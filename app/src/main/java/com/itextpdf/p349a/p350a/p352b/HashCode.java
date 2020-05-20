package com.itextpdf.p349a.p350a.p352b;

/* renamed from: com.itextpdf.a.a.b.a */
/* loaded from: classes.dex */
public final class HashCode {

    /* renamed from: a */
    private int f19499a = 1;

    public final int hashCode() {
        return this.f19499a;
    }

    /* renamed from: a */
    private static int m2742a(int i, double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    /* renamed from: a */
    public final HashCode m2743a(double d) {
        this.f19499a = m2742a(this.f19499a, d);
        return this;
    }
}
