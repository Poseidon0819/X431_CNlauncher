package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d */
    private static final String f4911d = "ArcOptions";

    /* renamed from: a */
    int f4912a;

    /* renamed from: c */
    Bundle f4914c;

    /* renamed from: g */
    private LatLng f4917g;

    /* renamed from: h */
    private LatLng f4918h;

    /* renamed from: i */
    private LatLng f4919i;

    /* renamed from: e */
    private int f4915e = -16777216;

    /* renamed from: f */
    private int f4916f = 5;

    /* renamed from: b */
    boolean f4913b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Arc arc = new Arc();
        arc.f5203x = this.f4913b;
        arc.f5202w = this.f4912a;
        arc.f5204y = this.f4914c;
        arc.f4906a = this.f4915e;
        arc.f4907b = this.f4916f;
        arc.f4908c = this.f4917g;
        arc.f4909d = this.f4918h;
        arc.f4910e = this.f4919i;
        return arc;
    }

    public final ArcOptions color(int i) {
        this.f4915e = i;
        return this;
    }

    public final ArcOptions extraInfo(Bundle bundle) {
        this.f4914c = bundle;
        return this;
    }

    public final int getColor() {
        return this.f4915e;
    }

    public final LatLng getEndPoint() {
        return this.f4919i;
    }

    public final Bundle getExtraInfo() {
        return this.f4914c;
    }

    public final LatLng getMiddlePoint() {
        return this.f4918h;
    }

    public final LatLng getStartPoint() {
        return this.f4917g;
    }

    public final int getWidth() {
        return this.f4916f;
    }

    public final int getZIndex() {
        return this.f4912a;
    }

    public final boolean isVisible() {
        return this.f4913b;
    }

    public final ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f4917g = latLng;
        this.f4918h = latLng2;
        this.f4919i = latLng3;
        return this;
    }

    public final ArcOptions visible(boolean z) {
        this.f4913b = z;
        return this;
    }

    public final ArcOptions width(int i) {
        if (i > 0) {
            this.f4916f = i;
        }
        return this;
    }

    public final ArcOptions zIndex(int i) {
        this.f4912a = i;
        return this;
    }
}
