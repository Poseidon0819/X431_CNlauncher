package com.cnlaunch.physics.p197c;

/* renamed from: com.cnlaunch.physics.c.c */
/* loaded from: classes.dex */
public final class DPUHardwareInfo {

    /* renamed from: a */
    public static String f9850a = "id";

    /* renamed from: b */
    public static String f9851b = "serialNo";

    /* renamed from: c */
    public static String f9852c = "version";

    /* renamed from: d */
    public static String f9853d = "date";

    /* renamed from: e */
    public static String f9854e = "deviceType";

    /* renamed from: f */
    public String f9855f;

    /* renamed from: g */
    public String f9856g;

    /* renamed from: h */
    public String f9857h;

    /* renamed from: i */
    public String f9858i;

    /* renamed from: j */
    public String f9859j;

    public DPUHardwareInfo() {
        this.f9855f = "";
        this.f9856g = "";
        this.f9857h = "";
        this.f9858i = "";
        this.f9859j = "";
    }

    public DPUHardwareInfo(String[] strArr) {
        if (strArr != null && strArr.length >= 5) {
            this.f9855f = strArr[0];
            this.f9856g = strArr[1];
            this.f9857h = strArr[2];
            this.f9858i = strArr[3];
            this.f9859j = strArr[4];
            return;
        }
        this.f9855f = "";
        this.f9856g = "";
        this.f9857h = "";
        this.f9858i = "";
        this.f9859j = "";
    }

    public final String toString() {
        return "DPUHardwareInfo [id=" + this.f9855f + ", serialNo=" + this.f9856g + ", version=" + this.f9857h + ", date=" + this.f9858i + ", deviceType=" + this.f9859j + "]";
    }
}
