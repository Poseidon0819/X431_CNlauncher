package com.itextpdf.p349a.p350a;

/* renamed from: com.itextpdf.a.a.m */
/* loaded from: classes.dex */
public abstract class QuadCurve2D implements Shape, Cloneable {
    /* renamed from: a */
    public static double m2731a(double[] dArr, int i) {
        return Line2D.m2736a(dArr[i + 0], dArr[i + 1], dArr[i + 4], dArr[i + 5], dArr[i + 2], dArr[i + 3]);
    }

    /* renamed from: a */
    public static void m2730a(double[] dArr, int i, double[] dArr2, int i2, double[] dArr3, int i3) {
        double d = dArr[i + 0];
        double d2 = dArr[i + 1];
        double d3 = dArr[i + 2];
        double d4 = dArr[i + 3];
        double d5 = dArr[i + 4];
        double d6 = dArr[i + 5];
        double d7 = (d + d3) / 2.0d;
        double d8 = (d2 + d4) / 2.0d;
        double d9 = (d3 + d5) / 2.0d;
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d7 + d9) / 2.0d;
        double d12 = (d8 + d10) / 2.0d;
        if (dArr2 != null) {
            dArr2[i2 + 0] = d;
            dArr2[i2 + 1] = d2;
            dArr2[i2 + 2] = d7;
            dArr2[i2 + 3] = d8;
            dArr2[i2 + 4] = d11;
            dArr2[i2 + 5] = d12;
        }
        if (dArr3 != null) {
            dArr3[i3 + 0] = d11;
            dArr3[i3 + 1] = d12;
            dArr3[i3 + 2] = d9;
            dArr3[i3 + 3] = d10;
            dArr3[i3 + 4] = d5;
            dArr3[i3 + 5] = d6;
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
