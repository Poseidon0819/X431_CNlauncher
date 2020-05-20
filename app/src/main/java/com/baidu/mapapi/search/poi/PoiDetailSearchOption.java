package com.baidu.mapapi.search.poi;

/* loaded from: classes.dex */
public class PoiDetailSearchOption {

    /* renamed from: a */
    boolean f5509a;

    /* renamed from: b */
    private String f5510b = "";

    /* renamed from: c */
    private String f5511c = "";

    /* renamed from: d */
    private boolean f5512d = false;

    public String getUid() {
        return this.f5510b;
    }

    public String getUids() {
        return this.f5511c;
    }

    public boolean isSearchByUids() {
        return this.f5512d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f5512d = false;
        this.f5510b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f5512d = true;
        this.f5511c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f5509a = z;
        return this;
    }
}
