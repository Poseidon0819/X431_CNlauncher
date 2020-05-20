package com.baidu.platform.core.p096d;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.mopub.common.AdType;
import java.util.List;

/* renamed from: com.baidu.platform.core.d.d */
/* loaded from: classes.dex */
public class C1355d extends AbstractC1323c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1355d(DrivingRoutePlanOption drivingRoutePlanOption) {
        m9849a(drivingRoutePlanOption);
    }

    /* renamed from: a */
    private void m9849a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        this.f6490a.m9767a("qt", "cars");
        C1384a c1384a = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(drivingRoutePlanOption.mPolicy.getInt());
        c1384a.m9767a("sy", sb.toString());
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("lrn", "20");
        this.f6490a.m9767a("version", "6");
        this.f6490a.m9767a("extinfo", "32");
        this.f6490a.m9767a("mrs", "1");
        this.f6490a.m9767a("rp_format", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("rp_filter", "mobile");
        C1384a c1384a2 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(drivingRoutePlanOption.mtrafficPolicy.getInt());
        c1384a2.m9767a("route_traffic", sb2.toString());
        this.f6490a.m9767a("sn", m9937a(drivingRoutePlanOption.mFrom));
        this.f6490a.m9767a("en", m9937a(drivingRoutePlanOption.mTo));
        if (drivingRoutePlanOption.mCityName != null) {
            this.f6490a.m9767a("c", drivingRoutePlanOption.mCityName);
        }
        if (drivingRoutePlanOption.mFrom != null) {
            this.f6490a.m9767a("sc", drivingRoutePlanOption.mFrom.getCity());
        }
        if (drivingRoutePlanOption.mTo != null) {
            this.f6490a.m9767a("ec", drivingRoutePlanOption.mTo.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str = new String();
        String str2 = new String();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    str = str + m9937a(planNode);
                    str2 = str2 + planNode.getCity();
                    if (i != list.size() - 1) {
                        str = str + "|";
                        str2 = str2 + "|";
                    }
                }
            }
            this.f6490a.m9767a("wp", str);
            this.f6490a.m9767a("wpc", str2);
        }
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9779i();
    }
}
