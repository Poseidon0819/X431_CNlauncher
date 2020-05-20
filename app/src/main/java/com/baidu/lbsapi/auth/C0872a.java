package com.baidu.lbsapi.auth;

import android.util.Log;

/* renamed from: com.baidu.lbsapi.auth.a */
/* loaded from: classes.dex */
class C0872a {

    /* renamed from: a */
    public static boolean f3743a = false;

    /* renamed from: b */
    private static String f3744b = "BaiduApiAuth";

    /* renamed from: a */
    public static String m12370a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    /* renamed from: a */
    public static void m12369a(String str) {
        if (!f3743a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f3744b;
        Log.d(str2, m12370a() + ";" + str);
    }

    /* renamed from: b */
    public static void m12368b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(f3744b, str);
    }

    /* renamed from: c */
    public static void m12367c(String str) {
        if (!f3743a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        String str2 = f3744b;
        Log.e(str2, m12370a() + ";" + str);
    }
}
