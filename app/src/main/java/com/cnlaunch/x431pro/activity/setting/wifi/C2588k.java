package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;
import com.ifoer.expedition.pro.R;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.k */
/* loaded from: classes.dex */
final class C2588k implements DPUWiFiLinkModeSettings.InterfaceC2579a {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2588k(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14884a = dPUWiFiLinkModeSettings;
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: a */
    public final void mo5856a(DPUWiFiModeConfig dPUWiFiModeConfig) {
        Context context;
        Context context2;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a;
        Context context3;
        context = this.f14884a.mContext;
        context2 = this.f14884a.mContext;
        context2.getString(R.string.common_title_tips);
        interfaceC2579a = this.f14884a.f14875p;
        DPUWiFiModeSettingsWaitDialog dPUWiFiModeSettingsWaitDialog = new DPUWiFiModeSettingsWaitDialog(context, "", interfaceC2579a);
        dPUWiFiModeSettingsWaitDialog.setCanceledOnTouchOutside(false);
        dPUWiFiModeSettingsWaitDialog.setCancelable(false);
        context3 = this.f14884a.mContext;
        dPUWiFiModeSettingsWaitDialog.m5847a(context3.getString(R.string.msg_wifi_mode_config_setting));
        dPUWiFiModeSettingsWaitDialog.show();
        dPUWiFiModeSettingsWaitDialog.m5850a(DeviceFactoryManager.m8305a().f9901a, dPUWiFiModeConfig);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: a */
    public final void mo5857a() {
        Context context;
        context = this.f14884a.mContext;
        NToast.m9444c(context, (int) R.string.msg_wifi_network_add_cancel);
        this.f14884a.m5887a();
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: b */
    public final void mo5854b(DPUWiFiModeConfig dPUWiFiModeConfig) {
        Context context;
        context = this.f14884a.mContext;
        NToast.m9444c(context, (int) R.string.msg_wifi_mode_config_success);
        if (dPUWiFiModeConfig.f10224a == 1) {
            this.f14884a.m5881a(true, 1, (WifiConfiguration) null);
        } else if (dPUWiFiModeConfig.f10224a == 2) {
            this.f14884a.m5881a(true, 2, dPUWiFiModeConfig.f10225b);
        }
        this.f14884a.m5887a();
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: b */
    public final void mo5855b() {
        Context context;
        context = this.f14884a.mContext;
        NToast.m9444c(context, (int) R.string.msg_wifi_mode_config_fail);
        this.f14884a.m5887a();
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: c */
    public final void mo5852c(DPUWiFiModeConfig dPUWiFiModeConfig) {
        Context context;
        context = this.f14884a.mContext;
        NToast.m9444c(context, (int) R.string.msg_wifi_mode_config_get_success);
        this.f14884a.m5881a(true, dPUWiFiModeConfig.f10224a, dPUWiFiModeConfig.f10225b);
        this.f14884a.m5887a();
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: c */
    public final void mo5853c() {
        Context context;
        context = this.f14884a.mContext;
        NToast.m9444c(context, (int) R.string.msg_wifi_mode_config_get_fail);
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings.InterfaceC2579a
    /* renamed from: d */
    public final void mo5851d() {
        Context context;
        Context context2;
        Context context3;
        int i;
        this.f14884a.m5887a();
        DPUWiFiLinkModeSettings.m5865q(this.f14884a);
        context = this.f14884a.mContext;
        String m9591a = PreferencesManager.m9595a(context).m9591a("serialNo");
        DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
        context2 = this.f14884a.mContext;
        if (m8305a.m8296a(true, context2, m9591a) != 3) {
            context3 = this.f14884a.mContext;
            NToast.m9444c(context3, (int) R.string.connector_reset_fail_process_tips);
            return;
        }
        DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings = this.f14884a;
        i = dPUWiFiLinkModeSettings.f14870k;
        dPUWiFiLinkModeSettings.m5886a(i);
    }
}
