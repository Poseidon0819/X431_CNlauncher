package com.cnlaunch.physics.p197c;

import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.c.d */
/* loaded from: classes.dex */
public final class DPUSoftInfo {

    /* renamed from: a */
    public static String f9860a = "bootVersion";

    /* renamed from: b */
    public static String f9861b = "downloadSersion";

    /* renamed from: c */
    public static String f9862c = "diagnoseSoftVersion";

    /* renamed from: d */
    public static String f9863d = "productFunctionVersion";

    /* renamed from: e */
    public static String f9864e = "boot103Version";

    /* renamed from: f */
    public String f9865f;

    /* renamed from: g */
    public String f9866g;

    /* renamed from: h */
    public String f9867h;

    /* renamed from: i */
    public String f9868i;

    /* renamed from: j */
    public String f9869j;

    public DPUSoftInfo() {
    }

    public DPUSoftInfo(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() >= 5) {
            this.f9865f = arrayList.get(0);
            this.f9866g = arrayList.get(1);
            this.f9867h = arrayList.get(2);
            this.f9868i = arrayList.get(3);
            this.f9869j = arrayList.get(4);
        }
        if (arrayList != null && arrayList.size() == 4) {
            this.f9865f = arrayList.get(0);
            this.f9866g = arrayList.get(1);
            this.f9867h = arrayList.get(2);
            this.f9868i = arrayList.get(3);
            this.f9869j = "";
        }
        if (arrayList != null && arrayList.size() == 3) {
            this.f9865f = arrayList.get(0);
            this.f9866g = arrayList.get(1);
            this.f9867h = arrayList.get(2);
            this.f9868i = "";
            this.f9869j = "";
        }
        if (arrayList != null && arrayList.size() == 2) {
            this.f9865f = arrayList.get(0);
            this.f9866g = arrayList.get(1);
            this.f9867h = "";
            this.f9868i = "";
            this.f9869j = "";
        }
        if (arrayList == null || arrayList.size() != 1) {
            return;
        }
        this.f9865f = arrayList.get(0);
        this.f9866g = "";
        this.f9867h = "";
        this.f9868i = "";
        this.f9869j = "";
    }

    public final String toString() {
        return "DPUSoftInfo{bootVersion='" + this.f9865f + "', downloadSersion='" + this.f9866g + "', diagnoseSoftVersion='" + this.f9867h + "', productFunctionVersion='" + this.f9868i + "', boot103Version='" + this.f9869j + "'}";
    }
}
