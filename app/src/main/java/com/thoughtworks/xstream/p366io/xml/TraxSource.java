package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/* renamed from: com.thoughtworks.xstream.io.xml.TraxSource */
/* loaded from: classes2.dex */
public class TraxSource extends SAXSource {
    public static final String XSTREAM_FEATURE = "http://com.thoughtworks.xstream/XStreamSource/feature";
    private List source;
    private XMLReader xmlReader;
    private XStream xstream;

    public TraxSource() {
        super(new InputSource());
        this.xmlReader = null;
        this.xstream = null;
        this.source = null;
    }

    public TraxSource(Object obj) {
        super(new InputSource());
        this.xmlReader = null;
        this.xstream = null;
        this.source = null;
        setSource(obj);
    }

    public TraxSource(Object obj, XStream xStream) {
        super(new InputSource());
        this.xmlReader = null;
        this.xstream = null;
        this.source = null;
        setSource(obj);
        setXStream(xStream);
    }

    public TraxSource(List list) {
        super(new InputSource());
        this.xmlReader = null;
        this.xstream = null;
        this.source = null;
        setSourceAsList(list);
    }

    public TraxSource(List list, XStream xStream) {
        super(new InputSource());
        this.xmlReader = null;
        this.xstream = null;
        this.source = null;
        setSourceAsList(list);
        setXStream(xStream);
    }

    @Override // javax.xml.transform.sax.SAXSource
    public void setInputSource(InputSource inputSource) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.transform.sax.SAXSource
    public void setXMLReader(XMLReader xMLReader) {
        createXMLReader(xMLReader);
    }

    @Override // javax.xml.transform.sax.SAXSource
    public XMLReader getXMLReader() {
        if (this.xmlReader == null) {
            createXMLReader(null);
        }
        return this.xmlReader;
    }

    public void setXStream(XStream xStream) {
        if (xStream == null) {
            throw new IllegalArgumentException("xstream");
        }
        this.xstream = xStream;
        configureXMLReader();
    }

    public void setSource(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj");
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        setSourceAsList(arrayList);
    }

    public void setSourceAsList(List list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list");
        }
        this.source = list;
        configureXMLReader();
    }

    private void createXMLReader(XMLReader xMLReader) {
        XMLFilter xMLFilter;
        if (xMLReader == null) {
            this.xmlReader = new SaxWriter();
        } else if (xMLReader instanceof XMLFilter) {
            XMLReader xMLReader2 = xMLReader;
            while (true) {
                xMLFilter = (XMLFilter) xMLReader2;
                if (!(xMLFilter.getParent() instanceof XMLFilter)) {
                    break;
                }
                xMLReader2 = xMLFilter.getParent();
            }
            if (!(xMLFilter.getParent() instanceof SaxWriter)) {
                xMLFilter.setParent(new SaxWriter());
            }
            this.xmlReader = xMLReader;
        } else {
            throw new UnsupportedOperationException();
        }
        configureXMLReader();
    }

    private void configureXMLReader() {
        XMLReader xMLReader = this.xmlReader;
        if (xMLReader != null) {
            try {
                if (this.xstream != null) {
                    xMLReader.setProperty(SaxWriter.CONFIGURED_XSTREAM_PROPERTY, this.xstream);
                }
                if (this.source != null) {
                    this.xmlReader.setProperty(SaxWriter.SOURCE_OBJECT_LIST_PROPERTY, this.source);
                }
            } catch (SAXException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
