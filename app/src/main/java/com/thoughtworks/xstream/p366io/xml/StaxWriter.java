package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/* renamed from: com.thoughtworks.xstream.io.xml.StaxWriter */
/* loaded from: classes2.dex */
public class StaxWriter extends AbstractXmlWriter {
    private boolean namespaceRepairingMode;
    private final XMLStreamWriter out;
    private final QNameMap qnameMap;
    private int tagDepth;
    private final boolean writeEnclosingDocument;

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, true, true);
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, NameCoder nameCoder) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, true, true, nameCoder);
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, NameCoder nameCoder) throws XMLStreamException {
        super(nameCoder);
        this.qnameMap = qNameMap;
        this.out = xMLStreamWriter;
        this.writeEnclosingDocument = z;
        this.namespaceRepairingMode = z2;
        if (z) {
            xMLStreamWriter.writeStartDocument();
        }
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, z, z2, new XmlFriendlyNameCoder());
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, XmlFriendlyReplacer xmlFriendlyReplacer) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, z, z2, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
        try {
            this.out.flush();
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
        try {
            this.out.close();
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        try {
            this.out.writeAttribute(encodeAttribute(str), str2);
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        try {
            this.tagDepth--;
            this.out.writeEndElement();
            if (this.tagDepth == 0 && this.writeEnclosingDocument) {
                this.out.writeEndDocument();
            }
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        try {
            this.out.writeCharacters(str);
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        try {
            QName qName = this.qnameMap.getQName(encodeNode(str));
            String prefix = qName.getPrefix();
            String namespaceURI = qName.getNamespaceURI();
            boolean z = false;
            boolean z2 = prefix != null && prefix.length() > 0;
            boolean z3 = namespaceURI != null && namespaceURI.length() > 0;
            if (z3) {
                if (z2) {
                    String namespaceURI2 = this.out.getNamespaceContext().getNamespaceURI(prefix);
                    if (namespaceURI2 == null || !namespaceURI2.equals(namespaceURI)) {
                        z = true;
                    }
                } else {
                    String namespaceURI3 = this.out.getNamespaceContext().getNamespaceURI("");
                    if (namespaceURI3 == null || !namespaceURI3.equals(namespaceURI)) {
                        z = true;
                    }
                }
            }
            this.out.writeStartElement(prefix, qName.getLocalPart(), namespaceURI);
            if (z2) {
                this.out.setPrefix(prefix, namespaceURI);
            } else if (z3 && z) {
                this.out.setDefaultNamespace(namespaceURI);
            }
            if (z3 && z && !isNamespaceRepairingMode()) {
                if (z2) {
                    this.out.writeNamespace(prefix, namespaceURI);
                } else {
                    this.out.writeDefaultNamespace(namespaceURI);
                }
            }
            this.tagDepth++;
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    public boolean isNamespaceRepairingMode() {
        return this.namespaceRepairingMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QNameMap getQNameMap() {
        return this.qnameMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XMLStreamWriter getXMLStreamWriter() {
        return this.out;
    }
}
