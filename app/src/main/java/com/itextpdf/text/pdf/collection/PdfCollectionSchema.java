package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;

/* loaded from: classes.dex */
public class PdfCollectionSchema extends PdfDictionary {
    public PdfCollectionSchema() {
        super(PdfName.COLLECTIONSCHEMA);
    }

    public void addField(String str, PdfCollectionField pdfCollectionField) {
        put(new PdfName(str), pdfCollectionField);
    }
}
