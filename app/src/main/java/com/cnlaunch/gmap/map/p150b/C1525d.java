package com.cnlaunch.gmap.map.p150b;

import com.google.android.gms.maps.C3436c;
import com.google.android.gms.maps.model.CameraPosition;

/* compiled from: BaseMapManager.java */
/* renamed from: com.cnlaunch.gmap.map.b.d */
/* loaded from: classes.dex */
final class C1525d implements C3436c.InterfaceC3437a {

    /* renamed from: a */
    final /* synthetic */ BaseMapManager f7555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1525d(BaseMapManager baseMapManager) {
        this.f7555a = baseMapManager;
    }

    @Override // com.google.android.gms.maps.C3436c.InterfaceC3437a
    /* renamed from: a */
    public final void mo2968a(CameraPosition cameraPosition) {
        float f;
        f = this.f7555a.f7541h;
        if (f == cameraPosition.f19279d || cameraPosition.f19279d == 2.0f) {
            return;
        }
        this.f7555a.f7541h = cameraPosition.f19279d;
    }
}
