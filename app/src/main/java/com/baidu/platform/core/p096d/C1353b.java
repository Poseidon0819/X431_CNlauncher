package com.baidu.platform.core.p096d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.itextpdf.text.Annotation;
import com.mopub.common.AdType;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.d.b */
/* loaded from: classes.dex */
public class C1353b extends AbstractC1323c {
    public C1353b(BikingRoutePlanOption bikingRoutePlanOption) {
        m9859a(bikingRoutePlanOption);
    }

    /* renamed from: a */
    private void m9859a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.f6490a.m9767a("mode", "riding");
        LatLng location = bikingRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            C1384a c1384a = this.f6490a;
            c1384a.m9767a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f6490a.m9767a("origin", bikingRoutePlanOption.mFrom.getName());
        }
        LatLng location2 = bikingRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            C1384a c1384a2 = this.f6490a;
            c1384a2.m9767a(Annotation.DESTINATION, location2.latitude + "," + location2.longitude);
        } else {
            this.f6490a.m9767a(Annotation.DESTINATION, bikingRoutePlanOption.mTo.getName());
        }
        this.f6490a.m9767a("origin_region", bikingRoutePlanOption.mFrom.getCity());
        this.f6490a.m9767a("destination_region", bikingRoutePlanOption.mTo.getCity());
        if (bikingRoutePlanOption.mRidingType == 1) {
            this.f6490a.m9767a("riding_type", String.valueOf(bikingRoutePlanOption.mRidingType));
        }
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9778j();
    }
}
