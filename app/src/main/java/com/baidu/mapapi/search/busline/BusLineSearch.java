package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.busline.C1342c;
import com.baidu.platform.core.busline.IBusLineSearch;

/* loaded from: classes.dex */
public class BusLineSearch extends C1115a {

    /* renamed from: b */
    private boolean f5436b = false;

    /* renamed from: a */
    IBusLineSearch f5435a = new C1342c();

    BusLineSearch() {
    }

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.f5436b) {
            return;
        }
        this.f5436b = true;
        this.f5435a.mo9892a();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        if (this.f5435a != null) {
            if (busLineSearchOption == null || busLineSearchOption.mCity == null || busLineSearchOption.mUid == null) {
                throw new IllegalArgumentException("option or city or uid can not be null");
            }
            return this.f5435a.mo9891a(busLineSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        IBusLineSearch iBusLineSearch = this.f5435a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetBusLineSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        iBusLineSearch.mo9890a(onGetBusLineSearchResultListener);
    }
}
