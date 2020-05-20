package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfBorderArray extends PdfArray {
    public PdfBorderArray(float f, float f2, float f3) {
        this(f, f2, f3, null);
    }

    public PdfBorderArray(float f, float f2, float f3, PdfDashPattern pdfDashPattern) {
        super(new PdfNumber(f));
        add(new PdfNumber(f2));
        add(new PdfNumber(f3));
        if (pdfDashPattern != null) {
            add(pdfDashPattern);
        }
    }
}
