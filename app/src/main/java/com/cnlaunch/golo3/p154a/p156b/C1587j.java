package com.cnlaunch.golo3.p154a.p156b;

import java.util.LinkedHashMap;

/* compiled from: LruMemoryCache.java */
/* renamed from: com.cnlaunch.golo3.a.b.j */
/* loaded from: classes.dex */
public class C1587j<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f7781a;

    /* renamed from: b */
    private int f7782b;

    /* renamed from: c */
    private int f7783c;

    /* renamed from: d */
    private int f7784d;

    /* renamed from: e */
    private int f7785e;

    /* renamed from: f */
    private int f7786f;

    /* renamed from: g */
    private int f7787g;

    /* renamed from: a */
    protected int mo9192a(V v) {
        return 1;
    }

    public C1587j(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7783c = i;
        this.f7781a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: b */
    public final V m9199b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f7781a.get(k);
            if (v != null) {
                this.f7786f++;
                return v;
            }
            this.f7787g++;
            return null;
        }
    }

    /* renamed from: a */
    public final V m9200a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f7784d++;
            this.f7782b += m9198b(k, v);
            put = this.f7781a.put(k, v);
            if (put != null) {
                this.f7782b -= m9198b(k, put);
            }
        }
        m9201a(this.f7783c);
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
    private void m9201a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f7782b     // Catch: java.lang.Throwable -> L51
            if (r0 < 0) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.f7781a     // Catch: java.lang.Throwable -> L51
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L12
            int r0 = r3.f7782b     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L12
            goto L4f
        L12:
            int r0 = r3.f7782b     // Catch: java.lang.Throwable -> L51
            if (r0 <= r4) goto L4d
            java.util.LinkedHashMap<K, V> r0 = r3.f7781a     // Catch: java.lang.Throwable -> L51
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L1f
            goto L4d
        L1f:
            java.util.LinkedHashMap<K, V> r0 = r3.f7781a     // Catch: java.lang.Throwable -> L51
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L51
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L51
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L51
            java.util.LinkedHashMap<K, V> r2 = r3.f7781a     // Catch: java.lang.Throwable -> L51
            r2.remove(r1)     // Catch: java.lang.Throwable -> L51
            int r2 = r3.f7782b     // Catch: java.lang.Throwable -> L51
            int r0 = r3.m9198b(r1, r0)     // Catch: java.lang.Throwable -> L51
            int r2 = r2 - r0
            r3.f7782b = r2     // Catch: java.lang.Throwable -> L51
            int r0 = r3.f7785e     // Catch: java.lang.Throwable -> L51
            int r0 = r0 + 1
            r3.f7785e = r0     // Catch: java.lang.Throwable -> L51
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
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.p154a.p156b.C1587j.m9201a(int):void");
    }

    /* renamed from: c */
    public final V m9197c(K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f7781a.remove(k);
            if (remove != null) {
                this.f7782b -= m9198b(k, remove);
            }
        }
        return remove;
    }

    /* renamed from: b */
    private int m9198b(K k, V v) {
        int mo9192a = mo9192a((C1587j<K, V>) v);
        if (mo9192a >= 0) {
            return mo9192a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* renamed from: a */
    public final void m9202a() {
        m9201a(-1);
    }

    public final synchronized String toString() {
        int i;
        i = this.f7786f + this.f7787g;
        return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7783c), Integer.valueOf(this.f7786f), Integer.valueOf(this.f7787g), Integer.valueOf(i != 0 ? (this.f7786f * 100) / i : 0));
    }
}
