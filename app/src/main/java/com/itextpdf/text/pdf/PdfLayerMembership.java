package com.itextpdf.text.pdf;

import java.util.Collection;
import java.util.HashSet;

/* loaded from: classes.dex */
public class PdfLayerMembership extends PdfDictionary implements PdfOCG {
    HashSet<PdfLayer> layers;
    PdfArray members;
    PdfIndirectReference ref;
    public static final PdfName ALLON = new PdfName("AllOn");
    public static final PdfName ANYON = new PdfName("AnyOn");
    public static final PdfName ANYOFF = new PdfName("AnyOff");
    public static final PdfName ALLOFF = new PdfName("AllOff");

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfObject getPdfObject() {
        return this;
    }

    public PdfLayerMembership(PdfWriter pdfWriter) {
        super(PdfName.OCMD);
        this.members = new PdfArray();
        this.layers = new HashSet<>();
        put(PdfName.OCGS, this.members);
        this.ref = pdfWriter.getPdfIndirectReference();
    }

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfIndirectReference getRef() {
        return this.ref;
    }

    public void addMember(PdfLayer pdfLayer) {
        if (this.layers.contains(pdfLayer)) {
            return;
        }
        this.members.add(pdfLayer.getRef());
        this.layers.add(pdfLayer);
    }

    public Collection<PdfLayer> getLayers() {
        return this.layers;
    }

    public void setVisibilityPolicy(PdfName pdfName) {
        put(PdfName.f19752P, pdfName);
    }

    public void setVisibilityExpression(PdfVisibilityExpression pdfVisibilityExpression) {
        put(PdfName.f19789VE, pdfVisibilityExpression);
    }
}
