package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import java.io.IOException;

/* loaded from: classes.dex */
public class PdfTemplate extends PdfContentByte {
    public static final int TYPE_IMPORTED = 2;
    public static final int TYPE_PATTERN = 3;
    public static final int TYPE_TEMPLATE = 1;
    private PdfDictionary additional;
    protected Rectangle bBox;
    protected PdfTransparencyGroup group;
    protected PdfOCG layer;
    protected PdfArray matrix;
    protected PageResources pageResources;
    protected PdfIndirectReference thisReference;
    protected int type;

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfTemplate() {
        super(null);
        this.bBox = new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.additional = null;
        this.type = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfTemplate(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.bBox = new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.additional = null;
        this.type = 1;
        this.pageResources = new PageResources();
        this.pageResources.addDefaultColor(pdfWriter.getDefaultColorspace());
        this.thisReference = this.writer.getPdfIndirectReference();
    }

    public static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2) {
        return createTemplate(pdfWriter, f, f2, null);
    }

    static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfTemplate pdfTemplate = new PdfTemplate(pdfWriter);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public void setWidth(float f) {
        this.bBox.setLeft(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.bBox.setRight(f);
    }

    public void setHeight(float f) {
        this.bBox.setBottom(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.bBox.setTop(f);
    }

    public float getWidth() {
        return this.bBox.getWidth();
    }

    public float getHeight() {
        return this.bBox.getHeight();
    }

    public Rectangle getBoundingBox() {
        return this.bBox;
    }

    public void setBoundingBox(Rectangle rectangle) {
        this.bBox = rectangle;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public void setMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        this.matrix = new PdfArray();
        this.matrix.add(new PdfNumber(f));
        this.matrix.add(new PdfNumber(f2));
        this.matrix.add(new PdfNumber(f3));
        this.matrix.add(new PdfNumber(f4));
        this.matrix.add(new PdfNumber(f5));
        this.matrix.add(new PdfNumber(f6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfArray getMatrix() {
        return this.matrix;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.thisReference == null) {
            this.thisReference = this.writer.getPdfIndirectReference();
        }
        return this.thisReference;
    }

    public void beginVariableText() {
        this.content.append("/Tx BMC ");
    }

    public void endVariableText() {
        this.content.append("EMC ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfObject getResources() {
        return getPageResources().getResources();
    }

    public PdfStream getFormXObject(int i) throws IOException {
        return new PdfFormXObject(this, i);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfTemplate pdfTemplate = new PdfTemplate();
        pdfTemplate.writer = this.writer;
        pdfTemplate.pdf = this.pdf;
        pdfTemplate.thisReference = this.thisReference;
        pdfTemplate.pageResources = this.pageResources;
        pdfTemplate.bBox = new Rectangle(this.bBox);
        pdfTemplate.group = this.group;
        pdfTemplate.layer = this.layer;
        PdfArray pdfArray = this.matrix;
        if (pdfArray != null) {
            pdfTemplate.matrix = new PdfArray(pdfArray);
        }
        pdfTemplate.separator = this.separator;
        pdfTemplate.additional = this.additional;
        return pdfTemplate;
    }

    public int getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PageResources getPageResources() {
        return this.pageResources;
    }

    public PdfTransparencyGroup getGroup() {
        return this.group;
    }

    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        this.group = pdfTransparencyGroup;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }
}
