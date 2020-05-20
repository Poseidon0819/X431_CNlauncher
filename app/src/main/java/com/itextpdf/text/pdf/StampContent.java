package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.PdfStamperImp;

/* loaded from: classes.dex */
public class StampContent extends PdfContentByte {
    PageResources pageResources;

    /* renamed from: ps */
    PdfStamperImp.PageStamp f19808ps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StampContent(PdfStamperImp pdfStamperImp, PdfStamperImp.PageStamp pageStamp) {
        super(pdfStamperImp);
        this.f19808ps = pageStamp;
        this.pageResources = pageStamp.pageResources;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        ((PdfStamperImp) this.writer).addAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, pdfAction), this.f19808ps.pageN);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        return new StampContent((PdfStamperImp) this.writer, this.f19808ps);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    PageResources getPageResources() {
        return this.pageResources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        ((PdfStamperImp) this.writer).addAnnotation(pdfAnnotation, this.f19808ps.pageN);
    }
}
