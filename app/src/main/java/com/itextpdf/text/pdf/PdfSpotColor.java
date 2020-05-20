package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfSpotColor {
    public BaseColor altcs;
    public PdfName name;

    public PdfSpotColor(String str, BaseColor baseColor) {
        this.name = new PdfName(str);
        this.altcs = baseColor;
    }

    public BaseColor getAlternativeCS() {
        return this.altcs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfObject getSpotObject(PdfWriter pdfWriter) {
        PdfFunction type2;
        PdfArray pdfArray = new PdfArray(PdfName.SEPARATION);
        pdfArray.add(this.name);
        BaseColor baseColor = this.altcs;
        if (baseColor instanceof ExtendedColor) {
            switch (((ExtendedColor) baseColor).type) {
                case 1:
                    pdfArray.add(PdfName.DEVICEGRAY);
                    type2 = PdfFunction.type2(pdfWriter, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f}, null, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO}, new float[]{((GrayColor) this.altcs).getGray()}, 1.0f);
                    break;
                case 2:
                    pdfArray.add(PdfName.DEVICECMYK);
                    CMYKColor cMYKColor = (CMYKColor) this.altcs;
                    type2 = PdfFunction.type2(pdfWriter, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f}, null, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO}, new float[]{cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack()}, 1.0f);
                    break;
                default:
                    throw new RuntimeException(MessageLocalization.getComposedMessage("only.rgb.gray.and.cmyk.are.supported.as.alternative.color.spaces", new Object[0]));
            }
        } else {
            pdfArray.add(PdfName.DEVICERGB);
            type2 = PdfFunction.type2(pdfWriter, new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f}, null, new float[]{1.0f, 1.0f, 1.0f}, new float[]{this.altcs.getRed() / 255.0f, this.altcs.getGreen() / 255.0f, this.altcs.getBlue() / 255.0f}, 1.0f);
        }
        pdfArray.add(type2.getReference());
        return pdfArray;
    }
}
