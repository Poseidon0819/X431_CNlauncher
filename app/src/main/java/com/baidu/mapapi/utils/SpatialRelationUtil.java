package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;

/* loaded from: classes.dex */
public class SpatialRelationUtil {
    /* renamed from: a */
    private static LatLng m10931a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(latLng3);
        double sqrt = Math.sqrt(((ll2mc.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6())));
        double longitudeE6 = (((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc3.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc3.getLatitudeE6() - ll2mc.getLatitudeE6()))) / (sqrt * sqrt);
        return CoordUtil.mc2ll(new GeoPoint(ll2mc.getLatitudeE6() + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * longitudeE6), ll2mc.getLongitudeE6() + ((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * longitudeE6)));
    }

    public static LatLng getNearestPointFromLine(List<LatLng> list, LatLng latLng) {
        LatLng latLng2;
        LatLng latLng3 = null;
        if (list != null && list.size() != 0 && latLng != null) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                LatLng m10931a = m10931a(list.get(i), list.get(i2), latLng);
                if ((m10931a.latitude - list.get(i).latitude) * (m10931a.latitude - list.get(i2).latitude) > 0.0d || (m10931a.longitude - list.get(i).longitude) * (m10931a.longitude - list.get(i2).longitude) > 0.0d) {
                    latLng2 = DistanceUtil.getDistance(latLng, list.get(i)) < DistanceUtil.getDistance(latLng, list.get(i2)) ? list.get(i) : list.get(i2);
                } else {
                    latLng2 = m10931a;
                }
                if (latLng3 == null || DistanceUtil.getDistance(latLng, latLng2) < DistanceUtil.getDistance(latLng, latLng3)) {
                    latLng3 = latLng2;
                }
                i = i2;
            }
        }
        return latLng3;
    }

    public static boolean isCircleContainsPoint(LatLng latLng, int i, LatLng latLng2) {
        if (latLng == null || i == 0 || latLng2 == null) {
            return false;
        }
        double distance = DistanceUtil.getDistance(latLng, latLng2);
        double d = i;
        if (distance > d) {
            return false;
        }
        if (distance == d) {
        }
        return true;
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        if (list != null && list.size() != 0 && latLng != null) {
            for (int i = 0; i < list.size(); i++) {
                if (latLng.longitude == list.get(i).longitude && latLng.latitude == list.get(i).latitude) {
                    return true;
                }
            }
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                LatLng latLng2 = list.get(i2);
                i2++;
                LatLng latLng3 = list.get(i2 % size);
                if (latLng2.latitude != latLng3.latitude && latLng.latitude >= Math.min(latLng2.latitude, latLng3.latitude) && latLng.latitude <= Math.max(latLng2.latitude, latLng3.latitude)) {
                    double d = (((latLng.latitude - latLng2.latitude) * (latLng3.longitude - latLng2.longitude)) / (latLng3.latitude - latLng2.latitude)) + latLng2.longitude;
                    if (d == latLng.longitude) {
                        return true;
                    }
                    if (d < latLng.longitude) {
                        i3++;
                    }
                }
            }
            if (i3 % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
