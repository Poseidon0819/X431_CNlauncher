package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;
import org.xmlpull.p398v1.XmlPullParserFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.XppDriver */
/* loaded from: classes2.dex */
public class XppDriver extends AbstractXppDriver {
    private static XmlPullParserFactory factory;

    public XppDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public XppDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public XppDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractXppDriver
    protected synchronized XmlPullParser createParser() throws XmlPullParserException {
        if (factory == null) {
            factory = XmlPullParserFactory.newInstance();
        }
        return factory.newPullParser();
    }
}
