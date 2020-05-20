package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.C1091b.AbstractC1092a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.baidu.mapapi.map.b */
/* loaded from: classes.dex */
class C1091b<T extends AbstractC1092a> {

    /* renamed from: a */
    private final C1090a f5396a;

    /* renamed from: b */
    private final int f5397b;

    /* renamed from: c */
    private List<T> f5398c;

    /* renamed from: d */
    private List<C1091b<T>> f5399d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapapi.map.b$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1092a {
        /* renamed from: a */
        abstract Point mo11072a();
    }

    private C1091b(double d, double d2, double d3, double d4, int i) {
        this(new C1090a(d, d2, d3, d4), i);
    }

    public C1091b(C1090a c1090a) {
        this(c1090a, 0);
    }

    private C1091b(C1090a c1090a, int i) {
        this.f5399d = null;
        this.f5396a = c1090a;
        this.f5397b = i;
    }

    /* renamed from: a */
    private void m11077a() {
        this.f5399d = new ArrayList(4);
        this.f5399d.add(new C1091b<>(this.f5396a.f5390a, this.f5396a.f5394e, this.f5396a.f5391b, this.f5396a.f5395f, this.f5397b + 1));
        this.f5399d.add(new C1091b<>(this.f5396a.f5394e, this.f5396a.f5392c, this.f5396a.f5391b, this.f5396a.f5395f, this.f5397b + 1));
        this.f5399d.add(new C1091b<>(this.f5396a.f5390a, this.f5396a.f5394e, this.f5396a.f5395f, this.f5396a.f5393d, this.f5397b + 1));
        this.f5399d.add(new C1091b<>(this.f5396a.f5394e, this.f5396a.f5392c, this.f5396a.f5395f, this.f5396a.f5393d, this.f5397b + 1));
        List<T> list = this.f5398c;
        this.f5398c = null;
        for (T t : list) {
            m11076a(t.mo11072a().x, t.mo11072a().y, t);
        }
    }

    /* renamed from: a */
    private void m11076a(double d, double d2, T t) {
        List<C1091b<T>> list;
        int i;
        C1091b<T> c1091b = this;
        while (c1091b.f5399d != null) {
            if (d2 < c1091b.f5396a.f5395f) {
                if (d < c1091b.f5396a.f5394e) {
                    list = c1091b.f5399d;
                    i = 0;
                } else {
                    list = c1091b.f5399d;
                    i = 1;
                }
            } else if (d < c1091b.f5396a.f5394e) {
                list = c1091b.f5399d;
                i = 2;
            } else {
                list = c1091b.f5399d;
                i = 3;
            }
            c1091b = list.get(i);
        }
        if (c1091b.f5398c == null) {
            c1091b.f5398c = new ArrayList();
        }
        c1091b.f5398c.add(t);
        if (c1091b.f5398c.size() <= 40 || c1091b.f5397b >= 40) {
            return;
        }
        c1091b.m11077a();
    }

    /* renamed from: a */
    private void m11074a(C1090a c1090a, Collection<T> collection) {
        if (this.f5396a.m11079a(c1090a)) {
            List<C1091b<T>> list = this.f5399d;
            if (list != null) {
                for (C1091b<T> c1091b : list) {
                    c1091b.m11074a(c1090a, collection);
                }
            } else if (this.f5398c != null) {
                if (c1090a.m11078b(this.f5396a)) {
                    collection.addAll(this.f5398c);
                    return;
                }
                for (T t : this.f5398c) {
                    if (c1090a.m11080a(t.mo11072a())) {
                        collection.add(t);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public Collection<T> m11075a(C1090a c1090a) {
        ArrayList arrayList = new ArrayList();
        m11074a(c1090a, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public void m11073a(T t) {
        Point mo11072a = t.mo11072a();
        if (this.f5396a.m11082a(mo11072a.x, mo11072a.y)) {
            m11076a(mo11072a.x, mo11072a.y, t);
        }
    }
}
