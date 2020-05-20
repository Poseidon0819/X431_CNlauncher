package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ExtendedColor;
import com.itextpdf.text.pdf.PatternColor;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfXConformanceException;
import com.itextpdf.text.pdf.ShadingColor;
import com.itextpdf.text.pdf.SpotColor;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;

/* loaded from: classes.dex */
public class PdfXConformanceImp implements PdfXConformance {
    protected int pdfxConformance = 0;

    @Override // com.itextpdf.text.pdf.interfaces.PdfXConformance
    public void setPDFXConformance(int i) {
        this.pdfxConformance = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfXConformance
    public int getPDFXConformance() {
        return this.pdfxConformance;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfIsoConformance
    public boolean isPdfIso() {
        return isPdfX();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfXConformance
    public boolean isPdfX() {
        return this.pdfxConformance != 0;
    }

    public boolean isPdfX1A2001() {
        return this.pdfxConformance == 1;
    }

    public boolean isPdfX32002() {
        return this.pdfxConformance == 2;
    }

    public static void checkPDFXConformance(PdfWriter pdfWriter, int i, Object obj) {
        PdfObject pdfObject;
        while (pdfWriter != null && pdfWriter.isPdfX()) {
            int pDFXConformance = pdfWriter.getPDFXConformance();
            switch (i) {
                case 1:
                    if (pDFXConformance != 1) {
                        return;
                    }
                    if (obj instanceof ExtendedColor) {
                        ExtendedColor extendedColor = (ExtendedColor) obj;
                        switch (extendedColor.getType()) {
                            case 0:
                                throw new PdfXConformanceException(MessageLocalization.getComposedMessage("colorspace.rgb.is.not.allowed", new Object[0]));
                            case 1:
                            case 2:
                                return;
                            case 3:
                                obj = ((SpotColor) extendedColor).getPdfSpotColor().getAlternativeCS();
                                i = 1;
                                break;
                            case 4:
                                obj = ((PatternColor) extendedColor).getPainter().getDefaultColor();
                                i = 1;
                                break;
                            case 5:
                                obj = ((ShadingColor) extendedColor).getPdfShadingPattern().getShading().getColorSpace();
                                i = 1;
                                break;
                            default:
                                return;
                        }
                    } else if (obj instanceof BaseColor) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("colorspace.rgb.is.not.allowed", new Object[0]));
                    } else {
                        return;
                    }
                case 2:
                    return;
                case 3:
                    if (pDFXConformance == 1) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("colorspace.rgb.is.not.allowed", new Object[0]));
                    }
                    return;
                case 4:
                    BaseFont baseFont = (BaseFont) obj;
                    if (!baseFont.isEmbedded()) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("all.the.fonts.must.be.embedded.this.one.isn.t.1", baseFont.getPostscriptFontName()));
                    }
                    return;
                case 5:
                    PdfImage pdfImage = (PdfImage) obj;
                    if (pdfImage.get(PdfName.SMASK) != null) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("the.smask.key.is.not.allowed.in.images", new Object[0]));
                    }
                    if (pDFXConformance == 1 && (pdfObject = pdfImage.get(PdfName.COLORSPACE)) != null) {
                        if (pdfObject.isName()) {
                            if (PdfName.DEVICERGB.equals(pdfObject)) {
                                throw new PdfXConformanceException(MessageLocalization.getComposedMessage("colorspace.rgb.is.not.allowed", new Object[0]));
                            }
                            return;
                        } else if (pdfObject.isArray() && PdfName.CALRGB.equals(((PdfArray) pdfObject).getPdfObject(0))) {
                            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("colorspace.calrgb.is.not.allowed", new Object[0]));
                        } else {
                            return;
                        }
                    }
                    return;
                case 6:
                    PdfDictionary pdfDictionary = (PdfDictionary) obj;
                    PdfObject pdfObject2 = pdfDictionary.get(PdfName.f19688BM);
                    if (pdfObject2 != null && !PdfGState.BM_NORMAL.equals(pdfObject2) && !PdfGState.BM_COMPATIBLE.equals(pdfObject2)) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("blend.mode.1.not.allowed", pdfObject2.toString()));
                    }
                    PdfObject pdfObject3 = pdfDictionary.get(PdfName.f19693CA);
                    if (pdfObject3 != null) {
                        double doubleValue = ((PdfNumber) pdfObject3).doubleValue();
                        if (doubleValue != 1.0d) {
                            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("transparency.is.not.allowed.ca.eq.1", String.valueOf(doubleValue)));
                        }
                    }
                    PdfObject pdfObject4 = pdfDictionary.get(PdfName.f19799ca);
                    if (pdfObject4 != null) {
                        double doubleValue2 = ((PdfNumber) pdfObject4).doubleValue();
                        if (doubleValue2 != 1.0d) {
                            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("transparency.is.not.allowed.ca.eq.1", String.valueOf(doubleValue2)));
                        }
                        return;
                    }
                    return;
                case 7:
                    throw new PdfXConformanceException(MessageLocalization.getComposedMessage("layers.are.not.allowed", new Object[0]));
                default:
                    return;
            }
        }
    }
}
