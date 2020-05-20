package com.cnlaunch.p135g;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.cnlaunch.p135g.p136a.LocationInfo;
import com.cnlaunch.p135g.p137b.LocalUtils;
import com.itextpdf.text.pdf.ColumnText;

/* compiled from: BLocationLogic.java */
/* renamed from: com.cnlaunch.g.c */
/* loaded from: classes.dex */
final class C1479c extends BDAbstractLocationListener {

    /* renamed from: a */
    final /* synthetic */ BLocationLogic f7298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1479c(BLocationLogic bLocationLogic) {
        this.f7298a = bLocationLogic;
    }

    @Override // com.baidu.location.BDAbstractLocationListener
    public final void onReceiveLocation(BDLocation bDLocation) {
        if (this.f7298a.f7289b == null || (this.f7298a.f7292e != null && this.f7298a.f7292e.f7299a)) {
            this.f7298a.m9426a();
            return;
        }
        this.f7298a.f7291d++;
        if (bDLocation == null) {
            return;
        }
        int locType = bDLocation.getLocType();
        if (locType == 61 || locType == 161 || locType == 66) {
            if ((bDLocation.getRadius() <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || bDLocation.getRadius() > 30.0f) && this.f7298a.f7291d < 0) {
                return;
            }
            LocationInfo locationInfo = new LocationInfo();
            if (bDLocation.getLocationWhere() == 1) {
                locationInfo.setLocationType(LocationInfo.LOCATION_TYPE_BAIDU);
            } else if (bDLocation.getLocationWhere() != 0 && LocalUtils.m9423a()) {
                locationInfo.setLocationType(LocationInfo.LOCATION_TYPE_BAIDU);
            } else {
                locationInfo.setLocationType(LocationInfo.LOCATION_TYPE_ST);
            }
            locationInfo.setLat(bDLocation.getLatitude());
            locationInfo.setLon(bDLocation.getLongitude());
            locationInfo.setLocationAddress(bDLocation.getAddrStr());
            locationInfo.setCity(bDLocation.getCity());
            locationInfo.setCountry(bDLocation.getCountry());
            locationInfo.setProvince(bDLocation.getProvince());
            locationInfo.setDistrict(bDLocation.getDistrict());
            locationInfo.setStreet(bDLocation.getStreet());
            locationInfo.setStreetNumber(bDLocation.getStreetNumber());
            if (this.f7298a.f7289b != null) {
                this.f7298a.f7289b.mo5399a(locationInfo);
            }
            if (this.f7298a.f7292e != null) {
                this.f7298a.f7292e.f7299a = true;
            }
            MyLocationLogic.m9420a().m9418a(this.f7298a.f7290c, locationInfo);
            this.f7298a.m9426a();
        }
    }
}
