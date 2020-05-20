package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d */
    private static final String f4989d = "CircleOptions";

    /* renamed from: a */
    int f4990a;

    /* renamed from: c */
    Bundle f4992c;

    /* renamed from: e */
    private LatLng f4993e;

    /* renamed from: g */
    private int f4995g;

    /* renamed from: h */
    private Stroke f4996h;

    /* renamed from: f */
    private int f4994f = -16777216;

    /* renamed from: b */
    boolean f4991b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Circle circle = new Circle();
        circle.f5203x = this.f4991b;
        circle.f5202w = this.f4990a;
        circle.f5204y = this.f4992c;
        circle.f4986b = this.f4994f;
        circle.f4985a = this.f4993e;
        circle.f4987c = this.f4995g;
        circle.f4988d = this.f4996h;
        return circle;
    }

    public final CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f4993e = latLng;
            return this;
        }
        throw new IllegalArgumentException("circle center can not be null");
    }

    public final CircleOptions extraInfo(Bundle bundle) {
        this.f4992c = bundle;
        return this;
    }

    public final CircleOptions fillColor(int i) {
        this.f4994f = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.f4993e;
    }

    public final Bundle getExtraInfo() {
        return this.f4992c;
    }

    public final int getFillColor() {
        return this.f4994f;
    }

    public final int getRadius() {
        return this.f4995g;
    }

    public final Stroke getStroke() {
        return this.f4996h;
    }

    public final int getZIndex() {
        return this.f4990a;
    }

    public final boolean isVisible() {
        return this.f4991b;
    }

    public final CircleOptions radius(int i) {
        this.f4995g = i;
        return this;
    }

    public final CircleOptions stroke(Stroke stroke) {
        this.f4996h = stroke;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.f4991b = z;
        return this;
    }

    public final CircleOptions zIndex(int i) {
        this.f4990a = i;
        return this;
    }
}
