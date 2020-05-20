package com.baidu.platform.core.p097e;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.itextpdf.text.Annotation;

/* renamed from: com.baidu.platform.core.e.c */
/* loaded from: classes.dex */
public class C1370c extends AbstractC1323c {
    public C1370c(PoiDetailShareURLOption poiDetailShareURLOption) {
        m9806a(poiDetailShareURLOption);
    }

    /* renamed from: a */
    private void m9806a(PoiDetailShareURLOption poiDetailShareURLOption) {
        this.f6490a.m9767a(Annotation.URL, ("http://wapmap.baidu.com/s?tn=Detail&pid=" + poiDetailShareURLOption.mUid + "&smsf=3") + HttpClient.getPhoneInfo());
        m9935b(false);
        m9936a(false);
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9772p();
    }
}
