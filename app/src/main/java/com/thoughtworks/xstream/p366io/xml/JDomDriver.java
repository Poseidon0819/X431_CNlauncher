package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/* renamed from: com.thoughtworks.xstream.io.xml.JDomDriver */
/* loaded from: classes2.dex */
public class JDomDriver extends AbstractXmlDriver {
    public JDomDriver() {
        super(new XmlFriendlyNameCoder());
    }

    public JDomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public JDomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new JDomReader(new SAXBuilder().build(reader), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (JDOMException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new JDomReader(new SAXBuilder().build(inputStream), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (JDOMException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new JDomReader(new SAXBuilder().build(url), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (JDOMException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        try {
            return new JDomReader(new SAXBuilder().build(file), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (JDOMException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return new PrettyPrintWriter(new OutputStreamWriter(outputStream));
    }
}
