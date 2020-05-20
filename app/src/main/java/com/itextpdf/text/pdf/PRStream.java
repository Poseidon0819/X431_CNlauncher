package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: classes.dex */
public class PRStream extends PdfStream {
    protected int length;
    protected int objGen;
    protected int objNum;
    protected long offset;
    protected PdfReader reader;

    public PRStream(PRStream pRStream, PdfDictionary pdfDictionary) {
        this.objNum = 0;
        this.objGen = 0;
        this.reader = pRStream.reader;
        this.offset = pRStream.offset;
        this.length = pRStream.length;
        this.compressed = pRStream.compressed;
        this.compressionLevel = pRStream.compressionLevel;
        this.streamBytes = pRStream.streamBytes;
        this.bytes = pRStream.bytes;
        this.objNum = pRStream.objNum;
        this.objGen = pRStream.objGen;
        if (pdfDictionary != null) {
            putAll(pdfDictionary);
        } else {
            this.hashMap.putAll(pRStream.hashMap);
        }
    }

    public PRStream(PRStream pRStream, PdfDictionary pdfDictionary, PdfReader pdfReader) {
        this(pRStream, pdfDictionary);
        this.reader = pdfReader;
    }

    public PRStream(PdfReader pdfReader, long j) {
        this.objNum = 0;
        this.objGen = 0;
        this.reader = pdfReader;
        this.offset = j;
    }

    public PRStream(PdfReader pdfReader, byte[] bArr) {
        this(pdfReader, bArr, -1);
    }

    public PRStream(PdfReader pdfReader, byte[] bArr, int i) {
        this.objNum = 0;
        this.objGen = 0;
        this.reader = pdfReader;
        this.offset = -1L;
        if (Document.compress) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                this.bytes = byteArrayOutputStream.toByteArray();
                put(PdfName.FILTER, PdfName.FLATEDECODE);
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            this.bytes = bArr;
        }
        setLength(this.bytes.length);
    }

    public void setData(byte[] bArr, boolean z) {
        setData(bArr, z, -1);
    }

    public void setData(byte[] bArr, boolean z, int i) {
        remove(PdfName.FILTER);
        this.offset = -1L;
        if (Document.compress && z) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                this.bytes = byteArrayOutputStream.toByteArray();
                this.compressionLevel = i;
                put(PdfName.FILTER, PdfName.FLATEDECODE);
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            this.bytes = bArr;
        }
        setLength(this.bytes.length);
    }

    public void setData(byte[] bArr) {
        setData(bArr, true);
    }

    public void setLength(int i) {
        this.length = i;
        put(PdfName.LENGTH, new PdfNumber(i));
    }

    public long getOffset() {
        return this.offset;
    }

    public int getLength() {
        return this.length;
    }

    public PdfReader getReader() {
        return this.reader;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public byte[] getBytes() {
        return this.bytes;
    }

    public void setObjNum(int i, int i2) {
        this.objNum = i;
        this.objGen = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getObjNum() {
        return this.objNum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getObjGen() {
        return this.objGen;
    }

    @Override // com.itextpdf.text.pdf.PdfStream, com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        byte[] streamBytesRaw = PdfReader.getStreamBytesRaw(this);
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        PdfObject pdfObject = get(PdfName.LENGTH);
        int length = streamBytesRaw.length;
        if (encryption != null) {
            length = encryption.calculateStreamSize(length);
        }
        put(PdfName.LENGTH, new PdfNumber(length));
        superToPdf(pdfWriter, outputStream);
        put(PdfName.LENGTH, pdfObject);
        outputStream.write(STARTSTREAM);
        if (this.length > 0) {
            if (encryption != null && !encryption.isEmbeddedFilesOnly()) {
                streamBytesRaw = encryption.encryptByteArray(streamBytesRaw);
            }
            outputStream.write(streamBytesRaw);
        }
        outputStream.write(ENDSTREAM);
    }
}
