package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.factories.RomanAlphabetFactory;
import com.itextpdf.text.factories.RomanNumberFactory;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PdfPageLabels {
    public static final int DECIMAL_ARABIC_NUMERALS = 0;
    public static final int EMPTY = 5;
    public static final int LOWERCASE_LETTERS = 4;
    public static final int LOWERCASE_ROMAN_NUMERALS = 2;
    public static final int UPPERCASE_LETTERS = 3;
    public static final int UPPERCASE_ROMAN_NUMERALS = 1;
    static PdfName[] numberingStyle = {PdfName.f19699D, PdfName.f19760R, new PdfName("r"), PdfName.f19679A, new PdfName(HtmlTags.f19618A)};
    private HashMap<Integer, PdfDictionary> map = new HashMap<>();

    public PdfPageLabels() {
        addPageLabel(1, 0, null, 1);
    }

    public void addPageLabel(int i, int i2, String str, int i3) {
        if (i <= 0 || i3 <= 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("in.a.page.label.the.page.numbers.must.be.greater.or.equal.to.1", new Object[0]));
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (i2 >= 0 && i2 < numberingStyle.length) {
            pdfDictionary.put(PdfName.f19767S, numberingStyle[i2]);
        }
        if (str != null) {
            pdfDictionary.put(PdfName.f19752P, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (i3 != 1) {
            pdfDictionary.put(PdfName.f19769ST, new PdfNumber(i3));
        }
        this.map.put(Integer.valueOf(i - 1), pdfDictionary);
    }

    public void addPageLabel(int i, int i2, String str) {
        addPageLabel(i, i2, str, 1);
    }

    public void addPageLabel(int i, int i2) {
        addPageLabel(i, i2, null, 1);
    }

    public void addPageLabel(PdfPageLabelFormat pdfPageLabelFormat) {
        addPageLabel(pdfPageLabelFormat.physicalPage, pdfPageLabelFormat.numberStyle, pdfPageLabelFormat.prefix, pdfPageLabelFormat.logicalPage);
    }

    public void removePageLabel(int i) {
        if (i <= 1) {
            return;
        }
        this.map.remove(Integer.valueOf(i - 1));
    }

    public PdfDictionary getDictionary(PdfWriter pdfWriter) {
        try {
            return PdfNumberTree.writeTree(this.map, pdfWriter);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String[] getPageLabels(PdfReader pdfReader) {
        int numberOfPages = pdfReader.getNumberOfPages();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        String[] strArr = new String[numberOfPages];
        HashMap<Integer, PdfObject> readTree = PdfNumberTree.readTree(pdfDictionary);
        String str = "";
        int i = 1;
        char c = 'D';
        for (int i2 = 0; i2 < numberOfPages; i2++) {
            Integer valueOf = Integer.valueOf(i2);
            if (readTree.containsKey(valueOf)) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(readTree.get(valueOf));
                int intValue = pdfDictionary2.contains(PdfName.f19769ST) ? ((PdfNumber) pdfDictionary2.get(PdfName.f19769ST)).intValue() : 1;
                if (pdfDictionary2.contains(PdfName.f19752P)) {
                    str = ((PdfString) pdfDictionary2.get(PdfName.f19752P)).toUnicodeString();
                }
                if (pdfDictionary2.contains(PdfName.f19767S)) {
                    int i3 = intValue;
                    c = ((PdfName) pdfDictionary2.get(PdfName.f19767S)).toString().charAt(1);
                    i = i3;
                } else {
                    i = intValue;
                    c = Barcode128.CODE_BC_TO_A;
                }
            }
            if (c == 'A') {
                strArr[i2] = str + RomanAlphabetFactory.getUpperCaseString(i);
            } else if (c == 'R') {
                strArr[i2] = str + RomanNumberFactory.getUpperCaseString(i);
            } else if (c == 'a') {
                strArr[i2] = str + RomanAlphabetFactory.getLowerCaseString(i);
            } else if (c == 'e') {
                strArr[i2] = str;
            } else if (c != 'r') {
                strArr[i2] = str + i;
            } else {
                strArr[i2] = str + RomanNumberFactory.getLowerCaseString(i);
            }
            i++;
        }
        return strArr;
    }

    public static PdfPageLabelFormat[] getPageLabelFormats(PdfReader pdfReader) {
        int i;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        HashMap<Integer, PdfObject> readTree = PdfNumberTree.readTree(pdfDictionary);
        Integer[] numArr = (Integer[]) readTree.keySet().toArray(new Integer[readTree.size()]);
        Arrays.sort(numArr);
        PdfPageLabelFormat[] pdfPageLabelFormatArr = new PdfPageLabelFormat[readTree.size()];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(readTree.get(num));
            int intValue = pdfDictionary2.contains(PdfName.f19769ST) ? ((PdfNumber) pdfDictionary2.get(PdfName.f19769ST)).intValue() : 1;
            String unicodeString = pdfDictionary2.contains(PdfName.f19752P) ? ((PdfString) pdfDictionary2.get(PdfName.f19752P)).toUnicodeString() : "";
            if (pdfDictionary2.contains(PdfName.f19767S)) {
                char charAt = ((PdfName) pdfDictionary2.get(PdfName.f19767S)).toString().charAt(1);
                i = charAt != 'A' ? charAt != 'R' ? charAt != 'a' ? charAt != 'r' ? 0 : 2 : 4 : 1 : 3;
            } else {
                i = 5;
            }
            pdfPageLabelFormatArr[i2] = new PdfPageLabelFormat(num.intValue() + 1, i, unicodeString, intValue);
        }
        return pdfPageLabelFormatArr;
    }

    /* loaded from: classes.dex */
    public static class PdfPageLabelFormat {
        public int logicalPage;
        public int numberStyle;
        public int physicalPage;
        public String prefix;

        public PdfPageLabelFormat(int i, int i2, String str, int i3) {
            this.physicalPage = i;
            this.numberStyle = i2;
            this.prefix = str;
            this.logicalPage = i3;
        }
    }
}
