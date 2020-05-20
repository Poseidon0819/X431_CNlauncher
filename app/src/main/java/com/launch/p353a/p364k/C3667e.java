package com.launch.p353a.p364k;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.p012v4.app.ActivityCompat;
import android.util.Log;

/* compiled from: LocationUtils.java */
/* renamed from: com.launch.a.k.e */
/* loaded from: classes.dex */
public final class C3667e {

    /* renamed from: a */
    public static double f19969a;

    /* renamed from: b */
    public static double f19970b;

    /* renamed from: c */
    static LocationListener f19971c = new C3668f();

    /* renamed from: a */
    public static void m2636a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Location location = null;
        for (String str : locationManager.getProviders(true)) {
            if (ActivityCompat.m14915a(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.m14915a(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str);
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        if (location != null) {
            f19969a = location.getLatitude();
            f19970b = location.getLongitude();
        }
        StringBuilder sb = new StringBuilder("loc==");
        sb.append(f19969a);
        sb.append("==");
        sb.append(f19970b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2635a(Location location) {
        f19970b = location.getLongitude();
        f19969a = location.getLatitude();
        Log.e("经纬度信息：", f19970b + "  " + f19969a);
    }
}
