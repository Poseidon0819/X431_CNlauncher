package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfVisibilityExpression extends PdfArray {
    public static final int AND = 1;
    public static final int NOT = -1;

    /* renamed from: OR */
    public static final int f19804OR = 0;

    public PdfVisibilityExpression(int i) {
        switch (i) {
            case -1:
                super.add(PdfName.NOT);
                return;
            case 0:
                super.add(PdfName.f19751OR);
                return;
            case 1:
                super.add(PdfName.AND);
                return;
            default:
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
        }
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public void add(int i, PdfObject pdfObject) {
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(PdfObject pdfObject) {
        if (pdfObject instanceof PdfLayer) {
            return super.add(((PdfLayer) pdfObject).getRef());
        }
        if (pdfObject instanceof PdfVisibilityExpression) {
            return super.add(pdfObject);
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public void addFirst(PdfObject pdfObject) {
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(float[] fArr) {
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(int[] iArr) {
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.ve.value", new Object[0]));
    }
}
