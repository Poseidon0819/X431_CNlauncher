package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class PdfArray extends PdfObject implements Iterable<PdfObject> {
    protected ArrayList<PdfObject> arrayList;

    public PdfArray() {
        super(5);
        this.arrayList = new ArrayList<>();
    }

    public PdfArray(PdfObject pdfObject) {
        super(5);
        this.arrayList = new ArrayList<>();
        this.arrayList.add(pdfObject);
    }

    public PdfArray(float[] fArr) {
        super(5);
        this.arrayList = new ArrayList<>();
        add(fArr);
    }

    public PdfArray(int[] iArr) {
        super(5);
        this.arrayList = new ArrayList<>();
        add(iArr);
    }

    public PdfArray(List<PdfObject> list) {
        this();
        for (PdfObject pdfObject : list) {
            add(pdfObject);
        }
    }

    public PdfArray(PdfArray pdfArray) {
        super(5);
        this.arrayList = new ArrayList<>(pdfArray.arrayList);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(91);
        Iterator<PdfObject> it = this.arrayList.iterator();
        if (it.hasNext()) {
            PdfObject next = it.next();
            if (next == null) {
                next = PdfNull.PDFNULL;
            }
            next.toPdf(pdfWriter, outputStream);
        }
        while (it.hasNext()) {
            PdfObject next2 = it.next();
            if (next2 == null) {
                next2 = PdfNull.PDFNULL;
            }
            int type = next2.type();
            if (type != 5 && type != 6 && type != 4 && type != 3) {
                outputStream.write(32);
            }
            next2.toPdf(pdfWriter, outputStream);
        }
        outputStream.write(93);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return this.arrayList.toString();
    }

    public PdfObject set(int i, PdfObject pdfObject) {
        return this.arrayList.set(i, pdfObject);
    }

    public PdfObject remove(int i) {
        return this.arrayList.remove(i);
    }

    @Deprecated
    public ArrayList<PdfObject> getArrayList() {
        return this.arrayList;
    }

    public int size() {
        return this.arrayList.size();
    }

    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    public boolean add(PdfObject pdfObject) {
        return this.arrayList.add(pdfObject);
    }

    public boolean add(float[] fArr) {
        for (float f : fArr) {
            this.arrayList.add(new PdfNumber(f));
        }
        return true;
    }

    public boolean add(int[] iArr) {
        for (int i : iArr) {
            this.arrayList.add(new PdfNumber(i));
        }
        return true;
    }

    public void add(int i, PdfObject pdfObject) {
        this.arrayList.add(i, pdfObject);
    }

    public void addFirst(PdfObject pdfObject) {
        this.arrayList.add(0, pdfObject);
    }

    public boolean contains(PdfObject pdfObject) {
        return this.arrayList.contains(pdfObject);
    }

    public ListIterator<PdfObject> listIterator() {
        return this.arrayList.listIterator();
    }

    public PdfObject getPdfObject(int i) {
        return this.arrayList.get(i);
    }

    public PdfObject getDirectObject(int i) {
        return PdfReader.getPdfObject(getPdfObject(i));
    }

    public PdfDictionary getAsDict(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isDictionary()) {
            return null;
        }
        return (PdfDictionary) directObject;
    }

    public PdfArray getAsArray(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isArray()) {
            return null;
        }
        return (PdfArray) directObject;
    }

    public PdfStream getAsStream(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isStream()) {
            return null;
        }
        return (PdfStream) directObject;
    }

    public PdfString getAsString(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isString()) {
            return null;
        }
        return (PdfString) directObject;
    }

    public PdfNumber getAsNumber(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isNumber()) {
            return null;
        }
        return (PdfNumber) directObject;
    }

    public PdfName getAsName(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isName()) {
            return null;
        }
        return (PdfName) directObject;
    }

    public PdfBoolean getAsBoolean(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isBoolean()) {
            return null;
        }
        return (PdfBoolean) directObject;
    }

    public PdfIndirectReference getAsIndirectObject(int i) {
        PdfObject pdfObject = getPdfObject(i);
        if (pdfObject == null || !pdfObject.isIndirect()) {
            return null;
        }
        return (PdfIndirectReference) pdfObject;
    }

    @Override // java.lang.Iterable
    public Iterator<PdfObject> iterator() {
        return this.arrayList.iterator();
    }
}
