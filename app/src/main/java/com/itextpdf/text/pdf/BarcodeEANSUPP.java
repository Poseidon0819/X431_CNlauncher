package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.awt.Color;
import java.awt.Image;

/* loaded from: classes.dex */
public class BarcodeEANSUPP extends Barcode {
    protected Barcode ean;
    protected Barcode supp;

    public BarcodeEANSUPP(Barcode barcode, Barcode barcode2) {
        this.f19647n = 8.0f;
        this.ean = barcode;
        this.supp = barcode2;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        barcodeSize.setRight(barcodeSize.getWidth() + this.supp.getBarcodeSize().getWidth() + this.f19647n);
        return barcodeSize;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        if (this.supp.getFont() != null) {
            this.supp.setBarHeight((this.ean.getBarHeight() + this.supp.getBaseline()) - this.supp.getFont().getFontDescriptor(2, this.supp.getSize()));
        } else {
            this.supp.setBarHeight(this.ean.getBarHeight());
        }
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        pdfContentByte.saveState();
        this.ean.placeBarcode(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.concatCTM(1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, barcodeSize.getWidth() + this.f19647n, barcodeSize.getHeight() - this.ean.getBarHeight());
        this.supp.placeBarcode(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.restoreState();
        return getBarcodeSize();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Image createAwtImage(Color color, Color color2) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("the.two.barcodes.must.be.composed.externally", new Object[0]));
    }
}
