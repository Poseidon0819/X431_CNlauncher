package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;

/* loaded from: classes.dex */
public final class RoleOptions {

    /* renamed from: a */
    private static final String f5702a = "RoleOptions";

    /* renamed from: b */
    private String f5703b;

    /* renamed from: c */
    private int f5704c;

    /* renamed from: d */
    private String f5705d;

    /* renamed from: e */
    private String f5706e;

    /* renamed from: f */
    private SyncCoordinateConverter.CoordType f5707f;

    /* renamed from: g */
    private LatLng f5708g = null;

    /* renamed from: h */
    private String f5709h = null;

    /* renamed from: i */
    private String f5710i = null;

    /* renamed from: j */
    private LatLng f5711j = null;

    /* renamed from: k */
    private String f5712k = null;

    /* renamed from: l */
    private String f5713l = null;

    /* renamed from: m */
    private LatLng f5714m = null;

    /* renamed from: n */
    private String f5715n = null;

    /* renamed from: o */
    private String f5716o = null;

    public RoleOptions() {
        this.f5703b = null;
        this.f5704c = 0;
        this.f5705d = null;
        this.f5706e = null;
        this.f5707f = SyncCoordinateConverter.CoordType.BD09LL;
        this.f5703b = null;
        this.f5704c = 0;
        this.f5705d = null;
        this.f5706e = null;
        this.f5707f = SyncCoordinateConverter.CoordType.BD09LL;
    }

    /* renamed from: a */
    private LatLng m10944a(LatLng latLng) {
        return new SyncCoordinateConverter().from(this.f5707f).coord(latLng).convert();
    }

    public final SyncCoordinateConverter.CoordType getCoordType() {
        return this.f5707f;
    }

    public final String getDriverId() {
        return this.f5705d;
    }

    public final LatLng getDriverPosition() {
        return this.f5714m;
    }

    public final String getDriverPositionName() {
        return this.f5716o;
    }

    public final String getDriverPositionPoiUid() {
        return this.f5715n;
    }

    public final LatLng getEndPosition() {
        return this.f5711j;
    }

    public final String getEndPositionName() {
        return this.f5713l;
    }

    public final String getEndPositionPoiUid() {
        return this.f5712k;
    }

    public final String getOrderId() {
        return this.f5703b;
    }

    public final int getRoleType() {
        return this.f5704c;
    }

    public final LatLng getStartPosition() {
        return this.f5708g;
    }

    public final String getStartPositionName() {
        return this.f5710i;
    }

    public final String getStartPositionPoiUid() {
        return this.f5709h;
    }

    public final String getUserId() {
        return this.f5706e;
    }

    public final RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
            this.f5707f = coordType;
            return this;
        }
        throw new IllegalArgumentException("CoordType only can be BD09LL or COMMON, please check!");
    }

    public final RoleOptions setDriverId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("driverId is null");
        }
        this.f5705d = str;
        return this;
    }

    public final RoleOptions setDriverPosition(LatLng latLng) {
        if (latLng == null) {
            this.f5714m = null;
            return this;
        }
        if (SyncCoordinateConverter.CoordType.COMMON == this.f5707f) {
            latLng = m10944a(latLng);
        }
        this.f5714m = latLng;
        return this;
    }

    public final RoleOptions setDriverPositionName(String str) {
        this.f5716o = str;
        return this;
    }

    public final RoleOptions setDriverPositionPoiUid(String str) {
        this.f5715n = str;
        return this;
    }

    public final RoleOptions setEndPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f5707f) {
                latLng = m10944a(latLng);
            }
            this.f5711j = latLng;
            return this;
        }
        throw new IllegalArgumentException("endPosition is null, must be applied!");
    }

    public final RoleOptions setEndPositionName(String str) {
        this.f5713l = str;
        return this;
    }

    public final RoleOptions setEndPositionPoiUid(String str) {
        this.f5712k = str;
        return this;
    }

    public final RoleOptions setOrderId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("orderId is null.");
        }
        this.f5703b = str;
        return this;
    }

    public final RoleOptions setRoleType(int i) {
        if (i == 0) {
            this.f5704c = i;
            return this;
        }
        throw new IllegalArgumentException("role type is invalid: ".concat(String.valueOf(i)));
    }

    public final RoleOptions setStartPosition(LatLng latLng) {
        if (latLng != null) {
            if (SyncCoordinateConverter.CoordType.COMMON == this.f5707f) {
                latLng = m10944a(latLng);
            }
            this.f5708g = latLng;
            return this;
        }
        throw new IllegalArgumentException("StartPosition is null, must be applied!");
    }

    public final RoleOptions setStartPositionName(String str) {
        this.f5710i = str;
        return this;
    }

    public final RoleOptions setStartPositionPoiUid(String str) {
        this.f5709h = str;
        return this;
    }

    public final RoleOptions setUserId(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("user id is null");
        }
        this.f5706e = str;
        return this;
    }
}
