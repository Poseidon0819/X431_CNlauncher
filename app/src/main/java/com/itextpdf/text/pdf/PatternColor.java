package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PatternColor extends ExtendedColor {
    private static final long serialVersionUID = -1185448552860615964L;
    PdfPatternPainter painter;

    @Override // com.itextpdf.text.BaseColor
    public boolean equals(Object obj) {
        return this == obj;
    }

    public PatternColor(PdfPatternPainter pdfPatternPainter) {
        super(4, 0.5f, 0.5f, 0.5f);
        this.painter = pdfPatternPainter;
    }

    public PdfPatternPainter getPainter() {
        return this.painter;
    }

    @Override // com.itextpdf.text.BaseColor
    public int hashCode() {
        return this.painter.hashCode();
    }
}
