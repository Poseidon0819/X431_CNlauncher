package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;

/* renamed from: com.baidu.location.indoor.h */
/* loaded from: classes.dex */
public class C1046h {

    /* renamed from: a */
    private InterfaceC1048a f4813a;

    /* renamed from: c */
    private BDLocation f4815c;

    /* renamed from: b */
    private long f4814b = 450;

    /* renamed from: d */
    private C1049b f4816d = null;

    /* renamed from: e */
    private C1049b f4817e = null;

    /* renamed from: f */
    private C1049b f4818f = new C1049b();

    /* renamed from: g */
    private C1049b f4819g = new C1049b();

    /* renamed from: h */
    private C1049b f4820h = new C1049b();

    /* renamed from: i */
    private C1049b f4821i = new C1049b();

    /* renamed from: j */
    private long f4822j = -1;

    /* renamed from: k */
    private boolean f4823k = false;

    /* renamed from: l */
    private Handler f4824l = new Handler();

    /* renamed from: m */
    private Runnable f4825m = new Runnable() { // from class: com.baidu.location.indoor.h.1
        @Override // java.lang.Runnable
        public void run() {
            C1046h c1046h = C1046h.this;
            C1049b m11331a = c1046h.m11331a(c1046h.f4817e);
            if (m11331a != null && C1046h.this.f4813a != null) {
                C1046h c1046h2 = C1046h.this;
                c1046h2.f4817e = c1046h2.f4817e.m11314b(m11331a);
                long currentTimeMillis = System.currentTimeMillis();
                if (!m11331a.m11315b(2.0E-6d) && currentTimeMillis - C1046h.this.f4822j > C1046h.this.f4814b) {
                    BDLocation bDLocation = new BDLocation(C1046h.this.f4815c);
                    bDLocation.setLatitude(C1046h.this.f4817e.f4827a);
                    bDLocation.setLongitude(C1046h.this.f4817e.f4828b);
                    C1046h.this.f4813a.mo11318a(bDLocation);
                    C1046h.this.f4822j = currentTimeMillis;
                }
            }
            C1046h.this.f4824l.postDelayed(C1046h.this.f4825m, 450L);
        }
    };

    /* renamed from: com.baidu.location.indoor.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1048a {
        /* renamed from: a */
        void mo11318a(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.h$b */
    /* loaded from: classes.dex */
    public class C1049b {

        /* renamed from: a */
        public double f4827a;

        /* renamed from: b */
        public double f4828b;

        public C1049b() {
            this.f4827a = 0.0d;
            this.f4828b = 0.0d;
        }

        public C1049b(double d, double d2) {
            this.f4827a = d;
            this.f4828b = d2;
        }

        public C1049b(C1049b c1049b) {
            this.f4827a = c1049b.f4827a;
            this.f4828b = c1049b.f4828b;
        }

        /* renamed from: a */
        public C1049b m11317a(double d) {
            return new C1049b(this.f4827a * d, this.f4828b * d);
        }

        /* renamed from: a */
        public C1049b m11316a(C1049b c1049b) {
            return new C1049b(this.f4827a - c1049b.f4827a, this.f4828b - c1049b.f4828b);
        }

        /* renamed from: b */
        public C1049b m11314b(C1049b c1049b) {
            return new C1049b(this.f4827a + c1049b.f4827a, this.f4828b + c1049b.f4828b);
        }

        /* renamed from: b */
        public boolean m11315b(double d) {
            double abs = Math.abs(this.f4827a);
            double abs2 = Math.abs(this.f4828b);
            return abs > 0.0d && abs < d && abs2 > 0.0d && abs2 < d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C1049b m11331a(C1049b c1049b) {
        C1049b c1049b2 = this.f4816d;
        if (c1049b2 == null || c1049b == null) {
            return null;
        }
        C1049b m11316a = c1049b2.m11316a(c1049b);
        this.f4821i = this.f4821i.m11314b(m11316a);
        C1049b m11316a2 = this.f4820h.m11316a(this.f4818f);
        this.f4818f = new C1049b(this.f4820h);
        this.f4820h = new C1049b(m11316a);
        C1049b m11317a = m11316a.m11317a(0.2d);
        C1049b m11317a2 = this.f4821i.m11317a(0.01d);
        return m11317a.m11314b(m11317a2).m11314b(m11316a2.m11317a(-0.02d));
    }

    /* renamed from: a */
    public void m11334a() {
        if (this.f4823k) {
            this.f4823k = false;
            this.f4824l.removeCallbacks(this.f4825m);
            m11327b();
        }
    }

    /* renamed from: a */
    public void m11333a(long j) {
        this.f4814b = j;
    }

    /* renamed from: a */
    public synchronized void m11332a(BDLocation bDLocation) {
        double latitude = bDLocation.getLatitude();
        double longitude = bDLocation.getLongitude();
        this.f4815c = bDLocation;
        this.f4816d = new C1049b(latitude, longitude);
        if (this.f4817e == null) {
            this.f4817e = new C1049b(latitude, longitude);
        }
    }

    /* renamed from: b */
    public void m11327b() {
        this.f4822j = -1L;
        this.f4817e = null;
        this.f4816d = null;
        this.f4818f = new C1049b();
        this.f4819g = new C1049b();
        this.f4820h = new C1049b();
        this.f4821i = new C1049b();
    }

    /* renamed from: c */
    public boolean m11324c() {
        return this.f4823k;
    }
}
