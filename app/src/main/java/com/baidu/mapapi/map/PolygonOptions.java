package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a */
    int f5208a;

    /* renamed from: c */
    Bundle f5210c;

    /* renamed from: d */
    private Stroke f5211d;

    /* renamed from: f */
    private List<LatLng> f5213f;

    /* renamed from: e */
    private int f5212e = -16777216;

    /* renamed from: b */
    boolean f5209b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Polygon polygon = new Polygon();
        polygon.f5203x = this.f5209b;
        polygon.f5202w = this.f5208a;
        polygon.f5204y = this.f5210c;
        List<LatLng> list = this.f5213f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polygon.f5207c = this.f5213f;
        polygon.f5206b = this.f5212e;
        polygon.f5205a = this.f5211d;
        return polygon;
    }

    public final PolygonOptions extraInfo(Bundle bundle) {
        this.f5210c = bundle;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.f5212e = i;
        return this;
    }

    public final Bundle getExtraInfo() {
        return this.f5210c;
    }

    public final int getFillColor() {
        return this.f5212e;
    }

    public final List<LatLng> getPoints() {
        return this.f5213f;
    }

    public final Stroke getStroke() {
        return this.f5211d;
    }

    public final int getZIndex() {
        return this.f5208a;
    }

    public final boolean isVisible() {
        return this.f5209b;
    }

    public final PolygonOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
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
                this.f5213f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than three");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public final PolygonOptions stroke(Stroke stroke) {
        this.f5211d = stroke;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.f5209b = z;
        return this;
    }

    public final PolygonOptions zIndex(int i) {
        this.f5208a = i;
        return this;
    }
}
