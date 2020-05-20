package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.busline.c */
/* loaded from: classes.dex */
public class C1342c extends AbstractC1319a implements IBusLineSearch {

    /* renamed from: b */
    OnGetBusLineSearchResultListener f6511b = null;

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    /* renamed from: a */
    public void mo9892a() {
        this.f6477a.lock();
        this.f6511b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    /* renamed from: a */
    public void mo9890a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        this.f6477a.lock();
        this.f6511b = onGetBusLineSearchResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    /* renamed from: a */
    public boolean mo9891a(BusLineSearchOption busLineSearchOption) {
        C1340a c1340a = new C1340a();
        c1340a.m9940a(SearchType.BUS_LINE_DETAIL);
        return m9946a(new C1341b(busLineSearchOption), this.f6511b, c1340a);
    }
}
