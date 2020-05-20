package com.cnlaunch.wifiprinter;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.cnlaunch.wifiprinter.av */
/* loaded from: classes.dex */
public final class WifiConnect {

    /* renamed from: a */
    WifiManager f10409a;

    /* compiled from: WifiConnect.java */
    /* renamed from: com.cnlaunch.wifiprinter.av$b */
    /* loaded from: classes.dex */
    public enum EnumC1910b {
        WIFICIPHER_WEP,
        WIFICIPHER_WPA,
        WIFICIPHER_NOPASS,
        WIFICIPHER_INVALID
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WifiConnect.java */
    /* renamed from: com.cnlaunch.wifiprinter.av$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1911c {
        /* renamed from: a */
        void mo8005a();
    }

    public WifiConnect(WifiManager wifiManager) {
        this.f10409a = wifiManager;
    }

    /* renamed from: a */
    public final void m8020a(String str, String str2, EnumC1910b enumC1910b) {
        Log.i("EE", "Connect Info:SSID:" + str + " PWD:" + str2 + " TYPE:" + enumC1910b);
        m8019a(str, str2, enumC1910b, null);
    }

    /* renamed from: a */
    public final void m8019a(String str, String str2, EnumC1910b enumC1910b, InterfaceC1911c interfaceC1911c) {
        Log.i("EE", "Connect Info:SSID:" + str + " PWD:" + str2 + " TYPE:" + enumC1910b + "\u3000Listener:" + interfaceC1911c);
        new Thread(new RunnableC1909a(str, str2, enumC1910b, interfaceC1911c)).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WifiConnect.java */
    /* renamed from: com.cnlaunch.wifiprinter.av$a */
    /* loaded from: classes.dex */
    public class RunnableC1909a implements Runnable {

        /* renamed from: b */
        private String f10411b;

        /* renamed from: c */
        private String f10412c;

        /* renamed from: d */
        private EnumC1910b f10413d;

        /* renamed from: e */
        private InterfaceC1911c f10414e;

        public RunnableC1909a(String str, String str2, EnumC1910b enumC1910b, InterfaceC1911c interfaceC1911c) {
            this.f10411b = str;
            this.f10412c = str2;
            this.f10413d = enumC1910b;
            this.f10414e = interfaceC1911c;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WifiConnect wifiConnect = WifiConnect.this;
            if (!wifiConnect.f10409a.isWifiEnabled()) {
                wifiConnect.f10409a.setWifiEnabled(true);
            }
            while (WifiConnect.this.f10409a.getWifiState() == 2) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
            try {
                String str = this.f10411b;
                String str2 = this.f10412c;
                EnumC1910b enumC1910b = this.f10413d;
                WifiConfiguration wifiConfiguration = new WifiConfiguration();
                wifiConfiguration.allowedAuthAlgorithms.clear();
                wifiConfiguration.allowedGroupCiphers.clear();
                wifiConfiguration.allowedKeyManagement.clear();
                wifiConfiguration.allowedPairwiseCiphers.clear();
                wifiConfiguration.allowedProtocols.clear();
                wifiConfiguration.SSID = "\"" + str + "\"";
                if (enumC1910b == EnumC1910b.WIFICIPHER_NOPASS) {
                    wifiConfiguration.wepKeys[0] = "";
                    wifiConfiguration.allowedKeyManagement.set(0);
                    wifiConfiguration.wepTxKeyIndex = 0;
                }
                if (enumC1910b == EnumC1910b.WIFICIPHER_WEP) {
                    if (!TextUtils.isEmpty(str2)) {
                        int length = str2.length();
                        if ((length == 10 || length == 26 || length == 58) ? WifiConnect.m8021a(str2) : false) {
                            wifiConfiguration.wepKeys[0] = str2;
                        } else {
                            String[] strArr = wifiConfiguration.wepKeys;
                            strArr[0] = "\"" + str2 + "\"";
                        }
                    }
                    wifiConfiguration.allowedAuthAlgorithms.set(0);
                    wifiConfiguration.allowedAuthAlgorithms.set(1);
                    wifiConfiguration.allowedKeyManagement.set(0);
                    wifiConfiguration.wepTxKeyIndex = 0;
                }
                if (enumC1910b == EnumC1910b.WIFICIPHER_WPA) {
                    wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                    wifiConfiguration.hiddenSSID = true;
                    wifiConfiguration.allowedAuthAlgorithms.set(0);
                    wifiConfiguration.allowedGroupCiphers.set(2);
                    wifiConfiguration.allowedKeyManagement.set(1);
                    wifiConfiguration.allowedPairwiseCiphers.set(1);
                    wifiConfiguration.allowedGroupCiphers.set(3);
                    wifiConfiguration.allowedPairwiseCiphers.set(2);
                    wifiConfiguration.status = 2;
                }
                WifiConfiguration m8022a = WifiConnect.m8022a(WifiConnect.this, this.f10411b);
                if (m8022a != null) {
                    WifiConnect.this.f10409a.removeNetwork(m8022a.networkId);
                }
                int addNetwork = WifiConnect.this.f10409a.addNetwork(wifiConfiguration);
                if (addNetwork == -1 && this.f10414e != null) {
                    this.f10414e.mo8005a();
                    return;
                }
                boolean enableNetwork = WifiConnect.this.f10409a.enableNetwork(addNetwork, true);
                Log.d("EE", "netId: " + addNetwork + " enable: " + enableNetwork);
                WifiConnect.this.f10409a.reconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static boolean m8021a(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'F') && (charAt < 'a' || charAt > 'f'))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ WifiConfiguration m8022a(WifiConnect wifiConnect, String str) {
        for (WifiConfiguration wifiConfiguration : wifiConnect.f10409a.getConfiguredNetworks()) {
            String str2 = wifiConfiguration.SSID;
            if (str2.equals("\"" + str + "\"")) {
                return wifiConfiguration;
            }
        }
        return null;
    }
}
