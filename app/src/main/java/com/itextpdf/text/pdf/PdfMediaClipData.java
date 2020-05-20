package com.itextpdf.text.pdf;

import java.io.IOException;

/* loaded from: classes.dex */
public class PdfMediaClipData extends PdfDictionary {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfMediaClipData(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        put(PdfName.TYPE, new PdfName("MediaClip"));
        put(PdfName.f19767S, new PdfName("MCD"));
        put(PdfName.f19739N, new PdfString("Media clip for ".concat(String.valueOf(str))));
        put(new PdfName("CT"), new PdfString(str2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(new PdfName("TF"), new PdfString("TEMPACCESS"));
        put(new PdfName("P"), pdfDictionary);
        put(PdfName.f19699D, pdfFileSpecification.getReference());
    }
}
