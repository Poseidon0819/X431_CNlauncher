package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class PdfReaderContentParser {
    private final PdfReader reader;

    public PdfReaderContentParser(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    public <E extends RenderListener> E processContent(int i, E e) throws IOException {
        new PdfContentStreamProcessor(e).processContent(ContentByteUtils.getContentBytesForPage(this.reader, i), this.reader.getPageN(i).getAsDict(PdfName.RESOURCES));
        return e;
    }
}
