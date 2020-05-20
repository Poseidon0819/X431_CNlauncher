package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.fonts.cmaps.CMapByteCid;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapSequence;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class CMapAwareDocumentFont extends DocumentFont {
    private CMapByteCid byteCid;
    private CMapCidUni cidUni;
    private char[] cidbyte2uni;
    private PdfDictionary fontDic;
    private int spaceWidth;
    private CMapToUnicode toUnicodeCmap;
    private Map<Integer, Integer> uni2cid;

    public CMapAwareDocumentFont(PdfDictionary pdfDictionary) {
        super(pdfDictionary);
        this.fontDic = pdfDictionary;
        initFont();
    }

    public CMapAwareDocumentFont(PRIndirectReference pRIndirectReference) {
        super(pRIndirectReference);
        this.fontDic = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
        initFont();
    }

    private void initFont() {
        processToUnicode();
        try {
            processUni2Byte();
            this.spaceWidth = super.getWidth(32);
            if (this.spaceWidth == 0) {
                this.spaceWidth = computeAverageWidth();
            }
            if (this.cjkEncoding != null) {
                this.byteCid = CMapCache.getCachedCMapByteCid(this.cjkEncoding);
                this.cidUni = CMapCache.getCachedCMapCidUni(this.uniMap);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void processToUnicode() {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(this.fontDic.get(PdfName.TOUNICODE));
        if (pdfObjectRelease instanceof PRStream) {
            try {
                CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.getStreamBytes((PRStream) pdfObjectRelease));
                this.toUnicodeCmap = new CMapToUnicode();
                CMapParserEx.parseCid("", this.toUnicodeCmap, cidLocationFromByte);
                this.uni2cid = this.toUnicodeCmap.createReverseMapping();
            } catch (IOException unused) {
                this.toUnicodeCmap = null;
                this.uni2cid = null;
            }
        }
    }

    private void processUni2Byte() throws IOException {
        IntHashtable uni2Byte = getUni2Byte();
        int[] orderedKeys = uni2Byte.toOrderedKeys();
        if (orderedKeys.length == 0) {
            return;
        }
        this.cidbyte2uni = new char[256];
        CMapToUnicode cMapToUnicode = this.toUnicodeCmap;
        if (cMapToUnicode == null) {
            for (int i = 0; i < orderedKeys.length; i++) {
                int i2 = uni2Byte.get(orderedKeys[i]);
                if (i2 < 256) {
                    char[] cArr = this.cidbyte2uni;
                    if (cArr[i2] == 0) {
                        cArr[i2] = (char) orderedKeys[i];
                    }
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : cMapToUnicode.createDirectMapping().entrySet()) {
                if (entry.getKey().intValue() < 256) {
                    this.cidbyte2uni[entry.getKey().intValue()] = (char) entry.getValue().intValue();
                }
            }
        }
        IntHashtable diffmap = getDiffmap();
        if (diffmap != null) {
            int[] orderedKeys2 = diffmap.toOrderedKeys();
            for (int i3 = 0; i3 < orderedKeys2.length; i3++) {
                int i4 = diffmap.get(orderedKeys2[i3]);
                if (i4 < 256) {
                    this.cidbyte2uni[i4] = (char) orderedKeys2[i3];
                }
            }
        }
    }

    private int computeAverageWidth() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.widths.length; i3++) {
            if (this.widths[i3] != 0) {
                i2 += this.widths[i3];
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.DocumentFont, com.itextpdf.text.pdf.BaseFont
    public int getWidth(int i) {
        if (i == 32) {
            return this.spaceWidth;
        }
        return super.getWidth(i);
    }

    private String decodeSingleCID(byte[] bArr, int i, int i2) {
        CMapToUnicode cMapToUnicode = this.toUnicodeCmap;
        if (cMapToUnicode != null) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(MessageLocalization.getComposedMessage("invalid.index.1", i3));
            }
            String lookup = cMapToUnicode.lookup(bArr, i, i2);
            if (lookup != null) {
                return lookup;
            }
            if (i2 != 1 || this.cidbyte2uni == null) {
                return null;
            }
        }
        if (i2 == 1) {
            char[] cArr = this.cidbyte2uni;
            return cArr == null ? "" : new String(cArr, bArr[i] & 255, 1);
        }
        throw new Error("Multi-byte glyphs not implemented yet");
    }

    public String decode(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (this.toUnicodeCmap != null || this.byteCid == null) {
            int i3 = i;
            while (true) {
                int i4 = i + i2;
                if (i3 >= i4) {
                    break;
                }
                String decodeSingleCID = decodeSingleCID(bArr, i3, 1);
                if (decodeSingleCID == null && i3 < i4 - 1) {
                    decodeSingleCID = decodeSingleCID(bArr, i3, 2);
                    i3++;
                }
                if (decodeSingleCID != null) {
                    sb.append(decodeSingleCID);
                }
                i3++;
            }
        } else {
            String decodeSequence = this.byteCid.decodeSequence(new CMapSequence(bArr, i, i2));
            for (int i5 = 0; i5 < decodeSequence.length(); i5++) {
                int lookup = this.cidUni.lookup(decodeSequence.charAt(i5));
                if (lookup > 0) {
                    sb.append(Utilities.convertFromUtf32(lookup));
                }
            }
        }
        return sb.toString();
    }

    public String encode(byte[] bArr, int i, int i2) {
        return decode(bArr, i, i2);
    }
}
