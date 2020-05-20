package com.cnlaunch.gmap.map.p145a.p146a;

import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;

/* compiled from: LocationInterface.java */
/* renamed from: com.cnlaunch.gmap.map.a.a.e */
/* loaded from: classes.dex */
final class RunnableC1516e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LocationSearch.InterfaceC1517a f7493a;

    /* renamed from: b */
    final /* synthetic */ LocationResult f7494b;

    /* renamed from: c */
    final /* synthetic */ LocationInterface f7495c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1516e(LocationInterface locationInterface, LocationSearch.InterfaceC1517a interfaceC1517a, LocationResult locationResult) {
        this.f7495c = locationInterface;
        this.f7493a = interfaceC1517a;
        this.f7494b = locationResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7493a.mo6551a(this.f7494b);
    }
}
