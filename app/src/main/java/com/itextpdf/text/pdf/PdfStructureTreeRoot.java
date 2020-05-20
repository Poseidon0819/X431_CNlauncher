package com.itextpdf.text.pdf;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PdfStructureTreeRoot extends PdfDictionary {
    private HashMap<Integer, PdfObject> parentTree;
    private PdfIndirectReference reference;
    private PdfWriter writer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfStructureTreeRoot(PdfWriter pdfWriter) {
        super(PdfName.STRUCTTREEROOT);
        this.parentTree = new HashMap<>();
        this.writer = pdfWriter;
        this.reference = pdfWriter.getPdfIndirectReference();
    }

    public void mapRole(PdfName pdfName, PdfName pdfName2) {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.ROLEMAP);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            put(PdfName.ROLEMAP, pdfDictionary);
        }
        pdfDictionary.put(pdfName, pdfName2);
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageMark(int i, PdfIndirectReference pdfIndirectReference) {
        Integer valueOf = Integer.valueOf(i);
        PdfArray pdfArray = (PdfArray) this.parentTree.get(valueOf);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            this.parentTree.put(valueOf, pdfArray);
        }
        pdfArray.add(pdfIndirectReference);
    }

    private void nodeProcess(PdfDictionary pdfDictionary, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfObject pdfObject = pdfDictionary.get(PdfName.f19734K);
        if (pdfObject != null && pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            if (!pdfArray.getPdfObject(0).isNumber()) {
                for (int i = 0; i < pdfArray.size(); i++) {
                    PdfStructureElement pdfStructureElement = (PdfStructureElement) pdfArray.getAsDict(i);
                    pdfArray.set(i, pdfStructureElement.getReference());
                    nodeProcess(pdfStructureElement, pdfStructureElement.getReference());
                }
            }
        }
        if (pdfIndirectReference != null) {
            this.writer.addToBody(pdfDictionary, pdfIndirectReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildTree() throws IOException {
        HashMap hashMap = new HashMap();
        for (Integer num : this.parentTree.keySet()) {
            hashMap.put(num, this.writer.addToBody((PdfArray) this.parentTree.get(num)).getIndirectReference());
        }
        PdfDictionary writeTree = PdfNumberTree.writeTree(hashMap, this.writer);
        if (writeTree != null) {
            put(PdfName.PARENTTREE, this.writer.addToBody(writeTree).getIndirectReference());
        }
        nodeProcess(this, this.reference);
    }
}
