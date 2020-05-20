package com.itextpdf.text.pdf;

import java.io.IOException;

/* loaded from: classes.dex */
public class PdfRendition extends PdfDictionary {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfRendition(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        put(PdfName.f19767S, new PdfName("MR"));
        put(PdfName.f19739N, new PdfString("Rendition for ".concat(String.valueOf(str))));
        put(PdfName.f19690C, new PdfMediaClipData(str, pdfFileSpecification, str2));
    }
}
