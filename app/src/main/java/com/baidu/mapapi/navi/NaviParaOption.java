package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class NaviParaOption {

    /* renamed from: a */
    LatLng f5420a;

    /* renamed from: b */
    String f5421b;

    /* renamed from: c */
    LatLng f5422c;

    /* renamed from: d */
    String f5423d;

    public NaviParaOption endName(String str) {
        this.f5423d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f5422c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f5423d;
    }

    public LatLng getEndPoint() {
        return this.f5422c;
    }

    public String getStartName() {
        return this.f5421b;
    }

    public LatLng getStartPoint() {
        return this.f5420a;
    }

    public NaviParaOption startName(String str) {
        this.f5421b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f5420a = latLng;
        return this;
    }
}
