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
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* renamed from: com.thoughtworks.xstream.io.xml.DomDriver */
/* loaded from: classes2.dex */
public class DomDriver extends AbstractXmlDriver {
    private final DocumentBuilderFactory documentBuilderFactory;
    private final String encoding;

    public DomDriver() {
        this(null);
    }

    public DomDriver(String str) {
        this(str, new XmlFriendlyNameCoder());
    }

    public DomDriver(String str, NameCoder nameCoder) {
        super(nameCoder);
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.encoding = str;
    }

    public DomDriver(String str, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(str, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        return createReader(new InputSource(reader));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        return createReader(new InputSource(inputStream));
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        return createReader(new InputSource(url.toExternalForm()));
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        return createReader(new InputSource(file.toURI().toASCIIString()));
    }

    private HierarchicalStreamReader createReader(InputSource inputSource) {
        try {
            DocumentBuilder newDocumentBuilder = this.documentBuilderFactory.newDocumentBuilder();
            if (this.encoding != null) {
                inputSource.setEncoding(this.encoding);
            }
            return new DomReader(newDocumentBuilder.parse(inputSource), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (FactoryConfigurationError e2) {
            throw new StreamException(e2);
        } catch (ParserConfigurationException e3) {
            throw new StreamException(e3);
        } catch (SAXException e4) {
            throw new StreamException(e4);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        try {
            return createWriter(this.encoding != null ? new OutputStreamWriter(outputStream, this.encoding) : new OutputStreamWriter(outputStream));
        } catch (UnsupportedEncodingException e) {
            throw new StreamException(e);
        }
    }
}
