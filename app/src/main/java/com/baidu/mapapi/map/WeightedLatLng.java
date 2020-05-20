package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.C1091b;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;

/* loaded from: classes.dex */
public class WeightedLatLng extends C1091b.AbstractC1092a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a */
    private Point f5389a;
    public final double intensity;
    public final LatLng latLng;

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng == null) {
            throw new IllegalArgumentException("latLng can not be null");
        }
        this.latLng = latLng;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        this.f5389a = new Point((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6());
        if (d > 0.0d) {
            this.intensity = d;
        } else {
            this.intensity = 1.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.C1091b.AbstractC1092a
    /* renamed from: a */
    public Point mo11072a() {
        return this.f5389a;
    }
}
