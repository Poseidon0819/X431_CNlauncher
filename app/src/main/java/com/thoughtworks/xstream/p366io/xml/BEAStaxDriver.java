package com.thoughtworks.xstream.p366io.xml;

import com.bea.xml.stream.MXParserFactory;
import com.bea.xml.stream.XMLOutputFactoryBase;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.BEAStaxDriver */
/* loaded from: classes2.dex */
public class BEAStaxDriver extends StaxDriver {
    public BEAStaxDriver() {
    }

    public BEAStaxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, xmlFriendlyNameCoder);
    }

    public BEAStaxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public BEAStaxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(xmlFriendlyNameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLInputFactory createInputFactory() {
        return new MXParserFactory();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLOutputFactory createOutputFactory() {
        return new XMLOutputFactoryBase();
    }
}
