package com.cnlaunch.gmap.map.logic.control;

import com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p150b.GoloMapListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloMapBaseActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.j */
/* loaded from: classes.dex */
public final class C1550j implements GoloMapListener.InterfaceC1528b {

    /* renamed from: a */
    final /* synthetic */ GoloMapBaseActivity f7663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1550j(GoloMapBaseActivity goloMapBaseActivity) {
        this.f7663a = goloMapBaseActivity;
    }

    @Override // com.cnlaunch.gmap.map.p150b.GoloMapListener.InterfaceC1528b
    /* renamed from: a */
    public final void mo6552a(int i, LocationResult locationResult) {
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a2;
        boolean z;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a3;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a4;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a5;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a6;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a7;
        GoloMapBaseActivity.InterfaceC1547a interfaceC1547a8;
        GoloMapBaseActivity.InterfaceC1547a unused;
        GoloMapBaseActivity.InterfaceC1547a unused2;
        if (locationResult != null) {
            if (locationResult.getCode() == 0) {
                interfaceC1547a7 = this.f7663a.f7648I;
                if (interfaceC1547a7 != null) {
                    interfaceC1547a8 = this.f7663a.f7648I;
                    interfaceC1547a8.mo9260a(true, locationResult);
                }
            } else {
                interfaceC1547a5 = this.f7663a.f7648I;
                if (interfaceC1547a5 != null) {
                    interfaceC1547a6 = this.f7663a.f7648I;
                    interfaceC1547a6.mo9260a(false, null);
                }
            }
        } else {
            if (i == 2 && !this.f7663a.isFinishing()) {
                GoloMapBaseActivity.m9264c(this.f7663a);
            }
            interfaceC1547a = this.f7663a.f7648I;
            if (interfaceC1547a != null) {
                interfaceC1547a2 = this.f7663a.f7648I;
                interfaceC1547a2.mo9260a(false, null);
            }
        }
        z = this.f7663a.f7660p;
        if (!z) {
            interfaceC1547a4 = this.f7663a.f7648I;
            if (interfaceC1547a4 != null) {
                unused = this.f7663a.f7648I;
                return;
            }
            return;
        }
        GoloMapBaseActivity.m9266b(this.f7663a);
        interfaceC1547a3 = this.f7663a.f7648I;
        if (interfaceC1547a3 != null) {
            unused2 = this.f7663a.f7648I;
        }
    }
}
