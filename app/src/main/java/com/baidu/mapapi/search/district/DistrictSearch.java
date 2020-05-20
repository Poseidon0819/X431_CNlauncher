package com.baidu.mapapi.search.district;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.p093a.C1332d;
import com.baidu.platform.core.p093a.InterfaceC1333e;

/* loaded from: classes.dex */
public class DistrictSearch extends C1115a {

    /* renamed from: a */
    private InterfaceC1333e f5487a;

    /* renamed from: b */
    private boolean f5488b = false;

    DistrictSearch() {
        this.f5487a = null;
        this.f5487a = new C1332d();
    }

    public static DistrictSearch newInstance() {
        BMapManager.init();
        return new DistrictSearch();
    }

    public void destroy() {
        if (this.f5488b) {
            return;
        }
        this.f5488b = true;
        this.f5487a.mo9914a();
        BMapManager.destroy();
    }

    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        if (this.f5487a != null) {
            if (districtSearchOption == null || districtSearchOption.mCityName == null || districtSearchOption.mCityName.equals("")) {
                throw new IllegalArgumentException("option or city name can not be null or empty.");
            }
            return this.f5487a.mo9913a(districtSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        InterfaceC1333e interfaceC1333e = this.f5487a;
        if (interfaceC1333e == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetDistricSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1333e.mo9912a(onGetDistricSearchResultListener);
    }
}
