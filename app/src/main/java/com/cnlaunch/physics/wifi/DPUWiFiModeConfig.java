package com.cnlaunch.physics.wifi;

import android.net.wifi.WifiConfiguration;
import com.cnlaunch.physics.p205k.C1856n;

/* renamed from: com.cnlaunch.physics.wifi.e */
/* loaded from: classes.dex */
public final class DPUWiFiModeConfig {

    /* renamed from: a */
    public int f10224a;

    /* renamed from: b */
    public WifiConfiguration f10225b;

    /* renamed from: c */
    String f10226c;

    public DPUWiFiModeConfig() {
        this(-1, null, null);
    }

    public DPUWiFiModeConfig(int i, WifiConfiguration wifiConfiguration, String str) {
        this.f10224a = i;
        this.f10225b = wifiConfiguration;
        this.f10226c = str;
    }

    /* renamed from: a */
    public static WifiConfiguration m8037a(String str, int i, String str2) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiModeConfig", String.format(" WifiConfiguration SSID=%s Security=%d Password=%s", str, Integer.valueOf(i), str2));
        }
        wifiConfiguration.SSID = str;
        switch (i) {
            case 0:
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 1:
                wifiConfiguration.allowedKeyManagement.set(0);
                wifiConfiguration.allowedAuthAlgorithms.set(0);
                wifiConfiguration.allowedAuthAlgorithms.set(1);
                if (str2.length() != 0) {
                    int length = str2.length();
                    if (length == 10 || length == 26 || length == 58) {
                        str2.matches("[0-9A-Fa-f]*");
                    }
                    wifiConfiguration.wepKeys[0] = str2;
                    break;
                }
                break;
            case 2:
                wifiConfiguration.allowedKeyManagement.set(1);
                if (str2.length() != 0) {
                    str2.matches("[0-9A-Fa-f]{64}");
                    wifiConfiguration.preSharedKey = str2;
                    break;
                }
                break;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiModeConfig", String.format(" WifiConfiguration SSID=%s Security=%d Password=%s,%s", str, Integer.valueOf(i), wifiConfiguration.wepKeys[0], wifiConfiguration.preSharedKey));
        }
        return wifiConfiguration;
    }
}
