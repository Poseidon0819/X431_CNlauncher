package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;

/* loaded from: classes.dex */
public final class PdfTextExtractor {
    private PdfTextExtractor() {
    }

    public static String getTextFromPage(PdfReader pdfReader, int i, TextExtractionStrategy textExtractionStrategy) throws IOException {
        return ((TextExtractionStrategy) new PdfReaderContentParser(pdfReader).processContent(i, textExtractionStrategy)).getResultantText();
    }

    public static String getTextFromPage(PdfReader pdfReader, int i) throws IOException {
        return getTextFromPage(pdfReader, i, new LocationTextExtractionStrategy());
    }
}
