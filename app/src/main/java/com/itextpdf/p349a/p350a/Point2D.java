package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.p352b.HashCode;

/* renamed from: com.itextpdf.a.a.l */
/* loaded from: classes.dex */
public abstract class Point2D implements Cloneable {
    public static double distanceSq(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        return (d5 * d5) + (d6 * d6);
    }

    public abstract double getX();

    public abstract double getY();

    public abstract void setLocation(double d, double d2);

    /* compiled from: Point2D.java */
    /* renamed from: com.itextpdf.a.a.l$b */
    /* loaded from: classes.dex */
    public static class C3607b extends Point2D {

        /* renamed from: a */
        public float f19529a;

        /* renamed from: b */
        public float f19530b;

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final double getX() {
            return this.f19529a;
        }

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final double getY() {
            return this.f19530b;
        }

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final void setLocation(double d, double d2) {
            this.f19529a = (float) d;
            this.f19530b = (float) d2;
        }

        public final String toString() {
            return getClass().getName() + "[x=" + this.f19529a + ",y=" + this.f19530b + "]";
        }
    }

    /* compiled from: Point2D.java */
    /* renamed from: com.itextpdf.a.a.l$a */
    /* loaded from: classes.dex */
    public static class C3606a extends Point2D {

        /* renamed from: a */
        public double f19527a;

        /* renamed from: b */
        public double f19528b;

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final double getX() {
            return this.f19527a;
        }

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final double getY() {
            return this.f19528b;
        }

        @Override // com.itextpdf.p349a.p350a.Point2D
        public final void setLocation(double d, double d2) {
            this.f19527a = d;
            this.f19528b = d2;
        }

        public final String toString() {
            return getClass().getName() + "[x=" + this.f19527a + ",y=" + this.f19528b + "]";
        }
    }

    public void setLocation(Point2D point2D) {
        setLocation(point2D.getX(), point2D.getY());
    }

    public double distanceSq(double d, double d2) {
        return distanceSq(getX(), getY(), d, d2);
    }

    public double distanceSq(Point2D point2D) {
        return distanceSq(getX(), getY(), point2D.getX(), point2D.getY());
    }

    public static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt(distanceSq(d, d2, d3, d4));
    }

    public double distance(double d, double d2) {
        return Math.sqrt(distanceSq(d, d2));
    }

    public double distance(Point2D point2D) {
        return Math.sqrt(distanceSq(point2D));
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.m2743a(getX());
        hashCode.m2743a(getY());
        return hashCode.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Point2D) {
            Point2D point2D = (Point2D) obj;
            return getX() == point2D.getX() && getY() == point2D.getY();
        }
        return false;
    }
}
