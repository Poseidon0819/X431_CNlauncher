package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.IOException;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultElement;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/* renamed from: com.thoughtworks.xstream.io.xml.Dom4JXmlWriter */
/* loaded from: classes2.dex */
public class Dom4JXmlWriter extends AbstractXmlWriter {
    private AttributesImpl attributes;
    private boolean children;
    private final FastStack elementStack;
    private boolean started;
    private final XMLWriter writer;

    public Dom4JXmlWriter(XMLWriter xMLWriter) {
        this(xMLWriter, new XmlFriendlyNameCoder());
    }

    public Dom4JXmlWriter(XMLWriter xMLWriter, NameCoder nameCoder) {
        super(nameCoder);
        this.writer = xMLWriter;
        this.elementStack = new FastStack(16);
        this.attributes = new AttributesImpl();
        try {
            xMLWriter.startDocument();
        } catch (SAXException e) {
            throw new StreamException(e);
        }
    }

    public Dom4JXmlWriter(XMLWriter xMLWriter, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(xMLWriter, (NameCoder) xmlFriendlyReplacer);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void startNode(String str) {
        if (this.elementStack.size() > 0) {
            try {
                startElement();
                this.started = false;
            } catch (SAXException e) {
                throw new StreamException(e);
            }
        }
        this.elementStack.push(encodeNode(str));
        this.children = false;
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void setValue(String str) {
        char[] charArray = str.toCharArray();
        if (charArray.length > 0) {
            try {
                startElement();
                this.writer.characters(charArray, 0, charArray.length);
                this.children = true;
            } catch (SAXException e) {
                throw new StreamException(e);
            }
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void addAttribute(String str, String str2) {
        this.attributes.addAttribute("", "", encodeAttribute(str), "string", str2);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void endNode() {
        try {
            if (!this.children) {
                DefaultElement defaultElement = new DefaultElement((String) this.elementStack.pop());
                for (int i = 0; i < this.attributes.getLength(); i++) {
                    defaultElement.addAttribute(this.attributes.getQName(i), this.attributes.getValue(i));
                }
                this.writer.write(defaultElement);
                this.attributes.clear();
                this.children = true;
                this.started = true;
                return;
            }
            startElement();
            this.writer.endElement("", "", (String) this.elementStack.pop());
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (SAXException e2) {
            throw new StreamException(e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void flush() {
        try {
            this.writer.flush();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamWriter
    public void close() {
        try {
            this.writer.endDocument();
        } catch (SAXException e) {
            throw new StreamException(e);
        }
    }

    private void startElement() throws SAXException {
        if (this.started) {
            return;
        }
        this.writer.startElement("", "", (String) this.elementStack.peek(), this.attributes);
        this.attributes.clear();
        this.started = true;
    }
}
