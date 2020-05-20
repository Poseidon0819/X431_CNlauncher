package com.cnlaunch.x431pro.activity.upgrade;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.ifoer.expedition.pro.R;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bh */
/* loaded from: classes.dex */
final class C2655bh implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2655bh(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15241a = upgradeFragmentForPro;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        CheckBox checkBox2;
        checkBox = this.f15241a.f15162Y;
        if (checkBox != compoundButton) {
            return;
        }
        checkBox2 = this.f15241a.f15162Y;
        checkBox2.setText(z ? R.string.common_unselect : R.string.common_select);
    }
}
