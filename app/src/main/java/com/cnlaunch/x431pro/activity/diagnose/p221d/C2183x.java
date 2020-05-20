package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.support.p012v4.view.ViewPager;
import android.util.Log;
import com.cnlaunch.p181j.RemotePerformClick;

/* compiled from: CombinedGraphFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.x */
/* loaded from: classes.dex */
final class C2183x implements RemotePerformClick.InterfaceC1789d {

    /* renamed from: a */
    final /* synthetic */ CombinedGraphFragment f12410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2183x(CombinedGraphFragment combinedGraphFragment) {
        this.f12410a = combinedGraphFragment;
    }

    @Override // com.cnlaunch.p181j.RemotePerformClick.InterfaceC1789d
    /* renamed from: a */
    public final void mo7104a(int i) {
        ViewPager viewPager;
        ViewPager viewPager2;
        try {
            viewPager = this.f12410a.f12394l;
            if (viewPager != null) {
                viewPager2 = this.f12410a.f12394l;
                viewPager2.setCurrentItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Sanda", "OnScrollPage:" + e.toString());
        }
    }
}
