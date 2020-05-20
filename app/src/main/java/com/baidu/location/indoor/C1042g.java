package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.location.indoor.mapversion.C1050a;
import com.itextpdf.text.pdf.ColumnText;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.baidu.location.indoor.g */
/* loaded from: classes.dex */
public class C1042g {

    /* renamed from: A */
    private int f4766A;

    /* renamed from: B */
    private long f4767B;

    /* renamed from: C */
    private int f4768C;

    /* renamed from: D */
    private int f4769D;

    /* renamed from: E */
    private double f4770E;

    /* renamed from: F */
    private double f4771F;

    /* renamed from: G */
    private double f4772G;

    /* renamed from: H */
    private double f4773H;

    /* renamed from: I */
    private double f4774I;

    /* renamed from: J */
    private double f4775J;

    /* renamed from: K */
    private double f4776K;

    /* renamed from: L */
    private int f4777L;

    /* renamed from: M */
    private float f4778M;

    /* renamed from: N */
    private int f4779N;

    /* renamed from: O */
    private int f4780O;

    /* renamed from: P */
    private double[] f4781P;

    /* renamed from: Q */
    private boolean f4782Q;

    /* renamed from: R */
    private double f4783R;

    /* renamed from: S */
    private String f4784S;

    /* renamed from: a */
    Timer f4785a;

    /* renamed from: b */
    public SensorEventListener f4786b;

    /* renamed from: c */
    private InterfaceC1045a f4787c;

    /* renamed from: d */
    private SensorManager f4788d;

    /* renamed from: e */
    private boolean f4789e;

    /* renamed from: f */
    private int f4790f;

    /* renamed from: g */
    private Sensor f4791g;

    /* renamed from: h */
    private Sensor f4792h;

    /* renamed from: i */
    private Sensor f4793i;

    /* renamed from: j */
    private final long f4794j;

    /* renamed from: k */
    private boolean f4795k;

    /* renamed from: l */
    private boolean f4796l;

    /* renamed from: m */
    private boolean f4797m;

    /* renamed from: n */
    private volatile int f4798n;

    /* renamed from: o */
    private int f4799o;

    /* renamed from: p */
    private float[] f4800p;

    /* renamed from: q */
    private float[] f4801q;

    /* renamed from: r */
    private double[] f4802r;

    /* renamed from: s */
    private int f4803s;

    /* renamed from: t */
    private double[] f4804t;

    /* renamed from: u */
    private int f4805u;

    /* renamed from: v */
    private int f4806v;

    /* renamed from: w */
    private int f4807w;

    /* renamed from: x */
    private double[] f4808x;

    /* renamed from: y */
    private int f4809y;

    /* renamed from: z */
    private double f4810z;

    /* renamed from: com.baidu.location.indoor.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1045a {
        /* renamed from: a */
        void mo11335a(double d, double d2);
    }

    private C1042g(Context context, int i) {
        this.f4794j = 30L;
        this.f4795k = true;
        this.f4796l = false;
        this.f4797m = false;
        this.f4798n = 1;
        this.f4799o = 1;
        this.f4800p = new float[3];
        this.f4801q = new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO};
        this.f4802r = new double[]{0.0d, 0.0d, 0.0d};
        this.f4803s = 31;
        this.f4804t = new double[this.f4803s];
        this.f4805u = 0;
        this.f4808x = new double[6];
        this.f4809y = 0;
        this.f4767B = 0L;
        this.f4768C = 0;
        this.f4769D = 0;
        this.f4770E = 0.0d;
        this.f4771F = 0.0d;
        this.f4772G = 100.0d;
        this.f4773H = 0.5d;
        this.f4774I = this.f4773H;
        this.f4775J = 0.85d;
        this.f4776K = 0.42d;
        this.f4777L = -1;
        this.f4778M = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f4779N = 20;
        this.f4780O = 0;
        this.f4781P = new double[this.f4779N];
        this.f4782Q = false;
        this.f4783R = -1.0d;
        this.f4784S = null;
        this.f4786b = new SensorEventListener() { // from class: com.baidu.location.indoor.g.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i2) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                int type = sensorEvent.sensor.getType();
                if (type == 1) {
                    float[] fArr = (float[]) sensorEvent.values.clone();
                    C1042g.this.f4801q = (float[]) fArr.clone();
                    if (C1042g.this.f4795k && C1050a.m11311b()) {
                        C1050a.m11312a(1, fArr, sensorEvent.timestamp);
                    }
                    float[] m11371a = C1042g.this.m11371a(fArr[0], fArr[1], fArr[2]);
                    if (C1042g.m11359b(C1042g.this) >= 20) {
                        double d = (m11371a[0] * m11371a[0]) + (m11371a[1] * m11371a[1]) + (m11371a[2] * m11371a[2]);
                        if (C1042g.this.f4798n == 0) {
                            if (d > 4.0d) {
                                C1042g.this.f4798n = 1;
                                return;
                            }
                            return;
                        } else if (d < 0.009999999776482582d) {
                            C1042g.this.f4798n = 0;
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                switch (type) {
                    case 3:
                        float[] fArr2 = (float[]) sensorEvent.values.clone();
                        if (C1042g.this.f4795k && C1050a.m11311b()) {
                            C1050a.m11312a(5, fArr2, sensorEvent.timestamp);
                        }
                        C1042g.this.f4781P[C1042g.this.f4780O] = fArr2[0];
                        C1042g.m11350f(C1042g.this);
                        if (C1042g.this.f4780O == C1042g.this.f4779N) {
                            C1042g.this.f4780O = 0;
                        }
                        if (C1042g.m11346h(C1042g.this) >= 20) {
                            C1042g c1042g = C1042g.this;
                            c1042g.f4782Q = c1042g.m11345i();
                            if (!C1042g.this.f4782Q) {
                                C1042g.this.f4788d.unregisterListener(C1042g.this.f4786b, C1042g.this.f4792h);
                            }
                            double[] dArr = C1042g.this.f4802r;
                            C1042g c1042g2 = C1042g.this;
                            dArr[0] = c1042g2.m11372a(c1042g2.f4802r[0], fArr2[0], 0.7d);
                            C1042g.this.f4802r[1] = fArr2[1];
                            C1042g.this.f4802r[2] = fArr2[2];
                            return;
                        }
                        return;
                    case 4:
                        float[] fArr3 = (float[]) sensorEvent.values.clone();
                        if (C1042g.this.f4795k && C1050a.m11311b()) {
                            C1050a.m11312a(4, fArr3, sensorEvent.timestamp);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.f4810z = 1.6d;
        this.f4766A = 440;
        try {
            this.f4788d = (SensorManager) context.getSystemService("sensor");
            this.f4790f = i;
            this.f4791g = this.f4788d.getDefaultSensor(1);
            this.f4792h = this.f4788d.getDefaultSensor(3);
            if (C1050a.m11311b()) {
                this.f4793i = this.f4788d.getDefaultSensor(4);
            }
            m11343j();
        } catch (Exception unused) {
        }
    }

    public C1042g(Context context, InterfaceC1045a interfaceC1045a) {
        this(context, 1);
        this.f4787c = interfaceC1045a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public double m11372a(double d, double d2, double d3) {
        double d4 = d2 - d;
        if (d4 < -180.0d) {
            d4 += 360.0d;
        } else if (d4 > 180.0d) {
            d4 -= 360.0d;
        }
        return d + (d3 * d4);
    }

    /* renamed from: a */
    private double m11362a(double[] dArr) {
        int length = dArr.length;
        double d = 0.0d;
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        double d4 = length;
        Double.isNaN(d4);
        double d5 = d2 / d4;
        for (int i = 0; i < length; i++) {
            d += (dArr[i] - d5) * (dArr[i] - d5);
        }
        double d6 = length - 1;
        Double.isNaN(d6);
        return d / d6;
    }

    /* renamed from: a */
    private void m11373a(double d) {
        double[] dArr = this.f4808x;
        int i = this.f4809y;
        dArr[i % 6] = d;
        this.f4809y = i + 1;
        this.f4809y %= 6;
    }

    /* renamed from: a */
    private synchronized void m11370a(int i) {
        this.f4799o = i | this.f4799o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public float[] m11371a(float f, float f2, float f3) {
        float[] fArr = this.f4800p;
        fArr[0] = (fArr[0] * 0.8f) + (f * 0.19999999f);
        fArr[1] = (fArr[1] * 0.8f) + (f2 * 0.19999999f);
        fArr[2] = (fArr[2] * 0.8f) + (0.19999999f * f3);
        return new float[]{f - fArr[0], f2 - fArr[1], f3 - fArr[2]};
    }

    /* renamed from: b */
    static /* synthetic */ int m11359b(C1042g c1042g) {
        int i = c1042g.f4806v + 1;
        c1042g.f4806v = i;
        return i;
    }

    /* renamed from: b */
    private boolean m11360b(double d) {
        for (int i = 1; i <= 5; i++) {
            double[] dArr = this.f4808x;
            int i2 = this.f4809y;
            if (dArr[((((i2 - 1) - i) + 6) + 6) % 6] - dArr[((i2 - 1) + 6) % 6] > d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    static /* synthetic */ int m11350f(C1042g c1042g) {
        int i = c1042g.f4780O;
        c1042g.f4780O = i + 1;
        return i;
    }

    /* renamed from: h */
    static /* synthetic */ int m11346h(C1042g c1042g) {
        int i = c1042g.f4807w + 1;
        c1042g.f4807w = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m11345i() {
        for (int i = 0; i < this.f4779N; i++) {
            if (this.f4781P[i] > 1.0E-7d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private void m11343j() {
        int intValue;
        try {
            List<Sensor> sensorList = this.f4788d.getSensorList(-1);
            HashMap hashMap = new HashMap();
            hashMap.put(1, 0);
            hashMap.put(10, 1);
            hashMap.put(9, 2);
            hashMap.put(4, 3);
            hashMap.put(2, 4);
            hashMap.put(11, 5);
            hashMap.put(6, 6);
            if (Build.VERSION.SDK_INT >= 18) {
                hashMap.put(14, 7);
                hashMap.put(16, 8);
            }
            int size = hashMap.size();
            char[] cArr = new char[size];
            for (int i = 0; i < size; i++) {
                cArr[i] = '0';
            }
            for (Sensor sensor : sensorList) {
                int type = sensor.getType();
                if (hashMap.get(Integer.valueOf(type)) != null && (intValue = ((Integer) hashMap.get(Integer.valueOf(type))).intValue()) < size) {
                    cArr[intValue] = '1';
                }
            }
            this.f4784S = new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m11341k() {
        this.f4795k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
        if (r10 < r14.f4773H) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m11339l() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C1042g.m11339l():void");
    }

    /* renamed from: a */
    public void m11374a() {
        if (this.f4789e) {
            return;
        }
        Sensor sensor = this.f4791g;
        if (sensor != null) {
            try {
                this.f4788d.registerListener(this.f4786b, sensor, this.f4790f);
            } catch (Exception unused) {
                this.f4795k = false;
            }
            this.f4785a = new Timer("UpdateData", false);
            this.f4785a.schedule(new TimerTask() { // from class: com.baidu.location.indoor.g.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        C1042g.this.m11339l();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 500L, 30L);
            this.f4789e = true;
        }
        Sensor sensor2 = this.f4792h;
        if (sensor2 != null) {
            try {
                this.f4788d.registerListener(this.f4786b, sensor2, this.f4790f);
            } catch (Exception unused2) {
                this.f4795k = false;
            }
        }
    }

    /* renamed from: a */
    public void m11363a(boolean z) {
        this.f4796l = z;
        if (!z || this.f4797m) {
            return;
        }
        m11341k();
        this.f4797m = true;
    }

    /* renamed from: b */
    public void m11361b() {
        if (this.f4789e) {
            try {
                this.f4788d.unregisterListener(this.f4786b);
            } catch (Exception unused) {
            }
            if (C1050a.m11311b()) {
                C1050a.m11313a();
            }
            this.f4785a.cancel();
            this.f4785a.purge();
            this.f4785a = null;
            this.f4789e = false;
            this.f4797m = false;
        }
    }

    /* renamed from: c */
    public synchronized int m11357c() {
        if (this.f4806v < 20) {
            return 1;
        }
        return this.f4799o;
    }

    /* renamed from: d */
    public synchronized int m11355d() {
        if (this.f4806v < 20) {
            return -1;
        }
        return this.f4768C;
    }

    /* renamed from: e */
    public double m11353e() {
        return this.f4783R;
    }

    /* renamed from: f */
    public synchronized void m11351f() {
        this.f4799o = 0;
    }

    /* renamed from: g */
    public boolean m11349g() {
        return this.f4796l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public String m11347h() {
        return this.f4784S;
    }
}
