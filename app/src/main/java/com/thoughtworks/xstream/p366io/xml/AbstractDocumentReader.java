package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.p366io.AttributeNameIterator;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.Iterator;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractDocumentReader */
/* loaded from: classes2.dex */
public abstract class AbstractDocumentReader extends AbstractXmlReader implements DocumentReader {
    private Object current;
    private FastStack pointers;

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void close() {
    }

    protected abstract Object getChild(int i);

    protected abstract int getChildCount();

    protected abstract Object getParent();

    protected abstract void reassignCurrentElement(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDocumentReader(Object obj) {
        this(obj, new XmlFriendlyNameCoder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDocumentReader(Object obj, NameCoder nameCoder) {
        super(nameCoder);
        this.pointers = new FastStack(16);
        this.current = obj;
        this.pointers.push(new Pointer());
        reassignCurrentElement(this.current);
    }

    protected AbstractDocumentReader(Object obj, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(obj, (NameCoder) xmlFriendlyReplacer);
    }

    /* renamed from: com.thoughtworks.xstream.io.xml.AbstractDocumentReader$Pointer */
    /* loaded from: classes2.dex */
    static class Pointer {

        /* renamed from: v */
        public int f21374v;

        private Pointer() {
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public boolean hasMoreChildren() {
        return ((Pointer) this.pointers.peek()).f21374v < getChildCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveUp() {
        this.current = getParent();
        this.pointers.popSilently();
        reassignCurrentElement(this.current);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void moveDown() {
        Pointer pointer = (Pointer) this.pointers.peek();
        this.pointers.push(new Pointer());
        this.current = getChild(pointer.f21374v);
        pointer.f21374v++;
        reassignCurrentElement(this.current);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public Iterator getAttributeNames() {
        return new AttributeNameIterator(this);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.DocumentReader
    public Object getCurrent() {
        return this.current;
    }
}
