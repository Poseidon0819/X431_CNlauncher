package com.baidu.location.p078a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1026d;
import com.baidu.location.p078a.AbstractC0907g;
import com.baidu.location.p079b.C0936b;
import com.baidu.location.p079b.C0944f;
import com.baidu.location.p081d.C0955a;
import com.baidu.location.p081d.C0969d;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0990c;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import java.util.List;

/* renamed from: com.baidu.location.a.j */
/* loaded from: classes.dex */
public class C0919j extends AbstractC0907g {

    /* renamed from: h */
    public static boolean f4019h = false;

    /* renamed from: i */
    private static C0919j f4020i;

    /* renamed from: A */
    private double f4021A;

    /* renamed from: f */
    public AbstractC0907g.C0909b f4037f;

    /* renamed from: z */
    private double f4055z;

    /* renamed from: e */
    final int f4036e = 1000;

    /* renamed from: j */
    private boolean f4039j = true;

    /* renamed from: k */
    private String f4040k = null;

    /* renamed from: l */
    private BDLocation f4041l = null;

    /* renamed from: m */
    private BDLocation f4042m = null;

    /* renamed from: n */
    private C0997e f4043n = null;

    /* renamed from: o */
    private C0986a f4044o = null;

    /* renamed from: p */
    private C0997e f4045p = null;

    /* renamed from: q */
    private C0986a f4046q = null;

    /* renamed from: r */
    private boolean f4047r = true;

    /* renamed from: s */
    private volatile boolean f4048s = false;

    /* renamed from: t */
    private boolean f4049t = false;

    /* renamed from: u */
    private long f4050u = 0;

    /* renamed from: v */
    private long f4051v = 0;

    /* renamed from: w */
    private Address f4052w = null;

    /* renamed from: x */
    private String f4053x = null;

    /* renamed from: y */
    private List<Poi> f4054y = null;

    /* renamed from: B */
    private boolean f4022B = false;

    /* renamed from: C */
    private long f4023C = 0;

    /* renamed from: D */
    private long f4024D = 0;

    /* renamed from: E */
    private RunnableC0921a f4025E = null;

    /* renamed from: F */
    private boolean f4026F = false;

    /* renamed from: G */
    private boolean f4027G = false;

    /* renamed from: H */
    private boolean f4028H = true;

    /* renamed from: g */
    public final Handler f4038g = new AbstractC0907g.HandlerC0908a();

    /* renamed from: I */
    private boolean f4029I = false;

    /* renamed from: J */
    private boolean f4030J = false;

    /* renamed from: K */
    private RunnableC0922b f4031K = null;

    /* renamed from: L */
    private boolean f4032L = false;

    /* renamed from: M */
    private int f4033M = 0;

    /* renamed from: N */
    private long f4034N = 0;

    /* renamed from: O */
    private boolean f4035O = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.j$a */
    /* loaded from: classes.dex */
    public class RunnableC0921a implements Runnable {
        private RunnableC0921a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0919j.this.f4026F) {
                C0919j.this.f4026F = false;
                if (C0919j.this.f4027G || C0991d.m11704a().m11666j()) {
                    return;
                }
                C0919j.this.m12111a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.j$b */
    /* loaded from: classes.dex */
    public class RunnableC0922b implements Runnable {
        private RunnableC0922b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0919j.this.f4032L) {
                C0919j.this.f4032L = false;
            }
            if (C0919j.this.f4049t) {
                C0919j.this.f4049t = false;
                C0919j.this.m12089h(null);
            }
        }
    }

    private C0919j() {
        this.f4037f = null;
        this.f4037f = new AbstractC0907g.C0909b();
    }

    /* renamed from: a */
    private boolean m12113a(C0986a c0986a) {
        this.f3981b = C0987b.m11732a().m11715f();
        if (this.f3981b == c0986a) {
            return false;
        }
        return this.f3981b == null || c0986a == null || !c0986a.m11741a(this.f3981b);
    }

    /* renamed from: a */
    private boolean m12112a(C0997e c0997e) {
        this.f3980a = C0998f.m11640a().m11620p();
        if (c0997e == this.f3980a) {
            return false;
        }
        return this.f3980a == null || c0997e == null || !c0997e.m11652c(this.f3980a);
    }

    /* renamed from: b */
    private boolean m12106b(C0986a c0986a) {
        if (c0986a == null) {
            return false;
        }
        C0986a c0986a2 = this.f4046q;
        return c0986a2 == null || !c0986a.m11741a(c0986a2);
    }

    /* renamed from: c */
    public static synchronized C0919j m12105c() {
        C0919j c0919j;
        synchronized (C0919j.class) {
            if (f4020i == null) {
                f4020i = new C0919j();
            }
            c0919j = f4020i;
        }
        return c0919j;
    }

    /* renamed from: c */
    private void m12104c(Message message2) {
        if (message2.getData().getBoolean("isWaitingLocTag", false)) {
            f4019h = true;
        }
        if (C1026d.m11499a().m11455g()) {
            return;
        }
        int m12245d = C0892a.m12261a().m12245d(message2);
        switch (m12245d) {
            case 1:
                m12099d(message2);
                return;
            case 2:
                m12091g(message2);
                return;
            case 3:
                if (C0991d.m11704a().m11666j()) {
                    m12095e(message2);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(m12245d)));
        }
    }

    /* renamed from: d */
    private void m12099d(Message message2) {
        if (C0991d.m11704a().m11666j()) {
            m12095e(message2);
            C0924l.m12078a().m12074c();
            return;
        }
        m12091g(message2);
        C0924l.m12078a().m12076b();
    }

    /* renamed from: e */
    private void m12095e(Message message2) {
        BDLocation bDLocation = new BDLocation(C0991d.m11704a().m11669g());
        if (C1016g.f4597g.equals("all") || C1016g.f4598h || C1016g.f4599i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f4021A, this.f4055z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.f4052w;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.f4053x;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.f4054y;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
            } else {
                this.f4022B = true;
                m12091g(null);
            }
        }
        this.f4041l = bDLocation;
        this.f4042m = null;
        C0892a.m12261a().m12257a(bDLocation);
    }

    /* renamed from: f */
    private void m12093f(Message message2) {
        RunnableC0922b runnableC0922b;
        if (!C0998f.m11640a().m11629g()) {
            m12089h(message2);
            return;
        }
        this.f4049t = true;
        if (this.f4031K == null) {
            this.f4031K = new RunnableC0922b();
        }
        if (this.f4032L && (runnableC0922b = this.f4031K) != null) {
            this.f4038g.removeCallbacks(runnableC0922b);
        }
        this.f4038g.postDelayed(this.f4031K, 3500L);
        this.f4032L = true;
    }

    /* renamed from: g */
    private void m12091g(Message message2) {
        this.f4033M = 0;
        if (!this.f4047r) {
            m12093f(message2);
            this.f4024D = SystemClock.uptimeMillis();
            return;
        }
        this.f4033M = 1;
        this.f4024D = SystemClock.uptimeMillis();
        if (C0998f.m11640a().m11625k()) {
            m12093f(message2);
        } else {
            m12089h(message2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12089h(Message message2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f4050u;
        if (!this.f4048s || currentTimeMillis > 12000) {
            long j = 0;
            if (System.currentTimeMillis() - this.f4050u > 0 && System.currentTimeMillis() - this.f4050u < 1000) {
                if (this.f4041l != null) {
                    C0892a.m12261a().m12257a(this.f4041l);
                }
                m12084m();
                return;
            }
            this.f4048s = true;
            this.f4039j = m12113a(this.f4044o);
            if (!m12112a(this.f4043n) && !this.f4039j && this.f4041l != null && !this.f4022B) {
                if (this.f4042m != null && System.currentTimeMillis() - this.f4051v > 30000) {
                    this.f4041l = this.f4042m;
                    this.f4042m = null;
                }
                if (C0924l.m12078a().m12073d()) {
                    this.f4041l.setDirection(C0924l.m12078a().m12072e());
                }
                if (this.f4041l.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.f4034N;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.f4041l.getLocType() == 61 || this.f4041l.getLocType() == 161 || (this.f4041l.getLocType() == 62 && j < 15000)) {
                    C0892a.m12261a().m12257a(this.f4041l);
                    m12084m();
                    return;
                }
            }
            this.f4050u = System.currentTimeMillis();
            String a = m12153a((String) null);
            this.f4030J = false;
            if (a == null) {
                this.f4030J = true;
                this.f4034N = System.currentTimeMillis();
                String[] m12085l = m12085l();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.f4023C > 60000) {
                    this.f4023C = currentTimeMillis3;
                }
                String m11623m = C0998f.m11640a().m11623m();
                if (m11623m != null) {
                    a = m11623m + m12152b() + m12085l[0];
                } else {
                    a = m12152b() + m12085l[0];
                }
                if (this.f3981b != null && this.f3981b.m11734h() != null) {
                    a = this.f3981b.m11734h() + a;
                }
                String m11600a = C1006b.m11603a().m11600a(true);
                if (m11600a != null) {
                    a = a + m11600a;
                }
            }
            if (this.f4040k != null) {
                a = a + this.f4040k;
                this.f4040k = null;
            }
            this.f4037f.m12150a(a);
            this.f4044o = this.f3981b;
            this.f4043n = this.f3980a;
            if (!C0991d.m11704a().m11666j()) {
                m12086k();
            }
            if (C0969d.m11810a().m11795h()) {
                if (this.f4025E == null) {
                    this.f4025E = new RunnableC0921a();
                }
                this.f4038g.postDelayed(this.f4025E, C0969d.m11810a().m11806a(C0990c.m11705a(C0987b.m11732a().m11716e())));
                this.f4026F = true;
            }
            if (this.f4047r) {
                this.f4047r = false;
                if (C0998f.m11626j() && message2 != null && C0892a.m12261a().m12243e(message2) < 1000 && C0969d.m11810a().m11799d()) {
                    C0969d.m11810a().m11794i();
                }
                C0936b.m12017a().m12014b();
            }
            int i = this.f4033M;
            if (i > 0) {
                if (i == 2) {
                    C0998f.m11640a().m11629g();
                }
                this.f4033M = 0;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
        if (r0.getPoiList() == null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m12086k() {
        /*
            r15 = this;
            double r0 = java.lang.Math.random()
            android.os.SystemClock.uptimeMillis()
            com.baidu.location.e.b r2 = com.baidu.location.p082e.C0987b.m11732a()
            com.baidu.location.e.a r2 = r2.m11715f()
            com.baidu.location.e.f r3 = com.baidu.location.p082e.C0998f.m11640a()
            com.baidu.location.e.e r3 = r3.m11621o()
            if (r3 == 0) goto L24
            int r4 = r3.m11664a()
            if (r4 <= 0) goto L24
            long r4 = r3.m11648f()
            goto L26
        L24:
            r4 = 0
        L26:
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L3a
            boolean r2 = r2.m11737e()
            if (r2 == 0) goto L3a
            if (r3 == 0) goto L38
            int r2 = r3.m11664a()
            if (r2 != 0) goto L3a
        L38:
            r2 = 1
            goto L3b
        L3a:
            r2 = 0
        L3b:
            com.baidu.location.d.d r3 = com.baidu.location.p081d.C0969d.m11810a()
            boolean r3 = r3.m11799d()
            r8 = 0
            if (r3 == 0) goto Lb8
            com.baidu.location.d.d r3 = com.baidu.location.p081d.C0969d.m11810a()
            boolean r3 = r3.m11797f()
            if (r3 == 0) goto Lb8
            r9 = 60
            int r3 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r3 >= 0) goto Lb8
            if (r2 != 0) goto L6a
            r2 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto Lb8
            com.baidu.location.d.d r2 = com.baidu.location.p081d.C0969d.m11810a()
            double r2 = r2.m11788o()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lb8
        L6a:
            com.baidu.location.d.d r9 = com.baidu.location.p081d.C0969d.m11810a()
            com.baidu.location.e.b r0 = com.baidu.location.p082e.C0987b.m11732a()
            com.baidu.location.e.a r10 = r0.m11715f()
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()
            com.baidu.location.e.e r11 = r0.m11621o()
            r12 = 0
            com.baidu.location.d.d$b r13 = com.baidu.location.p081d.C0969d.EnumC0972b.IS_MIX_MODE
            com.baidu.location.d.d$a r14 = com.baidu.location.p081d.C0969d.EnumC0971a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r9.m11807a(r10, r11, r12, r13, r14)
            if (r0 != 0) goto L8b
        L89:
            r1 = 0
            goto Lb4
        L8b:
            java.lang.String r1 = com.baidu.location.p084g.C1016g.f4597g
            java.lang.String r2 = "all"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9d
            java.lang.String r1 = r0.getAddrStr()
            if (r1 != 0) goto L9d
            r1 = 0
            goto L9e
        L9d:
            r1 = 1
        L9e:
            boolean r2 = com.baidu.location.p084g.C1016g.f4598h
            if (r2 == 0) goto La9
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto La9
            r1 = 0
        La9:
            boolean r2 = com.baidu.location.p084g.C1016g.f4599i
            if (r2 == 0) goto Lb4
            java.util.List r2 = r0.getPoiList()
            if (r2 != 0) goto Lb4
            goto L89
        Lb4:
            if (r1 != 0) goto Lb7
            goto Lb8
        Lb7:
            r8 = r0
        Lb8:
            if (r8 == 0) goto Le0
            int r0 = r8.getLocType()
            r1 = 66
            if (r0 != r1) goto Le0
            boolean r0 = r15.f4048s
            if (r0 == 0) goto Le0
            com.baidu.location.BDLocation r0 = new com.baidu.location.BDLocation
            r0.<init>(r8)
            r1 = 161(0xa1, float:2.26E-43)
            r0.setLocType(r1)
            boolean r1 = r15.f4048s
            if (r1 == 0) goto Le0
            r15.f4027G = r6
            com.baidu.location.a.a r1 = com.baidu.location.p078a.C0892a.m12261a()
            r1.m12257a(r0)
            r15.f4041l = r0
            goto Le1
        Le0:
            r6 = 0
        Le1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0919j.m12086k():boolean");
    }

    /* renamed from: l */
    private String[] m12085l() {
        boolean z;
        C0895b m12229a;
        int i;
        String str;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int m11561b = C1016g.m11561b(ServiceC1002f.getServiceContext());
        if (m11561b == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(m11561b);
        String m11554d = C1016g.m11554d(ServiceC1002f.getServiceContext());
        if (m11554d.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(m11554d);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int m11556c = C1016g.m11556c(ServiceC1002f.getServiceContext());
            if (m11556c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(m11556c);
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            int m11556c2 = C1016g.m11556c(ServiceC1002f.getServiceContext());
            if (m11556c2 >= 0) {
                stringBuffer.append(m11556c2);
            }
        }
        String m11714g = C0987b.m11732a().m11714g();
        String m11628h = C0998f.m11640a().m11628h();
        stringBuffer.append(m11628h);
        stringBuffer.append(m11714g);
        stringBuffer.append(C1016g.m11552e(ServiceC1002f.getServiceContext()));
        if (m11561b == 1) {
            m12229a = C0895b.m12229a();
            i = 7;
            str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        } else if (m11554d.contains("0|0|")) {
            m12229a = C0895b.m12229a();
            i = 4;
            str = "Location failed beacuse we can not get any loc information without any location permission!";
        } else if (z) {
            m12229a = C0895b.m12229a();
            i = 5;
            str = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
        } else if (m11714g == null || m11628h == null || !m11714g.equals("&sim=1") || m11628h.equals("&wifio=1")) {
            m12229a = C0895b.m12229a();
            i = 9;
            str = "Location failed beacuse we can not get any loc information!";
        } else {
            m12229a = C0895b.m12229a();
            i = 6;
            str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
        }
        m12229a.m12228a(62, i, str);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    /* renamed from: m */
    private void m12084m() {
        this.f4048s = false;
        this.f4027G = false;
        this.f4028H = false;
        this.f4022B = false;
        m12083n();
        if (this.f4035O) {
            this.f4035O = false;
        }
    }

    /* renamed from: n */
    private void m12083n() {
        if (this.f4041l != null) {
            C0932p.m12048a().m12035c();
            C0944f.m11971a().m11964c();
        }
    }

    /* renamed from: a */
    public Address m12117a(BDLocation bDLocation) {
        if (C1016g.f4597g.equals("all") || C1016g.f4598h || C1016g.f4599i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f4021A, this.f4055z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.f4052w;
                if (address != null) {
                    return address;
                }
            } else {
                this.f4053x = null;
                this.f4054y = null;
                this.f4022B = true;
                m12091g(null);
            }
        }
        return null;
    }

    @Override // com.baidu.location.p078a.AbstractC0907g
    /* renamed from: a */
    public void mo12119a() {
        BDLocation bDLocation;
        RunnableC0921a runnableC0921a = this.f4025E;
        boolean z = false;
        if (runnableC0921a != null && this.f4026F) {
            this.f4026F = false;
            this.f4038g.removeCallbacks(runnableC0921a);
        }
        if (C0991d.m11704a().m11666j()) {
            BDLocation bDLocation2 = new BDLocation(C0991d.m11704a().m11669g());
            if (C1016g.f4597g.equals("all") || C1016g.f4598h || C1016g.f4599i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f4021A, this.f4055z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.f4052w;
                    if (address != null) {
                        bDLocation2.setAddr(address);
                    }
                    String str = this.f4053x;
                    if (str != null) {
                        bDLocation2.setLocationDescribe(str);
                    }
                    List<Poi> list = this.f4054y;
                    if (list != null) {
                        bDLocation2.setPoiList(list);
                    }
                }
            }
            C0892a.m12261a().m12257a(bDLocation2);
        } else if (this.f4027G) {
            m12084m();
            return;
        } else {
            if (C0969d.m11810a().m11799d() && C0969d.m11810a().m11798e()) {
                bDLocation = C0969d.m11810a().m11807a(C0987b.m11732a().m11715f(), C0998f.m11640a().m11621o(), null, C0969d.EnumC0972b.IS_NOT_MIX_MODE, C0969d.EnumC0971a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    C0892a.m12261a().m12257a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.f4039j || this.f4041l == null) {
                    if (C0955a.m11938a().f4220a) {
                        bDLocation = C0955a.m11938a().m11925a(false);
                    } else if (bDLocation == null) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(67);
                    }
                    if (bDLocation != null) {
                        C0892a.m12261a().m12257a(bDLocation);
                        if (bDLocation.getLocType() == 67 && !this.f4030J) {
                            C0895b.m12229a().m12228a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z2 = true;
                        if (C1016g.f4597g.equals("all") && bDLocation.getAddrStr() == null) {
                            z2 = false;
                        }
                        if (C1016g.f4598h && bDLocation.getLocationDescribe() == null) {
                            z2 = false;
                        }
                        if (!C1016g.f4599i || bDLocation.getPoiList() != null) {
                            z = z2;
                        }
                        if (!z) {
                            bDLocation.setLocType(67);
                        }
                    }
                } else {
                    C0892a.m12261a().m12257a(this.f4041l);
                }
            }
            this.f4042m = null;
        }
        m12084m();
    }

    @Override // com.baidu.location.p078a.AbstractC0907g
    /* renamed from: a */
    public void mo12118a(Message message2) {
        RunnableC0921a runnableC0921a = this.f4025E;
        if (runnableC0921a != null && this.f4026F) {
            this.f4026F = false;
            this.f4038g.removeCallbacks(runnableC0921a);
        }
        BDLocation bDLocation = (BDLocation) message2.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.f4030J) {
            bDLocation.setLocType(62);
        }
        m12109b(bDLocation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (com.baidu.location.p081d.C0955a.m11938a().f4220a == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r0.getLocType() != 67) goto L9;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m12111a(boolean r9, boolean r10) {
        /*
            r8 = this;
            com.baidu.location.d.d r0 = com.baidu.location.p081d.C0969d.m11810a()
            boolean r0 = r0.m11799d()
            r1 = 0
            if (r0 == 0) goto L47
            com.baidu.location.d.d r0 = com.baidu.location.p081d.C0969d.m11810a()
            boolean r0 = r0.m11796g()
            if (r0 == 0) goto L47
            com.baidu.location.d.d r2 = com.baidu.location.p081d.C0969d.m11810a()
            com.baidu.location.e.b r0 = com.baidu.location.p082e.C0987b.m11732a()
            com.baidu.location.e.a r3 = r0.m11715f()
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()
            com.baidu.location.e.e r4 = r0.m11621o()
            r5 = 0
            com.baidu.location.d.d$b r6 = com.baidu.location.p081d.C0969d.EnumC0972b.IS_NOT_MIX_MODE
            com.baidu.location.d.d$a r7 = com.baidu.location.p081d.C0969d.EnumC0971a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r2.m11807a(r3, r4, r5, r6, r7)
            if (r0 == 0) goto L3c
            int r2 = r0.getLocType()
            r3 = 67
            if (r2 != r3) goto L5b
        L3c:
            if (r9 == 0) goto L5b
            com.baidu.location.d.a r9 = com.baidu.location.p081d.C0955a.m11938a()
            boolean r9 = r9.f4220a
            if (r9 == 0) goto L5b
            goto L51
        L47:
            if (r9 == 0) goto L5a
            com.baidu.location.d.a r9 = com.baidu.location.p081d.C0955a.m11938a()
            boolean r9 = r9.f4220a
            if (r9 == 0) goto L5a
        L51:
            com.baidu.location.d.a r9 = com.baidu.location.p081d.C0955a.m11938a()
            com.baidu.location.BDLocation r0 = r9.m11925a(r1)
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 == 0) goto L98
            int r9 = r0.getLocType()
            r2 = 66
            if (r9 != r2) goto L98
            r9 = 1
            java.lang.String r2 = com.baidu.location.p084g.C1016g.f4597g
            java.lang.String r3 = "all"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L77
            java.lang.String r2 = r0.getAddrStr()
            if (r2 != 0) goto L77
            r9 = 0
        L77:
            boolean r2 = com.baidu.location.p084g.C1016g.f4598h
            if (r2 == 0) goto L82
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto L82
            r9 = 0
        L82:
            boolean r2 = com.baidu.location.p084g.C1016g.f4599i
            if (r2 == 0) goto L8d
            java.util.List r2 = r0.getPoiList()
            if (r2 != 0) goto L8d
            r9 = 0
        L8d:
            if (r9 != 0) goto L91
            if (r10 == 0) goto L98
        L91:
            com.baidu.location.a.a r9 = com.baidu.location.p078a.C0892a.m12261a()
            r9.m12257a(r0)
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0919j.m12111a(boolean, boolean):void");
    }

    /* renamed from: b */
    public void m12110b(Message message2) {
        if (this.f4029I) {
            m12104c(message2);
        }
    }

    /* renamed from: b */
    public void m12109b(BDLocation bDLocation) {
        String m11628h;
        int m11556c;
        C0997e c0997e;
        BDLocation bDLocation2;
        BDLocation bDLocation3 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.f4052w = bDLocation.getAddress();
            this.f4055z = bDLocation.getLongitude();
            this.f4021A = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.f4053x = bDLocation.getLocationDescribe();
            this.f4055z = bDLocation.getLongitude();
            this.f4021A = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.f4054y = bDLocation.getPoiList();
            this.f4055z = bDLocation.getLongitude();
            this.f4021A = bDLocation.getLatitude();
        }
        boolean z = false;
        if (C0991d.m11704a().m11666j()) {
            BDLocation bDLocation4 = new BDLocation(C0991d.m11704a().m11669g());
            if (C1016g.f4597g.equals("all") || C1016g.f4598h || C1016g.f4599i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f4021A, this.f4055z, bDLocation4.getLatitude(), bDLocation4.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.f4052w;
                    if (address != null) {
                        bDLocation4.setAddr(address);
                    }
                    String str = this.f4053x;
                    if (str != null) {
                        bDLocation4.setLocationDescribe(str);
                    }
                    List<Poi> list = this.f4054y;
                    if (list != null) {
                        bDLocation4.setPoiList(list);
                    }
                }
            }
            C0892a.m12261a().m12257a(bDLocation4);
            m12084m();
        } else if (this.f4027G) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation5 = this.f4041l;
            if (bDLocation5 != null) {
                Location.distanceBetween(bDLocation5.getLatitude(), this.f4041l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] <= 10.0f) {
                if (bDLocation.getUserIndoorState() >= 0) {
                    this.f4041l = bDLocation;
                    C0892a.m12261a().m12257a(bDLocation);
                }
                m12084m();
            }
            this.f4041l = bDLocation;
            if (!this.f4028H) {
                this.f4028H = false;
                C0892a.m12261a().m12257a(bDLocation);
            }
            m12084m();
        } else {
            if (bDLocation.getLocType() == 167) {
                C0895b.m12229a().m12228a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((m11556c = C1016g.m11556c(ServiceC1002f.getServiceContext())) == 0 || m11556c == 2)) {
                    C0895b.m12229a().m12228a(161, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (m11628h = C0998f.m11640a().m11628h()) != null && !m11628h.equals("&wifio=1")) {
                    C0895b.m12229a().m12228a(161, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            String str2 = null;
            this.f4042m = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.f4041l) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.f4041l.getNetworkLocationType()) && System.currentTimeMillis() - this.f4051v < 30000) {
                this.f4042m = bDLocation;
                z = true;
            }
            if (z) {
                C0892a.m12261a().m12257a(this.f4041l);
            } else {
                C0892a.m12261a().m12257a(bDLocation);
                this.f4051v = System.currentTimeMillis();
            }
            if (!C1016g.m11569a(bDLocation)) {
                this.f4041l = null;
            } else if (!z) {
                this.f4041l = bDLocation;
            }
            int m11563a = C1016g.m11563a(f3979c, "ssid\":\"", "\"");
            if (m11563a != Integer.MIN_VALUE && (c0997e = this.f4043n) != null) {
                str2 = c0997e.m11650d(m11563a);
            }
            this.f4040k = str2;
            if (C0969d.m11810a().m11799d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && m12106b(this.f4044o)) {
                C0969d.m11810a().m11807a(this.f4044o, null, bDLocation3, C0969d.EnumC0972b.IS_NOT_MIX_MODE, C0969d.EnumC0971a.NO_NEED_TO_LOG);
                this.f4046q = this.f4044o;
            }
            if (C0969d.m11810a().m11799d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                C0969d.m11810a().m11807a(null, this.f4043n, bDLocation3, C0969d.EnumC0972b.IS_NOT_MIX_MODE, C0969d.EnumC0971a.NO_NEED_TO_LOG);
                this.f4045p = this.f4043n;
            }
            if (this.f4044o != null) {
                C0955a.m11938a().m11929a(f3979c, this.f4044o, this.f4043n, bDLocation3);
            }
            if (C0998f.m11626j()) {
                C0969d.m11810a().m11794i();
                C0969d.m11810a().m11790m();
            }
            m12084m();
        }
    }

    /* renamed from: c */
    public void m12103c(BDLocation bDLocation) {
        m12087j();
        this.f4041l = bDLocation;
        this.f4041l.setIndoorLocMode(false);
    }

    /* renamed from: d */
    public void m12100d() {
        this.f4047r = true;
        this.f4048s = false;
        this.f4029I = true;
    }

    /* renamed from: d */
    public void m12098d(BDLocation bDLocation) {
        this.f4041l = new BDLocation(bDLocation);
    }

    /* renamed from: e */
    public void m12096e() {
        this.f4048s = false;
        this.f4049t = false;
        this.f4027G = false;
        this.f4028H = true;
        m12087j();
        this.f4029I = false;
    }

    /* renamed from: f */
    public String m12094f() {
        return this.f4053x;
    }

    /* renamed from: g */
    public List<Poi> m12092g() {
        return this.f4054y;
    }

    /* renamed from: h */
    public boolean m12090h() {
        return this.f4039j;
    }

    /* renamed from: i */
    public void m12088i() {
        if (!this.f4049t) {
            C0936b.m12017a().m12010d();
            return;
        }
        m12089h(null);
        this.f4049t = false;
    }

    /* renamed from: j */
    public void m12087j() {
        this.f4041l = null;
    }
}
