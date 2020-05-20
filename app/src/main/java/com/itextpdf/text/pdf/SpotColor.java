package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class SpotColor extends ExtendedColor {
    private static final long serialVersionUID = -6257004582113248079L;
    PdfSpotColor spot;
    float tint;

    @Override // com.itextpdf.text.BaseColor
    public boolean equals(Object obj) {
        return this == obj;
    }

    public SpotColor(PdfSpotColor pdfSpotColor, float f) {
        super(3, (((pdfSpotColor.getAlternativeCS().getRed() / 255.0f) - 1.0f) * f) + 1.0f, (((pdfSpotColor.getAlternativeCS().getGreen() / 255.0f) - 1.0f) * f) + 1.0f, (((pdfSpotColor.getAlternativeCS().getBlue() / 255.0f) - 1.0f) * f) + 1.0f);
        this.spot = pdfSpotColor;
        this.tint = f;
    }

    public PdfSpotColor getPdfSpotColor() {
        return this.spot;
    }

    public float getTint() {
        return this.tint;
    }

    @Override // com.itextpdf.text.BaseColor
    public int hashCode() {
        return this.spot.hashCode() ^ Float.floatToIntBits(this.tint);
    }
}
