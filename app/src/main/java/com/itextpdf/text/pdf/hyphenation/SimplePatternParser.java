package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class SimplePatternParser implements PatternConsumer, SimpleXMLDocHandler {
    static final int ELEM_CLASSES = 1;
    static final int ELEM_EXCEPTIONS = 2;
    static final int ELEM_HYPHEN = 4;
    static final int ELEM_PATTERNS = 3;
    PatternConsumer consumer;
    int currElement;
    ArrayList<Object> exception;
    SimpleXMLParser parser;
    StringBuffer token = new StringBuffer();
    char hyphenChar = SignatureVisitor.SUPER;

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    public void parse(InputStream inputStream, PatternConsumer patternConsumer) {
        this.consumer = patternConsumer;
        try {
            try {
                SimpleXMLParser.parse(this, inputStream);
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    protected static String getPattern(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    protected ArrayList<Object> normalizeException(ArrayList<Object> arrayList) {
        ArrayList<Object> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                String str = (String) obj;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt != this.hyphenChar) {
                        stringBuffer.append(charAt);
                    } else {
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        arrayList2.add(new Hyphen(new String(new char[]{this.hyphenChar}), null, null));
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList2.add(stringBuffer.toString());
                }
            } else {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    protected String getExceptionWord(ArrayList<Object> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                stringBuffer.append((String) obj);
            } else {
                Hyphen hyphen = (Hyphen) obj;
                if (hyphen.noBreak != null) {
                    stringBuffer.append(hyphen.noBreak);
                }
            }
        }
        return stringBuffer.toString();
    }

    protected static String getInterletterValues(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + HtmlTags.f19618A;
        int length = str2.length();
        int i = 0;
        while (i < length) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt)) {
                stringBuffer.append(charAt);
                i++;
            } else {
                stringBuffer.append('0');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (this.token.length() > 0) {
            String stringBuffer = this.token.toString();
            switch (this.currElement) {
                case 1:
                    this.consumer.addClass(stringBuffer);
                    break;
                case 2:
                    this.exception.add(stringBuffer);
                    this.exception = normalizeException(this.exception);
                    this.consumer.addException(getExceptionWord(this.exception), (ArrayList) this.exception.clone());
                    break;
                case 3:
                    this.consumer.addPattern(getPattern(stringBuffer), getInterletterValues(stringBuffer));
                    break;
            }
            if (this.currElement != 4) {
                this.token.setLength(0);
            }
        }
        if (this.currElement == 4) {
            this.currElement = 2;
        } else {
            this.currElement = 0;
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (str.equals("hyphen-char")) {
            String str2 = map.get("value");
            if (str2 != null && str2.length() == 1) {
                this.hyphenChar = str2.charAt(0);
            }
        } else if (str.equals("classes")) {
            this.currElement = 1;
        } else if (str.equals("patterns")) {
            this.currElement = 3;
        } else if (str.equals("exceptions")) {
            this.currElement = 2;
            this.exception = new ArrayList<>();
        } else if (str.equals("hyphen")) {
            if (this.token.length() > 0) {
                this.exception.add(this.token.toString());
            }
            this.exception.add(new Hyphen(map.get(HtmlTags.PRE), map.get("no"), map.get("post")));
            this.currElement = 4;
        }
        this.token.setLength(0);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            switch (this.currElement) {
                case 1:
                    this.consumer.addClass(nextToken);
                    break;
                case 2:
                    this.exception.add(nextToken);
                    this.exception = normalizeException(this.exception);
                    this.consumer.addException(getExceptionWord(this.exception), (ArrayList) this.exception.clone());
                    this.exception.clear();
                    break;
                case 3:
                    this.consumer.addPattern(getPattern(nextToken), getInterletterValues(nextToken));
                    break;
            }
        }
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addClass(String str) {
        System.out.println("class: ".concat(String.valueOf(str)));
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addException(String str, ArrayList<Object> arrayList) {
        PrintStream printStream = System.out;
        printStream.println("exception: " + str + " : " + arrayList.toString());
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addPattern(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("pattern: " + str + " : " + str2);
    }
}
