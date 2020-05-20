package com.itextpdf.text.pdf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ColorDetails {
    PdfName colorName;
    PdfIndirectReference indirectReference;
    PdfSpotColor spotcolor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, PdfSpotColor pdfSpotColor) {
        this.colorName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.spotcolor = pdfSpotColor;
    }

    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfName getColorName() {
        return this.colorName;
    }

    public PdfObject getSpotColor(PdfWriter pdfWriter) {
        return this.spotcolor.getSpotObject(pdfWriter);
    }
}
