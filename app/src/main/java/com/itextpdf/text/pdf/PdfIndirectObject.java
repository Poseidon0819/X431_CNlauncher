package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PdfIndirectObject {
    protected int generation;
    protected int number;
    protected PdfObject object;
    protected PdfWriter writer;
    static final byte[] STARTOBJ = DocWriter.getISOBytes(" obj\n");
    static final byte[] ENDOBJ = DocWriter.getISOBytes("\nendobj\n");
    static final int SIZEOBJ = STARTOBJ.length + ENDOBJ.length;

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfIndirectObject(int i, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(i, 0, pdfObject, pdfWriter);
    }

    PdfIndirectObject(PdfIndirectReference pdfIndirectReference, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(pdfIndirectReference.getNumber(), pdfIndirectReference.getGeneration(), pdfObject, pdfWriter);
    }

    PdfIndirectObject(int i, int i2, PdfObject pdfObject, PdfWriter pdfWriter) {
        this.generation = 0;
        this.writer = pdfWriter;
        this.number = i;
        this.generation = i2;
        this.object = pdfObject;
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null) {
            encryption.setHashKey(i, i2);
        }
    }

    public PdfIndirectReference getIndirectReference() {
        return new PdfIndirectReference(this.object.type(), this.number, this.generation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(DocWriter.getISOBytes(String.valueOf(this.number)));
        outputStream.write(32);
        outputStream.write(DocWriter.getISOBytes(String.valueOf(this.generation)));
        outputStream.write(STARTOBJ);
        this.object.toPdf(this.writer, outputStream);
        outputStream.write(ENDOBJ);
    }
}
