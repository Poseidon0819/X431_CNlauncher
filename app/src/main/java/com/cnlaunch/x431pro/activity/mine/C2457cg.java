package com.cnlaunch.x431pro.activity.mine;

import android.widget.ListView;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;

/* compiled from: ProvinceFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cg */
/* loaded from: classes.dex */
final class C2457cg implements SideBar.InterfaceC2960a {

    /* renamed from: a */
    final /* synthetic */ ProvinceFragment f14047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2457cg(ProvinceFragment provinceFragment) {
        this.f14047a = provinceFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.sortlistview.SideBar.InterfaceC2960a
    /* renamed from: a */
    public final void mo4392a(String str) {
        AreaAdapter areaAdapter;
        AreaAdapter areaAdapter2;
        ListView listView;
        areaAdapter = this.f14047a.f14041j;
        if (areaAdapter != null) {
            areaAdapter2 = this.f14047a.f14041j;
            int positionForSection = areaAdapter2.getPositionForSection(str.charAt(0));
            if (positionForSection != -1) {
                listView = this.f14047a.f14034c;
                listView.setSelection(positionForSection);
            }
        }
    }
}
