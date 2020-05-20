package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.util.Log;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.widget.CustomViewPager;

/* compiled from: TextListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cm */
/* loaded from: classes.dex */
final class C2169cm implements RemotePerformClick.InterfaceC1789d {

    /* renamed from: a */
    final /* synthetic */ TextListFragment f12324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2169cm(TextListFragment textListFragment) {
        this.f12324a = textListFragment;
    }

    @Override // com.cnlaunch.p181j.RemotePerformClick.InterfaceC1789d
    /* renamed from: a */
    public final void mo7104a(int i) {
        CustomViewPager customViewPager;
        CustomViewPager customViewPager2;
        try {
            customViewPager = this.f12324a.f12307l;
            if (customViewPager != null) {
                customViewPager2 = this.f12324a.f12307l;
                customViewPager2.setCurrentItem(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("Sanda", "OnScrollPage:" + e.toString());
        }
    }
}
