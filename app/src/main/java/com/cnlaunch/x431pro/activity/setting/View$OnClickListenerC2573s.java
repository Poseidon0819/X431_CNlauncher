package com.cnlaunch.x431pro.activity.setting;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.s */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2573s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnosticLogVehicleListFragment f14842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2573s(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        this.f14842a = diagnosticLogVehicleListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f14842a.replaceFragment(OneKeyFeedbackHistoryFragment.class.getName(), 1);
    }
}
