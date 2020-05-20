package com.itextpdf.text.pdf.qrcode;

/* loaded from: classes.dex */
public final class ByteArray {
    private static final int INITIAL_SIZE = 32;
    private byte[] bytes;
    private int size;

    public ByteArray() {
        this.bytes = null;
        this.size = 0;
    }

    public ByteArray(int i) {
        this.bytes = new byte[i];
        this.size = i;
    }

    public ByteArray(byte[] bArr) {
        this.bytes = bArr;
        this.size = this.bytes.length;
    }

    /* renamed from: at */
    public final int m2709at(int i) {
        return this.bytes[i] & 255;
    }

    public final void set(int i, int i2) {
        this.bytes[i] = (byte) i2;
    }

    public final int size() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final void appendByte(int i) {
        int i2 = this.size;
        if (i2 == 0 || i2 >= this.bytes.length) {
            reserve(Math.max(32, this.size << 1));
        }
        byte[] bArr = this.bytes;
        int i3 = this.size;
        bArr[i3] = (byte) i;
        this.size = i3 + 1;
    }

    public final void reserve(int i) {
        byte[] bArr = this.bytes;
        if (bArr == null || bArr.length < i) {
            byte[] bArr2 = new byte[i];
            byte[] bArr3 = this.bytes;
            if (bArr3 != null) {
                System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            }
            this.bytes = bArr2;
        }
    }

    public final void set(byte[] bArr, int i, int i2) {
        this.bytes = new byte[i2];
        this.size = i2;
        for (int i3 = 0; i3 < i2; i3++) {
            this.bytes[i3] = bArr[i + i3];
        }
    }
}
