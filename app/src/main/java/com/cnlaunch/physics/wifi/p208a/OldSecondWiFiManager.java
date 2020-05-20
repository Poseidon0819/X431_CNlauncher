package com.cnlaunch.physics.wifi.p208a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.wifi.p208a.CustomWiFiControlForDualWiFi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.cnlaunch.physics.wifi.a.c */
/* loaded from: classes.dex */
public final class OldSecondWiFiManager implements ISecondWiFiManager {

    /* renamed from: a */
    boolean f10175a;

    /* renamed from: b */
    boolean f10176b;

    /* renamed from: c */
    boolean f10177c;

    /* renamed from: d */
    boolean f10178d;

    /* renamed from: e */
    boolean f10179e;

    /* renamed from: f */
    boolean f10180f;

    /* renamed from: g */
    Method f10181g = m8067b("android.net.ConnectivityManager", "SetIpRuleAdd");

    /* renamed from: h */
    Method f10182h = m8067b("android.net.ConnectivityManager", "SetIpRouteAdd");

    /* renamed from: i */
    Method f10183i = m8067b("android.net.ConnectivityManager", "DeleteIpRule");

    /* renamed from: j */
    Method f10184j = m8067b("android.net.wifi.WifiManager", "doCustomSupplicantCommandRlt");

    /* renamed from: k */
    Method f10185k = m8067b("android.net.wifi.WifiManager", "setWifiEnabledRlt");

    /* renamed from: l */
    Method f10186l = m8067b("android.net.wifi.WifiManager", "getWifiEnabledRlt");

    /* renamed from: m */
    private WifiManager f10187m;

    /* renamed from: n */
    private ConnectivityManager f10188n;

    /* renamed from: o */
    private Context f10189o;

    public OldSecondWiFiManager(Context context) {
        this.f10189o = context;
        this.f10187m = (WifiManager) context.getSystemService("wifi");
        this.f10188n = (ConnectivityManager) context.getSystemService("connectivity");
        this.f10175a = this.f10181g != null;
        this.f10176b = this.f10182h != null;
        this.f10177c = this.f10183i != null;
        this.f10178d = this.f10184j != null;
        this.f10179e = this.f10185k != null;
        this.f10180f = this.f10186l != null;
        Log.d("OldSecondWiFiManager", ",isExistsMethod_ConnectivityManager_SetIpRuleAdd=" + this.f10175a + ",isExistsMethod_ConnectivityManager_SetIpRouteAdd=" + this.f10176b + ",isExistsMethod_ConnectivityManager_DeleteIpRule=" + this.f10177c + ",isExistsMethod_WifiManager_doCustomSupplicantCommandRlt=" + this.f10178d + ",isExistsMethod_WifiManager_setWifiEnabledRlt=" + this.f10179e + ",isExistsMethod_WifiManager_getWifiEnabledRlt=" + this.f10180f);
    }

    /* renamed from: a */
    private String m8068a(Object obj, String str) {
        String str2;
        if (!this.f10178d) {
            return "";
        }
        try {
            str2 = (String) this.f10184j.invoke(obj, str);
            try {
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "doCustomSupplicantCommandRltInvoke returnValue=".concat(String.valueOf(str2)));
                    return str2;
                }
                return str2;
            } catch (IllegalAccessException e) {
                e = e;
                e.printStackTrace();
                return str2;
            } catch (InvocationTargetException e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (IllegalAccessException e3) {
            e = e3;
            str2 = null;
        } catch (InvocationTargetException e4) {
            e = e4;
            str2 = null;
        }
    }

    /* renamed from: b */
    private static Method m8067b(String str, String str2) {
        try {
            Log.e("OldSecondWiFiManager", " checkClassMethodExists " + str + "   " + str2);
            Method[] declaredMethods = Class.forName(str).getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                Log.e("OldSecondWiFiManager", str + " method= " + declaredMethods[i].getName());
                if (declaredMethods[i].getName().equals(str2)) {
                    Log.e("OldSecondWiFiManager", str + " find method= " + declaredMethods[i].getName());
                    return declaredMethods[i];
                }
            }
            return null;
        } catch (Exception e) {
            Log.e("OldSecondWiFiManager", "checkClassMethodExists error: " + e.toString());
            return null;
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final boolean mo8057b() {
        boolean z = false;
        if (this.f10180f) {
            try {
                z = ((Boolean) this.f10186l.invoke(this.f10187m, new Object[0])).booleanValue();
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", " isEnabled() =".concat(String.valueOf(z)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return z;
        }
        return false;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final synchronized boolean mo8058a(boolean z) {
        if (this.f10179e) {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "wifiManager.setWifiEnabledRlt(" + z + ") start");
            }
            try {
                if (z) {
                    return ((Boolean) this.f10185k.invoke(this.f10187m, Boolean.TRUE)).booleanValue();
                }
                boolean booleanValue = ((Boolean) this.f10185k.invoke(this.f10187m, Boolean.FALSE)).booleanValue();
                if (booleanValue) {
                    m8069a();
                }
                return booleanValue;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final boolean mo8059a(String str, String str2) {
        if (this.f10178d) {
            try {
                String m8068a = m8068a(this.f10187m, "ADD_NETWORK");
                if (!TextUtils.isEmpty(m8068a) && !m8068a.equals("null")) {
                    if (C1856n.f10135a) {
                        C1856n.m8130a("OldSecondWiFiManager", "ADD_NETWORK ".concat(String.valueOf(m8068a)));
                    }
                    WifiManager wifiManager = this.f10187m;
                    String m8068a2 = m8068a(wifiManager, "SET_NETWORK " + m8068a + " ssid \"" + str + "\"");
                    if (C1856n.f10135a) {
                        C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8068a + " ssid \"" + str + "\"" + m8068a2);
                    }
                    if (SecondWiFiUtil.m8063a(m8068a2)) {
                        WifiManager wifiManager2 = this.f10187m;
                        String m8068a3 = m8068a(wifiManager2, "SET_NETWORK " + m8068a + " key_mgmt WPA-PSK");
                        if (C1856n.f10135a) {
                            C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8068a + " key_mgmt WPA-PSK " + m8068a3);
                        }
                        if (SecondWiFiUtil.m8063a(m8068a3)) {
                            WifiManager wifiManager3 = this.f10187m;
                            String m8068a4 = m8068a(wifiManager3, "SET_NETWORK " + m8068a + " psk \"" + str2 + "\"");
                            if (C1856n.f10135a) {
                                C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8068a + " psk \"" + str2 + "\"" + m8068a4);
                            }
                            if (SecondWiFiUtil.m8063a(m8068a4)) {
                                WifiManager wifiManager4 = this.f10187m;
                                String m8068a5 = m8068a(wifiManager4, "SET_NETWORK " + m8068a + " scan_ssid 1");
                                if (C1856n.f10135a) {
                                    C1856n.m8130a("OldSecondWiFiManager", "SET_NETWORK " + m8068a + " scan_ssid 1" + m8068a5);
                                }
                                if (SecondWiFiUtil.m8063a(m8068a5)) {
                                    String m8068a6 = m8068a(this.f10187m, "SELECT_NETWORK ".concat(String.valueOf(m8068a)));
                                    if (C1856n.f10135a) {
                                        C1856n.m8130a("OldSecondWiFiManager", "SELECT_NETWORK ".concat(String.valueOf(m8068a6)));
                                    }
                                    return SecondWiFiUtil.m8063a(m8068a6);
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
        return false;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: c */
    public final boolean mo8054c() {
        if (this.f10178d) {
            try {
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "STATIC start");
                }
                String m8068a = m8068a(this.f10187m, "STATIC 192.168.100.144");
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "STATIC ".concat(String.valueOf(m8068a)));
                }
                if (TextUtils.isEmpty(m8068a)) {
                    return false;
                }
                return !m8068a.equals("null");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final CustomWiFiControlForDualWiFi.C1866c mo8056b(String str) {
        String m8068a;
        CustomWiFiControlForDualWiFi.C1866c c1866c = new CustomWiFiControlForDualWiFi.C1866c();
        c1866c.f10173a = str;
        if (!mo8057b()) {
            if (C1856n.f10135a) {
                C1856n.m8130a("OldSecondWiFiManager", "getCurrentWiFiState state is WPAState.NONE isEnabled() =false");
            }
            return c1866c;
        } else if (this.f10178d) {
            try {
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "STATUS start");
                }
                m8068a = m8068a(this.f10187m, "STATUS");
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "getCurrentWiFiState STATUS ".concat(String.valueOf(m8068a)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(m8068a) && !m8068a.equals("null")) {
                if (m8068a.equalsIgnoreCase("CONNECTED")) {
                    c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.CONNECTED;
                } else if (m8068a.equalsIgnoreCase("CONNECTEDING")) {
                    c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.CONNECTING;
                } else {
                    c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.NONE;
                }
                return c1866c;
            }
            c1866c.f10174b = CustomWiFiControlForDualWiFi.EnumC1865b.NONE;
            return c1866c;
        } else {
            return c1866c;
        }
    }

    /* renamed from: c */
    private boolean m8066c(String str, String str2) {
        if (this.f10175a) {
            try {
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "setIpRule start");
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    this.f10181g.invoke(this.f10188n, str, str2);
                    this.f10182h.invoke(this.f10188n, str2);
                    if (C1856n.f10135a) {
                        C1856n.m8130a("OldSecondWiFiManager", "SetIpRuleAdd  " + str + "," + str2);
                    }
                    if (C1856n.f10135a) {
                        C1856n.m8130a("OldSecondWiFiManager", "SetIpRouteAdd ".concat(String.valueOf(str2)));
                        return true;
                    }
                    return true;
                }
                this.f10181g.invoke(this.f10188n, "192.168.100.0/24", "192.168.100.1");
                this.f10182h.invoke(this.f10188n, "192.168.100.1");
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "SetIpRuleAdd 192.168.100.0/24 ，192.168.100.1 ");
                }
                if (C1856n.f10135a) {
                    C1856n.m8130a("OldSecondWiFiManager", "SetIpRouteAdd 192.168.100.1");
                    return true;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: d */
    public final boolean mo8053d() {
        return m8066c("", "");
    }

    /* renamed from: a */
    private boolean m8069a() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OldSecondWiFiManager", " deleteIpRule ");
        }
        if (this.f10177c) {
            try {
                this.f10183i.invoke(this.f10188n, new Object[0]);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }
}
