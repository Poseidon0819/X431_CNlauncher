package com.cnlaunch.x431pro.activity.setting.wifi;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DPUWiFiModeSettingsWaitDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.n */
/* loaded from: classes.dex */
public final class HandlerC2590n extends Handler {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiModeSettingsWaitDialog f14890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2590n(DPUWiFiModeSettingsWaitDialog dPUWiFiModeSettingsWaitDialog) {
        this.f14890a = dPUWiFiModeSettingsWaitDialog;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a2;
        DPUWiFiModeConfig dPUWiFiModeConfig;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a3;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a4;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a5;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a6;
        DPUWiFiModeConfig dPUWiFiModeConfig2;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a7;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a8;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a9;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a10;
        DPUWiFiModeConfig unused;
        DPUWiFiModeConfig unused2;
        switch (message2.what) {
            case 0:
                interfaceC2579a = this.f14890a.f14887d;
                if (interfaceC2579a != null) {
                    interfaceC2579a2 = this.f14890a.f14887d;
                    dPUWiFiModeConfig = this.f14890a.f14886c;
                    interfaceC2579a2.mo5854b(dPUWiFiModeConfig);
                }
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
            case 1:
                interfaceC2579a3 = this.f14890a.f14887d;
                if (interfaceC2579a3 != null) {
                    interfaceC2579a4 = this.f14890a.f14887d;
                    unused2 = this.f14890a.f14886c;
                    interfaceC2579a4.mo5855b();
                }
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
            case 2:
                interfaceC2579a5 = this.f14890a.f14887d;
                if (interfaceC2579a5 != null) {
                    interfaceC2579a6 = this.f14890a.f14887d;
                    dPUWiFiModeConfig2 = this.f14890a.f14886c;
                    interfaceC2579a6.mo5852c(dPUWiFiModeConfig2);
                }
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
            case 3:
                interfaceC2579a7 = this.f14890a.f14887d;
                if (interfaceC2579a7 != null) {
                    interfaceC2579a8 = this.f14890a.f14887d;
                    unused = this.f14890a.f14886c;
                    interfaceC2579a8.mo5853c();
                }
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
            case 4:
                interfaceC2579a9 = this.f14890a.f14887d;
                if (interfaceC2579a9 != null) {
                    interfaceC2579a10 = this.f14890a.f14887d;
                    interfaceC2579a10.mo5851d();
                }
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
            default:
                super.handleMessage(message2);
                this.f14890a.hide();
                this.f14890a.dismiss();
                return;
        }
    }
}
