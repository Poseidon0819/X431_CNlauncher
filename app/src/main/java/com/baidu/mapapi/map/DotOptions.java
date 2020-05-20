package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a */
    int f5000a;

    /* renamed from: c */
    Bundle f5002c;

    /* renamed from: d */
    private LatLng f5003d;

    /* renamed from: e */
    private int f5004e = -16777216;

    /* renamed from: f */
    private int f5005f = 5;

    /* renamed from: b */
    boolean f5001b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Dot dot = new Dot();
        dot.f5203x = this.f5001b;
        dot.f5202w = this.f5000a;
        dot.f5204y = this.f5002c;
        dot.f4998b = this.f5004e;
        dot.f4997a = this.f5003d;
        dot.f4999c = this.f5005f;
        return dot;
    }

    public final DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f5003d = latLng;
            return this;
        }
        throw new IllegalArgumentException("dot center can not be null");
    }

    public final DotOptions color(int i) {
        this.f5004e = i;
        return this;
    }

    public final DotOptions extraInfo(Bundle bundle) {
        this.f5002c = bundle;
        return this;
    }

    public final LatLng getCenter() {
        return this.f5003d;
    }

    public final int getColor() {
        return this.f5004e;
    }

    public final Bundle getExtraInfo() {
        return this.f5002c;
    }

    public final int getRadius() {
        return this.f5005f;
    }

    public final int getZIndex() {
        return this.f5000a;
    }

    public final boolean isVisible() {
        return this.f5001b;
    }

    public final DotOptions radius(int i) {
        if (i > 0) {
            this.f5005f = i;
        }
        return this;
    }

    public final DotOptions visible(boolean z) {
        this.f5001b = z;
        return this;
    }

    public final DotOptions zIndex(int i) {
        this.f5000a = i;
        return this;
    }
}
