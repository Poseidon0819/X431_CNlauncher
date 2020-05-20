package com.baidu.platform.core.p095c;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.mopub.common.AdType;

/* renamed from: com.baidu.platform.core.c.e */
/* loaded from: classes.dex */
public class C1347e extends AbstractC1323c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1347e(PoiDetailSearchOption poiDetailSearchOption) {
        m9882a(poiDetailSearchOption);
    }

    /* renamed from: a */
    private void m9882a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(C1347e.class.getSimpleName(), "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        this.f6490a.m9767a("uids", poiDetailSearchOption.getUids());
        this.f6490a.m9767a("output", AdType.STATIC_NATIVE);
        this.f6490a.m9767a("scope", "2");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9786b();
    }
}
