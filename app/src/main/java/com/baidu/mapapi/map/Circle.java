package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;

/* loaded from: classes.dex */
public final class Circle extends Overlay {

    /* renamed from: a */
    LatLng f4985a;

    /* renamed from: b */
    int f4986b;

    /* renamed from: c */
    int f4987c;

    /* renamed from: d */
    Stroke f4988d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Circle() {
        this.type = EnumC1214h.circle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f4985a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f4985a, this.f4987c));
        Overlay.m11154a(this.f4986b, bundle);
        if (this.f4988d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f4988d.m11146a(new Bundle()));
        }
        return bundle;
    }

    public final LatLng getCenter() {
        return this.f4985a;
    }

    public final int getFillColor() {
        return this.f4986b;
    }

    public final int getRadius() {
        return this.f4987c;
    }

    public final Stroke getStroke() {
        return this.f4988d;
    }

    public final void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.f4985a = latLng;
        this.listener.mo11151b(this);
    }

    public final void setFillColor(int i) {
        this.f4986b = i;
        this.listener.mo11151b(this);
    }

    public final void setRadius(int i) {
        this.f4987c = i;
        this.listener.mo11151b(this);
    }

    public final void setStroke(Stroke stroke) {
        this.f4988d = stroke;
        this.listener.mo11151b(this);
    }
}
