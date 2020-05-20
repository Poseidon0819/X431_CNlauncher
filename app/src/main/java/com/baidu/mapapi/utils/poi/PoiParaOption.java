package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class PoiParaOption {

    /* renamed from: a */
    String f5790a;

    /* renamed from: b */
    String f5791b;

    /* renamed from: c */
    LatLng f5792c;

    /* renamed from: d */
    int f5793d;

    public PoiParaOption center(LatLng latLng) {
        this.f5792c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f5792c;
    }

    public String getKey() {
        return this.f5791b;
    }

    public int getRadius() {
        return this.f5793d;
    }

    public String getUid() {
        return this.f5790a;
    }

    public PoiParaOption key(String str) {
        this.f5791b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.f5793d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f5790a = str;
        return this;
    }
}
