package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.jdom2.DefaultJDOMFactory;
import org.jdom2.Element;
import org.jdom2.JDOMFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.JDom2Writer */
/* loaded from: classes2.dex */
public class JDom2Writer extends AbstractDocumentWriter {
    private final JDOMFactory documentFactory;

    public JDom2Writer(Element element, JDOMFactory jDOMFactory, NameCoder nameCoder) {
        super(element, nameCoder);
        this.documentFactory = jDOMFactory;
    }

    public JDom2Writer(Element element, JDOMFactory jDOMFactory) {
        this(element, jDOMFactory, new XmlFriendlyNameCoder());
    }

    public JDom2Writer(JDOMFactory jDOMFactory, NameCoder nameCoder) {
        this(null, jDOMFactory, nameCoder);
    }

    public JDom2Writer(JDOMFactory jDOMFactory) {
        this((Element) null, jDOMFactory);
    }

    public JDom2Writer(Element element, NameCoder nameCoder) {
        this(element, new DefaultJDOMFactory(), nameCoder);
    }

    public JDom2Writer(Element element) {
        this(element, (JDOMFactory) new DefaultJDOMFactory());
    }

    public JDom2Writer() {
        this((JDOMFactory) new DefaultJDOMFactory());
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentWriter
    protected Object createNode(String str) {
        Element element = this.documentFactory.element(encodeNode(str));
        Element pVar = top();
        if (pVar != null) {
            pVar.addContent(element);
        }
        return element;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        top().addContent(this.documentFactory.text(str));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        top().setAttribute(this.documentFactory.attribute(encodeAttribute(str), str2));
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
