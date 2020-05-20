package com.itextpdf.text.pdf.qrcode;

import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public final class BitArray {
    public int[] bits;
    public final int size;

    public BitArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be at least 1");
        }
        this.size = i;
        this.bits = makeArray(i);
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean get(int i) {
        return ((1 << (i & 31)) & this.bits[i >> 5]) != 0;
    }

    public final void set(int i) {
        int[] iArr = this.bits;
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public final void flip(int i) {
        int[] iArr = this.bits;
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public final void setBulk(int i, int i2) {
        this.bits[i >> 5] = i2;
    }

    public final void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public final boolean isRange(int i, int i2, boolean z) {
        int i3;
        if (i2 >= i) {
            if (i2 == i) {
                return true;
            }
            int i4 = i2 - 1;
            int i5 = i >> 5;
            int i6 = i4 >> 5;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = i7 > i5 ? 0 : i & 31;
                int i9 = i7 < i6 ? 31 : i4 & 31;
                if (i8 == 0 && i9 == 31) {
                    i3 = -1;
                } else {
                    i3 = 0;
                    while (i8 <= i9) {
                        i3 |= 1 << i8;
                        i8++;
                    }
                }
                int i10 = this.bits[i7] & i3;
                if (!z) {
                    i3 = 0;
                }
                if (i10 != i3) {
                    return false;
                }
                i7++;
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public final int[] getBitArray() {
        return this.bits;
    }

    public final void reverse() {
        int[] iArr = new int[this.bits.length];
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (get((i - i2) - 1)) {
                int i3 = i2 >> 5;
                iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
            }
        }
        this.bits = iArr;
    }

    private static int[] makeArray(int i) {
        int i2 = i >> 5;
        if ((i & 31) != 0) {
            i2++;
        }
        return new int[i2];
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuffer.append(TokenParser.f24154SP);
            }
            stringBuffer.append(get(i) ? 'X' : '.');
        }
        return stringBuffer.toString();
    }
}
