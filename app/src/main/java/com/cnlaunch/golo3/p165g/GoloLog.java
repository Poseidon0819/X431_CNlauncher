package com.cnlaunch.golo3.p165g;

import android.content.Context;
import android.util.Log;

/* renamed from: com.cnlaunch.golo3.g.l */
/* loaded from: classes.dex */
public final class GoloLog {

    /* renamed from: a */
    private static int f8474a;

    /* renamed from: b */
    private static Context f8475b;

    /* renamed from: a */
    public static void m9133a() {
    }

    /* renamed from: b */
    public static void m9131b() {
    }

    /* renamed from: a */
    public static void m9132a(String str, String str2) {
        if (1 >= f8474a) {
            Log.d(str, str2 + "on" + new Throwable().getStackTrace()[1].toString());
        }
    }

    /* renamed from: b */
    public static void m9130b(String str, String str2) {
        if (4 >= f8474a) {
            String str3 = str2 + " on " + new Throwable().getStackTrace()[1].toString();
            if (str3 != null) {
                Log.e(str, str3);
            } else {
                Log.e("Golo3.0Client", "info null");
            }
        }
    }
}
