package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PdfString extends PdfObject {
    protected String encoding;
    protected boolean hexWriting;
    protected int objGen;
    protected int objNum;
    protected String originalValue;
    protected String value;

    public PdfString() {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
    }

    public PdfString(String str) {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = str;
    }

    public PdfString(String str, String str2) {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = str;
        this.encoding = str2;
    }

    public PdfString(byte[] bArr) {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = PdfEncodings.convertToString(bArr, null);
        this.encoding = "";
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        byte[] bytes = getBytes();
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null && !encryption.isEmbeddedFilesOnly()) {
            bytes = encryption.encryptByteArray(bytes);
        }
        if (this.hexWriting) {
            ByteBuffer byteBuffer = new ByteBuffer();
            byteBuffer.append('<');
            for (byte b : bytes) {
                byteBuffer.appendHex(b);
            }
            byteBuffer.append('>');
            outputStream.write(byteBuffer.toByteArray());
            return;
        }
        outputStream.write(PdfContentByte.escapeString(bytes));
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return this.value;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public byte[] getBytes() {
        if (this.bytes == null) {
            String str = this.encoding;
            if (str != null && str.equals(PdfObject.TEXT_UNICODE) && PdfEncodings.isPdfDocEncoding(this.value)) {
                this.bytes = PdfEncodings.convertToBytes(this.value, PdfObject.TEXT_PDFDOCENCODING);
            } else {
                this.bytes = PdfEncodings.convertToBytes(this.value, this.encoding);
            }
        }
        return this.bytes;
    }

    public String toUnicodeString() {
        String str = this.encoding;
        if (str != null && str.length() != 0) {
            return this.value;
        }
        getBytes();
        if (this.bytes.length >= 2 && this.bytes[0] == -2 && this.bytes[1] == -1) {
            return PdfEncodings.convertToString(this.bytes, PdfObject.TEXT_UNICODE);
        }
        return PdfEncodings.convertToString(this.bytes, PdfObject.TEXT_PDFDOCENCODING);
    }

    public String getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setObjNum(int i, int i2) {
        this.objNum = i;
        this.objGen = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decrypt(PdfReader pdfReader) {
        PdfEncryption decrypt = pdfReader.getDecrypt();
        if (decrypt != null) {
            this.originalValue = this.value;
            decrypt.setHashKey(this.objNum, this.objGen);
            this.bytes = PdfEncodings.convertToBytes(this.value, (String) null);
            this.bytes = decrypt.decryptByteArray(this.bytes);
            this.value = PdfEncodings.convertToString(this.bytes, null);
        }
    }

    public byte[] getOriginalBytes() {
        String str = this.originalValue;
        if (str == null) {
            return getBytes();
        }
        return PdfEncodings.convertToBytes(str, (String) null);
    }

    public PdfString setHexWriting(boolean z) {
        this.hexWriting = z;
        return this;
    }

    public boolean isHexWriting() {
        return this.hexWriting;
    }
}
