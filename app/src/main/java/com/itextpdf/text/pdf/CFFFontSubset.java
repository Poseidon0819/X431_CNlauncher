package com.itextpdf.text.pdf;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.CFFFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class CFFFontSubset extends CFFFont {
    static final byte ENDCHAR_OP = 14;
    static final byte RETURN_OP = 11;
    HashSet<Integer> FDArrayUsed;
    int GBias;
    HashMap<Integer, int[]> GlyphsUsed;
    byte[] NewCharStringsIndex;
    byte[] NewGSubrsIndex;
    byte[][] NewLSubrsIndex;
    byte[] NewSubrsIndexNonCID;
    int NumOfHints;
    LinkedList<CFFFont.Item> OutputList;
    ArrayList<Integer> glyphsInList;
    HashMap<Integer, int[]> hGSubrsUsed;
    HashMap<Integer, int[]>[] hSubrsUsed;
    HashMap<Integer, int[]> hSubrsUsedNonCID;
    ArrayList<Integer> lGSubrsUsed;
    ArrayList<Integer>[] lSubrsUsed;
    ArrayList<Integer> lSubrsUsedNonCID;
    static final String[] SubrsFunctions = {"RESERVED_0", "hstem", "RESERVED_2", "vstem", "vmoveto", "rlineto", "hlineto", "vlineto", "rrcurveto", "RESERVED_9", "callsubr", "return", "escape", "RESERVED_13", "endchar", "RESERVED_15", "RESERVED_16", "RESERVED_17", "hstemhm", "hintmask", "cntrmask", "rmoveto", "hmoveto", "vstemhm", "rcurveline", "rlinecurve", "vvcurveto", "hhcurveto", "shortint", "callgsubr", "vhcurveto", "hvcurveto"};
    static final String[] SubrsEscapeFuncs = {"RESERVED_0", "RESERVED_1", "RESERVED_2", "and", "or", "not", "RESERVED_6", "RESERVED_7", "RESERVED_8", "abs", "add", HtmlTags.SUB, HtmlTags.DIV, "RESERVED_13", "neg", "eq", "RESERVED_16", "RESERVED_17", "drop", "RESERVED_19", "put", "get", "ifelse", "random", "mul", "RESERVED_25", "sqrt", "dup", "exch", "index", "roll", "RESERVED_31", "RESERVED_32", "RESERVED_33", "hflex", "flex", "hflex1", "flex1", "RESERVED_REST"};

    public CFFFontSubset(RandomAccessFileOrArray randomAccessFileOrArray, HashMap<Integer, int[]> hashMap) {
        super(randomAccessFileOrArray);
        this.FDArrayUsed = new HashSet<>();
        this.hGSubrsUsed = new HashMap<>();
        this.lGSubrsUsed = new ArrayList<>();
        this.hSubrsUsedNonCID = new HashMap<>();
        this.lSubrsUsedNonCID = new ArrayList<>();
        this.GBias = 0;
        this.NumOfHints = 0;
        this.GlyphsUsed = hashMap;
        this.glyphsInList = new ArrayList<>(hashMap.keySet());
        for (int i = 0; i < this.fonts.length; i++) {
            seek(this.fonts[i].charstringsOffset);
            this.fonts[i].nglyphs = getCard16();
            seek(this.stringIndexOffset);
            this.fonts[i].nstrings = getCard16() + standardStrings.length;
            this.fonts[i].charstringsOffsets = getIndex(this.fonts[i].charstringsOffset);
            if (this.fonts[i].fdselectOffset >= 0) {
                readFDSelect(i);
                BuildFDArrayUsed(i);
            }
            if (this.fonts[i].isCID) {
                ReadFDArray(i);
            }
            this.fonts[i].CharsetLength = CountCharset(this.fonts[i].charsetOffset, this.fonts[i].nglyphs);
        }
    }

    int CountCharset(int i, int i2) {
        seek(i);
        switch (getCard8()) {
            case 0:
                return (i2 * 2) + 1;
            case 1:
                return (CountRange(i2, 1) * 3) + 1;
            case 2:
                return (CountRange(i2, 2) * 4) + 1;
            default:
                return 0;
        }
    }

    int CountRange(int i, int i2) {
        char card16;
        int i3 = 1;
        int i4 = 0;
        while (i3 < i) {
            i4++;
            getCard16();
            if (i2 == 1) {
                card16 = getCard8();
            } else {
                card16 = getCard16();
            }
            i3 += card16 + 1;
        }
        return i4;
    }

    protected void readFDSelect(int i) {
        int i2 = this.fonts[i].nglyphs;
        int[] iArr = new int[i2];
        seek(this.fonts[i].fdselectOffset);
        this.fonts[i].FDSelectFormat = getCard8();
        int i3 = this.fonts[i].FDSelectFormat;
        if (i3 == 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = getCard8();
            }
            this.fonts[i].FDSelectLength = this.fonts[i].nglyphs + 1;
        } else if (i3 == 3) {
            char card16 = getCard16();
            char card162 = getCard16();
            int i5 = 0;
            int i6 = 0;
            while (i5 < card16) {
                char card8 = getCard8();
                char card163 = getCard16();
                int i7 = card163 - card162;
                int i8 = i6;
                for (int i9 = 0; i9 < i7; i9++) {
                    iArr[i8] = card8;
                    i8++;
                }
                i5++;
                card162 = card163;
                i6 = i8;
            }
            this.fonts[i].FDSelectLength = (card16 * 3) + 3 + 2;
        }
        this.fonts[i].FDSelect = iArr;
    }

    protected void BuildFDArrayUsed(int i) {
        int[] iArr = this.fonts[i].FDSelect;
        for (int i2 = 0; i2 < this.glyphsInList.size(); i2++) {
            this.FDArrayUsed.add(Integer.valueOf(iArr[this.glyphsInList.get(i2).intValue()]));
        }
    }

    protected void ReadFDArray(int i) {
        seek(this.fonts[i].fdarrayOffset);
        this.fonts[i].FDArrayCount = getCard16();
        this.fonts[i].FDArrayOffsize = getCard8();
        if (this.fonts[i].FDArrayOffsize < 4) {
            this.fonts[i].FDArrayOffsize++;
        }
        this.fonts[i].FDArrayOffsets = getIndex(this.fonts[i].fdarrayOffset);
    }

    public byte[] Process(String str) throws IOException {
        try {
            this.buf.reOpen();
            int i = 0;
            while (i < this.fonts.length && !str.equals(this.fonts[i].name)) {
                i++;
            }
            if (i != this.fonts.length) {
                if (this.gsubrIndexOffset >= 0) {
                    this.GBias = CalcBias(this.gsubrIndexOffset, i);
                }
                BuildNewCharString(i);
                BuildNewLGSubrs(i);
                return BuildNewFile(i);
            }
            try {
                this.buf.close();
                return null;
            } catch (Exception unused) {
                return null;
            }
        } finally {
            try {
                this.buf.close();
            } catch (Exception unused2) {
            }
        }
    }

    protected int CalcBias(int i, int i2) {
        seek(i);
        char card16 = getCard16();
        if (this.fonts[i2].CharstringType == 1) {
            return 0;
        }
        if (card16 < 1240) {
            return 107;
        }
        return card16 < 33900 ? 1131 : 32768;
    }

    protected void BuildNewCharString(int i) throws IOException {
        this.NewCharStringsIndex = BuildNewIndex(this.fonts[i].charstringsOffsets, this.GlyphsUsed, (byte) 14);
    }

    protected void BuildNewLGSubrs(int i) throws IOException {
        if (this.fonts[i].isCID) {
            this.hSubrsUsed = new HashMap[this.fonts[i].fdprivateOffsets.length];
            this.lSubrsUsed = new ArrayList[this.fonts[i].fdprivateOffsets.length];
            this.NewLSubrsIndex = new byte[this.fonts[i].fdprivateOffsets.length];
            this.fonts[i].PrivateSubrsOffset = new int[this.fonts[i].fdprivateOffsets.length];
            this.fonts[i].PrivateSubrsOffsetsArray = new int[this.fonts[i].fdprivateOffsets.length];
            ArrayList arrayList = new ArrayList(this.FDArrayUsed);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int intValue = ((Integer) arrayList.get(i2)).intValue();
                this.hSubrsUsed[intValue] = new HashMap<>();
                this.lSubrsUsed[intValue] = new ArrayList<>();
                BuildFDSubrsOffsets(i, intValue);
                if (this.fonts[i].PrivateSubrsOffset[intValue] >= 0) {
                    BuildSubrUsed(i, intValue, this.fonts[i].PrivateSubrsOffset[intValue], this.fonts[i].PrivateSubrsOffsetsArray[intValue], this.hSubrsUsed[intValue], this.lSubrsUsed[intValue]);
                    this.NewLSubrsIndex[intValue] = BuildNewIndex(this.fonts[i].PrivateSubrsOffsetsArray[intValue], this.hSubrsUsed[intValue], (byte) 11);
                }
            }
        } else if (this.fonts[i].privateSubrs >= 0) {
            this.fonts[i].SubrsOffsets = getIndex(this.fonts[i].privateSubrs);
            BuildSubrUsed(i, -1, this.fonts[i].privateSubrs, this.fonts[i].SubrsOffsets, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID);
        }
        BuildGSubrsUsed(i);
        if (this.fonts[i].privateSubrs >= 0) {
            this.NewSubrsIndexNonCID = BuildNewIndex(this.fonts[i].SubrsOffsets, this.hSubrsUsedNonCID, (byte) 11);
        }
        this.NewGSubrsIndex = BuildNewIndex(this.gsubrOffsets, this.hGSubrsUsed, (byte) 11);
    }

    protected void BuildFDSubrsOffsets(int i, int i2) {
        this.fonts[i].PrivateSubrsOffset[i2] = -1;
        seek(this.fonts[i].fdprivateOffsets[i2]);
        while (getPosition() < this.fonts[i].fdprivateOffsets[i2] + this.fonts[i].fdprivateLengths[i2]) {
            getDictItem();
            if (this.key == "Subrs") {
                this.fonts[i].PrivateSubrsOffset[i2] = ((Integer) this.args[0]).intValue() + this.fonts[i].fdprivateOffsets[i2];
            }
        }
        if (this.fonts[i].PrivateSubrsOffset[i2] >= 0) {
            this.fonts[i].PrivateSubrsOffsetsArray[i2] = getIndex(this.fonts[i].PrivateSubrsOffset[i2]);
        }
    }

    protected void BuildSubrUsed(int i, int i2, int i3, int[] iArr, HashMap<Integer, int[]> hashMap, ArrayList<Integer> arrayList) {
        int CalcBias = CalcBias(i3, i);
        for (int i4 = 0; i4 < this.glyphsInList.size(); i4++) {
            int intValue = this.glyphsInList.get(i4).intValue();
            int i5 = this.fonts[i].charstringsOffsets[intValue];
            int i6 = this.fonts[i].charstringsOffsets[intValue + 1];
            if (i2 >= 0) {
                EmptyStack();
                this.NumOfHints = 0;
                if (this.fonts[i].FDSelect[intValue] == i2) {
                    ReadASubr(i5, i6, this.GBias, CalcBias, hashMap, arrayList, iArr);
                }
            } else {
                ReadASubr(i5, i6, this.GBias, CalcBias, hashMap, arrayList, iArr);
            }
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int intValue2 = arrayList.get(i7).intValue();
            if (intValue2 < iArr.length - 1 && intValue2 >= 0) {
                ReadASubr(iArr[intValue2], iArr[intValue2 + 1], this.GBias, CalcBias, hashMap, arrayList, iArr);
            }
        }
    }

    protected void BuildGSubrsUsed(int i) {
        int i2;
        int i3;
        if (this.fonts[i].privateSubrs >= 0) {
            i2 = CalcBias(this.fonts[i].privateSubrs, i);
            i3 = this.lSubrsUsedNonCID.size();
        } else {
            i2 = 0;
            i3 = 0;
        }
        for (int i4 = 0; i4 < this.lGSubrsUsed.size(); i4++) {
            int intValue = this.lGSubrsUsed.get(i4).intValue();
            if (intValue < this.gsubrOffsets.length - 1 && intValue >= 0) {
                int i5 = this.gsubrOffsets[intValue];
                int i6 = this.gsubrOffsets[intValue + 1];
                if (this.fonts[i].isCID) {
                    ReadASubr(i5, i6, this.GBias, 0, this.hGSubrsUsed, this.lGSubrsUsed, null);
                } else {
                    ReadASubr(i5, i6, this.GBias, i2, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID, this.fonts[i].SubrsOffsets);
                    if (i3 < this.lSubrsUsedNonCID.size()) {
                        while (i3 < this.lSubrsUsedNonCID.size()) {
                            int intValue2 = this.lSubrsUsedNonCID.get(i3).intValue();
                            if (intValue2 < this.fonts[i].SubrsOffsets.length - 1 && intValue2 >= 0) {
                                ReadASubr(this.fonts[i].SubrsOffsets[intValue2], this.fonts[i].SubrsOffsets[intValue2 + 1], this.GBias, i2, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID, this.fonts[i].SubrsOffsets);
                            }
                            i3++;
                        }
                        i3 = this.lSubrsUsedNonCID.size();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v28 */
    protected void ReadASubr(int i, int i2, int i3, int i4, HashMap<Integer, int[]> hashMap, ArrayList<Integer> arrayList, int[] iArr) {
        EmptyStack();
        this.NumOfHints = 0;
        seek(i);
        while (getPosition() < i2) {
            ReadCommand();
            int position = getPosition();
            Integer num = this.arg_count > 0 ? this.args[this.arg_count - 1] : null;
            int i5 = this.arg_count;
            HandelStack();
            if (this.key == "callsubr") {
                if (i5 > 0) {
                    int intValue = num.intValue() + i4;
                    if (!hashMap.containsKey(Integer.valueOf(intValue))) {
                        hashMap.put(Integer.valueOf(intValue), null);
                        arrayList.add(Integer.valueOf(intValue));
                    }
                    CalcHints(iArr[intValue], iArr[intValue + 1], i4, i3, iArr);
                    seek(position);
                }
            } else if (this.key == "callgsubr") {
                if (i5 > 0) {
                    int intValue2 = num.intValue() + i3;
                    if (!this.hGSubrsUsed.containsKey(Integer.valueOf(intValue2))) {
                        this.hGSubrsUsed.put(Integer.valueOf(intValue2), null);
                        this.lGSubrsUsed.add(Integer.valueOf(intValue2));
                    }
                    CalcHints(this.gsubrOffsets[intValue2], this.gsubrOffsets[intValue2 + 1], i4, i3, iArr);
                    seek(position);
                }
            } else if (this.key == "hstem" || this.key == "vstem" || this.key == "hstemhm" || this.key == "vstemhm") {
                this.NumOfHints += i5 / 2;
            } else if (this.key == "hintmask" || this.key == "cntrmask") {
                int i6 = this.NumOfHints;
                int i7 = i6 / 8;
                if (i6 % 8 != 0 || i7 == 0) {
                    i7++;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    getCard8();
                }
            }
        }
    }

    protected void HandelStack() {
        int StackOpp = StackOpp();
        if (StackOpp >= 2) {
            EmptyStack();
        } else if (StackOpp == 1) {
            PushStack();
        } else {
            int i = StackOpp * (-1);
            for (int i2 = 0; i2 < i; i2++) {
                PopStack();
            }
        }
    }

    protected int StackOpp() {
        if (this.key == "ifelse") {
            return -3;
        }
        if (this.key == "roll" || this.key == "put") {
            return -2;
        }
        if (this.key == "callsubr" || this.key == "callgsubr" || this.key == "add" || this.key == HtmlTags.SUB || this.key == HtmlTags.DIV || this.key == "mul" || this.key == "drop" || this.key == "and" || this.key == "or" || this.key == "eq") {
            return -1;
        }
        if (this.key == "abs" || this.key == "neg" || this.key == "sqrt" || this.key == "exch" || this.key == "index" || this.key == "get" || this.key == "not" || this.key == "return") {
            return 0;
        }
        return (this.key == "random" || this.key == "dup") ? 1 : 2;
    }

    protected void EmptyStack() {
        for (int i = 0; i < this.arg_count; i++) {
            this.args[i] = null;
        }
        this.arg_count = 0;
    }

    protected void PopStack() {
        if (this.arg_count > 0) {
            this.args[this.arg_count - 1] = null;
            this.arg_count--;
        }
    }

    protected void PushStack() {
        this.arg_count++;
    }

    protected void ReadCommand() {
        this.key = null;
        boolean z = false;
        while (!z) {
            char card8 = getCard8();
            if (card8 == 28) {
                this.args[this.arg_count] = Integer.valueOf((getCard8() << '\b') | getCard8());
                this.arg_count++;
            } else if (card8 >= ' ' && card8 <= 246) {
                this.args[this.arg_count] = Integer.valueOf(card8 - 139);
                this.arg_count++;
            } else if (card8 >= 247 && card8 <= 250) {
                this.args[this.arg_count] = Integer.valueOf(((card8 - 247) * 256) + getCard8() + 108);
                this.arg_count++;
            } else if (card8 >= 251 && card8 <= 254) {
                this.args[this.arg_count] = Integer.valueOf((((-(card8 - 251)) * 256) - getCard8()) - 108);
                this.arg_count++;
            } else if (card8 == 255) {
                this.args[this.arg_count] = Integer.valueOf((getCard8() << 24) | (getCard8() << 16) | (getCard8() << '\b') | getCard8());
                this.arg_count++;
            } else if (card8 <= 31 && card8 != 28) {
                if (card8 == '\f') {
                    int card82 = getCard8();
                    String[] strArr = SubrsEscapeFuncs;
                    if (card82 > strArr.length - 1) {
                        card82 = strArr.length - 1;
                    }
                    this.key = SubrsEscapeFuncs[card82];
                } else {
                    this.key = SubrsFunctions[card8];
                }
                z = true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v20 */
    protected int CalcHints(int i, int i2, int i3, int i4, int[] iArr) {
        seek(i);
        while (getPosition() < i2) {
            ReadCommand();
            int position = getPosition();
            Integer num = this.arg_count > 0 ? this.args[this.arg_count - 1] : null;
            int i5 = this.arg_count;
            HandelStack();
            if (this.key == "callsubr") {
                if (i5 > 0) {
                    int intValue = num.intValue() + i3;
                    CalcHints(iArr[intValue], iArr[intValue + 1], i3, i4, iArr);
                    seek(position);
                }
            } else if (this.key == "callgsubr") {
                if (i5 > 0) {
                    int intValue2 = num.intValue() + i4;
                    CalcHints(this.gsubrOffsets[intValue2], this.gsubrOffsets[intValue2 + 1], i3, i4, iArr);
                    seek(position);
                }
            } else if (this.key == "hstem" || this.key == "vstem" || this.key == "hstemhm" || this.key == "vstemhm") {
                this.NumOfHints += i5 / 2;
            } else if (this.key == "hintmask" || this.key == "cntrmask") {
                int i6 = this.NumOfHints;
                int i7 = i6 / 8;
                if (i6 % 8 != 0 || i7 == 0) {
                    i7++;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    getCard8();
                }
            }
        }
        return this.NumOfHints;
    }

    protected byte[] BuildNewIndex(int[] iArr, HashMap<Integer, int[]> hashMap, byte b) throws IOException {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = i2;
            if (hashMap.containsKey(Integer.valueOf(i4))) {
                i2 += iArr[i4 + 1] - iArr[i4];
            } else {
                i3++;
            }
        }
        byte[] bArr = new byte[i2 + i3];
        int i5 = 0;
        while (i < iArr.length - 1) {
            int i6 = iArr2[i];
            int i7 = i + 1;
            int i8 = iArr2[i7];
            int i9 = i6 + i5;
            iArr2[i] = i9;
            if (i6 != i8) {
                this.buf.seek(iArr[i]);
                this.buf.readFully(bArr, i9, i8 - i6);
            } else {
                bArr[i9] = b;
                i5++;
            }
            i = i7;
        }
        int length = iArr.length - 1;
        iArr2[length] = iArr2[length] + i5;
        return AssembleIndex(iArr2, bArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected byte[] AssembleIndex(int[] iArr, byte[] bArr) {
        char length = (char) (iArr.length - 1);
        int i = iArr[iArr.length - 1];
        int i2 = 3;
        byte b = i <= 255 ? (byte) 1 : i <= 65535 ? (byte) 2 : i <= 16777215 ? (byte) 3 : (byte) 4;
        byte[] bArr2 = new byte[((length + 1) * b) + 3 + bArr.length];
        int i3 = 0;
        bArr2[0] = (byte) ((length >>> '\b') & 255);
        bArr2[1] = (byte) ((length >>> 0) & 255);
        bArr2[2] = b;
        for (int i4 : iArr) {
            int i5 = (i4 - iArr[0]) + 1;
            switch (b) {
                case 1:
                    break;
                case 2:
                    bArr2[i2] = (byte) ((i5 >>> 8) & 255);
                    i2++;
                    break;
                case 3:
                    bArr2[i2] = (byte) ((i5 >>> 16) & 255);
                    i2++;
                    bArr2[i2] = (byte) ((i5 >>> 8) & 255);
                    i2++;
                    break;
                case 4:
                    bArr2[i2] = (byte) ((i5 >>> 24) & 255);
                    i2++;
                    bArr2[i2] = (byte) ((i5 >>> 16) & 255);
                    i2++;
                    bArr2[i2] = (byte) ((i5 >>> 8) & 255);
                    i2++;
                    break;
                default:
            }
            bArr2[i2] = (byte) ((i5 >>> 0) & 255);
            i2++;
        }
        int length2 = bArr.length;
        while (i3 < length2) {
            bArr2[i2] = bArr[i3];
            i3++;
            i2++;
        }
        return bArr2;
    }

    protected byte[] BuildNewFile(int i) {
        this.OutputList = new LinkedList<>();
        CopyHeader();
        BuildIndexHeader(1, 1, 1);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) (this.fonts[i].name.length() + 1)));
        this.OutputList.addLast(new CFFFont.StringItem(this.fonts[i].name));
        BuildIndexHeader(1, 2, 1);
        CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(2);
        this.OutputList.addLast(indexOffsetItem);
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem2 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem3 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem4 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem5 = new CFFFont.DictOffsetItem();
        if (!this.fonts[i].isCID) {
            this.OutputList.addLast(new CFFFont.DictNumberItem(this.fonts[i].nstrings));
            this.OutputList.addLast(new CFFFont.DictNumberItem(this.fonts[i].nstrings + 1));
            this.OutputList.addLast(new CFFFont.DictNumberItem(0));
            this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
            this.OutputList.addLast(new CFFFont.UInt8Item((char) 30));
            this.OutputList.addLast(new CFFFont.DictNumberItem(this.fonts[i].nglyphs));
            this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
            this.OutputList.addLast(new CFFFont.UInt8Item(TokenParser.DQUOTE));
        }
        seek(this.topdictOffsets[i]);
        while (getPosition() < this.topdictOffsets[i + 1]) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            if (this.key != "Encoding" && this.key != "Private" && this.key != "FDSelect" && this.key != "FDArray" && this.key != "charset" && this.key != "CharStrings") {
                this.OutputList.add(new CFFFont.RangeItem(this.buf, position, position2 - position));
            }
        }
        CreateKeys(dictOffsetItem3, dictOffsetItem4, dictOffsetItem, dictOffsetItem2);
        this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItem, indexBaseItem));
        if (this.fonts[i].isCID) {
            this.OutputList.addLast(getEntireIndexRange(this.stringIndexOffset));
        } else {
            CreateNewStringIndex(i);
        }
        this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(this.NewGSubrsIndex), 0, this.NewGSubrsIndex.length));
        if (this.fonts[i].isCID) {
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem4));
            if (this.fonts[i].fdselectOffset >= 0) {
                this.OutputList.addLast(new CFFFont.RangeItem(this.buf, this.fonts[i].fdselectOffset, this.fonts[i].FDSelectLength));
            } else {
                CreateFDSelect(dictOffsetItem4, this.fonts[i].nglyphs);
            }
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem));
            this.OutputList.addLast(new CFFFont.RangeItem(this.buf, this.fonts[i].charsetOffset, this.fonts[i].CharsetLength));
            if (this.fonts[i].fdarrayOffset >= 0) {
                this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem3));
                Reconstruct(i);
            } else {
                CreateFDArray(dictOffsetItem3, dictOffsetItem5, i);
            }
        } else {
            CreateFDSelect(dictOffsetItem4, this.fonts[i].nglyphs);
            CreateCharset(dictOffsetItem, this.fonts[i].nglyphs);
            CreateFDArray(dictOffsetItem3, dictOffsetItem5, i);
        }
        if (this.fonts[i].privateOffset >= 0) {
            CFFFont.IndexBaseItem indexBaseItem2 = new CFFFont.IndexBaseItem();
            this.OutputList.addLast(indexBaseItem2);
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem5));
            CFFFont.DictOffsetItem dictOffsetItem6 = new CFFFont.DictOffsetItem();
            CreateNonCIDPrivate(i, dictOffsetItem6);
            CreateNonCIDSubrs(i, indexBaseItem2, dictOffsetItem6);
        }
        this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem2));
        this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(this.NewCharStringsIndex), 0, this.NewCharStringsIndex.length));
        int[] iArr = {0};
        Iterator<CFFFont.Item> it = this.OutputList.iterator();
        while (it.hasNext()) {
            it.next().increment(iArr);
        }
        Iterator<CFFFont.Item> it2 = this.OutputList.iterator();
        while (it2.hasNext()) {
            it2.next().xref();
        }
        byte[] bArr = new byte[iArr[0]];
        Iterator<CFFFont.Item> it3 = this.OutputList.iterator();
        while (it3.hasNext()) {
            it3.next().emit(bArr);
        }
        return bArr;
    }

    protected void CopyHeader() {
        seek(0);
        getCard8();
        getCard8();
        char card8 = getCard8();
        getCard8();
        this.nextIndexOffset = card8;
        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, 0, card8));
    }

    protected void BuildIndexHeader(int i, int i2, int i3) {
        this.OutputList.addLast(new CFFFont.UInt16Item((char) i));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) i2));
        switch (i2) {
            case 1:
                this.OutputList.addLast(new CFFFont.UInt8Item((char) i3));
                return;
            case 2:
                this.OutputList.addLast(new CFFFont.UInt16Item((char) i3));
                return;
            case 3:
                this.OutputList.addLast(new CFFFont.UInt24Item((char) i3));
                return;
            case 4:
                this.OutputList.addLast(new CFFFont.UInt32Item((char) i3));
                return;
            default:
                return;
        }
    }

    protected void CreateKeys(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, CFFFont.OffsetItem offsetItem3, CFFFont.OffsetItem offsetItem4) {
        this.OutputList.addLast(offsetItem);
        this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
        this.OutputList.addLast(new CFFFont.UInt8Item('$'));
        this.OutputList.addLast(offsetItem2);
        this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
        this.OutputList.addLast(new CFFFont.UInt8Item('%'));
        this.OutputList.addLast(offsetItem3);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 15));
        this.OutputList.addLast(offsetItem4);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 17));
    }

    protected void CreateNewStringIndex(int i) {
        int i2;
        String str = this.fonts[i].name + "-OneRange";
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        String concat = "AdobeIdentity".concat(String.valueOf(str));
        int i3 = this.stringOffsets[this.stringOffsets.length - 1] - this.stringOffsets[0];
        int i4 = this.stringOffsets[0] - 1;
        if (concat.length() + i3 <= 255) {
            i2 = 1;
        } else if (concat.length() + i3 <= 65535) {
            i2 = 2;
        } else {
            i2 = concat.length() + i3 <= 16777215 ? 3 : 4;
        }
        this.OutputList.addLast(new CFFFont.UInt16Item((char) ((this.stringOffsets.length - 1) + 3)));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) i2));
        for (int i5 : this.stringOffsets) {
            this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i5 - i4));
        }
        int i6 = (this.stringOffsets[this.stringOffsets.length - 1] - i4) + 5;
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i6));
        int i7 = i6 + 8;
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i7));
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i7 + str.length()));
        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, this.stringOffsets[0], i3));
        this.OutputList.addLast(new CFFFont.StringItem(concat));
    }

    protected void CreateFDSelect(CFFFont.OffsetItem offsetItem, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 3));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 1));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 0));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 0));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) i));
    }

    protected void CreateCharset(CFFFont.OffsetItem offsetItem, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 2));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 1));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) (i - 1)));
    }

    protected void CreateFDArray(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        BuildIndexHeader(1, 1, 1);
        CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(1);
        this.OutputList.addLast(indexOffsetItem);
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        int i2 = this.fonts[i].privateLength;
        int CalcSubrOffsetSize = CalcSubrOffsetSize(this.fonts[i].privateOffset, this.fonts[i].privateLength);
        if (CalcSubrOffsetSize != 0) {
            i2 += 5 - CalcSubrOffsetSize;
        }
        this.OutputList.addLast(new CFFFont.DictNumberItem(i2));
        this.OutputList.addLast(offsetItem2);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 18));
        this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItem, indexBaseItem));
    }

    void Reconstruct(int i) {
        CFFFont.DictOffsetItem[] dictOffsetItemArr = new CFFFont.DictOffsetItem[this.fonts[i].FDArrayOffsets.length - 1];
        CFFFont.IndexBaseItem[] indexBaseItemArr = new CFFFont.IndexBaseItem[this.fonts[i].fdprivateOffsets.length];
        CFFFont.DictOffsetItem[] dictOffsetItemArr2 = new CFFFont.DictOffsetItem[this.fonts[i].fdprivateOffsets.length];
        ReconstructFDArray(i, dictOffsetItemArr);
        ReconstructPrivateDict(i, dictOffsetItemArr, indexBaseItemArr, dictOffsetItemArr2);
        ReconstructPrivateSubrs(i, indexBaseItemArr, dictOffsetItemArr2);
    }

    void ReconstructFDArray(int i, CFFFont.OffsetItem[] offsetItemArr) {
        int i2;
        BuildIndexHeader(this.fonts[i].FDArrayCount, this.fonts[i].FDArrayOffsize, 1);
        CFFFont.IndexOffsetItem[] indexOffsetItemArr = new CFFFont.IndexOffsetItem[this.fonts[i].FDArrayOffsets.length - 1];
        for (int i3 = 0; i3 < this.fonts[i].FDArrayOffsets.length - 1; i3++) {
            indexOffsetItemArr[i3] = new CFFFont.IndexOffsetItem(this.fonts[i].FDArrayOffsize);
            this.OutputList.addLast(indexOffsetItemArr[i3]);
        }
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        int i4 = 0;
        while (i4 < this.fonts[i].FDArrayOffsets.length - 1) {
            seek(this.fonts[i].FDArrayOffsets[i4]);
            while (true) {
                i2 = i4 + 1;
                if (getPosition() < this.fonts[i].FDArrayOffsets[i2]) {
                    int position = getPosition();
                    getDictItem();
                    int position2 = getPosition();
                    if (this.key == "Private") {
                        int intValue = ((Integer) this.args[0]).intValue();
                        int CalcSubrOffsetSize = CalcSubrOffsetSize(this.fonts[i].fdprivateOffsets[i4], this.fonts[i].fdprivateLengths[i4]);
                        if (CalcSubrOffsetSize != 0) {
                            intValue += 5 - CalcSubrOffsetSize;
                        }
                        this.OutputList.addLast(new CFFFont.DictNumberItem(intValue));
                        offsetItemArr[i4] = new CFFFont.DictOffsetItem();
                        this.OutputList.addLast(offsetItemArr[i4]);
                        this.OutputList.addLast(new CFFFont.UInt8Item((char) 18));
                        seek(position2);
                    } else {
                        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position, position2 - position));
                    }
                }
            }
            this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItemArr[i4], indexBaseItem));
            i4 = i2;
        }
    }

    void ReconstructPrivateDict(int i, CFFFont.OffsetItem[] offsetItemArr, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr2) {
        for (int i2 = 0; i2 < this.fonts[i].fdprivateOffsets.length; i2++) {
            this.OutputList.addLast(new CFFFont.MarkerItem(offsetItemArr[i2]));
            indexBaseItemArr[i2] = new CFFFont.IndexBaseItem();
            this.OutputList.addLast(indexBaseItemArr[i2]);
            seek(this.fonts[i].fdprivateOffsets[i2]);
            while (getPosition() < this.fonts[i].fdprivateOffsets[i2] + this.fonts[i].fdprivateLengths[i2]) {
                int position = getPosition();
                getDictItem();
                int position2 = getPosition();
                if (this.key == "Subrs") {
                    offsetItemArr2[i2] = new CFFFont.DictOffsetItem();
                    this.OutputList.addLast(offsetItemArr2[i2]);
                    this.OutputList.addLast(new CFFFont.UInt8Item((char) 19));
                } else {
                    this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position, position2 - position));
                }
            }
        }
    }

    void ReconstructPrivateSubrs(int i, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr) {
        for (int i2 = 0; i2 < this.fonts[i].fdprivateLengths.length; i2++) {
            if (offsetItemArr[i2] != null && this.fonts[i].PrivateSubrsOffset[i2] >= 0) {
                this.OutputList.addLast(new CFFFont.SubrMarkerItem(offsetItemArr[i2], indexBaseItemArr[i2]));
                this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(this.NewLSubrsIndex[i2]), 0, this.NewLSubrsIndex[i2].length));
            }
        }
    }

    int CalcSubrOffsetSize(int i, int i2) {
        seek(i);
        int i3 = 0;
        while (getPosition() < i + i2) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            if (this.key == "Subrs") {
                i3 = (position2 - position) - 1;
            }
        }
        return i3;
    }

    protected int countEntireIndexRange(int i) {
        seek(i);
        char card16 = getCard16();
        if (card16 == 0) {
            return 2;
        }
        char card8 = getCard8();
        seek(i + 2 + 1 + (card16 * card8));
        return ((card16 + 1) * card8) + 3 + (getOffset(card8) - 1);
    }

    void CreateNonCIDPrivate(int i, CFFFont.OffsetItem offsetItem) {
        seek(this.fonts[i].privateOffset);
        while (getPosition() < this.fonts[i].privateOffset + this.fonts[i].privateLength) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            if (this.key == "Subrs") {
                this.OutputList.addLast(offsetItem);
                this.OutputList.addLast(new CFFFont.UInt8Item((char) 19));
            } else {
                this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position, position2 - position));
            }
        }
    }

    void CreateNonCIDSubrs(int i, CFFFont.IndexBaseItem indexBaseItem, CFFFont.OffsetItem offsetItem) {
        this.OutputList.addLast(new CFFFont.SubrMarkerItem(offsetItem, indexBaseItem));
        byte[] bArr = this.NewSubrsIndexNonCID;
        if (bArr != null) {
            this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(bArr), 0, this.NewSubrsIndexNonCID.length));
        }
    }
}
