package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PdfPages {
    private PdfIndirectReference topParent;
    private PdfWriter writer;
    private ArrayList<PdfIndirectReference> pages = new ArrayList<>();
    private ArrayList<PdfIndirectReference> parents = new ArrayList<>();
    private int leafSize = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPages(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPage(PdfDictionary pdfDictionary) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            pdfDictionary.put(PdfName.PARENT, this.parents.get(this.parents.size() - 1));
            PdfIndirectReference currentPage = this.writer.getCurrentPage();
            this.writer.addToBody(pdfDictionary, currentPage);
            this.pages.add(currentPage);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference addPageRef(PdfIndirectReference pdfIndirectReference) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            this.pages.add(pdfIndirectReference);
            return this.parents.get(this.parents.size() - 1);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference writePageTree() throws IOException {
        int i;
        int i2;
        if (this.pages.isEmpty()) {
            throw new IOException(MessageLocalization.getComposedMessage("the.document.has.no.pages", new Object[0]));
        }
        ArrayList<PdfIndirectReference> arrayList = this.parents;
        ArrayList<PdfIndirectReference> arrayList2 = this.pages;
        ArrayList<PdfIndirectReference> arrayList3 = new ArrayList<>();
        ArrayList<PdfIndirectReference> arrayList4 = arrayList;
        int i3 = 1;
        while (true) {
            int i4 = this.leafSize;
            i3 *= i4;
            int size = arrayList2.size();
            int i5 = this.leafSize;
            int i6 = size % i5;
            if (i6 == 0) {
                i6 = i5;
            }
            for (int i7 = 0; i7 < arrayList4.size(); i7++) {
                if (i7 == arrayList4.size() - 1) {
                    i = this.pages.size() % i3;
                    if (i == 0) {
                        i = i3;
                        i2 = i6;
                    } else {
                        i2 = i6;
                    }
                } else {
                    i = i3;
                    i2 = i4;
                }
                PdfDictionary pdfDictionary = new PdfDictionary(PdfName.PAGES);
                pdfDictionary.put(PdfName.COUNT, new PdfNumber(i));
                PdfArray pdfArray = new PdfArray();
                int i8 = i7 * i4;
                pdfArray.getArrayList().addAll(arrayList2.subList(i8, i2 + i8));
                pdfDictionary.put(PdfName.KIDS, pdfArray);
                if (arrayList4.size() > 1) {
                    if (i7 % this.leafSize == 0) {
                        arrayList3.add(this.writer.getPdfIndirectReference());
                    }
                    pdfDictionary.put(PdfName.PARENT, arrayList3.get(i7 / this.leafSize));
                }
                this.writer.addToBody(pdfDictionary, arrayList4.get(i7));
            }
            if (arrayList4.size() == 1) {
                this.topParent = arrayList4.get(0);
                return this.topParent;
            }
            ArrayList<PdfIndirectReference> arrayList5 = arrayList3;
            arrayList3 = new ArrayList<>();
            arrayList2 = arrayList4;
            arrayList4 = arrayList5;
        }
    }

    PdfIndirectReference getTopParent() {
        return this.topParent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLinearMode(PdfIndirectReference pdfIndirectReference) {
        if (this.parents.size() > 1) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("linear.page.mode.can.only.be.called.with.a.single.parent", new Object[0]));
        }
        if (pdfIndirectReference != null) {
            this.topParent = pdfIndirectReference;
            this.parents.clear();
            this.parents.add(pdfIndirectReference);
        }
        this.leafSize = 10000000;
    }

    void addPage(PdfIndirectReference pdfIndirectReference) {
        this.pages.add(pdfIndirectReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int reorderPages(int[] iArr) throws DocumentException {
        if (iArr == null) {
            return this.pages.size();
        }
        if (this.parents.size() > 1) {
            throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.a.single.parent.in.the.page.tree.call.pdfwriter.setlinearmode.after.open", new Object[0]));
        }
        if (iArr.length != this.pages.size()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.an.array.with.the.same.size.as.the.number.of.pages", new Object[0]));
        }
        int size = this.pages.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            int i2 = iArr[i];
            if (i2 <= 0 || i2 > size) {
                throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.pages.between.1.and.1.found.2", String.valueOf(size), String.valueOf(i2)));
            }
            int i3 = i2 - 1;
            if (zArr[i3]) {
                throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.no.page.repetition.page.1.is.repeated", i2));
            }
            zArr[i3] = true;
        }
        ArrayList<PdfIndirectReference> arrayList = this.pages;
        PdfIndirectReference[] pdfIndirectReferenceArr = (PdfIndirectReference[]) arrayList.toArray(new PdfIndirectReference[arrayList.size()]);
        for (int i4 = 0; i4 < size; i4++) {
            this.pages.set(i4, pdfIndirectReferenceArr[iArr[i4] - 1]);
        }
        return size;
    }
}
