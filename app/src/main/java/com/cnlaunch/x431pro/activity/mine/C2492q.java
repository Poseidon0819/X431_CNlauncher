package com.cnlaunch.x431pro.activity.mine;

import android.widget.ListView;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;

/* compiled from: CityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.q */
/* loaded from: classes.dex */
final class C2492q implements SideBar.InterfaceC2960a {

    /* renamed from: a */
    final /* synthetic */ CityFragment f14281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2492q(CityFragment cityFragment) {
        this.f14281a = cityFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.sortlistview.SideBar.InterfaceC2960a
    /* renamed from: a */
    public final void mo4392a(String str) {
        AreaAdapter areaAdapter;
        AreaAdapter areaAdapter2;
        ListView listView;
        areaAdapter = this.f14281a.f14274k;
        if (areaAdapter != null) {
            areaAdapter2 = this.f14281a.f14274k;
            int positionForSection = areaAdapter2.getPositionForSection(str.charAt(0));
            if (positionForSection != -1) {
                listView = this.f14281a.f14267d;
                listView.setSelection(positionForSection);
            }
        }
    }
}
