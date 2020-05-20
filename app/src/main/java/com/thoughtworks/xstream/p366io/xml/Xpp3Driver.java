package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import org.xmlpull.mxp1.MXParser;
import org.xmlpull.p398v1.XmlPullParser;

/* renamed from: com.thoughtworks.xstream.io.xml.Xpp3Driver */
/* loaded from: classes2.dex */
public class Xpp3Driver extends AbstractXppDriver {
    public Xpp3Driver() {
        super(new XmlFriendlyNameCoder());
    }

    public Xpp3Driver(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractXppDriver
    protected XmlPullParser createParser() {
        return new MXParser();
    }
}
