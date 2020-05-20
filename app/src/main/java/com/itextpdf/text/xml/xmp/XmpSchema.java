package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.Enumeration;
import java.util.Properties;

/* loaded from: classes.dex */
public abstract class XmpSchema extends Properties {
    private static final long serialVersionUID = -176374295948945272L;
    protected String xmlns;

    public XmpSchema(String str) {
        this.xmlns = str;
    }

    @Override // java.util.Hashtable
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            process(stringBuffer, propertyNames.nextElement());
        }
        return stringBuffer.toString();
    }

    protected void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append('<');
        stringBuffer.append(obj);
        stringBuffer.append('>');
        stringBuffer.append(get(obj));
        stringBuffer.append("</");
        stringBuffer.append(obj);
        stringBuffer.append('>');
    }

    public String getXmlns() {
        return this.xmlns;
    }

    public Object addProperty(String str, String str2) {
        return setProperty(str, str2);
    }

    @Override // java.util.Properties
    public Object setProperty(String str, String str2) {
        return super.setProperty(str, XMLUtil.escapeXML(str2, false));
    }

    public Object setProperty(String str, XmpArray xmpArray) {
        return super.setProperty(str, xmpArray.toString());
    }

    public Object setProperty(String str, LangAlt langAlt) {
        return super.setProperty(str, langAlt.toString());
    }

    public static String escape(String str) {
        return XMLUtil.escapeXML(str, false);
    }
}
