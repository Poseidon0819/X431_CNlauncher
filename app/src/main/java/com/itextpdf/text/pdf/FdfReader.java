package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FdfReader extends PdfReader {
    PdfName encoding;
    HashMap<String, PdfDictionary> fields;
    String fileSpec;

    public FdfReader(String str) throws IOException {
        super(str);
    }

    public FdfReader(byte[] bArr) throws IOException {
        super(bArr);
    }

    public FdfReader(URL url) throws IOException {
        super(url);
    }

    public FdfReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override // com.itextpdf.text.pdf.PdfReader
    protected void readPdf() throws IOException {
        this.fields = new HashMap<>();
        try {
            this.tokens.checkFdfHeader();
            rebuildXref();
            readDocObj();
            readFields();
        } finally {
            try {
                this.tokens.close();
            } catch (Exception unused) {
            }
        }
    }

    protected void kidNode(PdfDictionary pdfDictionary, String str) {
        PdfString asString;
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
        if (asArray == null || asArray.isEmpty()) {
            if (str.length() > 0) {
                str = str.substring(1);
            }
            this.fields.put(str, pdfDictionary);
            return;
        }
        pdfDictionary.remove(PdfName.KIDS);
        for (int i = 0; i < asArray.size(); i++) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.merge(pdfDictionary);
            PdfDictionary asDict = asArray.getAsDict(i);
            String str2 = asDict.getAsString(PdfName.f19772T) != null ? str + "." + asString.toUnicodeString() : str;
            pdfDictionary2.merge(asDict);
            pdfDictionary2.remove(PdfName.f19772T);
            kidNode(pdfDictionary2, str2);
        }
    }

    protected void readFields() {
        this.catalog = this.trailer.getAsDict(PdfName.ROOT);
        PdfDictionary asDict = this.catalog.getAsDict(PdfName.FDF);
        if (asDict == null) {
            return;
        }
        PdfString asString = asDict.getAsString(PdfName.f19712F);
        if (asString != null) {
            this.fileSpec = asString.toUnicodeString();
        }
        PdfArray asArray = asDict.getAsArray(PdfName.FIELDS);
        if (asArray == null) {
            return;
        }
        this.encoding = asDict.getAsName(PdfName.ENCODING);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.KIDS, asArray);
        kidNode(pdfDictionary, "");
    }

    public HashMap<String, PdfDictionary> getFields() {
        return this.fields;
    }

    public PdfDictionary getField(String str) {
        return this.fields.get(str);
    }

    public byte[] getAttachedFile(String str) throws IOException {
        PdfDictionary pdfDictionary = this.fields.get(str);
        if (pdfDictionary != null) {
            return getStreamBytes((PRStream) getPdfObject(((PRIndirectReference) ((PdfDictionary) getPdfObject(((PRIndirectReference) pdfDictionary.get(PdfName.f19787V)).getNumber())).getAsDict(PdfName.f19711EF).get(PdfName.f19712F)).getNumber()));
        }
        return new byte[0];
    }

    public String getFieldValue(String str) {
        PdfObject pdfObject;
        PdfDictionary pdfDictionary = this.fields.get(str);
        if (pdfDictionary == null || (pdfObject = getPdfObject(pdfDictionary.get(PdfName.f19787V))) == null) {
            return null;
        }
        if (pdfObject.isName()) {
            return PdfName.decodeName(((PdfName) pdfObject).toString());
        }
        if (pdfObject.isString()) {
            PdfString pdfString = (PdfString) pdfObject;
            if (this.encoding == null || pdfString.getEncoding() != null) {
                return pdfString.toUnicodeString();
            }
            byte[] bytes = pdfString.getBytes();
            if (bytes.length >= 2 && bytes[0] == -2 && bytes[1] == -1) {
                return pdfString.toUnicodeString();
            }
            if (this.encoding.equals(PdfName.SHIFT_JIS)) {
                return new String(bytes, "SJIS");
            }
            if (this.encoding.equals(PdfName.UHC)) {
                return new String(bytes, "MS949");
            }
            if (this.encoding.equals(PdfName.GBK)) {
                return new String(bytes, "GBK");
            }
            if (this.encoding.equals(PdfName.BIGFIVE)) {
                return new String(bytes, "Big5");
            }
            return pdfString.toUnicodeString();
        }
        return null;
    }

    public String getFileSpec() {
        return this.fileSpec;
    }
}
