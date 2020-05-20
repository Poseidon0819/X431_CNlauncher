package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.core.p097e.C1375g;
import com.baidu.platform.core.p097e.InterfaceC1368a;

/* loaded from: classes.dex */
public class ShareUrlSearch extends C1115a {

    /* renamed from: b */
    private boolean f5656b = false;

    /* renamed from: a */
    InterfaceC1368a f5655a = new C1375g();

    ShareUrlSearch() {
    }

    /* renamed from: a */
    private boolean m10949a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static ShareUrlSearch newInstance() {
        BMapManager.init();
        return new ShareUrlSearch();
    }

    public void destroy() {
        if (this.f5656b) {
            return;
        }
        this.f5656b = true;
        this.f5655a.mo9803a();
        BMapManager.destroy();
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        if (this.f5655a != null) {
            if (locationShareURLOption == null || locationShareURLOption.mLocation == null || locationShareURLOption.mName == null || locationShareURLOption.mSnippet == null) {
                throw new IllegalArgumentException("option or name or snippet  can not be null");
            }
            return this.f5655a.mo9802a(locationShareURLOption);
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        if (this.f5655a != null) {
            if (poiDetailShareURLOption == null || poiDetailShareURLOption.mUid == null) {
                throw new IllegalArgumentException("option or uid can not be null");
            }
            return this.f5655a.mo9800a(poiDetailShareURLOption);
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        if (this.f5655a != null) {
            if (routeShareURLOption != null) {
                if (routeShareURLOption.getmMode().ordinal() < 0) {
                    return false;
                }
                if (routeShareURLOption.mFrom == null || routeShareURLOption.mTo == null) {
                    throw new IllegalArgumentException("start or end point can not be null");
                }
                if (routeShareURLOption.mMode == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
                    if ((routeShareURLOption.mFrom.getLocation() == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                        throw new IllegalArgumentException("city code can not be null if don't set start or end point");
                    }
                } else if (routeShareURLOption.mFrom.getLocation() == null && !m10949a(routeShareURLOption.mFrom.getCity())) {
                    throw new IllegalArgumentException("start cityCode must be set if not set start location");
                } else {
                    if (routeShareURLOption.mTo.getLocation() == null && !m10949a(routeShareURLOption.mTo.getCity())) {
                        throw new IllegalArgumentException("end cityCode must be set if not set end location");
                    }
                }
                return this.f5655a.mo9799a(routeShareURLOption);
            }
            throw new IllegalArgumentException("option is null");
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        InterfaceC1368a interfaceC1368a = this.f5655a;
        if (interfaceC1368a == null) {
            throw new IllegalStateException("searcher has been destroyed");
        }
        if (onGetShareUrlResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1368a.mo9801a(onGetShareUrlResultListener);
    }
}
