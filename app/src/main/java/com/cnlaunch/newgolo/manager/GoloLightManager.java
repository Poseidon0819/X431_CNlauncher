package com.cnlaunch.newgolo.manager;

/* loaded from: classes.dex */
public class GoloLightManager {
    public static native void native_gpio_setDirection(String str, int i, String str2);

    public static native int native_gpio_setValue(String str, int i, int i2);

    static {
        System.loadLibrary("gpio_jni");
    }

    /* renamed from: b */
    public static void m8496b() {
        m8497a("PM", 1);
    }

    /* renamed from: c */
    public static void m8495c() {
        m8497a("PM", 0);
    }

    /* renamed from: a */
    private static int m8497a(String str, int i) {
        return native_gpio_setValue(str.toUpperCase(), 5, i);
    }

    /* renamed from: a */
    public static void m8498a() {
        native_gpio_setDirection("PM".toUpperCase(), 5, "out".toLowerCase());
    }
}
