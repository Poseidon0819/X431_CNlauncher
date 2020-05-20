package com.thoughtworks.xstream.p366io.xml.xppdom;

import java.io.Reader;
import org.xmlpull.mxp1.MXParser;

/* renamed from: com.thoughtworks.xstream.io.xml.xppdom.Xpp3DomBuilder */
/* loaded from: classes2.dex */
public class Xpp3DomBuilder {
    public static Xpp3Dom build(Reader reader) throws Exception {
        MXParser mXParser = new MXParser();
        mXParser.setInput(reader);
        try {
            return (Xpp3Dom) XppDom.build(mXParser);
        } finally {
            reader.close();
        }
    }
}
