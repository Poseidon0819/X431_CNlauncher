package com.baidu.platform.core.p095c;

import android.text.TextUtils;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.common.AdType;
import com.unionpay.tsmservice.data.Constant;

/* renamed from: com.baidu.platform.core.c.h */
/* loaded from: classes.dex */
public class C1351h extends AbstractC1323c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1351h(PoiBoundSearchOption poiBoundSearchOption) {
        m9869a(poiBoundSearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1351h(PoiCitySearchOption poiCitySearchOption) {
        m9868a(poiCitySearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1351h(PoiNearbySearchOption poiNearbySearchOption) {
        m9867a(poiNearbySearchOption);
    }

    /* renamed from: a */
    private void m9869a(PoiBoundSearchOption poiBoundSearchOption) {
        this.f6490a.m9767a("query", poiBoundSearchOption.mKeyword);
        this.f6490a.m9767a(Constant.KEY_TAG, poiBoundSearchOption.mTag);
        C1384a c1384a = this.f6490a;
        c1384a.m9767a("bounds", poiBoundSearchOption.mBound.southwest.latitude + "," + poiBoundSearchOption.mBound.southwest.longitude + "," + poiBoundSearchOption.mBound.northeast.latitude + "," + poiBoundSearchOption.mBound.northeast.longitude);
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        C1384a c1384a2 = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(poiBoundSearchOption.mScope);
        c1384a2.m9767a("scope", sb.toString());
        C1384a c1384a3 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(poiBoundSearchOption.mPageNum);
        c1384a3.m9767a("page_num", sb2.toString());
        C1384a c1384a4 = this.f6490a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(poiBoundSearchOption.mPageCapacity);
        c1384a4.m9767a("page_size", sb3.toString());
        if (poiBoundSearchOption.mScope != 2 || poiBoundSearchOption.mPoiFilter == null || TextUtils.isEmpty(poiBoundSearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f6490a.m9767a("filter", poiBoundSearchOption.mPoiFilter.toString());
    }

    /* renamed from: a */
    private void m9868a(PoiCitySearchOption poiCitySearchOption) {
        C1384a c1384a;
        String str;
        String str2;
        this.f6490a.m9767a("query", poiCitySearchOption.mKeyword);
        this.f6490a.m9767a("region", poiCitySearchOption.mCity);
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        C1384a c1384a2 = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(poiCitySearchOption.mPageNum);
        c1384a2.m9767a("page_num", sb.toString());
        C1384a c1384a3 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(poiCitySearchOption.mPageCapacity);
        c1384a3.m9767a("page_size", sb2.toString());
        C1384a c1384a4 = this.f6490a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(poiCitySearchOption.mScope);
        c1384a4.m9767a("scope", sb3.toString());
        this.f6490a.m9767a(Constant.KEY_TAG, poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            c1384a = this.f6490a;
            str = "city_limit";
            str2 = PdfBoolean.TRUE;
        } else {
            c1384a = this.f6490a;
            str = "city_limit";
            str2 = PdfBoolean.FALSE;
        }
        c1384a.m9767a(str, str2);
        if (poiCitySearchOption.mScope != 2 || poiCitySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiCitySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f6490a.m9767a("filter", poiCitySearchOption.mPoiFilter.toString());
    }

    /* renamed from: a */
    private void m9867a(PoiNearbySearchOption poiNearbySearchOption) {
        C1384a c1384a;
        String str;
        String str2;
        this.f6490a.m9767a("query", poiNearbySearchOption.mKeyword);
        C1384a c1384a2 = this.f6490a;
        c1384a2.m9767a("location", poiNearbySearchOption.mLocation.latitude + "," + poiNearbySearchOption.mLocation.longitude);
        C1384a c1384a3 = this.f6490a;
        StringBuilder sb = new StringBuilder();
        sb.append(poiNearbySearchOption.mRadius);
        c1384a3.m9767a("radius", sb.toString());
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        C1384a c1384a4 = this.f6490a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(poiNearbySearchOption.mPageNum);
        c1384a4.m9767a("page_num", sb2.toString());
        C1384a c1384a5 = this.f6490a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(poiNearbySearchOption.mPageCapacity);
        c1384a5.m9767a("page_size", sb3.toString());
        C1384a c1384a6 = this.f6490a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(poiNearbySearchOption.mScope);
        c1384a6.m9767a("scope", sb4.toString());
        this.f6490a.m9767a(Constant.KEY_TAG, poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            c1384a = this.f6490a;
            str = "radius_limit";
            str2 = PdfBoolean.TRUE;
        } else {
            c1384a = this.f6490a;
            str = "radius_limit";
            str2 = PdfBoolean.FALSE;
        }
        c1384a.m9767a(str, str2);
        if (poiNearbySearchOption.mScope != 2 || poiNearbySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiNearbySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f6490a.m9767a("filter", poiNearbySearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9787a();
    }
}
