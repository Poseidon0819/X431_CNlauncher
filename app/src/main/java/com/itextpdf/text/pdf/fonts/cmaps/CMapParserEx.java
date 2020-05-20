package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CMapParserEx {
    private static final PdfName CMAPNAME = new PdfName("CMapName");
    private static final String DEF = "def";
    private static final String ENDBFCHAR = "endbfchar";
    private static final String ENDBFRANGE = "endbfrange";
    private static final String ENDCIDCHAR = "endcidchar";
    private static final String ENDCIDRANGE = "endcidrange";
    private static final int MAXLEVEL = 10;
    private static final String USECMAP = "usecmap";

    public static void parseCid(String str, AbstractCMap abstractCMap, CidLocation cidLocation) throws IOException {
        parseCid(str, abstractCMap, cidLocation, 0);
    }

    private static void parseCid(String str, AbstractCMap abstractCMap, CidLocation cidLocation, int i) throws IOException {
        if (i >= 10) {
            return;
        }
        PRTokeniser location = cidLocation.getLocation(str);
        try {
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            PdfContentParser pdfContentParser = new PdfContentParser(location);
            int i2 = 50;
            while (true) {
                try {
                    pdfContentParser.parse(arrayList);
                } catch (Exception unused) {
                    i2--;
                    if (i2 < 0) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    break;
                }
                String pdfObject = arrayList.get(arrayList.size() - 1).toString();
                int i3 = 0;
                if (i == 0 && arrayList.size() == 3 && pdfObject.equals(DEF)) {
                    PdfObject pdfObject2 = arrayList.get(0);
                    if (PdfName.REGISTRY.equals(pdfObject2)) {
                        abstractCMap.setRegistry(arrayList.get(1).toString());
                    } else if (PdfName.ORDERING.equals(pdfObject2)) {
                        abstractCMap.setOrdering(arrayList.get(1).toString());
                    } else if (CMAPNAME.equals(pdfObject2)) {
                        abstractCMap.setName(arrayList.get(1).toString());
                    } else if (PdfName.SUPPLEMENT.equals(pdfObject2)) {
                        try {
                            abstractCMap.setSupplement(((PdfNumber) arrayList.get(1)).intValue());
                        } catch (Exception unused2) {
                        }
                    }
                } else if ((pdfObject.equals(ENDCIDCHAR) || pdfObject.equals(ENDBFCHAR)) && arrayList.size() >= 3) {
                    int size = arrayList.size() - 2;
                    while (i3 < size) {
                        if (arrayList.get(i3) instanceof PdfString) {
                            abstractCMap.addChar((PdfString) arrayList.get(i3), arrayList.get(i3 + 1));
                        }
                        i3 += 2;
                    }
                } else if ((pdfObject.equals(ENDCIDRANGE) || pdfObject.equals(ENDBFRANGE)) && arrayList.size() >= 4) {
                    int size2 = arrayList.size() - 3;
                    while (i3 < size2) {
                        if (arrayList.get(i3) instanceof PdfString) {
                            int i4 = i3 + 1;
                            if (arrayList.get(i4) instanceof PdfString) {
                                abstractCMap.addRange((PdfString) arrayList.get(i3), (PdfString) arrayList.get(i4), arrayList.get(i3 + 2));
                            }
                        }
                        i3 += 3;
                    }
                } else if (pdfObject.equals(USECMAP) && arrayList.size() == 2 && (arrayList.get(0) instanceof PdfName)) {
                    parseCid(PdfName.decodeName(arrayList.get(0).toString()), abstractCMap, cidLocation, i + 1);
                }
            }
        } finally {
            location.close();
        }
    }

    private static void encodeSequence(int i, byte[] bArr, char c, ArrayList<char[]> arrayList) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            char[] cArr = arrayList.get(i3);
            int i5 = bArr[i4] & 255;
            char c2 = cArr[i5];
            if (c2 != 0 && (c2 & 32768) == 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
            }
            if (c2 == 0) {
                arrayList.add(new char[256]);
                c2 = (char) (32768 | (arrayList.size() - 1));
                cArr[i5] = c2;
            }
            i3 = c2 & BaseFont.CID_NEWLINE;
        }
        char[] cArr2 = arrayList.get(i3);
        int i6 = bArr[i2] & 255;
        if ((cArr2[i6] & 32768) != 0) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
        }
        cArr2[i6] = c;
    }
}
