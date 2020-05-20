package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public final class GroundOverlay extends Overlay {

    /* renamed from: j */
    private static final String f5013j = "GroundOverlay";

    /* renamed from: a */
    int f5014a;

    /* renamed from: b */
    BitmapDescriptor f5015b;

    /* renamed from: c */
    LatLng f5016c;

    /* renamed from: d */
    double f5017d;

    /* renamed from: e */
    double f5018e;

    /* renamed from: f */
    float f5019f;

    /* renamed from: g */
    float f5020g;

    /* renamed from: h */
    LatLngBounds f5021h;

    /* renamed from: i */
    float f5022i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlay() {
        this.type = EnumC1214h.ground;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        double d;
        super.mo11138a(bundle);
        bundle.putBundle("image_info", this.f5015b.m11217b());
        if (this.f5014a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f5021h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f5021h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            this.f5017d = longitudeE62 - longitudeE6;
            this.f5018e = latitudeE62 - latitudeE6;
            this.f5016c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (this.f5018e / 2.0d), longitudeE6 + (this.f5017d / 2.0d)));
            this.f5019f = 0.5f;
            this.f5020g = 0.5f;
        }
        double d2 = this.f5017d;
        if (d2 <= 0.0d || this.f5018e <= 0.0d) {
            throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d2);
        if (this.f5018e == 2.147483647E9d) {
            double d3 = this.f5017d;
            double height = this.f5015b.f4982a.getHeight();
            Double.isNaN(height);
            double d4 = d3 * height;
            Double.isNaN(this.f5015b.f4982a.getWidth());
            this.f5018e = (int) (d4 / d);
        }
        bundle.putDouble("y_distance", this.f5018e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f5016c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f5019f);
        bundle.putFloat("anchor_y", this.f5020g);
        bundle.putFloat("transparency", this.f5022i);
        return bundle;
    }

    public final float getAnchorX() {
        return this.f5019f;
    }

    public final float getAnchorY() {
        return this.f5020g;
    }

    public final LatLngBounds getBounds() {
        return this.f5021h;
    }

    public final double getHeight() {
        return this.f5018e;
    }

    public final BitmapDescriptor getImage() {
        return this.f5015b;
    }

    public final LatLng getPosition() {
        return this.f5016c;
    }

    public final float getTransparency() {
        return this.f5022i;
    }

    public final double getWidth() {
        return this.f5017d;
    }

    public final void setAnchor(float f, float f2) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f > 1.0f || f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f2 > 1.0f) {
            return;
        }
        this.f5019f = f;
        this.f5020g = f2;
        this.listener.mo11151b(this);
    }

    public final void setDimensions(int i) {
        this.f5017d = i;
        this.f5018e = 2.147483647E9d;
        this.listener.mo11151b(this);
    }

    public final void setDimensions(int i, int i2) {
        this.f5017d = i;
        this.f5018e = i2;
        this.listener.mo11151b(this);
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("image can not be null");
        }
        this.f5015b = bitmapDescriptor;
        this.listener.mo11151b(this);
    }

    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f5014a = 2;
        this.f5016c = latLng;
        this.listener.mo11151b(this);
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("bounds can not be null");
        }
        this.f5014a = 1;
        this.f5021h = latLngBounds;
        this.listener.mo11151b(this);
    }

    public final void setTransparency(float f) {
        if (f > 1.0f || f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return;
        }
        this.f5022i = f;
        this.listener.mo11151b(this);
    }
}
