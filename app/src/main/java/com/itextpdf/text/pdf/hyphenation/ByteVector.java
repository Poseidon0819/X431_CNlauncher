package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ByteVector implements Serializable {
    private static final int DEFAULT_BLOCK_SIZE = 2048;
    private static final long serialVersionUID = -1096301185375029343L;
    private byte[] array;
    private int blockSize;

    /* renamed from: n */
    private int f19845n;

    public ByteVector() {
        this(2048);
    }

    public ByteVector(int i) {
        if (i > 0) {
            this.blockSize = i;
        } else {
            this.blockSize = 2048;
        }
        this.array = new byte[this.blockSize];
        this.f19845n = 0;
    }

    public ByteVector(byte[] bArr) {
        this.blockSize = 2048;
        this.array = bArr;
        this.f19845n = 0;
    }

    public ByteVector(byte[] bArr, int i) {
        if (i > 0) {
            this.blockSize = i;
        } else {
            this.blockSize = 2048;
        }
        this.array = bArr;
        this.f19845n = 0;
    }

    public byte[] getArray() {
        return this.array;
    }

    public int length() {
        return this.f19845n;
    }

    public int capacity() {
        return this.array.length;
    }

    public void put(int i, byte b) {
        this.array[i] = b;
    }

    public byte get(int i) {
        return this.array[i];
    }

    public int alloc(int i) {
        int i2 = this.f19845n;
        byte[] bArr = this.array;
        int length = bArr.length;
        if (i2 + i >= length) {
            byte[] bArr2 = new byte[this.blockSize + length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            this.array = bArr2;
        }
        this.f19845n += i;
        return i2;
    }

    public void trimToSize() {
        int i = this.f19845n;
        byte[] bArr = this.array;
        if (i < bArr.length) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            this.array = bArr2;
        }
    }
}
