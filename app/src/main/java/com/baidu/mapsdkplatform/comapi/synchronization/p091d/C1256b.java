package com.baidu.mapsdkplatform.comapi.synchronization.p091d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.d.b */
/* loaded from: classes.dex */
public class C1256b {
    /* renamed from: a */
    public static double m10451a(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            Point ll2point = CoordUtil.ll2point(latLng);
            Point ll2point2 = CoordUtil.ll2point(latLng2);
            if (ll2point != null && ll2point2 != null) {
                return CoordUtil.getDistance(ll2point, ll2point2);
            }
        }
        return -1.0d;
    }
}
