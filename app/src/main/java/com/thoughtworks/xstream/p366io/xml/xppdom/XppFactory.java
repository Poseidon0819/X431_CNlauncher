package com.thoughtworks.xstream.p366io.xml.xppdom;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;
import org.xmlpull.p398v1.XmlPullParserFactory;

/* renamed from: com.thoughtworks.xstream.io.xml.xppdom.XppFactory */
/* loaded from: classes2.dex */
public class XppFactory {
    public static XmlPullParser createDefaultParser() throws XmlPullParserException {
        return XmlPullParserFactory.newInstance().newPullParser();
    }

    public static XppDom buildDom(String str) throws XmlPullParserException, IOException {
        return buildDom(new StringReader(str));
    }

    public static XppDom buildDom(Reader reader) throws XmlPullParserException, IOException {
        XmlPullParser createDefaultParser = createDefaultParser();
        createDefaultParser.setInput(reader);
        return XppDom.build(createDefaultParser);
    }

    public static XppDom buildDom(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        XmlPullParser createDefaultParser = createDefaultParser();
        createDefaultParser.setInput(inputStream, str);
        return XppDom.build(createDefaultParser);
    }
}
