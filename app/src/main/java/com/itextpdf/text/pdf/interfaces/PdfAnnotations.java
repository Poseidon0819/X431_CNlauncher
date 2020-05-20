package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfFormField;

/* loaded from: classes.dex */
public interface PdfAnnotations {
    void addAnnotation(PdfAnnotation pdfAnnotation);

    void addCalculationOrder(PdfFormField pdfFormField);

    PdfAcroForm getAcroForm();

    void setSigFlags(int i);
}
