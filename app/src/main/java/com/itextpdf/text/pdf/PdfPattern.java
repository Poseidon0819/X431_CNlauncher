package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;

/* loaded from: classes.dex */
public class PdfPattern extends PdfStream {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPattern(PdfPatternPainter pdfPatternPainter) {
        this(pdfPatternPainter, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPattern(PdfPatternPainter pdfPatternPainter, int i) {
        PdfNumber pdfNumber = new PdfNumber(1);
        PdfArray matrix = pdfPatternPainter.getMatrix();
        if (matrix != null) {
            put(PdfName.MATRIX, matrix);
        }
        put(PdfName.TYPE, PdfName.PATTERN);
        put(PdfName.BBOX, new PdfRectangle(pdfPatternPainter.getBoundingBox()));
        put(PdfName.RESOURCES, pdfPatternPainter.getResources());
        put(PdfName.TILINGTYPE, pdfNumber);
        put(PdfName.PATTERNTYPE, pdfNumber);
        if (pdfPatternPainter.isStencil()) {
            put(PdfName.PAINTTYPE, new PdfNumber(2));
        } else {
            put(PdfName.PAINTTYPE, pdfNumber);
        }
        put(PdfName.XSTEP, new PdfNumber(pdfPatternPainter.getXStep()));
        put(PdfName.YSTEP, new PdfNumber(pdfPatternPainter.getYStep()));
        this.bytes = pdfPatternPainter.toPdf(null);
        put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
        try {
            flateCompress(i);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
