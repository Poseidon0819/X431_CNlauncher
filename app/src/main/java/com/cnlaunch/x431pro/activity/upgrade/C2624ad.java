package com.cnlaunch.x431pro.activity.upgrade;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.ifoer.expedition.pro.R;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ad */
/* loaded from: classes.dex */
final class C2624ad implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2624ad(UpgradeFragment upgradeFragment) {
        this.f15121a = upgradeFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        CheckBox checkBox2;
        checkBox = this.f15121a.f15067A;
        if (checkBox != compoundButton) {
            return;
        }
        checkBox2 = this.f15121a.f15067A;
        checkBox2.setText(z ? R.string.common_unselect : R.string.common_select);
    }
}
