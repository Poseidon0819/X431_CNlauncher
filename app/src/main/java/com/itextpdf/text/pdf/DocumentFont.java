package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class DocumentFont extends BaseFont {
    private static final int[] stdEnc = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 8217, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 8216, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, Opcodes.INEG, 117, Opcodes.FNEG, 119, Opcodes.ISHL, 121, Opcodes.ISHR, 123, Opcodes.IUSHR, 125, Opcodes.IAND, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 161, 162, Opcodes.IF_ICMPGT, 8260, Opcodes.IF_ACMPEQ, 402, 167, Opcodes.IF_ICMPLE, 39, 8220, Opcodes.LOOKUPSWITCH, 8249, 8250, 64257, 64258, 0, 8211, 8224, 8225, Opcodes.INVOKESPECIAL, 0, Opcodes.INVOKEVIRTUAL, 8226, 8218, 8222, 8221, Opcodes.NEW, 8230, 8240, 0, Opcodes.ATHROW, 0, 96, Opcodes.GETFIELD, 710, 732, Opcodes.DRETURN, 728, 729, Opcodes.JSR, 0, 730, Opcodes.INVOKESTATIC, 0, 733, 731, 711, 8212, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Opcodes.IFNULL, 0, Opcodes.TABLESWITCH, 0, 0, 0, 0, TIFFConstants.TIFFTAG_HALFTONEHINTS, 216, TIFFConstants.TIFFTAG_EXTRASAMPLES, Opcodes.INVOKEDYNAMIC, 0, 0, 0, 0, 0, 230, 0, 0, 0, TIFFConstants.TIFFTAG_SOFTWARE, 0, 0, 322, 248, TIFFConstants.TIFFTAG_SAMPLEFORMAT, 223, 0, 0, 0, 0};
    private float ascender;
    private float capHeight;
    protected String cjkEncoding;
    private BaseFont cjkMirror;
    private float descender;
    private IntHashtable diffmap;
    private PdfDictionary font;
    private String fontName;
    private float fontWeight;
    private boolean isType0;
    private float italicAngle;
    private float llx;
    private float lly;
    private HashMap<Integer, int[]> metrics;
    private PRIndirectReference refFont;
    private IntHashtable uni2byte;
    protected String uniMap;
    private float urx;
    private float ury;

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    protected int[] getRawCharBBox(int i, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentFont(PdfDictionary pdfDictionary) {
        this.metrics = new HashMap<>();
        this.uni2byte = new IntHashtable();
        this.ascender = 800.0f;
        this.capHeight = 700.0f;
        this.descender = -200.0f;
        this.italicAngle = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.fontWeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.llx = -50.0f;
        this.lly = -200.0f;
        this.urx = 100.0f;
        this.ury = 900.0f;
        this.isType0 = false;
        this.refFont = null;
        this.font = pdfDictionary;
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentFont(PRIndirectReference pRIndirectReference) {
        this.metrics = new HashMap<>();
        this.uni2byte = new IntHashtable();
        this.ascender = 800.0f;
        this.capHeight = 700.0f;
        this.descender = -200.0f;
        this.italicAngle = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.fontWeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.llx = -50.0f;
        this.lly = -200.0f;
        this.urx = 100.0f;
        this.ury = 900.0f;
        this.isType0 = false;
        this.refFont = pRIndirectReference;
        this.font = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
        init();
    }

    private void init() {
        this.encoding = "";
        this.fontSpecific = false;
        this.fontType = 4;
        PdfName asName = this.font.getAsName(PdfName.BASEFONT);
        this.fontName = asName != null ? PdfName.decodeName(asName.toString()) : "Unspecified Font Name";
        PdfName asName2 = this.font.getAsName(PdfName.SUBTYPE);
        if (PdfName.TYPE1.equals(asName2) || PdfName.TRUETYPE.equals(asName2)) {
            doType1TT();
            return;
        }
        PdfName asName3 = this.font.getAsName(PdfName.ENCODING);
        if (asName3 != null) {
            String decodeName = PdfName.decodeName(asName3.toString());
            String GetCompatibleFont = CJKFont.GetCompatibleFont(decodeName);
            if (GetCompatibleFont != null) {
                try {
                    this.cjkMirror = BaseFont.createFont(GetCompatibleFont, decodeName, false);
                    this.cjkEncoding = decodeName;
                    this.uniMap = ((CJKFont) this.cjkMirror).getUniMap();
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } else if (PdfName.TYPE0.equals(asName2) && decodeName.equals(BaseFont.IDENTITY_H)) {
                processType0(this.font);
                this.isType0 = true;
            }
        }
    }

    private void processType0(PdfDictionary pdfDictionary) {
        try {
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TOUNICODE));
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DESCENDANTFONTS))).getPdfObject(0));
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19709DW));
            int intValue = pdfNumber != null ? pdfNumber.intValue() : 1000;
            IntHashtable readWidths = readWidths((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f19791W)));
            fillFontDesc((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.FONTDESCRIPTOR)));
            if (pdfObjectRelease instanceof PRStream) {
                fillMetrics(PdfReader.getStreamBytes((PRStream) pdfObjectRelease), readWidths, intValue);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private IntHashtable readWidths(PdfArray pdfArray) {
        IntHashtable intHashtable = new IntHashtable();
        if (pdfArray == null) {
            return intHashtable;
        }
        int i = 0;
        while (i < pdfArray.size()) {
            int intValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i))).intValue();
            int i2 = i + 1;
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2));
            if (pdfObjectRelease.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObjectRelease;
                int i3 = intValue;
                int i4 = 0;
                while (i4 < pdfArray2.size()) {
                    intHashtable.put(i3, ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray2.getPdfObject(i4))).intValue());
                    i4++;
                    i3++;
                }
            } else {
                int intValue2 = ((PdfNumber) pdfObjectRelease).intValue();
                i2++;
                int intValue3 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2))).intValue();
                while (intValue <= intValue2) {
                    intHashtable.put(intValue, intValue3);
                    intValue++;
                }
            }
            i = i2 + 1;
        }
        return intHashtable;
    }

    private String decodeString(PdfString pdfString) {
        if (pdfString.isHexWriting()) {
            return PdfEncodings.convertToString(pdfString.getBytes(), "UnicodeBigUnmarked");
        }
        return pdfString.toUnicodeString();
    }

    private void fillMetrics(byte[] bArr, IntHashtable intHashtable, int i) {
        PdfObject readPRObject;
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(bArr));
            boolean z = true;
            int i2 = 0;
            int i3 = 50;
            while (true) {
                if (!z && i2 <= 0) {
                    return;
                }
                try {
                    readPRObject = pdfContentParser.readPRObject();
                } catch (Exception unused) {
                    i3--;
                    if (i3 < 0) {
                        return;
                    }
                }
                if (readPRObject == null) {
                    return;
                }
                if (readPRObject.type() == 200) {
                    if (readPRObject.toString().equals("begin")) {
                        i2++;
                        z = false;
                    } else if (readPRObject.toString().equals("end")) {
                        i2--;
                    } else if (readPRObject.toString().equals("beginbfchar")) {
                        while (true) {
                            PdfObject readPRObject2 = pdfContentParser.readPRObject();
                            if (!readPRObject2.toString().equals("endbfchar")) {
                                String decodeString = decodeString((PdfString) readPRObject2);
                                String decodeString2 = decodeString((PdfString) pdfContentParser.readPRObject());
                                if (decodeString2.length() == 1) {
                                    char charAt = decodeString.charAt(0);
                                    this.metrics.put(Integer.valueOf(decodeString2.charAt(decodeString2.length() - 1)), new int[]{charAt, intHashtable.containsKey(charAt) ? intHashtable.get(charAt) : i});
                                }
                            }
                        }
                    } else if (readPRObject.toString().equals("beginbfrange")) {
                        while (true) {
                            PdfObject readPRObject3 = pdfContentParser.readPRObject();
                            if (!readPRObject3.toString().equals("endbfrange")) {
                                String decodeString3 = decodeString((PdfString) readPRObject3);
                                String decodeString4 = decodeString((PdfString) pdfContentParser.readPRObject());
                                int charAt2 = decodeString3.charAt(0);
                                char charAt3 = decodeString4.charAt(0);
                                PdfObject readPRObject4 = pdfContentParser.readPRObject();
                                if (readPRObject4.isString()) {
                                    String decodeString5 = decodeString((PdfString) readPRObject4);
                                    if (decodeString5.length() == 1) {
                                        int charAt4 = decodeString5.charAt(decodeString5.length() - 1);
                                        while (charAt2 <= charAt3) {
                                            this.metrics.put(Integer.valueOf(charAt4), new int[]{charAt2, intHashtable.containsKey(charAt2) ? intHashtable.get(charAt2) : i});
                                            charAt2++;
                                            charAt4++;
                                        }
                                    }
                                } else {
                                    PdfArray pdfArray = (PdfArray) readPRObject4;
                                    int i4 = charAt2;
                                    int i5 = 0;
                                    while (i5 < pdfArray.size()) {
                                        String decodeString6 = decodeString(pdfArray.getAsString(i5));
                                        if (decodeString6.length() == 1) {
                                            this.metrics.put(Integer.valueOf(decodeString6.charAt(decodeString6.length() - 1)), new int[]{i4, intHashtable.containsKey(i4) ? intHashtable.get(i4) : i});
                                        }
                                        i5++;
                                        i4++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void doType1TT() {
        PdfObject pdfObject = PdfReader.getPdfObject(this.font.get(PdfName.ENCODING));
        if (pdfObject == null) {
            fillEncoding(null);
            try {
                CMapToUnicode processToUnicode = processToUnicode();
                if (processToUnicode != null) {
                    for (Map.Entry<Integer, Integer> entry : processToUnicode.createReverseMapping().entrySet()) {
                        this.uni2byte.put(entry.getKey().intValue(), entry.getValue().intValue());
                    }
                }
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else if (pdfObject.isName()) {
            fillEncoding((PdfName) pdfObject);
        } else if (pdfObject.isDictionary()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfObject pdfObject2 = PdfReader.getPdfObject(pdfDictionary.get(PdfName.BASEENCODING));
            if (pdfObject2 == null) {
                fillEncoding(null);
            } else {
                fillEncoding((PdfName) pdfObject2);
            }
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.DIFFERENCES);
            if (asArray != null) {
                this.diffmap = new IntHashtable();
                CMapToUnicode cMapToUnicode = null;
                int i = 0;
                for (int i2 = 0; i2 < asArray.size(); i2++) {
                    PdfObject pdfObject3 = asArray.getPdfObject(i2);
                    if (pdfObject3.isNumber()) {
                        i = ((PdfNumber) pdfObject3).intValue();
                    } else {
                        int[] nameToUnicode = GlyphList.nameToUnicode(PdfName.decodeName(((PdfName) pdfObject3).toString()));
                        if (nameToUnicode != null && nameToUnicode.length > 0) {
                            this.uni2byte.put(nameToUnicode[0], i);
                            this.diffmap.put(nameToUnicode[0], i);
                        } else {
                            if (cMapToUnicode == null && (cMapToUnicode = processToUnicode()) == null) {
                                cMapToUnicode = new CMapToUnicode();
                            }
                            String lookup = cMapToUnicode.lookup(new byte[]{(byte) i}, 0, 1);
                            if (lookup != null && lookup.length() == 1) {
                                this.uni2byte.put(lookup.charAt(0), i);
                                this.diffmap.put(lookup.charAt(0), i);
                            }
                        }
                        i++;
                    }
                }
            }
        }
        PdfArray asArray2 = this.font.getAsArray(PdfName.WIDTHS);
        PdfNumber asNumber = this.font.getAsNumber(PdfName.FIRSTCHAR);
        PdfNumber asNumber2 = this.font.getAsNumber(PdfName.LASTCHAR);
        if (BuiltinFonts14.containsKey(this.fontName)) {
            try {
                BaseFont createFont = BaseFont.createFont(this.fontName, "Cp1252", false);
                int[] orderedKeys = this.uni2byte.toOrderedKeys();
                for (int i3 = 0; i3 < orderedKeys.length; i3++) {
                    int i4 = this.uni2byte.get(orderedKeys[i3]);
                    this.widths[i4] = createFont.getRawWidth(i4, GlyphList.unicodeToName(orderedKeys[i3]));
                }
                IntHashtable intHashtable = this.diffmap;
                if (intHashtable != null) {
                    int[] orderedKeys2 = intHashtable.toOrderedKeys();
                    for (int i5 = 0; i5 < orderedKeys2.length; i5++) {
                        int i6 = this.diffmap.get(orderedKeys2[i5]);
                        this.widths[i6] = createFont.getRawWidth(i6, GlyphList.unicodeToName(orderedKeys2[i5]));
                    }
                    this.diffmap = null;
                }
                this.ascender = createFont.getFontDescriptor(1, 1000.0f);
                this.capHeight = createFont.getFontDescriptor(2, 1000.0f);
                this.descender = createFont.getFontDescriptor(3, 1000.0f);
                this.italicAngle = createFont.getFontDescriptor(4, 1000.0f);
                this.fontWeight = createFont.getFontDescriptor(23, 1000.0f);
                this.llx = createFont.getFontDescriptor(5, 1000.0f);
                this.lly = createFont.getFontDescriptor(6, 1000.0f);
                this.urx = createFont.getFontDescriptor(7, 1000.0f);
                this.ury = createFont.getFontDescriptor(8, 1000.0f);
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        if (asNumber != null && asNumber2 != null && asArray2 != null) {
            int intValue = asNumber.intValue();
            int size = asArray2.size() + intValue;
            if (this.widths.length < size) {
                int[] iArr = new int[size];
                System.arraycopy(this.widths, 0, iArr, 0, intValue);
                this.widths = iArr;
            }
            for (int i7 = 0; i7 < asArray2.size(); i7++) {
                this.widths[intValue + i7] = asArray2.getAsNumber(i7).intValue();
            }
        }
        fillFontDesc(this.font.getAsDict(PdfName.FONTDESCRIPTOR));
    }

    private CMapToUnicode processToUnicode() {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(this.font.get(PdfName.TOUNICODE));
        if (pdfObjectRelease instanceof PRStream) {
            try {
                CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.getStreamBytes((PRStream) pdfObjectRelease));
                CMapToUnicode cMapToUnicode = new CMapToUnicode();
                CMapParserEx.parseCid("", cMapToUnicode, cidLocationFromByte);
                return cMapToUnicode;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private void fillFontDesc(PdfDictionary pdfDictionary) {
        if (pdfDictionary == null) {
            return;
        }
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ASCENT);
        if (asNumber != null) {
            this.ascender = asNumber.floatValue();
        }
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.CAPHEIGHT);
        if (asNumber2 != null) {
            this.capHeight = asNumber2.floatValue();
        }
        PdfNumber asNumber3 = pdfDictionary.getAsNumber(PdfName.DESCENT);
        if (asNumber3 != null) {
            this.descender = asNumber3.floatValue();
        }
        PdfNumber asNumber4 = pdfDictionary.getAsNumber(PdfName.ITALICANGLE);
        if (asNumber4 != null) {
            this.italicAngle = asNumber4.floatValue();
        }
        PdfNumber asNumber5 = pdfDictionary.getAsNumber(PdfName.FONTWEIGHT);
        if (asNumber5 != null) {
            this.fontWeight = asNumber5.floatValue();
        }
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.FONTBBOX);
        if (asArray != null) {
            this.llx = asArray.getAsNumber(0).floatValue();
            this.lly = asArray.getAsNumber(1).floatValue();
            this.urx = asArray.getAsNumber(2).floatValue();
            this.ury = asArray.getAsNumber(3).floatValue();
            float f = this.llx;
            float f2 = this.urx;
            if (f > f2) {
                this.llx = f2;
                this.urx = f;
            }
            float f3 = this.lly;
            float f4 = this.ury;
            if (f3 > f4) {
                this.lly = f4;
                this.ury = f3;
            }
        }
        float max = Math.max(this.ury, this.ascender);
        float min = Math.min(this.lly, this.descender);
        float f5 = max * 1000.0f;
        float f6 = max - min;
        this.ascender = f5 / f6;
        this.descender = (min * 1000.0f) / f6;
    }

    private void fillEncoding(PdfName pdfName) {
        int i = 0;
        if (!PdfName.MAC_ROMAN_ENCODING.equals(pdfName) && !PdfName.WIN_ANSI_ENCODING.equals(pdfName)) {
            while (i < 256) {
                this.uni2byte.put(stdEnc[i], i);
                i++;
            }
            return;
        }
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) i2;
        }
        char[] charArray = PdfEncodings.convertToString(bArr, PdfName.MAC_ROMAN_ENCODING.equals(pdfName) ? BaseFont.MACROMAN : "Cp1252").toCharArray();
        while (i < 256) {
            this.uni2byte.put(charArray[i], i);
            i++;
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getFontDescriptor(i, f);
        }
        if (i != 23) {
            switch (i) {
                case 1:
                case 9:
                    return (this.ascender * f) / 1000.0f;
                case 2:
                    return (this.capHeight * f) / 1000.0f;
                case 3:
                case 10:
                    return (this.descender * f) / 1000.0f;
                case 4:
                    return this.italicAngle;
                case 5:
                    return (this.llx * f) / 1000.0f;
                case 6:
                    return (this.lly * f) / 1000.0f;
                case 7:
                    return (this.urx * f) / 1000.0f;
                case 8:
                    return (this.ury * f) / 1000.0f;
                case 11:
                    return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                case 12:
                    return ((this.urx - this.llx) * f) / 1000.0f;
                default:
                    return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
        }
        return (this.fontWeight * f) / 1000.0f;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.fontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getWidth(i);
        }
        if (this.isType0) {
            int[] iArr = this.metrics.get(Integer.valueOf(i));
            if (iArr != null) {
                return iArr[1];
            }
            return 0;
        }
        return super.getWidth(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getWidth(str);
        }
        if (this.isType0) {
            int i = 0;
            for (char c : str.toCharArray()) {
                int[] iArr = this.metrics.get(Integer.valueOf(c));
                if (iArr != null) {
                    i += iArr[1];
                }
            }
            return i;
        }
        return super.getWidth(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.convertToBytes(str);
        }
        if (this.isType0) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length * 2];
            int i = 0;
            for (char c : charArray) {
                int[] iArr = this.metrics.get(Integer.valueOf(c));
                if (iArr != null) {
                    int i2 = iArr[0];
                    int i3 = i + 1;
                    bArr[i] = (byte) (i2 / 256);
                    i = i3 + 1;
                    bArr[i3] = (byte) i2;
                }
            }
            if (i == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        char[] charArray2 = str.toCharArray();
        byte[] bArr3 = new byte[charArray2.length];
        int i4 = 0;
        for (int i5 = 0; i5 < charArray2.length; i5++) {
            if (this.uni2byte.containsKey(charArray2[i5])) {
                bArr3[i4] = (byte) this.uni2byte.get(charArray2[i5]);
                i4++;
            }
        }
        if (i4 == bArr3.length) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.convertToBytes(i);
        }
        if (!this.isType0) {
            return this.uni2byte.containsKey(i) ? new byte[]{(byte) this.uni2byte.get(i)} : new byte[0];
        }
        int[] iArr = this.metrics.get(Integer.valueOf(i));
        if (iArr != null) {
            int i2 = iArr[0];
            return new byte[]{(byte) (i2 / 256), (byte) i2};
        }
        return new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference getIndirectReference() {
        PRIndirectReference pRIndirectReference = this.refFont;
        if (pRIndirectReference != null) {
            return pRIndirectReference;
        }
        throw new IllegalArgumentException("Font reuse not allowed with direct font objects.");
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.charExists(i);
        }
        if (this.isType0) {
            return this.metrics.containsKey(Integer.valueOf(i));
        }
        return super.charExists(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntHashtable getUni2Byte() {
        return this.uni2byte;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntHashtable getDiffmap() {
        return this.diffmap;
    }
}
