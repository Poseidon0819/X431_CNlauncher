package com.cnlaunch.x431pro.activity.setting.wifi;

import android.view.View;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC2584g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14880a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2584g(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14880a = dPUWiFiLinkModeSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f14880a.f14864e != null) {
            DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings = this.f14880a;
            dPUWiFiLinkModeSettings.m5886a(dPUWiFiLinkModeSettings.f14864e.getId());
        }
    }
}
