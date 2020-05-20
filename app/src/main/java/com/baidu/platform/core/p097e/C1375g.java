package com.baidu.platform.core.p097e;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.e.g */
/* loaded from: classes.dex */
public class C1375g extends AbstractC1319a implements InterfaceC1368a {

    /* renamed from: b */
    OnGetShareUrlResultListener f6524b = null;

    @Override // com.baidu.platform.core.p097e.InterfaceC1368a
    /* renamed from: a */
    public void mo9803a() {
        this.f6477a.lock();
        this.f6524b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p097e.InterfaceC1368a
    /* renamed from: a */
    public void mo9801a(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        this.f6477a.lock();
        this.f6524b = onGetShareUrlResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p097e.InterfaceC1368a
    /* renamed from: a */
    public boolean mo9802a(LocationShareURLOption locationShareURLOption) {
        C1373f c1373f = new C1373f();
        c1373f.m9940a(SearchType.LOCATION_SEARCH_SHARE);
        return m9946a(new C1369b(locationShareURLOption), this.f6524b, c1373f);
    }

    @Override // com.baidu.platform.core.p097e.InterfaceC1368a
    /* renamed from: a */
    public boolean mo9800a(PoiDetailShareURLOption poiDetailShareURLOption) {
        C1373f c1373f = new C1373f();
        c1373f.m9940a(SearchType.POI_DETAIL_SHARE);
        return m9946a(new C1370c(poiDetailShareURLOption), this.f6524b, c1373f);
    }

    @Override // com.baidu.platform.core.p097e.InterfaceC1368a
    /* renamed from: a */
    public boolean mo9799a(RouteShareURLOption routeShareURLOption) {
        C1371d c1371d = new C1371d();
        c1371d.m9940a(SearchType.ROUTE_PLAN_SHARE);
        return m9946a(new C1372e(routeShareURLOption), this.f6524b, c1371d);
    }
}
