package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.xml.XMLUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class TaggedPdfReaderTool {
    PrintWriter out;
    PdfReader reader;

    public void convertToXml(PdfReader pdfReader, OutputStream outputStream, String str) throws IOException {
        this.reader = pdfReader;
        this.out = new PrintWriter(new OutputStreamWriter(outputStream, str));
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.STRUCTTREEROOT);
        if (asDict == null) {
            throw new IOException(MessageLocalization.getComposedMessage("no.structtreeroot.found", new Object[0]));
        }
        inspectChild(asDict.getDirectObject(PdfName.f19734K));
        this.out.flush();
        this.out.close();
    }

    public void convertToXml(PdfReader pdfReader, OutputStream outputStream) throws IOException {
        convertToXml(pdfReader, outputStream, Charset.defaultCharset().name());
    }

    public void inspectChild(PdfObject pdfObject) throws IOException {
        if (pdfObject == null) {
            return;
        }
        if (pdfObject instanceof PdfArray) {
            inspectChildArray((PdfArray) pdfObject);
        } else if (pdfObject instanceof PdfDictionary) {
            inspectChildDictionary((PdfDictionary) pdfObject);
        }
    }

    public void inspectChildArray(PdfArray pdfArray) throws IOException {
        if (pdfArray == null) {
            return;
        }
        for (int i = 0; i < pdfArray.size(); i++) {
            inspectChild(pdfArray.getDirectObject(i));
        }
    }

    public void inspectChildDictionary(PdfDictionary pdfDictionary) throws IOException {
        if (pdfDictionary == null) {
            return;
        }
        PdfName asName = pdfDictionary.getAsName(PdfName.f19767S);
        if (asName != null) {
            String decodeName = PdfName.decodeName(asName.toString());
            String fixTagName = fixTagName(decodeName);
            this.out.print("<");
            this.out.print(fixTagName);
            this.out.print(">");
            PdfDictionary asDict = pdfDictionary.getAsDict(PdfName.f19754PG);
            if (asDict != null) {
                parseTag(decodeName, pdfDictionary.getDirectObject(PdfName.f19734K), asDict);
            }
            inspectChild(pdfDictionary.getDirectObject(PdfName.f19734K));
            this.out.print("</");
            this.out.print(fixTagName);
            this.out.println(">");
            return;
        }
        inspectChild(pdfDictionary.getDirectObject(PdfName.f19734K));
    }

    private static String fixTagName(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            boolean z = true;
            boolean z2 = charAt == ':' || (charAt >= 'A' && charAt <= 'Z') || charAt == '_' || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 192 && charAt <= 214) || ((charAt >= 216 && charAt <= 246) || ((charAt >= 248 && charAt <= 767) || ((charAt >= 880 && charAt <= 893) || ((charAt >= 895 && charAt <= 8191) || ((charAt >= 8204 && charAt <= 8205) || ((charAt >= 8304 && charAt <= 8591) || ((charAt >= 11264 && charAt <= 12271) || ((charAt >= 12289 && charAt <= 55295) || ((charAt >= 63744 && charAt <= 64975) || (charAt >= 65008 && charAt <= 65533))))))))))));
            if (charAt != '-' && charAt != '.' && ((charAt < '0' || charAt > '9') && charAt != 183 && ((charAt < 768 || charAt > 879) && ((charAt < 8255 || charAt > 8256) && !z2)))) {
                z = false;
            }
            if (i == 0) {
                if (!z2) {
                    charAt = '_';
                }
            } else if (!z) {
                charAt = SignatureVisitor.SUPER;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public void parseTag(String str, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
        if (pdfObject instanceof PdfNumber) {
            FilteredTextRenderListener filteredTextRenderListener = new FilteredTextRenderListener(new SimpleTextExtractionStrategy(), new MarkedContentRenderFilter(((PdfNumber) pdfObject).intValue()));
            new PdfContentStreamProcessor(filteredTextRenderListener).processContent(PdfReader.getPageContent(pdfDictionary), pdfDictionary.getAsDict(PdfName.RESOURCES));
            this.out.print(XMLUtil.escapeXML(filteredTextRenderListener.getResultantText(), true));
        } else if (pdfObject instanceof PdfArray) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            int size = pdfArray.size();
            for (int i = 0; i < size; i++) {
                parseTag(str, pdfArray.getPdfObject(i), pdfDictionary);
                if (i < size - 1) {
                    this.out.println();
                }
            }
        } else if (pdfObject instanceof PdfDictionary) {
            PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
            parseTag(str, pdfDictionary2.getDirectObject(PdfName.MCID), pdfDictionary2.getAsDict(PdfName.f19754PG));
        }
    }
}
