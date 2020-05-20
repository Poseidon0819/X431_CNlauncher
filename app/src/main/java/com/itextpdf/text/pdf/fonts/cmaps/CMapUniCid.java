package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.IntHashtable;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* loaded from: classes.dex */
public class CMapUniCid extends AbstractCMap {
    private IntHashtable map = new IntHashtable(65537);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap
    public void addChar(PdfString pdfString, PdfObject pdfObject) {
        int charAt;
        if (pdfObject instanceof PdfNumber) {
            String decodeStringToUnicode = decodeStringToUnicode(pdfString);
            if (Utilities.isSurrogatePair(decodeStringToUnicode, 0)) {
                charAt = Utilities.convertToUtf32(decodeStringToUnicode, 0);
            } else {
                charAt = decodeStringToUnicode.charAt(0);
            }
            this.map.put(charAt, ((PdfNumber) pdfObject).intValue());
        }
    }

    public int lookup(int i) {
        return this.map.get(i);
    }
}
