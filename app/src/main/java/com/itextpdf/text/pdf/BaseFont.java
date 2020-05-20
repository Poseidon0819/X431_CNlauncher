package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public abstract class BaseFont {
    public static final int ASCENT = 1;
    public static final int AWT_ASCENT = 9;
    public static final int AWT_DESCENT = 10;
    public static final int AWT_LEADING = 11;
    public static final int AWT_MAXADVANCE = 12;
    public static final int BBOXLLX = 5;
    public static final int BBOXLLY = 6;
    public static final int BBOXURX = 7;
    public static final int BBOXURY = 8;
    protected static final HashMap<String, PdfName> BuiltinFonts14;
    public static final boolean CACHED = true;
    public static final int CAPHEIGHT = 2;
    public static final char CID_NEWLINE = 32767;
    public static final String COURIER = "Courier";
    public static final String COURIER_BOLD = "Courier-Bold";
    public static final String COURIER_BOLDOBLIQUE = "Courier-BoldOblique";
    public static final String COURIER_OBLIQUE = "Courier-Oblique";
    public static final String CP1250 = "Cp1250";
    public static final String CP1252 = "Cp1252";
    public static final String CP1257 = "Cp1257";
    public static final int DESCENT = 3;
    public static final boolean EMBEDDED = true;
    public static final int FONT_TYPE_CJK = 2;
    public static final int FONT_TYPE_DOCUMENT = 4;
    public static final int FONT_TYPE_T1 = 0;
    public static final int FONT_TYPE_T3 = 5;
    public static final int FONT_TYPE_TT = 1;
    public static final int FONT_TYPE_TTUNI = 3;
    public static final int FONT_WEIGHT = 23;
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_BOLD = "Helvetica-Bold";
    public static final String HELVETICA_BOLDOBLIQUE = "Helvetica-BoldOblique";
    public static final String HELVETICA_OBLIQUE = "Helvetica-Oblique";
    public static final String IDENTITY_H = "Identity-H";
    public static final String IDENTITY_V = "Identity-V";
    public static final int ITALICANGLE = 4;
    public static final String MACROMAN = "MacRoman";
    public static final boolean NOT_CACHED = false;
    public static final boolean NOT_EMBEDDED = false;
    public static final String RESOURCE_PATH = "com/itextpdf/text/pdf/fonts/";
    public static final int STRIKETHROUGH_POSITION = 15;
    public static final int STRIKETHROUGH_THICKNESS = 16;
    public static final int SUBSCRIPT_OFFSET = 18;
    public static final int SUBSCRIPT_SIZE = 17;
    public static final int SUPERSCRIPT_OFFSET = 20;
    public static final int SUPERSCRIPT_SIZE = 19;
    public static final String SYMBOL = "Symbol";
    public static final String TIMES_BOLD = "Times-Bold";
    public static final String TIMES_BOLDITALIC = "Times-BoldItalic";
    public static final String TIMES_ITALIC = "Times-Italic";
    public static final String TIMES_ROMAN = "Times-Roman";
    public static final int UNDERLINE_POSITION = 13;
    public static final int UNDERLINE_THICKNESS = 14;
    public static final int WEIGHT_CLASS = 21;
    public static final int WIDTH_CLASS = 22;
    public static final String WINANSI = "Cp1252";
    public static final String ZAPFDINGBATS = "ZapfDingbats";
    public static final String notdef = ".notdef";
    protected boolean embedded;
    protected String encoding;
    int fontType;
    protected IntHashtable specialMap;
    protected ArrayList<int[]> subsetRanges;
    public static final int[] CHAR_RANGE_LATIN = {0, 383, 8192, 8303, 8352, 8399, 64256, 64262};
    public static final int[] CHAR_RANGE_ARABIC = {0, 127, 1536, 1663, 8352, 8399, 64336, 64511, 65136, 65279};
    public static final int[] CHAR_RANGE_HEBREW = {0, 127, 1424, 1535, 8352, 8399, 64285, 64335};
    public static final int[] CHAR_RANGE_CYRILLIC = {0, 127, 1024, 1327, 8192, 8303, 8352, 8399};
    protected static HashMap<String, BaseFont> fontCache = new HashMap<>();
    protected int[] widths = new int[256];
    protected String[] differences = new String[256];
    protected char[] unicodeDifferences = new char[256];
    protected int[][] charBBoxes = new int[256];
    protected int compressionLevel = -1;
    protected boolean fontSpecific = true;
    protected boolean forceWidthsOutput = false;
    protected boolean directTextToByte = false;
    protected boolean subset = true;
    protected boolean fastWinansi = false;

    public abstract String[][] getAllNameEntries();

    public int getCidCode(int i) {
        return i;
    }

    public abstract String[][] getFamilyFontName();

    public abstract float getFontDescriptor(int i, float f);

    public abstract String[][] getFullFontName();

    abstract PdfStream getFullFontStream() throws IOException, DocumentException;

    public abstract int getKerning(int i, int i2);

    public abstract String getPostscriptFontName();

    protected abstract int[] getRawCharBBox(int i, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getRawWidth(int i, String str);

    public int getUnicodeEquivalent(int i) {
        return i;
    }

    public abstract boolean hasKernPairs();

    public void setFontDescriptor(int i, float f) {
    }

    public abstract boolean setKerning(int i, int i2, int i3);

    public abstract void setPostscriptFontName(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException;

    static {
        HashMap<String, PdfName> hashMap = new HashMap<>();
        BuiltinFonts14 = hashMap;
        hashMap.put("Courier", PdfName.COURIER);
        BuiltinFonts14.put("Courier-Bold", PdfName.COURIER_BOLD);
        BuiltinFonts14.put("Courier-BoldOblique", PdfName.COURIER_BOLDOBLIQUE);
        BuiltinFonts14.put("Courier-Oblique", PdfName.COURIER_OBLIQUE);
        BuiltinFonts14.put("Helvetica", PdfName.HELVETICA);
        BuiltinFonts14.put("Helvetica-Bold", PdfName.HELVETICA_BOLD);
        BuiltinFonts14.put("Helvetica-BoldOblique", PdfName.HELVETICA_BOLDOBLIQUE);
        BuiltinFonts14.put("Helvetica-Oblique", PdfName.HELVETICA_OBLIQUE);
        BuiltinFonts14.put("Symbol", PdfName.SYMBOL);
        BuiltinFonts14.put("Times-Roman", PdfName.TIMES_ROMAN);
        BuiltinFonts14.put("Times-Bold", PdfName.TIMES_BOLD);
        BuiltinFonts14.put("Times-BoldItalic", PdfName.TIMES_BOLDITALIC);
        BuiltinFonts14.put("Times-Italic", PdfName.TIMES_ITALIC);
        BuiltinFonts14.put("ZapfDingbats", PdfName.ZAPFDINGBATS);
    }

    /* loaded from: classes.dex */
    static class StreamFont extends PdfStream {
        public StreamFont(byte[] bArr, int[] iArr, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                int i2 = 0;
                while (i2 < iArr.length) {
                    StringBuilder sb = new StringBuilder("Length");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    put(new PdfName(sb.toString()), new PdfNumber(iArr[i2]));
                    i2 = i3;
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }

        public StreamFont(byte[] bArr, String str, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                if (str != null) {
                    put(PdfName.SUBTYPE, new PdfName(str));
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }
    }

    public static BaseFont createFont() throws DocumentException, IOException {
        return createFont("Helvetica", "Cp1252", false);
    }

    public static BaseFont createFont(String str, String str2, boolean z) throws DocumentException, IOException {
        return createFont(str, str2, z, true, null, null, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2) throws DocumentException, IOException {
        return createFont(str, str2, z, true, null, null, z2);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2) throws DocumentException, IOException {
        return createFont(str, str2, z, z2, bArr, bArr2, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3) throws DocumentException, IOException {
        return createFont(str, str2, z, z2, bArr, bArr2, z3, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3, boolean z4) throws DocumentException, IOException {
        boolean z5;
        BaseFont type1Font;
        BaseFont baseFont;
        String baseName = getBaseName(str);
        String normalizeEncoding = normalizeEncoding(str2);
        boolean containsKey = BuiltinFonts14.containsKey(str);
        boolean isCJKFont = containsKey ? false : CJKFont.isCJKFont(baseName, normalizeEncoding);
        if (containsKey || isCJKFont) {
            z5 = false;
        } else {
            z5 = (normalizeEncoding.equals(IDENTITY_H) || normalizeEncoding.equals(IDENTITY_V)) ? true : z;
        }
        String str3 = str + "\n" + normalizeEncoding + "\n" + z5;
        if (z2) {
            synchronized (fontCache) {
                baseFont = fontCache.get(str3);
            }
            if (baseFont != null) {
                return baseFont;
            }
        }
        if (containsKey || str.toLowerCase().endsWith(".afm") || str.toLowerCase().endsWith(".pfm")) {
            type1Font = new Type1Font(str, normalizeEncoding, z5, bArr, bArr2, z4);
            type1Font.fastWinansi = normalizeEncoding.equals("Cp1252");
        } else if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            if (normalizeEncoding.equals(IDENTITY_H) || normalizeEncoding.equals(IDENTITY_V)) {
                type1Font = new TrueTypeFontUnicode(str, normalizeEncoding, z5, bArr, z4);
            } else {
                type1Font = new TrueTypeFont(str, normalizeEncoding, z5, bArr, false, z4);
                type1Font.fastWinansi = normalizeEncoding.equals("Cp1252");
            }
        } else if (!isCJKFont) {
            if (z3) {
                return null;
            }
            throw new DocumentException(MessageLocalization.getComposedMessage("font.1.with.2.is.not.recognized", str, normalizeEncoding));
        } else {
            type1Font = new CJKFont(str, normalizeEncoding, z5);
        }
        if (z2) {
            synchronized (fontCache) {
                BaseFont baseFont2 = fontCache.get(str3);
                if (baseFont2 != null) {
                    return baseFont2;
                }
                fontCache.put(str3, type1Font);
            }
        }
        return type1Font;
    }

    public static BaseFont createFont(PRIndirectReference pRIndirectReference) {
        return new DocumentFont(pRIndirectReference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getBaseName(String str) {
        if (str.endsWith(",Bold")) {
            return str.substring(0, str.length() - 5);
        }
        if (str.endsWith(",Italic")) {
            return str.substring(0, str.length() - 7);
        }
        return str.endsWith(",BoldItalic") ? str.substring(0, str.length() - 11) : str;
    }

    protected static String normalizeEncoding(String str) {
        return (str.equals("winansi") || str.equals("")) ? "Cp1252" : str.equals("macroman") ? MACROMAN : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createEncoding() {
        int parseInt;
        int i = 0;
        if (this.encoding.startsWith("#")) {
            this.specialMap = new IntHashtable();
            StringTokenizer stringTokenizer = new StringTokenizer(this.encoding.substring(1), " ,\t\n\r\f");
            if (stringTokenizer.nextToken().equals("full")) {
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    char parseInt2 = (char) Integer.parseInt(stringTokenizer.nextToken(), 16);
                    if (nextToken.startsWith("'")) {
                        parseInt = nextToken.charAt(1);
                    } else {
                        parseInt = Integer.parseInt(nextToken);
                    }
                    int i2 = parseInt % 256;
                    this.specialMap.put(parseInt2, i2);
                    this.differences[i2] = nextToken2;
                    this.unicodeDifferences[i2] = parseInt2;
                    this.widths[i2] = getRawWidth(parseInt2, nextToken2);
                    this.charBBoxes[i2] = getRawCharBBox(parseInt2, nextToken2);
                }
            } else {
                int parseInt3 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
                while (stringTokenizer.hasMoreTokens() && parseInt3 < 256) {
                    int parseInt4 = Integer.parseInt(stringTokenizer.nextToken(), 16) % 65536;
                    String unicodeToName = GlyphList.unicodeToName(parseInt4);
                    if (unicodeToName != null) {
                        this.specialMap.put(parseInt4, parseInt3);
                        this.differences[parseInt3] = unicodeToName;
                        this.unicodeDifferences[parseInt3] = (char) parseInt4;
                        this.widths[parseInt3] = getRawWidth(parseInt4, unicodeToName);
                        this.charBBoxes[parseInt3] = getRawCharBBox(parseInt4, unicodeToName);
                        parseInt3++;
                    }
                }
            }
            while (i < 256) {
                String[] strArr = this.differences;
                if (strArr[i] == null) {
                    strArr[i] = notdef;
                }
                i++;
            }
        } else if (this.fontSpecific) {
            while (i < 256) {
                this.widths[i] = getRawWidth(i, null);
                this.charBBoxes[i] = getRawCharBBox(i, null);
                i++;
            }
        } else {
            byte[] bArr = new byte[1];
            for (int i3 = 0; i3 < 256; i3++) {
                bArr[0] = (byte) i3;
                String convertToString = PdfEncodings.convertToString(bArr, this.encoding);
                char charAt = convertToString.length() > 0 ? convertToString.charAt(0) : '?';
                String unicodeToName2 = GlyphList.unicodeToName(charAt);
                if (unicodeToName2 == null) {
                    unicodeToName2 = notdef;
                }
                this.differences[i3] = unicodeToName2;
                this.unicodeDifferences[i3] = charAt;
                this.widths[i3] = getRawWidth(charAt, unicodeToName2);
                this.charBBoxes[i3] = getRawCharBBox(charAt, unicodeToName2);
            }
        }
    }

    public int getWidth(int i) {
        if (this.fastWinansi) {
            if (i < 128 || (i >= 160 && i <= 255)) {
                return this.widths[i];
            }
            return this.widths[PdfEncodings.winansi.get(i)];
        }
        int i2 = 0;
        for (byte b : convertToBytes((char) i)) {
            i2 += this.widths[b & 255];
        }
        return i2;
    }

    public int getWidth(String str) {
        int i;
        int i2 = 0;
        if (this.fastWinansi) {
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128 || (charAt >= 160 && charAt <= 255)) {
                    i = this.widths[charAt];
                } else {
                    i = this.widths[PdfEncodings.winansi.get(charAt)];
                }
                i3 += i;
                i2++;
            }
            return i3;
        }
        byte[] convertToBytes = convertToBytes(str);
        int i4 = 0;
        while (i2 < convertToBytes.length) {
            i4 += this.widths[convertToBytes[i2] & 255];
            i2++;
        }
        return i4;
    }

    public int getDescent(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            int[] charBBox = getCharBBox(c);
            if (charBBox != null && charBBox[1] < i) {
                i = charBBox[1];
            }
        }
        return i;
    }

    public int getAscent(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            int[] charBBox = getCharBBox(c);
            if (charBBox != null && charBBox[3] > i) {
                i = charBBox[3];
            }
        }
        return i;
    }

    public float getDescentPoint(String str, float f) {
        return getDescent(str) * 0.001f * f;
    }

    public float getAscentPoint(String str, float f) {
        return getAscent(str) * 0.001f * f;
    }

    public float getWidthPointKerned(String str, float f) {
        float width = getWidth(str) * 0.001f * f;
        if (hasKernPairs()) {
            int length = str.length() - 1;
            char[] charArray = str.toCharArray();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char c = charArray[i];
                i++;
                i2 += getKerning(c, charArray[i]);
            }
            return width + (i2 * 0.001f * f);
        }
        return width;
    }

    public float getWidthPoint(String str, float f) {
        return getWidth(str) * 0.001f * f;
    }

    public float getWidthPoint(int i, float f) {
        return getWidth(i) * 0.001f * f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes(str, (String) null);
        }
        if (this.specialMap != null) {
            byte[] bArr = new byte[str.length()];
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (this.specialMap.containsKey(charAt)) {
                    bArr[i] = (byte) this.specialMap.get(charAt);
                    i++;
                }
            }
            if (i < length) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                return bArr2;
            }
            return bArr;
        }
        return PdfEncodings.convertToBytes(str, this.encoding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] convertToBytes(int i) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes((char) i, (String) null);
        }
        IntHashtable intHashtable = this.specialMap;
        if (intHashtable != null) {
            return intHashtable.containsKey(i) ? new byte[]{(byte) this.specialMap.get(i)} : new byte[0];
        }
        return PdfEncodings.convertToBytes((char) i, this.encoding);
    }

    public String getEncoding() {
        return this.encoding;
    }

    public int getFontType() {
        return this.fontType;
    }

    public boolean isEmbedded() {
        return this.embedded;
    }

    public boolean isFontSpecific() {
        return this.fontSpecific;
    }

    public static String createSubsetPrefix() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 6; i++) {
            sb.append((char) ((Math.random() * 26.0d) + 65.0d));
        }
        return ((Object) sb) + "+";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getUnicodeDifferences(int i) {
        return this.unicodeDifferences[i];
    }

    public static String[][] getFullFontName(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont trueTypeFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            trueTypeFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            trueTypeFont = createFont(str, str2, false, false, bArr, null);
        }
        return trueTypeFont.getFullFontName();
    }

    public static Object[] getAllFontNames(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont trueTypeFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            trueTypeFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            trueTypeFont = createFont(str, str2, false, false, bArr, null);
        }
        return new Object[]{trueTypeFont.getPostscriptFontName(), trueTypeFont.getFamilyFontName(), trueTypeFont.getFullFontName()};
    }

    public static String[][] getAllNameEntries(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont trueTypeFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            trueTypeFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            trueTypeFont = createFont(str, str2, false, false, bArr, null);
        }
        return trueTypeFont.getAllNameEntries();
    }

    public String[] getCodePagesSupported() {
        return new String[0];
    }

    public static String[] enumerateTTCNames(String str) throws DocumentException, IOException {
        return new EnumerateTTC(str).getNames();
    }

    public static String[] enumerateTTCNames(byte[] bArr) throws DocumentException, IOException {
        return new EnumerateTTC(bArr).getNames();
    }

    public int[] getWidths() {
        return this.widths;
    }

    public String[] getDifferences() {
        return this.differences;
    }

    public char[] getUnicodeDifferences() {
        return this.unicodeDifferences;
    }

    public boolean isForceWidthsOutput() {
        return this.forceWidthsOutput;
    }

    public void setForceWidthsOutput(boolean z) {
        this.forceWidthsOutput = z;
    }

    public boolean isDirectTextToByte() {
        return this.directTextToByte;
    }

    public void setDirectTextToByte(boolean z) {
        this.directTextToByte = z;
    }

    public boolean isSubset() {
        return this.subset;
    }

    public void setSubset(boolean z) {
        this.subset = z;
    }

    public static InputStream getResourceStream(String str) {
        return getResourceStream(str, null);
    }

    public static InputStream getResourceStream(String str, ClassLoader classLoader) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        InputStream inputStream = null;
        if (classLoader == null || (inputStream = classLoader.getResourceAsStream(str)) == null) {
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    inputStream = contextClassLoader.getResourceAsStream(str);
                }
            } catch (Throwable unused) {
            }
            if (inputStream == null) {
                inputStream = BaseFont.class.getResourceAsStream("/".concat(String.valueOf(str)));
            }
            return inputStream == null ? ClassLoader.getSystemResourceAsStream(str) : inputStream;
        }
        return inputStream;
    }

    public boolean charExists(int i) {
        return convertToBytes(i).length > 0;
    }

    public boolean setCharAdvance(int i, int i2) {
        byte[] convertToBytes = convertToBytes(i);
        if (convertToBytes.length == 0) {
            return false;
        }
        this.widths[convertToBytes[0] & 255] = i2;
        return true;
    }

    private static void addFont(PRIndirectReference pRIndirectReference, IntHashtable intHashtable, ArrayList<Object[]> arrayList) {
        PdfObject pdfObject = PdfReader.getPdfObject(pRIndirectReference);
        if (pdfObject == null || !pdfObject.isDictionary()) {
            return;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfName asName = pdfDictionary.getAsName(PdfName.SUBTYPE);
        if (PdfName.TYPE1.equals(asName) || PdfName.TRUETYPE.equals(asName) || PdfName.TYPE0.equals(asName)) {
            arrayList.add(new Object[]{PdfName.decodeName(pdfDictionary.getAsName(PdfName.BASEFONT).toString()), pRIndirectReference});
            intHashtable.put(pRIndirectReference.getNumber(), 1);
        }
    }

    private static void recourseFonts(PdfDictionary pdfDictionary, IntHashtable intHashtable, ArrayList<Object[]> arrayList, int i) {
        PdfDictionary asDict;
        int i2 = i + 1;
        if (i2 > 50 || pdfDictionary == null || (asDict = pdfDictionary.getAsDict(PdfName.RESOURCES)) == null) {
            return;
        }
        PdfDictionary asDict2 = asDict.getAsDict(PdfName.FONT);
        if (asDict2 != null) {
            for (PdfName pdfName : asDict2.getKeys()) {
                PdfObject pdfObject = asDict2.get(pdfName);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                    if (!intHashtable.containsKey(pRIndirectReference.getNumber())) {
                        addFont(pRIndirectReference, intHashtable, arrayList);
                    }
                }
            }
        }
        PdfDictionary asDict3 = asDict.getAsDict(PdfName.XOBJECT);
        if (asDict3 != null) {
            for (PdfName pdfName2 : asDict3.getKeys()) {
                PdfObject directObject = asDict3.getDirectObject(pdfName2);
                if (directObject instanceof PdfDictionary) {
                    recourseFonts((PdfDictionary) directObject, intHashtable, arrayList, i2);
                }
            }
        }
    }

    public static ArrayList<Object[]> getDocumentFonts(PdfReader pdfReader) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1);
        }
        return arrayList;
    }

    public static ArrayList<Object[]> getDocumentFonts(PdfReader pdfReader, int i) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1);
        return arrayList;
    }

    public int[] getCharBBox(int i) {
        byte[] convertToBytes = convertToBytes(i);
        if (convertToBytes.length == 0) {
            return null;
        }
        return this.charBBoxes[convertToBytes[0] & 255];
    }

    public void correctArabicAdvance() {
        for (char c = 1611; c <= 1624; c = (char) (c + 1)) {
            setCharAdvance(c, 0);
        }
        setCharAdvance(1648, 0);
        for (char c2 = 1750; c2 <= 1756; c2 = (char) (c2 + 1)) {
            setCharAdvance(c2, 0);
        }
        for (char c3 = 1759; c3 <= 1764; c3 = (char) (c3 + 1)) {
            setCharAdvance(c3, 0);
        }
        for (char c4 = 1767; c4 <= 1768; c4 = (char) (c4 + 1)) {
            setCharAdvance(c4, 0);
        }
        for (char c5 = 1770; c5 <= 1773; c5 = (char) (c5 + 1)) {
            setCharAdvance(c5, 0);
        }
    }

    public void addSubsetRange(int[] iArr) {
        if (this.subsetRanges == null) {
            this.subsetRanges = new ArrayList<>();
        }
        this.subsetRanges.add(iArr);
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }
}
