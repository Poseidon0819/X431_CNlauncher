package com.cnlaunch.gmap.p138a.p140b;

import java.util.ArrayList;

/* renamed from: com.cnlaunch.gmap.a.b.g */
/* loaded from: classes.dex */
public final class BytesBufferPool {

    /* renamed from: c */
    private final ArrayList<C1505a> f7409c = new ArrayList<>(4);

    /* renamed from: a */
    private final int f7407a = 4;

    /* renamed from: b */
    private final int f7408b = 204800;

    /* compiled from: BytesBufferPool.java */
    /* renamed from: com.cnlaunch.gmap.a.b.g$a */
    /* loaded from: classes.dex */
    public static class C1505a {

        /* renamed from: a */
        public byte[] f7410a;

        /* renamed from: b */
        public int f7411b;

        /* renamed from: c */
        public int f7412c;

        /* synthetic */ C1505a(int i, byte b) {
            this(i);
        }

        private C1505a(int i) {
            this.f7410a = new byte[i];
        }
    }

    /* renamed from: a */
    public final synchronized C1505a m9383a() {
        int size = this.f7409c.size();
        if (size > 0) {
            return this.f7409c.remove(size - 1);
        }
        return new C1505a(this.f7408b, (byte) 0);
    }

    /* renamed from: a */
    public final synchronized void m9382a(C1505a c1505a) {
        if (c1505a.f7410a.length != this.f7408b) {
            return;
        }
        if (this.f7409c.size() < this.f7407a) {
            c1505a.f7411b = 0;
            c1505a.f7412c = 0;
            this.f7409c.add(c1505a);
        }
    }
}
