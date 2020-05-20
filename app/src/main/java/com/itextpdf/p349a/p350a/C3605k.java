package com.itextpdf.p349a.p350a;

import java.io.Serializable;

/* compiled from: Point.java */
/* renamed from: com.itextpdf.a.a.k */
/* loaded from: classes.dex */
public final class C3605k extends Point2D implements Serializable {
    private static final long serialVersionUID = -5276940640259749850L;

    /* renamed from: x */
    public double f19525x;

    /* renamed from: y */
    public double f19526y;

    public C3605k() {
        setLocation(0, 0);
    }

    public C3605k(int i, int i2) {
        setLocation(i, i2);
    }

    public C3605k(double d, double d2) {
        setLocation(d, d2);
    }

    public C3605k(C3605k c3605k) {
        setLocation(c3605k.f19525x, c3605k.f19526y);
    }

    @Override // com.itextpdf.p349a.p350a.Point2D
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3605k) {
            C3605k c3605k = (C3605k) obj;
            return this.f19525x == c3605k.f19525x && this.f19526y == c3605k.f19526y;
        }
        return false;
    }

    public final String toString() {
        return getClass().getName() + "[x=" + this.f19525x + ",y=" + this.f19526y + "]";
    }

    @Override // com.itextpdf.p349a.p350a.Point2D
    public final double getX() {
        return this.f19525x;
    }

    @Override // com.itextpdf.p349a.p350a.Point2D
    public final double getY() {
        return this.f19526y;
    }

    public final C3605k getLocation() {
        return new C3605k(this.f19525x, this.f19526y);
    }

    public final void setLocation(C3605k c3605k) {
        setLocation(c3605k.f19525x, c3605k.f19526y);
    }

    public final void setLocation(int i, int i2) {
        setLocation(i, i2);
    }

    @Override // com.itextpdf.p349a.p350a.Point2D
    public final void setLocation(double d, double d2) {
        this.f19525x = d;
        this.f19526y = d2;
    }

    public final void move(int i, int i2) {
        move(i, i2);
    }

    public final void move(double d, double d2) {
        setLocation(d, d2);
    }

    public final void translate(int i, int i2) {
        translate(this.f19525x, this.f19526y);
    }

    public final void translate(double d, double d2) {
        this.f19525x += d;
        this.f19526y += d2;
    }
}
