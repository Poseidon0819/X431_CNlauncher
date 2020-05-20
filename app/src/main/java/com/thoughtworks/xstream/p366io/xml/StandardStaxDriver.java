package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.p366io.StreamException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.StandardStaxDriver */
/* loaded from: classes2.dex */
public class StandardStaxDriver extends StaxDriver {
    public StandardStaxDriver() {
    }

    public StandardStaxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, xmlFriendlyNameCoder);
    }

    public StandardStaxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public StandardStaxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(xmlFriendlyNameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLInputFactory createInputFactory() {
        try {
            Class staxInputFactory = JVM.getStaxInputFactory();
            if (staxInputFactory != null) {
                return (XMLInputFactory) staxInputFactory.newInstance();
            }
            throw new StreamException("Java runtime has no standard XMLInputFactory implementation.", null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new StreamException("Cannot create standard XMLInputFactory instance of Java runtime.", e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.xml.StaxDriver
    protected XMLOutputFactory createOutputFactory() {
        try {
            Class staxOutputFactory = JVM.getStaxOutputFactory();
            if (staxOutputFactory != null) {
                return (XMLOutputFactory) staxOutputFactory.newInstance();
            }
            throw new StreamException("Java runtime has no standard XMLOutputFactory implementation.", null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new StreamException("Cannot create standard XMLOutputFactory instance of Java runtime.", e);
        }
    }
}
