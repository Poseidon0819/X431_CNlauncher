package com.thoughtworks.xstream.p366io;

/* renamed from: com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper */
/* loaded from: classes2.dex */
public class ExtendedHierarchicalStreamWriterHelper {
    public static void startNode(HierarchicalStreamWriter hierarchicalStreamWriter, String str, Class cls) {
        if (hierarchicalStreamWriter instanceof ExtendedHierarchicalStreamWriter) {
            ((ExtendedHierarchicalStreamWriter) hierarchicalStreamWriter).startNode(str, cls);
        } else {
            hierarchicalStreamWriter.startNode(str);
        }
    }
}
