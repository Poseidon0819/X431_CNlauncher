package com.cnlaunch.golo3.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

/* compiled from: PagerSlidingTabStrip.java */
/* renamed from: com.cnlaunch.golo3.widget.i */
/* loaded from: classes.dex */
final class ViewTreeObserver$OnGlobalLayoutListenerC1671i implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ int f8852a;

    /* renamed from: b */
    final /* synthetic */ PagerSlidingTabStrip f8853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTreeObserver$OnGlobalLayoutListenerC1671i(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f8853b = pagerSlidingTabStrip;
        this.f8852a = i;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        int i;
        if (Build.VERSION.SDK_INT < 16) {
            this.f8853b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f8853b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.f8853b.f8814l = this.f8852a;
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f8853b;
        i = pagerSlidingTabStrip.f8814l;
        PagerSlidingTabStrip.m8974a(pagerSlidingTabStrip, i, 0);
    }
}
