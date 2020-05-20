package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DPUDeviceType;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.physics.wifi.DPUWiFiModeSettings;
import com.cnlaunch.physics.wifi.Smartbox30DPUWiFiModeSettings;
import com.cnlaunch.physics.wifi.StandardDPUWiFiModeSettings;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;
import com.ifoer.expedition.pro.R;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.j */
/* loaded from: classes.dex */
final class C2587j extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14883a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2587j(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14883a = dPUWiFiLinkModeSettings;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        int i;
        Context context3;
        Context context4;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a;
        int i2;
        int i3;
        Context context5;
        int i4;
        Context context6;
        int i5;
        int i6;
        int i7;
        Context context7;
        DPUWiFiLinkModeSettings.InterfaceC2579a interfaceC2579a2;
        int i8;
        String action = intent.getAction();
        if (action.equals("DPUDeviceConnectSuccess")) {
            if (C1856n.f10135a) {
                StringBuilder sb = new StringBuilder(" IS_DOWNLOAD_BIN_FIX=");
                sb.append(intent.getBooleanExtra("isFix", false));
                sb.append(" FirmwareFixSubMode =");
                sb.append(DeviceFactoryManager.m8305a().f9907g);
                sb.append(" currentFunctionID=");
                i8 = this.f14883a.f14870k;
                sb.append(i8);
                C1856n.m8130a("DPUWiFiLinkModeSettings", sb.toString());
            }
            if (intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 2) {
                DPUWiFiLinkModeSettings.m5877e(this.f14883a);
                i = this.f14883a.f14870k;
                if (i != R.id.chk_wifi_with_ap_mode) {
                    i5 = this.f14883a.f14870k;
                    if (i5 != R.id.btn_wifi_mode_config_refresh) {
                        i6 = this.f14883a.f14870k;
                        if (i6 != R.id.chk_link_mode_wifi_switch) {
                            i7 = this.f14883a.f14870k;
                            if (i7 == R.id.chk_wifi_with_sta_mode) {
                                String serialNo = DeviceFactoryManager.m8305a().f9901a.getSerialNo();
                                context7 = this.f14883a.mContext;
                                interfaceC2579a2 = this.f14883a.f14875p;
                                new WiFiAccessPointSettingsDialog(context7, serialNo, interfaceC2579a2).show();
                                return;
                            }
                            return;
                        }
                    }
                }
                context3 = this.f14883a.mContext;
                context4 = this.f14883a.mContext;
                context4.getString(R.string.common_title_tips);
                interfaceC2579a = this.f14883a.f14875p;
                DPUWiFiModeSettingsWaitDialog dPUWiFiModeSettingsWaitDialog = new DPUWiFiModeSettingsWaitDialog(context3, "", interfaceC2579a);
                dPUWiFiModeSettingsWaitDialog.setCanceledOnTouchOutside(false);
                dPUWiFiModeSettingsWaitDialog.setCancelable(false);
                i2 = this.f14883a.f14870k;
                if (i2 == R.id.chk_wifi_with_ap_mode) {
                    context6 = this.f14883a.mContext;
                    dPUWiFiModeSettingsWaitDialog.m5847a(context6.getString(R.string.msg_wifi_mode_config_setting));
                    dPUWiFiModeSettingsWaitDialog.show();
                    DPUWiFiModeConfig dPUWiFiModeConfig = new DPUWiFiModeConfig();
                    dPUWiFiModeConfig.f10224a = 1;
                    dPUWiFiModeSettingsWaitDialog.m5850a(DeviceFactoryManager.m8305a().f9901a, dPUWiFiModeConfig);
                    return;
                }
                i3 = this.f14883a.f14870k;
                if (i3 != R.id.btn_wifi_mode_config_refresh) {
                    i4 = this.f14883a.f14870k;
                    if (i4 != R.id.chk_link_mode_wifi_switch) {
                        return;
                    }
                }
                context5 = this.f14883a.mContext;
                dPUWiFiModeSettingsWaitDialog.m5847a(context5.getString(R.string.msg_wifi_mode_config_get_setting));
                dPUWiFiModeSettingsWaitDialog.show();
                DPUWiFiModeSettings dPUWiFiModeSettings = new DPUWiFiModeSettings(DeviceFactoryManager.m8305a().f9901a, dPUWiFiModeSettingsWaitDialog.f14885a);
                if (dPUWiFiModeSettings.f10229c == DPUDeviceType.f9692b) {
                    new Thread(new Smartbox30DPUWiFiModeSettings.RunnableC1871a(dPUWiFiModeSettings.f10228b, dPUWiFiModeSettings.f10227a)).start();
                } else {
                    new Thread(new StandardDPUWiFiModeSettings.RunnableC1873a(dPUWiFiModeSettings.f10228b, dPUWiFiModeSettings.f10227a)).start();
                }
            }
        } else if (action.equals("DPUDeviceConnectFail") && intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 2) {
            context2 = this.f14883a.mContext;
            NToast.m9449a(context2, intent.getStringExtra(MessageDao.TABLENAME));
            DeviceFactoryManager.m8305a().m8293b();
            DeviceFactoryManager.m8305a().m8288c();
        }
    }
}
