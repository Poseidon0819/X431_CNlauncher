package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public final class PdfPatternPainter extends PdfTemplate {
    BaseColor defaultColor;
    boolean stencil;
    float xstep;
    float ystep;

    private PdfPatternPainter() {
        this.stencil = false;
        this.type = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPatternPainter(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.stencil = false;
        this.type = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPatternPainter(PdfWriter pdfWriter, BaseColor baseColor) {
        this(pdfWriter);
        this.stencil = true;
        if (baseColor == null) {
            this.defaultColor = BaseColor.GRAY;
        } else {
            this.defaultColor = baseColor;
        }
    }

    public final void setXStep(float f) {
        this.xstep = f;
    }

    public final void setYStep(float f) {
        this.ystep = f;
    }

    public final float getXStep() {
        return this.xstep;
    }

    public final float getYStep() {
        return this.ystep;
    }

    public final boolean isStencil() {
        return this.stencil;
    }

    public final void setPatternMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        setMatrix(f, f2, f3, f4, f5, f6);
    }

    public final PdfPattern getPattern() {
        return new PdfPattern(this);
    }

    public final PdfPattern getPattern(int i) {
        return new PdfPattern(this, i);
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public final PdfContentByte getDuplicate() {
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter();
        pdfPatternPainter.writer = this.writer;
        pdfPatternPainter.pdf = this.pdf;
        pdfPatternPainter.thisReference = this.thisReference;
        pdfPatternPainter.pageResources = this.pageResources;
        pdfPatternPainter.bBox = new Rectangle(this.bBox);
        pdfPatternPainter.xstep = this.xstep;
        pdfPatternPainter.ystep = this.ystep;
        pdfPatternPainter.matrix = this.matrix;
        pdfPatternPainter.stencil = this.stencil;
        pdfPatternPainter.defaultColor = this.defaultColor;
        return pdfPatternPainter;
    }

    public final BaseColor getDefaultColor() {
        return this.defaultColor;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setGrayFill(float f) {
        checkNoColor();
        super.setGrayFill(f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetGrayFill() {
        checkNoColor();
        super.resetGrayFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setGrayStroke(float f) {
        checkNoColor();
        super.setGrayStroke(f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetGrayStroke() {
        checkNoColor();
        super.resetGrayStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setRGBColorFillF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorFillF(f, f2, f3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetRGBColorFill() {
        checkNoColor();
        super.resetRGBColorFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setRGBColorStrokeF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorStrokeF(f, f2, f3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetRGBColorStroke() {
        checkNoColor();
        super.resetRGBColorStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorFillF(f, f2, f3, f4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetCMYKColorFill() {
        checkNoColor();
        super.resetCMYKColorFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorStrokeF(f, f2, f3, f4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void resetCMYKColorStroke() {
        checkNoColor();
        super.resetCMYKColorStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        if (this.stencil && !image.isMask()) {
            checkNoColor();
        }
        super.addImage(image, f, f2, f3, f4, f5, f6);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setCMYKColorFill(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorFill(i, i2, i3, i4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorStroke(i, i2, i3, i4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setRGBColorFill(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorFill(i, i2, i3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setRGBColorStroke(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorStroke(i, i2, i3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setColorStroke(BaseColor baseColor) {
        checkNoColor();
        super.setColorStroke(baseColor);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setColorFill(BaseColor baseColor) {
        checkNoColor();
        super.setColorFill(baseColor);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorFill(pdfSpotColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorStroke(pdfSpotColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter, baseColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter, baseColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public final void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter);
    }

    final void checkNoColor() {
        if (this.stencil) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("colors.are.not.allowed.in.uncolored.tile.patterns", new Object[0]));
        }
    }
}
