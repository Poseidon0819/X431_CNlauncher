package com.itextpdf.text.pdf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PdfResources extends PdfDictionary {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(PdfName pdfName, PdfDictionary pdfDictionary) {
        if (pdfDictionary.size() == 0) {
            return;
        }
        PdfDictionary asDict = getAsDict(pdfName);
        if (asDict == null) {
            put(pdfName, pdfDictionary);
        } else {
            asDict.putAll(pdfDictionary);
        }
    }
}
