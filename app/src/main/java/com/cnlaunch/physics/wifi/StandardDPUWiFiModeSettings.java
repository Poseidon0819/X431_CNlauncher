package com.cnlaunch.physics.wifi;

import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.cnlaunch.physics.p195b.p196a.MyFactory;
import com.cnlaunch.physics.p197c.AnalysisData;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import com.cnlaunch.physics.p205k.Tools;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.codec.net.StringEncodings;
import org.codehaus.jackson.smile.SmileConstants;

/* renamed from: com.cnlaunch.physics.wifi.i */
/* loaded from: classes.dex */
public final class StandardDPUWiFiModeSettings {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StandardDPUWiFiModeSettings.java */
    /* renamed from: com.cnlaunch.physics.wifi.i$b */
    /* loaded from: classes.dex */
    public class RunnableC1874b implements Runnable {

        /* renamed from: b */
        private DPUWiFiModeConfig f10241b;

        /* renamed from: c */
        private OnWiFiModeListener f10242c;

        /* renamed from: d */
        private IPhysics f10243d;

        public RunnableC1874b(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener, DPUWiFiModeConfig dPUWiFiModeConfig) {
            this.f10241b = dPUWiFiModeConfig;
            this.f10242c = onWiFiModeListener;
            this.f10243d = iPhysics;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] bArr;
            boolean z;
            try {
                if (!Tools.m8110a(this.f10243d)) {
                    this.f10242c.mo5844a(7);
                    return;
                }
                IPhysics iPhysics = this.f10243d;
                DPUWiFiModeConfig dPUWiFiModeConfig = this.f10241b;
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.FALSE;
                if (dPUWiFiModeConfig.f10224a == 1) {
                    bArr = MyFactory.m8342a().mo8333a(new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 24}, new byte[]{1, 1});
                } else {
                    if (dPUWiFiModeConfig.f10224a == 2) {
                        WifiConfiguration wifiConfiguration = dPUWiFiModeConfig.f10225b;
                        if (dPUWiFiModeConfig.f10225b != null) {
                            String str = wifiConfiguration.SSID;
                            int m8122a = NetworkUtil.m8122a(wifiConfiguration);
                            String m8121a = NetworkUtil.m8121a(wifiConfiguration, m8122a);
                            if (C1856n.f10135a) {
                                C1856n.m8130a("StandardDPUWiFiModeSettings", String.format(" WifiConfiguration SSID=%s Security=%d Password=%s", str, Integer.valueOf(m8122a), m8121a));
                            }
                            byte[] bytes = str.getBytes(Charset.forName(StringEncodings.US_ASCII));
                            int length = bytes.length;
                            byte[] m8175b = ByteHexHelper.m8175b(length);
                            byte[] bytes2 = m8121a.getBytes(Charset.forName(StringEncodings.US_ASCII));
                            int length2 = bytes2.length;
                            byte[] m8175b2 = ByteHexHelper.m8175b(length2);
                            int i = length + 4;
                            int i2 = i + 1;
                            int i3 = i2 + 2;
                            byte[] bArr2 = new byte[i3 + length2];
                            bArr2[0] = 1;
                            bArr2[1] = 2;
                            System.arraycopy(m8175b, 0, bArr2, 2, 2);
                            System.arraycopy(bytes, 0, bArr2, 4, length);
                            bArr2[i] = (byte) m8122a;
                            System.arraycopy(m8175b2, 0, bArr2, i2, 2);
                            System.arraycopy(bytes2, 0, bArr2, i3, length2);
                            bArr = MyFactory.m8342a().mo8333a(new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 24}, bArr2);
                        }
                    }
                    bArr = null;
                }
                if (C1856n.f10135a) {
                    C1856n.m8130a("StandardDPUWiFiModeSettings", "setDPUWiFiMode2118 .sendOrder = " + ByteHexHelper.m8180a(bArr));
                }
                if (bArr.length > 0) {
                    int i4 = 0;
                    int i5 = 3;
                    while (true) {
                        if (i4 >= i5) {
                            break;
                        }
                        Tools.m8103a(bArr, iPhysics);
                        String command = iPhysics.getCommand();
                        if (TextUtils.isEmpty(command)) {
                            i4++;
                            i5 = 3;
                        } else {
                            if (C1856n.f10135a) {
                                C1856n.m8130a("StandardDPUWiFiModeSettings", "setDPUWiFiMode2118.backOrder = ".concat(String.valueOf(command)));
                            }
                            AnalysisData mo8358a = MyFactory.m8341b().mo8358a(bArr, ByteHexHelper.m8183a(command));
                            if (mo8358a.f9843d.booleanValue()) {
                                if (!Arrays.equals(new byte[]{1, 1, 0}, mo8358a.f9842c) && !Arrays.equals(new byte[]{1, 2, 0}, mo8358a.f9842c)) {
                                    z = false;
                                    bool = Boolean.valueOf(z);
                                }
                                z = true;
                                bool = Boolean.valueOf(z);
                            } else {
                                i4++;
                                i5 = 3;
                            }
                        }
                    }
                    if (C1856n.f10135a) {
                        C1856n.m8130a("StandardDPUWiFiModeSettings", "setDPUWiFiMode2118. state = ".concat(String.valueOf(bool)));
                    }
                }
                if (this.f10242c != null) {
                    if (bool.booleanValue()) {
                        this.f10242c.mo5844a(0);
                    } else {
                        this.f10242c.mo5844a(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OnWiFiModeListener onWiFiModeListener = this.f10242c;
                if (onWiFiModeListener != null) {
                    onWiFiModeListener.mo5844a(1);
                }
            }
        }
    }

    /* compiled from: StandardDPUWiFiModeSettings.java */
    /* renamed from: com.cnlaunch.physics.wifi.i$a */
    /* loaded from: classes.dex */
    public class RunnableC1873a implements Runnable {

        /* renamed from: b */
        private OnWiFiModeListener f10238b;

        /* renamed from: c */
        private IPhysics f10239c;

        public RunnableC1873a(IPhysics iPhysics, OnWiFiModeListener onWiFiModeListener) {
            this.f10238b = onWiFiModeListener;
            this.f10239c = iPhysics;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DPUWiFiModeConfig dPUWiFiModeConfig;
            try {
                if (!Tools.m8110a(this.f10239c)) {
                    this.f10238b.mo5843a(7, null);
                    return;
                }
                IPhysics iPhysics = this.f10239c;
                Boolean bool = Boolean.FALSE;
                byte[] mo8333a = MyFactory.m8342a().mo8333a(new byte[]{SmileConstants.TOKEN_LITERAL_NULL, 25}, new byte[]{1});
                if (C1856n.f10135a) {
                    C1856n.m8130a("StandardDPUWiFiModeSettings", "getDPUWiFiMode2119 .sendOrder = " + ByteHexHelper.m8180a(mo8333a));
                }
                if (mo8333a.length <= 0) {
                    dPUWiFiModeConfig = null;
                } else {
                    int i = 0;
                    while (true) {
                        if (i >= 3) {
                            dPUWiFiModeConfig = null;
                            break;
                        }
                        Tools.m8103a(mo8333a, iPhysics);
                        String command = iPhysics.getCommand();
                        if (TextUtils.isEmpty(command)) {
                            i++;
                        } else {
                            if (C1856n.f10135a) {
                                C1856n.m8130a("StandardDPUWiFiModeSettings", "getDPUWiFiMode2119.backOrder = ".concat(String.valueOf(command)));
                            }
                            AnalysisData mo8358a = MyFactory.m8341b().mo8358a(mo8333a, ByteHexHelper.m8183a(command));
                            if (mo8358a.f9843d.booleanValue()) {
                                byte[] bArr = mo8358a.f9842c;
                                if (C1856n.f10135a) {
                                    C1856n.m8130a("StandardDPUWiFiModeSettings", "getDPUWiFiMode2119 .data receiveBuffer = " + ByteHexHelper.m8180a(bArr));
                                }
                                if (bArr[1] == 0) {
                                    dPUWiFiModeConfig = new DPUWiFiModeConfig();
                                    switch (bArr[2]) {
                                        case 1:
                                            dPUWiFiModeConfig.f10224a = 1;
                                            break;
                                        case 2:
                                            dPUWiFiModeConfig.f10224a = 2;
                                            int i2 = ((bArr[3] & 255) * 256) + (bArr[4] & 255);
                                            String str = new String(bArr, 5, i2, Charset.forName(StringEncodings.US_ASCII));
                                            int i3 = i2 + 2 + 3;
                                            byte b = bArr[i3];
                                            int i4 = i3 + 1;
                                            String str2 = new String(bArr, i4 + 2, ((bArr[i4] & 255) * 256) + (bArr[i4 + 1] & 255), Charset.forName(StringEncodings.US_ASCII));
                                            dPUWiFiModeConfig.f10225b = DPUWiFiModeConfig.m8037a(str, b, str2);
                                            if (C1856n.f10135a) {
                                                C1856n.m8130a("StandardDPUWiFiModeSettings", String.format(" analysisDPUWiFiModeInformation SSID=%s Security=%d Password=%s", str, Integer.valueOf(b), str2));
                                                break;
                                            }
                                            break;
                                    }
                                } else {
                                    dPUWiFiModeConfig = null;
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                    if (C1856n.f10135a) {
                        C1856n.m8130a("StandardDPUWiFiModeSettings", "getDPUWiFiMode2119. end ");
                    }
                }
                if (this.f10238b != null) {
                    if (dPUWiFiModeConfig != null) {
                        this.f10238b.mo5843a(0, dPUWiFiModeConfig);
                    } else {
                        this.f10238b.mo5843a(1, dPUWiFiModeConfig);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OnWiFiModeListener onWiFiModeListener = this.f10238b;
                if (onWiFiModeListener != null) {
                    onWiFiModeListener.mo5843a(1, null);
                }
            }
        }
    }
}
