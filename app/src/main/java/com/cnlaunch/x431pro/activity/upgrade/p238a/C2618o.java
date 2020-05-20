package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.widget.CompoundButton;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;

/* compiled from: UpgradeAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.o */
/* loaded from: classes.dex */
final class C2618o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDto f15059a;

    /* renamed from: b */
    final /* synthetic */ UpgradeAdapter f15060b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2618o(UpgradeAdapter upgradeAdapter, DivisionSoftDto divisionSoftDto) {
        this.f15060b = upgradeAdapter;
        this.f15059a = divisionSoftDto;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f15059a.setChecked(z);
        this.f15060b.f15036d.mo4708a();
    }
}
