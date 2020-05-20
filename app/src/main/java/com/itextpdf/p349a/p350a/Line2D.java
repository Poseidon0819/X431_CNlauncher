package com.itextpdf.p349a.p350a;

/* renamed from: com.itextpdf.a.a.h */
/* loaded from: classes.dex */
public abstract class Line2D implements Shape, Cloneable {
    /* renamed from: a */
    public static double m2736a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8 = d3 - d;
        double d9 = d4 - d2;
        double d10 = d5 - d;
        double d11 = d6 - d2;
        if ((d10 * d8) + (d11 * d9) <= 0.0d) {
            d7 = (d10 * d10) + (d11 * d11);
        } else {
            double d12 = d8 - d10;
            double d13 = d9 - d11;
            if ((d12 * d8) + (d13 * d9) <= 0.0d) {
                d7 = (d12 * d12) + (d13 * d13);
            } else {
                double d14 = (d12 * d9) - (d13 * d8);
                d7 = (d14 * d14) / ((d8 * d8) + (d9 * d9));
            }
        }
        if (d7 < 0.0d) {
            return 0.0d;
        }
        return d7;
    }

    /* renamed from: a */
    public static boolean m2735a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d4 - d2;
        double d11 = d5 - d;
        double d12 = d6 - d2;
        double d13 = d7 - d;
        double d14 = d8 - d2;
        double d15 = (d9 * d12) - (d11 * d10);
        double d16 = (d9 * d14) - (d13 * d10);
        if (d15 != 0.0d || d16 != 0.0d) {
            double d17 = (d11 * d14) - (d13 * d12);
            return d15 * d16 <= 0.0d && d17 * ((d15 + d17) - d16) <= 0.0d;
        } else if (d9 == 0.0d) {
            if (d10 != 0.0d) {
                return d14 * d12 <= 0.0d || (d12 * d10 >= 0.0d && (d10 <= 0.0d ? d12 >= d10 || d14 >= d10 : d12 <= d10 || d14 <= d10));
            }
            return false;
        } else {
            if (d13 * d11 > 0.0d) {
                if (d11 * d9 >= 0.0d) {
                    if (d9 > 0.0d) {
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public abstract double m2737a();

    /* renamed from: b */
    public abstract double m2734b();

    /* renamed from: c */
    public abstract double m2733c();

    /* renamed from: d */
    public abstract double m2732d();

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
