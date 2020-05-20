package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;

/* loaded from: classes.dex */
public class InlineImageInfo {
    private final PdfDictionary imageDictionary;
    private final byte[] samples;

    public InlineImageInfo(byte[] bArr, PdfDictionary pdfDictionary) {
        this.samples = bArr;
        this.imageDictionary = pdfDictionary;
    }

    public PdfDictionary getImageDictionary() {
        return this.imageDictionary;
    }

    public byte[] getSamples() {
        return this.samples;
    }
}
