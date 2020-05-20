package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettingsActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ao */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2054ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2054ao(DiagnoseActivity diagnoseActivity) {
        this.f11507a = diagnoseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        C1856n.m8130a("DiagnoseActivity", "launch DPUWiFiLinkModeSettingsActivity");
        context = this.f11507a.f11019H;
        Intent intent = new Intent(context, DPUWiFiLinkModeSettingsActivity.class);
        intent.setFlags(67108864);
        context2 = this.f11507a.f11019H;
        context2.startActivity(intent);
    }
}
