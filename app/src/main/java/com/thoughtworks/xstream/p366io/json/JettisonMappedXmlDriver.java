package com.thoughtworks.xstream.p366io.json;

import com.thoughtworks.xstream.p366io.AbstractDriver;
import com.thoughtworks.xstream.p366io.HierarchicalStreamReader;
import com.thoughtworks.xstream.p366io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.xml.QNameMap;
import com.thoughtworks.xstream.p366io.xml.StaxReader;
import com.thoughtworks.xstream.p366io.xml.StaxWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import javax.xml.stream.XMLStreamException;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLInputFactory;
import org.codehaus.jettison.mapped.MappedXMLOutputFactory;

/* renamed from: com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver */
/* loaded from: classes2.dex */
public class JettisonMappedXmlDriver extends AbstractDriver {
    protected final MappedNamespaceConvention convention;
    protected final MappedXMLInputFactory mif;
    protected final MappedXMLOutputFactory mof;
    protected final boolean useSerializeAsArray;

    public JettisonMappedXmlDriver() {
        this(new Configuration());
    }

    public JettisonMappedXmlDriver(Configuration configuration) {
        this(configuration, true);
    }

    public JettisonMappedXmlDriver(Configuration configuration, boolean z) {
        this.mof = new MappedXMLOutputFactory(configuration);
        this.mif = new MappedXMLInputFactory(configuration);
        this.convention = new MappedNamespaceConvention(configuration);
        this.useSerializeAsArray = z;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(reader), getNameCoder());
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(inputStream), getNameCoder());
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(URL url) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = url.openStream();
                StaxReader staxReader = new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(url.toExternalForm(), inputStream), getNameCoder());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return staxReader;
            } catch (XMLStreamException e) {
                throw new StreamException((Throwable) e);
            } catch (IOException e2) {
                throw new StreamException(e2);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.thoughtworks.xstream.p366io.AbstractDriver, com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamReader createReader(File file) {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    StaxReader staxReader = new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(file.toURI().toASCIIString(), fileInputStream), getNameCoder());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return staxReader;
                } catch (XMLStreamException e) {
                    e = e;
                    throw new StreamException((Throwable) e);
                } catch (IOException e2) {
                    e = e2;
                    throw new StreamException(e);
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (XMLStreamException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(Writer writer) {
        try {
            if (this.useSerializeAsArray) {
                return new JettisonStaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(writer), getNameCoder(), this.convention);
            }
            return new StaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(writer), getNameCoder());
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamDriver
    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        try {
            if (this.useSerializeAsArray) {
                return new JettisonStaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(outputStream), getNameCoder(), this.convention);
            }
            return new StaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(outputStream), getNameCoder());
        } catch (XMLStreamException e) {
            throw new StreamException((Throwable) e);
        }
    }
}
