package com.baidu.platform.core.p094b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.b.a */
/* loaded from: classes.dex */
public class C1334a extends AbstractC1319a implements InterfaceC1337d {

    /* renamed from: b */
    OnGetGeoCoderResultListener f6508b = null;

    @Override // com.baidu.platform.core.p094b.InterfaceC1337d
    /* renamed from: a */
    public void mo9907a() {
        this.f6477a.lock();
        this.f6508b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p094b.InterfaceC1337d
    /* renamed from: a */
    public void mo9905a(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        this.f6477a.lock();
        this.f6508b = onGetGeoCoderResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p094b.InterfaceC1337d
    /* renamed from: a */
    public boolean mo9906a(GeoCodeOption geoCodeOption) {
        C1335b c1335b = new C1335b();
        AbstractC1323c c1336c = new C1336c(geoCodeOption);
        c1335b.m9940a(SearchType.GEO_CODER);
        if (geoCodeOption != null) {
            c1335b.m9909b(geoCodeOption.getAddress());
        }
        return m9946a(c1336c, this.f6508b, c1335b);
    }

    @Override // com.baidu.platform.core.p094b.InterfaceC1337d
    /* renamed from: a */
    public boolean mo9904a(ReverseGeoCodeOption reverseGeoCodeOption) {
        C1338e c1338e = new C1338e();
        C1339f c1339f = new C1339f(reverseGeoCodeOption);
        c1338e.m9940a(SearchType.REVERSE_GEO_CODER);
        return m9946a(c1339f, this.f6508b, c1338e);
    }
}
