package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: a */
    int f5172a;

    /* renamed from: c */
    Bundle f5174c;

    /* renamed from: d */
    private LatLng f5175d;

    /* renamed from: e */
    private BitmapDescriptor f5176e;

    /* renamed from: j */
    private float f5181j;

    /* renamed from: k */
    private String f5182k;

    /* renamed from: l */
    private int f5183l;

    /* renamed from: n */
    private ArrayList<BitmapDescriptor> f5185n;

    /* renamed from: u */
    private Point f5192u;

    /* renamed from: f */
    private float f5177f = 0.5f;

    /* renamed from: g */
    private float f5178g = 1.0f;

    /* renamed from: h */
    private boolean f5179h = true;

    /* renamed from: i */
    private boolean f5180i = false;

    /* renamed from: m */
    private boolean f5184m = false;

    /* renamed from: o */
    private int f5186o = 20;

    /* renamed from: p */
    private float f5187p = 1.0f;

    /* renamed from: q */
    private float f5188q = 1.0f;

    /* renamed from: r */
    private float f5189r = 1.0f;

    /* renamed from: s */
    private int f5190s = MarkerAnimateType.none.ordinal();

    /* renamed from: t */
    private boolean f5191t = false;

    /* renamed from: b */
    boolean f5173b = true;

    /* loaded from: classes.dex */
    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Marker marker = new Marker();
        marker.f5203x = this.f5173b;
        marker.f5202w = this.f5172a;
        marker.f5204y = this.f5174c;
        LatLng latLng = this.f5175d;
        if (latLng != null) {
            marker.f5151a = latLng;
            if (this.f5176e == null && this.f5185n == null) {
                throw new IllegalStateException("when you add marker, you must set the icon or icons");
            }
            marker.f5152b = this.f5176e;
            marker.f5153c = this.f5177f;
            marker.f5154d = this.f5178g;
            marker.f5155e = this.f5179h;
            marker.f5156f = this.f5180i;
            marker.f5157g = this.f5181j;
            marker.f5158h = this.f5182k;
            marker.f5159i = this.f5183l;
            marker.f5160j = this.f5184m;
            marker.f5165o = this.f5185n;
            marker.f5166p = this.f5186o;
            marker.f5162l = this.f5189r;
            marker.f5168r = this.f5187p;
            marker.f5169s = this.f5188q;
            marker.f5163m = this.f5190s;
            marker.f5164n = this.f5191t;
            Point point = this.f5192u;
            if (point != null) {
                marker.f5171u = point;
            }
            return marker;
        }
        throw new IllegalStateException("when you add marker, you must set the position");
    }

    public final MarkerOptions alpha(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f > 1.0f) {
            this.f5189r = 1.0f;
            return this;
        }
        this.f5189r = f;
        return this;
    }

    public final MarkerOptions anchor(float f, float f2) {
        if (f >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && f <= 1.0f && f2 >= ColumnText.GLOBAL_SPACE_CHAR_RATIO && f2 <= 1.0f) {
            this.f5177f = f;
            this.f5178g = f2;
        }
        return this;
    }

    public final MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.f5190s = markerAnimateType.ordinal();
        return this;
    }

    public final MarkerOptions draggable(boolean z) {
        this.f5180i = z;
        return this;
    }

    public final MarkerOptions extraInfo(Bundle bundle) {
        this.f5174c = bundle;
        return this;
    }

    public final MarkerOptions fixedScreenPosition(Point point) {
        this.f5192u = point;
        this.f5191t = true;
        return this;
    }

    public final MarkerOptions flat(boolean z) {
        this.f5184m = z;
        return this;
    }

    public final float getAlpha() {
        return this.f5189r;
    }

    public final float getAnchorX() {
        return this.f5177f;
    }

    public final float getAnchorY() {
        return this.f5178g;
    }

    public final MarkerAnimateType getAnimateType() {
        switch (this.f5190s) {
            case 1:
                return MarkerAnimateType.drop;
            case 2:
                return MarkerAnimateType.grow;
            case 3:
                return MarkerAnimateType.jump;
            default:
                return MarkerAnimateType.none;
        }
    }

    public final Bundle getExtraInfo() {
        return this.f5174c;
    }

    public final BitmapDescriptor getIcon() {
        return this.f5176e;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return this.f5185n;
    }

    public final int getPeriod() {
        return this.f5186o;
    }

    public final LatLng getPosition() {
        return this.f5175d;
    }

    public final float getRotate() {
        return this.f5181j;
    }

    public final String getTitle() {
        return this.f5182k;
    }

    public final int getZIndex() {
        return this.f5172a;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5176e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("marker's icon can not be null");
    }

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f4982a == null) {
                    return this;
                }
            }
            this.f5185n = arrayList;
            return this;
        }
        throw new IllegalArgumentException("marker's icons can not be null");
    }

    public final boolean isDraggable() {
        return this.f5180i;
    }

    public final boolean isFlat() {
        return this.f5184m;
    }

    public final boolean isPerspective() {
        return this.f5179h;
    }

    public final boolean isVisible() {
        return this.f5173b;
    }

    public final MarkerOptions period(int i) {
        if (i > 0) {
            this.f5186o = i;
            return this;
        }
        throw new IllegalArgumentException("marker's period must be greater than zero ");
    }

    public final MarkerOptions perspective(boolean z) {
        this.f5179h = z;
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f5175d = latLng;
            return this;
        }
        throw new IllegalArgumentException("marker's position can not be null");
    }

    public final MarkerOptions rotate(float f) {
        while (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f += 360.0f;
        }
        this.f5181j = f % 360.0f;
        return this;
    }

    public final MarkerOptions scaleX(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return this;
        }
        this.f5187p = f;
        return this;
    }

    public final MarkerOptions scaleY(float f) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return this;
        }
        this.f5188q = f;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.f5182k = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.f5173b = z;
        return this;
    }

    public final MarkerOptions yOffset(int i) {
        this.f5183l = i;
        return this;
    }

    public final MarkerOptions zIndex(int i) {
        this.f5172a = i;
        return this;
    }
}
