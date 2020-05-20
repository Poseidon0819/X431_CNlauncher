package com.cnlaunch.x431pro.utils;

import com.cnlaunch.x431pro.utils.C2778n;

/* renamed from: com.cnlaunch.x431pro.utils.m */
/* loaded from: classes.dex */
public final class CardUtil {
    /* renamed from: a */
    public static String m4921a(String str) {
        if (str == null) {
            return null;
        }
        String substring = str.endsWith(".0") ? str.substring(0, str.length() - 2) : null;
        if (substring == null) {
            substring = C2778n.C2782b.m4890a(str.replace("Z", "+00:00"), "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss");
        }
        if (substring == null) {
            substring = C2778n.C2782b.m4890a(str.replace("Z", "+00:00"), "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss");
        }
        return substring == null ? str : substring;
    }
}
