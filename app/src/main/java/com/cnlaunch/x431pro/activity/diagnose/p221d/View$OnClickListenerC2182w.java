package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.support.p012v4.view.ViewPager;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CombinedGraphFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.w */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2182w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CombinedGraphFragment f12409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2182w(CombinedGraphFragment combinedGraphFragment) {
        this.f12409a = combinedGraphFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        ViewPager viewPager;
        ViewPager viewPager2;
        int i2;
        i = this.f12409a.f12401t;
        if (i > 0) {
            viewPager = this.f12409a.f12394l;
            if (viewPager != null) {
                viewPager2 = this.f12409a.f12394l;
                i2 = this.f12409a.f12401t;
                viewPager2.setCurrentItem(i2 - 1);
            }
        }
    }
}
