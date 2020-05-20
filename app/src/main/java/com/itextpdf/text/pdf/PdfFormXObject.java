package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfFormXObject extends PdfStream {
    public static final PdfNumber ZERO = new PdfNumber(0);
    public static final PdfNumber ONE = new PdfNumber(1);
    public static final PdfLiteral MATRIX = new PdfLiteral("[1 0 0 1 0 0]");

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfFormXObject(PdfTemplate pdfTemplate, int i) {
        put(PdfName.TYPE, PdfName.XOBJECT);
        put(PdfName.SUBTYPE, PdfName.FORM);
        put(PdfName.RESOURCES, pdfTemplate.getResources());
        put(PdfName.BBOX, new PdfRectangle(pdfTemplate.getBoundingBox()));
        put(PdfName.FORMTYPE, ONE);
        if (pdfTemplate.getLayer() != null) {
            put(PdfName.f19747OC, pdfTemplate.getLayer().getRef());
        }
        if (pdfTemplate.getGroup() != null) {
            put(PdfName.GROUP, pdfTemplate.getGroup());
        }
        PdfArray matrix = pdfTemplate.getMatrix();
        if (matrix == null) {
            put(PdfName.MATRIX, MATRIX);
        } else {
            put(PdfName.MATRIX, matrix);
        }
        this.bytes = pdfTemplate.toPdf(null);
        put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
        if (pdfTemplate.getAdditional() != null) {
            putAll(pdfTemplate.getAdditional());
        }
        flateCompress(i);
    }
}
