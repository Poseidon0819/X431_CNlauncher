package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;

/* loaded from: classes.dex */
public final class Dot extends Overlay {

    /* renamed from: a */
    LatLng f4997a;

    /* renamed from: b */
    int f4998b;

    /* renamed from: c */
    int f4999c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dot() {
        this.type = EnumC1214h.dot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f4997a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.f4999c);
        Overlay.m11154a(this.f4998b, bundle);
        return bundle;
    }

    public final LatLng getCenter() {
        return this.f4997a;
    }

    public final int getColor() {
        return this.f4998b;
    }

    public final int getRadius() {
        return this.f4999c;
    }

    public final void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.f4997a = latLng;
        this.listener.mo11151b(this);
    }

    public final void setColor(int i) {
        this.f4998b = i;
        this.listener.mo11151b(this);
    }

    public final void setRadius(int i) {
        if (i > 0) {
            this.f4999c = i;
            this.listener.mo11151b(this);
        }
    }
}
