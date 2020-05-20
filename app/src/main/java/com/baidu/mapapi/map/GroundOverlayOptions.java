package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.nativeads.MoPubNativeAdPositioning;

/* loaded from: classes.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a */
    int f5023a;

    /* renamed from: c */
    Bundle f5025c;

    /* renamed from: d */
    private BitmapDescriptor f5026d;

    /* renamed from: e */
    private LatLng f5027e;

    /* renamed from: f */
    private int f5028f;

    /* renamed from: g */
    private int f5029g;

    /* renamed from: j */
    private LatLngBounds f5032j;

    /* renamed from: h */
    private float f5030h = 0.5f;

    /* renamed from: i */
    private float f5031i = 0.5f;

    /* renamed from: k */
    private float f5033k = 1.0f;

    /* renamed from: b */
    boolean f5024b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        LatLngBounds latLngBounds;
        int i;
        LatLng latLng;
        int i2;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.f5203x = this.f5024b;
        groundOverlay.f5202w = this.f5023a;
        groundOverlay.f5204y = this.f5025c;
        BitmapDescriptor bitmapDescriptor = this.f5026d;
        if (bitmapDescriptor != null) {
            groundOverlay.f5015b = bitmapDescriptor;
            if (this.f5032j == null && (latLng = this.f5027e) != null) {
                int i3 = this.f5028f;
                if (i3 <= 0 || (i2 = this.f5029g) <= 0) {
                    throw new IllegalArgumentException("when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f5016c = latLng;
                groundOverlay.f5019f = this.f5030h;
                groundOverlay.f5020g = this.f5031i;
                groundOverlay.f5017d = i3;
                groundOverlay.f5018e = i2;
                i = 2;
            } else if (this.f5027e != null || (latLngBounds = this.f5032j) == null) {
                throw new IllegalStateException("when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f5021h = latLngBounds;
                i = 1;
            }
            groundOverlay.f5014a = i;
            groundOverlay.f5022i = this.f5033k;
            return groundOverlay;
        }
        throw new IllegalStateException("when you add ground overlay, you must set the image");
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        if (f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && f <= 1.0f && f2 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && f2 <= 1.0f) {
            this.f5030h = f;
            this.f5031i = f2;
        }
        return this;
    }

    public final GroundOverlayOptions dimensions(int i) {
        this.f5028f = i;
        this.f5029g = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        return this;
    }

    public final GroundOverlayOptions dimensions(int i, int i2) {
        this.f5028f = i;
        this.f5029g = i2;
        return this;
    }

    public final GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f5025c = bundle;
        return this;
    }

    public final float getAnchorX() {
        return this.f5030h;
    }

    public final float getAnchorY() {
        return this.f5031i;
    }

    public final LatLngBounds getBounds() {
        return this.f5032j;
    }

    public final Bundle getExtraInfo() {
        return this.f5025c;
    }

    public final int getHeight() {
        int i = this.f5029g;
        return i == Integer.MAX_VALUE ? (int) ((this.f5028f * this.f5026d.f4982a.getHeight()) / this.f5026d.f4982a.getWidth()) : i;
    }

    public final BitmapDescriptor getImage() {
        return this.f5026d;
    }

    public final LatLng getPosition() {
        return this.f5027e;
    }

    public final float getTransparency() {
        return this.f5033k;
    }

    public final int getWidth() {
        return this.f5028f;
    }

    public final int getZIndex() {
        return this.f5023a;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5026d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("image can not be null");
    }

    public final boolean isVisible() {
        return this.f5024b;
    }

    public final GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f5027e = latLng;
            return this;
        }
        throw new IllegalArgumentException("position can not be null");
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.f5032j = latLngBounds;
            return this;
        }
        throw new IllegalArgumentException("bounds can not be null");
    }

    public final GroundOverlayOptions transparency(float f) {
        if (f <= 1.0f && f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            this.f5033k = f;
        }
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.f5024b = z;
        return this;
    }

    public final GroundOverlayOptions zIndex(int i) {
        this.f5023a = i;
        return this;
    }
}
