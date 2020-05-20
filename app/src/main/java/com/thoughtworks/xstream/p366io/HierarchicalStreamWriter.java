package com.thoughtworks.xstream.p366io;

/* renamed from: com.thoughtworks.xstream.io.HierarchicalStreamWriter */
/* loaded from: classes2.dex */
public interface HierarchicalStreamWriter {
    void addAttribute(String str, String str2);

    void close();

    void endNode();

    void flush();

    void setValue(String str);

    void startNode(String str);

    HierarchicalStreamWriter underlyingWriter();
}
