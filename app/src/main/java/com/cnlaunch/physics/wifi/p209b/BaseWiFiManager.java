package com.cnlaunch.physics.wifi.p209b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.cnlaunch.physics.wifi.b.a */
/* loaded from: classes.dex */
public class BaseWiFiManager {

    /* renamed from: e */
    private static ConnectivityManager f10216e;

    /* renamed from: a */
    protected WifiManager f10217a;

    /* renamed from: b */
    protected Context f10218b;

    /* renamed from: c */
    protected NetworkInfo f10219c;

    /* renamed from: d */
    protected WifiInfo f10220d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseWiFiManager(Context context) {
        this.f10217a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        f10216e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f10218b = context;
        this.f10219c = null;
        this.f10220d = null;
    }

    /* renamed from: a */
    public final boolean m8049a() {
        WifiManager wifiManager = this.f10217a;
        return wifiManager != null && wifiManager.isWifiEnabled();
    }

    public final void b() {
        WifiManager wifiManager = this.f10217a;
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(true);
        }
    }

    /* renamed from: c */
    public static boolean m8042c() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = f10216e;
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: a */
    public final boolean m8046a(String str) {
        WifiInfo m8039f;
        if (!m8042c() || (m8039f = m8039f()) == null) {
            return false;
        }
        String ssid = m8039f.getSSID();
        return !TextUtils.isEmpty(ssid) && ssid.contains(str);
    }

    /* renamed from: f */
    private WifiInfo m8039f() {
        WifiManager wifiManager = this.f10217a;
        if (wifiManager != null) {
            return wifiManager.getConnectionInfo();
        }
        return null;
    }

    /* renamed from: d */
    public final List<WifiConfiguration> m8041d() {
        WifiManager wifiManager = this.f10217a;
        if (wifiManager != null) {
            return wifiManager.getConfiguredNetworks();
        }
        return null;
    }

    /* renamed from: e */
    public final boolean m8040e() {
        WifiManager wifiManager = this.f10217a;
        return wifiManager != null && wifiManager.saveConfiguration();
    }

    /* renamed from: a */
    public final boolean m8048a(int i) {
        boolean z;
        if (this.f10217a == null) {
            return false;
        }
        WifiInfo m8039f = m8039f();
        if (m8039f != null) {
            int networkId = m8039f.getNetworkId();
            WifiManager wifiManager = this.f10217a;
            if (wifiManager != null) {
                boolean disableNetwork = wifiManager.disableNetwork(networkId);
                boolean disconnect = this.f10217a.disconnect();
                if (!disableNetwork || !disconnect) {
                    z = false;
                }
            } else {
                z = false;
            }
            return !z && this.f10217a.enableNetwork(i, true) && this.f10217a.saveConfiguration() && this.f10217a.reconnect();
        }
        z = true;
        if (z) {
        }
    }

    /* renamed from: b */
    public static String m8043b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "\"" + str + "\"";
    }

    /* renamed from: a */
    public final int m8047a(WifiConfiguration wifiConfiguration) {
        int addNetwork;
        WifiManager wifiManager = this.f10217a;
        if (wifiManager == null || -1 == (addNetwork = wifiManager.addNetwork(wifiConfiguration)) || !this.f10217a.saveConfiguration()) {
            return -1;
        }
        return addNetwork;
    }

    /* renamed from: b */
    public final int m8044b(WifiConfiguration wifiConfiguration) {
        int updateNetwork;
        WifiManager wifiManager = this.f10217a;
        if (wifiManager == null || -1 == (updateNetwork = wifiManager.updateNetwork(wifiConfiguration)) || !this.f10217a.saveConfiguration()) {
            return -1;
        }
        return updateNetwork;
    }
}
