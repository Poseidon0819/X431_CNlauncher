package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* loaded from: classes.dex */
public abstract class AbstractCMap {
    private String cmapName;
    private String ordering;
    private String registry;
    private int supplement;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void addChar(PdfString pdfString, PdfObject pdfObject);

    public String getName() {
        return this.cmapName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this.cmapName = str;
    }

    public String getOrdering() {
        return this.ordering;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOrdering(String str) {
        this.ordering = str;
    }

    public String getRegistry() {
        return this.registry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRegistry(String str) {
        this.registry = str;
    }

    public int getSupplement() {
        return this.supplement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupplement(int i) {
        this.supplement = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRange(PdfString pdfString, PdfString pdfString2, PdfObject pdfObject) {
        byte[] decodeStringToByte = decodeStringToByte(pdfString);
        byte[] decodeStringToByte2 = decodeStringToByte(pdfString2);
        if (decodeStringToByte.length != decodeStringToByte2.length || decodeStringToByte.length == 0) {
            throw new IllegalArgumentException("Invalid map.");
        }
        boolean z = pdfObject instanceof PdfString;
        byte[] decodeStringToByte3 = z ? decodeStringToByte((PdfString) pdfObject) : null;
        int i = decodeStringToByte[decodeStringToByte.length - 1] & 255;
        int i2 = decodeStringToByte2[decodeStringToByte2.length - 1] & 255;
        for (int i3 = i; i3 <= i2; i3++) {
            decodeStringToByte[decodeStringToByte.length - 1] = (byte) i3;
            PdfString pdfString3 = new PdfString(decodeStringToByte);
            pdfString3.setHexWriting(true);
            if (pdfObject instanceof PdfArray) {
                addChar(pdfString3, ((PdfArray) pdfObject).getPdfObject(i3 - i));
            } else if (pdfObject instanceof PdfNumber) {
                addChar(pdfString3, new PdfNumber((((PdfNumber) pdfObject).intValue() + i3) - i));
            } else if (z) {
                PdfString pdfString4 = new PdfString(decodeStringToByte3);
                pdfString4.setHexWriting(true);
                int length = decodeStringToByte3.length - 1;
                decodeStringToByte3[length] = (byte) (decodeStringToByte3[length] + 1);
                addChar(pdfString3, pdfString4);
            }
        }
    }

    public static byte[] decodeStringToByte(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public String decodeStringToUnicode(PdfString pdfString) {
        if (pdfString.isHexWriting()) {
            return PdfEncodings.convertToString(pdfString.getBytes(), "UnicodeBigUnmarked");
        }
        return pdfString.toUnicodeString();
    }
}
