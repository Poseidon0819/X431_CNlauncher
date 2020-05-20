package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

/* loaded from: classes.dex */
public class PdfImportedPage extends PdfTemplate {
    int pageNumber;
    PdfReaderInstance readerInstance;
    protected boolean toCopy = true;

    public PdfImportedPage getFromReader() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfImportedPage(PdfReaderInstance pdfReaderInstance, PdfWriter pdfWriter, int i) {
        this.readerInstance = pdfReaderInstance;
        this.pageNumber = i;
        this.writer = pdfWriter;
        this.bBox = pdfReaderInstance.getReader().getPageSize(i);
        setMatrix(1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, -this.bBox.getLeft(), -this.bBox.getBottom());
        this.type = 2;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        throwError();
        return null;
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfStream getFormXObject(int i) throws IOException {
        return this.readerInstance.getFormXObject(this.pageNumber, i);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfObject getResources() {
        return this.readerInstance.getResources(this.pageNumber);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setFontAndSize(BaseFont baseFont, float f) {
        throwError();
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        throwError();
    }

    void throwError() {
        throw new RuntimeException(MessageLocalization.getComposedMessage("content.can.not.be.added.to.a.pdfimportedpage", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfReaderInstance getPdfReaderInstance() {
        return this.readerInstance;
    }

    public boolean isToCopy() {
        return this.toCopy;
    }

    public void setCopied() {
        this.toCopy = false;
    }
}
