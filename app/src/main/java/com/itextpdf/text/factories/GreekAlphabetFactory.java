package com.itextpdf.text.factories;

import com.itextpdf.text.SpecialSymbol;

/* loaded from: classes.dex */
public class GreekAlphabetFactory {
    public static final String getString(int i) {
        return getString(i, true);
    }

    public static final String getLowerCaseString(int i) {
        return getString(i);
    }

    public static final String getUpperCaseString(int i) {
        return getString(i).toUpperCase();
    }

    public static final String getString(int i, boolean z) {
        if (i <= 0) {
            return "";
        }
        int i2 = i - 1;
        int i3 = 0;
        int i4 = 24;
        int i5 = 1;
        while (true) {
            int i6 = i4 + i3;
            if (i2 < i6) {
                break;
            }
            i5++;
            i4 *= 24;
            i3 = i6;
        }
        int i7 = i2 - i3;
        char[] cArr = new char[i5];
        while (i5 > 0) {
            i5--;
            cArr[i5] = (char) (i7 % 24);
            if (cArr[i5] > 16) {
                cArr[i5] = (char) (cArr[i5] + 1);
            }
            cArr[i5] = (char) (cArr[i5] + (z ? (char) 945 : (char) 913));
            cArr[i5] = SpecialSymbol.getCorrespondingSymbol(cArr[i5]);
            i7 /= 24;
        }
        return String.valueOf(cArr);
    }
}
