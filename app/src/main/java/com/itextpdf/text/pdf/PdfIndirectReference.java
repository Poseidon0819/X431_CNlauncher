package com.itextpdf.text.pdf;

import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class PdfIndirectReference extends PdfObject {
    protected int generation;
    protected int number;

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfIndirectReference() {
        super(0);
        this.generation = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PdfIndirectReference(int r2, int r3, int r4) {
        /*
            r1 = this;
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r3)
            java.lang.String r0 = " "
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = " R"
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r0 = 0
            r1.<init>(r0, r2)
            r1.generation = r0
            r1.number = r3
            r1.generation = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfIndirectReference.<init>(int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfIndirectReference(int i, int i2) {
        this(i, i2, 0);
    }

    public int getNumber() {
        return this.number;
    }

    public int getGeneration() {
        return this.generation;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.number);
        stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        stringBuffer.append(this.generation);
        stringBuffer.append(" R");
        return stringBuffer.toString();
    }
}
