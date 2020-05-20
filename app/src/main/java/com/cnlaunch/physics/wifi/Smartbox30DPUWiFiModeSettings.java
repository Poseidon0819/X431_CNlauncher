package com.cnlaunch.physics.wifi;

import android.net.wifi.WifiConfiguration;
import com.cnlaunch.physics.p195b.p196a.MyFactory;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.translate.TranslateManager;
import java.nio.charset.Charset;
import org.apache.commons.codec.net.StringEncodings;

/* renamed from: com.cnlaunch.physics.wifi.h */
/* loaded from: classes.dex */
public final class Smartbox30DPUWiFiModeSettings {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Smartbox30DPUWiFiModeSettings.java */
    /* renamed from: com.cnlaunch.physics.wifi.h$b */
    /* loaded from: classes.dex */
    public class RunnableC1872b implements Runnable {

        /* renamed from: b */
        private DPUWiFiModeConfig f10234b;

        /* renamed from: c */
        private OnWiFiModeListener f10235c;

        /* renamed from: d */
        private IPhysics f10236d;

        public RunnableC1872b(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener, DPUWiFiModeConfig dPUWiFiModeConfig) {
            this.f10234b = dPUWiFiModeConfig;
            this.f10235c = onWiFiModeListener;
            this.f10236d = iPhysics;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] mo8328b;
            int i;
            try {
                IPhysics iPhysics = this.f10236d;
                DPUWiFiModeConfig dPUWiFiModeConfig = this.f10234b;
                Boolean bool = Boolean.FALSE;
                if (dPUWiFiModeConfig.f10224a == 1) {
                    byte[] m8107a = Tools.m8107a(iPhysics, MyFactory.m8342a().mo8328b(new byte[]{44, 20}, new byte[]{1}), (int) TranslateManager.TIME_OUT);
                    if (m8107a != null && m8107a.length > 0 && m8107a[0] == 0) {
                        bool = Boolean.TRUE;
                    }
                } else if (dPUWiFiModeConfig.f10224a == 2) {
                    WifiConfiguration wifiConfiguration = dPUWiFiModeConfig.f10225b;
                    if (dPUWiFiModeConfig.f10225b == null) {
                        mo8328b = null;
                        i = TranslateManager.TIME_OUT;
                    } else {
                        String str = wifiConfiguration.SSID;
                        int m8122a = NetworkUtil.m8122a(wifiConfiguration);
                        int i2 = m8122a != 0 ? m8122a != 2 ? 1 : 4 : 1;
                        String m8121a = NetworkUtil.m8121a(wifiConfiguration, m8122a);
                        if (C1856n.f10135a) {
                            C1856n.m8130a("Smartbox30DPUWiFiModeSettings", String.format(" WifiConfiguration SSID=%s Security=%d smartbox30SecurityType =%d Password=%s", str, Integer.valueOf(m8122a), Integer.valueOf(i2), m8121a));
                        }
                        byte[] bytes = str.getBytes(Charset.forName(StringEncodings.US_ASCII));
                        int length = bytes.length;
                        byte[] bytes2 = m8121a.getBytes(Charset.forName(StringEncodings.US_ASCII));
                        int length2 = bytes2.length;
                        int i3 = length + 1;
                        int i4 = i3 + 1;
                        int i5 = i4 + 1;
                        byte[] bArr = new byte[i5 + length2];
                        bArr[0] = (byte) (length & 255);
                        System.arraycopy(bytes, 0, bArr, 1, length);
                        bArr[i3] = (byte) i2;
                        bArr[i4] = (byte) (length2 & 255);
                        System.arraycopy(bytes2, 0, bArr, i5, length2);
                        mo8328b = MyFactory.m8342a().mo8328b(new byte[]{44, 18}, bArr);
                        i = TranslateManager.TIME_OUT;
                    }
                    byte[] m8107a2 = Tools.m8107a(iPhysics, mo8328b, i);
                    if (m8107a2 != null && m8107a2.length > 0 && m8107a2[0] == 0) {
                        bool = Boolean.TRUE;
                    }
                }
                if (C1856n.f10135a) {
                    C1856n.m8130a("Smartbox30DPUWiFiModeSettings", "setDPUWiFiMode. state = ".concat(String.valueOf(bool)));
                }
                if (this.f10235c != null) {
                    if (bool.booleanValue()) {
                        this.f10235c.mo5844a(0);
                    } else {
                        this.f10235c.mo5844a(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OnWiFiModeListener onWiFiModeListener = this.f10235c;
                if (onWiFiModeListener != null) {
                    onWiFiModeListener.mo5844a(1);
                }
            }
        }
    }

    /* compiled from: Smartbox30DPUWiFiModeSettings.java */
    /* renamed from: com.cnlaunch.physics.wifi.h$a */
    /* loaded from: classes.dex */
    public class RunnableC1871a implements Runnable {

        /* renamed from: b */
        private OnWiFiModeListener f10231b;

        /* renamed from: c */
        private IPhysics f10232c;

        public RunnableC1871a(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener) {
            this.f10231b = onWiFiModeListener;
            this.f10232c = iPhysics;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r8 = this;
                r0 = 0
                r1 = 1
                com.cnlaunch.physics.e.c r2 = r8.f10232c     // Catch: java.lang.Exception -> L65
                com.cnlaunch.physics.b.a.f r3 = com.cnlaunch.physics.p195b.p196a.MyFactory.m8342a()     // Catch: java.lang.Exception -> L65
                r4 = 2
                byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L65
                r6 = 44
                r7 = 0
                r5[r7] = r6     // Catch: java.lang.Exception -> L65
                r6 = 21
                r5[r1] = r6     // Catch: java.lang.Exception -> L65
                byte[] r3 = r3.mo8328b(r5, r0)     // Catch: java.lang.Exception -> L65
                byte[] r2 = com.cnlaunch.physics.p205k.Tools.m8108a(r2, r3)     // Catch: java.lang.Exception -> L65
                if (r2 == 0) goto L4e
                int r3 = r2.length     // Catch: java.lang.Exception -> L65
                if (r3 < r4) goto L4e
                r3 = r2[r1]     // Catch: java.lang.Exception -> L65
                if (r3 != 0) goto L4e
                r3 = r2[r7]     // Catch: java.lang.Exception -> L65
                if (r3 != r1) goto L31
                com.cnlaunch.physics.wifi.e r2 = new com.cnlaunch.physics.wifi.e     // Catch: java.lang.Exception -> L65
                r2.<init>()     // Catch: java.lang.Exception -> L65
                r2.f10224a = r1     // Catch: java.lang.Exception -> L65
                goto L4f
            L31:
                r3 = r2[r7]     // Catch: java.lang.Exception -> L65
                if (r3 != r4) goto L3d
                com.cnlaunch.physics.wifi.e r2 = new com.cnlaunch.physics.wifi.e     // Catch: java.lang.Exception -> L65
                r2.<init>()     // Catch: java.lang.Exception -> L65
                r2.f10224a = r4     // Catch: java.lang.Exception -> L65
                goto L4f
            L3d:
                r3 = r2[r7]     // Catch: java.lang.Exception -> L65
                r4 = 3
                if (r3 == r4) goto L46
                r2 = r2[r1]     // Catch: java.lang.Exception -> L65
                if (r2 == 0) goto L4e
            L46:
                com.cnlaunch.physics.wifi.e r2 = new com.cnlaunch.physics.wifi.e     // Catch: java.lang.Exception -> L65
                r2.<init>()     // Catch: java.lang.Exception -> L65
                r2.f10224a = r7     // Catch: java.lang.Exception -> L65
                goto L4f
            L4e:
                r2 = r0
            L4f:
                com.cnlaunch.physics.g.c r3 = r8.f10231b     // Catch: java.lang.Exception -> L65
                if (r3 == 0) goto L64
                if (r2 == 0) goto L5f
                int r3 = r2.f10224a     // Catch: java.lang.Exception -> L65
                if (r3 == 0) goto L5f
                com.cnlaunch.physics.g.c r3 = r8.f10231b     // Catch: java.lang.Exception -> L65
                r3.mo5843a(r7, r2)     // Catch: java.lang.Exception -> L65
                return
            L5f:
                com.cnlaunch.physics.g.c r3 = r8.f10231b     // Catch: java.lang.Exception -> L65
                r3.mo5843a(r1, r2)     // Catch: java.lang.Exception -> L65
            L64:
                return
            L65:
                r2 = move-exception
                r2.printStackTrace()
                com.cnlaunch.physics.g.c r2 = r8.f10231b
                if (r2 == 0) goto L70
                r2.mo5843a(r1, r0)
            L70:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.wifi.Smartbox30DPUWiFiModeSettings.RunnableC1871a.run():void");
        }
    }
}
