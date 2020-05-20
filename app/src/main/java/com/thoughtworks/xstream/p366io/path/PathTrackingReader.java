package com.thoughtworks.xstream.p366io.path;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.ReaderWrapper;

/* renamed from: com.thoughtworks.xstream.io.path.PathTrackingReader */
/* loaded from: classes2.dex */
public class PathTrackingReader extends ReaderWrapper {
    private final PathTracker pathTracker;

    public PathTrackingReader(HierarchicalStreamReader hierarchicalStreamReader, PathTracker pathTracker) {
        super(hierarchicalStreamReader);
        this.pathTracker = pathTracker;
        pathTracker.pushElement(getNodeName());
    }

    @Override // com.thoughtworks.xstream.p366io.ReaderWrapper, com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveDown() {
        super.moveDown();
        this.pathTracker.pushElement(getNodeName());
    }

    @Override // com.thoughtworks.xstream.p366io.ReaderWrapper, com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveUp() {
        super.moveUp();
        this.pathTracker.popElement();
    }

    @Override // com.thoughtworks.xstream.p366io.ReaderWrapper, com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("path", this.pathTracker.getPath().toString());
        super.appendErrors(errorWriter);
    }
}
