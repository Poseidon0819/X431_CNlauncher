package com.cnlaunch.x431pro.widget.cycleviewpager;

import android.view.View;
import com.cnlaunch.x431pro.module.p252d.p254b.AdvertiseResponse;
import com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager;

/* compiled from: CycleViewPager.java */
/* renamed from: com.cnlaunch.x431pro.widget.cycleviewpager.c */
/* loaded from: classes.dex */
final class View$OnClickListenerC2904c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CycleViewPager.C2901b f16574a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2904c(CycleViewPager.C2901b c2901b) {
        this.f16574a = c2901b;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AdvertiseResponse[] advertiseResponseArr;
        int i;
        AdvertiseResponse[] advertiseResponseArr2;
        int i2;
        AdvertiseResponse[] advertiseResponseArr3;
        int i3;
        int unused;
        int unused2;
        advertiseResponseArr = CycleViewPager.this.f16569s;
        if (advertiseResponseArr != null) {
            i = CycleViewPager.this.f16562l;
            if (i == 0) {
                CycleViewPager.InterfaceC2900a interfaceC2900a = CycleViewPager.this.f16568r;
                advertiseResponseArr3 = CycleViewPager.this.f16569s;
                i3 = CycleViewPager.this.f16562l;
                AdvertiseResponse advertiseResponse = advertiseResponseArr3[i3];
                unused = CycleViewPager.this.f16562l;
                interfaceC2900a.mo4481a(advertiseResponse);
                return;
            }
            CycleViewPager.InterfaceC2900a interfaceC2900a2 = CycleViewPager.this.f16568r;
            advertiseResponseArr2 = CycleViewPager.this.f16569s;
            i2 = CycleViewPager.this.f16562l;
            AdvertiseResponse advertiseResponse2 = advertiseResponseArr2[i2 - 1];
            unused2 = CycleViewPager.this.f16562l;
            interfaceC2900a2.mo4481a(advertiseResponse2);
        }
    }
}
