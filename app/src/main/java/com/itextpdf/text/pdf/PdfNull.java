package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfNull extends PdfObject {
    private static final String CONTENT = "null";
    public static final PdfNull PDFNULL = new PdfNull();

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return CONTENT;
    }

    public PdfNull() {
        super(8, CONTENT);
    }
}
