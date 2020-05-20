package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;

/* renamed from: com.unionpay.mobile.android.hce.d */
/* loaded from: classes2.dex */
public final class C4154d {

    /* renamed from: a */
    private String f22166a;

    /* renamed from: b */
    private String f22167b = null;

    /* renamed from: c */
    private String f22168c = null;

    /* renamed from: d */
    private boolean f22169d = false;

    /* renamed from: e */
    private boolean f22170e = false;

    /* renamed from: f */
    private ServiceConnection f22171f = null;

    public C4154d(String str) {
        this.f22166a = str;
    }

    /* renamed from: a */
    public final void m1600a(ServiceConnection serviceConnection) {
        this.f22171f = serviceConnection;
    }

    /* renamed from: a */
    public final void m1599a(String str) {
        this.f22167b = str;
    }

    /* renamed from: a */
    public final boolean m1601a() {
        return this.f22169d;
    }

    /* renamed from: b */
    public final void m1597b(String str) {
        this.f22168c = str;
    }

    /* renamed from: b */
    public final boolean m1598b() {
        return this.f22170e;
    }

    /* renamed from: c */
    public final String m1596c() {
        return this.f22167b;
    }

    /* renamed from: d */
    public final ServiceConnection m1595d() {
        return this.f22171f;
    }

    /* renamed from: e */
    public final void m1594e() {
        this.f22169d = true;
    }

    /* renamed from: f */
    public final void m1593f() {
        this.f22170e = true;
    }
}
