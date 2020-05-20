package com.launch.p353a.p364k;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* compiled from: LocationUtils.java */
/* renamed from: com.launch.a.k.f */
/* loaded from: classes.dex */
final class C3668f implements LocationListener {
    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        C3667e.m2635a(location);
    }
}
