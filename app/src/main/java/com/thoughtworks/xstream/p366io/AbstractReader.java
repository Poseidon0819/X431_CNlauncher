package com.thoughtworks.xstream.p366io;

import com.thoughtworks.xstream.core.util.Cloneables;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.naming.NoNameCoder;

/* renamed from: com.thoughtworks.xstream.io.AbstractReader */
/* loaded from: classes2.dex */
public abstract class AbstractReader implements ExtendedHierarchicalStreamReader {
    private NameCoder nameCoder;

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public HierarchicalStreamReader underlyingReader() {
        return this;
    }

    protected AbstractReader() {
        this(new NoNameCoder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractReader(NameCoder nameCoder) {
        this.nameCoder = (NameCoder) Cloneables.cloneIfPossible(nameCoder);
    }

    public String decodeNode(String str) {
        return this.nameCoder.decodeNode(str);
    }

    public String decodeAttribute(String str) {
        return this.nameCoder.decodeAttribute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String encodeNode(String str) {
        return this.nameCoder.encodeNode(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String encodeAttribute(String str) {
        return this.nameCoder.encodeAttribute(str);
    }

    @Override // com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader
    public String peekNextChild() {
        throw new UnsupportedOperationException("peekNextChild");
    }
}
