package com.cnlaunch.p135g;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.cnlaunch.p135g.p136a.LocationInfo;
import com.cnlaunch.p135g.p137b.LatLngUtils;
import com.cnlaunch.p135g.p137b.LocalUtils;

/* compiled from: MobileLocationLogic.java */
/* renamed from: com.cnlaunch.g.g */
/* loaded from: classes.dex */
final class C1481g implements LocationListener {

    /* renamed from: a */
    final /* synthetic */ MobileLocationLogic f7311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1481g(MobileLocationLogic mobileLocationLogic) {
        this.f7311a = mobileLocationLogic;
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        Log.e("msp", "onStatusChanged");
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        Log.e("msp", "onProviderEnabled");
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        Log.e("msp", "onProviderDisabled");
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        LatLng m9424a;
        Log.e("msp", "onLocationChanged");
        if (location == null) {
            return;
        }
        if (this.f7311a.f7300a == null || (this.f7311a.f7304e != null && this.f7311a.f7304e.f7299a)) {
            this.f7311a.m9422a();
            return;
        }
        this.f7311a.f7302c++;
        Location location2 = this.f7311a.f7301b;
        boolean z = false;
        if (location2 != null && location != null) {
            Log.i("msp", "distance ".concat(String.valueOf(location2.distanceTo(location))));
            if (location2.distanceTo(location) < 80.0f) {
                z = true;
            }
        }
        if (z || this.f7311a.f7302c >= 0) {
            LocationInfo locationInfo = new LocationInfo();
            if (LocalUtils.m9423a()) {
                locationInfo.setLocationType(LocationInfo.LOCATION_TYPE_BAIDU);
                if (location == null) {
                    m9424a = null;
                } else {
                    LocationInfo locationInfo2 = new LocationInfo();
                    locationInfo2.setLat(location.getLatitude());
                    locationInfo2.setLon(location.getLongitude());
                    m9424a = LatLngUtils.m9424a(locationInfo2);
                }
                locationInfo.setLat(m9424a.latitude);
                locationInfo.setLon(m9424a.longitude);
            } else {
                locationInfo.setLocationType(LocationInfo.LOCATION_TYPE_ST);
                locationInfo.setLat(location.getLatitude());
                locationInfo.setLon(location.getLongitude());
            }
            Log.e("msp", "MobileLocation:" + locationInfo.getLat() + "  " + locationInfo.getLon() + "  " + locationInfo.getLocationType());
            if (this.f7311a.f7300a != null) {
                this.f7311a.f7300a.mo5399a(locationInfo);
            }
            if (this.f7311a.f7304e != null) {
                this.f7311a.f7304e.f7299a = true;
            }
            MyLocationLogic.m9420a().m9418a(this.f7311a.f7303d, locationInfo);
            this.f7311a.m9422a();
            return;
        }
        this.f7311a.f7301b = location;
    }
}
