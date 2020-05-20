package com.itextpdf.p349a.p350a.p351a;

import com.itextpdf.p349a.p350a.PathIterator;
import com.itextpdf.p349a.p350a.Shape;

/* renamed from: com.itextpdf.a.a.a.a */
/* loaded from: classes.dex */
public final class Crossing {
    /* renamed from: a */
    public static int m2759a(double d, double d2, double d3, double d4, double d5, double d6) {
        if ((d5 >= d || d5 >= d3) && ((d5 <= d || d5 <= d3) && ((d6 <= d2 || d6 <= d4) && d != d3))) {
            if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
                return 0;
            }
            return d5 == d ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? 1 : -1;
        }
        return 0;
    }

    /* renamed from: a */
    private static int m2758a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9;
        double d10;
        if ((d7 >= d || d7 >= d3) && ((d5 <= d || d5 <= d3) && (d6 <= d2 || d6 <= d4))) {
            if (d8 >= d2 || d8 >= d4) {
                if (d == d3) {
                    return 255;
                }
                if (d < d3) {
                    d9 = d < d5 ? d5 : d;
                    d10 = d3 < d7 ? d3 : d7;
                } else {
                    d9 = d3 < d5 ? d5 : d3;
                    d10 = d < d7 ? d : d7;
                }
                double d11 = (d4 - d2) / (d3 - d);
                double d12 = ((d9 - d) * d11) + d2;
                double d13 = (d11 * (d10 - d)) + d2;
                if (d12 < d6 && d13 < d6) {
                    return 0;
                }
                if (d12 <= d8 || d13 <= d8) {
                    return 255;
                }
            }
            if (d == d3) {
                return 0;
            }
            return d5 == d ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? (d >= d5 || d5 >= d3) ? 0 : 1 : (d3 >= d5 || d5 >= d) ? 0 : -1;
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m2760a(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    /* renamed from: a */
    public static int m2753a(double[] dArr, double[] dArr2) {
        double d = dArr[2];
        int i = 1;
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != 0.0d) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < 0.0d) {
                return 0;
            }
            double sqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr2[0] = (d5 + sqrt) / d6;
            if (sqrt != 0.0d) {
                dArr2[1] = (d5 - sqrt) / d6;
                i = 2;
            }
        } else if (d2 == 0.0d) {
            return -1;
        } else {
            dArr2[0] = (-d3) / d2;
        }
        return m2755a(dArr2, i);
    }

    /* renamed from: b */
    public static int m2752b(double[] dArr, double[] dArr2) {
        int i = 3;
        double d = dArr[3];
        if (d == 0.0d) {
            return m2753a(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double acos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double sqrt = Math.sqrt(d5) * (-2.0d);
            dArr2[0] = (Math.cos(acos) * sqrt) + d9;
            dArr2[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d9;
            dArr2[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double pow = Math.pow(Math.sqrt(d10) + Math.abs(d6), 0.3333333333333333d);
            if (d6 > 0.0d) {
                pow = -pow;
            }
            if (-1.0E-10d < pow && pow < 1.0E-10d) {
                dArr2[0] = d9;
                i = 1;
            } else {
                double d11 = pow + (d5 / pow);
                dArr2[0] = d11 + d9;
                if (-1.0E-10d >= d10 || d10 >= 1.0E-10d) {
                    i = 1;
                } else {
                    dArr2[1] = ((-d11) / 2.0d) + d9;
                    i = 2;
                }
            }
        }
        return m2755a(dArr2, i);
    }

    /* renamed from: a */
    private static int m2755a(double[] dArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 < i) {
                    if (!m2760a(dArr[i2] - dArr[i5])) {
                        i5++;
                    }
                } else {
                    dArr[i3] = dArr[i2];
                    i3++;
                    break;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    /* compiled from: Crossing.java */
    /* renamed from: com.itextpdf.a.a.a.a$b */
    /* loaded from: classes.dex */
    public static class C3603b {

        /* renamed from: a */
        double f19491a;

        /* renamed from: b */
        double f19492b;

        /* renamed from: c */
        double f19493c;

        /* renamed from: d */
        double f19494d;

        /* renamed from: e */
        double f19495e;

        /* renamed from: f */
        double f19496f;

        /* renamed from: g */
        double f19497g;

        /* renamed from: h */
        double f19498h;

        public C3603b(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f19491a = d5 - d;
            this.f19492b = d6 - d2;
            this.f19493c = d3 - d;
            this.f19494d = d4 - d2;
            double d7 = this.f19493c;
            this.f19497g = d7 + d7;
            this.f19495e = this.f19491a - this.f19497g;
            double d8 = this.f19494d;
            this.f19498h = d8 + d8;
            this.f19496f = this.f19492b - this.f19498h;
        }

        /* renamed from: a */
        public final int m2747a(double[] dArr, int i, double d, double d2) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double d3 = dArr[i3];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d4 = this.f19493c;
                            if (d4 == 0.0d) {
                                d4 = this.f19491a - d4;
                            }
                            if (d4 < 0.0d) {
                                i2--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.f19492b) {
                            double d5 = this.f19491a;
                            double d6 = this.f19493c;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > 0.0d) {
                                i2++;
                            }
                        }
                    } else if (((this.f19496f * d3) + this.f19498h) * d3 > d2) {
                        double d7 = (d3 * this.f19495e) + this.f19493c;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i2 += d7 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i2;
        }

        /* renamed from: a */
        public final int m2748a(double[] dArr, double d) {
            return Crossing.m2753a(new double[]{-d, this.f19497g, this.f19495e}, dArr);
        }

        /* renamed from: a */
        final int m2746a(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i3;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.f19495e * d3) + this.f19497g) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i4 + 1;
                        dArr[i4] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((this.f19496f * d3) + this.f19498h);
                        i4 = i9 + 1;
                        dArr[i9] = i5;
                        if (z) {
                            i5++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    /* compiled from: Crossing.java */
    /* renamed from: com.itextpdf.a.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C3602a {

        /* renamed from: a */
        double f19477a;

        /* renamed from: b */
        double f19478b;

        /* renamed from: c */
        double f19479c;

        /* renamed from: d */
        double f19480d;

        /* renamed from: e */
        double f19481e;

        /* renamed from: f */
        double f19482f;

        /* renamed from: g */
        double f19483g;

        /* renamed from: h */
        double f19484h;

        /* renamed from: i */
        double f19485i;

        /* renamed from: j */
        double f19486j;

        /* renamed from: k */
        double f19487k;

        /* renamed from: l */
        double f19488l;

        /* renamed from: m */
        double f19489m;

        /* renamed from: n */
        double f19490n;

        public C3602a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.f19477a = d7 - d;
            this.f19478b = d8 - d2;
            this.f19479c = d3 - d;
            this.f19480d = d4 - d2;
            this.f19481e = d5 - d;
            this.f19482f = d6 - d2;
            double d9 = this.f19479c;
            this.f19487k = d9 + d9 + d9;
            double d10 = this.f19481e;
            double d11 = d10 + d10 + d10;
            double d12 = this.f19487k;
            this.f19485i = (d11 - d12) - d12;
            double d13 = this.f19477a;
            double d14 = this.f19485i;
            this.f19483g = (d13 - d14) - d12;
            double d15 = this.f19480d;
            this.f19488l = d15 + d15 + d15;
            double d16 = this.f19482f;
            double d17 = d16 + d16 + d16;
            double d18 = this.f19488l;
            this.f19486j = (d17 - d18) - d18;
            this.f19484h = (this.f19478b - this.f19486j) - d18;
            double d19 = this.f19483g;
            this.f19489m = d19 + d19 + d19;
            this.f19490n = d14 + d14;
        }

        /* renamed from: a */
        public final int m2750a(double[] dArr, int i, double d, double d2) {
            double d3;
            double d4;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double d5 = dArr[i3];
                if (d5 >= -1.0E-5d && d5 <= 1.00001d) {
                    if (d5 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d6 = this.f19479c;
                            if (d6 == 0.0d) {
                                double d7 = this.f19481e;
                                d6 = d7 != d6 ? d7 - d6 : this.f19477a - d7;
                            }
                            if (d6 < 0.0d) {
                                i2--;
                            }
                        }
                    } else if (d5 > 0.99999d) {
                        if (d < this.f19478b) {
                            double d8 = this.f19477a;
                            double d9 = this.f19481e;
                            if (d8 != d9) {
                                d4 = d8 - d9;
                            } else {
                                d4 = this.f19479c;
                                if (d9 != d4) {
                                    d4 = d9 - d4;
                                }
                            }
                            if (d4 > 0.0d) {
                                i2++;
                            }
                        }
                    } else if (((((this.f19484h * d5) + this.f19486j) * d5) + this.f19488l) * d5 > d2) {
                        double d10 = this.f19489m;
                        double d11 = this.f19490n;
                        double d12 = (((d5 * d10) + d11) * d5) + this.f19487k;
                        if (d12 <= -1.0E-5d || d12 >= 1.0E-5d) {
                            d3 = 0.0d;
                        } else {
                            double d13 = (d5 * (d10 + d10)) + d11;
                            if (d13 >= -1.0E-5d && d13 <= 1.0E-5d) {
                                d12 = this.f19477a;
                                d3 = 0.0d;
                            }
                        }
                        i2 += d12 > d3 ? 1 : -1;
                    }
                }
            }
            return i2;
        }

        /* renamed from: a */
        public final int m2751a(double[] dArr, double d) {
            return Crossing.m2752b(new double[]{-d, this.f19487k, this.f19485i, this.f19483g}, dArr);
        }

        /* renamed from: a */
        final int m2749a(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i3;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.f19483g * d3) + this.f19485i) * d3) + this.f19487k) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i4 + 1;
                        dArr[i4] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((((this.f19484h * d3) + this.f19486j) * d3) + this.f19488l);
                        i4 = i9 + 1;
                        dArr[i9] = i5;
                        if (z) {
                            i5++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    /* renamed from: a */
    private static int m2754a(double[] dArr, int i, double d, double d2) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 2; i4 < i; i4 += 4) {
            if (dArr[i4] < d) {
                i3++;
            } else if (dArr[i4] <= d2) {
                return 255;
            } else {
                i2++;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        if (i3 != 0) {
            int i5 = 0;
            while (i5 < i - 4) {
                int i6 = i5 + 4;
                int i7 = i5;
                for (int i8 = i6; i8 < i; i8 += 4) {
                    if (dArr[i7] > dArr[i8]) {
                        i7 = i8;
                    }
                }
                if (i7 != i5) {
                    double d3 = dArr[i5];
                    dArr[i5] = dArr[i7];
                    dArr[i7] = d3;
                    int i9 = i5 + 1;
                    double d4 = dArr[i9];
                    int i10 = i7 + 1;
                    dArr[i9] = dArr[i10];
                    dArr[i10] = d4;
                    int i11 = i5 + 2;
                    double d5 = dArr[i11];
                    int i12 = i7 + 2;
                    dArr[i11] = dArr[i12];
                    dArr[i12] = d5;
                    int i13 = i5 + 3;
                    double d6 = dArr[i13];
                    int i14 = i7 + 3;
                    dArr[i13] = dArr[i14];
                    dArr[i14] = d6;
                }
                i5 = i6;
            }
            boolean z = dArr[2] > d2;
            int i15 = 6;
            while (i15 < i) {
                boolean z2 = dArr[i15] > d2;
                if (z != z2 && dArr[i15 + 1] != dArr[i15 - 3]) {
                    return 255;
                }
                i15 += 4;
                z = z2;
            }
            return 254;
        }
        return 254;
    }

    /* renamed from: a */
    private static int m2757a(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double[] dArr;
        int m2758a;
        int i;
        double d5;
        int i2;
        int i3;
        double d6;
        int i4;
        double[] dArr2 = new double[6];
        double d7 = d + d3;
        double d8 = d2 + d4;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i5 = 0;
        while (!pathIterator.mo2726b()) {
            int i6 = 1;
            switch (pathIterator.mo2728a(dArr2)) {
                case 0:
                    dArr = dArr2;
                    m2758a = (d11 == d12 && d9 == d10) ? 0 : m2758a(d11, d9, d12, d10, d, d2, d7, d8);
                    d11 = dArr[0];
                    d9 = dArr[1];
                    d10 = d9;
                    d12 = d11;
                    i = 255;
                    break;
                case 1:
                    dArr = dArr2;
                    double d13 = dArr[0];
                    double d14 = dArr[1];
                    m2758a = m2758a(d11, d9, d13, d14, d, d2, d7, d8);
                    d11 = d13;
                    d9 = d14;
                    i = 255;
                    break;
                case 2:
                    dArr = dArr2;
                    double d15 = dArr[0];
                    double d16 = dArr[1];
                    double d17 = dArr[2];
                    double d18 = dArr[3];
                    if ((d7 < d11 && d7 < d15 && d7 < d17) || ((d > d11 && d > d15 && d > d17) || (d2 > d9 && d2 > d16 && d2 > d18))) {
                        d5 = d17;
                        m2758a = 0;
                    } else if (d8 >= d9 || d8 >= d16 || d8 >= d18 || d == d11 || d == d17) {
                        d5 = d17;
                        C3603b c3603b = new C3603b(d11, d9, d15, d16, d17, d18);
                        double d19 = d - d11;
                        double d20 = d2 - d9;
                        double d21 = d7 - d11;
                        double d22 = d8 - d9;
                        double[] dArr3 = new double[3];
                        double[] dArr4 = new double[3];
                        int m2748a = c3603b.m2748a(dArr3, d19);
                        int m2748a2 = c3603b.m2748a(dArr4, d21);
                        if (m2748a == 0 && m2748a2 == 0) {
                            m2758a = 0;
                        } else {
                            double d23 = d19 - 1.0E-5d;
                            double d24 = d21 + 1.0E-5d;
                            double[] dArr5 = new double[28];
                            int m2746a = c3603b.m2746a(dArr5, c3603b.m2746a(dArr5, 0, dArr3, m2748a, d23, d24, false, 0), dArr4, m2748a2, d23, d24, false, 1);
                            if (c3603b.f19495e != 0.0d) {
                                dArr4[0] = (-c3603b.f19497g) / (c3603b.f19495e + c3603b.f19495e);
                            } else {
                                i6 = 0;
                            }
                            if (c3603b.f19496f != 0.0d) {
                                dArr4[i6] = (-c3603b.f19498h) / (c3603b.f19496f + c3603b.f19496f);
                                i2 = i6 + 1;
                            } else {
                                i2 = i6;
                            }
                            int m2746a2 = c3603b.m2746a(dArr5, m2746a, dArr4, i2, d23, d24, true, 2);
                            if (d < d11 && d11 < d7) {
                                int i7 = m2746a2 + 1;
                                dArr5[m2746a2] = 0.0d;
                                int i8 = i7 + 1;
                                dArr5[i7] = 0.0d;
                                int i9 = i8 + 1;
                                dArr5[i8] = 0.0d;
                                m2746a2 = i9 + 1;
                                dArr5[i9] = 4.0d;
                            }
                            if (d >= d5 || d5 >= d7) {
                                i3 = m2746a2;
                            } else {
                                int i10 = m2746a2 + 1;
                                dArr5[m2746a2] = 1.0d;
                                int i11 = i10 + 1;
                                dArr5[i10] = c3603b.f19491a;
                                int i12 = i11 + 1;
                                dArr5[i11] = c3603b.f19492b;
                                dArr5[i12] = 5.0d;
                                i3 = i12 + 1;
                            }
                            m2758a = m2754a(dArr5, i3, d20, d22);
                            if (m2758a == 254) {
                                m2758a = c3603b.m2747a(dArr3, m2748a, d20, d22);
                            }
                        }
                    } else if (d11 < d17) {
                        if (d11 >= d || d >= d17) {
                            d5 = d17;
                            m2758a = 0;
                        } else {
                            d5 = d17;
                            m2758a = 1;
                        }
                    } else if (d17 >= d || d >= d11) {
                        d5 = d17;
                        m2758a = 0;
                    } else {
                        d5 = d17;
                        m2758a = -1;
                    }
                    d11 = d5;
                    d9 = d18;
                    i = 255;
                    break;
                case 3:
                    dArr = dArr2;
                    double d25 = dArr[0];
                    double d26 = dArr[1];
                    double d27 = dArr[2];
                    double d28 = dArr[3];
                    double d29 = dArr[4];
                    double d30 = dArr[5];
                    if ((d7 < d11 && d7 < d25 && d7 < d27 && d7 < d29) || ((d > d11 && d > d25 && d > d27 && d > d29) || (d2 > d9 && d2 > d26 && d2 > d28 && d2 > d30))) {
                        d6 = d30;
                        m2758a = 0;
                    } else if (d8 >= d9 || d8 >= d26 || d8 >= d28 || d8 >= d30 || d == d11 || d == d29) {
                        C3602a c3602a = new C3602a(d11, d9, d25, d26, d27, d28, d29, d30);
                        double d31 = d - d11;
                        double d32 = d2 - d9;
                        double d33 = d7 - d11;
                        double d34 = d8 - d9;
                        double[] dArr6 = new double[3];
                        double[] dArr7 = new double[3];
                        int m2751a = c3602a.m2751a(dArr6, d31);
                        int m2751a2 = c3602a.m2751a(dArr7, d33);
                        if (m2751a == 0 && m2751a2 == 0) {
                            d6 = d30;
                            m2758a = 0;
                        } else {
                            double d35 = d31 - 1.0E-5d;
                            double d36 = d33 + 1.0E-5d;
                            double[] dArr8 = new double[40];
                            d6 = d30;
                            int m2749a = c3602a.m2749a(dArr8, c3602a.m2749a(dArr8, c3602a.m2749a(dArr8, c3602a.m2749a(dArr8, 0, dArr6, m2751a, d35, d36, false, 0), dArr7, m2751a2, d35, d36, false, 1), dArr7, m2753a(new double[]{c3602a.f19487k, c3602a.f19490n, c3602a.f19489m}, dArr7), d35, d36, true, 2), dArr7, m2753a(new double[]{c3602a.f19488l, c3602a.f19486j + c3602a.f19486j, c3602a.f19484h + c3602a.f19484h + c3602a.f19484h}, dArr7), d35, d36, true, 4);
                            if (d < d11 && d11 < d7) {
                                int i13 = m2749a + 1;
                                dArr8[m2749a] = 0.0d;
                                int i14 = i13 + 1;
                                dArr8[i13] = 0.0d;
                                int i15 = i14 + 1;
                                dArr8[i14] = 0.0d;
                                m2749a = i15 + 1;
                                dArr8[i15] = 6.0d;
                            }
                            if (d >= d29 || d29 >= d7) {
                                i4 = m2749a;
                            } else {
                                int i16 = m2749a + 1;
                                dArr8[m2749a] = 1.0d;
                                int i17 = i16 + 1;
                                dArr8[i16] = c3602a.f19477a;
                                int i18 = i17 + 1;
                                dArr8[i17] = c3602a.f19478b;
                                dArr8[i18] = 7.0d;
                                i4 = i18 + 1;
                            }
                            m2758a = m2754a(dArr8, i4, d32, d34);
                            if (m2758a == 254) {
                                m2758a = c3602a.m2750a(dArr6, m2751a, d32, d34);
                            }
                        }
                    } else if (d11 < d29) {
                        if (d11 >= d || d >= d29) {
                            d6 = d30;
                            m2758a = 0;
                        } else {
                            d6 = d30;
                            m2758a = 1;
                        }
                    } else if (d29 >= d || d >= d11) {
                        d6 = d30;
                        m2758a = 0;
                    } else {
                        d6 = d30;
                        m2758a = -1;
                    }
                    d9 = d6;
                    d11 = d29;
                    i = 255;
                    break;
                case 4:
                    if (d9 == d10 && d11 == d12) {
                        dArr = dArr2;
                        m2758a = 0;
                    } else {
                        dArr = dArr2;
                        m2758a = m2758a(d11, d9, d12, d10, d, d2, d7, d8);
                    }
                    d9 = d10;
                    d11 = d12;
                    i = 255;
                    break;
                default:
                    dArr = dArr2;
                    m2758a = 0;
                    i = 255;
                    break;
            }
            if (m2758a == i) {
                return i;
            }
            i5 += m2758a;
            pathIterator.mo2725c();
            dArr2 = dArr;
        }
        if (d9 != d10) {
            int m2758a2 = m2758a(d11, d9, d12, d10, d, d2, d7, d8);
            if (m2758a2 == 255) {
                return 255;
            }
            return i5 + m2758a2;
        }
        return i5;
    }

    /* renamed from: a */
    public static int m2756a(Shape shape, double d, double d2, double d3, double d4) {
        if (shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return m2757a(shape.getPathIterator(null), d, d2, d3, d4);
        }
        return 0;
    }
}
