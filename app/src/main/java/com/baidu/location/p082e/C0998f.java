package com.baidu.location.p082e;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.indoor.C1026d;
import com.baidu.location.p078a.C0892a;
import com.baidu.location.p078a.C0919j;
import com.baidu.location.p078a.C0930n;
import com.baidu.location.p078a.C0932p;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;

/* renamed from: com.baidu.location.e.f */
/* loaded from: classes.dex */
public class C0998f {

    /* renamed from: a */
    public static long f4455a;

    /* renamed from: b */
    private static C0998f f4456b;

    /* renamed from: c */
    private WifiManager f4457c = null;

    /* renamed from: d */
    private C1000a f4458d = null;

    /* renamed from: e */
    private C0997e f4459e = null;

    /* renamed from: f */
    private long f4460f = 0;

    /* renamed from: g */
    private long f4461g = 0;

    /* renamed from: h */
    private boolean f4462h = false;

    /* renamed from: i */
    private Handler f4463i = new Handler();

    /* renamed from: j */
    private long f4464j = 0;

    /* renamed from: k */
    private long f4465k = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.e.f$a */
    /* loaded from: classes.dex */
    public class C1000a extends BroadcastReceiver {

        /* renamed from: b */
        private long f4467b;

        /* renamed from: c */
        private boolean f4468c;

        private C1000a() {
            this.f4467b = 0L;
            this.f4468c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                C0998f.f4455a = System.currentTimeMillis() / 1000;
                C0998f.this.f4463i.post(new Runnable() { // from class: com.baidu.location.e.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0998f.this.m11616t();
                        C0919j.m12105c().m12088i();
                        if (C1026d.m11499a().m11457f()) {
                            C1026d.m11499a().f4687c.obtainMessage(41).sendToTarget();
                        }
                        C0998f.this.m11618r();
                        if (System.currentTimeMillis() - C0930n.m12052b() <= 5000) {
                            C0932p.m12041a(C0930n.m12051c(), C0998f.this.m11621o(), C0930n.m12050d(), C0930n.m12057a());
                        }
                    }
                });
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.f4467b >= 5000) {
                this.f4467b = System.currentTimeMillis();
                if (this.f4468c) {
                    return;
                }
                this.f4468c = true;
            }
        }
    }

    private C0998f() {
    }

    /* renamed from: a */
    public static synchronized C0998f m11640a() {
        C0998f c0998f;
        synchronized (C0998f.class) {
            if (f4456b == null) {
                f4456b = new C0998f();
            }
            c0998f = f4456b;
        }
        return c0998f;
    }

    /* renamed from: a */
    private String m11639a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static boolean m11638a(C0997e c0997e, C0997e c0997e2) {
        boolean m11637a = m11637a(c0997e, c0997e2, 0.7f);
        long currentTimeMillis = System.currentTimeMillis() - C0892a.f3855c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !m11637a || c0997e2.m11647g() - c0997e.m11647g() <= 30) {
            return m11637a;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m11637a(C0997e c0997e, C0997e c0997e2, float f) {
        if (c0997e != null && c0997e2 != null) {
            List<ScanResult> list = c0997e.f4450a;
            List<ScanResult> list2 = c0997e2.f4450a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2).BSSID;
                        if (str != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                } else if (str.equals(list2.get(i3).BSSID)) {
                                    i++;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: j */
    public static boolean m11626j() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ServiceC1002f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m11616t() {
        WifiManager wifiManager = this.f4457c;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                C0997e c0997e = new C0997e(scanResults, System.currentTimeMillis());
                C0997e c0997e2 = this.f4459e;
                if (c0997e2 == null || !c0997e.m11660a(c0997e2)) {
                    this.f4459e = c0997e;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m11635b() {
        this.f4464j = 0L;
    }

    /* renamed from: c */
    public synchronized void m11633c() {
        if (this.f4462h) {
            return;
        }
        if (ServiceC1002f.isServing) {
            this.f4457c = (WifiManager) ServiceC1002f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.f4458d = new C1000a();
            try {
                ServiceC1002f.getServiceContext().registerReceiver(this.f4458d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception unused) {
            }
            this.f4462h = true;
        }
    }

    /* renamed from: d */
    public List<WifiConfiguration> m11632d() {
        try {
            if (this.f4457c != null) {
                return this.f4457c.getConfiguredNetworks();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public synchronized void m11631e() {
        if (this.f4462h) {
            try {
                ServiceC1002f.getServiceContext().unregisterReceiver(this.f4458d);
                f4455a = 0L;
            } catch (Exception unused) {
            }
            this.f4458d = null;
            this.f4457c = null;
            this.f4462h = false;
        }
    }

    /* renamed from: f */
    public boolean m11630f() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f4461g;
        if (currentTimeMillis - j <= 0 || currentTimeMillis - j > 5000) {
            this.f4461g = currentTimeMillis;
            m11635b();
            return m11629g();
        }
        return false;
    }

    /* renamed from: g */
    public boolean m11629g() {
        if (this.f4457c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f4460f;
        if (currentTimeMillis - j > 0) {
            long j2 = this.f4464j;
            if (currentTimeMillis - j <= j2 + 5000 || currentTimeMillis - (f4455a * 1000) <= j2 + 5000) {
                return false;
            }
            if (m11626j() && currentTimeMillis - this.f4460f <= this.f4464j + 10000) {
                return false;
            }
        }
        return m11627i();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public String m11628h() {
        WifiManager wifiManager = this.f4457c;
        if (wifiManager != null) {
            try {
                if (!wifiManager.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return "";
                    }
                    if (!this.f4457c.isScanAlwaysAvailable()) {
                        return "";
                    }
                }
                return "&wifio=1";
            } catch (Exception | NoSuchMethodError unused) {
                return "";
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    /* renamed from: i */
    public boolean m11627i() {
        long currentTimeMillis = System.currentTimeMillis() - this.f4465k;
        if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
            this.f4465k = System.currentTimeMillis();
            try {
                if (!this.f4457c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.f4457c.isScanAlwaysAvailable())) {
                    return false;
                }
                this.f4457c.startScan();
                this.f4460f = System.currentTimeMillis();
                return true;
            } catch (Exception | NoSuchMethodError unused) {
                return false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    public boolean m11625k() {
        try {
            if ((this.f4457c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.f4457c.isScanAlwaysAvailable())) && !m11626j()) {
                return new C0997e(this.f4457c.getScanResults(), 0L).m11649e();
            }
            return false;
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    /* renamed from: l */
    public WifiInfo m11624l() {
        WifiManager wifiManager = this.f4457c;
        if (wifiManager == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    String replace = bssid.replace(":", "");
                    if (!Constant.DEFAULT_BALANCE.equals(replace)) {
                        if ("".equals(replace)) {
                        }
                    }
                    return null;
                }
                return connectionInfo;
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    /* renamed from: m */
    public String m11623m() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo m11624l = m11640a().m11624l();
        if (m11624l != null && m11624l.getBSSID() != null) {
            String replace = m11624l.getBSSID().replace(":", "");
            int rssi = m11624l.getRssi();
            String m11622n = m11640a().m11622n();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100) {
                stringBuffer.append("&wf=");
                stringBuffer.append(replace);
                stringBuffer.append(";");
                stringBuffer.append(rssi + ";");
                String ssid = m11624l.getSSID();
                if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
                    ssid = ssid.replace("&", "_");
                }
                stringBuffer.append(ssid);
                stringBuffer.append("&wf_n=1");
                if (m11622n != null) {
                    stringBuffer.append("&wf_gw=");
                    stringBuffer.append(m11622n);
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    /* renamed from: n */
    public String m11622n() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.f4457c;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return m11639a(dhcpInfo.gateway);
    }

    /* renamed from: o */
    public C0997e m11621o() {
        C0997e c0997e = this.f4459e;
        return (c0997e == null || !c0997e.m11644j()) ? m11619q() : this.f4459e;
    }

    /* renamed from: p */
    public C0997e m11620p() {
        C0997e c0997e = this.f4459e;
        return (c0997e == null || !c0997e.m11643k()) ? m11619q() : this.f4459e;
    }

    /* renamed from: q */
    public C0997e m11619q() {
        WifiManager wifiManager = this.f4457c;
        if (wifiManager != null) {
            try {
                return new C0997e(wifiManager.getScanResults(), this.f4460f);
            } catch (Exception unused) {
            }
        }
        return new C0997e(null, 0L);
    }

    /* renamed from: r */
    public void m11618r() {
    }

    /* renamed from: s */
    public String m11617s() {
        try {
            WifiInfo connectionInfo = this.f4457c.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error | Exception unused) {
            return null;
        }
    }
}
