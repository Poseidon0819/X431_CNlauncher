package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Type1Font extends BaseFont {
    private static final int[] PFB_TYPES = {1, 2, 1};
    private static FontsResourceAnchor resourceAnchor;
    private String CharacterSet;
    private String EncodingScheme;
    private String FamilyName;
    private String FontName;
    private String FullName;
    private int StdHW;
    private boolean builtinFont;
    private String fileName;
    protected byte[] pfb;
    private String Weight = "";
    private float ItalicAngle = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private boolean IsFixedPitch = false;
    private int llx = -50;
    private int lly = -200;
    private int urx = 1000;
    private int ury = 900;
    private int UnderlinePosition = -100;
    private int UnderlineThickness = 50;
    private int CapHeight = 700;
    private int XHeight = 480;
    private int Ascender = 800;
    private int Descender = -200;
    private int StdVW = 80;
    private HashMap<Object, Object[]> CharMetrics = new HashMap<>();
    private HashMap<String, Object[]> KernPairs = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type1Font(String str, String str2, boolean z, byte[] bArr, byte[] bArr2, boolean z2) throws DocumentException, IOException {
        RandomAccessFileOrArray randomAccessFileOrArray;
        InputStream resourceStream;
        RandomAccessFileOrArray randomAccessFileOrArray2;
        this.EncodingScheme = "FontSpecific";
        this.builtinFont = false;
        if (z && bArr != null && bArr2 == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("two.byte.arrays.are.needed.if.the.type1.font.is.embedded", new Object[0]));
        }
        if (z && bArr != null) {
            this.pfb = bArr2;
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = str;
        this.fontType = 0;
        RandomAccessFileOrArray randomAccessFileOrArray3 = null;
        RandomAccessFileOrArray randomAccessFileOrArray4 = null;
        InputStream inputStream = null;
        RandomAccessFileOrArray randomAccessFileOrArray5 = null;
        if (BuiltinFonts14.containsKey(str)) {
            this.embedded = false;
            this.builtinFont = true;
            byte[] bArr3 = new byte[1024];
            try {
                if (resourceAnchor == null) {
                    resourceAnchor = new FontsResourceAnchor();
                }
                resourceStream = getResourceStream(BaseFont.RESOURCE_PATH + str + ".afm", resourceAnchor.getClass().getClassLoader());
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (resourceStream == null) {
                    String composedMessage = MessageLocalization.getComposedMessage("1.not.found.as.resource", str);
                    System.err.println(composedMessage);
                    throw new DocumentException(composedMessage);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = resourceStream.read(bArr3);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (resourceStream != null) {
                    try {
                        resourceStream.close();
                    } catch (Exception unused) {
                    }
                }
                try {
                    randomAccessFileOrArray2 = new RandomAccessFileOrArray(byteArray);
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    process(randomAccessFileOrArray2);
                    try {
                        randomAccessFileOrArray2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFileOrArray4 = randomAccessFileOrArray2;
                    if (randomAccessFileOrArray4 != null) {
                        try {
                            randomAccessFileOrArray4.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = resourceStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } else if (str.toLowerCase().endsWith(".afm")) {
            try {
                if (bArr == null) {
                    randomAccessFileOrArray3 = new RandomAccessFileOrArray(str, z2, Document.plainRandomAccess);
                } else {
                    randomAccessFileOrArray3 = new RandomAccessFileOrArray(bArr);
                }
                process(randomAccessFileOrArray3);
                try {
                    randomAccessFileOrArray3.close();
                } catch (Exception unused5) {
                }
            } catch (Throwable th5) {
                if (randomAccessFileOrArray3 != null) {
                    try {
                        randomAccessFileOrArray3.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th5;
            }
        } else if (str.toLowerCase().endsWith(".pfm")) {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (bArr == null) {
                    randomAccessFileOrArray5 = new RandomAccessFileOrArray(str, z2, Document.plainRandomAccess);
                } else {
                    randomAccessFileOrArray5 = new RandomAccessFileOrArray(bArr);
                }
                Pfm2afm.convert(randomAccessFileOrArray5, byteArrayOutputStream2);
                randomAccessFileOrArray5.close();
                randomAccessFileOrArray = new RandomAccessFileOrArray(byteArrayOutputStream2.toByteArray());
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                process(randomAccessFileOrArray);
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused7) {
                }
            } catch (Throwable th7) {
                randomAccessFileOrArray5 = randomAccessFileOrArray;
                th = th7;
                if (randomAccessFileOrArray5 != null) {
                    try {
                        randomAccessFileOrArray5.close();
                    } catch (Exception unused8) {
                    }
                }
                throw th;
            }
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("1.is.not.an.afm.or.pfm.font.file", str));
        }
        this.EncodingScheme = this.EncodingScheme.trim();
        if (this.EncodingScheme.equals("AdobeStandardEncoding") || this.EncodingScheme.equals("StandardEncoding")) {
            this.fontSpecific = false;
        }
        if (!this.encoding.startsWith("#")) {
            PdfEncodings.convertToBytes(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, str2);
        }
        createEncoding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else if (str.equals(BaseFont.notdef)) {
            return 0;
        } else {
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        String unicodeToName;
        Object[] objArr;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null || (objArr = this.KernPairs.get(unicodeToName2)) == null) {
            return 0;
        }
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            if (unicodeToName.equals(objArr[i3])) {
                return ((Integer) objArr[i3 + 1]).intValue();
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02c8, code lost:
        if (r0 == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02ca, code lost:
        r3 = r15.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02ce, code lost:
        if (r3 == null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02d0, code lost:
        r5 = new java.util.StringTokenizer(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02d9, code lost:
        if (r5.hasMoreTokens() == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02db, code lost:
        r3 = r5.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02e5, code lost:
        if (r3.equals("KPX") == false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02e7, code lost:
        r3 = r5.nextToken();
        r6 = r5.nextToken();
        r5 = java.lang.Integer.valueOf((int) java.lang.Float.parseFloat(r5.nextToken()));
        r7 = r14.KernPairs.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0304, code lost:
        if (r7 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0306, code lost:
        r14.KernPairs.put(r3, new java.lang.Object[]{r6, r5});
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0312, code lost:
        r8 = r7.length;
        r9 = new java.lang.Object[r8 + 2];
        java.lang.System.arraycopy(r7, 0, r9, 0, r8);
        r9[r8] = r6;
        r9[r8 + 1] = r5;
        r14.KernPairs.put(r3, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x032b, code lost:
        if (r3.equals("EndKernPairs") == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x032d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x032e, code lost:
        if (r0 != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0330, code lost:
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0333, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0345, code lost:
        throw new com.itextpdf.text.DocumentException(com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage("missing.endkernpairs.in.1", r14.fileName));
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0357, code lost:
        throw new com.itextpdf.text.DocumentException(com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage("missing.endfontmetrics.in.1", r14.fileName));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void process(com.itextpdf.text.pdf.RandomAccessFileOrArray r15) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 893
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Type1Font.process(com.itextpdf.text.pdf.RandomAccessFileOrArray):void");
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() throws DocumentException {
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessFileOrArray randomAccessFileOrArray2 = null;
        if (!this.builtinFont) {
            try {
                if (this.embedded) {
                    try {
                        String str = this.fileName.substring(0, this.fileName.length() - 3) + "pfb";
                        if (this.pfb == null) {
                            randomAccessFileOrArray = new RandomAccessFileOrArray(str, true, Document.plainRandomAccess);
                        } else {
                            randomAccessFileOrArray = new RandomAccessFileOrArray(this.pfb);
                        }
                        byte[] bArr = new byte[((int) randomAccessFileOrArray.length()) - 18];
                        int[] iArr = new int[3];
                        int i = 0;
                        for (int i2 = 0; i2 < 3; i2++) {
                            if (randomAccessFileOrArray.read() != 128) {
                                throw new DocumentException(MessageLocalization.getComposedMessage("start.marker.missing.in.1", str));
                            }
                            if (randomAccessFileOrArray.read() != PFB_TYPES[i2]) {
                                throw new DocumentException(MessageLocalization.getComposedMessage("incorrect.segment.type.in.1", str));
                            }
                            int read = randomAccessFileOrArray.read() + (randomAccessFileOrArray.read() << 8) + (randomAccessFileOrArray.read() << 16) + (randomAccessFileOrArray.read() << 24);
                            iArr[i2] = read;
                            while (read != 0) {
                                int read2 = randomAccessFileOrArray.read(bArr, i, read);
                                if (read2 < 0) {
                                    throw new DocumentException(MessageLocalization.getComposedMessage("premature.end.in.1", str));
                                }
                                i += read2;
                                read -= read2;
                            }
                        }
                        BaseFont.StreamFont streamFont = new BaseFont.StreamFont(bArr, iArr, this.compressionLevel);
                        try {
                            randomAccessFileOrArray.close();
                        } catch (Exception unused) {
                        }
                        return streamFont;
                    } catch (Exception e) {
                        throw new DocumentException(e);
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        randomAccessFileOrArray2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    private PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference) {
        if (this.builtinFont) {
            return null;
        }
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber(this.Ascender));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber(this.CapHeight));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber(this.Descender));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle(this.llx, this.lly, this.urx, this.ury));
        pdfDictionary.put(PdfName.FONTNAME, new PdfName(this.FontName));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.ItalicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(this.StdVW));
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTFILE, pdfIndirectReference);
        }
        int i = (this.IsFixedPitch ? 1 : 0) | (this.fontSpecific ? 4 : 32);
        if (this.ItalicAngle < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            i |= 64;
        }
        if (this.FontName.indexOf("Caps") >= 0 || this.FontName.endsWith("SC")) {
            i |= 131072;
        }
        if (this.Weight.equals("Bold")) {
            i |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.FontName));
        boolean z = this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN);
        if (!this.fontSpecific || this.specialMap != null) {
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
            if (z) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z2 = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z2) {
                            pdfArray.add(new PdfNumber(i4));
                            z2 = false;
                        }
                        pdfArray.add(new PdfName(this.differences[i4]));
                    } else {
                        z2 = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        if (this.specialMap != null || this.forceWidthsOutput || !this.builtinFont || (!this.fontSpecific && !z)) {
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
        }
        if (!this.builtinFont && pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i = 0;
        int intValue = ((Integer) objArr[0]).intValue();
        int intValue2 = ((Integer) objArr[1]).intValue();
        byte[] bArr = (byte[]) objArr[2];
        if (((Boolean) objArr[3]).booleanValue() && this.subset) {
            i = intValue;
        } else {
            intValue2 = bArr.length - 1;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = 1;
            }
        }
        PdfStream fullFontStream = getFullFontStream();
        PdfIndirectReference indirectReference = fullFontStream != null ? pdfWriter.addToBody(fullFontStream).getIndirectReference() : null;
        PdfDictionary fontDescriptor = getFontDescriptor(indirectReference);
        if (fontDescriptor != null) {
            indirectReference = pdfWriter.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(indirectReference, i, intValue2, bArr), pdfIndirectReference);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        switch (i) {
            case 1:
            case 9:
                return (this.Ascender * f) / 1000.0f;
            case 2:
                return (this.CapHeight * f) / 1000.0f;
            case 3:
            case 10:
                return (this.Descender * f) / 1000.0f;
            case 4:
                return this.ItalicAngle;
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
            case 13:
                return (this.UnderlinePosition * f) / 1000.0f;
            case 14:
                return (this.UnderlineThickness * f) / 1000.0f;
            default:
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setFontDescriptor(int i, float f) {
        if (i != 1) {
            if (i != 3) {
                switch (i) {
                    case 9:
                        break;
                    case 10:
                        break;
                    default:
                        return;
                }
            }
            this.Descender = (int) f;
            return;
        }
        this.Ascender = (int) f;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.FontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return new String[][]{new String[]{"", "", "", this.FamilyName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return !this.KernPairs.isEmpty();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.FontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        String unicodeToName;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null) {
            return false;
        }
        Object[] objArr = this.KernPairs.get(unicodeToName2);
        if (objArr == null) {
            this.KernPairs.put(unicodeToName2, new Object[]{unicodeToName, Integer.valueOf(i3)});
            return true;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (unicodeToName.equals(objArr[i4])) {
                objArr[i4 + 1] = Integer.valueOf(i3);
                return true;
            }
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[length + 2];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = unicodeToName;
        objArr2[length + 1] = Integer.valueOf(i3);
        this.KernPairs.put(unicodeToName2, objArr2);
        return true;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    protected int[] getRawCharBBox(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else if (str.equals(BaseFont.notdef)) {
            return null;
        } else {
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }
}
