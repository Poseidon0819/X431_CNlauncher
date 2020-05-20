package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FontDetails {
    BaseFont baseFont;
    CJKFont cjkFont;
    IntHashtable cjkTag;
    PdfName fontName;
    int fontType;
    PdfIndirectReference indirectReference;
    HashMap<Integer, int[]> longTag;
    byte[] shortTag;
    protected boolean subset = true;
    boolean symbolic;
    TrueTypeFontUnicode ttu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FontDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, BaseFont baseFont) {
        this.fontName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.baseFont = baseFont;
        this.fontType = baseFont.getFontType();
        switch (this.fontType) {
            case 0:
            case 1:
                this.shortTag = new byte[256];
                return;
            case 2:
                this.cjkTag = new IntHashtable();
                this.cjkFont = (CJKFont) baseFont;
                return;
            case 3:
                this.longTag = new HashMap<>();
                this.ttu = (TrueTypeFontUnicode) baseFont;
                this.symbolic = baseFont.isFontSpecific();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfName getFontName() {
        return this.fontName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        int i;
        int charAt;
        int charAt2;
        switch (this.fontType) {
            case 0:
            case 1:
                byte[] convertToBytes = this.baseFont.convertToBytes(str);
                for (byte b : convertToBytes) {
                    this.shortTag[b & 255] = 1;
                }
                return convertToBytes;
            case 2:
                int length = str.length();
                if (this.cjkFont.isIdentity()) {
                    for (int i2 = 0; i2 < length; i2++) {
                        this.cjkTag.put(str.charAt(i2), 0);
                    }
                } else {
                    int i3 = 0;
                    while (i3 < length) {
                        if (Utilities.isSurrogatePair(str, i3)) {
                            charAt2 = Utilities.convertToUtf32(str, i3);
                            i3++;
                        } else {
                            charAt2 = str.charAt(i3);
                        }
                        this.cjkTag.put(this.cjkFont.getCidCode(charAt2), 0);
                        i3++;
                    }
                }
                return this.cjkFont.convertToBytes(str);
            case 3:
                try {
                    int length2 = str.length();
                    char[] cArr = new char[length2];
                    if (this.symbolic) {
                        byte[] convertToBytes2 = PdfEncodings.convertToBytes(str, "symboltt");
                        int length3 = convertToBytes2.length;
                        i = 0;
                        for (int i4 = 0; i4 < length3; i4++) {
                            int[] metricsTT = this.ttu.getMetricsTT(convertToBytes2[i4] & 255);
                            if (metricsTT != null) {
                                this.longTag.put(Integer.valueOf(metricsTT[0]), new int[]{metricsTT[0], metricsTT[1], this.ttu.getUnicodeDifferences(convertToBytes2[i4] & 255)});
                                cArr[i] = (char) metricsTT[0];
                                i++;
                            }
                        }
                    } else {
                        int i5 = 0;
                        i = 0;
                        while (i5 < length2) {
                            if (Utilities.isSurrogatePair(str, i5)) {
                                charAt = Utilities.convertToUtf32(str, i5);
                                i5++;
                            } else {
                                charAt = str.charAt(i5);
                            }
                            int[] metricsTT2 = this.ttu.getMetricsTT(charAt);
                            if (metricsTT2 != null) {
                                int i6 = metricsTT2[0];
                                Integer valueOf = Integer.valueOf(i6);
                                if (!this.longTag.containsKey(valueOf)) {
                                    this.longTag.put(valueOf, new int[]{i6, metricsTT2[1], charAt});
                                }
                                cArr[i] = (char) i6;
                                i++;
                            }
                            i5++;
                        }
                    }
                    return new String(cArr, 0, i).getBytes("UnicodeBigUnmarked");
                } catch (UnsupportedEncodingException e) {
                    throw new ExceptionConverter(e);
                }
            case 4:
                return this.baseFont.convertToBytes(str);
            case 5:
                return this.baseFont.convertToBytes(str);
            default:
                return null;
        }
    }

    public void writeFont(PdfWriter pdfWriter) {
        try {
            int i = this.fontType;
            if (i == 5) {
                this.baseFont.writeFont(pdfWriter, this.indirectReference, null);
                return;
            }
            switch (i) {
                case 0:
                case 1:
                    int i2 = 0;
                    while (i2 < 256 && this.shortTag[i2] == 0) {
                        i2++;
                    }
                    int i3 = 255;
                    int i4 = 255;
                    while (i4 >= i2 && this.shortTag[i4] == 0) {
                        i4--;
                    }
                    if (i2 > 255) {
                        i2 = 255;
                    } else {
                        i3 = i4;
                    }
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.shortTag, Boolean.valueOf(this.subset)});
                    return;
                case 2:
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.cjkTag});
                    return;
                case 3:
                    this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.longTag, Boolean.valueOf(this.subset)});
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean isSubset() {
        return this.subset;
    }

    public void setSubset(boolean z) {
        this.subset = z;
    }
}
