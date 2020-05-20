package com.cnlaunch.x431pro.activity.login;

import android.widget.ListView;
import com.cnlaunch.x431pro.activity.mine.p229a.AreaAdapter;
import com.cnlaunch.x431pro.widget.sortlistview.SideBar;

/* compiled from: CountrySelectActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.o */
/* loaded from: classes.dex */
final class C2372o implements SideBar.InterfaceC2960a {

    /* renamed from: a */
    final /* synthetic */ CountrySelectActivity f13528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2372o(CountrySelectActivity countrySelectActivity) {
        this.f13528a = countrySelectActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.sortlistview.SideBar.InterfaceC2960a
    /* renamed from: a */
    public final void mo4392a(String str) {
        AreaAdapter areaAdapter;
        AreaAdapter areaAdapter2;
        ListView listView;
        areaAdapter = this.f13528a.f13040K;
        if (areaAdapter != null) {
            areaAdapter2 = this.f13528a.f13040K;
            int positionForSection = areaAdapter2.getPositionForSection(str.charAt(0));
            if (positionForSection != -1) {
                listView = this.f13528a.f13033D;
                listView.setSelection(positionForSection);
            }
        }
    }
}
