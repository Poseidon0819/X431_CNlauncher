package com.cnlaunch.wifiprinter;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.cnlaunch.wifiprinter.m */
/* loaded from: classes.dex */
public final class MySharedPreferences {

    /* renamed from: a */
    public static SharedPreferences f10460a;

    /* renamed from: a */
    public static SharedPreferences m8004a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MYSHAREDNAME", 0);
        f10460a = sharedPreferences;
        return sharedPreferences;
    }

    /* renamed from: a */
    public static String m8003a(Context context, String str) {
        if (f10460a == null) {
            m8004a(context);
        }
        return f10460a.getString(str, null);
    }

    /* renamed from: a */
    public static void m8002a(Context context, String str, String str2) {
        if (f10460a == null) {
            m8004a(context);
        }
        f10460a.edit().putString(str, str2).commit();
    }

    /* renamed from: b */
    public static void m8001b(Context context, String str, String str2) {
        if (f10460a == null) {
            m8004a(context);
        }
        f10460a.edit().putString(str, str2).commit();
    }
}
