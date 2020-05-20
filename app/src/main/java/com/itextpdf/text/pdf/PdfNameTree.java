package com.itextpdf.text.pdf;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PdfNameTree {
    private static final int leafSize = 64;

    public static PdfDictionary writeTree(HashMap<String, ? extends PdfObject> hashMap, PdfWriter pdfWriter) throws IOException {
        if (hashMap.isEmpty()) {
            return null;
        }
        String[] strArr = (String[]) hashMap.keySet().toArray(new String[hashMap.size()]);
        Arrays.sort(strArr);
        int i = 64;
        if (strArr.length <= 64) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                pdfArray.add(new PdfString(strArr[i2], null));
                pdfArray.add(hashMap.get(strArr[i2]));
            }
            pdfDictionary.put(PdfName.NAMES, pdfArray);
            return pdfDictionary;
        }
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[((strArr.length + 64) - 1) / 64];
        for (int i3 = 0; i3 < pdfIndirectReferenceArr.length; i3++) {
            int i4 = i3 * 64;
            int min = Math.min(i4 + 64, strArr.length);
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.add(new PdfString(strArr[i4], null));
            pdfArray2.add(new PdfString(strArr[min - 1], null));
            pdfDictionary2.put(PdfName.LIMITS, pdfArray2);
            PdfArray pdfArray3 = new PdfArray();
            while (i4 < min) {
                pdfArray3.add(new PdfString(strArr[i4], null));
                pdfArray3.add(hashMap.get(strArr[i4]));
                i4++;
            }
            pdfDictionary2.put(PdfName.NAMES, pdfArray3);
            pdfIndirectReferenceArr[i3] = pdfWriter.addToBody(pdfDictionary2).getIndirectReference();
        }
        int length = pdfIndirectReferenceArr.length;
        int i5 = 64;
        while (length > i) {
            i5 *= 64;
            int length2 = ((strArr.length + i5) - 1) / i5;
            int i6 = 0;
            while (i6 < length2) {
                int i7 = i6 * 64;
                int min2 = Math.min(i7 + 64, length);
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                PdfArray pdfArray4 = new PdfArray();
                pdfArray4.add(new PdfString(strArr[i6 * i5], null));
                int i8 = i6 + 1;
                pdfArray4.add(new PdfString(strArr[Math.min(i8 * i5, strArr.length) - 1], null));
                pdfDictionary3.put(PdfName.LIMITS, pdfArray4);
                PdfArray pdfArray5 = new PdfArray();
                while (i7 < min2) {
                    pdfArray5.add(pdfIndirectReferenceArr[i7]);
                    i7++;
                }
                pdfDictionary3.put(PdfName.KIDS, pdfArray5);
                pdfIndirectReferenceArr[i6] = pdfWriter.addToBody(pdfDictionary3).getIndirectReference();
                i6 = i8;
                i = 64;
            }
            length = length2;
        }
        PdfArray pdfArray6 = new PdfArray();
        for (int i9 = 0; i9 < length; i9++) {
            pdfArray6.add(pdfIndirectReferenceArr[i9]);
        }
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.put(PdfName.KIDS, pdfArray6);
        return pdfDictionary4;
    }

    private static PdfString iterateItems(PdfDictionary pdfDictionary, HashMap<String, PdfObject> hashMap, PdfString pdfString) {
        int i;
        PdfString pdfString2;
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.NAMES));
        int i2 = 0;
        if (pdfArray != null) {
            while (i2 < pdfArray.size()) {
                if (pdfString == null) {
                    i = i2 + 1;
                    PdfString pdfString3 = (PdfString) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2));
                    pdfString2 = pdfString;
                    pdfString = pdfString3;
                } else {
                    i = i2;
                    pdfString2 = null;
                }
                if (i >= pdfArray.size()) {
                    return pdfString;
                }
                hashMap.put(PdfEncodings.convertToString(pdfString.getBytes(), null), pdfArray.getPdfObject(i));
                pdfString = pdfString2;
                i2 = i + 1;
            }
        } else {
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.KIDS));
            if (pdfArray2 != null) {
                while (i2 < pdfArray2.size()) {
                    pdfString = iterateItems((PdfDictionary) PdfReader.getPdfObjectRelease(pdfArray2.getPdfObject(i2)), hashMap, pdfString);
                    i2++;
                }
            }
        }
        return null;
    }

    public static HashMap<String, PdfObject> readTree(PdfDictionary pdfDictionary) {
        HashMap<String, PdfObject> hashMap = new HashMap<>();
        if (pdfDictionary != null) {
            iterateItems(pdfDictionary, hashMap, null);
        }
        return hashMap;
    }
}
