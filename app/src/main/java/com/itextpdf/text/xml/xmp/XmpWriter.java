package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/* loaded from: classes.dex */
public class XmpWriter {
    public static final String EXTRASPACE = "                                                                                                   \n";
    public static final String UTF16 = "UTF-16";
    public static final String UTF16BE = "UTF-16BE";
    public static final String UTF16LE = "UTF-16LE";
    public static final String UTF8 = "UTF-8";
    public static final String XPACKET_PI_BEGIN = "<?xpacket begin=\"\ufeff\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n";
    public static final String XPACKET_PI_END_R = "<?xpacket end=\"r\"?>";
    public static final String XPACKET_PI_END_W = "<?xpacket end=\"w\"?>";
    protected String about;
    protected char end;
    protected int extraSpace;
    protected OutputStreamWriter writer;

    public XmpWriter(OutputStream outputStream, String str, int i) throws IOException {
        this.end = 'w';
        this.extraSpace = i;
        this.writer = new OutputStreamWriter(outputStream, str);
        this.writer.write(XPACKET_PI_BEGIN);
        this.writer.write("<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n");
        this.writer.write("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n");
        this.about = "";
    }

    public XmpWriter(OutputStream outputStream) throws IOException {
        this(outputStream, "UTF-8", 20);
    }

    public void setReadOnly() {
        this.end = 'r';
    }

    public void setAbout(String str) {
        this.about = str;
    }

    public void addRdfDescription(String str, String str2) throws IOException {
        this.writer.write("<rdf:Description rdf:about=\"");
        this.writer.write(this.about);
        this.writer.write("\" ");
        this.writer.write(str);
        this.writer.write(">");
        this.writer.write(str2);
        this.writer.write("</rdf:Description>\n");
    }

    public void addRdfDescription(XmpSchema xmpSchema) throws IOException {
        this.writer.write("<rdf:Description rdf:about=\"");
        this.writer.write(this.about);
        this.writer.write("\" ");
        this.writer.write(xmpSchema.getXmlns());
        this.writer.write(">");
        this.writer.write(xmpSchema.toString());
        this.writer.write("</rdf:Description>\n");
    }

    public void close() throws IOException {
        this.writer.write("</rdf:RDF>");
        this.writer.write("</x:xmpmeta>\n");
        for (int i = 0; i < this.extraSpace; i++) {
            this.writer.write(EXTRASPACE);
        }
        this.writer.write(this.end == 'r' ? XPACKET_PI_END_R : XPACKET_PI_END_W);
        this.writer.flush();
        this.writer.close();
    }

    public XmpWriter(OutputStream outputStream, PdfDictionary pdfDictionary, int i) throws IOException {
        this(outputStream, pdfDictionary);
        if (pdfDictionary != null) {
            DublinCoreSchema dublinCoreSchema = new DublinCoreSchema();
            PdfSchema pdfSchema = new PdfSchema();
            XmpBasicSchema xmpBasicSchema = new XmpBasicSchema();
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                if (pdfObject != null && pdfObject.isString()) {
                    String unicodeString = ((PdfString) pdfObject).toUnicodeString();
                    if (PdfName.TITLE.equals(pdfName)) {
                        dublinCoreSchema.addTitle(unicodeString);
                    }
                    if (PdfName.AUTHOR.equals(pdfName)) {
                        dublinCoreSchema.addAuthor(unicodeString);
                    }
                    if (PdfName.SUBJECT.equals(pdfName)) {
                        dublinCoreSchema.addSubject(unicodeString);
                        dublinCoreSchema.addDescription(unicodeString);
                    }
                    if (PdfName.KEYWORDS.equals(pdfName)) {
                        pdfSchema.addKeywords(unicodeString);
                    }
                    if (PdfName.CREATOR.equals(pdfName)) {
                        xmpBasicSchema.addCreatorTool(unicodeString);
                    }
                    if (PdfName.PRODUCER.equals(pdfName)) {
                        pdfSchema.addProducer(unicodeString);
                    }
                    if (PdfName.CREATIONDATE.equals(pdfName)) {
                        xmpBasicSchema.addCreateDate(PdfDate.getW3CDate(pdfObject.toString()));
                    }
                    if (PdfName.MODDATE.equals(pdfName)) {
                        xmpBasicSchema.addModDate(PdfDate.getW3CDate(pdfObject.toString()));
                    }
                }
            }
            if (dublinCoreSchema.size() > 0) {
                addRdfDescription(dublinCoreSchema);
            }
            if (pdfSchema.size() > 0) {
                addRdfDescription(pdfSchema);
            }
            if (xmpBasicSchema.size() > 0) {
                addRdfDescription(xmpBasicSchema);
            }
        }
    }

    public XmpWriter(OutputStream outputStream, PdfDictionary pdfDictionary) throws IOException {
        this(outputStream);
        if (pdfDictionary != null) {
            DublinCoreSchema dublinCoreSchema = new DublinCoreSchema();
            PdfSchema pdfSchema = new PdfSchema();
            XmpBasicSchema xmpBasicSchema = new XmpBasicSchema();
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                if (pdfObject != null && pdfObject.isString()) {
                    String unicodeString = ((PdfString) pdfObject).toUnicodeString();
                    if (PdfName.TITLE.equals(pdfName)) {
                        dublinCoreSchema.addTitle(unicodeString);
                    }
                    if (PdfName.AUTHOR.equals(pdfName)) {
                        dublinCoreSchema.addAuthor(unicodeString);
                    }
                    if (PdfName.SUBJECT.equals(pdfName)) {
                        dublinCoreSchema.addSubject(unicodeString);
                        dublinCoreSchema.addDescription(unicodeString);
                    }
                    if (PdfName.KEYWORDS.equals(pdfName)) {
                        pdfSchema.addKeywords(unicodeString);
                    }
                    if (PdfName.CREATOR.equals(pdfName)) {
                        xmpBasicSchema.addCreatorTool(unicodeString);
                    }
                    if (PdfName.PRODUCER.equals(pdfName)) {
                        pdfSchema.addProducer(unicodeString);
                    }
                    if (PdfName.CREATIONDATE.equals(pdfName)) {
                        xmpBasicSchema.addCreateDate(PdfDate.getW3CDate(pdfObject.toString()));
                    }
                    if (PdfName.MODDATE.equals(pdfName)) {
                        xmpBasicSchema.addModDate(PdfDate.getW3CDate(pdfObject.toString()));
                    }
                }
            }
            if (dublinCoreSchema.size() > 0) {
                addRdfDescription(dublinCoreSchema);
            }
            if (pdfSchema.size() > 0) {
                addRdfDescription(pdfSchema);
            }
            if (xmpBasicSchema.size() > 0) {
                addRdfDescription(xmpBasicSchema);
            }
        }
    }

    public XmpWriter(OutputStream outputStream, Map<String, String> map) throws IOException {
        this(outputStream);
        if (map != null) {
            DublinCoreSchema dublinCoreSchema = new DublinCoreSchema();
            PdfSchema pdfSchema = new PdfSchema();
            XmpBasicSchema xmpBasicSchema = new XmpBasicSchema();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null) {
                    if ("Title".equals(key)) {
                        dublinCoreSchema.addTitle(value);
                    }
                    if ("Author".equals(key)) {
                        dublinCoreSchema.addAuthor(value);
                    }
                    if ("Subject".equals(key)) {
                        dublinCoreSchema.addSubject(value);
                        dublinCoreSchema.addDescription(value);
                    }
                    if ("Keywords".equals(key)) {
                        pdfSchema.addKeywords(value);
                    }
                    if ("Creator".equals(key)) {
                        xmpBasicSchema.addCreatorTool(value);
                    }
                    if ("Producer".equals(key)) {
                        pdfSchema.addProducer(value);
                    }
                    if ("CreationDate".equals(key)) {
                        xmpBasicSchema.addCreateDate(PdfDate.getW3CDate(value));
                    }
                    if ("ModDate".equals(key)) {
                        xmpBasicSchema.addModDate(PdfDate.getW3CDate(value));
                    }
                }
            }
            if (dublinCoreSchema.size() > 0) {
                addRdfDescription(dublinCoreSchema);
            }
            if (pdfSchema.size() > 0) {
                addRdfDescription(pdfSchema);
            }
            if (xmpBasicSchema.size() > 0) {
                addRdfDescription(xmpBasicSchema);
            }
        }
    }
}
