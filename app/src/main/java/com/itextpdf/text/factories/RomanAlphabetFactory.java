package com.itextpdf.text.factories;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class RomanAlphabetFactory {
    public static final String getString(int i) {
        if (i <= 0) {
            throw new NumberFormatException(MessageLocalization.getComposedMessage("you.can.t.translate.a.negative.number.into.an.alphabetical.value", new Object[0]));
        }
        int i2 = i - 1;
        int i3 = 26;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int i6 = i3 + i4;
            if (i2 < i6) {
                break;
            }
            i5++;
            i3 *= 26;
            i4 = i6;
        }
        int i7 = i2 - i4;
        char[] cArr = new char[i5];
        while (i5 > 0) {
            i5--;
            cArr[i5] = (char) ((i7 % 26) + 97);
            i7 /= 26;
        }
        return new String(cArr);
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
