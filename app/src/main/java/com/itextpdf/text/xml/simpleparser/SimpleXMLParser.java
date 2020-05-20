package com.itextpdf.text.xml.simpleparser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.handler.HTMLNewLineHandler;
import com.itextpdf.text.xml.simpleparser.handler.NeverNewLineHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

/* loaded from: classes.dex */
public final class SimpleXMLParser {
    private static final int ATTRIBUTE_EQUAL = 13;
    private static final int ATTRIBUTE_KEY = 12;
    private static final int ATTRIBUTE_VALUE = 14;
    private static final int CDATA = 7;
    private static final int COMMENT = 8;
    private static final int ENTITY = 10;
    private static final int EXAMIN_TAG = 3;
    private static final int IN_CLOSETAG = 5;

    /* renamed from: PI */
    private static final int f19874PI = 9;
    private static final int QUOTE = 11;
    private static final int SINGLE_TAG = 6;
    private static final int TAG_ENCOUNTERED = 2;
    private static final int TAG_EXAMINED = 4;
    private static final int TEXT = 1;
    private static final int UNKNOWN = 0;
    private final SimpleXMLDocHandlerComment comment;
    private final SimpleXMLDocHandler doc;
    private final boolean html;
    private NewLineHandler newLineHandler;
    private final Stack<Integer> stack;
    private int state;
    private int character = 0;
    private int previousCharacter = -1;
    private int lines = 1;
    private int columns = 0;
    private boolean eol = false;
    private boolean nowhite = false;
    private final StringBuffer text = new StringBuffer();
    private final StringBuffer entity = new StringBuffer();
    private String tag = null;
    private HashMap<String, String> attributes = null;
    private int nested = 0;
    private int quoteCharacter = 34;
    private String attributekey = null;
    private String attributevalue = null;

    private SimpleXMLParser(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z) {
        this.doc = simpleXMLDocHandler;
        this.comment = simpleXMLDocHandlerComment;
        this.html = z;
        if (z) {
            this.newLineHandler = new HTMLNewLineHandler();
        } else {
            this.newLineHandler = new NeverNewLineHandler();
        }
        this.stack = new Stack<>();
        this.state = z ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:366:0x0012, code lost:
        continue;
     */
    /* renamed from: go */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2707go(java.io.Reader r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.simpleparser.SimpleXMLParser.m2707go(java.io.Reader):void");
    }

    private int restoreState() {
        if (this.stack.empty()) {
            return 0;
        }
        return this.stack.pop().intValue();
    }

    private void saveState(int i) {
        this.stack.push(Integer.valueOf(i));
    }

    private void flush() {
        switch (this.state) {
            case 1:
            case 7:
                if (this.text.length() > 0) {
                    this.doc.text(this.text.toString());
                    break;
                }
                break;
            case 8:
                SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.comment;
                if (simpleXMLDocHandlerComment != null) {
                    simpleXMLDocHandlerComment.comment(this.text.toString());
                    break;
                }
                break;
            case 11:
            case 14:
                this.attributevalue = this.text.toString();
                this.attributes.put(this.attributekey, this.attributevalue);
                break;
            case 12:
                this.attributekey = this.text.toString();
                if (this.html) {
                    this.attributekey = this.attributekey.toLowerCase();
                    break;
                }
                break;
        }
        this.text.setLength(0);
    }

    private void initTag() {
        this.tag = null;
        this.attributes = new HashMap<>();
    }

    private void doTag() {
        if (this.tag == null) {
            this.tag = this.text.toString();
        }
        if (this.html) {
            this.tag = this.tag.toLowerCase();
        }
        this.text.setLength(0);
    }

    private void processTag(boolean z) {
        if (z) {
            this.nested++;
            this.doc.startElement(this.tag, this.attributes);
            return;
        }
        if (this.newLineHandler.isNewLineTag(this.tag)) {
            this.nowhite = false;
        }
        this.nested--;
        this.doc.endElement(this.tag);
    }

    private void throwException(String str) throws IOException {
        throw new IOException(MessageLocalization.getComposedMessage("1.near.line.2.column.3", str, String.valueOf(this.lines), String.valueOf(this.columns)));
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z) throws IOException {
        new SimpleXMLParser(simpleXMLDocHandler, simpleXMLDocHandlerComment, z).m2707go(reader);
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String declaredEncoding;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) != 4) {
            throw new IOException(MessageLocalization.getComposedMessage("insufficient.length", new Object[0]));
        }
        String encodingName = XMLUtil.getEncodingName(bArr);
        String str = null;
        if (encodingName.equals("UTF-8")) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int read = inputStream.read();
                if (read == -1 || read == 62) {
                    break;
                }
                stringBuffer.append((char) read);
            }
            str = stringBuffer.toString();
        } else if (encodingName.equals("CP037")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read2 = inputStream.read();
                if (read2 == -1 || read2 == 110) {
                    break;
                }
                byteArrayOutputStream.write(read2);
            }
            str = new String(byteArrayOutputStream.toByteArray(), "CP037");
        }
        if (str != null && (declaredEncoding = getDeclaredEncoding(str)) != null) {
            encodingName = declaredEncoding;
        }
        parse(simpleXMLDocHandler, new InputStreamReader(inputStream, IanaEncodings.getJavaEncoding(encodingName)));
    }

    private static String getDeclaredEncoding(String str) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i;
        int indexOf4;
        if (str == null || (indexOf = str.indexOf(HtmlTags.ENCODING)) < 0 || (indexOf2 = str.indexOf(34, indexOf)) == (indexOf3 = str.indexOf(39, indexOf))) {
            return null;
        }
        if ((indexOf2 < 0 && indexOf3 > 0) || (indexOf3 > 0 && indexOf3 < indexOf2)) {
            int i2 = indexOf3 + 1;
            int indexOf5 = str.indexOf(39, i2);
            if (indexOf5 < 0) {
                return null;
            }
            return str.substring(i2, indexOf5);
        } else if (((indexOf3 >= 0 || indexOf2 <= 0) && (indexOf2 <= 0 || indexOf2 >= indexOf3)) || (indexOf4 = str.indexOf(34, (i = indexOf2 + 1))) < 0) {
            return null;
        } else {
            return str.substring(i, indexOf4);
        }
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        parse(simpleXMLDocHandler, null, reader, false);
    }

    @Deprecated
    public static String escapeXML(String str, boolean z) {
        return XMLUtil.escapeXML(str, z);
    }
}
