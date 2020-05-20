package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.p352b.Messages;
import java.util.NoSuchElementException;

/* renamed from: com.itextpdf.a.a.e */
/* loaded from: classes.dex */
public final class FlatteningPathIterator implements PathIterator {

    /* renamed from: a */
    int f19501a;

    /* renamed from: b */
    int f19502b;

    /* renamed from: c */
    int f19503c;

    /* renamed from: d */
    int f19504d;

    /* renamed from: e */
    int f19505e;

    /* renamed from: f */
    double[] f19506f;

    /* renamed from: g */
    boolean f19507g;

    /* renamed from: h */
    PathIterator f19508h;

    /* renamed from: i */
    double f19509i;

    /* renamed from: j */
    double f19510j;

    /* renamed from: k */
    double f19511k;

    /* renamed from: l */
    double f19512l;

    /* renamed from: m */
    double[] f19513m;

    public FlatteningPathIterator(PathIterator pathIterator, double d) {
        this(pathIterator, d, (byte) 0);
    }

    private FlatteningPathIterator(PathIterator pathIterator, double d, byte b) {
        this.f19507g = true;
        this.f19513m = new double[6];
        if (d < 0.0d) {
            throw new IllegalArgumentException(Messages.m2741a("awt.206"));
        }
        if (pathIterator == null) {
            throw new NullPointerException(Messages.m2741a("awt.208"));
        }
        this.f19508h = pathIterator;
        this.f19509i = d;
        this.f19510j = d * d;
        this.f19502b = 16;
        this.f19503c = Math.min(this.f19502b, 16);
        int i = this.f19503c;
        this.f19506f = new double[i];
        this.f19504d = i;
    }

    @Override // com.itextpdf.p349a.p350a.PathIterator
    /* renamed from: a */
    public final int mo2729a() {
        return this.f19508h.mo2729a();
    }

    @Override // com.itextpdf.p349a.p350a.PathIterator
    /* renamed from: b */
    public final boolean mo2726b() {
        return this.f19507g && this.f19508h.mo2726b();
    }

    /* renamed from: d */
    private void m2740d() {
        if (this.f19507g) {
            this.f19501a = this.f19508h.mo2728a(this.f19513m);
        }
        switch (this.f19501a) {
            case 0:
            case 1:
                double[] dArr = this.f19513m;
                this.f19511k = dArr[0];
                this.f19512l = dArr[1];
                return;
            case 2:
                if (this.f19507g) {
                    this.f19504d -= 6;
                    double[] dArr2 = this.f19506f;
                    int i = this.f19504d;
                    dArr2[i + 0] = this.f19511k;
                    dArr2[i + 1] = this.f19512l;
                    System.arraycopy(this.f19513m, 0, dArr2, i + 2, 4);
                    this.f19505e = 0;
                }
                while (this.f19505e < this.f19502b && QuadCurve2D.m2731a(this.f19506f, this.f19504d) >= this.f19510j) {
                    int i2 = this.f19504d;
                    if (i2 <= 4) {
                        int i3 = this.f19503c;
                        double[] dArr3 = new double[i3 + 16];
                        System.arraycopy(this.f19506f, i2, dArr3, i2 + 16, i3 - i2);
                        this.f19506f = dArr3;
                        this.f19503c += 16;
                        this.f19504d += 16;
                    }
                    double[] dArr4 = this.f19506f;
                    int i4 = this.f19504d;
                    QuadCurve2D.m2730a(dArr4, i4, dArr4, i4 - 4, dArr4, i4);
                    this.f19504d -= 4;
                    this.f19505e++;
                }
                this.f19504d += 4;
                double[] dArr5 = this.f19506f;
                int i5 = this.f19504d;
                this.f19511k = dArr5[i5];
                this.f19512l = dArr5[i5 + 1];
                this.f19507g = i5 == this.f19503c + (-2);
                if (this.f19507g) {
                    this.f19504d = this.f19503c;
                    this.f19501a = 1;
                    return;
                }
                return;
            case 3:
                if (this.f19507g) {
                    this.f19504d -= 8;
                    double[] dArr6 = this.f19506f;
                    int i6 = this.f19504d;
                    dArr6[i6 + 0] = this.f19511k;
                    dArr6[i6 + 1] = this.f19512l;
                    System.arraycopy(this.f19513m, 0, dArr6, i6 + 2, 6);
                    this.f19505e = 0;
                }
                while (this.f19505e < this.f19502b && CubicCurve2D.m2745a(this.f19506f, this.f19504d) >= this.f19510j) {
                    int i7 = this.f19504d;
                    if (i7 <= 6) {
                        int i8 = this.f19503c;
                        double[] dArr7 = new double[i8 + 16];
                        System.arraycopy(this.f19506f, i7, dArr7, i7 + 16, i8 - i7);
                        this.f19506f = dArr7;
                        this.f19503c += 16;
                        this.f19504d += 16;
                    }
                    double[] dArr8 = this.f19506f;
                    int i9 = this.f19504d;
                    CubicCurve2D.m2744a(dArr8, i9, dArr8, i9 - 6, dArr8, i9);
                    this.f19504d -= 6;
                    this.f19505e++;
                }
                this.f19504d += 6;
                double[] dArr9 = this.f19506f;
                int i10 = this.f19504d;
                this.f19511k = dArr9[i10];
                this.f19512l = dArr9[i10 + 1];
                this.f19507g = i10 == this.f19503c + (-2);
                if (this.f19507g) {
                    this.f19504d = this.f19503c;
                    this.f19501a = 1;
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.itextpdf.p349a.p350a.PathIterator
    /* renamed from: c */
    public final void mo2725c() {
        if (this.f19507g) {
            this.f19508h.mo2725c();
        }
    }

    @Override // com.itextpdf.p349a.p350a.PathIterator
    /* renamed from: a */
    public final int mo2727a(float[] fArr) {
        if (mo2726b()) {
            throw new NoSuchElementException(Messages.m2741a("awt.4Bx"));
        }
        m2740d();
        int i = this.f19501a;
        if (i != 4) {
            fArr[0] = (float) this.f19511k;
            fArr[1] = (float) this.f19512l;
            if (i != 0) {
                return 1;
            }
            return i;
        }
        return i;
    }

    @Override // com.itextpdf.p349a.p350a.PathIterator
    /* renamed from: a */
    public final int mo2728a(double[] dArr) {
        if (mo2726b()) {
            throw new NoSuchElementException(Messages.m2741a("awt.4B"));
        }
        m2740d();
        int i = this.f19501a;
        if (i != 4) {
            dArr[0] = this.f19511k;
            dArr[1] = this.f19512l;
            if (i != 0) {
                return 1;
            }
            return i;
        }
        return i;
    }
}
