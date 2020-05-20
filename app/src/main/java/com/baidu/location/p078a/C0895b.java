package com.baidu.location.p078a;

import android.os.Bundle;

/* renamed from: com.baidu.location.a.b */
/* loaded from: classes.dex */
public class C0895b {

    /* renamed from: a */
    private static Object f3877a = new Object();

    /* renamed from: b */
    private static C0895b f3878b = null;

    /* renamed from: c */
    private int f3879c = -1;

    /* renamed from: a */
    public static C0895b m12229a() {
        C0895b c0895b;
        synchronized (f3877a) {
            if (f3878b == null) {
                f3878b = new C0895b();
            }
            c0895b = f3878b;
        }
        return c0895b;
    }

    /* renamed from: a */
    public void m12228a(int i, int i2, String str) {
        if (i2 != this.f3879c) {
            this.f3879c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            C0892a.m12261a().m12260a(bundle, 303);
        }
    }

    /* renamed from: b */
    public void m12227b() {
        this.f3879c = -1;
    }
}
