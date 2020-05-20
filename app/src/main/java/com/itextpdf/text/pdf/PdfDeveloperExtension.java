package com.itextpdf.text.pdf;

/* loaded from: classes.dex */
public class PdfDeveloperExtension {
    public static final PdfDeveloperExtension ADOBE_1_7_EXTENSIONLEVEL3 = new PdfDeveloperExtension(PdfName.ADBE, PdfWriter.PDF_VERSION_1_7, 3);
    protected PdfName baseversion;
    protected int extensionLevel;
    protected PdfName prefix;

    public PdfDeveloperExtension(PdfName pdfName, PdfName pdfName2, int i) {
        this.prefix = pdfName;
        this.baseversion = pdfName2;
        this.extensionLevel = i;
    }

    public PdfName getPrefix() {
        return this.prefix;
    }

    public PdfName getBaseversion() {
        return this.baseversion;
    }

    public int getExtensionLevel() {
        return this.extensionLevel;
    }

    public PdfDictionary getDeveloperExtensions() {
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.BASEVERSION, this.baseversion);
        pdfDictionary.put(PdfName.EXTENSIONLEVEL, new PdfNumber(this.extensionLevel));
        return pdfDictionary;
    }
}
