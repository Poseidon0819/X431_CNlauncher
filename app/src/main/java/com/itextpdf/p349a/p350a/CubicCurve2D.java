package com.itextpdf.p349a.p350a;

/* renamed from: com.itextpdf.a.a.b */
/* loaded from: classes.dex */
public abstract class CubicCurve2D implements Shape, Cloneable {
    /* renamed from: a */
    public static double m2745a(double[] dArr, int i) {
        double d = dArr[i + 0];
        double d2 = dArr[i + 1];
        double d3 = dArr[i + 2];
        double d4 = dArr[i + 3];
        double d5 = dArr[i + 4];
        double d6 = dArr[i + 5];
        double d7 = dArr[i + 6];
        double d8 = dArr[i + 7];
        return Math.max(Line2D.m2736a(d, d2, d7, d8, d3, d4), Line2D.m2736a(d, d2, d7, d8, d5, d6));
    }

    /* renamed from: a */
    public static void m2744a(double[] dArr, int i, double[] dArr2, int i2, double[] dArr3, int i3) {
        double d = dArr[i + 0];
        double d2 = dArr[i + 1];
        double d3 = dArr[i + 2];
        double d4 = dArr[i + 3];
        double d5 = dArr[i + 4];
        double d6 = dArr[i + 5];
        double d7 = dArr[i + 6];
        double d8 = dArr[i + 7];
        double d9 = (d3 + d5) / 2.0d;
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d3 + d) / 2.0d;
        double d12 = (d4 + d2) / 2.0d;
        double d13 = (d5 + d7) / 2.0d;
        double d14 = (d6 + d8) / 2.0d;
        double d15 = (d11 + d9) / 2.0d;
        double d16 = (d12 + d10) / 2.0d;
        double d17 = (d13 + d9) / 2.0d;
        double d18 = (d14 + d10) / 2.0d;
        double d19 = (d15 + d17) / 2.0d;
        double d20 = (d16 + d18) / 2.0d;
        if (dArr2 != null) {
            dArr2[i2 + 0] = d;
            dArr2[i2 + 1] = d2;
            dArr2[i2 + 2] = d11;
            dArr2[i2 + 3] = d12;
            dArr2[i2 + 4] = d15;
            dArr2[i2 + 5] = d16;
            dArr2[i2 + 6] = d19;
            dArr2[i2 + 7] = d20;
        }
        if (dArr3 != null) {
            dArr3[i3 + 0] = d19;
            dArr3[i3 + 1] = d20;
            dArr3[i3 + 2] = d17;
            dArr3[i3 + 3] = d18;
            dArr3[i3 + 4] = d13;
            dArr3[i3 + 5] = d14;
            dArr3[i3 + 6] = d7;
            dArr3[i3 + 7] = d8;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
