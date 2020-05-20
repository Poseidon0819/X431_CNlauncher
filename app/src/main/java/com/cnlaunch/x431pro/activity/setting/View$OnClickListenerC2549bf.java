package com.cnlaunch.x431pro.activity.setting;

import android.view.View;

/* compiled from: SettingFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.bf */
/* loaded from: classes.dex */
final class View$OnClickListenerC2549bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f14682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2549bf(SettingFragment settingFragment) {
        this.f14682a = settingFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f14682a.replaceFragment(DiagnosticLogVehicleListFragment.class.getName(), 1);
        SettingFragment.m5962c(this.f14682a);
    }
}
