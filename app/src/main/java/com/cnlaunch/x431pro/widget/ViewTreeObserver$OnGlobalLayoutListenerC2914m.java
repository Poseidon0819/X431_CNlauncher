package com.cnlaunch.x431pro.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.x431pro.widget.m */
/* loaded from: classes.dex */
public final class ViewTreeObserver$OnGlobalLayoutListenerC2914m implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PagerSlidingTabStrip f16588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC2914m(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f16588a = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        int i;
        if (Build.VERSION.SDK_INT < 16) {
            this.f16588a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f16588a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16588a;
        pagerSlidingTabStrip.f16034i = pagerSlidingTabStrip.f16032g.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f16588a;
        i = pagerSlidingTabStrip2.f16034i;
        PagerSlidingTabStrip.m4763a(pagerSlidingTabStrip2, i, 0);
    }
}
