package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.p393b.p394a.C4918a;
import org.xmlpull.p398v1.XmlPullParser;

/* renamed from: com.thoughtworks.xstream.io.xml.KXml2DomDriver */
/* loaded from: classes2.dex */
public class KXml2DomDriver extends AbstractXppDomDriver {
    public KXml2DomDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public KXml2DomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractXppDomDriver
    protected XmlPullParser createParser() {
        return new C4918a();
    }
}
