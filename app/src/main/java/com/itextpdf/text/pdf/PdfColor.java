package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PdfColor extends PdfArray {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PdfColor(int r6, int r7, int r8) {
        /*
            r5 = this;
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            r6 = r6 & 255(0xff, float:3.57E-43)
            double r1 = (double) r6
            r3 = 4643176031446892544(0x406fe00000000000, double:255.0)
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r3
            r0.<init>(r1)
            r5.<init>(r0)
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            r7 = r7 & 255(0xff, float:3.57E-43)
            double r0 = (double) r7
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r3
            r6.<init>(r0)
            r5.add(r6)
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            r7 = r8 & 255(0xff, float:3.57E-43)
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r3
            r6.<init>(r7)
            r5.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfColor.<init>(int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfColor(BaseColor baseColor) {
        this(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
    }
}
