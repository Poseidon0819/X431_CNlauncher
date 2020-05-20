package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Arc extends Overlay {

    /* renamed from: f */
    private static final String f4905f = "Arc";

    /* renamed from: a */
    int f4906a;

    /* renamed from: b */
    int f4907b;

    /* renamed from: c */
    LatLng f4908c;

    /* renamed from: d */
    LatLng f4909d;

    /* renamed from: e */
    LatLng f4910e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Arc() {
        this.type = EnumC1214h.arc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.f4908c);
        arrayList.add(this.f4909d);
        arrayList.add(this.f4910e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f4907b);
        Overlay.m11153a(arrayList, bundle);
        Overlay.m11154a(this.f4906a, bundle);
        return bundle;
    }

    public final int getColor() {
        return this.f4906a;
    }

    public final LatLng getEndPoint() {
        return this.f4910e;
    }

    public final LatLng getMiddlePoint() {
        return this.f4909d;
    }

    public final LatLng getStartPoint() {
        return this.f4908c;
    }

    public final int getWidth() {
        return this.f4907b;
    }

    public final void setColor(int i) {
        this.f4906a = i;
        this.listener.mo11151b(this);
    }

    public final void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f4908c = latLng;
        this.f4909d = latLng2;
        this.f4910e = latLng3;
        this.listener.mo11151b(this);
    }

    public final void setWidth(int i) {
        if (i > 0) {
            this.f4907b = i;
            this.listener.mo11151b(this);
        }
    }
}
