package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Type3Font extends BaseFont {
    private HashMap<Integer, Type3Glyph> char2glyph;
    private boolean colorized;
    private float llx;
    private float lly;
    private PageResources pageResources;
    private float urx;
    private float ury;
    private boolean[] usedSlot;
    private IntHashtable widths3;
    private PdfWriter writer;

    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getCharBBox(int i) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
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
    public String getPostscriptFontName() {
        return "";
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
    public boolean setCharAdvance(int i, int i2) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
    }

    public Type3Font(PdfWriter pdfWriter, char[] cArr, boolean z) {
        this(pdfWriter, z);
    }

    public Type3Font(PdfWriter pdfWriter, boolean z) {
        this.widths3 = new IntHashtable();
        this.char2glyph = new HashMap<>();
        this.llx = Float.NaN;
        this.pageResources = new PageResources();
        this.writer = pdfWriter;
        this.colorized = z;
        this.fontType = 5;
        this.usedSlot = new boolean[256];
    }

    public PdfContentByte defineGlyph(char c, float f, float f2, float f3, float f4, float f5) {
        if (c == 0 || c > 255) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.char.1.doesn.t.belong.in.this.type3.font", c));
        }
        this.usedSlot[c] = true;
        Integer valueOf = Integer.valueOf(c);
        Type3Glyph type3Glyph = this.char2glyph.get(valueOf);
        if (type3Glyph != null) {
            return type3Glyph;
        }
        this.widths3.put(c, (int) f);
        if (!this.colorized) {
            if (Float.isNaN(this.llx)) {
                this.llx = f2;
                this.lly = f3;
                this.urx = f4;
                this.ury = f5;
            } else {
                this.llx = Math.min(this.llx, f2);
                this.lly = Math.min(this.lly, f3);
                this.urx = Math.max(this.urx, f4);
                this.ury = Math.max(this.ury, f5);
            }
        }
        Type3Glyph type3Glyph2 = new Type3Glyph(this.writer, this.pageResources, f, f2, f3, f4, f5, this.colorized);
        this.char2glyph.put(valueOf, type3Glyph2);
        return type3Glyph2;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", ""}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", ""}};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        if (this.writer != pdfWriter) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("type3.font.used.with.the.wrong.pdfwriter", new Object[0]));
        }
        int i = 0;
        while (true) {
            boolean[] zArr = this.usedSlot;
            if (i >= zArr.length || zArr[i]) {
                break;
            }
            i++;
        }
        boolean[] zArr2 = this.usedSlot;
        if (i == zArr2.length) {
            throw new DocumentException(MessageLocalization.getComposedMessage("no.glyphs.defined.for.type3.font", new Object[0]));
        }
        int length = zArr2.length - 1;
        while (length >= i && !this.usedSlot[length]) {
            length--;
        }
        int i2 = (length - i) + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        while (i3 <= length) {
            if (this.usedSlot[i3]) {
                iArr2[i4] = i3;
                iArr[i5] = this.widths3.get(i3);
                i4++;
            }
            i3++;
            i5++;
        }
        PdfArray pdfArray = new PdfArray();
        PdfDictionary pdfDictionary = new PdfDictionary();
        int i6 = -1;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = iArr2[i7];
            if (i8 > i6) {
                pdfArray.add(new PdfNumber(i8));
                i6 = i8;
            }
            i6++;
            int i9 = iArr2[i7];
            String unicodeToName = GlyphList.unicodeToName(i9);
            if (unicodeToName == null) {
                unicodeToName = HtmlTags.f19618A.concat(String.valueOf(i9));
            }
            PdfName pdfName = new PdfName(unicodeToName);
            pdfArray.add(pdfName);
            PdfStream pdfStream = new PdfStream(this.char2glyph.get(Integer.valueOf(i9)).toPdf(null));
            pdfStream.flateCompress(this.compressionLevel);
            pdfDictionary.put(pdfName, pdfWriter.addToBody(pdfStream).getIndirectReference());
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.FONT);
        pdfDictionary2.put(PdfName.SUBTYPE, PdfName.TYPE3);
        if (this.colorized) {
            pdfDictionary2.put(PdfName.FONTBBOX, new PdfRectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO));
        } else {
            pdfDictionary2.put(PdfName.FONTBBOX, new PdfRectangle(this.llx, this.lly, this.urx, this.ury));
        }
        pdfDictionary2.put(PdfName.FONTMATRIX, new PdfArray(new float[]{0.001f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.001f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO}));
        pdfDictionary2.put(PdfName.CHARPROCS, pdfWriter.addToBody(pdfDictionary).getIndirectReference());
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary3.put(PdfName.DIFFERENCES, pdfArray);
        pdfDictionary2.put(PdfName.ENCODING, pdfWriter.addToBody(pdfDictionary3).getIndirectReference());
        pdfDictionary2.put(PdfName.FIRSTCHAR, new PdfNumber(i));
        pdfDictionary2.put(PdfName.LASTCHAR, new PdfNumber(length));
        pdfDictionary2.put(PdfName.WIDTHS, pdfWriter.addToBody(new PdfArray(iArr)).getIndirectReference());
        if (this.pageResources.hasResources()) {
            pdfDictionary2.put(PdfName.RESOURCES, pdfWriter.addToBody(this.pageResources.getResources()).getIndirectReference());
        }
        pdfWriter.addToBody(pdfDictionary2, pdfIndirectReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length];
        int i = 0;
        for (char c : charArray) {
            if (charExists(c)) {
                bArr[i] = (byte) c;
                i++;
            }
        }
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public byte[] convertToBytes(int i) {
        return charExists(i) ? new byte[]{(byte) i} : new byte[0];
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        if (!this.widths3.containsKey(i)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.char.1.is.not.defined.in.a.type3.font", i));
        }
        return this.widths3.get(i);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getWidth(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            i += getWidth(c);
        }
        return i;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean charExists(int i) {
        if (i <= 0 || i >= 256) {
            return false;
        }
        return this.usedSlot[i];
    }
}
