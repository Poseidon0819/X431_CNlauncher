package com.launch.p353a.p364k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

/* renamed from: com.launch.a.k.d */
/* loaded from: classes.dex */
public final class LUAsdk {

    /* renamed from: a */
    public static String f19966a = null;

    /* renamed from: b */
    public static String f19967b = "";

    /* renamed from: c */
    private static String f19968c = "";

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public static void m2638a(Context context, String str) {
        if (!StringUtil.m2629a(str)) {
            f19966a = str;
            f19968c = m2639a(context);
            C3667e.m2636a(context);
            new Thread(new RunnableC3670k()).start();
        } else if (StringUtil.m2629a(str)) {
            Log.e("LUAsdk.init error", "=================appID is null========================");
        }
    }

    /* renamed from: a */
    private static String m2639a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.launch.adsdk.key");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m2640a() {
        return f19968c;
    }

    /* renamed from: a */
    public static void m2637a(String str, String str2) {
        f19966a = str;
        f19968c = str2;
    }
}
