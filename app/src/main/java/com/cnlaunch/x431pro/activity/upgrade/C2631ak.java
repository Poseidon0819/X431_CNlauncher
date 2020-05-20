package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ak */
/* loaded from: classes.dex */
final class C2631ak implements ExpandableListView.OnChildClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2631ak(UpgradeFragment upgradeFragment) {
        this.f15128a = upgradeFragment;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        List list;
        List list2;
        List list3;
        List list4;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list5;
        UpgradeAdapter upgradeAdapter2;
        NLog.m9456a("yhx", "onChildClick enter,groupPosition=" + i + ",childPos=" + i2);
        try {
            list = this.f15128a.f15082P;
            if (list != null) {
                list2 = this.f15128a.f15082P;
                if (list2.size() > 0) {
                    list3 = this.f15128a.f15082P;
                    DivisionSoftDto divisionSoftDto = ((X431PadDtoSoft) list3.get(i)).getCarDivisionSoftDtoList().get(i2);
                    if (!divisionSoftDto.isMust()) {
                        if (divisionSoftDto.isChecked()) {
                            divisionSoftDto.setChecked(false);
                        } else {
                            divisionSoftDto.setChecked(true);
                        }
                    }
                    this.f15128a.m5781a();
                    list4 = this.f15128a.f15082P;
                    synchronized (list4) {
                        upgradeAdapter = this.f15128a.f15112r;
                        list5 = this.f15128a.f15082P;
                        upgradeAdapter.m5807a(list5);
                        upgradeAdapter2 = this.f15128a.f15112r;
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
