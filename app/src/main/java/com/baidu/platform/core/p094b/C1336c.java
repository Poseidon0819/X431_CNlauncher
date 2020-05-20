package com.baidu.platform.core.p094b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.mopub.common.AdType;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.b.c */
/* loaded from: classes.dex */
public class C1336c extends AbstractC1323c {
    public C1336c(GeoCodeOption geoCodeOption) {
        m9908a(geoCodeOption);
    }

    /* renamed from: a */
    private void m9908a(GeoCodeOption geoCodeOption) {
        this.f6490a.m9767a("city", geoCodeOption.mCity);
        this.f6490a.m9767a("address", geoCodeOption.mAddress);
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("ret_coordtype", "bd09ll");
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9782f();
    }
}
