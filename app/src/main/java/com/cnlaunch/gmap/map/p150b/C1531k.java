package com.cnlaunch.gmap.map.p150b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.itextpdf.text.pdf.ColumnText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationLogic.java */
/* renamed from: com.cnlaunch.gmap.map.b.k */
/* loaded from: classes.dex */
public final class C1531k implements LocationListener {

    /* renamed from: a */
    final /* synthetic */ LocationLogic f7572a;

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1531k(LocationLogic locationLogic) {
        this.f7572a = locationLogic;
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        if (this.f7572a.f7566e != null) {
            this.f7572a.f7566e.mo6552a(2, null);
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        this.f7572a.f7563b = new LocationResult();
        try {
            if (location == null) {
                this.f7572a.f7563b.setCode(1);
            } else {
                this.f7572a.f7562a = new LcLatlng(location.getLatitude(), location.getLongitude());
                this.f7572a.f7563b.setCode(0);
                this.f7572a.f7563b.setLclatlng(this.f7572a.f7562a);
                this.f7572a.f7563b.setRadius(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                this.f7572a.f7563b.setAddress(null);
                this.f7572a.f7563b.setCityCode(null);
                this.f7572a.f7563b.setCityName(null);
                this.f7572a.f7563b.setProvince(null);
                this.f7572a.f7563b.setDirection(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                this.f7572a.f7563b.setCityCode(null);
                this.f7572a.f7563b.setDirection(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                this.f7572a.f7563b.setAltitude(location.getAltitude());
                this.f7572a.f7563b.setSpeed(location.getSpeed());
            }
            if (this.f7572a.f7566e != null) {
                if (!this.f7572a.f7565d || location == null) {
                    this.f7572a.f7565d = true;
                    this.f7572a.f7566e.mo6552a(0, this.f7572a.f7563b);
                }
            }
        } catch (Exception unused) {
            if (this.f7572a.f7566e != null) {
                this.f7572a.f7566e.mo6552a(1, null);
            }
        }
    }
}
