package com.baidu.location.p084g;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.baidu.location.g.d */
/* loaded from: classes.dex */
public class C1008d {

    /* renamed from: a */
    private static C1008d f4508a;

    /* renamed from: b */
    private static final double[] f4509b = {110.389648d, 105.070224d, 96.898845d, 95.617053d, 93.822557d, 91.387165d, 91.387165d, 89.079901d, 87.221341d, 86.259997d, 85.170461d, 85.234525d, 82.863261d, 81.901917d, 79.594685d, 80.395798d, 79.931142d, 77.800174d, 75.252622d, 73.490158d, 73.185732d, 73.874699d, 74.403435d, 74.099003d, 75.460905d, 76.77474d, 78.280852d, 78.15266d, 78.37698d, 78.8897d, 79.690818d, 81.196914d, 81.805762d, 83.888674d, 85.939538d, 87.862215d, 89.031847d, 90.057287d, 91.098741d, 92.156213d, 93.742421d, 95.825333d, 97.956327d, 97.123143d, 98.212679d, 99.206055d, 101.657471d, 102.52267d, 102.23427d, 105.022158d, 106.095662d, 107.858116d, 111.639396d, 109.588503d, 112.280343d, 117.792023d, 118.945559d, 114.203031d, 118.689303d, 123.143466d, 122.726858d, 120.932369d, 123.415857d, 122.374385d, 122.134054d, 121.586108d, 121.17271d, 120.676006d, 120.243409d, 122.790961d, 122.871076d, 121.300884d, 122.134052d, 123.736285d, 126.412019d, 128.559027d, 129.712627d, 131.218707d, 131.987795d, 133.622084d, 135.60888d, 131.378992d, 130.866224d, 128.623088d, 126.091572d, 124.393204d, 122.214164d, 119.65058d, 119.778772d, 118.561044d, 116.510192d, 114.811824d, 119.073776d, 116.446096d, 111.735536d, 110.389648d};

    /* renamed from: c */
    private static final double[] f4510c = {43.216755d, 42.378597d, 43.172612d, 44.421188d, 45.097508d, 45.565732d, 47.334548d, 48.687188d, 49.62362d, 48.947316d, 48.479092d, 47.334548d, 47.438596d, 46.03394d, 45.201556d, 43.344095d, 42.328663d, 41.395882d, 40.829126d, 39.955382d, 39.258748d, 38.361382d, 38.054394d, 37.168842d, 36.389553d, 35.362313d, 34.311457d, 32.587581d, 31.572149d, 30.781055d, 30.438642d, 29.77743d, 30.09623d, 28.714766d, 27.71114d, 27.581258d, 27.014504d, 27.781984d, 27.510415d, 26.506787d, 26.707513d, 27.959095d, 27.29788d, 23.649404d, 23.62579d, 21.677574d, 20.780213d, 21.323353d, 22.185291d, 22.315173d, 22.515897d, 16.802289d, 13.198973d, 0.693351d, 1.541191d, 10.504055d, 15.591095d, 17.892375d, 19.951383d, 22.187501d, 25.375613d, 25.617568d, 30.627458d, 31.082902d, 31.894166d, 32.503117d, 32.805056d, 34.256784d, 35.155304d, 36.90119d, 37.83411d, 37.940728d, 38.64708d, 38.966937d, 40.979374d, 41.253698d, 42.069802d, 42.48888d, 44.65045d, 44.691252d, 48.620679d, 48.091311d, 49.194151d, 50.032311d, 53.274665d, 53.627577d, 53.892257d, 52.987929d, 52.017425d, 50.230825d, 50.186707d, 47.495779d, 47.341379d, 46.503219d, 45.245983d, 43.216755d};

    /* renamed from: d */
    private LinkedList<C1010b> f4511d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.g.d$a */
    /* loaded from: classes.dex */
    public class C1009a {

        /* renamed from: a */
        double f4512a;

        /* renamed from: b */
        double f4513b;

        C1009a(double d, double d2) {
            this.f4512a = d;
            this.f4513b = d2;
        }
    }

    /* renamed from: com.baidu.location.g.d$b */
    /* loaded from: classes.dex */
    class C1010b {

        /* renamed from: a */
        C1009a f4515a;

        /* renamed from: b */
        C1009a f4516b;

        C1010b(C1009a c1009a, C1009a c1009a2) {
            this.f4515a = c1009a;
            this.f4516b = c1009a2;
        }

        /* renamed from: a */
        double m11582a(C1009a c1009a) {
            C1009a c1009a2 = new C1009a(this.f4516b.f4512a - this.f4515a.f4512a, this.f4516b.f4513b - this.f4515a.f4513b);
            C1009a c1009a3 = new C1009a(c1009a.f4512a - this.f4515a.f4512a, c1009a.f4513b - this.f4515a.f4513b);
            return (c1009a2.f4512a * c1009a3.f4513b) - (c1009a2.f4513b * c1009a3.f4512a);
        }

        /* renamed from: b */
        boolean m11581b(C1009a c1009a) {
            return C1008d.this.m11584a(m11582a(c1009a)) == 0 && c1009a.f4512a < Math.max(this.f4515a.f4512a, this.f4516b.f4512a) + 1.0E-8d && c1009a.f4512a > Math.min(this.f4515a.f4512a, this.f4516b.f4512a) - 1.0E-8d && c1009a.f4513b < Math.max(this.f4515a.f4513b, this.f4516b.f4513b) + 1.0E-8d && c1009a.f4513b > Math.min(this.f4515a.f4513b, this.f4516b.f4513b) - 1.0E-8d;
        }
    }

    private C1008d() {
        this.f4511d = null;
        int length = f4509b.length;
        this.f4511d = new LinkedList<>();
        int i = 0;
        while (i < length - 1) {
            i++;
            this.f4511d.add(new C1010b(new C1009a(f4509b[i] * 100000.0d, f4510c[i] * 100000.0d), new C1009a(f4509b[i] * 100000.0d, f4510c[i] * 100000.0d)));
        }
    }

    /* renamed from: a */
    public static C1008d m11585a() {
        if (f4508a == null) {
            f4508a = new C1008d();
        }
        return f4508a;
    }

    /* renamed from: a */
    int m11584a(double d) {
        if (d < -1.0E-8d) {
            return -1;
        }
        return d > 1.0E-8d ? 1 : 0;
    }

    /* renamed from: a */
    public boolean m11583a(double d, double d2) {
        try {
            C1009a c1009a = new C1009a(d * 100000.0d, d2 * 100000.0d);
            Iterator<C1010b> it = this.f4511d.iterator();
            int i = 0;
            while (it.hasNext()) {
                C1010b next = it.next();
                if (next.m11581b(c1009a)) {
                    return true;
                }
                int m11584a = m11584a(next.m11582a(c1009a));
                int m11584a2 = m11584a(next.f4515a.f4513b - c1009a.f4513b);
                int m11584a3 = m11584a(next.f4516b.f4513b - c1009a.f4513b);
                if (m11584a > 0 && m11584a2 <= 0 && m11584a3 > 0) {
                    i++;
                }
                if (m11584a < 0 && m11584a3 <= 0 && m11584a2 > 0) {
                    i--;
                }
            }
            return i != 0;
        } catch (Exception unused) {
            return true;
        }
    }
}
