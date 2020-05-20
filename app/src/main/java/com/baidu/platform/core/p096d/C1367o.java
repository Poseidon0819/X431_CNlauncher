package com.baidu.platform.core.p096d;

import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.mopub.common.AdType;

/* renamed from: com.baidu.platform.core.d.o */
/* loaded from: classes.dex */
public class C1367o extends AbstractC1323c {
    public C1367o(WalkingRoutePlanOption walkingRoutePlanOption) {
        m9808a(walkingRoutePlanOption);
    }

    /* renamed from: a */
    private void m9808a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f6490a.m9767a("qt", "walk2");
        this.f6490a.m9767a("sn", m9937a(walkingRoutePlanOption.mFrom));
        this.f6490a.m9767a("en", m9937a(walkingRoutePlanOption.mTo));
        if (walkingRoutePlanOption.mFrom != null) {
            this.f6490a.m9767a("sc", walkingRoutePlanOption.mFrom.getCity());
        }
        if (walkingRoutePlanOption.mTo != null) {
            this.f6490a.m9767a("ec", walkingRoutePlanOption.mTo.getCity());
        }
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("lrn", "20");
        this.f6490a.m9767a("version", "3");
        this.f6490a.m9767a("rp_format", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9777k();
    }
}
