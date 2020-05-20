package com.cnlaunch.p118c.p119a;

import android.text.TextUtils;

/* renamed from: com.cnlaunch.c.a.a */
/* loaded from: classes.dex */
public final class MyTools {
    /* renamed from: a */
    public static boolean m9636a(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str.trim());
    }

    /* renamed from: b */
    public static boolean m9635b(String str) {
        String replace = str.replace("\ufeff", "");
        if (TextUtils.isEmpty(replace.trim())) {
            return false;
        }
        String[] strArr = {"\\", "/", ":", "*", "?", "\"", "<", ">", "|", "%"};
        for (int i = 0; i < 10; i++) {
            if (replace.indexOf(strArr[i]) != -1) {
                return false;
            }
        }
        for (int i2 = 0; i2 < replace.length(); i2++) {
            char charAt = replace.charAt(i2);
            if (!(charAt == 0 || charAt == '\t' || charAt == '\n' || charAt == '\r' || (charAt >= ' ' && charAt <= 55295)) || (charAt >= 57344 && charAt <= 65533) || (charAt >= 0 && charAt <= 65535)) {
                return false;
            }
        }
        return true;
    }
}
