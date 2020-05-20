package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* loaded from: classes.dex */
public class PdfTargetDictionary extends PdfDictionary {
    public PdfTargetDictionary(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f19760R, PdfName.f19752P);
        if (pdfTargetDictionary != null) {
            setAdditionalPath(pdfTargetDictionary);
        }
    }

    public PdfTargetDictionary(boolean z) {
        if (z) {
            put(PdfName.f19760R, PdfName.f19690C);
        } else {
            put(PdfName.f19760R, PdfName.f19752P);
        }
    }

    public void setEmbeddedFileName(String str) {
        put(PdfName.f19739N, new PdfString(str, null));
    }

    public void setFileAttachmentPagename(String str) {
        put(PdfName.f19752P, new PdfString(str, null));
    }

    public void setFileAttachmentPage(int i) {
        put(PdfName.f19752P, new PdfNumber(i));
    }

    public void setFileAttachmentName(String str) {
        put(PdfName.f19679A, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setFileAttachmentIndex(int i) {
        put(PdfName.f19679A, new PdfNumber(i));
    }

    public void setAdditionalPath(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f19772T, pdfTargetDictionary);
    }
}
