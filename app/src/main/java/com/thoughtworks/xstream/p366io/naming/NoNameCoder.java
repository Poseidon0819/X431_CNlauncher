package com.thoughtworks.xstream.p366io.naming;

/* renamed from: com.thoughtworks.xstream.io.naming.NoNameCoder */
/* loaded from: classes2.dex */
public class NoNameCoder implements NameCoder {
    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeAttribute(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeNode(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeAttribute(String str) {
        return str;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeNode(String str) {
        return str;
    }
}
