package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import java.util.List;

/* loaded from: classes.dex */
public final class Polygon extends Overlay {

    /* renamed from: a */
    Stroke f5205a;

    /* renamed from: b */
    int f5206b;

    /* renamed from: c */
    List<LatLng> f5207c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Polygon() {
        this.type = EnumC1214h.polygon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5207c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.m11153a(this.f5207c, bundle);
        Overlay.m11154a(this.f5206b, bundle);
        if (this.f5205a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f5205a.m11146a(new Bundle()));
        }
        return bundle;
    }

    public final int getFillColor() {
        return this.f5206b;
    }

    public final List<LatLng> getPoints() {
        return this.f5207c;
    }

    public final Stroke getStroke() {
        return this.f5205a;
    }

    public final void setFillColor(int i) {
        this.f5206b = i;
        this.listener.mo11151b(this);
    }

    public final void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                if (list.get(i) == list.get(i3)) {
                    throw new IllegalArgumentException("points list can not has same points");
                }
            }
            i = i2;
        }
        this.f5207c = list;
        this.listener.mo11151b(this);
    }

    public final void setStroke(Stroke stroke) {
        this.f5205a = stroke;
        this.listener.mo11151b(this);
    }
}
