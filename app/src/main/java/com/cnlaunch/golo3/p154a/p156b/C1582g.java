package com.cnlaunch.golo3.p154a.p156b;

import java.util.ArrayList;

/* compiled from: BytesBufferPool.java */
/* renamed from: com.cnlaunch.golo3.a.b.g */
/* loaded from: classes.dex */
public final class C1582g {

    /* renamed from: c */
    private final ArrayList<C1583a> f7751c = new ArrayList<>(4);

    /* renamed from: a */
    private final int f7749a = 4;

    /* renamed from: b */
    private final int f7750b = 204800;

    /* compiled from: BytesBufferPool.java */
    /* renamed from: com.cnlaunch.golo3.a.b.g$a */
    /* loaded from: classes.dex */
    public static class C1583a {

        /* renamed from: a */
        public byte[] f7752a;

        /* renamed from: b */
        public int f7753b;

        /* renamed from: c */
        public int f7754c;

        /* synthetic */ C1583a(int i, byte b) {
            this(i);
        }

        private C1583a(int i) {
            this.f7752a = new byte[i];
        }
    }

    /* renamed from: a */
    public final synchronized C1583a m9222a() {
        int size = this.f7751c.size();
        if (size > 0) {
            return this.f7751c.remove(size - 1);
        }
        return new C1583a(this.f7750b, (byte) 0);
    }

    /* renamed from: a */
    public final synchronized void m9221a(C1583a c1583a) {
        if (c1583a.f7752a.length != this.f7750b) {
            return;
        }
        if (this.f7751c.size() < this.f7749a) {
            c1583a.f7753b = 0;
            c1583a.f7754c = 0;
            this.f7751c.add(c1583a);
        }
    }
}
