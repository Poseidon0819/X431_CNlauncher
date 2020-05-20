package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.C2778n;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bm */
/* loaded from: classes.dex */
final class C2660bm implements ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2660bm(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15246a = upgradeFragmentForPro;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        UpgradeAdapter upgradeAdapter;
        UpgradeAdapter upgradeAdapter2;
        UpgradeAdapter upgradeAdapter3;
        UpgradeAdapter upgradeAdapter4;
        UpgradeAdapter upgradeAdapter5;
        UpgradeAdapter upgradeAdapter6;
        NLog.m9456a("yhx", "onGroupClick enter,groupPosition=".concat(String.valueOf(i)));
        try {
            upgradeAdapter = this.f15246a.f15146I;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!upgradeAdapter.m5809a().get(i).isMust()) {
            upgradeAdapter2 = this.f15246a.f15146I;
            if (!upgradeAdapter2.m5809a().get(i).isMust()) {
                upgradeAdapter6 = this.f15246a.f15146I;
                if (C2778n.m4902b(upgradeAdapter6.m5809a().get(i).getSoftPackageID())) {
                }
            }
            upgradeAdapter3 = this.f15246a.f15146I;
            X431PadDtoSoft x431PadDtoSoft = upgradeAdapter3.m5809a().get(i);
            upgradeAdapter4 = this.f15246a.f15146I;
            x431PadDtoSoft.setChecked(upgradeAdapter4.m5809a().get(i).isChecked() ? false : true);
            upgradeAdapter5 = this.f15246a.f15146I;
            upgradeAdapter5.notifyDataSetChanged();
            this.f15246a.mo4708a();
            return true;
        }
        return true;
    }
}
