package com.itextpdf.p349a.p350a;

import com.itextpdf.p349a.p350a.Rectangle2D;
import com.itextpdf.p349a.p350a.p351a.Crossing;
import com.itextpdf.p349a.p350a.p352b.Messages;
import com.itextpdf.text.pdf.ColumnText;
import java.util.NoSuchElementException;

/* renamed from: com.itextpdf.a.a.f */
/* loaded from: classes.dex */
public final class GeneralPath implements Shape, Cloneable {

    /* renamed from: f */
    static int[] f19514f = {2, 2, 4, 6, 0};

    /* renamed from: a */
    byte[] f19515a;

    /* renamed from: b */
    float[] f19516b;

    /* renamed from: c */
    int f19517c;

    /* renamed from: d */
    int f19518d;

    /* renamed from: e */
    int f19519e;

    /* compiled from: GeneralPath.java */
    /* renamed from: com.itextpdf.a.a.f$a */
    /* loaded from: classes.dex */
    class C3604a implements PathIterator {

        /* renamed from: a */
        int f19520a;

        /* renamed from: b */
        int f19521b;

        /* renamed from: c */
        GeneralPath f19522c;

        /* renamed from: d */
        AffineTransform f19523d;

        C3604a(GeneralPath generalPath, AffineTransform affineTransform) {
            this.f19522c = generalPath;
            this.f19523d = affineTransform;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        public final int mo2729a() {
            return this.f19522c.f19519e;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: b */
        public final boolean mo2726b() {
            return this.f19520a >= this.f19522c.f19517c;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: c */
        public final void mo2725c() {
            this.f19520a++;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        public final int mo2728a(double[] dArr) {
            if (mo2726b()) {
                throw new NoSuchElementException(Messages.m2741a("awt.4B"));
            }
            byte b = this.f19522c.f19515a[this.f19520a];
            int i = GeneralPath.f19514f[b];
            for (int i2 = 0; i2 < i; i2++) {
                dArr[i2] = this.f19522c.f19516b[this.f19521b + i2];
            }
            AffineTransform affineTransform = this.f19523d;
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, dArr, 0, i / 2);
            }
            this.f19521b += i;
            return b;
        }

        @Override // com.itextpdf.p349a.p350a.PathIterator
        /* renamed from: a */
        public final int mo2727a(float[] fArr) {
            if (mo2726b()) {
                throw new NoSuchElementException(Messages.m2741a("awt.4B"));
            }
            byte b = this.f19522c.f19515a[this.f19520a];
            int i = GeneralPath.f19514f[b];
            System.arraycopy(this.f19522c.f19516b, this.f19521b, fArr, 0, i);
            AffineTransform affineTransform = this.f19523d;
            if (affineTransform != null) {
                affineTransform.transform(fArr, 0, fArr, 0, i / 2);
            }
            this.f19521b += i;
            return b;
        }
    }

    public GeneralPath() {
        this(1, (byte) 0);
    }

    public GeneralPath(int i) {
        this(i, (byte) 0);
    }

    private GeneralPath(int i, byte b) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(Messages.m2741a("awt.209"));
        }
        this.f19519e = i;
        this.f19515a = new byte[10];
        this.f19516b = new float[20];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2738a(int i, boolean z) {
        if (z && this.f19517c == 0) {
            throw new IllegalPathStateException(Messages.m2741a("awt.20A"));
        }
        int i2 = this.f19517c;
        byte[] bArr = this.f19515a;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[i2 + 10];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.f19515a = bArr2;
        }
        int i3 = this.f19518d;
        if (i3 + i > this.f19516b.length) {
            float[] fArr = new float[i3 + Math.max(20, i)];
            System.arraycopy(this.f19516b, 0, fArr, 0, this.f19518d);
            this.f19516b = fArr;
        }
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public final Rectangle2D getBounds2D() {
        float f;
        float f2;
        float f3;
        float f4;
        int i = this.f19518d;
        if (i == 0) {
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            int i2 = i - 1;
            float[] fArr = this.f19516b;
            int i3 = i2 - 1;
            int i4 = i3 - 1;
            f = fArr[i2];
            f2 = fArr[i3];
            f3 = f2;
            f4 = f;
            while (i4 > 0) {
                float[] fArr2 = this.f19516b;
                int i5 = i4 - 1;
                float f5 = fArr2[i4];
                int i6 = i5 - 1;
                float f6 = fArr2[i5];
                if (f6 < f3) {
                    f3 = f6;
                } else if (f6 > f2) {
                    f2 = f6;
                }
                if (f5 < f4) {
                    f4 = f5;
                    i4 = i6;
                } else {
                    if (f5 > f) {
                        f = f5;
                    }
                    i4 = i6;
                }
            }
        }
        return new Rectangle2D.C3609b(f3, f4, f2 - f3, f - f4);
    }

    /* renamed from: a */
    private boolean m2739a(int i) {
        return this.f19519e == 1 ? i != 0 : (i & 1) != 0;
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public final boolean contains(double d, double d2, double d3, double d4) {
        int m2756a = Crossing.m2756a(this, d, d2, d3, d4);
        return m2756a != 255 && m2739a(m2756a);
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public final boolean intersects(double d, double d2, double d3, double d4) {
        int m2756a = Crossing.m2756a(this, d, d2, d3, d4);
        return m2756a == 255 || m2739a(m2756a);
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public final PathIterator getPathIterator(AffineTransform affineTransform) {
        return new C3604a(this, affineTransform);
    }

    public final Object clone() {
        try {
            GeneralPath generalPath = (GeneralPath) super.clone();
            generalPath.f19515a = (byte[]) this.f19515a.clone();
            generalPath.f19516b = (float[]) this.f19516b.clone();
            return generalPath;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.itextpdf.p349a.p350a.Shape
    public final boolean contains(double d, double d2) {
        double d3;
        double d4;
        PathIterator pathIterator;
        double[] dArr;
        int i = 0;
        if (getBounds2D().contains(d, d2)) {
            PathIterator pathIterator2 = getPathIterator(null);
            double d5 = 0.0d;
            double[] dArr2 = new double[6];
            double d6 = 0.0d;
            double d7 = 0.0d;
            double d8 = 0.0d;
            int i2 = 0;
            while (true) {
                if (pathIterator2.mo2726b()) {
                    d3 = d7;
                    i = i2;
                    d4 = d8;
                } else {
                    int i3 = 1;
                    switch (pathIterator2.mo2728a(dArr2)) {
                        case 0:
                            pathIterator = pathIterator2;
                            dArr = dArr2;
                            if (d5 != d7 || d6 != d8) {
                                i2 += Crossing.m2759a(d5, d6, d7, d8, d, d2);
                            }
                            d5 = dArr[0];
                            d6 = dArr[1];
                            d7 = d5;
                            d8 = d6;
                            break;
                        case 1:
                            pathIterator = pathIterator2;
                            dArr = dArr2;
                            double d9 = dArr[0];
                            double d10 = dArr[1];
                            i2 += Crossing.m2759a(d5, d6, d9, d10, d, d2);
                            d5 = d9;
                            d6 = d10;
                            break;
                        case 2:
                            pathIterator = pathIterator2;
                            dArr = dArr2;
                            double d11 = dArr[0];
                            double d12 = dArr[1];
                            double d13 = dArr[2];
                            double d14 = dArr[3];
                            if ((d < d5 && d < d11 && d < d13) || ((d > d5 && d > d11 && d > d13) || ((d2 > d6 && d2 > d12 && d2 > d14) || (d5 == d11 && d11 == d13)))) {
                                i3 = 0;
                            } else if (d2 >= d6 || d2 >= d12 || d2 >= d14 || d == d5 || d == d13) {
                                Crossing.C3603b c3603b = new Crossing.C3603b(d5, d6, d11, d12, d13, d14);
                                double d15 = d2 - d6;
                                double[] dArr3 = new double[3];
                                i3 = c3603b.m2747a(dArr3, c3603b.m2748a(dArr3, d - d5), d15, d15);
                            } else if (d5 >= d13) {
                                i3 = (d13 >= d || d >= d5) ? 0 : -1;
                            } else if (d5 >= d || d >= d13) {
                                i3 = 0;
                            }
                            i2 += i3;
                            d5 = d13;
                            d6 = d14;
                            break;
                        case 3:
                            pathIterator = pathIterator2;
                            dArr = dArr2;
                            double d16 = dArr[0];
                            double d17 = dArr[1];
                            double d18 = dArr[2];
                            double d19 = dArr[3];
                            double d20 = dArr[4];
                            double d21 = dArr[5];
                            if ((d < d5 && d < d16 && d < d18 && d < d20) || ((d > d5 && d > d16 && d > d18 && d > d20) || ((d2 > d6 && d2 > d17 && d2 > d19 && d2 > d21) || (d5 == d16 && d16 == d18 && d18 == d20)))) {
                                i3 = 0;
                            } else if (d2 >= d6 || d2 >= d17 || d2 >= d19 || d2 >= d21 || d == d5 || d == d20) {
                                Crossing.C3602a c3602a = new Crossing.C3602a(d5, d6, d16, d17, d18, d19, d20, d21);
                                double d22 = d2 - d6;
                                double[] dArr4 = new double[3];
                                i3 = c3602a.m2750a(dArr4, c3602a.m2751a(dArr4, d - d5), d22, d22);
                            } else if (d5 >= d20) {
                                i3 = (d20 >= d || d >= d5) ? 0 : -1;
                            } else if (d5 >= d || d >= d20) {
                                i3 = 0;
                            }
                            i2 += i3;
                            d5 = d20;
                            d6 = d21;
                            break;
                        case 4:
                            if (d6 != d8 || d5 != d7) {
                                pathIterator = pathIterator2;
                                dArr = dArr2;
                                i2 += Crossing.m2759a(d5, d6, d7, d8, d, d2);
                                d5 = d7;
                                d6 = d8;
                                break;
                            } else {
                                pathIterator = pathIterator2;
                                dArr = dArr2;
                                break;
                            }
                        default:
                            pathIterator = pathIterator2;
                            dArr = dArr2;
                            break;
                    }
                    if (d == d5 && d2 == d6) {
                        d3 = d7;
                        d6 = d8;
                        d4 = d6;
                    } else {
                        pathIterator.mo2725c();
                        pathIterator2 = pathIterator;
                        dArr2 = dArr;
                    }
                }
            }
            if (d6 != d4) {
                i += Crossing.m2759a(d5, d6, d3, d4, d, d2);
            }
        }
        return m2739a(i);
    }
}
