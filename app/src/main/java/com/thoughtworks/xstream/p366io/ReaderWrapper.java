package com.thoughtworks.xstream.p366io;

import com.thoughtworks.xstream.converters.ErrorWriter;
import java.util.Iterator;

/* renamed from: com.thoughtworks.xstream.io.ReaderWrapper */
/* loaded from: classes2.dex */
public abstract class ReaderWrapper implements ExtendedHierarchicalStreamReader {
    protected HierarchicalStreamReader wrapped;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReaderWrapper(HierarchicalStreamReader hierarchicalStreamReader) {
        this.wrapped = hierarchicalStreamReader;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public boolean hasMoreChildren() {
        return this.wrapped.hasMoreChildren();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveDown() {
        this.wrapped.moveDown();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveUp() {
        this.wrapped.moveUp();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getNodeName() {
        return this.wrapped.getNodeName();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getValue() {
        return this.wrapped.getValue();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(String str) {
        return this.wrapped.getAttribute(str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(int i) {
        return this.wrapped.getAttribute(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public int getAttributeCount() {
        return this.wrapped.getAttributeCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttributeName(int i) {
        return this.wrapped.getAttributeName(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public Iterator getAttributeNames() {
        return this.wrapped.getAttributeNames();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        this.wrapped.appendErrors(errorWriter);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void close() {
        this.wrapped.close();
    }

    @Override // com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader
    public String peekNextChild() {
        HierarchicalStreamReader hierarchicalStreamReader = this.wrapped;
        if (!(hierarchicalStreamReader instanceof ExtendedHierarchicalStreamReader)) {
            throw new UnsupportedOperationException("peekNextChild");
        }
        return ((ExtendedHierarchicalStreamReader) hierarchicalStreamReader).peekNextChild();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public HierarchicalStreamReader underlyingReader() {
        return this.wrapped.underlyingReader();
    }
}
