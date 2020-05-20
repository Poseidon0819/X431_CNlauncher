package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

/* loaded from: classes.dex */
public class PdfCollectionSort extends PdfDictionary {
    public PdfCollectionSort(String str) {
        super(PdfName.COLLECTIONSORT);
        put(PdfName.f19767S, new PdfName(str));
    }

    public PdfCollectionSort(String[] strArr) {
        super(PdfName.COLLECTIONSORT);
        PdfArray pdfArray = new PdfArray();
        for (String str : strArr) {
            pdfArray.add(new PdfName(str));
        }
        put(PdfName.f19767S, pdfArray);
    }

    public void setSortOrder(boolean z) {
        if (get(PdfName.f19767S) instanceof PdfName) {
            put(PdfName.f19679A, new PdfBoolean(z));
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.have.to.define.a.boolean.array.for.this.collection.sort.dictionary", new Object[0]));
    }

    public void setSortOrder(boolean[] zArr) {
        PdfObject pdfObject = get(PdfName.f19767S);
        if (pdfObject instanceof PdfArray) {
            if (((PdfArray) pdfObject).size() != zArr.length) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.booleans.in.this.array.doesn.t.correspond.with.the.number.of.fields", new Object[0]));
            }
            PdfArray pdfArray = new PdfArray();
            for (boolean z : zArr) {
                pdfArray.add(new PdfBoolean(z));
            }
            put(PdfName.f19679A, pdfArray);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.need.a.single.boolean.for.this.collection.sort.dictionary", new Object[0]));
    }
}
