package com.itextpdf.text.api;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

/* loaded from: classes.dex */
public interface WriterOperation {
    void write(PdfWriter pdfWriter, Document document) throws DocumentException;
}
