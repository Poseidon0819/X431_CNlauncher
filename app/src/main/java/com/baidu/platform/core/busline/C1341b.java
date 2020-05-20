package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;

/* renamed from: com.baidu.platform.core.busline.b */
/* loaded from: classes.dex */
public class C1341b extends AbstractC1323c {
    public C1341b(BusLineSearchOption busLineSearchOption) {
        m9893a(busLineSearchOption);
    }

    /* renamed from: a */
    private void m9893a(BusLineSearchOption busLineSearchOption) {
        this.f6490a.m9767a("qt", "bsl");
        this.f6490a.m9767a("rt_info", "1");
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("oue", "0");
        this.f6490a.m9767a("c", busLineSearchOption.mCity);
        this.f6490a.m9767a("uid", busLineSearchOption.mUid);
        C1384a c1384a = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        c1384a.m9767a("t", sb.toString());
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9775m();
    }
}
