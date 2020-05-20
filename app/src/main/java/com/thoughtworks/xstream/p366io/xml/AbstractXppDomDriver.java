package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.XmlHeaderAwareReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import com.thoughtworks.xstream.p366io.xml.xppdom.XppDom;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.thoughtworks.xstream.io.xml.AbstractXppDomDriver */
/* loaded from: classes2.dex */
public abstract class AbstractXppDomDriver extends AbstractXmlDriver {
    protected abstract XmlPullParser createParser() throws XmlPullParserException;

    public AbstractXppDomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            XmlPullParser createParser = createParser();
            createParser.setInput(reader);
            return new XppDomReader(XppDom.build(createParser), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (XmlPullParserException e2) {
            throw new StreamException(e2);
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
