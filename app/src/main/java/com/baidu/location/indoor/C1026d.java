package com.baidu.location.indoor;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1017a;
import com.baidu.location.indoor.C1021c;
import com.baidu.location.indoor.C1042g;
import com.baidu.location.indoor.C1046h;
import com.baidu.location.indoor.mapversion.p085a.C1051a;
import com.baidu.location.indoor.mapversion.p086b.C1052a;
import com.baidu.location.p078a.C0892a;
import com.baidu.location.p078a.C0919j;
import com.baidu.location.p078a.C0924l;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1005a;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.itextpdf.text.pdf.ColumnText;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.indoor.d */
/* loaded from: classes.dex */
public class C1026d {

    /* renamed from: j */
    private static C1026d f4650j;

    /* renamed from: I */
    private C1020b<String> f4659I;

    /* renamed from: K */
    private C1020b<String> f4661K;

    /* renamed from: V */
    private C1017a f4672V;

    /* renamed from: Z */
    private C1046h f4676Z;

    /* renamed from: aa */
    private C1046h.InterfaceC1048a f4678aa;

    /* renamed from: c */
    public HandlerC1035e f4687c;

    /* renamed from: h */
    private BDLocationListener f4692h;

    /* renamed from: m */
    private C1042g f4696m;

    /* renamed from: o */
    private C1038h f4698o;

    /* renamed from: v */
    private C1042g.InterfaceC1045a f4705v;

    /* renamed from: e */
    private final int f4689e = 32;

    /* renamed from: a */
    boolean f4677a = false;

    /* renamed from: b */
    boolean f4686b = false;

    /* renamed from: i */
    private int f4693i = 5;

    /* renamed from: k */
    private long f4694k = 3000;

    /* renamed from: l */
    private volatile boolean f4695l = true;

    /* renamed from: n */
    private C1036f f4697n = null;

    /* renamed from: p */
    private long f4699p = 0;

    /* renamed from: q */
    private boolean f4700q = false;

    /* renamed from: r */
    private boolean f4701r = false;

    /* renamed from: s */
    private long f4702s = 0;

    /* renamed from: t */
    private int f4703t = 0;

    /* renamed from: u */
    private int f4704u = 0;

    /* renamed from: w */
    private int f4706w = 0;

    /* renamed from: x */
    private int f4707x = 0;

    /* renamed from: y */
    private int f4708y = 0;

    /* renamed from: z */
    private String f4709z = null;

    /* renamed from: A */
    private String f4651A = null;

    /* renamed from: B */
    private C1040e f4652B = null;

    /* renamed from: C */
    private String f4653C = null;

    /* renamed from: D */
    private String f4654D = null;

    /* renamed from: E */
    private String f4655E = null;

    /* renamed from: F */
    private int f4656F = 0;

    /* renamed from: G */
    private boolean f4657G = true;

    /* renamed from: H */
    private int f4658H = 7;

    /* renamed from: J */
    private int f4660J = 20;

    /* renamed from: L */
    private double f4662L = 0.0d;

    /* renamed from: M */
    private double f4663M = 0.0d;

    /* renamed from: N */
    private double f4664N = 0.4d;

    /* renamed from: O */
    private double f4665O = 0.0d;

    /* renamed from: P */
    private boolean f4666P = false;

    /* renamed from: Q */
    private boolean f4667Q = true;

    /* renamed from: R */
    private List<C1037g> f4668R = Collections.synchronizedList(new ArrayList());

    /* renamed from: S */
    private int f4669S = -1;

    /* renamed from: T */
    private int f4670T = 0;

    /* renamed from: U */
    private int f4671U = 0;

    /* renamed from: W */
    private String f4673W = null;

    /* renamed from: X */
    private C1021c f4674X = null;

    /* renamed from: Y */
    private boolean f4675Y = false;

    /* renamed from: ab */
    private boolean f4679ab = false;

    /* renamed from: d */
    public SimpleDateFormat f4688d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: ac */
    private int f4680ac = 2;

    /* renamed from: ad */
    private BDLocation f4681ad = null;

    /* renamed from: ae */
    private boolean f4682ae = false;

    /* renamed from: af */
    private boolean f4683af = false;

    /* renamed from: ag */
    private boolean f4684ag = false;

    /* renamed from: ah */
    private List<Float> f4685ah = Collections.synchronizedList(new ArrayList());

    /* renamed from: f */
    private boolean f4690f = false;

    /* renamed from: g */
    private BDLocationListener f4691g = new BDLocationListener() { // from class: com.baidu.location.indoor.d.1
        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && C1026d.this.f4681ad != null) {
                if (bDLocation.getAddrStr() == null && C1026d.this.f4681ad.getAddrStr() != null) {
                    bDLocation.setAddr(C1026d.this.f4681ad.getAddress());
                    bDLocation.setAddrStr(C1026d.this.f4681ad.getAddrStr());
                }
                if (bDLocation.getPoiList() == null && C1026d.this.f4681ad.getPoiList() != null) {
                    bDLocation.setPoiList(C1026d.this.f4681ad.getPoiList());
                }
                if (bDLocation.getLocationDescribe() == null && C1026d.this.f4681ad.getLocationDescribe() != null) {
                    bDLocation.setLocationDescribe(C1026d.this.f4681ad.getLocationDescribe());
                }
            }
            if ((bDLocation != null && !C0991d.m11704a().m11666j()) || (bDLocation != null && C0991d.m11704a().m11666j() && C1026d.this.f4682ae)) {
                bDLocation.setUserIndoorState(1);
                bDLocation.setIndoorNetworkState(C1026d.this.f4680ac);
                C0892a.m12261a().m12257a(bDLocation);
            }
            if (bDLocation == null || !bDLocation.getNetworkLocationType().equals("ml")) {
                return;
            }
            Message obtainMessage = C1026d.this.f4687c.obtainMessage(801);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$a */
    /* loaded from: classes.dex */
    public class C1031a {

        /* renamed from: b */
        private HashMap<String, Integer> f4717b = new HashMap<>();

        /* renamed from: c */
        private double f4718c;

        public C1031a(C0997e c0997e) {
            this.f4718c = 0.0d;
            if (c0997e.f4450a != null) {
                for (ScanResult scanResult : c0997e.f4450a) {
                    int abs = Math.abs(scanResult.level);
                    this.f4717b.put(scanResult.BSSID, Integer.valueOf(abs));
                    double d = this.f4718c;
                    int i = 100 - abs;
                    double d2 = i * i;
                    Double.isNaN(d2);
                    this.f4718c = d + d2;
                }
                this.f4718c = Math.sqrt(this.f4718c + 1.0d);
            }
        }

        /* renamed from: a */
        double m11426a(C1031a c1031a) {
            double d = 0.0d;
            for (String str : this.f4717b.keySet()) {
                int intValue = this.f4717b.get(str).intValue();
                Integer num = c1031a.m11427a().get(str);
                if (num != null) {
                    double intValue2 = (100 - intValue) * (100 - num.intValue());
                    Double.isNaN(intValue2);
                    d += intValue2;
                }
            }
            return d / (this.f4718c * c1031a.m11425b());
        }

        /* renamed from: a */
        public HashMap<String, Integer> m11427a() {
            return this.f4717b;
        }

        /* renamed from: b */
        public double m11425b() {
            return this.f4718c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$b */
    /* loaded from: classes.dex */
    public class C1032b {

        /* renamed from: a */
        double f4719a;

        /* renamed from: b */
        double f4720b;

        /* renamed from: c */
        long f4721c;

        /* renamed from: d */
        int f4722d;

        /* renamed from: e */
        List<Float> f4723e;

        /* renamed from: g */
        String f4725g;

        /* renamed from: h */
        String f4726h;

        /* renamed from: i */
        String f4727i;

        /* renamed from: j */
        boolean f4728j = false;

        /* renamed from: f */
        boolean f4724f = false;

        public C1032b(double d, double d2, long j, int i, List<Float> list, String str, String str2, String str3) {
            this.f4719a = d;
            this.f4720b = d2;
            this.f4721c = j;
            this.f4722d = i;
            this.f4723e = new ArrayList(list);
            this.f4725g = str;
            this.f4726h = str2;
            this.f4727i = str3;
        }

        /* renamed from: a */
        public double m11424a() {
            return this.f4719a;
        }

        /* renamed from: a */
        public int m11422a(C1032b c1032b) {
            return Math.abs(this.f4722d - c1032b.m11417c());
        }

        /* renamed from: a */
        public void m11423a(double d) {
            this.f4719a = d;
        }

        /* renamed from: a */
        public void m11421a(boolean z) {
            this.f4724f = z;
        }

        /* renamed from: b */
        public double m11420b() {
            return this.f4720b;
        }

        /* renamed from: b */
        public float m11418b(C1032b c1032b) {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f4720b, this.f4719a, c1032b.f4720b, c1032b.f4719a, fArr);
            return fArr[0];
        }

        /* renamed from: b */
        public void m11419b(double d) {
            this.f4720b = d;
        }

        /* renamed from: c */
        public int m11417c() {
            return this.f4722d;
        }

        /* renamed from: c */
        public boolean m11416c(C1032b c1032b) {
            int m11422a = m11422a(c1032b);
            return m11422a != 0 && ((double) (m11418b(c1032b) / ((float) m11422a))) <= (Math.pow(1.2d, (double) (1 - m11422a)) * 0.5d) + 1.0d;
        }

        /* renamed from: d */
        public boolean m11415d() {
            return this.f4724f;
        }

        /* renamed from: e */
        public Double m11414e() {
            String str = this.f4725g;
            if (str == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        }

        /* renamed from: f */
        public Double m11413f() {
            String str = this.f4726h;
            if (str == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        }

        /* renamed from: g */
        public Double m11412g() {
            String str = this.f4727i;
            if (str == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        }
    }

    /* renamed from: com.baidu.location.indoor.d$c */
    /* loaded from: classes.dex */
    class C1033c {

        /* renamed from: b */
        private C1032b[] f4731b;

        /* renamed from: c */
        private int f4732c;

        /* renamed from: d */
        private int f4733d;

        public C1033c(C1026d c1026d) {
            this(5);
        }

        public C1033c(int i) {
            this.f4731b = new C1032b[i + 1];
            this.f4732c = 0;
            this.f4733d = 0;
        }

        /* renamed from: a */
        public C1032b m11411a() {
            C1032b[] c1032bArr = this.f4731b;
            return c1032bArr[((this.f4733d - 1) + c1032bArr.length) % c1032bArr.length];
        }

        /* renamed from: a */
        public C1032b m11410a(int i) {
            C1032b[] c1032bArr = this.f4731b;
            return c1032bArr[(((this.f4733d - 1) - i) + c1032bArr.length) % c1032bArr.length];
        }

        /* renamed from: a */
        public void m11409a(C1032b c1032b) {
            if (this.f4732c != this.f4733d) {
                C1032b m11411a = m11411a();
                if (m11411a.m11417c() == c1032b.m11417c()) {
                    m11411a.m11423a((m11411a.m11424a() + c1032b.m11424a()) / 2.0d);
                    m11411a.m11419b((m11411a.m11420b() + c1032b.m11420b()) / 2.0d);
                    return;
                }
            }
            if (m11408b()) {
                m11404d();
            }
            m11407b(c1032b);
        }

        /* renamed from: b */
        public boolean m11408b() {
            return (this.f4733d + 1) % this.f4731b.length == this.f4732c;
        }

        /* renamed from: b */
        public boolean m11407b(C1032b c1032b) {
            if (m11408b()) {
                return false;
            }
            C1032b[] c1032bArr = this.f4731b;
            int i = this.f4733d;
            c1032bArr[i] = c1032b;
            this.f4733d = (i + 1) % c1032bArr.length;
            return true;
        }

        /* renamed from: c */
        public boolean m11406c() {
            return this.f4733d == this.f4732c;
        }

        /* renamed from: c */
        public boolean m11405c(C1032b c1032b) {
            if ((C1026d.this.f4683af && C1026d.this.f4684ag) || m11406c() || c1032b.m11416c(m11411a())) {
                return true;
            }
            if (m11411a().m11415d()) {
                return false;
            }
            for (int i = 0; i < m11403e(); i++) {
                C1032b m11410a = m11410a(i);
                if (m11410a.m11415d() && m11410a.m11416c(c1032b)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        public boolean m11404d() {
            int i = this.f4732c;
            if (i == this.f4733d) {
                return false;
            }
            this.f4732c = (i + 1) % this.f4731b.length;
            return true;
        }

        /* renamed from: e */
        public int m11403e() {
            int i = this.f4733d - this.f4732c;
            C1032b[] c1032bArr = this.f4731b;
            return (i + c1032bArr.length) % c1032bArr.length;
        }

        public String toString() {
            String str = "";
            for (int i = 0; i < m11403e(); i++) {
                C1032b[] c1032bArr = this.f4731b;
                C1032b c1032b = c1032bArr[(this.f4732c + i) % c1032bArr.length];
                str = str + c1032b.f4719a + ",";
            }
            String str2 = str + "  ";
            for (int i2 = 0; i2 < m11403e(); i2++) {
                C1032b[] c1032bArr2 = this.f4731b;
                C1032b c1032b2 = c1032bArr2[(this.f4732c + i2) % c1032bArr2.length];
                str2 = str2 + c1032b2.f4720b + ",";
            }
            String str3 = str2 + "  ";
            for (int i3 = 0; i3 < m11403e(); i3++) {
                C1032b[] c1032bArr3 = this.f4731b;
                C1032b c1032b3 = c1032bArr3[(this.f4732c + i3) % c1032bArr3.length];
                str3 = str3 + c1032b3.f4722d + ",";
            }
            return str3 + "  ";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$d */
    /* loaded from: classes.dex */
    public class C1034d {

        /* renamed from: b */
        private C1032b[] f4735b;

        /* renamed from: c */
        private int f4736c;

        /* renamed from: d */
        private int f4737d;

        public C1034d(C1026d c1026d) {
            this(5);
        }

        public C1034d(int i) {
            this.f4735b = new C1032b[i + 1];
            this.f4736c = 0;
            this.f4737d = 0;
        }

        /* renamed from: a */
        public C1032b m11402a() {
            C1032b[] c1032bArr = this.f4735b;
            return c1032bArr[((this.f4737d - 1) + c1032bArr.length) % c1032bArr.length];
        }

        /* renamed from: a */
        public boolean m11401a(C1032b c1032b) {
            if (c1032b.m11412g() != null && c1032b.m11413f() != null) {
                double doubleValue = c1032b.m11412g().doubleValue();
                if (c1032b.m11413f().doubleValue() > 1.0d && doubleValue > 8.0d) {
                    return false;
                }
                if (m11396d()) {
                    return true;
                }
                C1032b m11402a = m11402a();
                double doubleValue2 = m11402a.m11414e().doubleValue();
                double doubleValue3 = c1032b.m11414e().doubleValue();
                double m11377a = C1041f.m11377a(m11402a.f4723e);
                double m11377a2 = C1041f.m11377a(c1032b.f4723e);
                double m11379a = C1041f.m11379a(doubleValue2, doubleValue3);
                double m11376b = C1041f.m11376b(m11377a, m11377a2);
                double abs = Math.abs(Math.abs(m11379a) - Math.abs(m11376b));
                if (Math.abs(m11376b) > 15.0d) {
                    C1026d.this.f4698o.f4757t.m11393g();
                    return false;
                } else if (Math.abs(m11379a) <= Math.abs(m11376b) * 2.0d && abs <= 20.0d) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public float m11400b() {
            if (m11394f() < 4) {
                return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 2; i <= m11394f(); i++) {
                C1032b[] c1032bArr = this.f4735b;
                int i2 = this.f4737d;
                C1032b c1032b = c1032bArr[(((i2 - i) + 1) + c1032bArr.length) % c1032bArr.length];
                C1032b c1032b2 = c1032bArr[((i2 - i) + c1032bArr.length) % c1032bArr.length];
                double m11375b = C1041f.m11375b(c1032b2.f4720b, c1032b2.f4719a, c1032b.f4720b, c1032b.f4719a);
                double degrees = 90.0d - Math.toDegrees(Math.atan(c1032b.m11414e().doubleValue()));
                double d = 180.0d + degrees;
                if (Math.abs(C1041f.m11376b(degrees, m11375b)) >= Math.abs(C1041f.m11376b(d, m11375b))) {
                    degrees = d;
                }
                arrayList.add(Float.valueOf((float) C1041f.m11376b(C1041f.m11377a(c1032b.f4723e), degrees)));
            }
            return (float) C1041f.m11377a(arrayList);
        }

        /* renamed from: b */
        public boolean m11399b(C1032b c1032b) {
            if (m11398c()) {
                m11395e();
            }
            return m11397c(c1032b);
        }

        /* renamed from: c */
        public boolean m11398c() {
            return (this.f4737d + 1) % this.f4735b.length == this.f4736c;
        }

        /* renamed from: c */
        public boolean m11397c(C1032b c1032b) {
            if (m11398c()) {
                return false;
            }
            C1032b[] c1032bArr = this.f4735b;
            int i = this.f4737d;
            c1032bArr[i] = c1032b;
            this.f4737d = (i + 1) % c1032bArr.length;
            return true;
        }

        /* renamed from: d */
        public boolean m11396d() {
            return this.f4737d == this.f4736c;
        }

        /* renamed from: e */
        public boolean m11395e() {
            int i = this.f4736c;
            if (i == this.f4737d) {
                return false;
            }
            this.f4736c = (i + 1) % this.f4735b.length;
            return true;
        }

        /* renamed from: f */
        public int m11394f() {
            int i = this.f4737d - this.f4736c;
            C1032b[] c1032bArr = this.f4735b;
            return (i + c1032bArr.length) % c1032bArr.length;
        }

        /* renamed from: g */
        public void m11393g() {
            this.f4737d = 0;
            this.f4736c = 0;
        }

        public String toString() {
            String str = "";
            for (int i = 0; i < m11394f(); i++) {
                C1032b[] c1032bArr = this.f4735b;
                C1032b c1032b = c1032bArr[(this.f4736c + i) % c1032bArr.length];
                str = str + c1032b.f4719a + ",";
            }
            String str2 = str + "  ";
            for (int i2 = 0; i2 < m11394f(); i2++) {
                C1032b[] c1032bArr2 = this.f4735b;
                C1032b c1032b2 = c1032bArr2[(this.f4736c + i2) % c1032bArr2.length];
                str2 = str2 + c1032b2.f4720b + ",";
            }
            String str3 = str2 + "  ";
            for (int i3 = 0; i3 < m11394f(); i3++) {
                C1032b[] c1032bArr3 = this.f4735b;
                C1032b c1032b3 = c1032bArr3[(this.f4736c + i3) % c1032bArr3.length];
                str3 = str3 + c1032b3.f4722d + ",";
            }
            return str3 + "  ";
        }
    }

    /* renamed from: com.baidu.location.indoor.d$e */
    /* loaded from: classes.dex */
    public class HandlerC1035e extends Handler {
        public HandlerC1035e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            if (ServiceC1002f.isServing) {
                int i = message2.what;
                if (i == 21) {
                    C1026d.this.m11495a(message2);
                } else if (i == 28) {
                    C1026d.this.m11478b(message2);
                } else if (i == 41) {
                    C1026d.this.m11445l();
                } else if (i != 801) {
                    super.dispatchMessage(message2);
                } else {
                    C1026d.this.m11494a((BDLocation) message2.obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$f */
    /* loaded from: classes.dex */
    public class C1036f extends Thread {

        /* renamed from: b */
        private volatile boolean f4740b = true;

        /* renamed from: c */
        private long f4741c = 0;

        C1036f() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f4740b) {
                if ((((!C1026d.this.f4695l || System.currentTimeMillis() - this.f4741c <= C1026d.this.f4694k) && System.currentTimeMillis() - this.f4741c <= 10000) || C1026d.this.f4696m.m11357c() != 1) && System.currentTimeMillis() - this.f4741c <= 17500) {
                    boolean z = !C0991d.m11704a().m11666j() || C1026d.this.f4682ae;
                    if (C1026d.this.f4696m.m11357c() != 1 && z) {
                        C0892a.m12261a().m12249c();
                    }
                } else {
                    C0998f.m11640a().m11627i();
                    C1026d.this.f4696m.m11351f();
                    this.f4741c = System.currentTimeMillis();
                    C1026d.this.f4695l = false;
                }
                if (System.currentTimeMillis() - C1026d.this.f4699p > 22000) {
                    C1026d.this.f4687c.sendEmptyMessage(41);
                }
                if (System.currentTimeMillis() - C1026d.this.f4702s > 60000) {
                    C1026d.m11499a().m11465d();
                }
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException unused) {
                    this.f4740b = false;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$g */
    /* loaded from: classes.dex */
    public class C1037g {

        /* renamed from: a */
        public int f4742a;

        /* renamed from: b */
        public double f4743b;

        /* renamed from: c */
        public double f4744c;

        /* renamed from: d */
        public int f4745d = 1;

        public C1037g(int i, double d, double d2) {
            this.f4742a = i;
            this.f4743b = d;
            this.f4744c = d2;
        }

        public String toString() {
            return String.format("%d:%.1f:%.2f", Integer.valueOf(this.f4745d), Double.valueOf(this.f4744c), Double.valueOf(this.f4743b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.indoor.d$h */
    /* loaded from: classes.dex */
    public class C1038h extends AbstractC1011e {

        /* renamed from: r */
        private C1033c f4755r;

        /* renamed from: s */
        private C1034d f4756s;

        /* renamed from: t */
        private C1034d f4757t;

        /* renamed from: c */
        private boolean f4749c = false;

        /* renamed from: d */
        private boolean f4750d = false;

        /* renamed from: e */
        private String f4751e = null;

        /* renamed from: f */
        private String f4752f = null;

        /* renamed from: p */
        private List<Float> f4753p = new ArrayList();

        /* renamed from: q */
        private C1031a f4754q = null;

        /* renamed from: a */
        public float f4747a = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

        /* renamed from: u */
        private int f4758u = -1;

        /* renamed from: v */
        private long f4759v = 0;

        /* renamed from: w */
        private long f4760w = 0;

        public C1038h() {
            this.f4755r = null;
            this.f4756s = null;
            this.f4757t = null;
            this.f4525k = new HashMap();
            this.f4755r = new C1033c(C1026d.this);
            this.f4756s = new C1034d(C1026d.this);
            this.f4757t = new C1034d(6);
        }

        /* renamed from: a */
        private boolean m11390a(C0997e c0997e, double d) {
            C1031a c1031a = new C1031a(c0997e);
            C1031a c1031a2 = this.f4754q;
            if (c1031a2 == null || c1031a.m11426a(c1031a2) <= d) {
                this.f4754q = c1031a;
                return true;
            }
            return false;
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4522h = C1016g.m11557c();
            if (C1026d.this.f4651A == null || C1026d.this.f4652B == null || !C1026d.this.f4651A.equals(C1026d.this.f4652B.m11382a())) {
                this.f4751e = "&nd_idf=1&indoor_polygon=1" + this.f4751e;
            }
            this.f4523i = 1;
            String encodeTp4 = Jni.encodeTp4(this.f4751e);
            this.f4751e = null;
            this.f4525k.put("bloc", encodeTp4);
            this.f4759v = System.currentTimeMillis();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            if (!z || this.f4524j == null) {
                C1026d.m11508H(C1026d.this);
                C1026d.this.f4680ac = 0;
                C1026d.this.f4679ab = true;
                this.f4749c = false;
                if (C1026d.this.f4703t <= 40) {
                    return;
                }
                C1026d.this.m11465d();
            } else {
                try {
                    String str = this.f4524j;
                    if (!C1026d.this.f4700q) {
                        this.f4749c = false;
                        return;
                    }
                    BDLocation bDLocation = new BDLocation(str);
                    if (bDLocation.getLocType() == 161 && bDLocation.getBuildingID() != null) {
                        C1026d.this.f4681ad = new BDLocation(bDLocation);
                    }
                    C1026d.this.f4679ab = false;
                    String indoorLocationSurpportBuidlingName = bDLocation.getIndoorLocationSurpportBuidlingName();
                    if (indoorLocationSurpportBuidlingName == null) {
                        Log.w(C1005a.f4481a, "inbldg is null");
                    } else if (!C1026d.this.f4672V.m11546a(indoorLocationSurpportBuidlingName)) {
                        C1026d.this.f4672V.m11545a(indoorLocationSurpportBuidlingName, (C1017a.InterfaceC1019a) null);
                    }
                    if (C1026d.this.f4674X != null) {
                        C1026d.this.f4674X.m11532a(new C1021c.InterfaceC1025b() { // from class: com.baidu.location.indoor.d.h.1
                            @Override // com.baidu.location.indoor.C1021c.InterfaceC1025b
                            /* renamed from: a */
                            public void mo11383a(boolean z2, String str2, String str3, String str4) {
                                if (z2) {
                                    C1026d c1026d = C1026d.this;
                                    c1026d.f4673W = "&ibuuid=" + str2 + "&ibname=" + str3 + "&ibfls=" + str4;
                                }
                            }
                        });
                    }
                    C0924l.m12078a().m12075b(true);
                    if (C1026d.this.f4696m.m11355d() == -1) {
                        C1026d.this.f4686b = false;
                    }
                    if (bDLocation.getBuildingName() != null) {
                        C1026d.this.f4654D = bDLocation.getBuildingName();
                    }
                    if (bDLocation.getFloor() != null) {
                        C1026d.this.f4702s = System.currentTimeMillis();
                        this.f4760w = System.currentTimeMillis();
                        int i = (int) (this.f4760w - this.f4759v);
                        if (i > 10000) {
                            C1026d.this.f4680ac = 0;
                        } else if (i < 3000) {
                            C1026d.this.f4680ac = 2;
                        } else {
                            C1026d.this.f4680ac = 1;
                        }
                        if (bDLocation.getFloor().contains("-a")) {
                            C1026d.this.f4666P = true;
                            bDLocation.setFloor(bDLocation.getFloor().split("-")[0]);
                        } else {
                            C1026d.this.f4666P = false;
                        }
                        C1026d.this.f4659I.add(bDLocation.getFloor());
                    }
                    if (C1026d.this.f4677a && C1026d.this.f4686b) {
                        C1032b c1032b = new C1032b(bDLocation.getLongitude(), bDLocation.getLatitude(), System.currentTimeMillis(), C1026d.this.f4696m.m11355d(), this.f4753p, bDLocation.getRetFields("gradient"), bDLocation.getRetFields("mean_error"), bDLocation.getRetFields("confidence"));
                        if (this.f4755r.m11405c(c1032b)) {
                            c1032b.m11421a(true);
                            Message obtainMessage = C1026d.this.f4687c.obtainMessage(21);
                            obtainMessage.obj = bDLocation;
                            obtainMessage.sendToTarget();
                        } else {
                            C1026d.this.m11441n();
                        }
                        if (bDLocation.getFloor() != null) {
                            this.f4755r.m11409a(c1032b);
                        }
                    } else {
                        Message obtainMessage2 = C1026d.this.f4687c.obtainMessage(21);
                        obtainMessage2.obj = bDLocation;
                        obtainMessage2.sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }
            if (this.f4525k != null) {
                this.f4525k.clear();
            }
            this.f4749c = false;
        }

        /* renamed from: b */
        public void m11387b() {
            if (this.f4749c) {
                this.f4750d = true;
                return;
            }
            StringBuffer stringBuffer = new StringBuffer(1024);
            String m11734h = C0987b.m11732a().m11715f().m11734h();
            String m11671f = C0991d.m11704a().m11671f();
            C1026d.this.f4664N = 0.5d;
            C0997e m11619q = C0998f.m11640a().m11619q();
            String m11492a = C1026d.this.m11492a(m11619q);
            if (m11492a == null) {
                m11492a = m11619q.m11662a(32, true, false);
            }
            if (m11492a == null || m11492a.length() < 10) {
                return;
            }
            String str = this.f4752f;
            if (str == null || !str.equals(m11492a)) {
                this.f4752f = m11492a;
                int m11355d = C1026d.this.f4696m.m11355d();
                int i = this.f4758u;
                boolean z = i < 0 || m11355d - i > C1026d.this.f4693i;
                if (C1026d.this.f4677a && C1026d.this.f4686b) {
                    if (C1026d.this.f4701r && !m11390a(m11619q, 0.8d) && !z) {
                        return;
                    }
                } else if (C1026d.this.f4677a && C1026d.this.f4701r && !m11390a(m11619q, 0.7d) && !z) {
                    return;
                }
                this.f4758u = m11355d;
                this.f4749c = true;
                stringBuffer.append(m11734h);
                if (m11671f != null) {
                    stringBuffer.append(m11671f);
                }
                stringBuffer.append("&coor=gcj02");
                stringBuffer.append("&lt=1");
                stringBuffer.append(m11492a);
                if (C1026d.this.f4670T <= 2 && C1026d.this.f4696m.m11347h() != null) {
                    stringBuffer.append("&idsl=" + C1026d.this.f4696m.m11347h());
                }
                int size = C1026d.this.f4668R.size();
                stringBuffer.append(C1026d.this.m11497a(size));
                C1026d.this.f4669S = size;
                C1026d.m11504L(C1026d.this);
                stringBuffer.append("&drsi=" + C1026d.this.f4670T);
                stringBuffer.append("&drc=" + C1026d.this.f4707x);
                if (C1026d.this.f4662L != 0.0d && C1026d.this.f4663M != 0.0d) {
                    stringBuffer.append("&lst_idl=" + String.format(Locale.CHINA, "%.5f:%.5f", Double.valueOf(C1026d.this.f4662L), Double.valueOf(C1026d.this.f4663M)));
                }
                C1026d.this.f4707x = 0;
                stringBuffer.append("&idpfv=1");
                if (C1026d.this.f4696m != null && C1026d.this.f4696m.m11349g()) {
                    stringBuffer.append("&pdr2=1");
                }
                if (C1026d.this.f4674X != null && C1026d.this.f4674X.m11521e() != null && C1026d.this.f4674X.m11519g()) {
                    stringBuffer.append("&bleand=");
                    stringBuffer.append(C1026d.this.f4674X.m11521e());
                    stringBuffer.append("&bleand_et=");
                    stringBuffer.append(C1026d.this.f4674X.m11520f());
                }
                C1026d.m11502N(C1026d.this);
                if (C1026d.this.f4673W != null) {
                    stringBuffer.append(C1026d.this.f4673W);
                    C1026d.this.f4673W = null;
                }
                String m12242f = C0892a.m12261a().m12242f();
                if (m12242f != null) {
                    stringBuffer.append(m12242f);
                }
                stringBuffer.append(C1006b.m11603a().m11600a(true));
                this.f4751e = stringBuffer.toString();
                m11575c(C1016g.f4596f);
            }
        }

        /* renamed from: c */
        public synchronized void m11385c() {
            if (this.f4749c) {
                return;
            }
            if (this.f4750d) {
                this.f4750d = false;
                m11387b();
            }
        }
    }

    private C1026d() {
        this.f4687c = null;
        this.f4696m = null;
        this.f4698o = null;
        this.f4659I = null;
        this.f4661K = null;
        this.f4687c = new HandlerC1035e();
        try {
            C1052a.m11303a(ServiceC1002f.getServiceContext());
        } catch (Exception unused) {
        }
        this.f4676Z = new C1046h();
        this.f4676Z.m11333a(800L);
        this.f4678aa = new C1046h.InterfaceC1048a() { // from class: com.baidu.location.indoor.d.2
            @Override // com.baidu.location.indoor.C1046h.InterfaceC1048a
            /* renamed from: a */
            public void mo11318a(BDLocation bDLocation) {
                C1026d.this.m11493a(bDLocation, 29);
            }
        };
        this.f4705v = new C1042g.InterfaceC1045a() { // from class: com.baidu.location.indoor.d.3
            /* JADX WARN: Removed duplicated region for block: B:26:0x00a5 A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00ff A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x012d A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x013e A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x014f A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0169 A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0173 A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0189 A[Catch: Exception -> 0x0233, all -> 0x0235, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0027, B:8:0x0031, B:10:0x003b, B:12:0x0043, B:17:0x0056, B:19:0x005e, B:23:0x007e, B:24:0x0091, B:26:0x00a5, B:27:0x00b9, B:29:0x00c5, B:31:0x00cb, B:34:0x00de, B:36:0x00ff, B:37:0x0104, B:39:0x012d, B:40:0x0136, B:42:0x013e, B:43:0x0147, B:45:0x014f, B:46:0x0158, B:48:0x0169, B:49:0x016f, B:54:0x0181, B:56:0x0189, B:58:0x019f, B:59:0x01a8, B:61:0x01d1, B:63:0x01df, B:65:0x01fb, B:67:0x0207, B:69:0x0214, B:72:0x021f, B:75:0x0228, B:50:0x0173, B:22:0x0068), top: B:87:0x0005 }] */
            @Override // com.baidu.location.indoor.C1042g.InterfaceC1045a
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public synchronized void mo11335a(double r24, double r26) {
                /*
                    Method dump skipped, instructions count: 569
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C1026d.C10293.mo11335a(double, double):void");
            }
        };
        this.f4696m = new C1042g(ServiceC1002f.getServiceContext(), this.f4705v);
        this.f4698o = new C1038h();
        this.f4659I = new C1020b<>(this.f4658H);
        this.f4661K = new C1020b<>(this.f4660J);
        this.f4672V = new C1017a(ServiceC1002f.getServiceContext());
    }

    /* renamed from: H */
    static /* synthetic */ int m11508H(C1026d c1026d) {
        int i = c1026d.f4703t;
        c1026d.f4703t = i + 1;
        return i;
    }

    /* renamed from: L */
    static /* synthetic */ int m11504L(C1026d c1026d) {
        int i = c1026d.f4670T;
        c1026d.f4670T = i + 1;
        return i;
    }

    /* renamed from: N */
    static /* synthetic */ int m11502N(C1026d c1026d) {
        int i = c1026d.f4671U;
        c1026d.f4671U = i + 1;
        return i;
    }

    /* renamed from: a */
    public static synchronized C1026d m11499a() {
        C1026d c1026d;
        synchronized (C1026d.class) {
            if (f4650j == null) {
                f4650j = new C1026d();
            }
            c1026d = f4650j;
        }
        return c1026d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m11497a(int i) {
        if (this.f4668R.size() == 0) {
            return "&dr=0:0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("&dr=");
        this.f4668R.get(0).f4745d = 1;
        sb.append(this.f4668R.get(0).toString());
        int i2 = this.f4668R.get(0).f4742a;
        for (int i3 = 1; i3 < this.f4668R.size() && i3 <= i; i3++) {
            this.f4668R.get(i3).f4745d = this.f4668R.get(i3).f4742a - i2;
            sb.append(";");
            sb.append(this.f4668R.get(i3).toString());
            i2 = this.f4668R.get(i3).f4742a;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m11492a(C0997e c0997e) {
        StringBuilder sb;
        int m11664a = c0997e.m11664a();
        if (m11664a <= 32) {
            sb = new StringBuilder();
            sb.append(c0997e.m11662a(32, true, true));
            sb.append("&aprk=0");
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < m11664a; i++) {
                String lowerCase = c0997e.f4450a.get(i).BSSID.replaceAll(":", "").toLowerCase();
                C1017a c1017a = this.f4672V;
                if (c1017a == null || !c1017a.m11542b(lowerCase)) {
                    arrayList2.add(c0997e.f4450a.get(i));
                } else {
                    arrayList.add(c0997e.f4450a.get(i));
                }
            }
            String str = arrayList.size() > 0 ? "&aprk=3" : "";
            if (str.equals("")) {
                str = this.f4672V.m11543b() ? "&aprk=2" : "&aprk=1";
            }
            arrayList.addAll(arrayList2);
            c0997e.f4450a = arrayList;
            String m11662a = c0997e.m11662a(32, true, true);
            sb = new StringBuilder();
            sb.append(m11662a);
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11495a(Message message2) {
        int i;
        C1040e c1040e;
        if (this.f4700q) {
            BDLocation bDLocation = (BDLocation) message2.obj;
            if (bDLocation.getLocType() == 161) {
                m11441n();
                if (bDLocation.getIndoorSurpportPolygon() != null && bDLocation.getIndoorLocationSurpportBuidlingID() != null && ((c1040e = this.f4652B) == null || !c1040e.m11382a().equals(bDLocation.getBuildingID()))) {
                    String[] split = bDLocation.getIndoorSurpportPolygon().split("\\|");
                    Location[] locationArr = new Location[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        String[] split2 = split[i2].split(",");
                        Location location = new Location("gps");
                        location.setLatitude(Double.valueOf(split2[1]).doubleValue());
                        location.setLongitude(Double.valueOf(split2[0]).doubleValue());
                        locationArr[i2] = location;
                    }
                    this.f4652B = new C1040e(bDLocation.getIndoorLocationSurpportBuidlingID(), locationArr);
                }
                if (this.f4667Q && this.f4674X != null) {
                    if ((((bDLocation.getIndoorLocationSource() >> 2) & 1) == 1) && this.f4674X.m11534a()) {
                        this.f4667Q = false;
                        this.f4674X.m11525b();
                    }
                }
                this.f4703t = 0;
                if (bDLocation.getBuildingID() == null) {
                    this.f4701r = false;
                    this.f4704u++;
                    if (this.f4704u > 3) {
                        m11465d();
                    }
                } else {
                    this.f4706w = 0;
                    this.f4704u = 0;
                    this.f4701r = true;
                    bDLocation.setIndoorLocMode(true);
                    if (bDLocation.getRetFields("tp") == null || !bDLocation.getRetFields("tp").equalsIgnoreCase("ble")) {
                        this.f4675Y = false;
                    } else {
                        bDLocation.setRadius(8.0f);
                        bDLocation.setNetworkLocationType("ble");
                        this.f4675Y = true;
                    }
                    if (this.f4662L < 0.1d || this.f4663M < 0.1d) {
                        this.f4663M = bDLocation.getLatitude();
                        this.f4662L = bDLocation.getLongitude();
                    }
                    if (this.f4709z == null) {
                        this.f4709z = bDLocation.getFloor();
                    }
                    m11480a(bDLocation.getBuildingName(), bDLocation.getFloor());
                    String retFields = bDLocation.getRetFields("pdr2");
                    if (retFields != null && retFields.equals("1")) {
                        this.f4696m.m11363a(true);
                    }
                    this.f4651A = bDLocation.getBuildingID();
                    this.f4653C = bDLocation.getBuildingName();
                    this.f4655E = bDLocation.getNetworkLocationType();
                    this.f4656F = bDLocation.isParkAvailable();
                    if (!bDLocation.getFloor().equals(m11443m())) {
                        return;
                    }
                    boolean equalsIgnoreCase = bDLocation.getFloor().equalsIgnoreCase(this.f4709z);
                    if (!equalsIgnoreCase && this.f4683af) {
                        C1051a.m11305b();
                        this.f4684ag = C1051a.m11307a(bDLocation.getFloor());
                    }
                    this.f4709z = bDLocation.getFloor();
                    if (!equalsIgnoreCase) {
                        m11449j();
                    }
                    C1042g c1042g = this.f4696m;
                    if (c1042g != null && c1042g.m11353e() >= 0.0d && bDLocation.getDirection() <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                        bDLocation.setDirection((float) this.f4696m.m11353e());
                    }
                    boolean m11308a = this.f4683af ? C1051a.m11308a(bDLocation) : false;
                    if ((!this.f4683af || !m11308a) && !this.f4666P && equalsIgnoreCase) {
                        double d = this.f4664N;
                        double longitude = (this.f4662L * 1000000.0d * d) + ((1.0d - d) * bDLocation.getLongitude() * 1000000.0d);
                        double d2 = this.f4664N;
                        bDLocation.setLatitude((((this.f4663M * 1000000.0d) * d2) + ((1.0d - d2) * (bDLocation.getLatitude() * 1000000.0d))) / 1000000.0d);
                        bDLocation.setLongitude(longitude / 1000000.0d);
                    }
                    this.f4663M = bDLocation.getLatitude();
                    this.f4662L = bDLocation.getLongitude();
                }
                if (bDLocation.getNetworkLocationType() != null && !bDLocation.getNetworkLocationType().equals("ble")) {
                    C0919j.m12105c().m12103c(bDLocation);
                }
            } else if (bDLocation.getLocType() == 63) {
                this.f4703t++;
                this.f4701r = false;
                this.f4679ab = true;
                if (this.f4703t <= 10) {
                    return;
                }
                m11465d();
            } else {
                this.f4703t = 0;
                this.f4701r = false;
            }
            if (this.f4701r) {
                if (bDLocation.getTime() == null) {
                    bDLocation.setTime(this.f4688d.format(new Date()));
                }
                if (bDLocation.getNetworkLocationType().equals("wf")) {
                    C1032b c1032b = new C1032b(bDLocation.getLongitude(), bDLocation.getLatitude(), System.currentTimeMillis(), this.f4696m.m11355d(), this.f4685ah, bDLocation.getRetFields("gradient"), bDLocation.getRetFields("mean_error"), bDLocation.getRetFields("confidence"));
                    this.f4685ah.clear();
                    if (!c1032b.f4723e.isEmpty()) {
                        if (this.f4698o.f4756s.m11401a(c1032b)) {
                            this.f4698o.f4757t.m11399b(c1032b);
                        }
                        C1038h c1038h = this.f4698o;
                        c1038h.f4747a = c1038h.f4757t.m11400b();
                        this.f4698o.f4756s.m11399b(c1032b);
                    }
                    bDLocation.setDirection((float) this.f4665O);
                }
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                bDLocation2.setNetworkLocationType(bDLocation2.getNetworkLocationType() + "2");
                C1046h c1046h = this.f4676Z;
                if (c1046h == null || !c1046h.m11324c()) {
                    i = 21;
                } else if (this.f4671U > 2) {
                    this.f4676Z.m11332a(bDLocation2);
                } else {
                    i = 29;
                }
                m11493a(bDLocation2, i);
            }
            this.f4698o.m11385c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11494a(BDLocation bDLocation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11493a(BDLocation bDLocation, int i) {
        if (this.f4681ad != null) {
            if (bDLocation.getAddrStr() == null && this.f4681ad.getAddrStr() != null) {
                bDLocation.setAddr(this.f4681ad.getAddress());
                bDLocation.setAddrStr(this.f4681ad.getAddrStr());
            }
            if (bDLocation.getPoiList() == null && this.f4681ad.getPoiList() != null) {
                bDLocation.setPoiList(this.f4681ad.getPoiList());
            }
            if (bDLocation.getLocationDescribe() == null && this.f4681ad.getLocationDescribe() != null) {
                bDLocation.setLocationDescribe(this.f4681ad.getLocationDescribe());
            }
        }
        if (this.f4690f && this.f4692h != null) {
            bDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
            if (bDLocation.getNetworkLocationType().contains("2")) {
                String networkLocationType = bDLocation.getNetworkLocationType();
                bDLocation.setNetworkLocationType(networkLocationType.substring(0, networkLocationType.length() - 1));
                this.f4692h.onReceiveLocation(bDLocation);
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            Message obtainMessage = this.f4687c.obtainMessage(801);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        } else if (bDLocation != null && !C0991d.m11704a().m11666j()) {
            bDLocation.setUserIndoorState(1);
            bDLocation.setIndoorNetworkState(this.f4680ac);
            C0892a.m12261a().m12257a(bDLocation);
        } else if (bDLocation != null && C0991d.m11704a().m11666j() && this.f4682ae) {
            bDLocation.setUserIndoorState(1);
            bDLocation.setIndoorNetworkState(this.f4680ac);
            C0892a.m12261a().m12257a(bDLocation);
        }
    }

    /* renamed from: a */
    private void m11480a(final String str, final String str2) {
        String str3 = this.f4653C;
        if (str3 != null && str3.equals(str) && this.f4683af) {
            return;
        }
        C1052a m11304a = C1052a.m11304a();
        m11304a.m11297a(CoordinateType.GCJ02);
        m11304a.m11296a(str, new C1052a.InterfaceC1056c() { // from class: com.baidu.location.indoor.d.4
            @Override // com.baidu.location.indoor.mapversion.p086b.C1052a.InterfaceC1056c
            /* renamed from: a */
            public void mo11279a(boolean z, String str4) {
                C1026d.this.f4683af = z;
                if (z) {
                    C1026d.this.f4684ag = C1051a.m11307a(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public double[] m11498a(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d4);
        double d5 = d3 / 6378137.0d;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new double[]{Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin))))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11478b(Message message2) {
        BDLocation bDLocation = (BDLocation) message2.obj;
        if (this.f4662L < 0.1d || this.f4663M < 0.1d) {
            this.f4663M = bDLocation.getLatitude();
            this.f4662L = bDLocation.getLongitude();
        }
        this.f4659I.add(bDLocation.getFloor());
        this.f4709z = m11443m();
        bDLocation.setFloor(this.f4709z);
        double d = this.f4664N;
        double longitude = (this.f4662L * 1000000.0d * d) + ((1.0d - d) * bDLocation.getLongitude() * 1000000.0d);
        double d2 = this.f4664N;
        bDLocation.setLatitude((((this.f4663M * 1000000.0d) * d2) + ((1.0d - d2) * (bDLocation.getLatitude() * 1000000.0d))) / 1000000.0d);
        bDLocation.setLongitude(longitude / 1000000.0d);
        bDLocation.setTime(this.f4688d.format(new Date()));
        this.f4663M = bDLocation.getLatitude();
        this.f4662L = bDLocation.getLongitude();
        m11493a(bDLocation, 21);
    }

    /* renamed from: j */
    private void m11449j() {
        this.f4676Z.m11327b();
        this.f4671U = 0;
        this.f4698o.f4756s.m11393g();
        this.f4698o.f4757t.m11393g();
        C1038h c1038h = this.f4698o;
        c1038h.f4747a = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        c1038h.f4753p.clear();
        this.f4685ah.clear();
        this.f4668R.clear();
    }

    /* renamed from: k */
    private void m11447k() {
        this.f4659I.clear();
        this.f4661K.clear();
        this.f4702s = 0L;
        this.f4703t = 0;
        this.f4656F = 0;
        this.f4708y = 0;
        this.f4709z = null;
        this.f4679ab = false;
        this.f4651A = null;
        this.f4653C = null;
        this.f4654D = null;
        this.f4655E = null;
        this.f4657G = true;
        this.f4667Q = true;
        this.f4664N = 0.4d;
        this.f4675Y = false;
        this.f4662L = 0.0d;
        this.f4663M = 0.0d;
        this.f4706w = 0;
        this.f4704u = 0;
        this.f4666P = false;
        this.f4670T = 0;
        this.f4707x = 0;
        if (this.f4683af) {
            C1051a.m11305b();
            C1052a.m11304a().m11294b();
        }
        this.f4684ag = false;
        this.f4683af = false;
        C0924l.m12078a().m12075b(false);
        C1021c c1021c = this.f4674X;
        if (c1021c != null) {
            c1021c.m11523c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m11445l() {
        if (this.f4700q) {
            this.f4695l = true;
            this.f4698o.m11387b();
            this.f4699p = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b6, code lost:
        if (r8.f4659I.get(r1 - 1).equals(r3) != false) goto L36;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m11443m() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C1026d.m11443m():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m11441n() {
        for (int i = this.f4669S; i >= 0 && this.f4668R.size() > 0; i--) {
            this.f4668R.remove(0);
        }
        this.f4669S = -1;
    }

    /* renamed from: p */
    static /* synthetic */ int m11438p(C1026d c1026d) {
        int i = c1026d.f4706w;
        c1026d.f4706w = i + 1;
        return i;
    }

    /* renamed from: t */
    static /* synthetic */ int m11434t(C1026d c1026d) {
        int i = c1026d.f4707x;
        c1026d.f4707x = i + 1;
        return i;
    }

    /* renamed from: a */
    public boolean m11496a(Location location) {
        C1040e c1040e;
        this.f4682ae = (location == null || (c1040e = this.f4652B) == null || !c1040e.m11381a(location.getLatitude(), location.getLongitude())) ? false : true;
        return this.f4682ae;
    }

    /* renamed from: b */
    public synchronized void m11479b() {
        if (this.f4700q) {
            this.f4659I.clear();
        }
    }

    /* renamed from: c */
    public synchronized void m11470c() {
        if (this.f4700q) {
            return;
        }
        this.f4702s = System.currentTimeMillis();
        this.f4696m.m11374a();
        C0892a.m12261a().m12246d();
        this.f4697n = new C1036f();
        this.f4697n.start();
        this.f4701r = false;
        this.f4700q = true;
        this.f4674X = C1021c.m11533a(ServiceC1002f.getServiceContext());
        this.f4670T = 0;
        this.f4707x = 0;
        C0924l.m12078a().m12075b(true);
    }

    /* renamed from: d */
    public synchronized void m11465d() {
        if (this.f4700q) {
            this.f4696m.m11361b();
            if (this.f4676Z != null && this.f4676Z.m11324c()) {
                this.f4676Z.m11334a();
            }
            if (this.f4672V != null) {
                this.f4672V.m11541c();
            }
            if (this.f4674X != null) {
                this.f4674X.m11522d();
            }
            if (this.f4697n != null) {
                this.f4697n.f4740b = false;
                this.f4697n.interrupt();
                this.f4697n = null;
            }
            m11447k();
            this.f4701r = false;
            this.f4700q = false;
            C0892a.m12261a().m12244e();
        }
    }

    /* renamed from: e */
    public synchronized void m11460e() {
    }

    /* renamed from: f */
    public boolean m11457f() {
        return this.f4700q;
    }

    /* renamed from: g */
    public boolean m11455g() {
        return this.f4700q && this.f4701r;
    }

    /* renamed from: h */
    public String m11453h() {
        return this.f4709z;
    }

    /* renamed from: i */
    public String m11451i() {
        return this.f4651A;
    }
}
