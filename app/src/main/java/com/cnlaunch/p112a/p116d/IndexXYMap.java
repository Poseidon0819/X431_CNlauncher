package com.cnlaunch.p112a.p116d;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.a.d.a */
/* loaded from: classes.dex */
public final class IndexXYMap<K, V> {

    /* renamed from: a */
    public final List<K> f6726a = new ArrayList();

    /* renamed from: b */
    public final List<V> f6727b = new ArrayList();

    /* renamed from: c */
    private double f6728c = 0.0d;

    /* renamed from: a */
    public final int m9653a() {
        return this.f6726a.size();
    }

    /* renamed from: a */
    public final V m9651a(K k, V v) {
        this.f6726a.add(k);
        this.f6727b.add(v);
        return v;
    }

    /* renamed from: b */
    public final void m9650b() {
        this.f6726a.clear();
        this.f6727b.clear();
    }

    /* renamed from: a */
    public final K m9652a(int i) {
        return this.f6726a.get(i);
    }

    /* renamed from: b */
    public final V m9649b(int i) {
        return this.f6727b.get(i);
    }

    /* renamed from: c */
    public final XYEntry<K, V> m9648c(int i) {
        return new XYEntry<>(this.f6726a.remove(i), this.f6727b.remove(i));
    }
}
