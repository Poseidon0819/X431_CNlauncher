package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.p095c.C1348f;
import com.baidu.platform.core.p095c.InterfaceC1343a;

/* loaded from: classes.dex */
public class PoiSearch extends C1115a {

    /* renamed from: b */
    private boolean f5541b = false;

    /* renamed from: a */
    private InterfaceC1343a f5540a = new C1348f();

    PoiSearch() {
    }

    public static PoiSearch newInstance() {
        BMapManager.init();
        return new PoiSearch();
    }

    public void destroy() {
        if (this.f5541b) {
            return;
        }
        this.f5541b = true;
        this.f5540a.mo9881a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        if (this.f5540a != null) {
            if (poiBoundSearchOption == null || poiBoundSearchOption.mBound == null || poiBoundSearchOption.mKeyword == null) {
                throw new IllegalArgumentException("option or bound or keyworld can not be null");
            }
            return this.f5540a.mo9879a(poiBoundSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        if (this.f5540a != null) {
            if (poiCitySearchOption == null || poiCitySearchOption.mCity == null || poiCitySearchOption.mKeyword == null) {
                throw new IllegalArgumentException("option or city or keyworld can not be null");
            }
            return this.f5540a.mo9878a(poiCitySearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        if (this.f5540a != null) {
            if (poiNearbySearchOption == null || poiNearbySearchOption.mLocation == null || poiNearbySearchOption.mKeyword == null) {
                throw new IllegalArgumentException("option or location or keyworld can not be null");
            }
            if (poiNearbySearchOption.mRadius <= 0) {
                return false;
            }
            return this.f5540a.mo9875a(poiNearbySearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        if (this.f5540a != null) {
            if (poiDetailSearchOption == null || poiDetailSearchOption.getUid() == null) {
                throw new IllegalArgumentException("option or uid can not be null");
            }
            return this.f5540a.mo9877a(poiDetailSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        if (this.f5540a != null) {
            if (poiIndoorOption == null || poiIndoorOption.bid == null || poiIndoorOption.f5530wd == null) {
                throw new IllegalArgumentException("option or indoor bid or keyword can not be null");
            }
            return this.f5540a.mo9876a(poiIndoorOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        InterfaceC1343a interfaceC1343a = this.f5540a;
        if (interfaceC1343a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetPoiSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1343a.mo9880a(onGetPoiSearchResultListener);
    }
}
