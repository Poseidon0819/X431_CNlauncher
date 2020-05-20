package com.cnlaunch.x431pro.activity.setting.wifi;

import android.widget.CompoundButton;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.e */
/* loaded from: classes.dex */
final class C2582e implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2582e(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14878a = dPUWiFiLinkModeSettings;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        DPUWiFiLinkModeSettings.m5882a(this.f14878a, compoundButton, z);
    }
}
