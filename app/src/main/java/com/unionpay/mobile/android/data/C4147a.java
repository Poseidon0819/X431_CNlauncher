package com.unionpay.mobile.android.data;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.unionpay.mobile.android.utils.C4388i;
import java.util.HashMap;

/* renamed from: com.unionpay.mobile.android.data.a */
/* loaded from: classes2.dex */
public final class C4147a {

    /* renamed from: a */
    public static final HashMap<String, Integer> f22096a = new HashMap<>();

    /* renamed from: a */
    public static SpannableString m1611a(String str, String str2) {
        String[] split;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-10066330), 0, str.length(), 33);
        if (str2 == null) {
            return spannableString;
        }
        int i = -10066330;
        for (String str3 : str2.split(";")) {
            if (m1612a(str3)) {
                break;
            }
            try {
                i = Color.parseColor("#".concat(String.valueOf(str3)));
            } catch (Exception unused) {
            }
        }
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    public static final boolean m1612a(String str) {
        if (!C4388i.m849b(str)) {
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
