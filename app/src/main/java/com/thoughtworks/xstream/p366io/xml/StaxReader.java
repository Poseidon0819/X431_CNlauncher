package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/* renamed from: com.thoughtworks.xstream.io.xml.StaxReader */
/* loaded from: classes2.dex */
public class StaxReader extends AbstractPullReader {

    /* renamed from: in */
    private final XMLStreamReader f21378in;
    private final QNameMap qnameMap;

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader) {
        this(qNameMap, xMLStreamReader, new XmlFriendlyNameCoder());
    }

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader, NameCoder nameCoder) {
        super(nameCoder);
        this.qnameMap = qNameMap;
        this.f21378in = xMLStreamReader;
        moveDown();
    }

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(qNameMap, xMLStreamReader, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected int pullNextEvent() {
        try {
            switch (this.f21378in.next()) {
                case 1:
                case 7:
                    return 1;
                case 2:
                case 8:
                    return 2;
                case 3:
                case 6:
                default:
                    return 0;
                case 4:
                    return 3;
                case 5:
                    return 4;
            }
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected String pullElementName() {
        return this.qnameMap.getJavaClassName(this.f21378in.getName());
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected String pullText() {
        return this.f21378in.getText();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(String str) {
        return this.f21378in.getAttributeValue((String) null, encodeAttribute(str));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(int i) {
        return this.f21378in.getAttributeValue(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public int getAttributeCount() {
        return this.f21378in.getAttributeCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttributeName(int i) {
        return decodeAttribute(this.f21378in.getAttributeLocalName(i));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("line number", String.valueOf(this.f21378in.getLocation().getLineNumber()));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void close() {
        try {
            this.f21378in.close();
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }
}
