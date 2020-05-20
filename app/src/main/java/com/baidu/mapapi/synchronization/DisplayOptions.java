package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DisplayOptions {

    /* renamed from: a */
    private static final String f5660a = "DisplayOptions";

    /* renamed from: A */
    private View f5661A;

    /* renamed from: B */
    private View f5662B;

    /* renamed from: C */
    private View f5663C;

    /* renamed from: k */
    private boolean f5686k;

    /* renamed from: l */
    private boolean f5687l;

    /* renamed from: e */
    private int f5680e = 6;

    /* renamed from: i */
    private int f5684i = 7;

    /* renamed from: m */
    private int f5688m = 8;

    /* renamed from: q */
    private int f5692q = 10;

    /* renamed from: t */
    private int f5695t = 5;

    /* renamed from: D */
    private boolean f5664D = true;

    /* renamed from: E */
    private boolean f5665E = true;

    /* renamed from: F */
    private int f5666F = 6;

    /* renamed from: G */
    private boolean f5667G = true;

    /* renamed from: H */
    private boolean f5668H = true;

    /* renamed from: I */
    private int f5669I = 7;

    /* renamed from: J */
    private boolean f5670J = true;

    /* renamed from: K */
    private boolean f5671K = true;

    /* renamed from: L */
    private int f5672L = 8;

    /* renamed from: M */
    private int f5673M = 50;

    /* renamed from: N */
    private int f5674N = 50;

    /* renamed from: O */
    private int f5675O = 50;

    /* renamed from: P */
    private int f5676P = 50;

    /* renamed from: b */
    private BitmapDescriptor f5677b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: c */
    private boolean f5678c = true;

    /* renamed from: d */
    private boolean f5679d = true;

    /* renamed from: f */
    private BitmapDescriptor f5681f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: g */
    private boolean f5682g = true;

    /* renamed from: h */
    private boolean f5683h = true;

    /* renamed from: j */
    private BitmapDescriptor f5685j = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: n */
    private BitmapDescriptor f5689n = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");

    /* renamed from: o */
    private boolean f5690o = true;

    /* renamed from: p */
    private boolean f5691p = true;

    /* renamed from: r */
    private boolean f5693r = true;

    /* renamed from: s */
    private boolean f5694s = true;

    /* renamed from: u */
    private BitmapDescriptor f5696u = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");

    /* renamed from: v */
    private BitmapDescriptor f5697v = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");

    /* renamed from: w */
    private BitmapDescriptor f5698w = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");

    /* renamed from: x */
    private BitmapDescriptor f5699x = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");

    /* renamed from: y */
    private BitmapDescriptor f5700y = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");

    /* renamed from: z */
    private int f5701z = 22;

    public DisplayOptions() {
        this.f5686k = true;
        this.f5687l = true;
        this.f5686k = true;
        this.f5687l = true;
    }

    public final BitmapDescriptor getCarIcon() {
        return this.f5685j;
    }

    public final View getCarInfoWindowView() {
        return this.f5661A;
    }

    public final int getCarPositionInfoWindowZIndex() {
        return this.f5672L;
    }

    public final int getCarPositionMarkerZIndex() {
        return this.f5688m;
    }

    public final BitmapDescriptor getEndPositionIcon() {
        return this.f5681f;
    }

    public final View getEndPositionInfoWindowView() {
        return this.f5663C;
    }

    public final int getEndPositionInfoWindowZIndex() {
        return this.f5669I;
    }

    public final int getEndPositionMarkerZIndex() {
        return this.f5684i;
    }

    public final int getPaddingBottom() {
        return this.f5676P;
    }

    public final int getPaddingLeft() {
        return this.f5673M;
    }

    public final int getPaddingRight() {
        return this.f5674N;
    }

    public final int getPaddingTop() {
        return this.f5675O;
    }

    public final BitmapDescriptor getPassengerIcon() {
        return this.f5689n;
    }

    public final int getPassengerMarkerZIndex() {
        return this.f5692q;
    }

    public final int getRouteLineWidth() {
        return this.f5701z;
    }

    public final int getRouteLineZIndex() {
        return this.f5695t;
    }

    public final BitmapDescriptor getStartPositionIcon() {
        return this.f5677b;
    }

    public final View getStartPositionInfoWindowView() {
        return this.f5662B;
    }

    public final int getStartPositionInfoWindowZIndex() {
        return this.f5666F;
    }

    public final int getStartPositionMarkerZIndex() {
        return this.f5680e;
    }

    public final List<BitmapDescriptor> getTrafficTextureList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f5700y);
        arrayList.add(this.f5696u);
        arrayList.add(this.f5697v);
        arrayList.add(this.f5698w);
        arrayList.add(this.f5699x);
        return arrayList;
    }

    public final boolean isShowCarInfoWindow() {
        return this.f5670J;
    }

    public final boolean isShowCarMarker() {
        return this.f5686k;
    }

    public final boolean isShowCarMarkerInSpan() {
        return this.f5687l;
    }

    public final boolean isShowEndPositionInfoWindow() {
        return this.f5667G;
    }

    public final boolean isShowEndPositionMarker() {
        return this.f5682g;
    }

    public final boolean isShowEndPositionMarkerInSpan() {
        return this.f5683h;
    }

    public final boolean isShowPassengerIcon() {
        return this.f5690o;
    }

    public final boolean isShowPassengerIconInSpan() {
        return this.f5691p;
    }

    public final boolean isShowRoutePlan() {
        return this.f5693r;
    }

    public final boolean isShowRoutePlanInSpan() {
        return this.f5694s;
    }

    public final boolean isShowStartPositionInfoWindow() {
        return this.f5664D;
    }

    public final boolean isShowStartPositionMarker() {
        return this.f5678c;
    }

    public final boolean isShowStartPositionMarkerInSpan() {
        return this.f5679d;
    }

    public final DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5685j = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("CarIcon descriptor is null");
    }

    public final DisplayOptions setCarInfoWindowView(View view) {
        this.f5661A = view;
        return this;
    }

    public final DisplayOptions setCarPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5672L = i;
        return this;
    }

    public final DisplayOptions setCarPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5688m = i;
        return this;
    }

    public final DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5698w = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("CongestionTrafficTexture descriptor is null");
    }

    public final DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5681f = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("EndPositionIcon descriptor is null");
    }

    public final DisplayOptions setEndPositionInfoWindowView(View view) {
        this.f5663C = view;
        return this;
    }

    public final DisplayOptions setEndPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5669I = i;
        return this;
    }

    public final DisplayOptions setEndPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5684i = i;
        return this;
    }

    public final DisplayOptions setMapViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i2 < 0 || i4 < 0) {
            String str = f5660a;
            C1255a.m10453b(str, "Padding param is invalid. paddingLeft = " + i + "; paddingRight = " + i3 + "; paddingTop = " + i2 + "; paddingBottom = " + i4);
        }
        if (i < 0) {
            i = 30;
        }
        this.f5673M = i;
        if (i2 < 0) {
            i2 = 30;
        }
        this.f5675O = i2;
        if (i3 < 0) {
            i3 = 30;
        }
        this.f5674N = i3;
        if (i4 < 0) {
            i4 = 50;
        }
        this.f5676P = i4;
        return this;
    }

    public final DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5689n = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("PassengerIcon descriptor is null");
    }

    public final DisplayOptions setPassengerMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5692q = i;
        return this;
    }

    public final DisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.f5701z = i;
                return this;
            }
        }
        this.f5701z = i2;
        return this;
    }

    public final DisplayOptions setRouteLineZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5695t = i;
        return this;
    }

    public final DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5699x = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SevereCongestionTrafficTexture descriptor is null");
    }

    public final DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5697v = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SlowTrafficTexture descriptor is null");
    }

    public final DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5696u = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SmoothTrafficTexture descriptor is null");
    }

    public final DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5677b = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("StartPositionIcon descriptor is null");
    }

    public final DisplayOptions setStartPositionInfoWindowView(View view) {
        this.f5662B = view;
        return this;
    }

    public final DisplayOptions setStartPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5666F = i;
        return this;
    }

    public final DisplayOptions setStartPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f5680e = i;
        return this;
    }

    public final DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f5700y = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("UnknownTrafficTexture descriptor is null");
    }

    public final DisplayOptions showCarIcon(boolean z) {
        this.f5686k = z;
        return this;
    }

    public final DisplayOptions showCarIconInSpan(boolean z) {
        this.f5687l = z;
        return this;
    }

    public final DisplayOptions showCarInfoWindow(boolean z) {
        this.f5670J = z;
        return this;
    }

    public final DisplayOptions showCarInfoWindowInSpan(boolean z) {
        this.f5671K = z;
        return this;
    }

    public final DisplayOptions showEndPositionIcon(boolean z) {
        this.f5682g = z;
        return this;
    }

    public final DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.f5683h = z;
        return this;
    }

    public final DisplayOptions showEndPositionInfoWindow(boolean z) {
        this.f5667G = z;
        return this;
    }

    public final DisplayOptions showEndPositionInfoWindowInSpan(boolean z) {
        this.f5668H = z;
        return this;
    }

    public final DisplayOptions showPassengereIcon(boolean z) {
        this.f5690o = z;
        return this;
    }

    public final DisplayOptions showPassengereIconInSpan(boolean z) {
        this.f5691p = z;
        return this;
    }

    public final DisplayOptions showRoutePlan(boolean z) {
        this.f5693r = z;
        return this;
    }

    public final DisplayOptions showRoutePlanInSpan(boolean z) {
        this.f5694s = z;
        return this;
    }

    public final DisplayOptions showStartPositionIcon(boolean z) {
        this.f5678c = z;
        return this;
    }

    public final DisplayOptions showStartPositionIconInSpan(boolean z) {
        this.f5679d = z;
        return this;
    }

    public final DisplayOptions showStartPositionInfoWindow(boolean z) {
        this.f5664D = z;
        return this;
    }

    public final DisplayOptions showStartPositionInfoWindowInSpan(boolean z) {
        this.f5665E = z;
        return this;
    }
}
