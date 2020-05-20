package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphGridFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.av */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2132av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GraphGridFragment f12055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2132av(GraphGridFragment graphGridFragment) {
        this.f12055a = graphGridFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        CustomViewPager customViewPager;
        CustomViewPager customViewPager2;
        int i3;
        i = this.f12055a.f12031H;
        i2 = this.f12055a.f12045r;
        if (i < i2) {
            customViewPager = this.f12055a.f12043p;
            if (customViewPager != null) {
                customViewPager2 = this.f12055a.f12043p;
                i3 = this.f12055a.f12031H;
                customViewPager2.setCurrentItem(i3 + 1);
            }
        }
    }
}
