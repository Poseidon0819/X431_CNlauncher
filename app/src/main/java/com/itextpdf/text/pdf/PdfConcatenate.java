package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PdfConcatenate {
    protected PdfCopy copy;
    protected Document document;

    public PdfConcatenate(OutputStream outputStream) throws DocumentException {
        this(outputStream, false);
    }

    public PdfConcatenate(OutputStream outputStream, boolean z) throws DocumentException {
        this.document = new Document();
        if (z) {
            this.copy = new PdfSmartCopy(this.document, outputStream);
        } else {
            this.copy = new PdfCopy(this.document, outputStream);
        }
    }

    public int addPages(PdfReader pdfReader) throws DocumentException, IOException {
        open();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            PdfCopy pdfCopy = this.copy;
            pdfCopy.addPage(pdfCopy.getImportedPage(pdfReader, i));
        }
        this.copy.freeReader(pdfReader);
        return numberOfPages;
    }

    public PdfCopy getWriter() {
        return this.copy;
    }

    public void open() {
        if (this.document.isOpen()) {
            return;
        }
        this.document.open();
    }

    public void close() {
        this.document.close();
    }
}
