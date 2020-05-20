package com.cnlaunch.physics.p205k;

import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p197c.DPUSoftInfo;

/* renamed from: com.cnlaunch.physics.k.j */
/* loaded from: classes.dex */
public final class DeviceUtils {

    /* renamed from: b */
    private static DeviceUtils f10115b;

    /* renamed from: c */
    private String f10117c = "";

    /* renamed from: a */
    public boolean f10116a = false;

    private DeviceUtils() {
    }

    /* renamed from: a */
    public static DeviceUtils m8149a() {
        if (f10115b == null) {
            f10115b = new DeviceUtils();
        }
        return f10115b;
    }

    /* renamed from: a */
    public static DPUHardwareInfo m8147a(String str, String str2) {
        return DeviceProperties.m8157a(str, str2).m8160a();
    }

    /* renamed from: a */
    public static void m8144a(String str, String str2, String[] strArr) {
        m8146a(str, str2, new DPUHardwareInfo(strArr));
    }

    /* renamed from: a */
    private static void m8146a(String str, String str2, DPUHardwareInfo dPUHardwareInfo) {
        DeviceProperties.m8157a(str, str2).m8159a(dPUHardwareInfo);
    }

    /* renamed from: b */
    public static DPUSoftInfo m8142b(String str, String str2) {
        return DeviceProperties.m8157a(str, str2).m8156b();
    }

    /* renamed from: a */
    public static void m8145a(String str, String str2, String str3) {
        DeviceProperties.m8157a(str, str2).m8155b(str3);
    }

    /* renamed from: d */
    public static String m8140d(String str, String str2) {
        return DeviceProperties.m8157a(str, str2).m8152e();
    }

    /* renamed from: a */
    public static String m8148a(String str) {
        return DeviceProperties.m8157a(str, null).m8153d();
    }

    /* renamed from: c */
    public static void m8141c(String str, String str2) {
        DeviceProperties m8157a = DeviceProperties.m8157a(str, null);
        m8157a.f10112a.setProperty("activateTime", str2);
        m8157a.m8154c();
    }

    /* renamed from: b */
    public static String m8143b(String str) {
        return DeviceProperties.m8157a(str, null).m8151f();
    }

    /* renamed from: e */
    public static void m8139e(String str, String str2) {
        DeviceProperties m8157a = DeviceProperties.m8157a(str, null);
        m8157a.f10112a.setProperty("blacklistState", str2);
        m8157a.m8154c();
    }
}
