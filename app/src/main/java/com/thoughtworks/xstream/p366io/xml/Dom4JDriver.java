package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.File;
import java.io.FilterWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/* renamed from: com.thoughtworks.xstream.io.xml.Dom4JDriver */
/* loaded from: classes2.dex */
public class Dom4JDriver extends AbstractXmlDriver {
    private DocumentFactory documentFactory;
    private OutputFormat outputFormat;

    public Dom4JDriver() {
        this(new XmlFriendlyNameCoder());
    }

    public Dom4JDriver(NameCoder nameCoder) {
        this(new DocumentFactory(), OutputFormat.createPrettyPrint(), nameCoder);
        this.outputFormat.setTrimText(false);
    }

    public Dom4JDriver(DocumentFactory documentFactory, OutputFormat outputFormat) {
        this(documentFactory, outputFormat, new XmlFriendlyNameCoder());
    }

    public Dom4JDriver(DocumentFactory documentFactory, OutputFormat outputFormat, NameCoder nameCoder) {
        super(nameCoder);
        this.documentFactory = documentFactory;
        this.outputFormat = outputFormat;
    }

    public Dom4JDriver(DocumentFactory documentFactory, OutputFormat outputFormat, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(documentFactory, outputFormat, (NameCoder) xmlFriendlyReplacer);
    }

    public DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    public OutputFormat getOutputFormat() {
        return this.outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new Dom4JReader(new SAXReader().read(reader), getNameCoder());
        } catch (DocumentException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new Dom4JReader(new SAXReader().read(inputStream), getNameCoder());
        } catch (DocumentException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new Dom4JReader(new SAXReader().read(url), getNameCoder());
        } catch (DocumentException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        try {
            return new Dom4JReader(new SAXReader().read(file), getNameCoder());
        } catch (DocumentException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        final HierarchicalStreamWriter[] hierarchicalStreamWriterArr = {new Dom4JXmlWriter(new XMLWriter(new FilterWriter(writer) { // from class: com.thoughtworks.xstream.io.xml.Dom4JDriver.1
            @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                hierarchicalStreamWriterArr[0].close();
            }
        }, this.outputFormat), getNameCoder())};
        return hierarchicalStreamWriterArr[0];
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return createWriter(new OutputStreamWriter(outputStream));
    }
}
