package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;
import org.xmlpull.p398v1.XmlPullParserFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.XppDomDriver */
/* loaded from: classes2.dex */
public class XppDomDriver extends AbstractXppDomDriver {
    private static XmlPullParserFactory factory;

    public XppDomDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public XppDomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public XppDomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractXppDomDriver
    protected synchronized XmlPullParser createParser() throws XmlPullParserException {
        if (factory == null) {
            factory = XmlPullParserFactory.newInstance(null, XppDomDriver.class);
        }
        return factory.newPullParser();
    }
}
