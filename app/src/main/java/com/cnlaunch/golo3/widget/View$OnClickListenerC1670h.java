package com.cnlaunch.golo3.widget;

import android.view.View;
import com.cnlaunch.golo3.widget.PagerSlidingTabStrip;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.golo3.widget.h */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1670h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8850a;

    /* renamed from: b */
    final /* synthetic */ PagerSlidingTabStrip f8851b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1670h(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f8851b = pagerSlidingTabStrip;
        this.f8850a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        PagerSlidingTabStrip.InterfaceC1662d interfaceC1662d;
        PagerSlidingTabStrip.InterfaceC1662d unused;
        if (this.f8851b.f8812j != null && this.f8851b.f8805b) {
            this.f8851b.f8812j.setCurrentItem(this.f8850a);
        } else {
            this.f8851b.f8814l = this.f8850a;
            this.f8851b.f8815m = this.f8850a;
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f8851b;
            i = pagerSlidingTabStrip.f8814l;
            PagerSlidingTabStrip.m8974a(pagerSlidingTabStrip, i, 0);
            this.f8851b.m8973b();
            this.f8851b.invalidate();
        }
        interfaceC1662d = this.f8851b.f8807d;
        if (interfaceC1662d != null) {
            unused = this.f8851b.f8807d;
        }
    }
}
