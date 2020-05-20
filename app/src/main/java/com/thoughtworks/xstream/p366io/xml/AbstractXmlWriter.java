package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.AbstractWriter;
import com.thoughtworks.xstream.p366io.naming.NameCoder;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractXmlWriter */
/* loaded from: classes2.dex */
public abstract class AbstractXmlWriter extends AbstractWriter implements XmlFriendlyWriter {
    protected AbstractXmlWriter() {
        this(new XmlFriendlyNameCoder());
    }

    protected AbstractXmlWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractXmlWriter(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.xml.XmlFriendlyWriter
    public String escapeXmlName(String str) {
        return super.encodeNode(str);
    }
}
