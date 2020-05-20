package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

/* loaded from: classes.dex */
public interface PdfPageEvent {
    void onChapter(PdfWriter pdfWriter, Document document, float f, Paragraph paragraph);

    void onChapterEnd(PdfWriter pdfWriter, Document document, float f);

    void onCloseDocument(PdfWriter pdfWriter, Document document);

    void onEndPage(PdfWriter pdfWriter, Document document);

    void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str);

    void onOpenDocument(PdfWriter pdfWriter, Document document);

    void onParagraph(PdfWriter pdfWriter, Document document, float f);

    void onParagraphEnd(PdfWriter pdfWriter, Document document, float f);

    void onSection(PdfWriter pdfWriter, Document document, float f, int i, Paragraph paragraph);

    void onSectionEnd(PdfWriter pdfWriter, Document document, float f);

    void onStartPage(PdfWriter pdfWriter, Document document);
}
