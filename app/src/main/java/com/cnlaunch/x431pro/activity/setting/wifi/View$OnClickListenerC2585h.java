package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.Intent;
import android.view.View;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC2585h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14881a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2585h(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14881a = dPUWiFiLinkModeSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f14881a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
}
