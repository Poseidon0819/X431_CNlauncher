package com.cnlaunch.gmap.map.p150b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.os.RemoteException;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p150b.GoloMapListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.InterfaceC3209b;
import com.google.android.gms.internal.C3265ao;
import com.google.android.gms.internal.C3268ap;
import com.google.android.gms.internal.C3353u;
import com.google.android.gms.location.C3361c;
import com.google.android.gms.location.InterfaceC3362d;
import com.google.android.gms.location.LocationRequest;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.gmap.map.b.j */
/* loaded from: classes.dex */
public class LocationLogic implements InterfaceC3209b.InterfaceC3210a, InterfaceC3209b.InterfaceC3211b, InterfaceC3362d {

    /* renamed from: a */
    LcLatlng f7562a;

    /* renamed from: c */
    public Context f7564c;

    /* renamed from: d */
    public boolean f7565d;

    /* renamed from: e */
    public GoloMapListener.InterfaceC1528b f7566e;

    /* renamed from: f */
    C3361c f7567f;

    /* renamed from: i */
    private LocationRequest f7570i;

    /* renamed from: j */
    private LocationManager f7571j;

    /* renamed from: b */
    LocationResult f7563b = null;

    /* renamed from: g */
    boolean f7568g = false;

    /* renamed from: h */
    LocationListener f7569h = new C1531k(this);

    /* renamed from: b */
    private void m9296b(Context context) {
        if (context != null) {
            this.f7571j = (LocationManager) context.getSystemService("location");
            if (this.f7571j.getAllProviders().contains("network")) {
                this.f7571j.requestLocationUpdates("network", 1000L, 10.0f, this.f7569h);
                return;
            }
            this.f7563b = new LocationResult();
            try {
                this.f7563b.setCode(1);
                if (this.f7566e != null) {
                    this.f7566e.mo6552a(1, this.f7563b);
                }
            } catch (Exception unused) {
                GoloMapListener.InterfaceC1528b interfaceC1528b = this.f7566e;
                if (interfaceC1528b != null) {
                    interfaceC1528b.mo6552a(1, null);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m9298a(Context context) {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0;
    }

    /* renamed from: g */
    private boolean m9294g() {
        Context context = this.f7564c;
        if (context != null && GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            Context context2 = this.f7564c;
            this.f7570i = LocationRequest.m3122a();
            LocationRequest locationRequest = this.f7570i;
            LocationRequest.m3121a(2000L);
            locationRequest.f19212c = 2000L;
            if (!locationRequest.f19214e) {
                double d = locationRequest.f19212c;
                Double.isNaN(d);
                locationRequest.f19213d = (long) (d / 6.0d);
            }
            LocationRequest locationRequest2 = this.f7570i;
            LocationRequest.m3121a(1000L);
            locationRequest2.f19214e = true;
            locationRequest2.f19213d = 1000L;
            LocationRequest locationRequest3 = this.f7570i;
            LocationRequest.m3120b();
            locationRequest3.f19211b = 100;
            this.f7567f = new C3361c(context2, this, this);
            C3361c c3361c = this.f7567f;
            if (c3361c != null && !c3361c.f19218a.m3178d()) {
                try {
                    this.f7567f.f19218a.m3180c();
                } catch (Exception unused) {
                    GoloMapListener.InterfaceC1528b interfaceC1528b = this.f7566e;
                    if (interfaceC1528b != null) {
                        interfaceC1528b.mo6552a(1, null);
                    }
                }
            }
            new Thread(new RunnableC1532l(this)).start();
        } else {
            this.f7568g = false;
        }
        return this.f7568g;
    }

    /* renamed from: a */
    public final void m9299a() {
        this.f7565d = false;
        if (this.f7567f == null && !m9294g()) {
            this.f7568g = false;
            m9296b(this.f7564c);
        }
        C3361c c3361c = this.f7567f;
        if (c3361c == null || !this.f7568g) {
            this.f7568g = false;
            m9296b(this.f7564c);
        } else if (c3361c.f19218a.m3178d()) {
        } else {
            this.f7567f.f19218a.m3180c();
        }
    }

    /* renamed from: b */
    public final void m9297b() {
        C3361c c3361c = this.f7567f;
        if (c3361c == null || !c3361c.f19218a.m3178d()) {
            return;
        }
        this.f7567f.m3117a(this);
        this.f7567f.f19218a.mo3174f();
    }

    /* renamed from: c */
    public final void m9295c() {
        LocationManager locationManager = this.f7571j;
        if (locationManager != null) {
            locationManager.removeUpdates(this.f7569h);
            return;
        }
        C3361c c3361c = this.f7567f;
        if (c3361c != null && c3361c.f19218a.m3178d()) {
            m9297b();
            this.f7567f.f19218a.mo3174f();
        }
    }

    @Override // com.google.android.gms.common.InterfaceC3209b.InterfaceC3211b
    /* renamed from: d */
    public final void mo3466d() {
        this.f7563b = new LocationResult();
        try {
            this.f7563b.setCode(1);
            if (this.f7566e != null) {
                this.f7566e.mo6552a(1, this.f7563b);
            }
        } catch (Exception unused) {
            GoloMapListener.InterfaceC1528b interfaceC1528b = this.f7566e;
            if (interfaceC1528b != null) {
                interfaceC1528b.mo6552a(1, null);
            }
        }
    }

    @Override // com.google.android.gms.common.InterfaceC3209b.InterfaceC3210a
    /* renamed from: e */
    public final void mo3468e() {
        C3361c c3361c = this.f7567f;
        LocationRequest locationRequest = this.f7570i;
        C3268ap c3268ap = c3361c.f19218a;
        synchronized (c3268ap.f18811i) {
            C3265ao c3265ao = c3268ap.f18811i;
            c3265ao.f18804a.mo3263a();
            C3353u.m3130a(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
            synchronized (c3265ao.f18808e) {
                C3265ao.BinderC3267b binderC3267b = c3265ao.f18808e.get(this);
                if (binderC3267b == null) {
                    binderC3267b = new C3265ao.BinderC3267b(this);
                }
                c3265ao.f18808e.put(this, binderC3267b);
                try {
                    c3265ao.f18804a.mo3262b().mo3273a(locationRequest, binderC3267b, c3265ao.f18805b.getPackageName());
                } catch (RemoteException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    @Override // com.google.android.gms.common.InterfaceC3209b.InterfaceC3210a
    /* renamed from: f */
    public final void mo3467f() {
        this.f7563b = new LocationResult();
        try {
            this.f7563b.setCode(1);
            if (this.f7566e != null) {
                this.f7566e.mo6552a(1, this.f7563b);
            }
        } catch (Exception unused) {
            GoloMapListener.InterfaceC1528b interfaceC1528b = this.f7566e;
            if (interfaceC1528b != null) {
                interfaceC1528b.mo6552a(1, null);
            }
        }
    }

    @Override // com.google.android.gms.location.InterfaceC3362d
    /* renamed from: a */
    public final void mo3116a(Location location) {
        this.f7563b = new LocationResult();
        try {
            this.f7563b.setCode(0);
            this.f7562a = new LcLatlng(location.getLatitude(), location.getLongitude());
            this.f7563b.setLclatlng(this.f7562a);
            this.f7563b.setRadius(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            this.f7563b.setAddress(null);
            this.f7563b.setCityCode(null);
            this.f7563b.setCityName(null);
            this.f7563b.setProvince(null);
            this.f7563b.setDirection(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            this.f7563b.setCityCode(null);
            this.f7563b.setDirection(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            this.f7563b.setAltitude(location.getAltitude());
            this.f7563b.setSpeed(location.getSpeed());
            if (this.f7566e != null) {
                if (this.f7565d) {
                    return;
                }
                this.f7565d = true;
                this.f7566e.mo6552a(0, this.f7563b);
            }
        } catch (Exception unused) {
            if (this.f7566e != null) {
                this.f7566e.mo6552a(1, null);
            }
        } finally {
            m9297b();
        }
    }
}
