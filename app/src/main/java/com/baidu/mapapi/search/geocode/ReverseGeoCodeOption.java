package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a */
    private int f5496a = 10;

    /* renamed from: b */
    private int f5497b = 0;

    /* renamed from: c */
    private LatLng f5498c = null;

    /* renamed from: d */
    private int f5499d = 0;

    /* renamed from: e */
    private int f5500e = 1000;

    public int getLatestAdmin() {
        return this.f5499d;
    }

    public LatLng getLocation() {
        return this.f5498c;
    }

    public int getPageNum() {
        return this.f5497b;
    }

    public int getPageSize() {
        return this.f5496a;
    }

    public int getRadius() {
        return this.f5500e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f5498c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.f5499d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f5497b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            i = 10;
        } else if (i > 100) {
            this.f5496a = 100;
            return this;
        }
        this.f5496a = i;
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 1000) {
            this.f5500e = 1000;
            return this;
        }
        this.f5500e = i;
        return this;
    }
}
