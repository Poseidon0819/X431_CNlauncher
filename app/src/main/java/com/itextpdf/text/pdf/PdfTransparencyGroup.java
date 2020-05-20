package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfTransparencyGroup extends PdfDictionary {
    public PdfTransparencyGroup() {
        put(PdfName.f19767S, PdfName.TRANSPARENCY);
    }

    public void setIsolated(boolean z) {
        if (z) {
            put(PdfName.f19729I, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f19729I);
        }
    }

    public void setKnockout(boolean z) {
        if (z) {
            put(PdfName.f19734K, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f19734K);
        }
    }
}
