package com.thoughtworks.xstream.p366io;

/* renamed from: com.thoughtworks.xstream.io.WriterWrapper */
/* loaded from: classes2.dex */
public abstract class WriterWrapper implements ExtendedHierarchicalStreamWriter {
    protected HierarchicalStreamWriter wrapped;

    /* JADX INFO: Access modifiers changed from: protected */
    public WriterWrapper(HierarchicalStreamWriter hierarchicalStreamWriter) {
        this.wrapped = hierarchicalStreamWriter;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        this.wrapped.startNode(str);
    }

    @Override // com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        ((ExtendedHierarchicalStreamWriter) this.wrapped).startNode(str, cls);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        this.wrapped.endNode();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        this.wrapped.addAttribute(str, str2);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        this.wrapped.setValue(str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
        this.wrapped.flush();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
        this.wrapped.close();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public HierarchicalStreamWriter underlyingWriter() {
        return this.wrapped.underlyingWriter();
    }
}
