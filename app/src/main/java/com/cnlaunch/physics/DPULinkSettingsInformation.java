package com.cnlaunch.physics;

import android.net.wifi.WifiConfiguration;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.d */
/* loaded from: classes.dex */
public final class DPULinkSettingsInformation {

    /* renamed from: b */
    private static DPULinkSettingsInformation f9870b;

    /* renamed from: c */
    private String f9872c = Environment.getExternalStorageDirectory().getPath() + File.separator + "cnlaunch" + File.separator + "dpu_settings_information.txt";

    /* renamed from: a */
    public PropertyFileOperation f9871a = new PropertyFileOperation(this.f9872c);

    /* renamed from: a */
    public static DPULinkSettingsInformation m8314a() {
        if (f9870b == null) {
            f9870b = new DPULinkSettingsInformation();
        }
        return f9870b;
    }

    /* renamed from: a */
    public final void m8312a(String str, boolean z) {
        this.f9871a.m8089a(String.format("%1s.%2s", str, "link_mode_bluetooth_switch"), Boolean.valueOf(z).toString());
    }

    /* renamed from: a */
    public final boolean m8313a(String str) {
        return Boolean.parseBoolean(this.f9871a.m8090a(String.format("%1s.%2s", str, "link_mode_bluetooth_switch")));
    }

    /* renamed from: a */
    public final void m8311a(String str, boolean z, int i, WifiConfiguration wifiConfiguration) {
        String num;
        String num2;
        ArrayList arrayList = new ArrayList();
        String format = String.format("%1s.%2s", str, "link_mode_wifi_switch");
        String format2 = String.format("%1s.%2s", str, "wifi_work_mode");
        arrayList.add(new Pair(format, Boolean.valueOf(z).toString()));
        try {
            num = Integer.valueOf(i).toString();
        } catch (Exception e) {
            e.printStackTrace();
            Integer num3 = 0;
            num = num3.toString();
        }
        arrayList.add(new Pair(format2, num));
        if (wifiConfiguration != null && i != 1) {
            String format3 = String.format("%1s.%2s", str, "AP_SSID");
            String format4 = String.format("%1s.%2s", str, "AP_SECURITY");
            String format5 = String.format("%1s.%2s", str, "AP_PASSWORD");
            String str2 = wifiConfiguration.SSID;
            int m8122a = NetworkUtil.m8122a(wifiConfiguration);
            String m8121a = NetworkUtil.m8121a(wifiConfiguration, m8122a);
            if (C1856n.f10135a) {
                C1856n.m8130a("DPULinkSettingsInformation", String.format(" saveWiFiPreferencesSetting WifiConfiguration SSID=%s Security=%d Password=%s", str2, Integer.valueOf(m8122a), m8121a));
            }
            try {
                num2 = Integer.valueOf(m8122a).toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                Integer num4 = 0;
                num2 = num4.toString();
            }
            arrayList.add(new Pair(format3, str2));
            arrayList.add(new Pair(format4, num2));
            arrayList.add(new Pair(format5, m8121a));
        }
        this.f9871a.m8088a(arrayList);
    }

    /* renamed from: b */
    public final boolean m8310b(String str) {
        return Boolean.parseBoolean(this.f9871a.m8090a(String.format("%1s.%2s", str, "link_mode_wifi_switch")));
    }

    /* renamed from: c */
    public final int m8309c(String str) {
        String m8090a = this.f9871a.m8090a(String.format("%1s.%2s", str, "wifi_work_mode"));
        if (TextUtils.isEmpty(m8090a)) {
            return 0;
        }
        try {
            return Integer.parseInt(m8090a);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.net.wifi.WifiConfiguration m8308d(java.lang.String r9) {
        /*
            r8 = this;
            com.cnlaunch.physics.n r0 = r8.f9871a
            java.lang.String r1 = "%1s.%2s"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r9
            java.lang.String r5 = "AP_SSID"
            r6 = 1
            r3[r6] = r5
            java.lang.String r1 = java.lang.String.format(r1, r3)
            java.lang.String r0 = r0.m8090a(r1)
            com.cnlaunch.physics.n r1 = r8.f9871a
            java.lang.String r3 = "%1s.%2s"
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r4] = r9
            java.lang.String r7 = "AP_SECURITY"
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            java.lang.String r1 = r1.m8090a(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L3a
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L36
            goto L3b
        L36:
            r1 = move-exception
            r1.printStackTrace()
        L3a:
            r1 = 0
        L3b:
            com.cnlaunch.physics.n r3 = r8.f9871a
            java.lang.String r5 = "%1s.%2s"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r9
            java.lang.String r9 = "AP_PASSWORD"
            r2[r6] = r9
            java.lang.String r9 = java.lang.String.format(r5, r2)
            java.lang.String r9 = r3.m8090a(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 == 0) goto L57
            java.lang.String r9 = ""
        L57:
            android.net.wifi.WifiConfiguration r9 = com.cnlaunch.physics.wifi.DPUWiFiModeConfig.m8037a(r0, r1, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.DPULinkSettingsInformation.m8308d(java.lang.String):android.net.wifi.WifiConfiguration");
    }
}
