package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;

/* loaded from: classes.dex */
public interface PdfDocumentActions {
    void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException;

    void setOpenAction(PdfAction pdfAction);

    void setOpenAction(String str);
}
