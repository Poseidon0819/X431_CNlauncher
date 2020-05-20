package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

/* renamed from: com.thoughtworks.xstream.io.xml.Dom4JReader */
/* loaded from: classes2.dex */
public class Dom4JReader extends AbstractDocumentReader {
    private Element currentElement;

    public Dom4JReader(Element element) {
        this(element, new XmlFriendlyNameCoder());
    }

    public Dom4JReader(Document document) {
        this(document.getRootElement());
    }

    public Dom4JReader(Element element, NameCoder nameCoder) {
        super(element, nameCoder);
    }

    public Dom4JReader(Document document, NameCoder nameCoder) {
        this(document.getRootElement(), nameCoder);
    }

    public Dom4JReader(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    public Dom4JReader(Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document.getRootElement(), (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getNodeName() {
        return decodeNode(this.currentElement.getName());
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getValue() {
        return this.currentElement.getText();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(String str) {
        return this.currentElement.attributeValue(encodeAttribute(str));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(int i) {
        return this.currentElement.attribute(i).getValue();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public int getAttributeCount() {
        return this.currentElement.attributeCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttributeName(int i) {
        return decodeAttribute(this.currentElement.attribute(i).getQualifiedName());
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentReader
    protected Object getParent() {
        return this.currentElement.getParent();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentReader
    protected Object getChild(int i) {
        return this.currentElement.elements().get(i);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentReader
    protected int getChildCount() {
        return this.currentElement.elements().size();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentReader
    protected void reassignCurrentElement(Object obj) {
        this.currentElement = (Element) obj;
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractReader, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamReader
    public String peekNextChild() {
        List elements = this.currentElement.elements();
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        return decodeNode(((Element) elements.get(0)).getName());
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractDocumentReader, com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("xpath", this.currentElement.getPath());
    }
}
