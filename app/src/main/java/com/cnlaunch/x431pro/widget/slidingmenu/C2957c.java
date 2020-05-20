package com.cnlaunch.x431pro.widget.slidingmenu;

import com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomViewAbove.java */
/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.c */
/* loaded from: classes.dex */
public final class C2957c extends CustomViewAbove.C2955b {

    /* renamed from: a */
    final /* synthetic */ CustomViewAbove f16780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2957c(CustomViewAbove customViewAbove) {
        this.f16780a = customViewAbove;
    }

    @Override // com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.C2955b, com.cnlaunch.x431pro.widget.slidingmenu.CustomViewAbove.InterfaceC2954a
    /* renamed from: a */
    public final void mo4394a(int i) {
        CustomViewBehind customViewBehind;
        CustomViewBehind customViewBehind2;
        CustomViewBehind customViewBehind3;
        customViewBehind = this.f16780a.f16764s;
        if (customViewBehind != null) {
            switch (i) {
                case 0:
                case 2:
                    customViewBehind2 = this.f16780a.f16764s;
                    customViewBehind2.setChildrenEnabled(true);
                    return;
                case 1:
                    customViewBehind3 = this.f16780a.f16764s;
                    customViewBehind3.setChildrenEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
