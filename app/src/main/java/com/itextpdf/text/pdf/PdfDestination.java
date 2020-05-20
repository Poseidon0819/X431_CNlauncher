package com.itextpdf.text.pdf;

import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class PdfDestination extends PdfArray {
    public static final int FIT = 1;
    public static final int FITB = 5;
    public static final int FITBH = 6;
    public static final int FITBV = 7;
    public static final int FITH = 2;
    public static final int FITR = 4;
    public static final int FITV = 3;
    public static final int XYZ = 0;
    private boolean status;

    public PdfDestination(int i) {
        this.status = false;
        if (i == 5) {
            add(PdfName.FITB);
        } else {
            add(PdfName.FIT);
        }
    }

    public PdfDestination(int i, float f) {
        super(new PdfNumber(f));
        this.status = false;
        if (i == 3) {
            addFirst(PdfName.FITV);
            return;
        }
        switch (i) {
            case 6:
                addFirst(PdfName.FITBH);
                return;
            case 7:
                addFirst(PdfName.FITBV);
                return;
            default:
                addFirst(PdfName.FITH);
                return;
        }
    }

    public PdfDestination(int i, float f, float f2, float f3) {
        super(PdfName.XYZ);
        this.status = false;
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            add(PdfNull.PDFNULL);
        } else {
            add(new PdfNumber(f));
        }
        if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            add(PdfNull.PDFNULL);
        } else {
            add(new PdfNumber(f2));
        }
        add(new PdfNumber(f3));
    }

    public PdfDestination(int i, float f, float f2, float f3, float f4) {
        super(PdfName.FITR);
        this.status = false;
        add(new PdfNumber(f));
        add(new PdfNumber(f2));
        add(new PdfNumber(f3));
        add(new PdfNumber(f4));
    }

    public PdfDestination(String str) {
        this.status = false;
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        if (stringTokenizer.hasMoreTokens()) {
            add(new PdfName(stringTokenizer.nextToken()));
        }
        while (stringTokenizer.hasMoreTokens()) {
            add(new PdfNumber(stringTokenizer.nextToken()));
        }
    }

    public boolean hasPage() {
        return this.status;
    }

    public boolean addPage(PdfIndirectReference pdfIndirectReference) {
        if (this.status) {
            return false;
        }
        addFirst(pdfIndirectReference);
        this.status = true;
        return true;
    }
}
