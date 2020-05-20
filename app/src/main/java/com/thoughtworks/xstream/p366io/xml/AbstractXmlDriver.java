package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.AbstractDriver;
import com.thoughtworks.xstream.p366io.naming.NameCoder;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractXmlDriver */
/* loaded from: classes2.dex */
public abstract class AbstractXmlDriver extends AbstractDriver {
    public AbstractXmlDriver() {
        this(new XmlFriendlyNameCoder());
    }

    public AbstractXmlDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public AbstractXmlDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    protected XmlFriendlyReplacer xmlFriendlyReplacer() {
        NameCoder nameCoder = getNameCoder();
        if (nameCoder instanceof XmlFriendlyReplacer) {
            return (XmlFriendlyReplacer) nameCoder;
        }
        return null;
    }
}
