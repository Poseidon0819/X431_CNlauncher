package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.XmlHeaderAwareReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractXppDriver */
/* loaded from: classes2.dex */
public abstract class AbstractXppDriver extends AbstractXmlDriver {
    protected abstract XmlPullParser createParser() throws XmlPullParserException;

    public AbstractXppDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new XppReader(reader, createParser(), getNameCoder());
        } catch (XmlPullParserException unused) {
            throw new StreamException("Cannot create XmlPullParser");
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return createReader(new XmlHeaderAwareReader(inputStream));
        } catch (UnsupportedEncodingException e) {
            throw new StreamException(e);
        } catch (IOException e2) {
            throw new StreamException(e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return createWriter(new OutputStreamWriter(outputStream));
    }
}
