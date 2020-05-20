package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import nu.xom.Attribute;
import nu.xom.Element;

/* renamed from: com.thoughtworks.xstream.io.xml.XomWriter */
/* loaded from: classes2.dex */
public class XomWriter extends AbstractDocumentWriter {
    public XomWriter() {
        this(null);
    }

    public XomWriter(Element element) {
        this(element, new XmlFriendlyNameCoder());
    }

    public XomWriter(Element element, NameCoder nameCoder) {
        super(element, nameCoder);
    }

    public XomWriter(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentWriter
    protected Object createNode(String str) {
        Element element = new Element(encodeNode(str));
        if (top() != null) {
            top().appendChild(element);
        }
        return element;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        top().addAttribute(new Attribute(encodeAttribute(str), str2));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        top().appendChild(str);
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
