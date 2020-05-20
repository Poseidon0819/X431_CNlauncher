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
import nu.xom.Builder;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

/* renamed from: com.thoughtworks.xstream.io.xml.XomDriver */
/* loaded from: classes2.dex */
public class XomDriver extends AbstractXmlDriver {
    private final Builder builder;

    public XomDriver() {
        this(new Builder());
    }

    public XomDriver(Builder builder) {
        this(builder, new XmlFriendlyNameCoder());
    }

    public XomDriver(NameCoder nameCoder) {
        this(new Builder(), nameCoder);
    }

    public XomDriver(Builder builder, NameCoder nameCoder) {
        super(nameCoder);
        this.builder = builder;
    }

    public XomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(new Builder(), xmlFriendlyReplacer);
    }

    public XomDriver(Builder builder, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    protected Builder getBuilder() {
        return this.builder;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new XomReader(this.builder.build(reader), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new XomReader(this.builder.build(inputStream), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new XomReader(this.builder.build(url.toExternalForm()), getNameCoder());
        } catch (ParsingException e) {
            throw new StreamException((Throwable) e);
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException(e3);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        try {
            return new XomReader(this.builder.build(file), getNameCoder());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return new PrettyPrintWriter(new OutputStreamWriter(outputStream), getNameCoder());
    }
}
