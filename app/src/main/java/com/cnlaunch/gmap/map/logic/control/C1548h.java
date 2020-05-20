package com.cnlaunch.gmap.map.logic.control;

import android.util.Log;
import com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity;
import com.cnlaunch.gmap.map.p150b.GoloMapListener;
import com.cnlaunch.gmap.map.p150b.MapManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloMapBaseActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.h */
/* loaded from: classes.dex */
public final class C1548h implements GoloMapListener.InterfaceC1527a {

    /* renamed from: a */
    final /* synthetic */ GoloMapBaseActivity f7661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1548h(GoloMapBaseActivity goloMapBaseActivity) {
        this.f7661a = goloMapBaseActivity;
    }

    @Override // com.cnlaunch.gmap.map.p150b.GoloMapListener.InterfaceC1527a
    /* renamed from: a */
    public final void mo9258a() {
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a2;
        if (this.f7661a.f7644E != null) {
            MapManager mapManager = this.f7661a.f7644E;
            Log.v("MapManager", "initMap");
            mapManager.m9319a();
        }
        interfaceC1547a = this.f7661a.f7648I;
        if (interfaceC1547a != null) {
            interfaceC1547a2 = this.f7661a.f7648I;
            interfaceC1547a2.mo9259b();
        }
    }
}
