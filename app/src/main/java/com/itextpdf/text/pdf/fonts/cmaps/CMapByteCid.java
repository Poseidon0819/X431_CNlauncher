package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CMapByteCid extends AbstractCMap {
    private ArrayList<char[]> planes = new ArrayList<>();

    public CMapByteCid() {
        this.planes.add(new char[256]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap
    public void addChar(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            encodeSequence(decodeStringToByte(pdfString), (char) ((PdfNumber) pdfObject).intValue());
        }
    }

    private void encodeSequence(byte[] bArr, char c) {
        int length = bArr.length - 1;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char[] cArr = this.planes.get(i);
            int i3 = bArr[i2] & 255;
            char c2 = cArr[i3];
            if (c2 != 0 && (c2 & 32768) == 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
            }
            if (c2 == 0) {
                this.planes.add(new char[256]);
                c2 = (char) (32768 | (this.planes.size() - 1));
                cArr[i3] = c2;
            }
            i = c2 & BaseFont.CID_NEWLINE;
        }
        char[] cArr2 = this.planes.get(i);
        int i4 = bArr[length] & 255;
        if ((cArr2[i4] & 32768) != 0) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
        }
        cArr2[i4] = c;
    }

    public int decodeSingle(CMapSequence cMapSequence) {
        int i = cMapSequence.off + cMapSequence.len;
        int i2 = 0;
        while (cMapSequence.off < i) {
            byte[] bArr = cMapSequence.seq;
            int i3 = cMapSequence.off;
            cMapSequence.off = i3 + 1;
            cMapSequence.len--;
            char c = this.planes.get(i2)[bArr[i3] & 255];
            if ((32768 & c) == 0) {
                return c;
            }
            i2 = c & BaseFont.CID_NEWLINE;
        }
        return -1;
    }

    public String decodeSequence(CMapSequence cMapSequence) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int decodeSingle = decodeSingle(cMapSequence);
            if (decodeSingle >= 0) {
                sb.append((char) decodeSingle);
            } else {
                return sb.toString();
            }
        }
    }
}
