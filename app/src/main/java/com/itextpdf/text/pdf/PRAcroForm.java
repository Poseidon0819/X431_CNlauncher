package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class PRAcroForm extends PdfDictionary {
    PdfReader reader;
    ArrayList<FieldInformation> fields = new ArrayList<>();
    HashMap<String, FieldInformation> fieldByName = new HashMap<>();
    ArrayList<PdfDictionary> stack = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class FieldInformation {
        String fieldName;
        PdfDictionary info;
        PRIndirectReference ref;

        FieldInformation(String str, PdfDictionary pdfDictionary, PRIndirectReference pRIndirectReference) {
            this.fieldName = str;
            this.info = pdfDictionary;
            this.ref = pRIndirectReference;
        }

        public String getWidgetName() {
            PdfObject pdfObject = this.info.get(PdfName.f19745NM);
            if (pdfObject != null) {
                return pdfObject.toString();
            }
            return null;
        }

        public String getName() {
            return this.fieldName;
        }

        public PdfDictionary getInfo() {
            return this.info;
        }

        public PRIndirectReference getRef() {
            return this.ref;
        }
    }

    public PRAcroForm(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary
    public int size() {
        return this.fields.size();
    }

    public ArrayList<FieldInformation> getFields() {
        return this.fields;
    }

    public FieldInformation getField(String str) {
        return this.fieldByName.get(str);
    }

    public PRIndirectReference getRefByName(String str) {
        FieldInformation fieldInformation = this.fieldByName.get(str);
        if (fieldInformation == null) {
            return null;
        }
        return fieldInformation.getRef();
    }

    public void readAcroForm(PdfDictionary pdfDictionary) {
        if (pdfDictionary == null) {
            return;
        }
        this.hashMap = pdfDictionary.hashMap;
        pushAttrib(pdfDictionary);
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS));
        if (pdfArray != null) {
            iterateFields(pdfArray, null, null);
        }
    }

    protected void iterateFields(PdfArray pdfArray, PRIndirectReference pRIndirectReference, String str) {
        String str2;
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) listIterator.next();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference2);
            PdfString pdfString = (PdfString) pdfDictionary.get(PdfName.f19772T);
            boolean z = pdfString != null;
            if (!z) {
                pRIndirectReference2 = pRIndirectReference;
                str2 = str;
            } else if (str == null) {
                str2 = pdfString.toString();
            } else {
                str2 = str + '.' + pdfString.toString();
            }
            PdfArray pdfArray2 = (PdfArray) pdfDictionary.get(PdfName.KIDS);
            if (pdfArray2 != null) {
                pushAttrib(pdfDictionary);
                iterateFields(pdfArray2, pRIndirectReference2, str2);
                ArrayList<PdfDictionary> arrayList = this.stack;
                arrayList.remove(arrayList.size() - 1);
            } else if (pRIndirectReference2 != null) {
                ArrayList<PdfDictionary> arrayList2 = this.stack;
                PdfDictionary pdfDictionary2 = arrayList2.get(arrayList2.size() - 1);
                if (z) {
                    pdfDictionary2 = mergeAttrib(pdfDictionary2, pdfDictionary);
                }
                pdfDictionary2.put(PdfName.f19772T, new PdfString(str2));
                FieldInformation fieldInformation = new FieldInformation(str2, pdfDictionary2, pRIndirectReference2);
                this.fields.add(fieldInformation);
                this.fieldByName.put(str2, fieldInformation);
            }
        }
    }

    protected PdfDictionary mergeAttrib(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (pdfDictionary != null) {
            pdfDictionary3.putAll(pdfDictionary);
        }
        for (PdfName pdfName : pdfDictionary2.getKeys()) {
            if (pdfName.equals(PdfName.f19706DR) || pdfName.equals(PdfName.f19700DA) || pdfName.equals(PdfName.f19759Q) || pdfName.equals(PdfName.f19715FF) || pdfName.equals(PdfName.f19708DV) || pdfName.equals(PdfName.f19787V) || pdfName.equals(PdfName.f19720FT) || pdfName.equals(PdfName.f19745NM) || pdfName.equals(PdfName.f19712F)) {
                pdfDictionary3.put(pdfName, pdfDictionary2.get(pdfName));
            }
        }
        return pdfDictionary3;
    }

    protected void pushAttrib(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2;
        if (this.stack.isEmpty()) {
            pdfDictionary2 = null;
        } else {
            ArrayList<PdfDictionary> arrayList = this.stack;
            pdfDictionary2 = arrayList.get(arrayList.size() - 1);
        }
        this.stack.add(mergeAttrib(pdfDictionary2, pdfDictionary));
    }
}
