package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ck */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2167ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextListFragment f12322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2167ck(TextListFragment textListFragment) {
        this.f12322a = textListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        CustomViewPager customViewPager;
        CustomViewPager customViewPager2;
        int i3;
        i = this.f12322a.f12310o;
        i2 = this.f12322a.f12311p;
        if (i < i2) {
            customViewPager = this.f12322a.f12307l;
            if (customViewPager != null) {
                customViewPager2 = this.f12322a.f12307l;
                i3 = this.f12322a.f12310o;
                customViewPager2.setCurrentItem(i3 + 1);
            }
        }
    }
}
