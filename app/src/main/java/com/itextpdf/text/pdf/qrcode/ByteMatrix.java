package com.itextpdf.text.pdf.qrcode;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i, int i2) {
        this.bytes = (byte[][]) Array.newInstance(byte.class, i2, i);
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final byte get(int i, int i2) {
        return this.bytes[i2][i];
    }

    public final byte[][] getArray() {
        return this.bytes;
    }

    public final void set(int i, int i2, byte b) {
        this.bytes[i2][i] = b;
    }

    public final void set(int i, int i2, int i3) {
        this.bytes[i2][i] = (byte) i3;
    }

    public final void clear(byte b) {
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                this.bytes[i][i2] = b;
            }
        }
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.width * 2 * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                switch (this.bytes[i][i2]) {
                    case 0:
                        stringBuffer.append(" 0");
                        break;
                    case 1:
                        stringBuffer.append(" 1");
                        break;
                    default:
                        stringBuffer.append("  ");
                        break;
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
