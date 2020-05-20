package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfBorderDictionary extends PdfDictionary {
    public static final int STYLE_BEVELED = 2;
    public static final int STYLE_DASHED = 1;
    public static final int STYLE_INSET = 3;
    public static final int STYLE_SOLID = 0;
    public static final int STYLE_UNDERLINE = 4;

    public PdfBorderDictionary(float f, int i, PdfDashPattern pdfDashPattern) {
        put(PdfName.f19791W, new PdfNumber(f));
        switch (i) {
            case 0:
                PdfName pdfName = PdfName.f19767S;
                put(pdfName, pdfName);
                return;
            case 1:
                if (pdfDashPattern != null) {
                    put(PdfName.f19699D, pdfDashPattern);
                }
                put(PdfName.f19767S, PdfName.f19699D);
                return;
            case 2:
                put(PdfName.f19767S, PdfName.f19684B);
                return;
            case 3:
                put(PdfName.f19767S, PdfName.f19729I);
                return;
            case 4:
                put(PdfName.f19767S, PdfName.f19783U);
                return;
            default:
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.border.style", new Object[0]));
        }
    }

    public PdfBorderDictionary(float f, int i) {
        this(f, i, null);
    }
}
