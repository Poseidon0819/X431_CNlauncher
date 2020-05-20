package com.thoughtworks.xstream.p366io.xml;

/* renamed from: com.thoughtworks.xstream.io.xml.XStream11XmlFriendlyReplacer */
/* loaded from: classes2.dex */
public class XStream11XmlFriendlyReplacer extends XmlFriendlyReplacer {
    @Override // com.thoughtworks.xstream.p366io.xml.XmlFriendlyNameCoder, com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeAttribute(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.p366io.xml.XmlFriendlyNameCoder, com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeNode(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.p366io.xml.XmlFriendlyReplacer
    public String unescapeName(String str) {
        return str;
    }
}
