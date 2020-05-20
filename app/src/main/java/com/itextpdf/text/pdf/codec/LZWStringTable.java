package com.itextpdf.text.pdf.codec;

import java.io.PrintStream;

/* loaded from: classes.dex */
public class LZWStringTable {
    private static final short HASHSIZE = 9973;
    private static final short HASHSTEP = 2039;
    private static final short HASH_FREE = -1;
    private static final int MAXBITS = 12;
    private static final int MAXSTR = 4096;
    private static final short NEXT_FIRST = -1;
    private static final int RES_CODES = 2;
    short numStrings_;
    byte[] strChr_ = new byte[4096];
    short[] strNxt_ = new short[4096];
    int[] strLen_ = new int[4096];
    short[] strHsh_ = new short[9973];

    public int AddCharString(short s, byte b) {
        short[] sArr;
        if (this.numStrings_ >= 4096) {
            return 65535;
        }
        int Hash = Hash(s, b);
        while (true) {
            sArr = this.strHsh_;
            if (sArr[Hash] == -1) {
                break;
            }
            Hash = (Hash + 2039) % 9973;
        }
        short s2 = this.numStrings_;
        sArr[Hash] = s2;
        this.strChr_[s2] = b;
        if (s == -1) {
            this.strNxt_[s2] = -1;
            this.strLen_[s2] = 1;
        } else {
            this.strNxt_[s2] = s;
            int[] iArr = this.strLen_;
            iArr[s2] = iArr[s] + 1;
        }
        short s3 = this.numStrings_;
        this.numStrings_ = (short) (s3 + 1);
        return s3;
    }

    public short FindCharString(short s, byte b) {
        if (s == -1) {
            return (short) (b & 255);
        }
        int Hash = Hash(s, b);
        while (true) {
            short s2 = this.strHsh_[Hash];
            if (s2 == -1) {
                return (short) -1;
            }
            if (this.strNxt_[s2] == s && this.strChr_[s2] == b) {
                return s2;
            }
            Hash = (Hash + 2039) % 9973;
        }
    }

    public void ClearTable(int i) {
        this.numStrings_ = (short) 0;
        for (int i2 = 0; i2 < 9973; i2++) {
            this.strHsh_[i2] = -1;
        }
        int i3 = (1 << i) + 2;
        for (int i4 = 0; i4 < i3; i4++) {
            AddCharString((short) -1, (byte) i4);
        }
    }

    public static int Hash(short s, byte b) {
        return ((s ^ ((short) (b << 8))) & 65535) % 9973;
    }

    public int expandCode(byte[] bArr, int i, short s, int i2) {
        if (i == -2 && i2 == 1) {
            i2 = 0;
        }
        if (s != -1) {
            int[] iArr = this.strLen_;
            if (i2 != iArr[s]) {
                int i3 = iArr[s] - i2;
                int length = bArr.length - i;
                if (length > i3) {
                    length = i3;
                }
                int i4 = i3 - length;
                int i5 = i + length;
                while (i5 > i && s != -1) {
                    i4--;
                    if (i4 < 0) {
                        i5--;
                        bArr[i5] = this.strChr_[s];
                    }
                    s = this.strNxt_[s];
                }
                return i3 > length ? -length : length;
            }
        }
        return 0;
    }

    public void dump(PrintStream printStream) {
        for (int i = 258; i < this.numStrings_; i++) {
            printStream.println(" strNxt_[" + i + "] = " + ((int) this.strNxt_[i]) + " strChr_ " + Integer.toHexString(this.strChr_[i] & 255) + " strLen_ " + Integer.toHexString(this.strLen_[i]));
        }
    }
}
