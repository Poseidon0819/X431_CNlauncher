package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfNumber extends PdfObject {
    private double value;

    public PdfNumber(String str) {
        super(2);
        try {
            this.value = Double.parseDouble(str.trim());
            setContent(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("1.is.not.a.valid.number.2", str, e.toString()));
        }
    }

    public PdfNumber(int i) {
        super(2);
        this.value = i;
        setContent(String.valueOf(i));
    }

    public PdfNumber(long j) {
        super(2);
        this.value = j;
        setContent(String.valueOf(j));
    }

    public PdfNumber(double d) {
        super(2);
        this.value = d;
        setContent(ByteBuffer.formatDouble(d));
    }

    public PdfNumber(float f) {
        this(f);
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public void increment() {
        this.value += 1.0d;
        setContent(ByteBuffer.formatDouble(this.value));
    }
}
