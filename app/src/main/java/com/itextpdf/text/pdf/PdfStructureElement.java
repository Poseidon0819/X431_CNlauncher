package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfStructureElement extends PdfDictionary {
    private PdfStructureElement parent;
    private PdfIndirectReference reference;
    private PdfStructureTreeRoot top;

    public PdfStructureElement(PdfStructureElement pdfStructureElement, PdfName pdfName) {
        this.top = pdfStructureElement.top;
        init(pdfStructureElement, pdfName);
        this.parent = pdfStructureElement;
        put(PdfName.f19752P, pdfStructureElement.reference);
        put(PdfName.TYPE, PdfName.STRUCTELEM);
    }

    public PdfStructureElement(PdfStructureTreeRoot pdfStructureTreeRoot, PdfName pdfName) {
        this.top = pdfStructureTreeRoot;
        init(pdfStructureTreeRoot, pdfName);
        put(PdfName.f19752P, pdfStructureTreeRoot.getReference());
        put(PdfName.TYPE, PdfName.STRUCTELEM);
    }

    private void init(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfArray pdfArray;
        PdfObject pdfObject = pdfDictionary.get(PdfName.f19734K);
        if (pdfObject != null && !pdfObject.isArray()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.parent.has.already.another.function", new Object[0]));
        }
        if (pdfObject == null) {
            pdfArray = new PdfArray();
            pdfDictionary.put(PdfName.f19734K, pdfArray);
        } else {
            pdfArray = (PdfArray) pdfObject;
        }
        pdfArray.add(this);
        put(PdfName.f19767S, pdfName);
        this.reference = this.top.getWriter().getPdfIndirectReference();
    }

    public PdfDictionary getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageMark(int i, int i2) {
        if (i2 >= 0) {
            put(PdfName.f19734K, new PdfNumber(i2));
        }
        this.top.setPageMark(i, this.reference);
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }
}
