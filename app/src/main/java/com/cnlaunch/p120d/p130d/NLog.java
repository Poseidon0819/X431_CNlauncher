package com.cnlaunch.p120d.p130d;

import android.util.Log;

/* renamed from: com.cnlaunch.d.d.c */
/* loaded from: classes.dex */
public final class NLog {

    /* renamed from: a */
    private static boolean f7236a = false;

    /* renamed from: a */
    public static void m9456a(String str, Object... objArr) {
        m9457a(3, null, str, objArr);
    }

    /* renamed from: b */
    public static void m9452b(String str, Object... objArr) {
        m9457a(4, null, str, objArr);
    }

    /* renamed from: a */
    public static void m9455a(Throwable th) {
        m9457a(6, th, null, new Object[0]);
    }

    /* renamed from: c */
    public static void m9451c(String str, Object... objArr) {
        m9457a(6, null, str, objArr);
    }

    /* renamed from: a */
    public static void m9454a(Throwable th, String str, Object... objArr) {
        m9457a(6, th, str, objArr);
    }

    /* renamed from: a */
    private static void m9457a(int i, Throwable th, String str, Object... objArr) {
        if (f7236a) {
            String str2 = "";
            if (th == null) {
                if (objArr != null && objArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Object obj : objArr) {
                        sb.append(String.valueOf(obj));
                    }
                    str2 = sb.toString();
                }
            } else {
                str2 = String.format("%1$s%n%2$s", th.getMessage(), Log.getStackTraceString(th));
            }
            int i2 = 0;
            for (int i3 = 0; i3 < str2.length(); i3 = i2) {
                i2 += 2048;
                if (i2 > str2.length()) {
                    i2 = str2.length();
                }
                try {
                    Log.println(i, str, str2.substring(i3, i2));
                } catch (StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m9458a() {
        return f7236a;
    }

    /* renamed from: a */
    public static void m9453a(boolean z) {
        f7236a = z;
    }
}
