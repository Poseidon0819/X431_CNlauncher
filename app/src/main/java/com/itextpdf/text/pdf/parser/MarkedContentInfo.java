package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;

/* loaded from: classes.dex */
public class MarkedContentInfo {
    private final PdfDictionary dictionary;
    private final PdfName tag;

    public MarkedContentInfo(PdfName pdfName, PdfDictionary pdfDictionary) {
        this.tag = pdfName;
        this.dictionary = pdfDictionary == null ? new PdfDictionary() : pdfDictionary;
    }

    public PdfName getTag() {
        return this.tag;
    }

    public boolean hasMcid() {
        return this.dictionary.contains(PdfName.MCID);
    }

    public int getMcid() {
        PdfNumber asNumber = this.dictionary.getAsNumber(PdfName.MCID);
        if (asNumber == null) {
            throw new IllegalStateException("MarkedContentInfo does not contain MCID");
        }
        return asNumber.intValue();
    }
}
