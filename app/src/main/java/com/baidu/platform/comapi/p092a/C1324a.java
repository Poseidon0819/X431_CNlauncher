package com.baidu.platform.comapi.p092a;

import android.content.Context;

/* renamed from: com.baidu.platform.comapi.a.a */
/* loaded from: classes.dex */
public class C1324a {

    /* renamed from: a */
    private static int f6493a = 621133959;

    /* renamed from: a */
    public static boolean m9934a(Context context) {
        return m9932c(context);
    }

    /* renamed from: b */
    private static int m9933b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures[0].hashCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: c */
    private static boolean m9932c(Context context) {
        return m9933b(context) == f6493a;
    }
}
