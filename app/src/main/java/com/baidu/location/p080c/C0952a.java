package com.baidu.location.p080c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.baidu.location.c.a */
/* loaded from: classes.dex */
public class C0952a {

    /* renamed from: e */
    private LocationClient f4205e;

    /* renamed from: f */
    private Context f4206f;

    /* renamed from: k */
    private AlarmManager f4211k;

    /* renamed from: l */
    private C0953a f4212l;

    /* renamed from: n */
    private boolean f4214n;

    /* renamed from: a */
    private ArrayList<BDNotifyListener> f4201a = null;

    /* renamed from: b */
    private float f4202b = Float.MAX_VALUE;

    /* renamed from: c */
    private BDLocation f4203c = null;

    /* renamed from: d */
    private long f4204d = 0;

    /* renamed from: g */
    private int f4207g = 0;

    /* renamed from: h */
    private long f4208h = 0;

    /* renamed from: i */
    private boolean f4209i = false;

    /* renamed from: j */
    private PendingIntent f4210j = null;

    /* renamed from: m */
    private C0954b f4213m = new C0954b();

    /* renamed from: com.baidu.location.c.a$a */
    /* loaded from: classes.dex */
    public class C0953a extends BroadcastReceiver {
        public C0953a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (C0952a.this.f4201a == null || C0952a.this.f4201a.isEmpty()) {
                return;
            }
            C0952a.this.f4205e.requestNotifyLocation();
        }
    }

    /* renamed from: com.baidu.location.c.a$b */
    /* loaded from: classes.dex */
    public class C0954b implements BDLocationListener {
        public C0954b() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (C0952a.this.f4201a == null || C0952a.this.f4201a.size() <= 0) {
                return;
            }
            C0952a.this.m11947a(bDLocation);
        }
    }

    public C0952a(Context context, LocationClient locationClient) {
        this.f4205e = null;
        this.f4206f = null;
        this.f4211k = null;
        this.f4212l = null;
        this.f4214n = false;
        this.f4206f = context;
        this.f4205e = locationClient;
        this.f4205e.registerNotifyLocationListener(this.f4213m);
        this.f4211k = (AlarmManager) this.f4206f.getSystemService("alarm");
        this.f4212l = new C0953a();
        this.f4214n = false;
    }

    /* renamed from: a */
    private void m11948a(long j) {
        try {
            if (this.f4210j != null) {
                this.f4211k.cancel(this.f4210j);
            }
            this.f4210j = PendingIntent.getBroadcast(this.f4206f, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), NTLMConstants.FLAG_UNIDENTIFIED_10);
            if (this.f4210j == null) {
                return;
            }
            this.f4211k.set(0, System.currentTimeMillis() + j, this.f4210j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11947a(BDLocation bDLocation) {
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != 161 && bDLocation.getLocType() != 65) {
            m11948a(120000L);
        } else if (System.currentTimeMillis() - this.f4204d < 5000 || this.f4201a == null) {
        } else {
            this.f4203c = bDLocation;
            this.f4204d = System.currentTimeMillis();
            float[] fArr = new float[1];
            Iterator<BDNotifyListener> it = this.f4201a.iterator();
            float f = Float.MAX_VALUE;
            while (it.hasNext()) {
                BDNotifyListener next = it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), next.mLatitudeC, next.mLongitudeC, fArr);
                float radius = (fArr[0] - next.mRadius) - bDLocation.getRadius();
                if (radius > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    if (radius < f) {
                        f = radius;
                    }
                } else if (next.Notified < 3) {
                    next.Notified++;
                    next.onNotify(bDLocation, fArr[0]);
                    if (next.Notified < 3) {
                        this.f4209i = true;
                    }
                }
            }
            if (f < this.f4202b) {
                this.f4202b = f;
            }
            this.f4207g = 0;
            m11940c();
        }
    }

    /* renamed from: b */
    private boolean m11943b() {
        ArrayList<BDNotifyListener> arrayList = this.f4201a;
        boolean z = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<BDNotifyListener> it = this.f4201a.iterator();
            while (it.hasNext()) {
                if (it.next().Notified < 3) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r0 > ((r7.f4208h + r1) - java.lang.System.currentTimeMillis())) goto L15;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11940c() {
        /*
            r7 = this;
            boolean r0 = r7.m11943b()
            if (r0 != 0) goto L7
            return
        L7:
            float r0 = r7.f4202b
            r1 = 1167867904(0x459c4000, float:5000.0)
            r2 = 10000(0x2710, float:1.4013E-41)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L16
            r0 = 600000(0x927c0, float:8.40779E-40)
            goto L2c
        L16:
            r1 = 1148846080(0x447a0000, float:1000.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L20
            r0 = 120000(0x1d4c0, float:1.68156E-40)
            goto L2c
        L20:
            r1 = 1140457472(0x43fa0000, float:500.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2a
            r0 = 60000(0xea60, float:8.4078E-41)
            goto L2c
        L2a:
            r0 = 10000(0x2710, float:1.4013E-41)
        L2c:
            boolean r1 = r7.f4209i
            r3 = 0
            if (r1 == 0) goto L35
            r7.f4209i = r3
            r0 = 10000(0x2710, float:1.4013E-41)
        L35:
            int r1 = r7.f4207g
            if (r1 == 0) goto L48
            long r4 = r7.f4208h
            long r1 = (long) r1
            long r4 = r4 + r1
            long r1 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            long r1 = (long) r0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 <= 0) goto L48
            goto L49
        L48:
            r3 = 1
        L49:
            if (r3 == 0) goto L59
            r7.f4207g = r0
            long r0 = java.lang.System.currentTimeMillis()
            r7.f4208h = r0
            int r0 = r7.f4207g
            long r0 = (long) r0
            r7.m11948a(r0)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p080c.C0952a.m11940c():void");
    }

    /* renamed from: a */
    public int m11946a(BDNotifyListener bDNotifyListener) {
        if (this.f4201a == null) {
            this.f4201a = new ArrayList<>();
        }
        this.f4201a.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.f4214n) {
            this.f4206f.registerReceiver(this.f4212l, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"), "android.permission.ACCESS_FINE_LOCATION", null);
            this.f4214n = true;
        }
        if (bDNotifyListener.mCoorType == null) {
            return 1;
        }
        if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.f4203c == null || System.currentTimeMillis() - this.f4204d > 30000) {
            this.f4205e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f4203c.getLatitude(), this.f4203c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f4203c.getRadius();
            if (radius > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                if (radius < this.f4202b) {
                    this.f4202b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f4203c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f4209i = true;
                }
            }
        }
        m11940c();
        return 1;
    }

    /* renamed from: a */
    public void m11949a() {
        PendingIntent pendingIntent = this.f4210j;
        if (pendingIntent != null) {
            this.f4211k.cancel(pendingIntent);
        }
        this.f4203c = null;
        this.f4204d = 0L;
        if (this.f4214n) {
            this.f4206f.unregisterReceiver(this.f4212l);
        }
        this.f4214n = false;
    }

    /* renamed from: b */
    public void m11942b(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType == null) {
            return;
        }
        if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
            double[] coorEncrypt = Jni.coorEncrypt(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
            bDNotifyListener.mLongitudeC = coorEncrypt[0];
            bDNotifyListener.mLatitudeC = coorEncrypt[1];
        }
        if (this.f4203c == null || System.currentTimeMillis() - this.f4204d > 300000) {
            this.f4205e.requestNotifyLocation();
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(this.f4203c.getLatitude(), this.f4203c.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
            float radius = (fArr[0] - bDNotifyListener.mRadius) - this.f4203c.getRadius();
            if (radius > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                if (radius < this.f4202b) {
                    this.f4202b = radius;
                }
            } else if (bDNotifyListener.Notified < 3) {
                bDNotifyListener.Notified++;
                bDNotifyListener.onNotify(this.f4203c, fArr[0]);
                if (bDNotifyListener.Notified < 3) {
                    this.f4209i = true;
                }
            }
        }
        m11940c();
    }

    /* renamed from: c */
    public int m11939c(BDNotifyListener bDNotifyListener) {
        PendingIntent pendingIntent;
        ArrayList<BDNotifyListener> arrayList = this.f4201a;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.contains(bDNotifyListener)) {
            this.f4201a.remove(bDNotifyListener);
        }
        if (this.f4201a.size() != 0 || (pendingIntent = this.f4210j) == null) {
            return 1;
        }
        this.f4211k.cancel(pendingIntent);
        return 1;
    }
}
