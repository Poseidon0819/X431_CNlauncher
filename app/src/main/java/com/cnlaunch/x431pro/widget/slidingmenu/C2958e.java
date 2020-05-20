package com.cnlaunch.x431pro.widget.slidingmenu;

import com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SlidingMenu.java */
/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.e */
/* loaded from: classes.dex */
public final class C2958e implements CustomViewAbove.InterfaceC2954a {

    /* renamed from: a */
    final /* synthetic */ SlidingMenu f16797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2958e(SlidingMenu slidingMenu) {
        this.f16797a = slidingMenu;
    }

    @Override // com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.InterfaceC2954a
    /* renamed from: a */
    public final void mo4394a(int i) {
        SlidingMenu.InterfaceC2950b interfaceC2950b;
        SlidingMenu.InterfaceC2952d interfaceC2952d;
        SlidingMenu.InterfaceC2952d unused;
        SlidingMenu.InterfaceC2950b unused2;
        if (i == 0) {
            interfaceC2952d = this.f16797a.f16740c;
            if (interfaceC2952d != null) {
                unused = this.f16797a.f16740c;
                return;
            }
        }
        if (i == 1) {
            interfaceC2950b = this.f16797a.f16741d;
            if (interfaceC2950b != null) {
                unused2 = this.f16797a.f16741d;
            }
        }
    }
}
