package com.cnlaunch.x431pro.activity.setting.wifi;

import android.widget.CompoundButton;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.d */
/* loaded from: classes.dex */
final class C2581d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2581d(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14877a = dPUWiFiLinkModeSettings;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        DPUWiFiLinkModeSettings.m5882a(this.f14877a, compoundButton, z);
    }
}
