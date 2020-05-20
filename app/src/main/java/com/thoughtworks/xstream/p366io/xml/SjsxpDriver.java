package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.StreamException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.SjsxpDriver */
/* loaded from: classes2.dex */
public class SjsxpDriver extends StaxDriver {
    public SjsxpDriver() {
    }

    public SjsxpDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, xmlFriendlyNameCoder);
    }

    public SjsxpDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public SjsxpDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(xmlFriendlyNameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLInputFactory createInputFactory() {
        try {
            return (XMLInputFactory) Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new StreamException("Cannot create SJSXP (Sun JDK 6 StAX) XMLInputFaqctory instance.", e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLOutputFactory createOutputFactory() {
        try {
            return (XMLOutputFactory) Class.forName("com.sun.xml.internal.stream.XMLOutputFactoryImpl").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new StreamException("Cannot create SJSXP (Sun JDK 6 StAX) XMLOutputFaqctory instance.", e);
        }
    }
}
