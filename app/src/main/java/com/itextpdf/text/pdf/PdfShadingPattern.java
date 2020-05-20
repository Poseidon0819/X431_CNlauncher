package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

/* loaded from: classes.dex */
public class PdfShadingPattern extends PdfDictionary {
    protected float[] matrix = {1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO};
    protected PdfName patternName;
    protected PdfIndirectReference patternReference;
    protected PdfShading shading;
    protected PdfWriter writer;

    public PdfShadingPattern(PdfShading pdfShading) {
        this.writer = pdfShading.getWriter();
        put(PdfName.PATTERNTYPE, new PdfNumber(2));
        this.shading = pdfShading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfName getPatternName() {
        return this.patternName;
    }

    PdfName getShadingName() {
        return this.shading.getShadingName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference getPatternReference() {
        if (this.patternReference == null) {
            this.patternReference = this.writer.getPdfIndirectReference();
        }
        return this.patternReference;
    }

    PdfIndirectReference getShadingReference() {
        return this.shading.getShadingReference();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(int i) {
        this.patternName = new PdfName("P".concat(String.valueOf(i)));
    }

    public void addToBody() throws IOException {
        put(PdfName.SHADING, getShadingReference());
        put(PdfName.MATRIX, new PdfArray(this.matrix));
        this.writer.addToBody(this, getPatternReference());
    }

    public void setMatrix(float[] fArr) {
        if (fArr.length != 6) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("the.matrix.size.must.be.6", new Object[0]));
        }
        this.matrix = fArr;
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public PdfShading getShading() {
        return this.shading;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorDetails getColorDetails() {
        return this.shading.getColorDetails();
    }
}
