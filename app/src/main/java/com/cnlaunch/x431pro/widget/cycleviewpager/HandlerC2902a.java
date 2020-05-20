package com.cnlaunch.x431pro.widget.cycleviewpager;

import android.content.Context;
import android.os.Message;

/* compiled from: CycleViewPager.java */
/* renamed from: com.cnlaunch.x431pro.widget.cycleviewpager.a */
/* loaded from: classes.dex */
final class HandlerC2902a extends CycleViewPagerHandler {

    /* renamed from: a */
    final /* synthetic */ CycleViewPager f16572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2902a(CycleViewPager cycleViewPager, Context context) {
        super(context);
        this.f16572a = cycleViewPager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        int i;
        int i2;
        CycleViewPagerHandler cycleViewPagerHandler;
        CycleViewPagerHandler cycleViewPagerHandler2;
        int i3;
        boolean z;
        CycleViewPagerHandler cycleViewPagerHandler3;
        CycleViewPagerHandler cycleViewPagerHandler4;
        int i4;
        int i5;
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        super.handleMessage(message2);
        int i6 = message2.what;
        i = this.f16572a.f16566p;
        if (i6 == i && this.f16572a.f16554d.size() != 0) {
            z = this.f16572a.f16563m;
            if (!z) {
                int size = this.f16572a.f16554d.size() + 1;
                i5 = this.f16572a.f16562l;
                int size2 = (i5 + 1) % this.f16572a.f16554d.size();
                baseViewPager = this.f16572a.f16558h;
                baseViewPager.m14748a(size2, true);
                if (size2 == size) {
                    baseViewPager2 = this.f16572a.f16558h;
                    baseViewPager2.m14748a(1, false);
                }
            }
            this.f16572a.f16565o = System.currentTimeMillis();
            cycleViewPagerHandler3 = this.f16572a.f16561k;
            cycleViewPagerHandler3.removeCallbacks(this.f16572a.f16553c);
            cycleViewPagerHandler4 = this.f16572a.f16561k;
            Runnable runnable = this.f16572a.f16553c;
            i4 = this.f16572a.f16551a;
            cycleViewPagerHandler4.postDelayed(runnable, i4);
            return;
        }
        int i7 = message2.what;
        i2 = this.f16572a.f16567q;
        if (i7 != i2 || this.f16572a.f16554d.size() == 0) {
            return;
        }
        cycleViewPagerHandler = this.f16572a.f16561k;
        cycleViewPagerHandler.removeCallbacks(this.f16572a.f16553c);
        cycleViewPagerHandler2 = this.f16572a.f16561k;
        Runnable runnable2 = this.f16572a.f16553c;
        i3 = this.f16572a.f16551a;
        cycleViewPagerHandler2.postDelayed(runnable2, i3);
    }
}
