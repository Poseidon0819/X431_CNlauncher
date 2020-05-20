package com.cnlaunch.physics.wifi.p208a;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.p205k.C1856n;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cnlaunch.physics.wifi.a.a */
/* loaded from: classes.dex */
public final class CustomWiFiControlForDualWiFi implements ISecondWiFiManager {

    /* renamed from: f */
    private static CustomWiFiControlForDualWiFi f10163f;

    /* renamed from: b */
    private Context f10165b;

    /* renamed from: d */
    private ISecondWiFiManager f10167d;

    /* renamed from: e */
    private boolean f10168e;

    /* renamed from: a */
    public C1864a f10164a = null;

    /* renamed from: c */
    private ConcurrentHashMap<String, Integer> f10166c = new ConcurrentHashMap<>();

    /* compiled from: CustomWiFiControlForDualWiFi.java */
    /* renamed from: com.cnlaunch.physics.wifi.a.a$b */
    /* loaded from: classes.dex */
    public enum EnumC1865b {
        NONE,
        CONNECTING,
        CONNECTED
    }

    /* compiled from: CustomWiFiControlForDualWiFi.java */
    /* renamed from: com.cnlaunch.physics.wifi.a.a$c */
    /* loaded from: classes.dex */
    public static class C1866c {

        /* renamed from: a */
        public String f10173a = "";

        /* renamed from: b */
        public EnumC1865b f10174b = EnumC1865b.NONE;
    }

    /* renamed from: a */
    public static CustomWiFiControlForDualWiFi m8078a(Context context) {
        if (f10163f == null) {
            f10163f = new CustomWiFiControlForDualWiFi(context);
        }
        return f10163f;
    }

    private CustomWiFiControlForDualWiFi(Context context) {
        this.f10165b = context;
        this.f10168e = PreferencesManager.m9595a(this.f10165b).m9583b("is_new_dual_wifi_support", false);
        if (!this.f10168e) {
            this.f10167d = new OldSecondWiFiManager(this.f10165b);
        } else {
            this.f10167d = new TrebleSecondWiFiManager(this.f10165b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m8074a(String str, int i) {
        this.f10166c.put(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public final synchronized int m8075a(String str) {
        Integer num = this.f10166c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* renamed from: c */
    private void m8072c(String str) {
        if (C1856n.f10135a) {
            C1856n.m8130a("CustomWiFiControl", "waitWiFiConnectStateAfterSelectNetwork ssid=".concat(String.valueOf(str)));
        }
        C1866c mo8056b = mo8056b(str);
        for (int i = 0; mo8056b.f10174b != EnumC1865b.CONNECTED && i < 6; i++) {
            String format = String.format("waitWiFiConnectStateAfterSelectNetwork Tools.isSupportDualWiFi wiFiState=%s connectCount=%d", mo8056b.f10174b, Integer.valueOf(i));
            if (C1856n.f10135a) {
                C1856n.m8130a("CustomWiFiControl", format);
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mo8056b = mo8056b(str);
        }
        if (mo8056b.f10174b == EnumC1865b.CONNECTED) {
            m8074a(str, 3);
        } else {
            m8074a(str, 0);
        }
    }

    /* renamed from: a */
    public final void m8073a(String str, String str2, boolean z) {
        if (C1856n.f10135a) {
            C1856n.m8130a("CustomWiFiControl", String.format("manualConnectNetwork ssid=%s,isForce=%b", str, Boolean.valueOf(z)));
        }
        m8074a(str, 2);
        if (mo8056b(str).f10174b == EnumC1865b.CONNECTED) {
            m8074a(str, 3);
            return;
        }
        if (!mo8057b()) {
            if (!mo8058a(true)) {
                m8074a(str, 0);
                return;
            }
        } else if (z && !this.f10168e) {
            Log.d("CustomWiFiControl", "Force setWifiEnabled true ");
            if (!mo8058a(true)) {
                m8074a(str, 0);
                return;
            }
        }
        if (!mo8059a(str, str2)) {
            m8074a(str, 0);
        } else if (!mo8054c()) {
            m8074a(str, 0);
        } else if (!mo8053d()) {
            m8074a(str, 0);
        } else {
            m8072c(str);
        }
    }

    /* renamed from: a */
    public final synchronized void m8079a() {
        if (this.f10164a != null) {
            this.f10164a.m8071a();
            this.f10164a = null;
        }
    }

    /* compiled from: CustomWiFiControlForDualWiFi.java */
    /* renamed from: com.cnlaunch.physics.wifi.a.a$a */
    /* loaded from: classes.dex */
    public class C1864a extends Thread {

        /* renamed from: b */
        private String f10170b;

        /* renamed from: c */
        private boolean f10171c = false;

        public C1864a(String str) {
            this.f10170b = str;
        }

        /* renamed from: b */
        private synchronized boolean m8070b() {
            return this.f10171c;
        }

        /* renamed from: a */
        public final synchronized void m8071a() {
            this.f10171c = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (!m8070b()) {
                C1866c mo8056b = CustomWiFiControlForDualWiFi.this.mo8056b(this.f10170b);
                if (CustomWiFiControlForDualWiFi.this.m8075a(this.f10170b) == 3 && (mo8056b.f10174b == EnumC1865b.NONE || mo8056b.f10174b == EnumC1865b.CONNECTING)) {
                    if (CustomWiFiControlForDualWiFi.this.f10165b != null) {
                        CustomWiFiControlForDualWiFi.this.f10165b.sendBroadcast(new Intent("CUSTOMWiFiConnectDisconnected"));
                    }
                    CustomWiFiControlForDualWiFi.this.m8074a(this.f10170b, 0);
                }
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final boolean mo8057b() {
        return this.f10167d.mo8057b();
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final boolean mo8058a(boolean z) {
        return this.f10167d.mo8058a(z);
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: a */
    public final boolean mo8059a(String str, String str2) {
        return this.f10167d.mo8059a(str, str2);
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: c */
    public final boolean mo8054c() {
        return this.f10167d.mo8054c();
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: b */
    public final C1866c mo8056b(String str) {
        return this.f10167d.mo8056b(str);
    }

    @Override // com.cnlaunch.physics.wifi.p208a.ISecondWiFiManager
    /* renamed from: d */
    public final boolean mo8053d() {
        return this.f10167d.mo8053d();
    }
}
