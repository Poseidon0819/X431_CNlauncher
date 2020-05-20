package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.Writer;

/* renamed from: com.thoughtworks.xstream.io.xml.CompactWriter */
/* loaded from: classes2.dex */
public class CompactWriter extends PrettyPrintWriter {
    @Override // com.thoughtworks.xstream.p366io.xml.PrettyPrintWriter
    protected void endOfLine() {
    }

    public CompactWriter(Writer writer) {
        super(writer);
    }

    public CompactWriter(Writer writer, int i) {
        super(writer, i);
    }

    public CompactWriter(Writer writer, NameCoder nameCoder) {
        super(writer, nameCoder);
    }

    public CompactWriter(Writer writer, int i, NameCoder nameCoder) {
        super(writer, i, nameCoder);
    }

    public CompactWriter(Writer writer, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(writer, xmlFriendlyReplacer);
    }

    public CompactWriter(Writer writer, int i, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(writer, i, xmlFriendlyReplacer);
    }
}
