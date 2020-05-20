package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.view.View;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradeAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.p */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2619p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDto f15061a;

    /* renamed from: b */
    final /* synthetic */ UpgradeAdapter f15062b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2619p(UpgradeAdapter upgradeAdapter, DivisionSoftDto divisionSoftDto) {
        this.f15062b = upgradeAdapter;
        this.f15061a = divisionSoftDto;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MessageDialog messageDialog = new MessageDialog(this.f15062b.f15033a, this.f15062b.f15033a.getString(R.string.text_softwareintroduction), this.f15061a.getSpfDesc(), true, (byte) 0);
        messageDialog.m4719a(R.string.confirm, true, new View$OnClickListenerC2620q(this));
        messageDialog.show();
    }
}
