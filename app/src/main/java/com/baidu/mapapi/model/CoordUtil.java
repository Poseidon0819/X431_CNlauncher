package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.util.C1300b;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mapsdkplatform.comjni.tools.C1312a;
import java.util.List;

/* loaded from: classes.dex */
public class CoordUtil {
    public static LatLng Coordinate_encryptEx(float f, float f2, String str) {
        return C1300b.m10097a(f, f2, str);
    }

    public static LatLng decodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(C1300b.m10092a(str)) : C1300b.m10092a(str);
    }

    public static List<LatLng> decodeLocationList(String str) {
        return C1300b.m10089c(str);
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        return C1300b.m10088d(str);
    }

    public static LatLng decodeNodeLocation(String str) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(C1300b.m10090b(str)) : C1300b.m10090b(str);
    }

    public static double getDistance(Point point, Point point2) {
        return C1312a.m9963a(point, point2);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? C1300b.m10095a(CoordTrans.gcjToBaidu(latLng), i) : C1300b.m10095a(latLng, i);
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? C1300b.m10096a(CoordTrans.gcjToBaidu(latLng)) : C1300b.m10096a(latLng);
    }

    public static Point ll2point(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? C1300b.m10091b(CoordTrans.gcjToBaidu(latLng)) : C1300b.m10091b(latLng);
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(C1300b.m10094a(geoPoint)) : C1300b.m10094a(geoPoint);
    }
}
