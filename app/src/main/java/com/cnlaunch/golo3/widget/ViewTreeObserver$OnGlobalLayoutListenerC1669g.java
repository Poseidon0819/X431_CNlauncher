package com.cnlaunch.golo3.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.golo3.widget.g */
/* loaded from: classes.dex */
public final class ViewTreeObserver$OnGlobalLayoutListenerC1669g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ PagerSlidingTabStrip f8849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC1669g(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f8849a = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        int i;
        if (Build.VERSION.SDK_INT < 16) {
            this.f8849a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f8849a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f8849a;
        pagerSlidingTabStrip.f8814l = pagerSlidingTabStrip.f8812j.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f8849a;
        i = pagerSlidingTabStrip2.f8814l;
        PagerSlidingTabStrip.m8974a(pagerSlidingTabStrip2, i, 0);
    }
}
