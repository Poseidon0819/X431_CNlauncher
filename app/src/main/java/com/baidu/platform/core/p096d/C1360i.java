package com.baidu.platform.core.p096d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.itextpdf.text.Annotation;
import com.mopub.common.AdType;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.d.i */
/* loaded from: classes.dex */
public class C1360i extends AbstractC1323c {
    public C1360i(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        m9836a(massTransitRoutePlanOption);
    }

    /* renamed from: a */
    private void m9836a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            C1384a c1384a = this.f6490a;
            c1384a.m9767a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f6490a.m9767a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.f6490a.m9767a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            C1384a c1384a2 = this.f6490a;
            c1384a2.m9767a(Annotation.DESTINATION, location2.latitude + "," + location2.longitude);
        } else {
            this.f6490a.m9767a(Annotation.DESTINATION, massTransitRoutePlanOption.mTo.getName());
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.f6490a.m9767a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        C1384a c1384a3 = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(massTransitRoutePlanOption.mTacticsIncity.getInt());
        c1384a3.m9767a("tactics_incity", sb.toString());
        C1384a c1384a4 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(massTransitRoutePlanOption.mTacticsIntercity.getInt());
        c1384a4.m9767a("tactics_intercity", sb2.toString());
        C1384a c1384a5 = this.f6490a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(massTransitRoutePlanOption.mTransTypeIntercity.getInt());
        c1384a5.m9767a("trans_type_intercity", sb3.toString());
        C1384a c1384a6 = this.f6490a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(massTransitRoutePlanOption.mPageIndex);
        c1384a6.m9767a("page_index", sb4.toString());
        C1384a c1384a7 = this.f6490a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(massTransitRoutePlanOption.mPageSize);
        c1384a7.m9767a("page_size", sb5.toString());
        this.f6490a.m9767a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9781g();
    }
}
