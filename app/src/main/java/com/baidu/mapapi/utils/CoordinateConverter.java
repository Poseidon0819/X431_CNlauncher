package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* loaded from: classes.dex */
public class CoordinateConverter {

    /* renamed from: a */
    private LatLng f5756a;

    /* renamed from: b */
    private CoordType f5757b;

    /* loaded from: classes.dex */
    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    /* renamed from: a */
    private static LatLng m10936a(LatLng latLng) {
        return m10935a(latLng, CoordinateType.WGS84);
    }

    /* renamed from: a */
    private static LatLng m10935a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    /* renamed from: b */
    private static LatLng m10934b(LatLng latLng) {
        return m10935a(latLng, CoordinateType.GCJ02);
    }

    /* renamed from: c */
    private static LatLng m10933c(LatLng latLng) {
        return m10935a(latLng, CoordinateType.BD09MC);
    }

    /* renamed from: d */
    private static LatLng m10932d(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f5756a == null) {
            return null;
        }
        if (this.f5757b == null) {
            this.f5757b = CoordType.GPS;
        }
        switch (this.f5757b) {
            case COMMON:
                return m10934b(this.f5756a);
            case GPS:
                return m10936a(this.f5756a);
            case BD09LL:
                return m10932d(this.f5756a);
            case BD09MC:
                return m10933c(this.f5756a);
            default:
                return null;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f5756a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f5757b = coordType;
        return this;
    }
}
