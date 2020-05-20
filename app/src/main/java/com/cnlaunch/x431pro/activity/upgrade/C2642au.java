package com.cnlaunch.x431pro.activity.upgrade;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.ifoer.expedition.pro.R;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.au */
/* loaded from: classes.dex */
final class C2642au implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2642au(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15226a = upgradeFragmentForPro;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        CheckBox checkBox2;
        checkBox = this.f15226a.f15155R;
        if (checkBox != compoundButton) {
            return;
        }
        checkBox2 = this.f15226a.f15155R;
        checkBox2.setText(z ? R.string.common_unselect : R.string.common_select);
    }
}
