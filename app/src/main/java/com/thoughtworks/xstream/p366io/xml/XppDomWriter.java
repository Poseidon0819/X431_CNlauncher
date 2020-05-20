package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.xml.xppdom.XppDom;

/* renamed from: com.thoughtworks.xstream.io.xml.XppDomWriter */
/* loaded from: classes2.dex */
public class XppDomWriter extends AbstractDocumentWriter {
    public XppDomWriter() {
        this((XppDom) null, new XmlFriendlyNameCoder());
    }

    public XppDomWriter(XppDom xppDom) {
        this(xppDom, new XmlFriendlyNameCoder());
    }

    public XppDomWriter(NameCoder nameCoder) {
        this((XppDom) null, nameCoder);
    }

    public XppDomWriter(XppDom xppDom, NameCoder nameCoder) {
        super(xppDom, nameCoder);
    }

    public XppDomWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((XppDom) null, xmlFriendlyReplacer);
    }

    public XppDomWriter(XppDom xppDom, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(xppDom, (NameCoder) xmlFriendlyReplacer);
    }

    public XppDom getConfiguration() {
        return (XppDom) getTopLevelNodes().get(0);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentWriter
    protected Object createNode(String str) {
        XppDom xppDom = new XppDom(encodeNode(str));
        if (top() != null) {
            top().addChild(xppDom);
        }
        return xppDom;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        top().setValue(str);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        top().setAttribute(encodeAttribute(str), str2);
    }

    private XppDom top() {
        return (XppDom) getCurrent();
    }
}
