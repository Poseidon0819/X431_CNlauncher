package com.thoughtworks.xstream.p366io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.p366io.StreamException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.p398v1.XmlPullParser;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.thoughtworks.xstream.io.xml.XppReader */
/* loaded from: classes2.dex */
public class XppReader extends AbstractPullReader {
    private final XmlPullParser parser;
    private final Reader reader;

    public XppReader(Reader reader, XmlPullParser xmlPullParser) {
        this(reader, xmlPullParser, new XmlFriendlyNameCoder());
    }

    public XppReader(Reader reader, XmlPullParser xmlPullParser, NameCoder nameCoder) {
        super(nameCoder);
        this.parser = xmlPullParser;
        this.reader = reader;
        try {
            xmlPullParser.setInput(this.reader);
            moveDown();
        } catch (XmlPullParserException e) {
            throw new StreamException(e);
        }
    }

    public XppReader(Reader reader) {
        this(reader, new XmlFriendlyReplacer());
    }

    public XppReader(Reader reader, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(xmlFriendlyReplacer);
        try {
            this.parser = createParser();
            this.reader = reader;
            this.parser.setInput(this.reader);
            moveDown();
        } catch (XmlPullParserException e) {
            throw new StreamException(e);
        }
    }

    protected XmlPullParser createParser() {
        try {
            return (XmlPullParser) Class.forName("org.xmlpull.mxp1.MXParser", true, XmlPullParser.class.getClassLoader()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new StreamException("Cannot create Xpp3 parser instance.", e);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected int pullNextEvent() {
        try {
            int next = this.parser.next();
            if (next != 9) {
                switch (next) {
                    case 0:
                    case 2:
                        return 1;
                    case 1:
                    case 3:
                        return 2;
                    case 4:
                        return 3;
                    default:
                        return 0;
                }
            }
            return 4;
        } catch (IOException e) {
            throw new StreamException(e);
        } catch (XmlPullParserException e2) {
            throw new StreamException(e2);
        }
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected String pullElementName() {
        return this.parser.getName();
    }

    @Override // com.thoughtworks.xstream.p366io.xml.AbstractPullReader
    protected String pullText() {
        return this.parser.getText();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(String str) {
        return this.parser.getAttributeValue(null, encodeAttribute(str));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttribute(int i) {
        return this.parser.getAttributeValue(i);
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public int getAttributeCount() {
        return this.parser.getAttributeCount();
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public String getAttributeName(int i) {
        return decodeAttribute(this.parser.getAttributeName(i));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.ErrorReporter
    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("line number", String.valueOf(this.parser.getLineNumber()));
    }

    @Override // com.thoughtworks.xstream.p366io.HierarchicalStreamReader
    public void close() {
        try {
            this.reader.close();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }
}
