package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class PdfDictionary extends PdfObject {
    private PdfName dictionaryType;
    protected HashMap<PdfName, PdfObject> hashMap;
    public static final PdfName FONT = PdfName.FONT;
    public static final PdfName OUTLINES = PdfName.OUTLINES;
    public static final PdfName PAGE = PdfName.PAGE;
    public static final PdfName PAGES = PdfName.PAGES;
    public static final PdfName CATALOG = PdfName.CATALOG;

    public PdfDictionary() {
        super(6);
        this.dictionaryType = null;
        this.hashMap = new HashMap<>();
    }

    public PdfDictionary(PdfName pdfName) {
        this();
        this.dictionaryType = pdfName;
        put(PdfName.TYPE, this.dictionaryType);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(60);
        outputStream.write(60);
        for (Map.Entry<PdfName, PdfObject> entry : this.hashMap.entrySet()) {
            entry.getKey().toPdf(pdfWriter, outputStream);
            PdfObject value = entry.getValue();
            int type = value.type();
            if (type != 5 && type != 6 && type != 4 && type != 3) {
                outputStream.write(32);
            }
            value.toPdf(pdfWriter, outputStream);
        }
        outputStream.write(62);
        outputStream.write(62);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        if (get(PdfName.TYPE) == null) {
            return "Dictionary";
        }
        return "Dictionary of type: " + get(PdfName.TYPE);
    }

    public void put(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.hashMap.remove(pdfName);
        } else {
            this.hashMap.put(pdfName, pdfObject);
        }
    }

    public void putEx(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null) {
            return;
        }
        put(pdfName, pdfObject);
    }

    public void putAll(PdfDictionary pdfDictionary) {
        this.hashMap.putAll(pdfDictionary.hashMap);
    }

    public void remove(PdfName pdfName) {
        this.hashMap.remove(pdfName);
    }

    public void clear() {
        this.hashMap.clear();
    }

    public PdfObject get(PdfName pdfName) {
        return this.hashMap.get(pdfName);
    }

    public PdfObject getDirectObject(PdfName pdfName) {
        return PdfReader.getPdfObject(get(pdfName));
    }

    public Set<PdfName> getKeys() {
        return this.hashMap.keySet();
    }

    public int size() {
        return this.hashMap.size();
    }

    public boolean contains(PdfName pdfName) {
        return this.hashMap.containsKey(pdfName);
    }

    public boolean isFont() {
        return FONT.equals(this.dictionaryType);
    }

    public boolean isPage() {
        return PAGE.equals(this.dictionaryType);
    }

    public boolean isPages() {
        return PAGES.equals(this.dictionaryType);
    }

    public boolean isCatalog() {
        return CATALOG.equals(this.dictionaryType);
    }

    public boolean isOutlineTree() {
        return OUTLINES.equals(this.dictionaryType);
    }

    public void merge(PdfDictionary pdfDictionary) {
        this.hashMap.putAll(pdfDictionary.hashMap);
    }

    public void mergeDifferent(PdfDictionary pdfDictionary) {
        for (PdfName pdfName : pdfDictionary.hashMap.keySet()) {
            if (!this.hashMap.containsKey(pdfName)) {
                this.hashMap.put(pdfName, pdfDictionary.hashMap.get(pdfName));
            }
        }
    }

    public PdfDictionary getAsDict(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isDictionary()) {
            return null;
        }
        return (PdfDictionary) directObject;
    }

    public PdfArray getAsArray(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isArray()) {
            return null;
        }
        return (PdfArray) directObject;
    }

    public PdfStream getAsStream(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isStream()) {
            return null;
        }
        return (PdfStream) directObject;
    }

    public PdfString getAsString(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isString()) {
            return null;
        }
        return (PdfString) directObject;
    }

    public PdfNumber getAsNumber(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isNumber()) {
            return null;
        }
        return (PdfNumber) directObject;
    }

    public PdfName getAsName(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isName()) {
            return null;
        }
        return (PdfName) directObject;
    }

    public PdfBoolean getAsBoolean(PdfName pdfName) {
        PdfObject directObject = getDirectObject(pdfName);
        if (directObject == null || !directObject.isBoolean()) {
            return null;
        }
        return (PdfBoolean) directObject;
    }

    public PdfIndirectReference getAsIndirectObject(PdfName pdfName) {
        PdfObject pdfObject = get(pdfName);
        if (pdfObject == null || !pdfObject.isIndirect()) {
            return null;
        }
        return (PdfIndirectReference) pdfObject;
    }
}
