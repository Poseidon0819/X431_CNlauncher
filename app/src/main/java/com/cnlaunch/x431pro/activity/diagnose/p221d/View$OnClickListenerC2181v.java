package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.support.p012v4.view.ViewPager;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CombinedGraphFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.v */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2181v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CombinedGraphFragment f12408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2181v(CombinedGraphFragment combinedGraphFragment) {
        this.f12408a = combinedGraphFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        ViewPager viewPager;
        ViewPager viewPager2;
        int i3;
        i = this.f12408a.f12401t;
        i2 = this.f12408a.f12391i;
        if (i < i2) {
            viewPager = this.f12408a.f12394l;
            if (viewPager != null) {
                viewPager2 = this.f12408a.f12394l;
                i3 = this.f12408a.f12401t;
                viewPager2.setCurrentItem(i3 + 1);
            }
        }
    }
}
