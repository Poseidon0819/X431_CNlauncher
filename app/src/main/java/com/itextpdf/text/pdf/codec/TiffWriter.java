package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class TiffWriter {
    private TreeMap<Integer, FieldBase> ifd = new TreeMap<>();

    public void addField(FieldBase fieldBase) {
        this.ifd.put(Integer.valueOf(fieldBase.getTag()), fieldBase);
    }

    public int getIfdSize() {
        return (this.ifd.size() * 12) + 6;
    }

    public void writeFile(OutputStream outputStream) throws IOException {
        outputStream.write(77);
        outputStream.write(77);
        outputStream.write(0);
        outputStream.write(42);
        writeLong(8, outputStream);
        writeShort(this.ifd.size(), outputStream);
        int ifdSize = getIfdSize() + 8;
        for (FieldBase fieldBase : this.ifd.values()) {
            int valueSize = fieldBase.getValueSize();
            if (valueSize > 4) {
                fieldBase.setOffset(ifdSize);
                ifdSize += valueSize;
            }
            fieldBase.writeField(outputStream);
        }
        writeLong(0, outputStream);
        for (FieldBase fieldBase2 : this.ifd.values()) {
            fieldBase2.writeValue(outputStream);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FieldBase {
        private int count;
        protected byte[] data;
        private int fieldType;
        private int offset;
        private int tag;

        protected FieldBase(int i, int i2, int i3) {
            this.tag = i;
            this.fieldType = i2;
            this.count = i3;
        }

        public int getValueSize() {
            return (this.data.length + 1) & (-2);
        }

        public int getTag() {
            return this.tag;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public void writeField(OutputStream outputStream) throws IOException {
            TiffWriter.writeShort(this.tag, outputStream);
            TiffWriter.writeShort(this.fieldType, outputStream);
            TiffWriter.writeLong(this.count, outputStream);
            byte[] bArr = this.data;
            if (bArr.length <= 4) {
                outputStream.write(bArr);
                for (int length = this.data.length; length < 4; length++) {
                    outputStream.write(0);
                }
                return;
            }
            TiffWriter.writeLong(this.offset, outputStream);
        }

        public void writeValue(OutputStream outputStream) throws IOException {
            byte[] bArr = this.data;
            if (bArr.length <= 4) {
                return;
            }
            outputStream.write(bArr);
            if ((this.data.length & 1) == 1) {
                outputStream.write(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FieldShort extends FieldBase {
        public FieldShort(int i, int i2) {
            super(i, 3, 1);
            this.data = new byte[2];
            this.data[0] = (byte) (i2 >> 8);
            this.data[1] = (byte) i2;
        }

        public FieldShort(int i, int[] iArr) {
            super(i, 3, iArr.length);
            this.data = new byte[iArr.length * 2];
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = iArr[i2];
                int i5 = i3 + 1;
                this.data[i3] = (byte) (i4 >> 8);
                this.data[i5] = (byte) i4;
                i2++;
                i3 = i5 + 1;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FieldLong extends FieldBase {
        public FieldLong(int i, int i2) {
            super(i, 4, 1);
            this.data = new byte[4];
            this.data[0] = (byte) (i2 >> 24);
            this.data[1] = (byte) (i2 >> 16);
            this.data[2] = (byte) (i2 >> 8);
            this.data[3] = (byte) i2;
        }

        public FieldLong(int i, int[] iArr) {
            super(i, 4, iArr.length);
            this.data = new byte[iArr.length * 4];
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = iArr[i2];
                int i5 = i3 + 1;
                this.data[i3] = (byte) (i4 >> 24);
                int i6 = i5 + 1;
                this.data[i5] = (byte) (i4 >> 16);
                int i7 = i6 + 1;
                this.data[i6] = (byte) (i4 >> 8);
                this.data[i7] = (byte) i4;
                i2++;
                i3 = i7 + 1;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FieldRational extends FieldBase {
        public FieldRational(int i, int[] iArr) {
            this(i, new int[][]{iArr});
        }

        public FieldRational(int i, int[][] iArr) {
            super(i, 5, iArr.length);
            this.data = new byte[iArr.length * 8];
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr2 = iArr[i2];
                int i4 = i3 + 1;
                this.data[i3] = (byte) (iArr2[0] >> 24);
                int i5 = i4 + 1;
                this.data[i4] = (byte) (iArr2[0] >> 16);
                int i6 = i5 + 1;
                this.data[i5] = (byte) (iArr2[0] >> 8);
                int i7 = i6 + 1;
                this.data[i6] = (byte) iArr2[0];
                int i8 = i7 + 1;
                this.data[i7] = (byte) (iArr2[1] >> 24);
                int i9 = i8 + 1;
                this.data[i8] = (byte) (iArr2[1] >> 16);
                int i10 = i9 + 1;
                this.data[i9] = (byte) (iArr2[1] >> 8);
                this.data[i10] = (byte) iArr2[1];
                i2++;
                i3 = i10 + 1;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FieldByte extends FieldBase {
        public FieldByte(int i, byte[] bArr) {
            super(i, 1, bArr.length);
            this.data = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class FieldUndefined extends FieldBase {
        public FieldUndefined(int i, byte[] bArr) {
            super(i, 7, bArr.length);
            this.data = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class FieldImage extends FieldBase {
        public FieldImage(byte[] bArr) {
            super(TIFFConstants.TIFFTAG_STRIPOFFSETS, 4, 1);
            this.data = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class FieldAscii extends FieldBase {
        public FieldAscii(int i, String str) {
            super(i, 2, str.getBytes().length + 1);
            byte[] bytes = str.getBytes();
            this.data = new byte[bytes.length + 1];
            System.arraycopy(bytes, 0, this.data, 0, bytes.length);
        }
    }

    public static void writeShort(int i, OutputStream outputStream) throws IOException {
        outputStream.write((i >> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void writeLong(int i, OutputStream outputStream) throws IOException {
        outputStream.write((i >> 24) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void compressLZW(OutputStream outputStream, int i, byte[] bArr, int i2, int i3, int i4) throws IOException {
        LZWCompressor lZWCompressor = new LZWCompressor(outputStream, 8, true);
        if (!(i == 2)) {
            lZWCompressor.compress(bArr, 0, bArr.length);
        } else {
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                System.arraycopy(bArr, i5, bArr2, 0, i4);
                for (int i7 = i4 - 1; i7 >= i3; i7--) {
                    bArr2[i7] = (byte) (bArr2[i7] - bArr2[i7 - i3]);
                }
                lZWCompressor.compress(bArr2, 0, i4);
                i5 += i4;
            }
        }
        lZWCompressor.flush();
    }
}
