package com.baidu.platform.core.p093a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.a.d */
/* loaded from: classes.dex */
public class C1332d extends AbstractC1319a implements InterfaceC1333e {

    /* renamed from: b */
    private OnGetDistricSearchResultListener f6507b = null;

    @Override // com.baidu.platform.core.p093a.InterfaceC1333e
    /* renamed from: a */
    public void mo9914a() {
        this.f6477a.lock();
        this.f6507b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p093a.InterfaceC1333e
    /* renamed from: a */
    public void mo9912a(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.f6477a.lock();
        this.f6507b = onGetDistricSearchResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p093a.InterfaceC1333e
    /* renamed from: a */
    public boolean mo9913a(DistrictSearchOption districtSearchOption) {
        C1330b c1330b = new C1330b();
        c1330b.m9940a(SearchType.DISTRICT_SEARCH);
        return m9946a(new C1329a(districtSearchOption), this.f6507b, c1330b);
    }
}
