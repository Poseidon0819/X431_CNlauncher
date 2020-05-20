package com.thoughtworks.xstream.p366io;

import com.thoughtworks.xstream.core.util.Cloneables;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.naming.NoNameCoder;

/* renamed from: com.thoughtworks.xstream.io.AbstractWriter */
/* loaded from: classes2.dex */
public abstract class AbstractWriter implements ExtendedHierarchicalStreamWriter {
    private NameCoder nameCoder;

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public HierarchicalStreamWriter underlyingWriter() {
        return this;
    }

    protected AbstractWriter() {
        this(new NoNameCoder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractWriter(NameCoder nameCoder) {
        this.nameCoder = (NameCoder) Cloneables.cloneIfPossible(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        startNode(str);
    }

    public String encodeNode(String str) {
        return this.nameCoder.encodeNode(str);
    }

    public String encodeAttribute(String str) {
        return this.nameCoder.encodeAttribute(str);
    }
}
