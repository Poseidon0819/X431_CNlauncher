package com.itextpdf.text.factories;

import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.pdf.Barcode128;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class RomanNumberFactory {
    private static final RomanDigit[] roman = {new RomanDigit('m', 1000, false), new RomanDigit(Barcode128.CODE_AC_TO_B, UIMsg.d_ResultType.SHORT_URL, false), new RomanDigit(Barcode128.CODE_AB_TO_C, 100, true), new RomanDigit('l', 50, false), new RomanDigit('x', 10, true), new RomanDigit('v', 5, false), new RomanDigit(Barcode128.START_C, 1, true)};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RomanDigit {
        public char digit;
        public boolean pre;
        public int value;

        RomanDigit(char c, int i, boolean z) {
            this.digit = c;
            this.value = i;
            this.pre = z;
        }
    }

    public static final String getString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i < 0) {
            stringBuffer.append(SignatureVisitor.SUPER);
            i = -i;
        }
        if (i > 3000) {
            stringBuffer.append('|');
            int i2 = i / 1000;
            stringBuffer.append(getString(i2));
            stringBuffer.append('|');
            i -= i2 * 1000;
        }
        int i3 = 0;
        while (true) {
            RomanDigit romanDigit = roman[i3];
            while (i >= romanDigit.value) {
                stringBuffer.append(romanDigit.digit);
                i -= romanDigit.value;
            }
            if (i > 0) {
                int i4 = i3;
                do {
                    i4++;
                } while (!roman[i4].pre);
                if (roman[i4].value + i >= romanDigit.value) {
                    stringBuffer.append(roman[i4].digit);
                    stringBuffer.append(romanDigit.digit);
                    i -= romanDigit.value - roman[i4].value;
                }
                i3++;
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public static final String getLowerCaseString(int i) {
        return getString(i);
    }

    public static final String getUpperCaseString(int i) {
        return getString(i).toUpperCase();
    }

    public static final String getString(int i, boolean z) {
        if (z) {
            return getLowerCaseString(i);
        }
        return getUpperCaseString(i);
    }
}
