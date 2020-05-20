package com.baidu.location.p082e;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1026d;
import com.baidu.location.p078a.C0892a;
import com.baidu.location.p078a.C0900d;
import com.baidu.location.p078a.C0904e;
import com.baidu.location.p078a.C0930n;
import com.baidu.location.p078a.C0932p;
import com.baidu.location.p079b.C0941d;
import com.baidu.location.p084g.C1005a;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1008d;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.e.d */
/* loaded from: classes.dex */
public class C0991d {

    /* renamed from: C */
    private static double f4403C = 100.0d;

    /* renamed from: D */
    private static String f4404D = "";

    /* renamed from: c */
    private static C0991d f4405c;

    /* renamed from: m */
    private static int f4406m;

    /* renamed from: n */
    private static int f4407n;

    /* renamed from: u */
    private static String f4408u;

    /* renamed from: A */
    private int f4409A;

    /* renamed from: B */
    private int f4410B;

    /* renamed from: d */
    private Context f4415d;

    /* renamed from: f */
    private Location f4417f;

    /* renamed from: i */
    private GpsStatus f4420i;

    /* renamed from: j */
    private C0993a f4421j;

    /* renamed from: k */
    private boolean f4422k;

    /* renamed from: a */
    private final long f4413a = 1000;

    /* renamed from: b */
    private final long f4414b = 9000;

    /* renamed from: e */
    private LocationManager f4416e = null;

    /* renamed from: g */
    private C0995c f4418g = null;

    /* renamed from: h */
    private C0996d f4419h = null;

    /* renamed from: l */
    private C0994b f4423l = null;

    /* renamed from: o */
    private long f4424o = 0;

    /* renamed from: p */
    private boolean f4425p = false;

    /* renamed from: q */
    private boolean f4426q = false;

    /* renamed from: r */
    private String f4427r = null;

    /* renamed from: s */
    private boolean f4428s = false;

    /* renamed from: t */
    private long f4429t = 0;

    /* renamed from: v */
    private Handler f4430v = null;

    /* renamed from: w */
    private final int f4431w = 1;

    /* renamed from: x */
    private final int f4432x = 2;

    /* renamed from: y */
    private final int f4433y = 3;

    /* renamed from: z */
    private final int f4434z = 4;

    /* renamed from: E */
    private long f4411E = 0;

    /* renamed from: F */
    private ArrayList<ArrayList<Float>> f4412F = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    /* renamed from: com.baidu.location.e.d$a */
    /* loaded from: classes.dex */
    public class C0993a extends GnssStatus.Callback {
        private C0993a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (C0991d.this.f4416e == null) {
                return;
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            C0991d.this.f4412F.clear();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < satelliteCount; i3++) {
                ArrayList arrayList = new ArrayList();
                if (gnssStatus.usedInFix(i3)) {
                    i++;
                    if (gnssStatus.getConstellationType(i3) == 1) {
                        i2++;
                        arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i3)));
                        arrayList.add(Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO));
                        arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i3)));
                        arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i3)));
                        arrayList.add(Float.valueOf(1.0f));
                    }
                    C0991d.this.f4412F.add(arrayList);
                }
            }
            int unused = C0991d.f4406m = i;
            int unused2 = C0991d.f4407n = i2;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            C0991d.this.m11676d((Location) null);
            C0991d.this.m11681b(false);
            int unused = C0991d.f4406m = 0;
            int unused2 = C0991d.f4407n = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.e.d$b */
    /* loaded from: classes.dex */
    public class C0994b implements GpsStatus.Listener {

        /* renamed from: a */
        long f4437a;

        /* renamed from: c */
        private long f4439c;

        /* renamed from: d */
        private final int f4440d;

        /* renamed from: e */
        private boolean f4441e;

        /* renamed from: f */
        private List<String> f4442f;

        /* renamed from: g */
        private String f4443g;

        /* renamed from: h */
        private String f4444h;

        /* renamed from: i */
        private String f4445i;

        /* renamed from: j */
        private long f4446j;

        private C0994b() {
            this.f4437a = 0L;
            this.f4439c = 0L;
            this.f4440d = 400;
            this.f4441e = false;
            this.f4442f = new ArrayList();
            this.f4443g = null;
            this.f4444h = null;
            this.f4445i = null;
            this.f4446j = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (C0991d.this.f4416e == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                C0991d.this.m11676d((Location) null);
                C0991d.this.m11681b(false);
                int unused = C0991d.f4406m = 0;
                int unused2 = C0991d.f4407n = 0;
            } else if (i == 4 && C0991d.this.f4426q) {
                try {
                    if (C0991d.this.f4420i == null) {
                        C0991d.this.f4420i = C0991d.this.f4416e.getGpsStatus(null);
                    } else {
                        C0991d.this.f4416e.getGpsStatus(C0991d.this.f4420i);
                    }
                    C0991d.this.f4409A = 0;
                    C0991d.this.f4410B = 0;
                    double d = 0.0d;
                    C0991d.this.f4412F.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : C0991d.this.f4420i.getSatellites()) {
                        ArrayList arrayList = new ArrayList();
                        if (gpsSatellite.usedInFix()) {
                            i3++;
                            if (gpsSatellite.getPrn() <= 65) {
                                i2++;
                                double snr = gpsSatellite.getSnr();
                                Double.isNaN(snr);
                                d += snr;
                                arrayList.add(Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO));
                                arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                                arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                                arrayList.add(Float.valueOf(1.0f));
                            }
                            C0991d.this.f4412F.add(arrayList);
                            if (gpsSatellite.getSnr() >= C1016g.f4543G) {
                                C0991d.m11670f(C0991d.this);
                            }
                        }
                    }
                    if (i2 > 0) {
                        int unused3 = C0991d.f4407n = i2;
                        double d2 = i2;
                        Double.isNaN(d2);
                        double unused4 = C0991d.f4403C = d / d2;
                    }
                    if (i3 > 0) {
                        this.f4446j = System.currentTimeMillis();
                        int unused5 = C0991d.f4406m = i3;
                    } else if (System.currentTimeMillis() - this.f4446j > 100) {
                        this.f4446j = System.currentTimeMillis();
                        int unused6 = C0991d.f4406m = i3;
                    }
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.e.d$c */
    /* loaded from: classes.dex */
    public class C0995c implements LocationListener {
        private C0995c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            C0991d.this.f4429t = System.currentTimeMillis();
            C0991d.this.m11681b(true);
            C0991d.this.m11676d(location);
            C0991d.this.f4425p = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            C0991d.this.m11676d((Location) null);
            C0991d.this.m11681b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    C0991d.this.m11676d((Location) null);
                    break;
                case 1:
                    C0991d.this.f4424o = System.currentTimeMillis();
                    C0991d.this.f4425p = true;
                    break;
                case 2:
                    C0991d.this.f4425p = false;
                    return;
                default:
                    return;
            }
            C0991d.this.m11681b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.e.d$d */
    /* loaded from: classes.dex */
    public class C0996d implements LocationListener {

        /* renamed from: b */
        private long f4449b;

        private C0996d() {
            this.f4449b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!C0991d.this.f4426q && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.f4449b >= 10000 && C0932p.m12042a(location, false)) {
                this.f4449b = System.currentTimeMillis();
                C0991d.this.f4430v.sendMessage(C0991d.this.f4430v.obtainMessage(4, location));
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private C0991d() {
        this.f4422k = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.f4422k = true;
            } catch (ClassNotFoundException unused) {
                this.f4422k = false;
            }
        }
    }

    /* renamed from: a */
    public static synchronized C0991d m11704a() {
        C0991d c0991d;
        synchronized (C0991d.class) {
            if (f4405c == null) {
                f4405c = new C0991d();
            }
            c0991d = f4405c;
        }
        return c0991d;
    }

    /* renamed from: a */
    public static String m11700a(Location location) {
        if (location == null) {
            return null;
        }
        double speed = location.getSpeed();
        Double.isNaN(speed);
        float f = (float) (speed * 3.6d);
        if (!location.hasSpeed()) {
            f = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(f), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(f4406m), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f4406m), Integer.valueOf(f4407n), Double.valueOf(f4403C));
    }

    /* renamed from: a */
    private void m11702a(double d, double d2, float f) {
        if (C0941d.m11996a().f4164f) {
            int i = 0;
            if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
                int i2 = (int) ((d - C1016g.f4609s) * 1000.0d);
                int i3 = (int) ((C1016g.f4610t - d2) * 1000.0d);
                if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                    C1016g.f4607q = d;
                    C1016g.f4608r = d2;
                    C0941d.m11996a().m11992a(String.format(Locale.CHINA, "&ll=%.5f|%.5f", Double.valueOf(d), Double.valueOf(d2)) + "&im=" + C1006b.m11603a().m11598b());
                } else {
                    int i4 = (i3 * 50) + i2;
                    int i5 = i4 >> 2;
                    int i6 = i4 & 3;
                    if (C1016g.f4613w) {
                        i = (C1016g.f4612v[i5] >> (i6 * 2)) & 3;
                    }
                }
            }
            if (C1016g.f4611u != i) {
                C1016g.f4611u = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11691a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + C0892a.m12261a().m12242f();
        boolean m11630f = C0998f.m11640a().m11630f();
        C0930n.m12054a(new C0986a(C0987b.m11732a().m11715f()));
        C0930n.m12056a(System.currentTimeMillis());
        C0930n.m12055a(new Location(location));
        C0930n.m12053a(str2);
        if (m11630f) {
            return;
        }
        C0932p.m12041a(C0930n.m12051c(), null, C0930n.m12050d(), str2);
    }

    /* renamed from: a */
    public static boolean m11699a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((C1016g.f4611u != 3 && C1008d.m11585a().m11583a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > C1016g.f4547K ? distanceTo > C1016g.f4549M : speed > C1016g.f4546J ? distanceTo > C1016g.f4548L : distanceTo > 5.0f;
        }
        return true;
    }

    /* renamed from: b */
    public static String m11687b(Location location) {
        String m11700a = m11700a(location);
        if (m11700a != null) {
            return m11700a + "&g_tp=0";
        }
        return m11700a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11681b(boolean z) {
        this.f4428s = z;
        if (!z || !m11666j()) {
        }
    }

    /* renamed from: c */
    public static String m11679c(Location location) {
        String m11700a = m11700a(location);
        if (m11700a != null) {
            return m11700a + f4408u;
        }
        return m11700a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11676d(Location location) {
        this.f4430v.sendMessage(this.f4430v.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m11673e(Location location) {
        Location location2;
        if (location == null) {
            this.f4417f = null;
            return;
        }
        int i = f4406m;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (i != 0 || C1016g.f4602l) {
            this.f4417f = location;
            int i2 = f4406m;
            Location location3 = this.f4417f;
            if (location3 == null) {
                this.f4427r = null;
                location2 = null;
            } else {
                location2 = new Location(location3);
                long currentTimeMillis = System.currentTimeMillis();
                this.f4417f.setTime(currentTimeMillis);
                double speed = this.f4417f.getSpeed();
                Double.isNaN(speed);
                float f = !this.f4417f.hasSpeed() ? -1.0f : (float) (speed * 3.6d);
                if (i2 == 0) {
                    try {
                        i2 = this.f4417f.getExtras().getInt("satellites");
                    } catch (Exception unused2) {
                    }
                }
                this.f4427r = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.f4417f.getLongitude()), Double.valueOf(this.f4417f.getLatitude()), Float.valueOf(f), Float.valueOf(this.f4417f.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                m11702a(this.f4417f.getLongitude(), this.f4417f.getLatitude(), f);
            }
            try {
                C0904e.m12178a().m12175a(this.f4417f);
            } catch (Exception unused3) {
            }
            if (location2 != null) {
                C0900d.m12208a().m12206a(location2);
            }
            if (!m11666j() || this.f4417f == null) {
                return;
            }
            f4404D = m11665k();
            if (!C1026d.m11499a().m11455g() || C1026d.m11499a().m11496a(this.f4417f)) {
                C1026d.m11499a().m11455g();
            }
            C0892a.m12261a().m12254a(m11669g());
            if (f4406m <= 2 || !C0932p.m12042a(this.f4417f, true)) {
                return;
            }
            boolean m11630f = C0998f.m11640a().m11630f();
            C0930n.m12054a(new C0986a(C0987b.m11732a().m11715f()));
            C0930n.m12056a(System.currentTimeMillis());
            C0930n.m12055a(new Location(this.f4417f));
            C0930n.m12053a(C0892a.m12261a().m12242f());
            if (m11630f) {
                return;
            }
            C0932p.m12041a(C0930n.m12051c(), null, C0930n.m12050d(), C0892a.m12261a().m12242f());
        }
    }

    /* renamed from: f */
    static /* synthetic */ int m11670f(C0991d c0991d) {
        int i = c0991d.f4410B;
        c0991d.f4410B = i + 1;
        return i;
    }

    /* renamed from: k */
    private String m11665k() {
        StringBuilder sb = new StringBuilder();
        if (this.f4412F.size() > 32 || this.f4412F.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = this.f4412F.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 5) {
                if (z) {
                    z = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f", next.get(4)));
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m11690a(boolean z) {
        if (z) {
            m11680c();
        } else {
            m11677d();
        }
    }

    /* renamed from: b */
    public synchronized void m11689b() {
        if (ServiceC1002f.isServing) {
            this.f4415d = ServiceC1002f.getServiceContext();
            try {
                this.f4416e = (LocationManager) this.f4415d.getSystemService("location");
                if (this.f4422k) {
                    this.f4421j = new C0993a();
                    this.f4416e.registerGnssStatusCallback(this.f4421j);
                } else {
                    this.f4423l = new C0994b();
                    this.f4416e.addGpsStatusListener(this.f4423l);
                }
                this.f4419h = new C0996d();
                this.f4416e.requestLocationUpdates("passive", 9000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f4419h);
            } catch (Exception unused) {
            }
            this.f4430v = new Handler() { // from class: com.baidu.location.e.d.1
                @Override // android.os.Handler
                public void handleMessage(Message message2) {
                    if (ServiceC1002f.isServing) {
                        int i = message2.what;
                        if (i == 1) {
                            C0991d.this.m11673e((Location) message2.obj);
                            return;
                        }
                        switch (i) {
                            case 3:
                                C0991d.this.m11691a("&og=1", (Location) message2.obj);
                                return;
                            case 4:
                                C0991d.this.m11691a("&og=2", (Location) message2.obj);
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
        }
    }

    /* renamed from: c */
    public void m11680c() {
        Log.d(C1005a.f4481a, "start gps...");
        if (this.f4426q) {
            return;
        }
        try {
            this.f4418g = new C0995c();
            try {
                this.f4416e.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused) {
            }
            this.f4416e.requestLocationUpdates("gps", 1000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f4418g);
            this.f4411E = System.currentTimeMillis();
            this.f4426q = true;
        } catch (Exception unused2) {
        }
    }

    /* renamed from: d */
    public void m11677d() {
        if (this.f4426q) {
            LocationManager locationManager = this.f4416e;
            if (locationManager != null) {
                try {
                    if (this.f4418g != null) {
                        locationManager.removeUpdates(this.f4418g);
                    }
                } catch (Exception unused) {
                }
            }
            C1016g.f4594d = 0;
            C1016g.f4611u = 0;
            this.f4418g = null;
            this.f4426q = false;
            m11681b(false);
        }
    }

    /* renamed from: e */
    public synchronized void m11674e() {
        m11677d();
        if (this.f4416e == null) {
            return;
        }
        try {
            if (this.f4423l != null) {
                this.f4416e.removeGpsStatusListener(this.f4423l);
            }
            if (this.f4422k && this.f4421j != null) {
                this.f4416e.unregisterGnssStatusCallback(this.f4421j);
            }
            this.f4416e.removeUpdates(this.f4419h);
        } catch (Exception unused) {
        }
        this.f4423l = null;
        this.f4416e = null;
    }

    /* renamed from: f */
    public String m11671f() {
        Location location;
        if (!m11666j() || (location = this.f4417f) == null) {
            return null;
        }
        return String.format("%s&idgps_tp=%s", m11700a(location).replaceAll("ll", "idll").replaceAll("&d=", "&idd=").replaceAll("&s", "&ids="), this.f4417f.getProvider());
    }

    /* renamed from: g */
    public String m11669g() {
        boolean z;
        StringBuilder sb;
        String str;
        if (this.f4417f != null) {
            String str2 = "{\"result\":{\"time\":\"" + C1016g.m11572a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.f4417f.hasAccuracy() ? this.f4417f.getAccuracy() : 10.0f);
            double speed = this.f4417f.getSpeed();
            Double.isNaN(speed);
            float f = (float) (speed * 3.6d);
            if (!this.f4417f.hasSpeed()) {
                f = -1.0f;
            }
            double[] dArr = new double[2];
            if (C1008d.m11585a().m11583a(this.f4417f.getLongitude(), this.f4417f.getLatitude())) {
                dArr = Jni.coorEncrypt(this.f4417f.getLongitude(), this.f4417f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                    dArr[0] = this.f4417f.getLongitude();
                    dArr[1] = this.f4417f.getLatitude();
                }
                z = true;
            } else {
                dArr[0] = this.f4417f.getLongitude();
                dArr[1] = this.f4417f.getLatitude();
                z = false;
            }
            String format = String.format(Locale.CHINA, str2, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.f4417f.getBearing()), Float.valueOf(f), Integer.valueOf(f4406m));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            if (this.f4417f.hasAltitude()) {
                sb = new StringBuilder();
                sb.append(format);
                str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.f4417f.getAltitude()));
            } else {
                sb = new StringBuilder();
                sb.append(format);
                str = "}}";
            }
            sb.append(str);
            return sb.toString();
        }
        return null;
    }

    /* renamed from: h */
    public Location m11668h() {
        if (this.f4417f != null && Math.abs(System.currentTimeMillis() - this.f4417f.getTime()) <= 60000) {
            return this.f4417f;
        }
        return null;
    }

    /* renamed from: i */
    public boolean m11667i() {
        try {
            if (this.f4417f != null && this.f4417f.getLatitude() != 0.0d && this.f4417f.getLongitude() != 0.0d) {
                if (f4406m <= 2) {
                    if (this.f4417f.getExtras().getInt("satellites", 3) > 2) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception unused) {
            Location location = this.f4417f;
            return (location == null || location.getLatitude() == 0.0d || this.f4417f.getLongitude() == 0.0d) ? false : true;
        }
    }

    /* renamed from: j */
    public boolean m11666j() {
        if (m11667i() && System.currentTimeMillis() - this.f4429t <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f4425p || currentTimeMillis - this.f4424o >= 3000) {
                return this.f4428s;
            }
            return true;
        }
        return false;
    }
}
