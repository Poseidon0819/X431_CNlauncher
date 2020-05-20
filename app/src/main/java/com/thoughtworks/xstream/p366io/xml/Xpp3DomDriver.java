package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.xmlpull.mxp1.MXParser;
import org.xmlpull.p398v1.XmlPullParser;

/* renamed from: com.thoughtworks.xstream.io.xml.Xpp3DomDriver */
/* loaded from: classes2.dex */
public class Xpp3DomDriver extends AbstractXppDomDriver {
    public Xpp3DomDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public Xpp3DomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractXppDomDriver
    protected XmlPullParser createParser() {
        return new MXParser();
    }
}
