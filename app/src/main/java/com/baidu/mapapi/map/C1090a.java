package com.baidu.mapapi.map;

import android.graphics.Point;

/* renamed from: com.baidu.mapapi.map.a */
/* loaded from: classes.dex */
class C1090a {

    /* renamed from: a */
    public final double f5390a;

    /* renamed from: b */
    public final double f5391b;

    /* renamed from: c */
    public final double f5392c;

    /* renamed from: d */
    public final double f5393d;

    /* renamed from: e */
    public final double f5394e;

    /* renamed from: f */
    public final double f5395f;

    public C1090a(double d, double d2, double d3, double d4) {
        this.f5390a = d;
        this.f5391b = d3;
        this.f5392c = d2;
        this.f5393d = d4;
        this.f5394e = (d + d2) / 2.0d;
        this.f5395f = (d3 + d4) / 2.0d;
    }

    /* renamed from: a */
    public boolean m11082a(double d, double d2) {
        return this.f5390a <= d && d <= this.f5392c && this.f5391b <= d2 && d2 <= this.f5393d;
    }

    /* renamed from: a */
    public boolean m11081a(double d, double d2, double d3, double d4) {
        return d < this.f5392c && this.f5390a < d2 && d3 < this.f5393d && this.f5391b < d4;
    }

    /* renamed from: a */
    public boolean m11080a(Point point) {
        return m11082a(point.x, point.y);
    }

    /* renamed from: a */
    public boolean m11079a(C1090a c1090a) {
        return m11081a(c1090a.f5390a, c1090a.f5392c, c1090a.f5391b, c1090a.f5393d);
    }

    /* renamed from: b */
    public boolean m11078b(C1090a c1090a) {
        return c1090a.f5390a >= this.f5390a && c1090a.f5392c <= this.f5392c && c1090a.f5391b >= this.f5391b && c1090a.f5393d <= this.f5393d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f5390a);
        sb.append(" minY: " + this.f5391b);
        sb.append(" maxX: " + this.f5392c);
        sb.append(" maxY: " + this.f5393d);
        sb.append(" midX: " + this.f5394e);
        sb.append(" midY: " + this.f5395f);
        return sb.toString();
    }
}
