package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class TtfUnicodeWriter {
    protected PdfWriter writer;

    public TtfUnicodeWriter(PdfWriter pdfWriter) {
        this.writer = null;
        this.writer = pdfWriter;
    }

    public void writeFont(TrueTypeFontUnicode trueTypeFontUnicode, PdfIndirectReference pdfIndirectReference, Object[] objArr, byte[] bArr) throws DocumentException, IOException {
        byte[] process;
        PdfIndirectReference indirectReference;
        HashMap<Integer, int[]> hashMap = (HashMap) objArr[0];
        trueTypeFontUnicode.addRangeUni(hashMap, true, trueTypeFontUnicode.subset);
        int[][] iArr = (int[][]) hashMap.values().toArray(new int[0]);
        Arrays.sort(iArr, trueTypeFontUnicode);
        if (trueTypeFontUnicode.cff) {
            byte[] readCffFont = trueTypeFontUnicode.readCffFont();
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.subsetRanges != null) {
                CFFFontSubset cFFFontSubset = new CFFFontSubset(new RandomAccessFileOrArray(readCffFont), hashMap);
                readCffFont = cFFFontSubset.Process(cFFFontSubset.getNames()[0]);
            }
            indirectReference = this.writer.addToBody(new BaseFont.StreamFont(readCffFont, "CIDFontType0C", trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        } else {
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.directoryOffset != 0) {
                process = new TrueTypeFontSubSet(trueTypeFontUnicode.fileName, new RandomAccessFileOrArray(trueTypeFontUnicode.f19810rf), new HashSet(hashMap.keySet()), trueTypeFontUnicode.directoryOffset, false, false).process();
            } else {
                process = trueTypeFontUnicode.getFullFont();
            }
            indirectReference = this.writer.addToBody(new BaseFont.StreamFont(process, new int[]{process.length}, trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        }
        String createSubsetPrefix = trueTypeFontUnicode.subset ? TrueTypeFontUnicode.createSubsetPrefix() : "";
        PdfIndirectReference indirectReference2 = this.writer.addToBody(trueTypeFontUnicode.getCIDFontType2(this.writer.addToBody(trueTypeFontUnicode.getFontDescriptor(indirectReference, createSubsetPrefix, null)).getIndirectReference(), createSubsetPrefix, iArr)).getIndirectReference();
        PdfStream toUnicode = trueTypeFontUnicode.getToUnicode(iArr);
        this.writer.addToBody(trueTypeFontUnicode.getFontBaseType(indirectReference2, createSubsetPrefix, toUnicode != null ? this.writer.addToBody(toUnicode).getIndirectReference() : null), pdfIndirectReference);
    }
}
