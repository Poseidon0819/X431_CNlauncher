package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* renamed from: com.thoughtworks.xstream.io.xml.DomWriter */
/* loaded from: classes2.dex */
public class DomWriter extends AbstractDocumentWriter {
    private final Document document;
    private boolean hasRootElement;

    public DomWriter(Document document) {
        this(document, new XmlFriendlyNameCoder());
    }

    public DomWriter(Element element) {
        this(element, new XmlFriendlyNameCoder());
    }

    public DomWriter(Document document, NameCoder nameCoder) {
        this(document.getDocumentElement(), document, nameCoder);
    }

    public DomWriter(Element element, Document document, NameCoder nameCoder) {
        super(element, nameCoder);
        this.document = document;
        this.hasRootElement = document.getDocumentElement() != null;
    }

    public DomWriter(Element element, NameCoder nameCoder) {
        this(element, element.getOwnerDocument(), nameCoder);
    }

    public DomWriter(Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document.getDocumentElement(), document, (NameCoder) xmlFriendlyReplacer);
    }

    public DomWriter(Element element, Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, document, (NameCoder) xmlFriendlyReplacer);
    }

    public DomWriter(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, element.getOwnerDocument(), (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentWriter
    protected Object createNode(String str) {
        Element createElement = this.document.createElement(encodeNode(str));
        if (top() != null) {
            top().appendChild(createElement);
        } else if (!this.hasRootElement) {
            this.document.appendChild(createElement);
            this.hasRootElement = true;
        }
        return createElement;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        top().setAttribute(encodeAttribute(str), str2);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        top().appendChild(this.document.createTextNode(str));
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
