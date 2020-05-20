package com.cnlaunch.x431pro.utils;

import com.itextpdf.text.pdf.Barcode128;

/* renamed from: com.cnlaunch.x431pro.utils.q */
/* loaded from: classes.dex */
public final class FirstLetterUtils {

    /* renamed from: a */
    private static int f15916a = 45217;

    /* renamed from: b */
    private static int f15917b = 63486;

    /* renamed from: c */
    private static char[] f15918c = {21834, 33453, 25830, 25645, 34558, 21457, 22134, 21704, 21704, 20987, 21888, 22403, 22920, 25343, 21734, 21866, 26399, 28982, 25746, 22604, 22604, 22604, 25366, 26132, 21387, 21277};

    /* renamed from: d */
    private static int[] f15919d = new int[27];

    /* renamed from: e */
    private static char[] f15920e = {'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_B, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 't', 't', 'w', 'x', 'y', 'z'};

    static {
        for (int i = 0; i < 26; i++) {
            f15919d[i] = m4874b(f15918c[i]);
        }
        f15919d[26] = f15917b;
    }

    /* renamed from: a */
    public static String m4875a(String str) {
        String lowerCase;
        String str2 = "";
        for (int i = 0; i < str.toLowerCase().length(); i++) {
            try {
                str2 = str2 + m4876a(lowerCase.charAt(i));
            } catch (Exception unused) {
                return "";
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static char m4876a(char c) {
        int m4874b;
        if (c < 'a' || c > 'z') {
            if ((c < 'A' || c > 'Z') && (m4874b = m4874b(c)) >= f15916a && m4874b <= f15917b) {
                int i = 0;
                while (i < 26) {
                    int[] iArr = f15919d;
                    if (m4874b >= iArr[i] && m4874b < iArr[i + 1]) {
                        break;
                    }
                    i++;
                }
                if (m4874b == f15917b) {
                    i = 25;
                }
                return f15920e[i];
            }
            return c;
        }
        return c;
    }

    /* renamed from: b */
    private static int m4874b(char c) {
        String str = new String();
        try {
            byte[] bytes = (str + c).getBytes("GB2312");
            if (bytes.length < 2) {
                return 0;
            }
            return ((bytes[0] << 8) & 65280) + (bytes[1] & 255);
        } catch (Exception unused) {
            return 0;
        }
    }
}
