package com.cnlaunch.x431pro.activity.setting.wifi;

import android.view.View;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WiFiAccessPointSettingsDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.r */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2593r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WiFiAccessPointSettingsDialog f14906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2593r(WiFiAccessPointSettingsDialog wiFiAccessPointSettingsDialog) {
        this.f14906a = wiFiAccessPointSettingsDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a;
        interfaceC2579a = this.f14906a.f14900m;
        interfaceC2579a.mo5857a();
    }
}
