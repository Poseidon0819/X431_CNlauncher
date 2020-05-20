package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import com.mopub.common.AdType;
import java.util.List;

/* loaded from: classes.dex */
public final class Polyline extends Overlay {

    /* renamed from: a */
    int f5214a;

    /* renamed from: b */
    List<LatLng> f5215b;

    /* renamed from: c */
    int[] f5216c;

    /* renamed from: d */
    int[] f5217d;

    /* renamed from: e */
    int f5218e;

    /* renamed from: f */
    boolean f5219f;

    /* renamed from: g */
    boolean f5220g = false;

    /* renamed from: h */
    boolean f5221h = true;

    /* renamed from: i */
    BitmapDescriptor f5222i;

    /* renamed from: j */
    List<BitmapDescriptor> f5223j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Polyline() {
        this.type = EnumC1214h.polyline;
    }

    /* renamed from: a */
    private Bundle m11150a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.f5222i).m11217b();
    }

    /* renamed from: a */
    static void m11149a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    /* renamed from: b */
    private Bundle m11148b(boolean z) {
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle("texture_0", BitmapDescriptorFactory.fromAsset("lineDashTexture.png").m11217b());
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i = 0;
        for (int i2 = 0; i2 < this.f5223j.size(); i2++) {
            if (this.f5223j.get(i2) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i), this.f5223j.get(i2).m11217b());
                i++;
            }
        }
        bundle2.putInt("total", i);
        return bundle2;
    }

    /* renamed from: b */
    static void m11147b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    /* renamed from: a */
    public final Bundle mo11138a(Bundle bundle) {
        super.mo11138a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5215b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f5218e);
        Overlay.m11153a(this.f5215b, bundle);
        Overlay.m11154a(this.f5214a, bundle);
        m11149a(this.f5216c, bundle);
        m11147b(this.f5217d, bundle);
        int[] iArr = this.f5216c;
        int i = 1;
        if (iArr != null && iArr.length > 0 && iArr.length > this.f5215b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        if (this.f5219f) {
            bundle.putInt("dotline", 1);
        } else {
            bundle.putInt("dotline", 0);
        }
        bundle.putInt("focus", this.f5220g ? 1 : 0);
        try {
            if (this.f5222i != null) {
                bundle.putInt(AdType.CUSTOM, 1);
                bundle.putBundle("image_info", m11150a(false));
            } else {
                if (this.f5219f) {
                    bundle.putBundle("image_info", m11150a(true));
                }
                bundle.putInt(AdType.CUSTOM, 0);
            }
            if (this.f5223j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", m11148b(false));
            } else {
                if (this.f5219f && ((this.f5216c != null && this.f5216c.length > 0) || (this.f5217d != null && this.f5217d.length > 0))) {
                    bundle.putBundle("image_info_list", m11148b(true));
                }
                bundle.putInt("customlist", 0);
            }
            if (!this.f5221h) {
                i = 0;
            }
            bundle.putInt("keep", i);
        } catch (Exception unused) {
            Log.e("baidumapsdk", "load texture resource failed!");
            bundle.putInt("dotline", 0);
        }
        return bundle;
    }

    public final int getColor() {
        return this.f5214a;
    }

    public final List<LatLng> getPoints() {
        return this.f5215b;
    }

    public final int getWidth() {
        return this.f5218e;
    }

    public final boolean isDottedLine() {
        return this.f5219f;
    }

    public final boolean isFocus() {
        return this.f5220g;
    }

    public final void setColor(int i) {
        this.f5214a = i;
        this.listener.mo11151b(this);
    }

    public final void setDottedLine(boolean z) {
        this.f5219f = z;
        this.listener.mo11151b(this);
    }

    public final void setFocus(boolean z) {
        this.f5220g = z;
        this.listener.mo11151b(this);
    }

    public final void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("indexList can not empty");
        }
        this.f5216c = iArr;
    }

    public final void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not less than 2 or more than 10000");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        this.f5215b = list;
        this.listener.mo11151b(this);
    }

    public final void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("textureList can not empty");
        }
        this.f5223j = list;
    }

    public final void setWidth(int i) {
        if (i > 0) {
            this.f5218e = i;
            this.listener.mo11151b(this);
        }
    }
}
