package com.cnlaunch.gmap.p138a.p140b;

import java.util.LinkedHashMap;

/* compiled from: LruMemoryCache.java */
/* renamed from: com.cnlaunch.gmap.a.b.j */
/* loaded from: classes.dex */
public class C1508j<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f7439a;

    /* renamed from: b */
    private int f7440b;

    /* renamed from: c */
    private int f7441c;

    /* renamed from: d */
    private int f7442d;

    /* renamed from: e */
    private int f7443e;

    /* renamed from: f */
    private int f7444f;

    /* renamed from: g */
    private int f7445g;

    /* renamed from: a */
    protected int mo9359a(V v) {
        return 1;
    }

    public C1508j(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7441c = i;
        this.f7439a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: b */
    public final V m9363b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f7439a.get(k);
            if (v != null) {
                this.f7444f++;
                return v;
            }
            this.f7445g++;
            return null;
        }
    }

    /* renamed from: a */
    public final V m9364a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f7442d++;
            this.f7440b += m9362b(k, v);
            put = this.f7439a.put(k, v);
            if (put != null) {
                this.f7440b -= m9362b(k, put);
            }
        }
        m9365a(this.f7441c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m9365a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f7440b     // Catch: java.lang.Throwable -> L51
            if (r0 < 0) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.f7439a     // Catch: java.lang.Throwable -> L51
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L12
            int r0 = r3.f7440b     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L12
            goto L4f
        L12:
            int r0 = r3.f7440b     // Catch: java.lang.Throwable -> L51
            if (r0 <= r4) goto L4d
            java.util.LinkedHashMap<K, V> r0 = r3.f7439a     // Catch: java.lang.Throwable -> L51
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L1f
            goto L4d
        L1f:
            java.util.LinkedHashMap<K, V> r0 = r3.f7439a     // Catch: java.lang.Throwable -> L51
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L51
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L51
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L51
            java.util.LinkedHashMap<K, V> r2 = r3.f7439a     // Catch: java.lang.Throwable -> L51
            r2.remove(r1)     // Catch: java.lang.Throwable -> L51
            int r2 = r3.f7440b     // Catch: java.lang.Throwable -> L51
            int r0 = r3.m9362b(r1, r0)     // Catch: java.lang.Throwable -> L51
            int r2 = r2 - r0
            r3.f7440b = r2     // Catch: java.lang.Throwable -> L51
            int r0 = r3.f7443e     // Catch: java.lang.Throwable -> L51
            int r0 = r0 + 1
            r3.f7443e = r0     // Catch: java.lang.Throwable -> L51
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            goto L0
        L4d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            return
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            return
        L51:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.gmap.p138a.p140b.C1508j.m9365a(int):void");
    }

    /* renamed from: b */
    private int m9362b(K k, V v) {
        int mo9359a = mo9359a((C1508j<K, V>) v);
        if (mo9359a >= 0) {
            return mo9359a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        i = this.f7444f + this.f7445g;
        return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7441c), Integer.valueOf(this.f7444f), Integer.valueOf(this.f7445g), Integer.valueOf(i != 0 ? (this.f7444f * 100) / i : 0));
    }
}
