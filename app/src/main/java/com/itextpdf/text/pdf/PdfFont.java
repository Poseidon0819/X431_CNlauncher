package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;

/* loaded from: classes.dex */
class PdfFont implements Comparable<PdfFont> {
    private BaseFont font;
    protected float hScale = 1.0f;
    protected Image image;
    private float size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfFont(BaseFont baseFont, float f) {
        this.size = f;
        this.font = baseFont;
    }

    @Override // java.lang.Comparable
    public int compareTo(PdfFont pdfFont) {
        if (this.image != null) {
            return 0;
        }
        if (pdfFont == null) {
            return -1;
        }
        try {
            if (this.font != pdfFont.font) {
                return 1;
            }
            return size() != pdfFont.size() ? 2 : 0;
        } catch (ClassCastException unused) {
            return -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float size() {
        Image image = this.image;
        if (image == null) {
            return this.size;
        }
        return image.getScaledHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float width() {
        return width(32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float width(int i) {
        Image image = this.image;
        if (image == null) {
            return this.font.getWidthPoint(i, this.size) * this.hScale;
        }
        return image.getScaledWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float width(String str) {
        Image image = this.image;
        if (image == null) {
            return this.font.getWidthPoint(str, this.size) * this.hScale;
        }
        return image.getScaledWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseFont getFont() {
        return this.font;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImage(Image image) {
        this.image = image;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PdfFont getDefaultFont() {
        try {
            return new PdfFont(BaseFont.createFont("Helvetica", "Cp1252", false), 12.0f);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalScaling(float f) {
        this.hScale = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHorizontalScaling() {
        return this.hScale;
    }
}
