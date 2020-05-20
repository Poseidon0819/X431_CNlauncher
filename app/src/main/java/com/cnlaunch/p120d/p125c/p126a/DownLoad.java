package com.cnlaunch.p120d.p125c.p126a;

/* renamed from: com.cnlaunch.d.c.a.c */
/* loaded from: classes.dex */
public final class DownLoad {

    /* renamed from: a */
    int f7046a;

    /* renamed from: b */
    int f7047b;

    /* renamed from: c */
    Object f7048c;

    /* renamed from: d */
    boolean f7049d;

    /* renamed from: e */
    OnDataListener f7050e;

    /* renamed from: f */
    private boolean f7051f;

    public DownLoad() {
    }

    public DownLoad(int i, boolean z, OnDataListener onDataListener) {
        this.f7046a = i;
        this.f7049d = z;
        this.f7050e = onDataListener;
    }

    public final String toString() {
        return "DownLoad [requestCode=" + this.f7046a + ", isRefresh=" + this.f7051f + ", state=" + this.f7047b + ", result=" + this.f7048c + ", listener=" + this.f7050e + "]";
    }
}
