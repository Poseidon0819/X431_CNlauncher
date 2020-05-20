package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes.dex */
public class XfdfReader implements SimpleXMLDocHandler {
    private final Stack<String> fieldNames;
    private final Stack<String> fieldValues;
    HashMap<String, String> fields;
    String fileSpec;
    private boolean foundRoot;
    protected HashMap<String, List<String>> listFields;

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    public XfdfReader(String str) throws IOException {
        FileInputStream fileInputStream;
        this.foundRoot = false;
        this.fieldNames = new Stack<>();
        this.fieldValues = new Stack<>();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            SimpleXMLParser.parse(this, fileInputStream);
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public XfdfReader(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public XfdfReader(InputStream inputStream) throws IOException {
        this.foundRoot = false;
        this.fieldNames = new Stack<>();
        this.fieldValues = new Stack<>();
        SimpleXMLParser.parse(this, inputStream);
    }

    public HashMap<String, String> getFields() {
        return this.fields;
    }

    public String getField(String str) {
        return this.fields.get(str);
    }

    public String getFieldValue(String str) {
        String str2 = this.fields.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public List<String> getListValues(String str) {
        return this.listFields.get(str);
    }

    public String getFileSpec() {
        return this.fileSpec;
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (!this.foundRoot) {
            if (!str.equals("xfdf")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.xfdf.1", str));
            }
            this.foundRoot = true;
        }
        if (str.equals("xfdf")) {
            return;
        }
        if (str.equals("f")) {
            this.fileSpec = map.get(HtmlTags.HREF);
        } else if (str.equals("fields")) {
            this.fields = new HashMap<>();
            this.listFields = new HashMap<>();
        } else if (str.equals("field")) {
            this.fieldNames.push(map.get("name"));
        } else if (str.equals("value")) {
            this.fieldValues.push("");
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (str.equals("value")) {
            String str2 = "";
            for (int i = 0; i < this.fieldNames.size(); i++) {
                str2 = str2 + "." + this.fieldNames.elementAt(i);
            }
            if (str2.startsWith(".")) {
                str2 = str2.substring(1);
            }
            String pop = this.fieldValues.pop();
            String put = this.fields.put(str2, pop);
            if (put != null) {
                List<String> list = this.listFields.get(str2);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(put);
                }
                list.add(pop);
                this.listFields.put(str2, list);
            }
        } else if (str.equals("field") && !this.fieldNames.isEmpty()) {
            this.fieldNames.pop();
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
        this.fileSpec = "";
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        if (this.fieldNames.isEmpty() || this.fieldValues.isEmpty()) {
            return;
        }
        this.fieldValues.push(this.fieldValues.pop() + str);
    }
}
