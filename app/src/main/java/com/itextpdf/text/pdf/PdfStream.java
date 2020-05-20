package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public class PdfStream extends PdfDictionary {
    public static final int BEST_COMPRESSION = 9;
    public static final int BEST_SPEED = 1;
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int NO_COMPRESSION = 0;
    protected InputStream inputStream;
    protected int rawLength;
    protected PdfIndirectReference ref;
    protected PdfWriter writer;
    static final byte[] STARTSTREAM = DocWriter.getISOBytes("stream\n");
    static final byte[] ENDSTREAM = DocWriter.getISOBytes("\nendstream");
    static final int SIZESTREAM = STARTSTREAM.length + ENDSTREAM.length;
    protected boolean compressed = false;
    protected int compressionLevel = 0;
    protected ByteArrayOutputStream streamBytes = null;
    protected int inputStreamLength = -1;

    public PdfStream(byte[] bArr) {
        this.type = 7;
        this.bytes = bArr;
        this.rawLength = bArr.length;
        put(PdfName.LENGTH, new PdfNumber(bArr.length));
    }

    public PdfStream(InputStream inputStream, PdfWriter pdfWriter) {
        this.type = 7;
        this.inputStream = inputStream;
        this.writer = pdfWriter;
        this.ref = pdfWriter.getPdfIndirectReference();
        put(PdfName.LENGTH, this.ref);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfStream() {
        this.type = 7;
    }

    public void writeLength() throws IOException {
        if (this.inputStream == null) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("writelength.can.only.be.called.in.a.contructed.pdfstream.inputstream.pdfwriter", new Object[0]));
        }
        int i = this.inputStreamLength;
        if (i == -1) {
            throw new IOException(MessageLocalization.getComposedMessage("writelength.can.only.be.called.after.output.of.the.stream.body", new Object[0]));
        }
        this.writer.addToBody((PdfObject) new PdfNumber(i), this.ref, false);
    }

    public int getRawLength() {
        return this.rawLength;
    }

    public void flateCompress() {
        flateCompress(-1);
    }

    public void flateCompress(int i) {
        if (Document.compress && !this.compressed) {
            this.compressionLevel = i;
            if (this.inputStream != null) {
                this.compressed = true;
                return;
            }
            PdfObject pdfObject = PdfReader.getPdfObject(get(PdfName.FILTER));
            if (pdfObject != null) {
                if (pdfObject.isName()) {
                    if (PdfName.FLATEDECODE.equals(pdfObject)) {
                        return;
                    }
                } else if (pdfObject.isArray()) {
                    if (((PdfArray) pdfObject).contains(PdfName.FLATEDECODE)) {
                        return;
                    }
                } else {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("stream.could.not.be.compressed.filter.is.not.a.name.or.array", new Object[0]));
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                if (this.streamBytes != null) {
                    this.streamBytes.writeTo(deflaterOutputStream);
                } else {
                    deflaterOutputStream.write(this.bytes);
                }
                deflaterOutputStream.close();
                deflater.end();
                this.streamBytes = byteArrayOutputStream;
                this.bytes = null;
                put(PdfName.LENGTH, new PdfNumber(this.streamBytes.size()));
                if (pdfObject == null) {
                    put(PdfName.FILTER, PdfName.FLATEDECODE);
                } else {
                    PdfArray pdfArray = new PdfArray(pdfObject);
                    pdfArray.add(PdfName.FLATEDECODE);
                    put(PdfName.FILTER, pdfArray);
                }
                this.compressed = true;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void superToPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        super.toPdf(pdfWriter, outputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.OutputStream, com.itextpdf.text.pdf.OutputStreamCounter] */
    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
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
            if (encryption == null || encryption.isEmbeddedFilesOnly()) {
                outputStreamEncryption = outputStreamCounter;
                outputStreamEncryption2 = null;
            } else {
                outputStreamEncryption = encryption.getEncryptionStream(outputStreamCounter);
                outputStreamEncryption2 = outputStreamEncryption;
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
        } else if (encryption != null && !encryption.isEmbeddedFilesOnly()) {
            ByteArrayOutputStream byteArrayOutputStream = this.streamBytes;
            if (byteArrayOutputStream != null) {
                encryptByteArray = encryption.encryptByteArray(byteArrayOutputStream.toByteArray());
            } else {
                encryptByteArray = encryption.encryptByteArray(this.bytes);
            }
            outputStream.write(encryptByteArray);
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = this.streamBytes;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.writeTo(outputStream);
            } else {
                outputStream.write(this.bytes);
            }
        }
        outputStream.write(ENDSTREAM);
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.streamBytes;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.writeTo(outputStream);
        } else if (this.bytes != null) {
            outputStream.write(this.bytes);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public String toString() {
        if (get(PdfName.TYPE) == null) {
            return "Stream";
        }
        return "Stream of type: " + get(PdfName.TYPE);
    }
}
