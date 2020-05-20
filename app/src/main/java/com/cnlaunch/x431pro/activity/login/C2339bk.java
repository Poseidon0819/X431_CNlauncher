package com.cnlaunch.x431pro.activity.login;

import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.gmap.map.p150b.GoloMapListener;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bk */
/* loaded from: classes.dex */
public final class C2339bk implements GoloMapListener.InterfaceC1528b {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2339bk(RegistMerchantActivity registMerchantActivity) {
        this.f13446a = registMerchantActivity;
    }

    @Override // com.cnlaunch.gmap.map.p150b.GoloMapListener.InterfaceC1528b
    /* renamed from: a */
    public final void mo6552a(int i, LocationResult locationResult) {
        if (locationResult == null || locationResult.getCode() != 0) {
            return;
        }
        LocationSearch.m9324a().m9322a(this.f13446a, locationResult.getLclatlng(), LanguageUtils.m9283b(), new C2340bl(this));
    }
}
