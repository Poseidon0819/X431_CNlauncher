package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class IndoorPlanNode {

    /* renamed from: a */
    private LatLng f5575a;

    /* renamed from: b */
    private String f5576b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f5575a = null;
        this.f5576b = null;
        this.f5575a = latLng;
        this.f5576b = str;
    }

    public String getFloor() {
        return this.f5576b;
    }

    public LatLng getLocation() {
        return this.f5575a;
    }
}
