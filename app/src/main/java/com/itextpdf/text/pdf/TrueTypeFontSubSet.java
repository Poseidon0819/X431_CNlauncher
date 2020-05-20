package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
class TrueTypeFontSubSet {
    static final int ARG_1_AND_2_ARE_WORDS = 1;
    static final int HEAD_LOCA_FORMAT_OFFSET = 51;
    static final int MORE_COMPONENTS = 32;
    static final int TABLE_CHECKSUM = 0;
    static final int TABLE_LENGTH = 2;
    static final int TABLE_OFFSET = 1;
    static final int WE_HAVE_AN_X_AND_Y_SCALE = 64;
    static final int WE_HAVE_A_SCALE = 8;
    static final int WE_HAVE_A_TWO_BY_TWO = 128;
    protected int directoryOffset;
    protected String fileName;
    protected int fontPtr;
    protected int glyfTableRealSize;
    protected ArrayList<Integer> glyphsInList;
    protected HashSet<Integer> glyphsUsed;
    protected boolean includeCmap;
    protected boolean includeExtras;
    protected boolean locaShortTable;
    protected int[] locaTable;
    protected int locaTableRealSize;
    protected byte[] newGlyfTable;
    protected int[] newLocaTable;
    protected byte[] newLocaTableOut;
    protected byte[] outFont;

    /* renamed from: rf */
    protected RandomAccessFileOrArray f19811rf;
    protected HashMap<String, int[]> tableDirectory;
    protected int tableGlyphOffset;
    static final String[] tableNamesSimple = {"cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final String[] tableNamesCmap = {"cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final String[] tableNamesExtra = {"OS/2", "cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "name, prep"};
    static final int[] entrySelectors = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrueTypeFontSubSet(String str, RandomAccessFileOrArray randomAccessFileOrArray, HashSet<Integer> hashSet, int i, boolean z, boolean z2) {
        this.fileName = str;
        this.f19811rf = randomAccessFileOrArray;
        this.glyphsUsed = hashSet;
        this.includeCmap = z;
        this.includeExtras = z2;
        this.directoryOffset = i;
        this.glyphsInList = new ArrayList<>(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] process() throws IOException, DocumentException {
        try {
            this.f19811rf.reOpen();
            createTableDirectory();
            readLoca();
            flatGlyphs();
            createNewGlyphTables();
            locaTobytes();
            assembleFont();
            return this.outFont;
        } finally {
            try {
                this.f19811rf.close();
            } catch (Exception unused) {
            }
        }
    }

    protected void assembleFont() throws IOException {
        String[] strArr;
        int i;
        int[] iArr;
        if (this.includeExtras) {
            strArr = tableNamesExtra;
        } else if (this.includeCmap) {
            strArr = tableNamesCmap;
        } else {
            strArr = tableNamesSimple;
        }
        int i2 = 0;
        int i3 = 2;
        for (String str : strArr) {
            if (!str.equals("glyf") && !str.equals("loca") && (iArr = this.tableDirectory.get(str)) != null) {
                i3++;
                i2 += (iArr[2] + 3) & (-4);
            }
        }
        int i4 = (i3 * 16) + 12;
        this.outFont = new byte[i2 + this.newLocaTableOut.length + this.newGlyfTable.length + i4];
        this.fontPtr = 0;
        writeFontInt(65536);
        writeFontShort(i3);
        int i5 = entrySelectors[i3];
        int i6 = 1 << i5;
        writeFontShort(i6 * 16);
        writeFontShort(i5);
        writeFontShort((i3 - i6) * 16);
        int i7 = i4;
        for (String str2 : strArr) {
            int[] iArr2 = this.tableDirectory.get(str2);
            if (iArr2 != null) {
                writeFontString(str2);
                if (str2.equals("glyf")) {
                    writeFontInt(calculateChecksum(this.newGlyfTable));
                    i = this.glyfTableRealSize;
                } else if (str2.equals("loca")) {
                    writeFontInt(calculateChecksum(this.newLocaTableOut));
                    i = this.locaTableRealSize;
                } else {
                    writeFontInt(iArr2[0]);
                    i = iArr2[2];
                }
                writeFontInt(i7);
                writeFontInt(i);
                i7 += (i + 3) & (-4);
            }
        }
        for (String str3 : strArr) {
            int[] iArr3 = this.tableDirectory.get(str3);
            if (iArr3 != null) {
                if (str3.equals("glyf")) {
                    byte[] bArr = this.newGlyfTable;
                    System.arraycopy(bArr, 0, this.outFont, this.fontPtr, bArr.length);
                    this.fontPtr += this.newGlyfTable.length;
                    this.newGlyfTable = null;
                } else if (str3.equals("loca")) {
                    byte[] bArr2 = this.newLocaTableOut;
                    System.arraycopy(bArr2, 0, this.outFont, this.fontPtr, bArr2.length);
                    this.fontPtr += this.newLocaTableOut.length;
                    this.newLocaTableOut = null;
                } else {
                    this.f19811rf.seek(iArr3[1]);
                    this.f19811rf.readFully(this.outFont, this.fontPtr, iArr3[2]);
                    this.fontPtr += (iArr3[2] + 3) & (-4);
                }
            }
        }
    }

    protected void createTableDirectory() throws IOException, DocumentException {
        this.tableDirectory = new HashMap<>();
        this.f19811rf.seek(this.directoryOffset);
        if (this.f19811rf.readInt() != 65536) {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.true.type.file", this.fileName));
        }
        int readUnsignedShort = this.f19811rf.readUnsignedShort();
        this.f19811rf.skipBytes(6);
        for (int i = 0; i < readUnsignedShort; i++) {
            this.tableDirectory.put(readStandardString(4), new int[]{this.f19811rf.readInt(), this.f19811rf.readInt(), this.f19811rf.readInt()});
        }
    }

    protected void readLoca() throws IOException, DocumentException {
        int[] iArr = this.tableDirectory.get("head");
        int i = 0;
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "head", this.fileName));
        }
        this.f19811rf.seek(iArr[1] + 51);
        this.locaShortTable = this.f19811rf.readUnsignedShort() == 0;
        int[] iArr2 = this.tableDirectory.get("loca");
        if (iArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "loca", this.fileName));
        }
        this.f19811rf.seek(iArr2[1]);
        if (this.locaShortTable) {
            int i2 = iArr2[2] / 2;
            this.locaTable = new int[i2];
            while (i < i2) {
                this.locaTable[i] = this.f19811rf.readUnsignedShort() * 2;
                i++;
            }
            return;
        }
        int i3 = iArr2[2] / 4;
        this.locaTable = new int[i3];
        while (i < i3) {
            this.locaTable[i] = this.f19811rf.readInt();
            i++;
        }
    }

    protected void createNewGlyphTables() throws IOException {
        int i;
        this.newLocaTable = new int[this.locaTable.length];
        int[] iArr = new int[this.glyphsInList.size()];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = this.glyphsInList.get(i3).intValue();
        }
        Arrays.sort(iArr);
        int i4 = 0;
        for (int i5 : iArr) {
            int[] iArr2 = this.locaTable;
            i4 += iArr2[i5 + 1] - iArr2[i5];
        }
        this.glyfTableRealSize = i4;
        this.newGlyfTable = new byte[(i4 + 3) & (-4)];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr3 = this.newLocaTable;
            if (i2 >= iArr3.length) {
                return;
            }
            iArr3[i2] = i6;
            if (i7 < iArr.length && iArr[i7] == i2) {
                i7++;
                iArr3[i2] = i6;
                int[] iArr4 = this.locaTable;
                int i8 = iArr4[i2 + 1] - iArr4[i2];
                if (i8 > 0) {
                    this.f19811rf.seek(this.tableGlyphOffset + i);
                    this.f19811rf.readFully(this.newGlyfTable, i6, i8);
                    i6 += i8;
                }
            }
            i2++;
        }
    }

    protected void locaTobytes() {
        if (this.locaShortTable) {
            this.locaTableRealSize = this.newLocaTable.length * 2;
        } else {
            this.locaTableRealSize = this.newLocaTable.length * 4;
        }
        this.newLocaTableOut = new byte[(this.locaTableRealSize + 3) & (-4)];
        this.outFont = this.newLocaTableOut;
        int i = 0;
        this.fontPtr = 0;
        while (true) {
            int[] iArr = this.newLocaTable;
            if (i >= iArr.length) {
                return;
            }
            if (this.locaShortTable) {
                writeFontShort(iArr[i] / 2);
            } else {
                writeFontInt(iArr[i]);
            }
            i++;
        }
    }

    protected void flatGlyphs() throws IOException, DocumentException {
        int[] iArr = this.tableDirectory.get("glyf");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "glyf", this.fileName));
        }
        if (!this.glyphsUsed.contains(0)) {
            this.glyphsUsed.add(0);
            this.glyphsInList.add(0);
        }
        this.tableGlyphOffset = iArr[1];
        for (int i = 0; i < this.glyphsInList.size(); i++) {
            checkGlyphComposite(this.glyphsInList.get(i).intValue());
        }
    }

    protected void checkGlyphComposite(int i) throws IOException {
        int[] iArr = this.locaTable;
        int i2 = iArr[i];
        if (i2 == iArr[i + 1]) {
            return;
        }
        this.f19811rf.seek(this.tableGlyphOffset + i2);
        if (this.f19811rf.readShort() >= 0) {
            return;
        }
        this.f19811rf.skipBytes(8);
        while (true) {
            int readUnsignedShort = this.f19811rf.readUnsignedShort();
            Integer valueOf = Integer.valueOf(this.f19811rf.readUnsignedShort());
            if (!this.glyphsUsed.contains(valueOf)) {
                this.glyphsUsed.add(valueOf);
                this.glyphsInList.add(valueOf);
            }
            if ((readUnsignedShort & 32) == 0) {
                return;
            }
            int i3 = (readUnsignedShort & 1) != 0 ? 4 : 2;
            if ((readUnsignedShort & 8) != 0) {
                i3 += 2;
            } else if ((readUnsignedShort & 64) != 0) {
                i3 += 4;
            }
            if ((readUnsignedShort & 128) != 0) {
                i3 += 8;
            }
            this.f19811rf.skipBytes(i3);
        }
    }

    protected String readStandardString(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.f19811rf.readFully(bArr);
        try {
            return new String(bArr, "Cp1252");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    protected void writeFontShort(int i) {
        byte[] bArr = this.outFont;
        int i2 = this.fontPtr;
        this.fontPtr = i2 + 1;
        bArr[i2] = (byte) (i >> 8);
        int i3 = this.fontPtr;
        this.fontPtr = i3 + 1;
        bArr[i3] = (byte) i;
    }

    protected void writeFontInt(int i) {
        byte[] bArr = this.outFont;
        int i2 = this.fontPtr;
        this.fontPtr = i2 + 1;
        bArr[i2] = (byte) (i >> 24);
        int i3 = this.fontPtr;
        this.fontPtr = i3 + 1;
        bArr[i3] = (byte) (i >> 16);
        int i4 = this.fontPtr;
        this.fontPtr = i4 + 1;
        bArr[i4] = (byte) (i >> 8);
        int i5 = this.fontPtr;
        this.fontPtr = i5 + 1;
        bArr[i5] = (byte) i;
    }

    protected void writeFontString(String str) {
        byte[] convertToBytes = PdfEncodings.convertToBytes(str, "Cp1252");
        System.arraycopy(convertToBytes, 0, this.outFont, this.fontPtr, convertToBytes.length);
        this.fontPtr += convertToBytes.length;
    }

    protected int calculateChecksum(byte[] bArr) {
        int length = bArr.length / 4;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i5 + 1;
            i4 += bArr[i5] & 255;
            int i8 = i7 + 1;
            i3 += bArr[i7] & 255;
            int i9 = i8 + 1;
            i2 += bArr[i8] & 255;
            i5 = i9 + 1;
            i += bArr[i9] & 255;
        }
        return i + (i2 << 8) + (i3 << 16) + (i4 << 24);
    }
}
