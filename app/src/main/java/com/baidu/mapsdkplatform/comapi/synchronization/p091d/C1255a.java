package com.baidu.mapsdkplatform.comapi.synchronization.p091d;

import android.util.Log;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.d.a */
/* loaded from: classes.dex */
public final class C1255a {

    /* renamed from: a */
    private static boolean f6207a = true;

    /* renamed from: a */
    private static String m10458a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getLineNumber();
    }

    /* renamed from: a */
    public static void m10457a(String str, String str2) {
        if (f6207a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m10456a(String str, String str2, Throwable th) {
        if (f6207a) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public static void m10455a(boolean z) {
        f6207a = z;
    }

    /* renamed from: b */
    private static String m10454b() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    /* renamed from: b */
    public static void m10453b(String str, String str2) {
        if (f6207a) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m10452c(String str, String str2) {
        Log.d(str + "-" + m10454b() + "-" + m10458a(), str2);
    }
}
