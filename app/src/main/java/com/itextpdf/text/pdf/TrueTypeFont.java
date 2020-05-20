package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TrueTypeFont extends BaseFont {
    static final String[] codePages = {"1252 Latin 1", "1250 Latin 2: Eastern Europe", "1251 Cyrillic", "1253 Greek", "1254 Turkish", "1255 Hebrew", "1256 Arabic", "1257 Windows Baltic", "1258 Vietnamese", null, null, null, null, null, null, null, "874 Thai", "932 JIS/Japan", "936 Chinese: Simplified chars--PRC and Singapore", "949 Korean Wansung", "950 Chinese: Traditional chars--Taiwan and Hong Kong", "1361 Korean Johab", null, null, null, null, null, null, null, "Macintosh Character Set (US Roman)", "OEM Character Set", "Symbol Character Set", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "869 IBM Greek", "866 MS-DOS Russian", "865 MS-DOS Nordic", "864 Arabic", "863 MS-DOS Canadian French", "862 Hebrew", "861 MS-DOS Icelandic", "860 MS-DOS Portuguese", "857 IBM Turkish", "855 IBM Cyrillic; primarily Russian", "852 Latin 2", "775 MS-DOS Baltic", "737 Greek; former 437 G", "708 Arabic; ASMO 708", "850 WE/Latin 1", "437 US"};
    protected int[] GlyphWidths;
    protected String[][] allNameEntries;
    protected int[][] bboxes;
    protected boolean cff;
    protected int cffLength;
    protected int cffOffset;
    protected HashMap<Integer, int[]> cmap10;
    protected HashMap<Integer, int[]> cmap31;
    protected HashMap<Integer, int[]> cmapExt;
    protected int directoryOffset;
    protected String[][] familyName;
    protected String fileName;
    protected String fontName;
    protected String[][] fullName;
    protected FontHeader head;
    protected HorizontalHeader hhea;
    protected boolean isFixedPitch;
    protected double italicAngle;
    protected boolean justNames;
    protected IntHashtable kerning;
    protected WindowsMetrics os_2;

    /* renamed from: rf */
    protected RandomAccessFileOrArray f19810rf;
    protected String style;
    protected HashMap<String, int[]> tables;
    protected String ttcIndex;
    protected int underlinePosition;
    protected int underlineThickness;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class FontHeader {
        int flags;
        int macStyle;
        int unitsPerEm;
        short xMax;
        short xMin;
        short yMax;
        short yMin;

        protected FontHeader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class HorizontalHeader {
        short Ascender;
        short Descender;
        short LineGap;
        int advanceWidthMax;
        short caretSlopeRise;
        short caretSlopeRun;
        short minLeftSideBearing;
        short minRightSideBearing;
        int numberOfHMetrics;
        short xMaxExtent;

        protected HorizontalHeader() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class WindowsMetrics {
        int fsSelection;
        short fsType;
        int sCapHeight;
        short sFamilyClass;
        short sTypoAscender;
        short sTypoDescender;
        short sTypoLineGap;
        int ulCodePageRange1;
        int ulCodePageRange2;
        int usFirstCharIndex;
        int usLastCharIndex;
        int usWeightClass;
        int usWidthClass;
        int usWinAscent;
        int usWinDescent;
        short xAvgCharWidth;
        short yStrikeoutPosition;
        short yStrikeoutSize;
        short ySubscriptXOffset;
        short ySubscriptXSize;
        short ySubscriptYOffset;
        short ySubscriptYSize;
        short ySuperscriptXOffset;
        short ySuperscriptXSize;
        short ySuperscriptYOffset;
        short ySuperscriptYSize;
        byte[] panose = new byte[10];
        byte[] achVendID = new byte[4];

        protected WindowsMetrics() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrueTypeFont() {
        this.justNames = false;
        this.cff = false;
        this.style = "";
        this.head = new FontHeader();
        this.hhea = new HorizontalHeader();
        this.os_2 = new WindowsMetrics();
        this.kerning = new IntHashtable();
        this.isFixedPitch = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrueTypeFont(String str, String str2, boolean z, byte[] bArr, boolean z2, boolean z3) throws DocumentException, IOException {
        this.justNames = false;
        this.cff = false;
        this.style = "";
        this.head = new FontHeader();
        this.hhea = new HorizontalHeader();
        this.os_2 = new WindowsMetrics();
        this.kerning = new IntHashtable();
        this.isFixedPitch = false;
        this.justNames = z2;
        String baseName = getBaseName(str);
        String tTCName = getTTCName(baseName);
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = tTCName;
        this.fontType = 1;
        this.ttcIndex = "";
        if (tTCName.length() < baseName.length()) {
            this.ttcIndex = baseName.substring(tTCName.length() + 1);
        }
        if (this.fileName.toLowerCase().endsWith(".ttf") || this.fileName.toLowerCase().endsWith(".otf") || this.fileName.toLowerCase().endsWith(".ttc")) {
            process(bArr, z3);
            if (!z2 && this.embedded && this.os_2.fsType == 2) {
                throw new DocumentException(MessageLocalization.getComposedMessage("1.cannot.be.embedded.due.to.licensing.restrictions", this.fileName + this.style));
            }
            if (!this.encoding.startsWith("#")) {
                PdfEncodings.convertToBytes(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, str2);
            }
            createEncoding();
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.ttf.otf.or.ttc.font.file", this.fileName + this.style));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getTTCName(String str) {
        int indexOf = str.toLowerCase().indexOf(".ttc,");
        return indexOf < 0 ? str : str.substring(0, indexOf + 4);
    }

    void fillTables() throws DocumentException, IOException {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (this.tables.get("head") == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "head", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0] + 16);
        this.head.flags = this.f19810rf.readUnsignedShort();
        this.head.unitsPerEm = this.f19810rf.readUnsignedShort();
        this.f19810rf.skipBytes(16);
        this.head.xMin = this.f19810rf.readShort();
        this.head.yMin = this.f19810rf.readShort();
        this.head.xMax = this.f19810rf.readShort();
        this.head.yMax = this.f19810rf.readShort();
        this.head.macStyle = this.f19810rf.readUnsignedShort();
        if (this.tables.get("hhea") == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "hhea", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr2[0] + 4);
        this.hhea.Ascender = this.f19810rf.readShort();
        this.hhea.Descender = this.f19810rf.readShort();
        this.hhea.LineGap = this.f19810rf.readShort();
        this.hhea.advanceWidthMax = this.f19810rf.readUnsignedShort();
        this.hhea.minLeftSideBearing = this.f19810rf.readShort();
        this.hhea.minRightSideBearing = this.f19810rf.readShort();
        this.hhea.xMaxExtent = this.f19810rf.readShort();
        this.hhea.caretSlopeRise = this.f19810rf.readShort();
        this.hhea.caretSlopeRun = this.f19810rf.readShort();
        this.f19810rf.skipBytes(12);
        this.hhea.numberOfHMetrics = this.f19810rf.readUnsignedShort();
        if (this.tables.get("OS/2") == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "OS/2", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr3[0]);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        this.os_2.xAvgCharWidth = this.f19810rf.readShort();
        this.os_2.usWeightClass = this.f19810rf.readUnsignedShort();
        this.os_2.usWidthClass = this.f19810rf.readUnsignedShort();
        this.os_2.fsType = this.f19810rf.readShort();
        this.os_2.ySubscriptXSize = this.f19810rf.readShort();
        this.os_2.ySubscriptYSize = this.f19810rf.readShort();
        this.os_2.ySubscriptXOffset = this.f19810rf.readShort();
        this.os_2.ySubscriptYOffset = this.f19810rf.readShort();
        this.os_2.ySuperscriptXSize = this.f19810rf.readShort();
        this.os_2.ySuperscriptYSize = this.f19810rf.readShort();
        this.os_2.ySuperscriptXOffset = this.f19810rf.readShort();
        this.os_2.ySuperscriptYOffset = this.f19810rf.readShort();
        this.os_2.yStrikeoutSize = this.f19810rf.readShort();
        this.os_2.yStrikeoutPosition = this.f19810rf.readShort();
        this.os_2.sFamilyClass = this.f19810rf.readShort();
        this.f19810rf.readFully(this.os_2.panose);
        this.f19810rf.skipBytes(16);
        this.f19810rf.readFully(this.os_2.achVendID);
        this.os_2.fsSelection = this.f19810rf.readUnsignedShort();
        this.os_2.usFirstCharIndex = this.f19810rf.readUnsignedShort();
        this.os_2.usLastCharIndex = this.f19810rf.readUnsignedShort();
        this.os_2.sTypoAscender = this.f19810rf.readShort();
        this.os_2.sTypoDescender = this.f19810rf.readShort();
        if (this.os_2.sTypoDescender > 0) {
            WindowsMetrics windowsMetrics = this.os_2;
            windowsMetrics.sTypoDescender = (short) (-windowsMetrics.sTypoDescender);
        }
        this.os_2.sTypoLineGap = this.f19810rf.readShort();
        this.os_2.usWinAscent = this.f19810rf.readUnsignedShort();
        this.os_2.usWinDescent = this.f19810rf.readUnsignedShort();
        WindowsMetrics windowsMetrics2 = this.os_2;
        windowsMetrics2.ulCodePageRange1 = 0;
        windowsMetrics2.ulCodePageRange2 = 0;
        if (readUnsignedShort > 0) {
            windowsMetrics2.ulCodePageRange1 = this.f19810rf.readInt();
            this.os_2.ulCodePageRange2 = this.f19810rf.readInt();
        }
        if (readUnsignedShort > 1) {
            this.f19810rf.skipBytes(2);
            this.os_2.sCapHeight = this.f19810rf.readShort();
        } else {
            WindowsMetrics windowsMetrics3 = this.os_2;
            double d = this.head.unitsPerEm;
            Double.isNaN(d);
            windowsMetrics3.sCapHeight = (int) (d * 0.7d);
        }
        if (this.tables.get("post") == null) {
            this.italicAngle = ((-Math.atan2(this.hhea.caretSlopeRun, this.hhea.caretSlopeRise)) * 180.0d) / 3.141592653589793d;
            return;
        }
        this.f19810rf.seek(iArr4[0] + 4);
        double readShort = this.f19810rf.readShort();
        double readUnsignedShort2 = this.f19810rf.readUnsignedShort();
        Double.isNaN(readUnsignedShort2);
        Double.isNaN(readShort);
        this.italicAngle = readShort + (readUnsignedShort2 / 16384.0d);
        this.underlinePosition = this.f19810rf.readShort();
        this.underlineThickness = this.f19810rf.readShort();
        this.isFixedPitch = this.f19810rf.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseFont() throws DocumentException, IOException {
        int[] iArr = this.tables.get("name");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0] + 2);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            int readUnsignedShort3 = this.f19810rf.readUnsignedShort();
            this.f19810rf.readUnsignedShort();
            this.f19810rf.readUnsignedShort();
            int readUnsignedShort4 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort5 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort6 = this.f19810rf.readUnsignedShort();
            if (readUnsignedShort4 == 6) {
                this.f19810rf.seek(iArr[0] + readUnsignedShort2 + readUnsignedShort6);
                if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3) {
                    return readUnicodeString(readUnsignedShort5);
                }
                return readStandardString(readUnsignedShort5);
            }
        }
        return new File(this.fileName).getName().replace(TokenParser.f24154SP, SignatureVisitor.SUPER);
    }

    String[][] getNames(int i) throws DocumentException, IOException {
        int i2;
        String readUnicodeString;
        int[] iArr = this.tables.get("name");
        char c = 0;
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0] + 2);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < readUnsignedShort) {
            int readUnsignedShort3 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort4 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort5 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort6 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort7 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort8 = this.f19810rf.readUnsignedShort();
            if (readUnsignedShort6 == i) {
                int filePointer = (int) this.f19810rf.getFilePointer();
                i2 = readUnsignedShort;
                this.f19810rf.seek(iArr[c] + readUnsignedShort2 + readUnsignedShort8);
                if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                    readUnicodeString = readUnicodeString(readUnsignedShort7);
                } else {
                    readUnicodeString = readStandardString(readUnsignedShort7);
                }
                arrayList.add(new String[]{String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), readUnicodeString});
                this.f19810rf.seek(filePointer);
            } else {
                i2 = readUnsignedShort;
            }
            i3++;
            readUnsignedShort = i2;
            c = 0;
        }
        String[][] strArr = new String[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            strArr[i4] = (String[]) arrayList.get(i4);
        }
        return strArr;
    }

    String[][] getAllNames() throws DocumentException, IOException {
        String readUnicodeString;
        int[] iArr = this.tables.get("name");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "name", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0] + 2);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readUnsignedShort; i++) {
            int readUnsignedShort3 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort4 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort5 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort6 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort7 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort8 = this.f19810rf.readUnsignedShort();
            int filePointer = (int) this.f19810rf.getFilePointer();
            this.f19810rf.seek(iArr[0] + readUnsignedShort2 + readUnsignedShort8);
            if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                readUnicodeString = readUnicodeString(readUnsignedShort7);
            } else {
                readUnicodeString = readStandardString(readUnsignedShort7);
            }
            arrayList.add(new String[]{String.valueOf(readUnsignedShort6), String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), readUnicodeString});
            this.f19810rf.seek(filePointer);
        }
        String[][] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String[]) arrayList.get(i2);
        }
        return strArr;
    }

    void checkCff() {
        int[] iArr = this.tables.get("CFF ");
        if (iArr != null) {
            this.cff = true;
            this.cffOffset = iArr[0];
            this.cffLength = iArr[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void process(byte[] bArr, boolean z) throws DocumentException, IOException {
        this.tables = new HashMap<>();
        try {
            if (bArr == null) {
                this.f19810rf = new RandomAccessFileOrArray(this.fileName, z, Document.plainRandomAccess);
            } else {
                this.f19810rf = new RandomAccessFileOrArray(bArr);
            }
            if (this.ttcIndex.length() > 0) {
                int parseInt = Integer.parseInt(this.ttcIndex);
                if (parseInt < 0) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("the.font.index.for.1.must.be.positive", this.fileName));
                }
                if (!readStandardString(4).equals("ttcf")) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttc.file", this.fileName));
                }
                this.f19810rf.skipBytes(4);
                int readInt = this.f19810rf.readInt();
                if (parseInt >= readInt) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("the.font.index.for.1.must.be.between.0.and.2.it.was.3", this.fileName, String.valueOf(readInt - 1), String.valueOf(parseInt)));
                }
                this.f19810rf.skipBytes(parseInt * 4);
                this.directoryOffset = this.f19810rf.readInt();
            }
            this.f19810rf.seek(this.directoryOffset);
            int readInt2 = this.f19810rf.readInt();
            if (readInt2 != 65536 && readInt2 != 1330926671) {
                throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.a.valid.ttf.or.otf.file", this.fileName));
            }
            int readUnsignedShort = this.f19810rf.readUnsignedShort();
            this.f19810rf.skipBytes(6);
            for (int i = 0; i < readUnsignedShort; i++) {
                String readStandardString = readStandardString(4);
                this.f19810rf.skipBytes(4);
                this.tables.put(readStandardString, new int[]{this.f19810rf.readInt(), this.f19810rf.readInt()});
            }
            checkCff();
            this.fontName = getBaseFont();
            this.fullName = getNames(4);
            this.familyName = getNames(1);
            this.allNameEntries = getAllNames();
            if (!this.justNames) {
                fillTables();
                readGlyphWidths();
                readCMaps();
                readKerning();
                readBbox();
                this.GlyphWidths = null;
            }
        } finally {
            RandomAccessFileOrArray randomAccessFileOrArray = this.f19810rf;
            if (randomAccessFileOrArray != null) {
                randomAccessFileOrArray.close();
                if (!this.embedded) {
                    this.f19810rf = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String readStandardString(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.f19810rf.readFully(bArr);
        try {
            return new String(bArr, "Cp1252");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    protected String readUnicodeString(int i) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i / 2;
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(this.f19810rf.readChar());
        }
        return stringBuffer.toString();
    }

    protected void readGlyphWidths() throws DocumentException, IOException {
        int[] iArr = this.tables.get("hmtx");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "hmtx", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0]);
        this.GlyphWidths = new int[this.hhea.numberOfHMetrics];
        for (int i = 0; i < this.hhea.numberOfHMetrics; i++) {
            this.GlyphWidths[i] = (this.f19810rf.readUnsignedShort() * 1000) / this.head.unitsPerEm;
            this.f19810rf.readUnsignedShort();
        }
    }

    protected int getGlyphWidth(int i) {
        int[] iArr = this.GlyphWidths;
        if (i >= iArr.length) {
            i = iArr.length - 1;
        }
        return this.GlyphWidths[i];
    }

    private void readBbox() throws DocumentException, IOException {
        int[] iArr;
        int[] iArr2 = this.tables.get("head");
        if (iArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "head", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr2[0] + 51);
        boolean z = this.f19810rf.readUnsignedShort() == 0;
        int[] iArr3 = this.tables.get("loca");
        if (iArr3 == null) {
            return;
        }
        this.f19810rf.seek(iArr3[0]);
        if (z) {
            int i = iArr3[1] / 2;
            iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = this.f19810rf.readUnsignedShort() * 2;
            }
        } else {
            int i3 = iArr3[1] / 4;
            iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i4] = this.f19810rf.readInt();
            }
        }
        int[] iArr4 = this.tables.get("glyf");
        if (iArr4 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "glyf", this.fileName + this.style));
        }
        int i5 = iArr4[0];
        this.bboxes = new int[iArr.length - 1];
        int i6 = 0;
        while (i6 < iArr.length - 1) {
            int i7 = iArr[i6];
            int i8 = i6 + 1;
            if (i7 != iArr[i8]) {
                this.f19810rf.seek(i7 + i5 + 2);
                int[][] iArr5 = this.bboxes;
                int[] iArr6 = new int[4];
                iArr6[0] = (this.f19810rf.readShort() * 1000) / this.head.unitsPerEm;
                iArr6[1] = (this.f19810rf.readShort() * 1000) / this.head.unitsPerEm;
                iArr6[2] = (this.f19810rf.readShort() * 1000) / this.head.unitsPerEm;
                iArr6[3] = (this.f19810rf.readShort() * 1000) / this.head.unitsPerEm;
                iArr5[i6] = iArr6;
            }
            i6 = i8;
        }
    }

    void readCMaps() throws DocumentException, IOException {
        int[] iArr = this.tables.get("cmap");
        if (iArr == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("table.1.does.not.exist.in.2", "cmap", this.fileName + this.style));
        }
        this.f19810rf.seek(iArr[0]);
        this.f19810rf.skipBytes(2);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        this.fontSpecific = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < readUnsignedShort; i5++) {
            int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
            int readUnsignedShort3 = this.f19810rf.readUnsignedShort();
            int readInt = this.f19810rf.readInt();
            if (readUnsignedShort2 == 3 && readUnsignedShort3 == 0) {
                this.fontSpecific = true;
                i3 = readInt;
            } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 1) {
                i2 = readInt;
            } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 10) {
                i4 = readInt;
            }
            if (readUnsignedShort2 == 1 && readUnsignedShort3 == 0) {
                i = readInt;
            }
        }
        if (i > 0) {
            this.f19810rf.seek(iArr[0] + i);
            int readUnsignedShort4 = this.f19810rf.readUnsignedShort();
            if (readUnsignedShort4 == 0) {
                this.cmap10 = readFormat0();
            } else if (readUnsignedShort4 == 4) {
                this.cmap10 = readFormat4();
            } else if (readUnsignedShort4 == 6) {
                this.cmap10 = readFormat6();
            }
        }
        if (i2 > 0) {
            this.f19810rf.seek(iArr[0] + i2);
            if (this.f19810rf.readUnsignedShort() == 4) {
                this.cmap31 = readFormat4();
            }
        }
        if (i3 > 0) {
            this.f19810rf.seek(iArr[0] + i3);
            if (this.f19810rf.readUnsignedShort() == 4) {
                this.cmap10 = readFormat4();
            }
        }
        if (i4 > 0) {
            this.f19810rf.seek(iArr[0] + i4);
            int readUnsignedShort5 = this.f19810rf.readUnsignedShort();
            if (readUnsignedShort5 == 0) {
                this.cmapExt = readFormat0();
            } else if (readUnsignedShort5 == 4) {
                this.cmapExt = readFormat4();
            } else if (readUnsignedShort5 == 6) {
                this.cmapExt = readFormat6();
            } else if (readUnsignedShort5 == 12) {
                this.cmapExt = readFormat12();
            }
        }
    }

    HashMap<Integer, int[]> readFormat12() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.f19810rf.skipBytes(2);
        this.f19810rf.readInt();
        this.f19810rf.skipBytes(4);
        int readInt = this.f19810rf.readInt();
        for (int i = 0; i < readInt; i++) {
            int readInt2 = this.f19810rf.readInt();
            int readInt3 = this.f19810rf.readInt();
            for (int readInt4 = this.f19810rf.readInt(); readInt4 <= readInt2; readInt4++) {
                int[] iArr = {readInt3, getGlyphWidth(iArr[0])};
                hashMap.put(Integer.valueOf(readInt4), iArr);
                readInt3++;
            }
        }
        return hashMap;
    }

    HashMap<Integer, int[]> readFormat0() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.f19810rf.skipBytes(4);
        for (int i = 0; i < 256; i++) {
            int[] iArr = {this.f19810rf.readUnsignedByte(), getGlyphWidth(iArr[0])};
            hashMap.put(Integer.valueOf(i), iArr);
        }
        return hashMap;
    }

    HashMap<Integer, int[]> readFormat4() throws IOException {
        int i;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        this.f19810rf.skipBytes(2);
        int readUnsignedShort2 = this.f19810rf.readUnsignedShort() / 2;
        this.f19810rf.skipBytes(6);
        int[] iArr = new int[readUnsignedShort2];
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            iArr[i2] = this.f19810rf.readUnsignedShort();
        }
        this.f19810rf.skipBytes(2);
        int[] iArr2 = new int[readUnsignedShort2];
        for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
            iArr2[i3] = this.f19810rf.readUnsignedShort();
        }
        int[] iArr3 = new int[readUnsignedShort2];
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            iArr3[i4] = this.f19810rf.readUnsignedShort();
        }
        int[] iArr4 = new int[readUnsignedShort2];
        for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
            iArr4[i5] = this.f19810rf.readUnsignedShort();
        }
        int[] iArr5 = new int[((readUnsignedShort / 2) - 8) - (readUnsignedShort2 * 4)];
        for (int i6 = 0; i6 < iArr5.length; i6++) {
            iArr5[i6] = this.f19810rf.readUnsignedShort();
        }
        for (int i7 = 0; i7 < readUnsignedShort2; i7++) {
            for (int i8 = iArr2[i7]; i8 <= iArr[i7] && i8 != 65535; i8++) {
                if (iArr4[i7] == 0) {
                    i = 65535 & (iArr3[i7] + i8);
                } else {
                    int i9 = ((((iArr4[i7] / 2) + i7) - readUnsignedShort2) + i8) - iArr2[i7];
                    if (i9 < iArr5.length) {
                        i = 65535 & (iArr5[i9] + iArr3[i7]);
                    }
                }
                int[] iArr6 = {i, getGlyphWidth(iArr6[0])};
                hashMap.put(Integer.valueOf((this.fontSpecific && (65280 & i8) == 61440) ? i8 & 255 : i8), iArr6);
            }
        }
        return hashMap;
    }

    HashMap<Integer, int[]> readFormat6() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.f19810rf.skipBytes(4);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort2; i++) {
            int[] iArr = {this.f19810rf.readUnsignedShort(), getGlyphWidth(iArr[0])};
            hashMap.put(Integer.valueOf(i + readUnsignedShort), iArr);
        }
        return hashMap;
    }

    void readKerning() throws IOException {
        int[] iArr = this.tables.get("kern");
        if (iArr == null) {
            return;
        }
        this.f19810rf.seek(iArr[0] + 2);
        int readUnsignedShort = this.f19810rf.readUnsignedShort();
        int i = iArr[0] + 4;
        int i2 = 0;
        for (int i3 = 0; i3 < readUnsignedShort; i3++) {
            i += i2;
            this.f19810rf.seek(i);
            this.f19810rf.skipBytes(2);
            i2 = this.f19810rf.readUnsignedShort();
            if ((this.f19810rf.readUnsignedShort() & 65527) == 1) {
                int readUnsignedShort2 = this.f19810rf.readUnsignedShort();
                this.f19810rf.skipBytes(6);
                for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
                    this.kerning.put(this.f19810rf.readInt(), (this.f19810rf.readShort() * 1000) / this.head.unitsPerEm);
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        int i3 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return 0;
        }
        return this.kerning.get((i3 << 16) + metricsTT2[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        return metricsTT[1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber((this.os_2.sTypoAscender * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber((this.os_2.sCapHeight * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber((this.os_2.sTypoDescender * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle((this.head.xMin * 1000) / this.head.unitsPerEm, (this.head.yMin * 1000) / this.head.unitsPerEm, (this.head.xMax * 1000) / this.head.unitsPerEm, (this.head.yMax * 1000) / this.head.unitsPerEm));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.put(PdfName.CIDSET, pdfIndirectReference2);
        }
        if (this.cff) {
            if (this.encoding.startsWith("Identity-")) {
                PdfName pdfName = PdfName.FONTNAME;
                pdfDictionary.put(pdfName, new PdfName(str + this.fontName + "-" + this.encoding));
            } else {
                PdfName pdfName2 = PdfName.FONTNAME;
                pdfDictionary.put(pdfName2, new PdfName(str + this.fontName + this.style));
            }
        } else {
            PdfName pdfName3 = PdfName.FONTNAME;
            pdfDictionary.put(pdfName3, new PdfName(str + this.fontName + this.style));
        }
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.italicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(80));
        if (pdfIndirectReference != null) {
            if (this.cff) {
                pdfDictionary.put(PdfName.FONTFILE3, pdfIndirectReference);
            } else {
                pdfDictionary.put(PdfName.FONTFILE2, pdfIndirectReference);
            }
        }
        int i = (this.isFixedPitch ? 1 : 0) | (this.fontSpecific ? 4 : 32);
        if ((this.head.macStyle & 2) != 0) {
            i |= 64;
        }
        if ((this.head.macStyle & 1) != 0) {
            i |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfDictionary;
    }

    protected PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, String str, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        if (this.cff) {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
            PdfName pdfName = PdfName.BASEFONT;
            pdfDictionary.put(pdfName, new PdfName(this.fontName + this.style));
        } else {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TRUETYPE);
            PdfName pdfName2 = PdfName.BASEFONT;
            pdfDictionary.put(pdfName2, new PdfName(str + this.fontName + this.style));
        }
        PdfName pdfName3 = PdfName.BASEFONT;
        pdfDictionary.put(pdfName3, new PdfName(str + this.fontName + this.style));
        if (!this.fontSpecific) {
            int i3 = i;
            while (true) {
                if (i3 > i2) {
                    break;
                } else if (!this.differences[i3].equals(BaseFont.notdef)) {
                    i = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN)) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z) {
                            pdfArray.add(new PdfNumber(i4));
                            z = false;
                        }
                        pdfArray.add(new PdfName(this.differences[i4]));
                    } else {
                        z = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        pdfDictionary.put(PdfName.FIRSTCHAR, new PdfNumber(i));
        pdfDictionary.put(PdfName.LASTCHAR, new PdfNumber(i2));
        PdfArray pdfArray2 = new PdfArray();
        while (i <= i2) {
            if (bArr[i] == 0) {
                pdfArray2.add(new PdfNumber(0));
            } else {
                pdfArray2.add(new PdfNumber(this.widths[i]));
            }
            i++;
        }
        pdfDictionary.put(PdfName.WIDTHS, pdfArray2);
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] getFullFont() throws IOException {
        RandomAccessFileOrArray randomAccessFileOrArray;
        Throwable th;
        try {
            randomAccessFileOrArray = new RandomAccessFileOrArray(this.f19810rf);
        } catch (Throwable th2) {
            randomAccessFileOrArray = null;
            th = th2;
        }
        try {
            randomAccessFileOrArray.reOpen();
            byte[] bArr = new byte[(int) randomAccessFileOrArray.length()];
            randomAccessFileOrArray.readFully(bArr);
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFileOrArray != null) {
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    protected static int[] compactRanges(ArrayList<int[]> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            int[] iArr = arrayList.get(i);
            for (int i2 = 0; i2 < iArr.length; i2 += 2) {
                int i3 = i2 + 1;
                arrayList2.add(new int[]{Math.max(0, Math.min(iArr[i2], iArr[i3])), Math.min(65535, Math.max(iArr[i2], iArr[i3]))});
            }
        }
        int i4 = 0;
        while (i4 < arrayList2.size() - 1) {
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList2.size()) {
                int[] iArr2 = (int[]) arrayList2.get(i4);
                int[] iArr3 = (int[]) arrayList2.get(i6);
                if ((iArr2[0] >= iArr3[0] && iArr2[0] <= iArr3[1]) || (iArr2[1] >= iArr3[0] && iArr2[0] <= iArr3[1])) {
                    iArr2[0] = Math.min(iArr2[0], iArr3[0]);
                    iArr2[1] = Math.max(iArr2[1], iArr3[1]);
                    arrayList2.remove(i6);
                    i6--;
                }
                i6++;
            }
            i4 = i5;
        }
        int[] iArr4 = new int[arrayList2.size() * 2];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            int[] iArr5 = (int[]) arrayList2.get(i7);
            int i8 = i7 * 2;
            iArr4[i8] = iArr5[0];
            iArr4[i8 + 1] = iArr5[1];
        }
        return iArr4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addRangeUni(HashMap<Integer, int[]> hashMap, boolean z, boolean z2) {
        HashMap<Integer, int[]> hashMap2;
        boolean z3;
        if (z2) {
            return;
        }
        if (this.subsetRanges != null || this.directoryOffset > 0) {
            int[] compactRanges = (this.subsetRanges != null || this.directoryOffset <= 0) ? compactRanges(this.subsetRanges) : new int[]{0, 65535};
            if ((this.fontSpecific || (hashMap2 = this.cmap31) == null) && ((this.fontSpecific && this.cmap10 != null) || (hashMap2 = this.cmap31) == null)) {
                hashMap2 = this.cmap10;
            }
            for (Map.Entry<Integer, int[]> entry : hashMap2.entrySet()) {
                int[] value = entry.getValue();
                Integer valueOf = Integer.valueOf(value[0]);
                if (!hashMap.containsKey(valueOf)) {
                    int intValue = entry.getKey().intValue();
                    int i = 0;
                    while (true) {
                        if (i >= compactRanges.length) {
                            z3 = true;
                            break;
                        } else if (intValue >= compactRanges[i] && intValue <= compactRanges[i + 1]) {
                            z3 = false;
                            break;
                        } else {
                            i += 2;
                        }
                    }
                    if (!z3) {
                        hashMap.put(valueOf, z ? new int[]{value[0], value[1], intValue} : null);
                    }
                }
            }
        }
    }

    protected void addRangeUni(HashSet<Integer> hashSet, boolean z) {
        HashMap<Integer, int[]> hashMap;
        if (z) {
            return;
        }
        if (this.subsetRanges != null || this.directoryOffset > 0) {
            int[] compactRanges = (this.subsetRanges != null || this.directoryOffset <= 0) ? compactRanges(this.subsetRanges) : new int[]{0, 65535};
            if ((this.fontSpecific || (hashMap = this.cmap31) == null) && ((this.fontSpecific && this.cmap10 != null) || (hashMap = this.cmap31) == null)) {
                hashMap = this.cmap10;
            }
            for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
                boolean z2 = false;
                Integer valueOf = Integer.valueOf(entry.getValue()[0]);
                if (!hashSet.contains(valueOf)) {
                    int intValue = entry.getKey().intValue();
                    int i = 0;
                    while (true) {
                        if (i >= compactRanges.length) {
                            z2 = true;
                            break;
                        } else if (intValue >= compactRanges[i] && intValue <= compactRanges[i + 1]) {
                            break;
                        } else {
                            i += 2;
                        }
                    }
                    if (!z2) {
                        hashSet.add(valueOf);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i;
        int i2;
        String str;
        PdfIndirectReference pdfIndirectReference2;
        byte[] process;
        int[] metricsTT;
        int intValue = ((Integer) objArr[0]).intValue();
        int intValue2 = ((Integer) objArr[1]).intValue();
        byte[] bArr = (byte[]) objArr[2];
        boolean z = ((Boolean) objArr[3]).booleanValue() && this.subset;
        if (z) {
            i = intValue2;
            i2 = intValue;
        } else {
            int length = bArr.length - 1;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = 1;
            }
            i = length;
            i2 = 0;
        }
        if (!this.embedded) {
            str = "";
            pdfIndirectReference2 = null;
        } else if (this.cff) {
            pdfIndirectReference2 = pdfWriter.addToBody(new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel)).getIndirectReference();
            str = "";
        } else {
            String createSubsetPrefix = z ? createSubsetPrefix() : "";
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i4 = i2; i4 <= i; i4++) {
                if (bArr[i4] != 0) {
                    if (this.specialMap != null) {
                        int[] nameToUnicode = GlyphList.nameToUnicode(this.differences[i4]);
                        metricsTT = nameToUnicode != null ? getMetricsTT(nameToUnicode[0]) : null;
                    } else if (this.fontSpecific) {
                        metricsTT = getMetricsTT(i4);
                    } else {
                        metricsTT = getMetricsTT(this.unicodeDifferences[i4]);
                    }
                    if (metricsTT != null) {
                        hashSet.add(Integer.valueOf(metricsTT[0]));
                    }
                }
            }
            addRangeUni(hashSet, z);
            if (z || this.directoryOffset != 0 || this.subsetRanges != null) {
                process = new TrueTypeFontSubSet(this.fileName, new RandomAccessFileOrArray(this.f19810rf), hashSet, this.directoryOffset, true, !z).process();
            } else {
                process = getFullFont();
            }
            pdfIndirectReference2 = pdfWriter.addToBody(new BaseFont.StreamFont(process, new int[]{process.length}, this.compressionLevel)).getIndirectReference();
            str = createSubsetPrefix;
        }
        PdfDictionary fontDescriptor = getFontDescriptor(pdfIndirectReference2, str, null);
        pdfWriter.addToBody(getFontBaseType(fontDescriptor != null ? pdfWriter.addToBody(fontDescriptor).getIndirectReference() : pdfIndirectReference2, str, i2, i, bArr), pdfIndirectReference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] readCffFont() throws IOException {
        RandomAccessFileOrArray randomAccessFileOrArray = new RandomAccessFileOrArray(this.f19810rf);
        byte[] bArr = new byte[this.cffLength];
        try {
            randomAccessFileOrArray.reOpen();
            randomAccessFileOrArray.seek(this.cffOffset);
            randomAccessFileOrArray.readFully(bArr);
            return bArr;
        } finally {
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() throws IOException, DocumentException {
        if (this.cff) {
            return new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel);
        }
        byte[] fullFont = getFullFont();
        return new BaseFont.StreamFont(fullFont, new int[]{fullFont.length}, this.compressionLevel);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        switch (i) {
            case 1:
                return (this.os_2.sTypoAscender * f) / this.head.unitsPerEm;
            case 2:
                return (this.os_2.sCapHeight * f) / this.head.unitsPerEm;
            case 3:
                return (this.os_2.sTypoDescender * f) / this.head.unitsPerEm;
            case 4:
                return (float) this.italicAngle;
            case 5:
                return (f * this.head.xMin) / this.head.unitsPerEm;
            case 6:
                return (f * this.head.yMin) / this.head.unitsPerEm;
            case 7:
                return (f * this.head.xMax) / this.head.unitsPerEm;
            case 8:
                return (f * this.head.yMax) / this.head.unitsPerEm;
            case 9:
                return (f * this.hhea.Ascender) / this.head.unitsPerEm;
            case 10:
                return (f * this.hhea.Descender) / this.head.unitsPerEm;
            case 11:
                return (f * this.hhea.LineGap) / this.head.unitsPerEm;
            case 12:
                return (f * this.hhea.advanceWidthMax) / this.head.unitsPerEm;
            case 13:
                return ((this.underlinePosition - (this.underlineThickness / 2)) * f) / this.head.unitsPerEm;
            case 14:
                return (this.underlineThickness * f) / this.head.unitsPerEm;
            case 15:
                return (this.os_2.yStrikeoutPosition * f) / this.head.unitsPerEm;
            case 16:
                return (this.os_2.yStrikeoutSize * f) / this.head.unitsPerEm;
            case 17:
                return (this.os_2.ySubscriptYSize * f) / this.head.unitsPerEm;
            case 18:
                return ((-this.os_2.ySubscriptYOffset) * f) / this.head.unitsPerEm;
            case 19:
                return (this.os_2.ySuperscriptYSize * f) / this.head.unitsPerEm;
            case 20:
                return (this.os_2.ySuperscriptYOffset * f) / this.head.unitsPerEm;
            case 21:
                return this.os_2.usWeightClass;
            case 22:
                return this.os_2.usWidthClass;
            default:
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    public int[] getMetricsTT(int i) {
        HashMap<Integer, int[]> hashMap;
        HashMap<Integer, int[]> hashMap2;
        HashMap<Integer, int[]> hashMap3 = this.cmapExt;
        if (hashMap3 != null) {
            return hashMap3.get(Integer.valueOf(i));
        }
        if (!this.fontSpecific && (hashMap2 = this.cmap31) != null) {
            return hashMap2.get(Integer.valueOf(i));
        }
        if (this.fontSpecific && (hashMap = this.cmap10) != null) {
            return hashMap.get(Integer.valueOf(i));
        }
        HashMap<Integer, int[]> hashMap4 = this.cmap31;
        if (hashMap4 != null) {
            return hashMap4.get(Integer.valueOf(i));
        }
        HashMap<Integer, int[]> hashMap5 = this.cmap10;
        if (hashMap5 != null) {
            return hashMap5.get(Integer.valueOf(i));
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.fontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[] getCodePagesSupported() {
        long j = (this.os_2.ulCodePageRange2 << 32) + (this.os_2.ulCodePageRange1 & 4294967295L);
        long j2 = 1;
        long j3 = 1;
        int i = 0;
        for (int i2 = 0; i2 < 64; i2++) {
            if ((j & j3) != 0 && codePages[i2] != null) {
                i++;
            }
            j3 <<= 1;
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((j & j2) != 0) {
                String[] strArr2 = codePages;
                if (strArr2[i4] != null) {
                    strArr[i3] = strArr2[i4];
                    i3++;
                }
            }
            j2 <<= 1;
        }
        return strArr;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return this.fullName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return this.allNameEntries;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return this.familyName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return this.kerning.size() > 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return false;
        }
        int i4 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return false;
        }
        this.kerning.put((i4 << 16) + metricsTT2[0], i3);
        return true;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    protected int[] getRawCharBBox(int i, String str) {
        HashMap<Integer, int[]> hashMap;
        int[] iArr;
        int[][] iArr2;
        if (str == null || (hashMap = this.cmap31) == null) {
            hashMap = this.cmap10;
        }
        if (hashMap == null || (iArr = hashMap.get(Integer.valueOf(i))) == null || (iArr2 = this.bboxes) == null) {
            return null;
        }
        return iArr2[iArr[0]];
    }
}
