package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class FavoritePoiInfo {

    /* renamed from: a */
    String f4884a;

    /* renamed from: b */
    String f4885b;

    /* renamed from: c */
    LatLng f4886c;

    /* renamed from: d */
    String f4887d;

    /* renamed from: e */
    String f4888e;

    /* renamed from: f */
    String f4889f;

    /* renamed from: g */
    long f4890g;

    public FavoritePoiInfo addr(String str) {
        this.f4887d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f4888e = str;
        return this;
    }

    public String getAddr() {
        return this.f4887d;
    }

    public String getCityName() {
        return this.f4888e;
    }

    public String getID() {
        return this.f4884a;
    }

    public String getPoiName() {
        return this.f4885b;
    }

    public LatLng getPt() {
        return this.f4886c;
    }

    public long getTimeStamp() {
        return this.f4890g;
    }

    public String getUid() {
        return this.f4889f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f4885b = str;
        return this;
    }

    /* renamed from: pt */
    public FavoritePoiInfo m11270pt(LatLng latLng) {
        this.f4886c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f4889f = str;
        return this;
    }
}
