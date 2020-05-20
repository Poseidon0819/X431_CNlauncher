package com.cnlaunch.p135g.p137b;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.cnlaunch.p135g.p136a.LocationInfo;

/* renamed from: com.cnlaunch.g.b.a */
/* loaded from: classes.dex */
public final class LatLngUtils {
    /* renamed from: a */
    public static LatLng m9424a(LocationInfo locationInfo) {
        if (locationInfo == null) {
            return null;
        }
        CoordinateConverter coordinateConverter = new CoordinateConverter();
        coordinateConverter.from(CoordinateConverter.CoordType.GPS);
        coordinateConverter.coord(new LatLng(locationInfo.getLat(), locationInfo.getLon()));
        return coordinateConverter.convert();
    }
}
