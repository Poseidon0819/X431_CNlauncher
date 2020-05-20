package com.unionpay.mobile.android.model;

/* renamed from: com.unionpay.mobile.android.model.a */
/* loaded from: classes2.dex */
public final class C4172a implements InterfaceC4174c {

    /* renamed from: a */
    private int f22361a;

    /* renamed from: b */
    private int f22362b;

    /* renamed from: c */
    private String f22363c;

    /* renamed from: d */
    private String f22364d;

    /* renamed from: e */
    private String f22365e;

    /* renamed from: f */
    private String f22366f;

    public C4172a() {
        this.f22361a = 2;
        this.f22362b = 0;
        this.f22363c = null;
        this.f22364d = null;
        this.f22365e = null;
        this.f22363c = null;
        this.f22364d = null;
        this.f22365e = null;
    }

    public C4172a(int i, String str, String str2, String str3, int i2) {
        this.f22361a = 2;
        this.f22362b = 0;
        this.f22363c = null;
        this.f22364d = null;
        this.f22365e = null;
        this.f22362b = i;
        this.f22361a = i2;
        this.f22363c = str;
        this.f22364d = str2;
        this.f22365e = str3;
    }

    private C4172a(String str, String str2, String str3) {
        this(0, str, str2, str3, 2);
    }

    public C4172a(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: a */
    public final String mo1544a() {
        return this.f22363c;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: a */
    public final void mo1543a(String str) {
        this.f22366f = str;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: b */
    public final String mo1542b() {
        return this.f22365e;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: c */
    public final int mo1541c() {
        return this.f22362b;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: d */
    public final int mo1540d() {
        return this.f22361a;
    }

    @Override // com.unionpay.mobile.android.model.InterfaceC4174c
    /* renamed from: e */
    public final String mo1539e() {
        return this.f22362b == 0 ? this.f22364d : String.format("<font color=\"#FF0000\">%s</font>", this.f22366f);
    }

    public final String toString() {
        return this.f22363c + "," + this.f22364d + "," + this.f22365e;
    }
}
