package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PRIndirectReference extends PdfIndirectReference {
    protected PdfReader reader;

    public PRIndirectReference(PdfReader pdfReader, int i, int i2) {
        this.type = 10;
        this.number = i;
        this.generation = i2;
        this.reader = pdfReader;
    }

    public PRIndirectReference(PdfReader pdfReader, int i) {
        this(pdfReader, i, 0);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        int newObjectNumber = pdfWriter.getNewObjectNumber(this.reader, this.number, this.generation);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(newObjectNumber);
        stringBuffer.append(" 0 R");
        outputStream.write(PdfEncodings.convertToBytes(stringBuffer.toString(), (String) null));
    }

    public PdfReader getReader() {
        return this.reader;
    }

    public void setNumber(int i, int i2) {
        this.number = i;
        this.generation = i2;
    }
}
