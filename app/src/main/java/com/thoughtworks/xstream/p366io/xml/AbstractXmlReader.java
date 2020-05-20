package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.AbstractReader;
import com.thoughtworks.xstream.p366io.naming.NameCoder;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractXmlReader */
/* loaded from: classes2.dex */
public abstract class AbstractXmlReader extends AbstractReader {
    protected AbstractXmlReader() {
        this(new XmlFriendlyNameCoder());
    }

    protected AbstractXmlReader(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractXmlReader(NameCoder nameCoder) {
        super(nameCoder);
    }

    public String unescapeXmlName(String str) {
        return decodeNode(str);
    }

    protected String escapeXmlName(String str) {
        return encodeNode(str);
    }
}
