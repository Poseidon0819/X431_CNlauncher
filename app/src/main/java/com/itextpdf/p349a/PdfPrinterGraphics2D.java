package com.itextpdf.p349a;

import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import java.awt.print.PrinterGraphics;
import java.awt.print.PrinterJob;

/* renamed from: com.itextpdf.a.d */
/* loaded from: classes.dex */
public final class PdfPrinterGraphics2D extends PdfGraphics2D implements PrinterGraphics {

    /* renamed from: u */
    private PrinterJob f19584u;

    public PdfPrinterGraphics2D(PdfContentByte pdfContentByte, float f, float f2, PrinterJob printerJob) {
        super(pdfContentByte, f, f2);
        this.f19584u = printerJob;
    }

    public PdfPrinterGraphics2D(PdfContentByte pdfContentByte, float f, float f2, PrinterJob printerJob, byte b) {
        super(pdfContentByte, f, f2, (byte) 0);
        this.f19584u = printerJob;
    }

    public PdfPrinterGraphics2D(PdfContentByte pdfContentByte, float f, float f2, FontMapper fontMapper, PrinterJob printerJob) {
        super(pdfContentByte, f, f2, fontMapper, false, false, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f19584u = printerJob;
    }

    public PdfPrinterGraphics2D(PdfContentByte pdfContentByte, float f, float f2, FontMapper fontMapper, boolean z, boolean z2, float f3, PrinterJob printerJob) {
        super(pdfContentByte, f, f2, fontMapper, z, z2, f3);
        this.f19584u = printerJob;
    }
}
