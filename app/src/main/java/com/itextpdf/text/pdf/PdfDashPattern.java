package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PdfDashPattern extends PdfArray {
    private float dash;
    private float gap;
    private float phase;

    public PdfDashPattern() {
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
    }

    public PdfDashPattern(float f) {
        super(new PdfNumber(f));
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
        this.dash = f;
    }

    public PdfDashPattern(float f, float f2) {
        super(new PdfNumber(f));
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
        add(new PdfNumber(f2));
        this.dash = f;
        this.gap = f2;
    }

    public PdfDashPattern(float f, float f2, float f3) {
        super(new PdfNumber(f));
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
        add(new PdfNumber(f2));
        this.dash = f;
        this.gap = f2;
        this.phase = f3;
    }

    public void add(float f) {
        add(new PdfNumber(f));
    }

    @Override // com.itextpdf.text.pdf.PdfArray, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(91);
        float f = this.dash;
        if (f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            new PdfNumber(f).toPdf(pdfWriter, outputStream);
            if (this.gap >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                outputStream.write(32);
                new PdfNumber(this.gap).toPdf(pdfWriter, outputStream);
            }
        }
        outputStream.write(93);
        if (this.phase >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            outputStream.write(32);
            new PdfNumber(this.phase).toPdf(pdfWriter, outputStream);
        }
    }
}
