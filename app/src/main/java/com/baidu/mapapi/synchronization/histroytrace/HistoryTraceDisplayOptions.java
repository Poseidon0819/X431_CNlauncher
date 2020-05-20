package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public class HistoryTraceDisplayOptions {

    /* renamed from: j */
    private boolean f5744j = true;

    /* renamed from: k */
    private int f5745k = 30;

    /* renamed from: l */
    private int f5746l = 30;

    /* renamed from: m */
    private int f5747m = 30;

    /* renamed from: n */
    private int f5748n = 30;

    /* renamed from: a */
    private BitmapDescriptor f5735a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: b */
    private BitmapDescriptor f5736b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: c */
    private BitmapDescriptor f5737c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: d */
    private BitmapDescriptor f5738d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");

    /* renamed from: e */
    private int f5739e = 22;

    /* renamed from: f */
    private boolean f5740f = true;

    /* renamed from: g */
    private boolean f5741g = true;

    /* renamed from: h */
    private boolean f5742h = false;

    /* renamed from: i */
    private boolean f5743i = true;

    public BitmapDescriptor getCarIcon() {
        return this.f5737c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f5736b;
    }

    public int getPaddingBottom() {
        return this.f5748n;
    }

    public int getPaddingLeft() {
        return this.f5745k;
    }

    public int getPaddingRight() {
        return this.f5746l;
    }

    public int getPaddingTop() {
        return this.f5747m;
    }

    public BitmapDescriptor getRouteLineTexture() {
        return this.f5738d;
    }

    public int getRouteLineWidth() {
        return this.f5739e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f5735a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.f5744j;
    }

    public boolean isShowCarIcon() {
        return this.f5742h;
    }

    public boolean isShowEndPositionIcon() {
        return this.f5741g;
    }

    public boolean isShowRoutePlan() {
        return this.f5743i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f5740f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f5737c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f5736b = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingBottom(int i) {
        this.f5748n = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingLeft(int i) {
        this.f5745k = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingRight(int i) {
        this.f5746l = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingTop(int i) {
        this.f5747m = i;
        return this;
    }

    public void setRouteLineRenderBySubSection(boolean z) {
        this.f5744j = z;
    }

    public HistoryTraceDisplayOptions setRouteLineTexture(BitmapDescriptor bitmapDescriptor) {
        this.f5738d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.f5739e = i;
                return this;
            }
        }
        this.f5739e = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.f5742h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.f5741g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.f5743i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f5740f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f5735a = bitmapDescriptor;
        return this;
    }
}
