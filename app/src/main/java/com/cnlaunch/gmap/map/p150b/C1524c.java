package com.cnlaunch.gmap.map.p150b;

import android.os.RemoteException;
import com.cnlaunch.gmap.map.p150b.GoloSupportMapFragment;
import com.google.android.gms.maps.BinderC3441d;
import com.google.android.gms.maps.BinderC3442e;
import com.google.android.gms.maps.BinderC3444g;
import com.google.android.gms.maps.C3436c;
import com.google.android.gms.maps.model.C3487l;
import com.google.android.gms.maps.p346a.InterfaceC3411p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMapManager.java */
/* renamed from: com.cnlaunch.gmap.map.b.c */
/* loaded from: classes.dex */
public final class C1524c implements GoloSupportMapFragment.InterfaceC1530a {

    /* renamed from: a */
    final /* synthetic */ BaseMapManager f7554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1524c(BaseMapManager baseMapManager) {
        this.f7554a = baseMapManager;
    }

    @Override // com.cnlaunch.gmap.map.p150b.GoloSupportMapFragment.InterfaceC1530a
    /* renamed from: a */
    public final void mo9300a() {
        BaseMapManager baseMapManager = this.f7554a;
        if (baseMapManager.m9319a() != null) {
            C3436c c3436c = baseMapManager.f7538e;
            try {
                c3436c.f19258a.mo3082a(new BinderC3444g(c3436c, baseMapManager));
                C3436c c3436c2 = baseMapManager.f7538e;
                MapListener mapListener = baseMapManager.f7544l;
                try {
                    if (mapListener == null) {
                        c3436c2.f19258a.mo3084a((InterfaceC3411p) null);
                    } else {
                        c3436c2.f19258a.mo3084a(new BinderC3441d(c3436c2, mapListener));
                    }
                    try {
                        baseMapManager.f7538e.m2969d().f19275a.mo3024a(false);
                        try {
                            baseMapManager.f7538e.m2969d().f19275a.mo3020c(false);
                            C3436c c3436c3 = baseMapManager.f7538e;
                            try {
                                c3436c3.f19258a.mo3087a(new BinderC3442e(c3436c3, new C1525d(baseMapManager)));
                            } catch (RemoteException e) {
                                throw new C3487l(e);
                            }
                        } catch (RemoteException e2) {
                            throw new C3487l(e2);
                        }
                    } catch (RemoteException e3) {
                        throw new C3487l(e3);
                    }
                } catch (RemoteException e4) {
                    throw new C3487l(e4);
                }
            } catch (RemoteException e5) {
                throw new C3487l(e5);
            }
        }
    }
}
