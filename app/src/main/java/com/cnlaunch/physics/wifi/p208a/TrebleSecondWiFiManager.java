package com.cnlaunch.physics.wifi.p208a;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p186m.p187a.SecondWifiManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.wifi.p208a.CustomWiFiControlForDualWiFi;

/* renamed from: com.cnlaunch.physics.wifi.a.e */
/* loaded from: classes.dex */
public final class TrebleSecondWiFiManager implements ISecondWiFiManager {

    /* renamed from: a */
    private SecondWifiManager f10191a = SecondWifiManager.m8617a();

    /* renamed from: b */
    private Context f10192b;

    public TrebleSecondWiFiManager(Context context) {
        this.f10192b = context;
        if (this.f10191a != null) {
            try {
                Log.d("OldSecondWiFiManager", "set SecondWifiManager success version=" + this.f10191a.m8608e());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final boolean mo8057b() {
        boolean z = false;
        try {
            z = this.f10191a.m8609d();
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", " isEnabled() =".concat(String.valueOf(z)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final synchronized boolean mo8058a(boolean z) {
        if (C1856n.f10135a) {
            C1856n.m8130a("OldSecondWiFiManager", "setWifiEnabled(" + z + ") start");
        }
        try {
            if (z) {
                SecondWiFiUtil.m8064a(this.f10192b);
                return this.f10191a.m8614a(true);
            }
            boolean m8614a = this.f10191a.m8614a(false);
            if (m8614a) {
                m8614a = m8060a();
                SecondWiFiUtil.m8061b(this.f10192b);
            }
            return m8614a;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final boolean mo8059a(String str, String str2) {
        try {
            String m8610c = this.f10191a.m8610c("ADD_NETWORK");
            if (!TextUtils.isEmpty(m8610c) && !m8610c.equals("null")) {
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "ADD_NETWORK ".concat(String.valueOf(m8610c)));
                }
                SecondWifiManager secondWifiManager = this.f10191a;
                String m8610c2 = secondWifiManager.m8610c("SET_NETWORK " + m8610c + " ssid \"" + str + "\"");
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8610c + " ssid \"" + str + "\"" + m8610c2);
                }
                if (SecondWiFiUtil.m8063a(m8610c2)) {
                    SecondWifiManager secondWifiManager2 = this.f10191a;
                    String m8610c3 = secondWifiManager2.m8610c("SET_NETWORK " + m8610c + " key_mgmt WPA-PSK");
                    if (C1856n.f10135a) {
                        C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8610c + " key_mgmt WPA-PSK " + m8610c3);
                    }
                    if (SecondWiFiUtil.m8063a(m8610c3)) {
                        SecondWifiManager secondWifiManager3 = this.f10191a;
                        String m8610c4 = secondWifiManager3.m8610c("SET_NETWORK " + m8610c + " psk \"" + str2 + "\"");
                        if (C1856n.f10135a) {
                            C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8610c + " psk \"" + str2 + "\"" + m8610c4);
                        }
                        if (SecondWiFiUtil.m8063a(m8610c4)) {
                            SecondWifiManager secondWifiManager4 = this.f10191a;
                            String m8610c5 = secondWifiManager4.m8610c("SET_NETWORK " + m8610c + " scan_ssid 1");
                            if (C1856n.f10135a) {
                                C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8610c + " scan_ssid 1" + m8610c5);
                            }
                            if (SecondWiFiUtil.m8063a(m8610c5)) {
                                String m8610c6 = this.f10191a.m8610c("SELECT_NETWORK ".concat(String.valueOf(m8610c)));
                                if (C1856n.f10135a) {
                                    C1856n.m8130a("OldSecondWiFiManager", "SELECT_NETWORK ".concat(String.valueOf(m8610c6)));
                                }
                                return SecondWiFiUtil.m8063a(m8610c6);
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: c */
    public final boolean mo8054c() {
        try {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "STATIC start");
            }
            return this.f10191a.m8616a("192.168.100.144");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final CustomWiFiControlForDualWiFi.C1866c mo8056b(String str) {
        String m8612b;
        CustomWiFiControlForDualWiFi.C1866c c1866c = new CustomWiFiControlForDualWiFi.C1866c();
        c1866c.f10173a = str;
        if (!mo8057b()) {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "getCurrentWiFiState state is WPAState.NONE isEnabled() =false");
            }
            return c1866c;
        }
        try {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "STATUS start");
            }
            m8612b = this.f10191a.m8612b("");
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "getCurrentWiFiState STATUS ".concat(String.valueOf(m8612b)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(m8612b) && !m8612b.equals("null")) {
            if (m8612b.equalsIgnoreCase("CONNECTED")) {
                c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.CONNECTED;
            } else if (m8612b.equalsIgnoreCase("CONNECTEDING")) {
                c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.CONNECTING;
            } else {
                c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.NONE;
            }
            return c1866c;
        }
        c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.NONE;
        return c1866c;
    }

    /* renamed from: b */
    private boolean m8055b(String str, String str2) {
        try {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "setIpRule start");
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                str = "192.168.100.0/24";
                str2 = "192.168.100.1";
            }
            if (this.f10191a.m8615a(str, str2)) {
                return this.f10191a.m8613b();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: d */
    public final boolean mo8053d() {
        return m8055b("", "");
    }

    /* renamed from: a */
    private boolean m8060a() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OldSecondWiFiManager", " deleteIpRule ");
        }
        try {
            this.f10191a.m8611c();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
