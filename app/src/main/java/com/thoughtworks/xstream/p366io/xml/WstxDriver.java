package com.thoughtworks.xstream.p366io.xml;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.WstxDriver */
/* loaded from: classes2.dex */
public class WstxDriver extends StaxDriver {
    public WstxDriver() {
    }

    public WstxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, xmlFriendlyNameCoder);
    }

    public WstxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public WstxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(xmlFriendlyNameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLInputFactory createInputFactory() {
        return new WstxInputFactory();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLOutputFactory createOutputFactory() {
        return new WstxOutputFactory();
    }
}
