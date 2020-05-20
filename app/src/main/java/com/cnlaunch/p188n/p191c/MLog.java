package com.cnlaunch.p188n.p191c;

import android.util.Log;

/* renamed from: com.cnlaunch.n.c.e */
/* loaded from: classes.dex */
public final class MLog {

    /* renamed from: a */
    public static boolean f9645a = false;

    /* renamed from: b */
    private static boolean f9646b = false;

    /* renamed from: a */
    public static void m8522a(String str, String str2) {
        if (f9646b) {
            Log.d(str, str2);
        }
    }

    /* renamed from: b */
    public static void m8521b(String str, String str2) {
        if (f9646b) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m8520c(String str, String str2) {
        if (f9646b) {
            Log.i(str, str2);
        }
    }
}
