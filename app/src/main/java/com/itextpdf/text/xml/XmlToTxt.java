package com.itextpdf.text.xml;

import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* loaded from: classes.dex */
public class XmlToTxt implements SimpleXMLDocHandler {
    protected StringBuffer buf = new StringBuffer();

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
    }

    public static String parse(InputStream inputStream) throws IOException {
        XmlToTxt xmlToTxt = new XmlToTxt();
        SimpleXMLParser.parse(xmlToTxt, null, new InputStreamReader(inputStream), true);
        return xmlToTxt.toString();
    }

    protected XmlToTxt() {
    }

    public String toString() {
        return this.buf.toString();
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        this.buf.append(str);
    }
}
