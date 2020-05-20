package com.baidu.mapsdkplatform.comapi.synchronization.data;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.b */
/* loaded from: classes.dex */
public final class C1269b {

    /* renamed from: a */
    private String f6246a;

    /* renamed from: b */
    private String f6247b;

    /* renamed from: c */
    private String f6248c;

    /* renamed from: d */
    private EnumC1271b f6249d;

    /* renamed from: e */
    private int f6250e;

    /* renamed from: f */
    private int f6251f;

    /* renamed from: g */
    private EnumC1270a f6252g;

    /* renamed from: h */
    private String f6253h;

    /* renamed from: i */
    private String f6254i;

    /* renamed from: j */
    private int f6255j;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1270a {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.b$b */
    /* loaded from: classes.dex */
    public enum EnumC1271b {
        DRIVING,
        RIDING
    }

    public C1269b() {
        this.f6249d = EnumC1271b.DRIVING;
        this.f6251f = 15;
        this.f6252g = EnumC1270a.BD09LL;
        this.f6249d = EnumC1271b.DRIVING;
        this.f6252g = EnumC1270a.BD09LL;
        this.f6251f = 15;
    }

    /* renamed from: a */
    public final String m10379a() {
        return this.f6246a;
    }

    /* renamed from: a */
    public final void m10378a(int i) {
        this.f6250e = i;
    }

    /* renamed from: a */
    public final void m10377a(String str) {
        this.f6246a = str;
    }

    /* renamed from: b */
    public final String m10376b() {
        return this.f6247b;
    }

    /* renamed from: b */
    public final void m10375b(String str) {
        this.f6247b = str;
    }

    /* renamed from: c */
    public final String m10374c() {
        return this.f6248c;
    }

    /* renamed from: c */
    public final void m10373c(String str) {
        this.f6248c = str;
    }

    /* renamed from: d */
    public final String m10372d() {
        return this.f6253h;
    }

    /* renamed from: d */
    public final void m10371d(String str) {
        this.f6253h = str;
    }

    /* renamed from: e */
    public final String m10370e() {
        return this.f6254i;
    }

    /* renamed from: e */
    public final void m10369e(String str) {
        this.f6254i = str;
    }

    /* renamed from: f */
    public final EnumC1270a m10368f() {
        return this.f6252g;
    }

    /* renamed from: g */
    public final EnumC1271b m10367g() {
        return this.f6249d;
    }

    /* renamed from: h */
    public final int m10366h() {
        return this.f6250e;
    }

    /* renamed from: i */
    public final int m10365i() {
        return this.f6251f;
    }

    /* renamed from: j */
    public final int m10364j() {
        return this.f6255j;
    }
}
