package com.baidu.platform.core.p096d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.mopub.common.AdType;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.baidu.platform.core.d.g */
/* loaded from: classes.dex */
public class C1358g extends AbstractC1323c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1358g(IndoorRoutePlanOption indoorRoutePlanOption) {
        m9846a(indoorRoutePlanOption);
    }

    /* renamed from: a */
    private void m9846a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.f6490a.m9767a("qt", "indoornavi");
        this.f6490a.m9767a("rp_format", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("version", "1");
        GeoPoint ll2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (ll2mc != null) {
            String format = String.format("%f,%f", Double.valueOf(ll2mc.getLongitudeE6()), Double.valueOf(ll2mc.getLatitudeE6()));
            this.f6490a.m9767a("sn", (format + "|" + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, ""));
        }
        GeoPoint ll2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (ll2mc2 != null) {
            String format2 = String.format("%f,%f", Double.valueOf(ll2mc2.getLongitudeE6()), Double.valueOf(ll2mc2.getLatitudeE6()));
            this.f6490a.m9767a("en", (format2 + "|" + indoorRoutePlanOption.mTo.getFloor()).replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, ""));
        }
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9776l();
    }
}
