package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class TIFFDirectory implements Serializable {
    private static final long serialVersionUID = -168636766193675380L;
    private static final int[] sizeOfType = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    TIFFField[] fields;
    boolean isBigEndian;
    int numEntries;
    Hashtable<Integer, Integer> fieldIndex = new Hashtable<>();
    long IFDOffset = 8;
    long nextIFDOffset = 0;

    private static boolean isValidEndianTag(int i) {
        return i == 18761 || i == 19789;
    }

    TIFFDirectory() {
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (!isValidEndianTag(readUnsignedShort)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
        }
        this.isBigEndian = readUnsignedShort == 19789;
        if (readUnsignedShort(randomAccessFileOrArray) != 42) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
        for (int i2 = 0; i2 < i; i2++) {
            if (readUnsignedInt == 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("directory.number.too.large", new Object[0]));
            }
            randomAccessFileOrArray.seek(readUnsignedInt);
            randomAccessFileOrArray.skip(readUnsignedShort(randomAccessFileOrArray) * 12);
            readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
        }
        randomAccessFileOrArray.seek(readUnsignedInt);
        initialize(randomAccessFileOrArray);
        randomAccessFileOrArray.seek(filePointer);
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, long j, int i) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (!isValidEndianTag(readUnsignedShort)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
        }
        this.isBigEndian = readUnsignedShort == 19789;
        randomAccessFileOrArray.seek(j);
        for (int i2 = 0; i2 < i; i2++) {
            randomAccessFileOrArray.seek(j + (readUnsignedShort(randomAccessFileOrArray) * 12));
            j = readUnsignedInt(randomAccessFileOrArray);
            randomAccessFileOrArray.seek(j);
        }
        initialize(randomAccessFileOrArray);
        randomAccessFileOrArray.seek(filePointer);
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r4v7, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r4v9, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [long[]] */
    /* JADX WARN: Type inference failed for: r4v13, types: [long[][]] */
    /* JADX WARN: Type inference failed for: r4v15, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v18, types: [int[][]] */
    /* JADX WARN: Type inference failed for: r4v19, types: [float[]] */
    /* JADX WARN: Type inference failed for: r4v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initialize(com.itextpdf.text.pdf.RandomAccessFileOrArray r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFDirectory.initialize(com.itextpdf.text.pdf.RandomAccessFileOrArray):void");
    }

    public int getNumEntries() {
        return this.numEntries;
    }

    public TIFFField getField(int i) {
        Integer num = this.fieldIndex.get(Integer.valueOf(i));
        if (num == null) {
            return null;
        }
        return this.fields[num.intValue()];
    }

    public boolean isTagPresent(int i) {
        return this.fieldIndex.containsKey(Integer.valueOf(i));
    }

    public int[] getTags() {
        int[] iArr = new int[this.fieldIndex.size()];
        Enumeration<Integer> keys = this.fieldIndex.keys();
        int i = 0;
        while (keys.hasMoreElements()) {
            iArr[i] = keys.nextElement().intValue();
            i++;
        }
        return iArr;
    }

    public TIFFField[] getFields() {
        return this.fields;
    }

    public byte getFieldAsByte(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsBytes()[i2];
    }

    public byte getFieldAsByte(int i) {
        return getFieldAsByte(i, 0);
    }

    public long getFieldAsLong(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsLong(i2);
    }

    public long getFieldAsLong(int i) {
        return getFieldAsLong(i, 0);
    }

    public float getFieldAsFloat(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsFloat(i2);
    }

    public float getFieldAsFloat(int i) {
        return getFieldAsFloat(i, 0);
    }

    public double getFieldAsDouble(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsDouble(i2);
    }

    public double getFieldAsDouble(int i) {
        return getFieldAsDouble(i, 0);
    }

    private short readShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readShort();
        }
        return randomAccessFileOrArray.readShortLE();
    }

    private int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private int readInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readInt();
        }
        return randomAccessFileOrArray.readIntLE();
    }

    private long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    private long readLong(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readLong();
        }
        return randomAccessFileOrArray.readLongLE();
    }

    private float readFloat(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readFloat();
        }
        return randomAccessFileOrArray.readFloatLE();
    }

    private double readDouble(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readDouble();
        }
        return randomAccessFileOrArray.readDoubleLE();
    }

    private static int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private static long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    public static int getNumDirectories(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        int i = 0;
        if (!isValidEndianTag(readUnsignedShort)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
        }
        boolean z = readUnsignedShort == 19789;
        if (readUnsignedShort(randomAccessFileOrArray, z) != 42) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        randomAccessFileOrArray.seek(4L);
        long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
        while (readUnsignedInt != 0) {
            i++;
            try {
                randomAccessFileOrArray.seek(readUnsignedInt);
                randomAccessFileOrArray.skip(readUnsignedShort(randomAccessFileOrArray, z) * 12);
                readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
            } catch (EOFException unused) {
            }
        }
        randomAccessFileOrArray.seek(filePointer);
        return i;
    }

    public boolean isBigEndian() {
        return this.isBigEndian;
    }

    public long getIFDOffset() {
        return this.IFDOffset;
    }

    public long getNextIFDOffset() {
        return this.nextIFDOffset;
    }
}
