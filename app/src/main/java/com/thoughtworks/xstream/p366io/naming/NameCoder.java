package com.thoughtworks.xstream.p366io.naming;

/* renamed from: com.thoughtworks.xstream.io.naming.NameCoder */
/* loaded from: classes2.dex */
public interface NameCoder {
    String decodeAttribute(String str);

    String decodeNode(String str);

    String encodeAttribute(String str);

    String encodeNode(String str);
}
