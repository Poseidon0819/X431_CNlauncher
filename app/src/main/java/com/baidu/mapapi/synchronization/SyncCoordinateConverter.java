package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* loaded from: classes.dex */
public class SyncCoordinateConverter {

    /* renamed from: a */
    private LatLng f5717a;

    /* renamed from: b */
    private CoordType f5718b;

    /* loaded from: classes.dex */
    public enum CoordType {
        COMMON,
        BD09LL
    }

    /* renamed from: a */
    private static LatLng m10943a(LatLng latLng) {
        return m10942a(latLng, CoordinateType.GCJ02);
    }

    /* renamed from: a */
    private static LatLng m10942a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    /* renamed from: b */
    private static LatLng m10941b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }

    public LatLng convert() {
        if (this.f5717a == null) {
            return null;
        }
        if (this.f5718b == null) {
            this.f5718b = CoordType.BD09LL;
        }
        switch (this.f5718b) {
            case COMMON:
                return m10943a(this.f5717a);
            case BD09LL:
                return m10941b(this.f5717a);
            default:
                return null;
        }
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        this.f5717a = latLng;
        return this;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        this.f5718b = coordType;
        return this;
    }
}
