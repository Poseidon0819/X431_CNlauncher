package com.thoughtworks.xstream.p366io.json;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.xml.QNameMap;
import com.thoughtworks.xstream.p366io.xml.StaxWriter;
import com.thoughtworks.xstream.p366io.xml.XmlFriendlyReplacer;
import java.util.Collection;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.jettison.AbstractXMLStreamWriter;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;

/* renamed from: com.thoughtworks.xstream.io.json.JettisonStaxWriter */
/* loaded from: classes2.dex */
public class JettisonStaxWriter extends StaxWriter {
    private final MappedNamespaceConvention convention;

    public JettisonStaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, NameCoder nameCoder, MappedNamespaceConvention mappedNamespaceConvention) throws XMLStreamException {
        super(qNameMap, xMLStreamWriter, z, z2, nameCoder);
        this.convention = mappedNamespaceConvention;
    }

    public JettisonStaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, XmlFriendlyReplacer xmlFriendlyReplacer, MappedNamespaceConvention mappedNamespaceConvention) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, z, z2, (NameCoder) xmlFriendlyReplacer, mappedNamespaceConvention);
    }

    public JettisonStaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, MappedNamespaceConvention mappedNamespaceConvention) throws XMLStreamException {
        super(qNameMap, xMLStreamWriter, z, z2);
        this.convention = mappedNamespaceConvention;
    }

    public JettisonStaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, MappedNamespaceConvention mappedNamespaceConvention) throws XMLStreamException {
        super(qNameMap, xMLStreamWriter);
        this.convention = mappedNamespaceConvention;
    }

    public JettisonStaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, NameCoder nameCoder, MappedNamespaceConvention mappedNamespaceConvention) throws XMLStreamException {
        super(qNameMap, xMLStreamWriter, nameCoder);
        this.convention = mappedNamespaceConvention;
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractWriter, com.thoughtworks.xstream.p366io.ExtendedHierarchicalStreamWriter
    public void startNode(String str, Class cls) {
        AbstractXMLStreamWriter xMLStreamWriter = getXMLStreamWriter();
        if (cls != null && (xMLStreamWriter instanceof AbstractXMLStreamWriter) && (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls) || cls.isArray())) {
            QName qName = getQNameMap().getQName(encodeNode(str));
            String createKey = this.convention.createKey(qName.getPrefix(), qName.getNamespaceURI(), qName.getLocalPart());
            AbstractXMLStreamWriter abstractXMLStreamWriter = xMLStreamWriter;
            if (!abstractXMLStreamWriter.getSerializedAsArrays().contains(createKey)) {
                abstractXMLStreamWriter.seriliazeAsArray(createKey);
            }
        }
        startNode(str);
    }
}
