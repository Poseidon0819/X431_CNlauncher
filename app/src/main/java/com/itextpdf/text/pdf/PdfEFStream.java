package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public class PdfEFStream extends PdfStream {
    public PdfEFStream(InputStream inputStream, PdfWriter pdfWriter) {
        super(inputStream, pdfWriter);
    }

    public PdfEFStream(byte[] bArr) {
        super(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.itextpdf.text.pdf.PdfEFStream] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.OutputStream, com.itextpdf.text.pdf.OutputStreamCounter] */
    @Override // com.itextpdf.text.pdf.PdfStream, com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        byte[] encryptByteArray;
        OutputStreamEncryption outputStreamEncryption;
        OutputStreamEncryption outputStreamEncryption2;
        Deflater deflater;
        PdfObject pdfObject;
        if (this.inputStream != null && this.compressed) {
            put(PdfName.FILTER, PdfName.FLATEDECODE);
        }
        ?? r0 = 0;
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null && (pdfObject = get(PdfName.FILTER)) != null) {
            if (PdfName.CRYPT.equals(pdfObject)) {
                encryption = null;
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                if (!pdfArray.isEmpty() && PdfName.CRYPT.equals(pdfArray.getPdfObject(0))) {
                    encryption = null;
                }
            }
        }
        if (encryption != null && encryption.isEmbeddedFilesOnly()) {
            PdfArray pdfArray2 = new PdfArray();
            PdfArray pdfArray3 = new PdfArray();
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.NAME, PdfName.STDCF);
            pdfArray2.add(PdfName.CRYPT);
            pdfArray3.add(pdfDictionary);
            if (this.compressed) {
                pdfArray2.add(PdfName.FLATEDECODE);
                pdfArray3.add(new PdfNull());
            }
            put(PdfName.FILTER, pdfArray2);
            put(PdfName.DECODEPARMS, pdfArray3);
        }
        PdfObject pdfObject2 = get(PdfName.LENGTH);
        if (encryption != null && pdfObject2 != null && pdfObject2.isNumber()) {
            put(PdfName.LENGTH, new PdfNumber(encryption.calculateStreamSize(((PdfNumber) pdfObject2).intValue())));
            superToPdf(pdfWriter, outputStream);
            put(PdfName.LENGTH, pdfObject2);
        } else {
            superToPdf(pdfWriter, outputStream);
        }
        outputStream.write(STARTSTREAM);
        if (this.inputStream != null) {
            this.rawLength = 0;
            ?? outputStreamCounter = new OutputStreamCounter(outputStream);
            if (encryption != null) {
                outputStreamEncryption = encryption.getEncryptionStream(outputStreamCounter);
                outputStreamEncryption2 = outputStreamEncryption;
            } else {
                outputStreamEncryption = outputStreamCounter;
                outputStreamEncryption2 = null;
            }
            if (this.compressed) {
                Deflater deflater2 = new Deflater(this.compressionLevel);
                outputStreamEncryption = new DeflaterOutputStream(outputStreamEncryption, deflater2, 32768);
                deflater = deflater2;
                r0 = outputStreamEncryption;
            } else {
                deflater = null;
            }
            byte[] bArr = new byte[4192];
            while (true) {
                int read = this.inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStreamEncryption.write(bArr, 0, read);
                this.rawLength += read;
            }
            if (r0 != 0) {
                r0.finish();
                deflater.end();
            }
            if (outputStreamEncryption2 != null) {
                outputStreamEncryption2.finish();
            }
            this.inputStreamLength = (int) outputStreamCounter.getCounter();
        } else if (encryption == null) {
            if (this.streamBytes != null) {
                this.streamBytes.writeTo(outputStream);
            } else {
                outputStream.write(this.bytes);
            }
        } else {
            if (this.streamBytes != null) {
                encryptByteArray = encryption.encryptByteArray(this.streamBytes.toByteArray());
            } else {
                encryptByteArray = encryption.encryptByteArray(this.bytes);
            }
            outputStream.write(encryptByteArray);
        }
        outputStream.write(ENDSTREAM);
    }
}
