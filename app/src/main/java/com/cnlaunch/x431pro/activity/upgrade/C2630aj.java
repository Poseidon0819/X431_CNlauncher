package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.aj */
/* loaded from: classes.dex */
final class C2630aj implements ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2630aj(UpgradeFragment upgradeFragment) {
        this.f15127a = upgradeFragment;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        List list;
        List list2;
        List list3;
        List list4;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list5;
        UpgradeAdapter upgradeAdapter2;
        List list6;
        List list7;
        List list8;
        NLog.m9456a("yhx", "onGroupClick enter,groupPosition=".concat(String.valueOf(i)));
        try {
            list = this.f15127a.f15082P;
            if (list != null) {
                list2 = this.f15127a.f15082P;
                if (list2.size() > 0) {
                    list3 = this.f15127a.f15082P;
                    if (!((X431PadDtoSoft) list3.get(i)).isMust()) {
                        list6 = this.f15127a.f15082P;
                        if (((X431PadDtoSoft) list6.get(i)).isChecked()) {
                            list8 = this.f15127a.f15082P;
                            ((X431PadDtoSoft) list8.get(i)).setChecked(false);
                        } else {
                            list7 = this.f15127a.f15082P;
                            ((X431PadDtoSoft) list7.get(i)).setChecked(true);
                        }
                    }
                    this.f15127a.m5781a();
                    list4 = this.f15127a.f15082P;
                    synchronized (list4) {
                        upgradeAdapter = this.f15127a.f15112r;
                        list5 = this.f15127a.f15082P;
                        upgradeAdapter.m5807a(list5);
                        upgradeAdapter2 = this.f15127a.f15112r;
                        upgradeAdapter2.notifyDataSetChanged();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
