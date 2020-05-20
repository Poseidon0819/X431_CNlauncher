package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class RouteParaOption {

    /* renamed from: a */
    LatLng f5795a;

    /* renamed from: b */
    LatLng f5796b;

    /* renamed from: c */
    String f5797c;

    /* renamed from: d */
    String f5798d;

    /* renamed from: e */
    String f5799e;

    /* renamed from: f */
    EBusStrategyType f5800f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f5800f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f5799e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f5798d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f5796b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f5800f;
    }

    public String getCityName() {
        return this.f5799e;
    }

    public String getEndName() {
        return this.f5798d;
    }

    public LatLng getEndPoint() {
        return this.f5796b;
    }

    public String getStartName() {
        return this.f5797c;
    }

    public LatLng getStartPoint() {
        return this.f5795a;
    }

    public RouteParaOption startName(String str) {
        this.f5797c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f5795a = latLng;
        return this;
    }
}
