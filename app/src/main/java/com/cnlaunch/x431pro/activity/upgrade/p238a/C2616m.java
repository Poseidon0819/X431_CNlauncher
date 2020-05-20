package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.widget.CompoundButton;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* compiled from: UpgradeAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.m */
/* loaded from: classes.dex */
final class C2616m implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ X431PadDtoSoft f15054a;

    /* renamed from: b */
    final /* synthetic */ UpgradeAdapter f15055b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2616m(UpgradeAdapter upgradeAdapter, X431PadDtoSoft x431PadDtoSoft) {
        this.f15055b = upgradeAdapter;
        this.f15054a = x431PadDtoSoft;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f15054a.setChecked(z);
        this.f15055b.f15036d.mo4708a();
    }
}
