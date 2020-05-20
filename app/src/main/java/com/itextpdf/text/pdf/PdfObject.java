package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class PdfObject {
    public static final int ARRAY = 5;
    public static final int BOOLEAN = 1;
    public static final int DICTIONARY = 6;
    public static final int INDIRECT = 10;
    public static final int NAME = 4;
    public static final String NOTHING = "";
    public static final int NULL = 8;
    public static final int NUMBER = 2;
    public static final int STREAM = 7;
    public static final int STRING = 3;
    public static final String TEXT_PDFDOCENCODING = "PDF";
    public static final String TEXT_UNICODE = "UnicodeBig";
    protected byte[] bytes;
    protected PRIndirectReference indRef;
    protected int type;

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfObject(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfObject(int i, String str) {
        this.type = i;
        this.bytes = PdfEncodings.convertToBytes(str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfObject(int i, byte[] bArr) {
        this.bytes = bArr;
        this.type = i;
    }

    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public String toString() {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            return super.toString();
        }
        return PdfEncodings.convertToString(bArr, null);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public boolean canBeInObjStm() {
        switch (this.type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            case 7:
            default:
                return false;
        }
    }

    public int length() {
        return toString().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContent(String str) {
        this.bytes = PdfEncodings.convertToBytes(str, (String) null);
    }

    public int type() {
        return this.type;
    }

    public boolean isNull() {
        return this.type == 8;
    }

    public boolean isBoolean() {
        return this.type == 1;
    }

    public boolean isNumber() {
        return this.type == 2;
    }

    public boolean isString() {
        return this.type == 3;
    }

    public boolean isName() {
        return this.type == 4;
    }

    public boolean isArray() {
        return this.type == 5;
    }

    public boolean isDictionary() {
        return this.type == 6;
    }

    public boolean isStream() {
        return this.type == 7;
    }

    public boolean isIndirect() {
        return this.type == 10;
    }

    public PRIndirectReference getIndRef() {
        return this.indRef;
    }

    public void setIndRef(PRIndirectReference pRIndirectReference) {
        this.indRef = pRIndirectReference;
    }
}
