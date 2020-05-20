package com.baidu.platform.core.p094b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.mopub.common.AdType;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.b.f */
/* loaded from: classes.dex */
public class C1339f extends AbstractC1323c {
    public C1339f(ReverseGeoCodeOption reverseGeoCodeOption) {
        m9895a(reverseGeoCodeOption);
    }

    /* renamed from: a */
    private void m9895a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            C1384a c1384a = this.f6490a;
            c1384a.m9767a("location", latLng.latitude + "," + latLng.longitude);
        }
        this.f6490a.m9767a("coordtype", "bd09ll");
        this.f6490a.m9767a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f6490a.m9767a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f6490a.m9767a("pois", "1");
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
        this.f6490a.m9767a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f6490a.m9767a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9783e();
    }
}
