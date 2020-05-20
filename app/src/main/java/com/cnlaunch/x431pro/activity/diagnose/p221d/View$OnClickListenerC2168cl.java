package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cl */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2168cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextListFragment f12323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2168cl(TextListFragment textListFragment) {
        this.f12323a = textListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        CustomViewPager customViewPager;
        CustomViewPager customViewPager2;
        int i2;
        i = this.f12323a.f12310o;
        if (i > 0) {
            customViewPager = this.f12323a.f12307l;
            if (customViewPager != null) {
                customViewPager2 = this.f12323a.f12307l;
                i2 = this.f12323a.f12310o;
                customViewPager2.setCurrentItem(i2 - 1);
            }
        }
    }
}
