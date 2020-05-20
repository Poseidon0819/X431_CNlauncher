package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a */
    int f5224a;

    /* renamed from: d */
    Bundle f5227d;

    /* renamed from: f */
    private List<LatLng> f5229f;

    /* renamed from: g */
    private List<Integer> f5230g;

    /* renamed from: h */
    private List<Integer> f5231h;

    /* renamed from: j */
    private BitmapDescriptor f5233j;

    /* renamed from: k */
    private List<BitmapDescriptor> f5234k;

    /* renamed from: e */
    private int f5228e = -16777216;

    /* renamed from: i */
    private int f5232i = 5;

    /* renamed from: l */
    private boolean f5235l = true;

    /* renamed from: m */
    private boolean f5236m = false;

    /* renamed from: b */
    boolean f5225b = true;

    /* renamed from: c */
    boolean f5226c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    /* renamed from: a */
    public final Overlay mo11137a() {
        Polyline polyline = new Polyline();
        polyline.f5203x = this.f5225b;
        polyline.f5219f = this.f5226c;
        polyline.f5202w = this.f5224a;
        polyline.f5204y = this.f5227d;
        List<LatLng> list = this.f5229f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.f5215b = this.f5229f;
        polyline.f5214a = this.f5228e;
        polyline.f5218e = this.f5232i;
        polyline.f5222i = this.f5233j;
        polyline.f5223j = this.f5234k;
        polyline.f5220g = this.f5235l;
        polyline.f5221h = this.f5236m;
        List<Integer> list2 = this.f5230g;
        if (list2 != null && list2.size() < this.f5229f.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f5229f.size() - 1) - this.f5230g.size());
            List<Integer> list3 = this.f5230g;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f5230g;
        int i = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f5230g.size()];
            int i2 = 0;
            for (Integer num : this.f5230g) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.f5216c = iArr;
        }
        List<Integer> list5 = this.f5231h;
        if (list5 != null && list5.size() < this.f5229f.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f5229f.size() - 1) - this.f5231h.size());
            List<Integer> list6 = this.f5231h;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f5231h;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f5231h.size()];
            for (Integer num2 : this.f5231h) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.f5217d = iArr2;
        }
        return polyline;
    }

    public final PolylineOptions color(int i) {
        this.f5228e = i;
        return this;
    }

    public final PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("colors list can not contains null");
            }
            this.f5231h = list;
            return this;
        }
        throw new IllegalArgumentException("colors list can not be null");
    }

    public final PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.f5233j = bitmapDescriptor;
        return this;
    }

    public final PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list != null) {
            if (list.size() == 0) {
                Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
            }
            for (BitmapDescriptor bitmapDescriptor : list) {
                if (bitmapDescriptor == null) {
                    Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
                }
            }
            this.f5234k = list;
            return this;
        }
        throw new IllegalArgumentException("customTexture list can not be null");
    }

    public final PolylineOptions dottedLine(boolean z) {
        this.f5226c = z;
        return this;
    }

    public final PolylineOptions extraInfo(Bundle bundle) {
        this.f5227d = bundle;
        return this;
    }

    public final PolylineOptions focus(boolean z) {
        this.f5235l = z;
        return this;
    }

    public final int getColor() {
        return this.f5228e;
    }

    public final BitmapDescriptor getCustomTexture() {
        return this.f5233j;
    }

    public final List<BitmapDescriptor> getCustomTextureList() {
        return this.f5234k;
    }

    public final Bundle getExtraInfo() {
        return this.f5227d;
    }

    public final List<LatLng> getPoints() {
        return this.f5229f;
    }

    public final List<Integer> getTextureIndexs() {
        return this.f5230g;
    }

    public final int getWidth() {
        return this.f5232i;
    }

    public final int getZIndex() {
        return this.f5224a;
    }

    public final boolean isDottedLine() {
        return this.f5226c;
    }

    public final boolean isFocus() {
        return this.f5235l;
    }

    public final boolean isVisible() {
        return this.f5225b;
    }

    public final PolylineOptions keepScale(boolean z) {
        this.f5236m = z;
        return this;
    }

    public final PolylineOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("points list can not contains null");
                }
                this.f5229f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than 2");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public final PolylineOptions textureIndex(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("index list can not contains null");
            }
            this.f5230g = list;
            return this;
        }
        throw new IllegalArgumentException("indexs list can not be null");
    }

    public final PolylineOptions visible(boolean z) {
        this.f5225b = z;
        return this;
    }

    public final PolylineOptions width(int i) {
        if (i > 0) {
            this.f5232i = i;
        }
        return this;
    }

    public final PolylineOptions zIndex(int i) {
        this.f5224a = i;
        return this;
    }
}
