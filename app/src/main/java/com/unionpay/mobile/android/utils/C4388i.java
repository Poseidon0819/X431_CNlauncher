package com.unionpay.mobile.android.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

/* renamed from: com.unionpay.mobile.android.utils.i */
/* loaded from: classes2.dex */
public final class C4388i {
    /* renamed from: a */
    public static SpannableString m850a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!m849b(str)) {
            str5 = "" + str;
        }
        if (!m849b(str3)) {
            str5 = str5 + str3;
        }
        if (!m849b(str4)) {
            str5 = str5 + str4;
        }
        SpannableString spannableString = new SpannableString(str5);
        int length = m849b(str) ? 0 : str.length();
        int length2 = (m849b(str3) ? 0 : str3.length()) + length;
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, str5.length(), 33);
        if (!m849b(str2)) {
            if (str2.length() == 6 || !m848c(str2)) {
                str2 = "#".concat(String.valueOf(str2));
            }
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), length, length2, 33);
        }
        return spannableString;
    }

    /* renamed from: a */
    public static final String m851a(String str) {
        return (str == null || str.length() <= 2) ? "" : str.substring(1, str.length() - 1);
    }

    /* renamed from: b */
    public static final boolean m849b(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: c */
    private static final boolean m848c(String str) {
        if (!m849b(str)) {
            String[] strArr = {"black", "darkgray", "gray", "lightgray", "white", "red", "green", "blue", "yellow", "cyan", "magenta"};
            for (int i = 0; i < 11; i++) {
                if (strArr[i].equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
