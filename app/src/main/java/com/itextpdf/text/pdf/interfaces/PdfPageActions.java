package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfTransition;

/* loaded from: classes.dex */
public interface PdfPageActions {
    void setDuration(int i);

    void setPageAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException;

    void setTransition(PdfTransition pdfTransition);
}
