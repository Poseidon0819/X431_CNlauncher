package com.baidu.platform.core.p098f;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.common.AdType;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.f.d */
/* loaded from: classes.dex */
public class C1379d extends AbstractC1323c {
    public C1379d(SuggestionSearchOption suggestionSearchOption) {
        m9789a(suggestionSearchOption);
    }

    /* renamed from: a */
    private void m9789a(SuggestionSearchOption suggestionSearchOption) {
        C1384a c1384a;
        String str;
        String str2;
        this.f6490a.m9767a("q", suggestionSearchOption.mKeyword);
        this.f6490a.m9767a("region", suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(suggestionSearchOption.mLocation.latitude, suggestionSearchOption.mLocation.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            C1384a c1384a2 = this.f6490a;
            c1384a2.m9767a("location", latLng.latitude + "," + latLng.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            c1384a = this.f6490a;
            str = "city_limit";
            str2 = PdfBoolean.TRUE;
        } else {
            c1384a = this.f6490a;
            str = "city_limit";
            str2 = PdfBoolean.FALSE;
        }
        c1384a.m9767a(str, str2);
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9784d();
    }
}
