package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

/* loaded from: classes.dex */
public class LineSeparator extends VerticalPositionMark {
    protected int alignment;
    protected BaseColor lineColor;
    protected float lineWidth;
    protected float percentage;

    public LineSeparator(float f, float f2, BaseColor baseColor, int i, float f3) {
        this.lineWidth = 1.0f;
        this.percentage = 100.0f;
        this.alignment = 1;
        this.lineWidth = f;
        this.percentage = f2;
        this.lineColor = baseColor;
        this.alignment = i;
        this.offset = f3;
    }

    public LineSeparator() {
        this.lineWidth = 1.0f;
        this.percentage = 100.0f;
        this.alignment = 1;
    }

    @Override // com.itextpdf.text.pdf.draw.VerticalPositionMark, com.itextpdf.text.pdf.draw.DrawInterface
    public void draw(PdfContentByte pdfContentByte, float f, float f2, float f3, float f4, float f5) {
        pdfContentByte.saveState();
        drawLine(pdfContentByte, f, f3, f5);
        pdfContentByte.restoreState();
    }

    public void drawLine(PdfContentByte pdfContentByte, float f, float f2, float f3) {
        float percentage;
        float percentage2 = getPercentage();
        float f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (percentage2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            percentage = -getPercentage();
        } else {
            percentage = ((f2 - f) * getPercentage()) / 100.0f;
        }
        int alignment = getAlignment();
        if (alignment != 0) {
            f4 = alignment != 2 ? ((f2 - f) - percentage) / 2.0f : (f2 - f) - percentage;
        }
        pdfContentByte.setLineWidth(getLineWidth());
        if (getLineColor() != null) {
            pdfContentByte.setColorStroke(getLineColor());
        }
        pdfContentByte.moveTo(f4 + f, this.offset + f3);
        pdfContentByte.lineTo(f4 + percentage + f, f3 + this.offset);
        pdfContentByte.stroke();
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(float f) {
        this.lineWidth = f;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(float f) {
        this.percentage = f;
    }

    public BaseColor getLineColor() {
        return this.lineColor;
    }

    public void setLineColor(BaseColor baseColor) {
        this.lineColor = baseColor;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }
}
