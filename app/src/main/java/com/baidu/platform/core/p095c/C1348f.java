package com.baidu.platform.core.p095c;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.c.f */
/* loaded from: classes.dex */
public class C1348f extends AbstractC1319a implements InterfaceC1343a {

    /* renamed from: b */
    private OnGetPoiSearchResultListener f6514b = null;

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public void mo9881a() {
        this.f6477a.lock();
        this.f6514b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public void mo9880a(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        this.f6477a.lock();
        this.f6514b = onGetPoiSearchResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public boolean mo9879a(PoiBoundSearchOption poiBoundSearchOption) {
        C1349g c1349g = new C1349g(poiBoundSearchOption.mPageNum, poiBoundSearchOption.mPageCapacity);
        c1349g.m9940a(SearchType.POI_IN_BOUND_SEARCH);
        return m9946a(new C1351h(poiBoundSearchOption), this.f6514b, c1349g);
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public boolean mo9878a(PoiCitySearchOption poiCitySearchOption) {
        C1349g c1349g = new C1349g(poiCitySearchOption.mPageNum, poiCitySearchOption.mPageCapacity);
        c1349g.m9940a(SearchType.POI_IN_CITY_SEARCH);
        return m9946a(new C1351h(poiCitySearchOption), this.f6514b, c1349g);
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public boolean mo9877a(PoiDetailSearchOption poiDetailSearchOption) {
        C1346d c1346d = new C1346d();
        if (poiDetailSearchOption != null) {
            c1346d.m9883a(poiDetailSearchOption.isSearchByUids());
        }
        c1346d.m9940a(SearchType.POI_DETAIL_SEARCH);
        return m9946a(new C1347e(poiDetailSearchOption), this.f6514b, c1346d);
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public boolean mo9876a(PoiIndoorOption poiIndoorOption) {
        C1344b c1344b = new C1344b();
        c1344b.m9940a(SearchType.INDOOR_POI_SEARCH);
        return m9946a(new C1345c(poiIndoorOption), this.f6514b, c1344b);
    }

    @Override // com.baidu.platform.core.p095c.InterfaceC1343a
    /* renamed from: a */
    public boolean mo9875a(PoiNearbySearchOption poiNearbySearchOption) {
        C1349g c1349g = new C1349g(poiNearbySearchOption.mPageNum, poiNearbySearchOption.mPageCapacity);
        c1349g.m9940a(SearchType.POI_NEAR_BY_SEARCH);
        return m9946a(new C1351h(poiNearbySearchOption), this.f6514b, c1349g);
    }
}
