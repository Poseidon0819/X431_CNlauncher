package com.cnlaunch.x431pro.activity.diagnose.p221d;

import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* compiled from: GraphGridFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ax */
/* loaded from: classes.dex */
final class C2134ax implements RemotePerformClick.InterfaceC1789d {

    /* renamed from: a */
    final /* synthetic */ GraphGridFragment f12057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2134ax(GraphGridFragment graphGridFragment) {
        this.f12057a = graphGridFragment;
    }

    @Override // com.cnlaunch.p181j.RemotePerformClick.InterfaceC1789d
    /* renamed from: a */
    public final void mo7104a(int i) {
        CustomViewPager customViewPager;
        int i2;
        CustomViewPager customViewPager2;
        try {
            customViewPager = this.f12057a.f12043p;
            if (customViewPager != null) {
                i2 = this.f12057a.f12031H;
                if (i != i2) {
                    GraphGridFragment.m7214j(this.f12057a);
                }
                customViewPager2 = this.f12057a.f12043p;
                customViewPager2.setCurrentItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
