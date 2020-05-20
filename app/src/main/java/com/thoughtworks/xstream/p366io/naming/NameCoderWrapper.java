package com.thoughtworks.xstream.p366io.naming;

/* renamed from: com.thoughtworks.xstream.io.naming.NameCoderWrapper */
/* loaded from: classes2.dex */
public class NameCoderWrapper implements NameCoder {
    private final NameCoder wrapped;

    public NameCoderWrapper(NameCoder nameCoder) {
        this.wrapped = nameCoder;
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeAttribute(String str) {
        return this.wrapped.decodeAttribute(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeNode(String str) {
        return this.wrapped.decodeNode(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeAttribute(String str) {
        return this.wrapped.encodeAttribute(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeNode(String str) {
        return this.wrapped.encodeNode(str);
    }
}
