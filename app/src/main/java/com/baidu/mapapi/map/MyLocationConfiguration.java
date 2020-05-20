package com.baidu.mapapi.map;

import android.graphics.Color;

/* loaded from: classes.dex */
public class MyLocationConfiguration {
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;
    public final BitmapDescriptor customMarker;
    public final boolean enableDirection;
    public final LocationMode locationMode;

    /* loaded from: classes.dex */
    public enum LocationMode {
        NORMAL,
        FOLLOWING,
        COMPASS
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor) {
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = m11155a(this.accuracyCircleFillColor);
        this.accuracyCircleStrokeColor = m11155a(this.accuracyCircleStrokeColor);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i, int i2) {
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = m11155a(i);
        this.accuracyCircleStrokeColor = m11155a(i2);
    }

    /* renamed from: a */
    private int m11155a(int i) {
        int i2 = (65280 & i) >> 8;
        return Color.argb(((-16777216) & i) >> 24, i & 255, i2, (16711680 & i) >> 16);
    }
}
