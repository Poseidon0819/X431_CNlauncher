package com.cnlaunch.p135g;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import com.cnlaunch.p135g.MyLocationLogic;
import com.itextpdf.text.pdf.ColumnText;
import java.util.List;
import java.util.Timer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.cnlaunch.g.e */
/* loaded from: classes.dex */
public final class MobileLocationLogic {

    /* renamed from: a */
    MyLocationLogic.InterfaceC1482a f7300a;

    /* renamed from: b */
    Location f7301b;

    /* renamed from: c */
    int f7302c;

    /* renamed from: d */
    Context f7303d;

    /* renamed from: e */
    LocationSuccessIndicator f7304e;

    /* renamed from: g */
    private LocationManager f7306g;

    /* renamed from: i */
    private Timer f7308i;

    /* renamed from: h */
    private String f7307h = "gps";

    /* renamed from: j */
    private long f7309j = 180000;

    /* renamed from: f */
    LocationListener f7305f = new C1481g(this);

    /* renamed from: a */
    public final synchronized void m9421a(Context context, MyLocationLogic.InterfaceC1482a interfaceC1482a, LocationSuccessIndicator locationSuccessIndicator) {
        m9422a();
        this.f7303d = context;
        this.f7300a = interfaceC1482a;
        this.f7304e = locationSuccessIndicator;
        this.f7301b = null;
        this.f7302c = 0;
        if (context != null) {
            this.f7306g = (LocationManager) context.getSystemService("location");
            if (this.f7306g != null) {
                List<String> allProviders = this.f7306g.getAllProviders();
                if (allProviders.contains("gps") && this.f7306g.isProviderEnabled("gps")) {
                    this.f7307h = "gps";
                    this.f7306g.requestLocationUpdates(this.f7307h, 1000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f7305f);
                } else if (allProviders.contains("network") && this.f7306g.isProviderEnabled("network")) {
                    this.f7307h = "network";
                    this.f7306g.requestLocationUpdates(this.f7307h, 1000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f7305f);
                } else if (allProviders != null && !allProviders.isEmpty()) {
                    this.f7307h = allProviders.get(0);
                    this.f7306g.requestLocationUpdates(this.f7307h, 1000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f7305f);
                }
                this.f7308i = new Timer();
                this.f7308i.schedule(new C1480f(this), this.f7309j);
            } else if (interfaceC1482a != null) {
                interfaceC1482a.mo5400a();
            }
        } else if (interfaceC1482a != null) {
            interfaceC1482a.mo5400a();
        }
    }

    /* renamed from: a */
    public final synchronized void m9422a() {
        Log.e("msp", "stopLocation");
        try {
            if (this.f7306g != null) {
                this.f7306g.removeUpdates(this.f7305f);
                this.f7306g = null;
            }
            if (this.f7300a != null) {
                this.f7300a = null;
            }
            if (this.f7308i != null) {
                this.f7308i.cancel();
                this.f7308i = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
