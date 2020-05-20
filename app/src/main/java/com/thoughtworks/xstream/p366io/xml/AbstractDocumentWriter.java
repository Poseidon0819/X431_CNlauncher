package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractDocumentWriter */
/* loaded from: classes2.dex */
public abstract class AbstractDocumentWriter extends AbstractXmlWriter implements DocumentWriter {
    private final FastStack nodeStack;
    private final List result;

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
    }

    protected abstract Object createNode(String str);

    public void endNodeInternally() {
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
    }

    public AbstractDocumentWriter(Object obj, NameCoder nameCoder) {
        super(nameCoder);
        this.result = new ArrayList();
        this.nodeStack = new FastStack(16);
        if (obj != null) {
            this.nodeStack.push(obj);
            this.result.add(obj);
        }
    }

    public AbstractDocumentWriter(Object obj, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(obj, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void startNode(String str) {
        this.nodeStack.push(createNode(str));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void endNode() {
        endNodeInternally();
        Object pop = this.nodeStack.pop();
        if (this.nodeStack.size() == 0) {
            this.result.add(pop);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object getCurrent() {
        return this.nodeStack.peek();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.DocumentWriter
    public List getTopLevelNodes() {
        return this.result;
    }
}
