package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;

/* loaded from: classes.dex */
public class PdfCollection extends PdfDictionary {
    public static final int CUSTOM = 3;
    public static final int DETAILS = 0;
    public static final int HIDDEN = 2;
    public static final int TILE = 1;

    public PdfCollection(int i) {
        super(PdfName.COLLECTION);
        switch (i) {
            case 1:
                put(PdfName.VIEW, PdfName.f19772T);
                return;
            case 2:
                put(PdfName.VIEW, PdfName.f19721H);
                return;
            case 3:
                put(PdfName.VIEW, PdfName.f19690C);
                return;
            default:
                put(PdfName.VIEW, PdfName.f19699D);
                return;
        }
    }

    public void setInitialDocument(String str) {
        put(PdfName.f19699D, new PdfString(str, null));
    }

    public void setSchema(PdfCollectionSchema pdfCollectionSchema) {
        put(PdfName.SCHEMA, pdfCollectionSchema);
    }

    public PdfCollectionSchema getSchema() {
        return (PdfCollectionSchema) get(PdfName.SCHEMA);
    }

    public void setSort(PdfCollectionSort pdfCollectionSort) {
        put(PdfName.SORT, pdfCollectionSort);
    }
}
