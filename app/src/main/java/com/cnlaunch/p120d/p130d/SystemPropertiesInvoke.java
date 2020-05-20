package com.cnlaunch.p120d.p130d;

import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: com.cnlaunch.d.d.g */
/* loaded from: classes.dex */
public final class SystemPropertiesInvoke {

    /* renamed from: a */
    private static Method f7250a;

    /* renamed from: b */
    private static Method f7251b;

    /* renamed from: c */
    private static Method f7252c;

    /* renamed from: a */
    public static boolean m9431a(String str) {
        try {
            if (f7251b == null) {
                f7251b = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE);
            }
            return ((Boolean) f7251b.invoke(null, str, Boolean.FALSE)).booleanValue();
        } catch (Exception e) {
            Log.e("SystemPropertiesInvoke", "Platform error: " + e.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static String m9430b(String str) {
        try {
            if (f7252c == null) {
                f7252c = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            }
            return (String) f7252c.invoke(null, str);
        } catch (Exception e) {
            Log.e("SystemPropertiesInvoke", "Platform error: " + e.toString());
            return "";
        }
    }
}
