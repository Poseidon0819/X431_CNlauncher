package com.thoughtworks.xstream.p366io.xml;

/* renamed from: com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer */
/* loaded from: classes2.dex */
public class XmlFriendlyReplacer extends XmlFriendlyNameCoder {
    public XmlFriendlyReplacer() {
        this("_-", "__");
    }

    public XmlFriendlyReplacer(String str, String str2) {
        super(str, str2);
    }

    public String escapeName(String str) {
        return super.encodeNode(str);
    }

    public String unescapeName(String str) {
        return super.decodeNode(str);
    }
}
