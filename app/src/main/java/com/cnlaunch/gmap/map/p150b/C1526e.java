package com.cnlaunch.gmap.map.p150b;

import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMapManager.java */
/* renamed from: com.cnlaunch.gmap.map.b.e */
/* loaded from: classes.dex */
public final class C1526e implements LocationSearch.InterfaceC1517a {

    /* renamed from: a */
    final /* synthetic */ BaseMapManager f7556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1526e(BaseMapManager baseMapManager) {
        this.f7556a = baseMapManager;
    }

    @Override // com.cnlaunch.gmap.map.p145a.p146a.LocationSearch.InterfaceC1517a
    /* renamed from: a */
    public final void mo6551a(LocationResult locationResult) {
        if (locationResult != null && locationResult.getLclatlng() != null) {
            this.f7556a.m9350a(locationResult);
        } else {
            this.f7556a.m9350a(new Object[0]);
        }
    }
}
