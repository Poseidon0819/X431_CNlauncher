package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/* renamed from: com.thoughtworks.xstream.io.xml.SaxWriter */
/* loaded from: classes2.dex */
public final class SaxWriter extends AbstractXmlWriter implements XMLReader {
    public static final String CONFIGURED_XSTREAM_PROPERTY = "http://com.thoughtworks.xstream/sax/property/configured-xstream";
    public static final String SOURCE_OBJECT_LIST_PROPERTY = "http://com.thoughtworks.xstream/sax/property/source-object-list";
    private final AttributesImpl attributeList;
    private char[] buffer;
    private ContentHandler contentHandler;
    private int depth;
    private DTDHandler dtdHandler;
    private List elementStack;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private Map features;
    private final boolean includeEnclosingDocument;
    private final Map properties;
    private boolean startTagInProgress;

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void close() {
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void flush() {
    }

    public SaxWriter(NameCoder nameCoder) {
        this(true, nameCoder);
    }

    public SaxWriter(boolean z, NameCoder nameCoder) {
        super(nameCoder);
        this.entityResolver = null;
        this.dtdHandler = null;
        this.contentHandler = null;
        this.errorHandler = null;
        this.features = new HashMap();
        this.properties = new HashMap();
        this.depth = 0;
        this.elementStack = new LinkedList();
        this.buffer = new char[128];
        this.startTagInProgress = false;
        this.attributeList = new AttributesImpl();
        this.includeEnclosingDocument = z;
    }

    public SaxWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(true, xmlFriendlyReplacer);
    }

    public SaxWriter(boolean z, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(z, (NameCoder) xmlFriendlyReplacer);
    }

    public SaxWriter(boolean z) {
        this(z, new XmlFriendlyNameCoder());
    }

    public SaxWriter() {
        this(true);
    }

    @Override // org.xml.sax.XMLReader
    public final void setFeature(String str, boolean z) throws SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces") || str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            this.features.put(str, z ? Boolean.TRUE : Boolean.FALSE);
            return;
        }
        throw new SAXNotRecognizedException(str);
    }

    @Override // org.xml.sax.XMLReader
    public final boolean getFeature(String str) throws SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces") || str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            Boolean bool = (Boolean) this.features.get(str);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        throw new SAXNotRecognizedException(str);
    }

    @Override // org.xml.sax.XMLReader
    public final void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(CONFIGURED_XSTREAM_PROPERTY)) {
            if (!(obj instanceof XStream)) {
                throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/configured-xstream\" must be a non-null XStream object");
            }
        } else if (str.equals(SOURCE_OBJECT_LIST_PROPERTY)) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" shall not be an empty list");
                }
                obj = Collections.unmodifiableList(new ArrayList(list));
            } else {
                throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" must be a non-null List object");
            }
        } else {
            throw new SAXNotRecognizedException(str);
        }
        this.properties.put(str, obj);
    }

    @Override // org.xml.sax.XMLReader
    public final Object getProperty(String str) throws SAXNotRecognizedException {
        if (str.equals(CONFIGURED_XSTREAM_PROPERTY) || str.equals(SOURCE_OBJECT_LIST_PROPERTY)) {
            return this.properties.get(str);
        }
        throw new SAXNotRecognizedException(str);
    }

    @Override // org.xml.sax.XMLReader
    public final void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            throw new NullPointerException("resolver");
        }
        this.entityResolver = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public final EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public final void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            throw new NullPointerException("handler");
        }
        this.dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            throw new NullPointerException("handler");
        }
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            throw new NullPointerException("handler");
        }
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public final void parse(String str) throws SAXException {
        parse();
    }

    @Override // org.xml.sax.XMLReader
    public final void parse(InputSource inputSource) throws SAXException {
        parse();
    }

    private void parse() throws SAXException {
        XStream xStream = (XStream) this.properties.get(CONFIGURED_XSTREAM_PROPERTY);
        if (xStream == null) {
            xStream = new XStream();
        }
        List<Object> list = (List) this.properties.get(SOURCE_OBJECT_LIST_PROPERTY);
        if (list == null || list.isEmpty()) {
            throw new SAXException("Missing or empty source object list. Setting property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" is mandatory");
        }
        try {
            startDocument(true);
            for (Object obj : list) {
                xStream.marshal(obj, this);
            }
            endDocument(true);
        } catch (StreamException e) {
            if (e.getCause() instanceof SAXException) {
                throw ((SAXException) e.getCause());
            }
            throw new SAXException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void startNode(String str) {
        try {
            if (this.depth != 0) {
                flushStartTag();
            } else if (this.includeEnclosingDocument) {
                startDocument(false);
            }
            this.elementStack.add(0, escapeXmlName(str));
            this.startTagInProgress = true;
            this.depth++;
        } catch (SAXException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void addAttribute(String str, String str2) {
        if (this.startTagInProgress) {
            String escapeXmlName = escapeXmlName(str);
            this.attributeList.addAttribute("", escapeXmlName, escapeXmlName, "CDATA", str2);
            return;
        }
        throw new StreamException(new IllegalStateException("No startElement being processed"));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void setValue(String str) {
        try {
            flushStartTag();
            int length = str.length();
            if (length > this.buffer.length) {
                this.buffer = new char[length];
            }
            str.getChars(0, length, this.buffer, 0);
            this.contentHandler.characters(this.buffer, 0, length);
        } catch (SAXException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public final void endNode() {
        try {
            flushStartTag();
            String str = (String) this.elementStack.remove(0);
            this.contentHandler.endElement("", str, str);
            this.depth--;
            if (this.depth == 0 && this.includeEnclosingDocument) {
                endDocument(false);
            }
        } catch (SAXException e) {
            throw new StreamException(e);
        }
    }

    private void startDocument(boolean z) throws SAXException {
        if (this.depth == 0) {
            this.contentHandler.startDocument();
            if (z) {
                this.depth++;
            }
        }
    }

    private void endDocument(boolean z) throws SAXException {
        int i = this.depth;
        if (i == 0 || (i == 1 && z)) {
            this.contentHandler.endDocument();
            this.depth = 0;
        }
    }

    private void flushStartTag() throws SAXException {
        if (this.startTagInProgress) {
            String str = (String) this.elementStack.get(0);
            this.contentHandler.startElement("", str, str, this.attributeList);
            this.attributeList.clear();
            this.startTagInProgress = false;
        }
    }
}
