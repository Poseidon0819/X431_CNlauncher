package com.thoughtworks.xstream.p366io.path;

import com.thoughtworks.xstream.p366io.AbstractWriter;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.WriterWrapper;

/* renamed from: com.thoughtworks.xstream.io.path.PathTrackingWriter */
/* loaded from: classes2.dex */
public class PathTrackingWriter extends WriterWrapper {
    private final boolean isNameEncoding;
    private final PathTracker pathTracker;

    public PathTrackingWriter(HierarchicalStreamWriter hierarchicalStreamWriter, PathTracker pathTracker) {
        super(hierarchicalStreamWriter);
        this.isNameEncoding = hierarchicalStreamWriter.underlyingWriter() instanceof AbstractWriter;
        this.pathTracker = pathTracker;
    }

    @Override // com.thoughtworks.xstream.p366io.WriterWrapper, com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        this.pathTracker.pushElement(this.isNameEncoding ? ((AbstractWriter) this.wrapped.underlyingWriter()).encodeNode(str) : str);
        super.startNode(str);
    }

    @Override // com.thoughtworks.xstream.p366io.WriterWrapper, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        this.pathTracker.pushElement(this.isNameEncoding ? ((AbstractWriter) this.wrapped.underlyingWriter()).encodeNode(str) : str);
        super.startNode(str, cls);
    }

    @Override // com.thoughtworks.xstream.p366io.WriterWrapper, com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        super.endNode();
        this.pathTracker.popElement();
    }
}
