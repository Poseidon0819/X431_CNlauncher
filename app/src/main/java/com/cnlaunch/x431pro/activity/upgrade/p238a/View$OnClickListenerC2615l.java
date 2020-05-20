package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.view.View;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* compiled from: UpgradeAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.l */
/* loaded from: classes.dex */
final class View$OnClickListenerC2615l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ X431PadDtoSoft f15051a;

    /* renamed from: b */
    final /* synthetic */ int f15052b;

    /* renamed from: c */
    final /* synthetic */ UpgradeAdapter f15053c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2615l(UpgradeAdapter upgradeAdapter, X431PadDtoSoft x431PadDtoSoft, int i) {
        this.f15053c = upgradeAdapter;
        this.f15051a = x431PadDtoSoft;
        this.f15052b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f15053c.f15036d.mo4707a(view, this.f15051a.getSoftId(), this.f15052b);
    }
}
