package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class AreaUtil {
    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            LatLng latLng3 = new LatLng(latLng.latitude, latLng2.longitude);
            double distance = DistanceUtil.getDistance(latLng3, latLng2);
            double distance2 = DistanceUtil.getDistance(latLng, latLng3);
            if (distance != 0.0d && distance2 != 0.0d) {
                return distance * distance2;
            }
        }
        return 0.0d;
    }
}
