package com.cnlaunch.x431pro.activity.mine;

import android.widget.ListView;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;

/* compiled from: CountryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.x */
/* loaded from: classes.dex */
final class C2497x implements SideBar.InterfaceC2960a {

    /* renamed from: a */
    final /* synthetic */ CountryFragment f14333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2497x(CountryFragment countryFragment) {
        this.f14333a = countryFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.sortlistview.SideBar.InterfaceC2960a
    /* renamed from: a */
    public final void mo4392a(String str) {
        AreaAdapter areaAdapter;
        AreaAdapter areaAdapter2;
        ListView listView;
        areaAdapter = this.f14333a.f14326k;
        if (areaAdapter != null) {
            areaAdapter2 = this.f14333a.f14326k;
            int positionForSection = areaAdapter2.getPositionForSection(str.charAt(0));
            if (positionForSection != -1) {
                listView = this.f14333a.f14319d;
                listView.setSelection(positionForSection);
            }
        }
    }
}
