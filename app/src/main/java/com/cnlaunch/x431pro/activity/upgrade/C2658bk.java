package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.ExpandableListView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bk */
/* loaded from: classes.dex */
final class C2658bk implements ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2658bk(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15244a = upgradeFragmentForPro;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        UpgradeAdapter upgradeAdapter;
        UpgradeAdapter upgradeAdapter2;
        UpgradeAdapter upgradeAdapter3;
        UpgradeAdapter upgradeAdapter4;
        NLog.m9456a("yhx", "onGroupClick enter,groupPosition=".concat(String.valueOf(i)));
        try {
            upgradeAdapter = this.f15244a.f15143F;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (upgradeAdapter.m5809a().get(i).isMust()) {
            return true;
        }
        upgradeAdapter2 = this.f15244a.f15143F;
        X431PadDtoSoft x431PadDtoSoft = upgradeAdapter2.m5809a().get(i);
        upgradeAdapter3 = this.f15244a.f15143F;
        x431PadDtoSoft.setChecked(upgradeAdapter3.m5809a().get(i).isChecked() ? false : true);
        upgradeAdapter4 = this.f15244a.f15143F;
        upgradeAdapter4.notifyDataSetChanged();
        this.f15244a.mo4708a();
        return true;
    }
}
