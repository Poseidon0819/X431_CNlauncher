package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphGridFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aw */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2133aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GraphGridFragment f12056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2133aw(GraphGridFragment graphGridFragment) {
        this.f12056a = graphGridFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        CustomViewPager customViewPager;
        CustomViewPager customViewPager2;
        int i2;
        i = this.f12056a.f12031H;
        if (i > 0) {
            customViewPager = this.f12056a.f12043p;
            if (customViewPager != null) {
                customViewPager2 = this.f12056a.f12043p;
                i2 = this.f12056a.f12031H;
                customViewPager2.setCurrentItem(i2 - 1);
            }
        }
    }
}
