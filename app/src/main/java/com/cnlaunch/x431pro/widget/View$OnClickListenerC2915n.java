package com.cnlaunch.x431pro.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.x431pro.widget.n */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2915n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f16589a;

    /* renamed from: b */
    final /* synthetic */ PagerSlidingTabStrip f16590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2915n(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f16590b = pagerSlidingTabStrip;
        this.f16589a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16590b.f16032g.setCurrentItem(this.f16589a);
    }
}
