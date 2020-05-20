package com.cnlaunch.gmap.map.p145a.p146a;

import android.content.Context;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.cnlaunch.gmap.map.a.a.f */
/* loaded from: classes.dex */
public final class LocationSearch {

    /* renamed from: a */
    private static LocationSearch f7496a;

    /* renamed from: b */
    private LocationInterface f7497b;

    /* compiled from: LocationSearch.java */
    /* renamed from: com.cnlaunch.gmap.map.a.a.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1517a {
        /* renamed from: a */
        void mo6551a(LocationResult locationResult);
    }

    /* renamed from: a */
    public static LocationSearch m9324a() {
        if (f7496a == null) {
            f7496a = new LocationSearch();
        }
        return f7496a;
    }

    /* renamed from: a */
    public final void m9323a(Context context, LcLatlng lcLatlng, InterfaceC1517a interfaceC1517a) {
        LatLng latLng = new LatLng(lcLatlng.latitude, lcLatlng.longitude);
        if (this.f7497b == null) {
            this.f7497b = new LocationInterface(context);
        }
        new Thread(new RunnableC1513b(this.f7497b, latLng, interfaceC1517a)).start();
    }

    /* renamed from: a */
    public final void m9322a(Context context, LcLatlng lcLatlng, String str, InterfaceC1517a interfaceC1517a) {
        if (this.f7497b == null) {
            this.f7497b = new LocationInterface(context);
        }
        this.f7497b.m9330a(lcLatlng.getLatitude(), lcLatlng.getLongitude(), str, interfaceC1517a);
    }
}
