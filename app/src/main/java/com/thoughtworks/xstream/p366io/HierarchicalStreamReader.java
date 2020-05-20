package com.thoughtworks.xstream.p366io;

import com.thoughtworks.xstream.converters.ErrorReporter;
import com.thoughtworks.xstream.converters.ErrorWriter;
import java.util.Iterator;

/* renamed from: com.thoughtworks.xstream.io.HierarchicalStreamReader */
/* loaded from: classes2.dex */
public interface HierarchicalStreamReader extends ErrorReporter {
    @Override // com.thoughtworks.xstream.converters.ErrorReporter
    void appendErrors(ErrorWriter errorWriter);

    void close();

    String getAttribute(int i);

    String getAttribute(String str);

    int getAttributeCount();

    String getAttributeName(int i);

    Iterator getAttributeNames();

    String getNodeName();

    String getValue();

    boolean hasMoreChildren();

    void moveDown();

    void moveUp();

    HierarchicalStreamReader underlyingReader();
}
