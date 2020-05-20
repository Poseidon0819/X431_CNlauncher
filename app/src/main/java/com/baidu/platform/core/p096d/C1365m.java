package com.baidu.platform.core.p096d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.mopub.common.AdType;

/* renamed from: com.baidu.platform.core.d.m */
/* loaded from: classes.dex */
public class C1365m extends AbstractC1323c {
    public C1365m(TransitRoutePlanOption transitRoutePlanOption) {
        m9815a(transitRoutePlanOption);
    }

    /* renamed from: a */
    private void m9815a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f6490a.m9767a("qt", "bus");
        C1384a c1384a = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(transitRoutePlanOption.mPolicy.getInt());
        c1384a.m9767a("sy", sb.toString());
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("lrn", "20");
        this.f6490a.m9767a("version", "3");
        this.f6490a.m9767a("rp_format", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("rp_filter", "mobile");
        this.f6490a.m9767a("ic_info", "2");
        this.f6490a.m9767a("exptype", "depall");
        this.f6490a.m9767a("sn", m9937a(transitRoutePlanOption.mFrom));
        this.f6490a.m9767a("en", m9937a(transitRoutePlanOption.mTo));
        if (transitRoutePlanOption.mCityName != null) {
            this.f6490a.m9767a("c", transitRoutePlanOption.mCityName);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f6490a.m9767a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9780h();
    }
}
