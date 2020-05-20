package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bn */
/* loaded from: classes.dex */
final class C2661bn implements ExpandableListView.OnChildClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2661bn(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15247a = upgradeFragmentForPro;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        UpgradeAdapter upgradeAdapter;
        UpgradeAdapter upgradeAdapter2;
        NLog.m9456a("yhx", "onChildClick enter,groupPosition=" + i + ",childPos=" + i2);
        try {
            upgradeAdapter = this.f15247a.f15146I;
            DivisionSoftDto divisionSoftDto = upgradeAdapter.m5809a().get(i).getCarDivisionSoftDtoList().get(i2);
            divisionSoftDto.setChecked(divisionSoftDto.isChecked() ? false : true);
            upgradeAdapter2 = this.f15247a.f15146I;
            upgradeAdapter2.notifyDataSetChanged();
            this.f15247a.mo4708a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
