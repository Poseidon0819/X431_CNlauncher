package com.cnlaunch.x431pro.module.golo.model;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.t */
/* loaded from: classes.dex */
public class VerificationInfo {

    /* renamed from: a */
    public Long f15544a;

    /* renamed from: b */
    public String f15545b;

    /* renamed from: c */
    public String f15546c;

    /* renamed from: d */
    public String f15547d;

    /* renamed from: e */
    public long f15548e;

    /* renamed from: f */
    public Integer f15549f;

    /* renamed from: g */
    public String f15550g;

    /* renamed from: h */
    public boolean f15551h;

    /* renamed from: i */
    public String f15552i;

    public VerificationInfo() {
        this.f15549f = 0;
        this.f15551h = false;
    }

    public VerificationInfo(Long l, String str, String str2, String str3, Long l2, Integer num, String str4, boolean z, String str5) {
        this.f15549f = 0;
        this.f15551h = false;
        this.f15544a = l;
        this.f15545b = str;
        this.f15546c = str2;
        this.f15547d = str3;
        this.f15548e = l2.longValue();
        this.f15549f = num;
        this.f15550g = str4;
        this.f15551h = z;
        this.f15552i = str5;
    }

    /* renamed from: a */
    public final void m5310a(Long l) {
        this.f15548e = l.longValue();
    }
}
