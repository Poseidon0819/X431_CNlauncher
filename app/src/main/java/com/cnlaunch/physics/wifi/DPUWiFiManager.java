package com.cnlaunch.physics.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DPULinkSettingsInformation;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.p196a.MyFactory;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p200f.PhysicsOutputStreamWrapper;
import com.cnlaunch.physics.p201g.OnWiFiModeListener;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import com.cnlaunch.physics.wifi.p208a.CustomWiFiControlForDualWiFi;
import com.cnlaunch.physics.wifi.p209b.BaseWiFiManager;
import com.cnlaunch.physics.wifi.p209b.WiFiControlManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.net.StringEncodings;
import org.codehaus.jackson.smile.SmileConstants;

/* renamed from: com.cnlaunch.physics.wifi.b */
/* loaded from: classes.dex */
public final class DPUWiFiManager implements IPhysics {

    /* renamed from: a */
    public Context f10193a;

    /* renamed from: e */
    public int f10197e;

    /* renamed from: f */
    boolean f10198f;

    /* renamed from: g */
    DeviceFactoryManager f10199g;

    /* renamed from: h */
    String f10200h;

    /* renamed from: k */
    boolean f10203k;

    /* renamed from: o */
    private String f10207o;

    /* renamed from: p */
    private boolean f10208p = true;

    /* renamed from: l */
    Handler f10204l = new HandlerC1869c(this, Looper.getMainLooper());

    /* renamed from: m */
    BroadcastReceiver f10205m = new C1870d(this);

    /* renamed from: n */
    private C1867a f10206n = null;

    /* renamed from: b */
    Socket f10194b = null;

    /* renamed from: c */
    ReadByteDataStream f10195c = null;

    /* renamed from: q */
    private OnWiFiModeListener f10209q = null;

    /* renamed from: d */
    int f10196d = 0;

    /* renamed from: r */
    private boolean f10210r = false;

    /* renamed from: s */
    private InputStream f10211s = null;

    /* renamed from: t */
    private OutputStream f10212t = null;

    /* renamed from: i */
    public boolean f10201i = false;

    /* renamed from: j */
    public boolean f10202j = false;

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        return null;
    }

    public DPUWiFiManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.f10193a = context.getApplicationContext();
        this.f10198f = z;
        this.f10199g = deviceFactoryManager;
        this.f10200h = str;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("DPUWiFiManager", "finalize DPUWiFiManager");
            this.f10204l = null;
            this.f10194b = null;
            this.f10209q = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f10193a;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f10208p;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f10208p = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        try {
            this.f10193a.unregisterReceiver(this.f10205m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1856n.m8130a("DPUWiFiManager", "stop wifi ConnectThread");
        C1867a c1867a = this.f10206n;
        if (c1867a != null) {
            c1867a.m8050a();
            this.f10206n = null;
        }
        ReadByteDataStream readByteDataStream = this.f10195c;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f10193a.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_UNCONNECTED"));
            this.f10195c = null;
        }
        if (Tools.m8113a(this.f10193a)) {
            CustomWiFiControlForDualWiFi.m8078a(this.f10193a).m8079a();
        }
        this.f10196d = 0;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        return this.f10196d;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        return this.f10207o;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        this.f10207o = str;
        this.f10199g.m8298a(str);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        try {
            if (this.f10212t == null) {
                this.f10212t = new PhysicsOutputStreamWrapper(this.f10194b.getOutputStream(), this.f10199g.f9916p);
            }
            return this.f10212t;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DPUWiFiManager.java */
    /* renamed from: com.cnlaunch.physics.wifi.b$a */
    /* loaded from: classes.dex */
    public class C1867a extends Thread {

        /* renamed from: b */
        private Socket f10214b;

        public C1867a() {
            C1856n.m8127b("DPUWiFiManager", "ConnectThread construct");
            m8045b();
        }

        /* renamed from: b */
        private void m8045b() {
            this.f10214b = new Socket();
            try {
                this.f10214b.setTcpNoDelay(true);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int i;
            WifiConfiguration wifiConfiguration;
            InetSocketAddress inetSocketAddress;
            InetSocketAddress inetSocketAddress2;
            boolean z;
            if (Tools.m8113a(DPUWiFiManager.this.f10193a)) {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (i2 == 0) {
                        z = false;
                    } else {
                        if (C1856n.f10135a) {
                            C1856n.m8130a("DPUWiFiManager", "Support Dual WiFi Force Enabled true");
                        }
                        z = true;
                    }
                    int m8075a = CustomWiFiControlForDualWiFi.m8078a(DPUWiFiManager.this.f10193a).m8075a(DPUWiFiManager.this.f10200h);
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DPUWiFiManager", String.format("Tools.isSupportDualWiFi  conntectState=%d", Integer.valueOf(m8075a)));
                    }
                    if (m8075a == 2) {
                        while (m8075a == 2) {
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            m8075a = CustomWiFiControlForDualWiFi.m8078a(DPUWiFiManager.this.f10193a).m8075a(DPUWiFiManager.this.f10200h);
                        }
                    } else {
                        if (C1856n.f10135a) {
                            C1856n.m8130a("DPUWiFiManager", String.format("Tools.isSupportDualWiFi not connected ,start to manualConnectNetwork ssid=%s,password=%s", DPUWiFiManager.this.f10200h, "12345678"));
                        }
                        if (DPUWiFiManager.this.f10197e == 1) {
                            CustomWiFiControlForDualWiFi.m8078a(DPUWiFiManager.this.f10193a).m8073a(DPUWiFiManager.this.f10200h, "12345678", z);
                        } else {
                            CustomWiFiControlForDualWiFi.m8078a(DPUWiFiManager.this.f10193a).m8073a(DPULinkSettingsInformation.m8314a().f9871a.m8090a(String.format("%1s.%2s", DPUWiFiManager.this.f10200h, "AP_SSID")), DPULinkSettingsInformation.m8314a().f9871a.m8090a(String.format("%1s.%2s", DPUWiFiManager.this.f10200h, "AP_PASSWORD")), z);
                        }
                    }
                    if (CustomWiFiControlForDualWiFi.m8078a(DPUWiFiManager.this.f10193a).m8075a(DPUWiFiManager.this.f10200h) == 3) {
                        break;
                    } else if (i2 != 0) {
                        DPUWiFiManager.this.m8051a(null);
                        return;
                    }
                }
            } else if (Tools.m8100b(DPUWiFiManager.this.f10193a)) {
                WiFiControlManager m8038a = WiFiControlManager.m8038a(DPUWiFiManager.this.f10193a);
                if (!m8038a.m8046a(DPUWiFiManager.this.f10200h)) {
                    String str = DPUWiFiManager.this.f10200h;
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty("12345678")) {
                        i = -1;
                    } else {
                        String m8043b = BaseWiFiManager.m8043b(str);
                        List<WifiConfiguration> m8041d = m8038a.m8041d();
                        if (m8041d != null) {
                            Iterator<WifiConfiguration> it = m8041d.iterator();
                            while (it.hasNext()) {
                                wifiConfiguration = it.next();
                                if (wifiConfiguration.SSID.equals(m8043b)) {
                                    break;
                                }
                            }
                        }
                        wifiConfiguration = null;
                        if (wifiConfiguration == null) {
                            WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
                            wifiConfiguration2.SSID = BaseWiFiManager.m8043b(str);
                            wifiConfiguration2.preSharedKey = "\"12345678\"";
                            wifiConfiguration2.allowedProtocols.set(1);
                            wifiConfiguration2.allowedKeyManagement.set(1);
                            wifiConfiguration2.status = 2;
                            wifiConfiguration2.allowedGroupCiphers.set(2);
                            wifiConfiguration2.allowedGroupCiphers.set(3);
                            wifiConfiguration2.allowedPairwiseCiphers.set(1);
                            wifiConfiguration2.allowedPairwiseCiphers.set(2);
                            wifiConfiguration2.allowedProtocols.set(1);
                            wifiConfiguration2.allowedProtocols.set(0);
                            wifiConfiguration2.allowedGroupCiphers.set(3);
                            wifiConfiguration2.allowedPairwiseCiphers.set(2);
                            i = m8038a.m8047a(wifiConfiguration2);
                        } else {
                            wifiConfiguration.preSharedKey = "\"12345678\"";
                            i = m8038a.m8044b(wifiConfiguration);
                        }
                    }
                    boolean z2 = -1 != i ? m8038a.m8040e() && m8038a.m8048a(i) : false;
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DPUWiFiManager", "isSupportWiFiPriority TRUE connectWPA2Network SSID=" + DPUWiFiManager.this.f10200h + " isEnable=" + z2);
                    }
                    int i3 = 6;
                    while (true) {
                        if (m8038a.m8046a(DPUWiFiManager.this.f10200h)) {
                            break;
                        }
                        int i4 = i3 - 1;
                        if (i3 <= 0) {
                            i3 = i4;
                            break;
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i3 = i4;
                    }
                    if (C1856n.f10135a) {
                        StringBuilder sb = new StringBuilder("isSupportWiFiPriority TRUE tryCheckCount=");
                        sb.append(i3);
                        sb.append(" isWifiConnected()=");
                        WiFiControlManager.m8038a(DPUWiFiManager.this.f10193a);
                        sb.append(WiFiControlManager.m8042c());
                        C1856n.m8130a("DPUWiFiManager", sb.toString());
                    }
                    if (!m8038a.m8046a(DPUWiFiManager.this.f10200h)) {
                        DPUWiFiManager.this.m8051a(null);
                        return;
                    }
                }
            }
            if (DPUWiFiManager.this.f10197e == 1) {
                if (!Tools.m8094e(DPUWiFiManager.this.f10193a, DPUWiFiManager.this.getSerialNo())) {
                    inetSocketAddress = new InetSocketAddress("192.168.16.254", 8080);
                } else if (DPUWiFiManager.this.f10199g != null && DPUWiFiManager.this.f10198f && DPUWiFiManager.this.f10199g.f9907g == 5) {
                    inetSocketAddress = new InetSocketAddress("192.168.100.1", 22400);
                } else {
                    inetSocketAddress = new InetSocketAddress("192.168.100.1", 22488);
                }
            } else {
                if (interrupted()) {
                    inetSocketAddress = null;
                } else {
                    IDPUWiFiModeSettings iDPUWiFiModeSettings = DPUWiFiManager.this.f10199g.f9908h;
                    if (iDPUWiFiModeSettings == null || DPUWiFiManager.this.f10197e == 2) {
                        iDPUWiFiModeSettings = new C1868b(DPUWiFiManager.this, (byte) 0);
                    }
                    if (NetworkUtil.m8117c(DPUWiFiManager.this.f10193a).booleanValue() && !Tools.m8113a(DPUWiFiManager.this.f10193a) && !Tools.m8100b(DPUWiFiManager.this.f10193a)) {
                        ArrayList<String> m8124a = NetworkUtil.m8124a();
                        if (C1856n.f10135a) {
                            C1856n.m8127b("DPUWiFiManager", "Connected IP  " + m8124a.toString());
                        }
                        if (m8124a.size() <= 0) {
                            inetSocketAddress2 = null;
                        } else if (DPUWiFiManager.this.f10199g != null && DPUWiFiManager.this.f10198f && DPUWiFiManager.this.f10199g.f9907g == 5) {
                            inetSocketAddress = new InetSocketAddress(m8124a.get(0), 22400);
                        } else {
                            inetSocketAddress2 = new InetSocketAddress(m8124a.get(0), 22488);
                        }
                        inetSocketAddress = inetSocketAddress2;
                    } else {
                        inetSocketAddress = (InetSocketAddress) iDPUWiFiModeSettings.mo8035a();
                    }
                }
                if (inetSocketAddress == null && !interrupted()) {
                    DPUWiFiManager dPUWiFiManager = DPUWiFiManager.this;
                    dPUWiFiManager.m8051a(dPUWiFiManager.f10193a.getResources().getString(C1411a.C1412a.msg_wifi_connect_state_fail_with_no_ip));
                    return;
                }
            }
            try {
                if (!interrupted()) {
                    this.f10214b.connect(inetSocketAddress, UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                C1856n.m8127b("DPUWiFiManager", "unable to connect() exception : " + e3.getMessage());
                try {
                    if (!interrupted()) {
                        if (!this.f10214b.isClosed()) {
                            this.f10214b.close();
                        }
                        m8045b();
                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                        }
                        this.f10214b.connect(inetSocketAddress, UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    C1856n.m8127b("DPUWiFiManager", "try connect error unable to connect() exception : " + e5.getMessage());
                    if (interrupted()) {
                        return;
                    }
                    DPUWiFiManager.this.m8051a(null);
                    return;
                }
            }
            if (interrupted()) {
                return;
            }
            DPUWiFiManager dPUWiFiManager2 = DPUWiFiManager.this;
            Socket socket = this.f10214b;
            C1856n.m8130a("DPUWiFiManager", "connected ");
            dPUWiFiManager2.f10194b = socket;
            try {
                dPUWiFiManager2.f10195c = new ReadByteDataStream(dPUWiFiManager2, socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e6) {
                C1856n.m8127b("DPUWiFiManager", "wifi Socket sockets not created" + e6.getMessage());
            }
            new Thread(dPUWiFiManager2.f10195c).start();
            if (Tools.m8113a(dPUWiFiManager2.f10193a)) {
                CustomWiFiControlForDualWiFi m8078a = CustomWiFiControlForDualWiFi.m8078a(dPUWiFiManager2.f10193a);
                String str2 = dPUWiFiManager2.f10200h;
                if (m8078a.f10164a != null) {
                    m8078a.f10164a.m8071a();
                    m8078a.f10164a = null;
                }
                m8078a.f10164a = new CustomWiFiControlForDualWiFi.C1864a(str2);
                m8078a.f10164a.start();
            }
            dPUWiFiManager2.f10196d = 3;
            dPUWiFiManager2.f10204l.sendEmptyMessage(0);
        }

        /* renamed from: a */
        public final void m8050a() {
            C1856n.m8127b("DPUWiFiManager", "cancel ConnectThread ");
            try {
                interrupt();
                C1856n.m8125d("DPUWiFiManager", "mConnectThread.interrupt() for cancel");
            } catch (Exception unused) {
                C1856n.m8125d("DPUWiFiManager", "mConnectThread.interrupt() Exception for cancel");
            }
            try {
                if (this.f10214b == null || !this.f10214b.isConnected()) {
                    return;
                }
                this.f10214b.close();
            } catch (IOException unused2) {
                C1856n.m8127b("DPUWiFiManager", " close() of Socket connect ");
            }
        }
    }

    /* renamed from: a */
    public final void m8052a() {
        C1867a c1867a;
        if (this.f10196d == 2 && (c1867a = this.f10206n) != null) {
            c1867a.m8050a();
            this.f10206n = null;
        }
        C1856n.m8127b("DPUWiFiManager", "mReadByteDataStreamThread cancel ");
        ReadByteDataStream readByteDataStream = this.f10195c;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f10195c = null;
        }
        this.f10206n = new C1867a();
        this.f10206n.start();
        this.f10196d = 2;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f10200h;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f10210r = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f10210r;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f10198f = z;
    }

    /* compiled from: DPUWiFiManager.java */
    /* renamed from: com.cnlaunch.physics.wifi.b$b */
    /* loaded from: classes.dex */
    class C1868b implements IDPUWiFiModeSettings {
        private C1868b() {
        }

        /* synthetic */ C1868b(DPUWiFiManager dPUWiFiManager, byte b) {
            this();
        }

        @Override // com.cnlaunch.physics.wifi.IDPUWiFiModeSettings
        /* renamed from: a */
        public final SocketAddress mo8035a() {
            byte[] bArr;
            InetSocketAddress inetSocketAddress;
            boolean z;
            int i;
            byte b;
            boolean z2;
            byte[] bArr2;
            byte[] bArr3;
            byte[] bArr4 = new byte[1024];
            boolean m8094e = Tools.m8094e(DPUWiFiManager.this.f10193a, DPUWiFiManager.this.getSerialNo());
            DPUWiFiModeConfig dPUWiFiModeConfig = new DPUWiFiModeConfig();
            dPUWiFiModeConfig.f10226c = DPUWiFiManager.this.f10200h;
            int i2 = 6;
            int i3 = 4;
            int i4 = 0;
            if (m8094e) {
                bArr = MyFactory.m8342a().mo8328b(new byte[]{0, Byte.MIN_VALUE}, null);
            } else {
                byte[] bytes = dPUWiFiModeConfig.f10226c.getBytes(Charset.forName(StringEncodings.US_ASCII));
                byte[] bArr5 = {SmileConstants.TOKEN_LITERAL_NULL, 25, 2};
                int length = bytes.length;
                int i5 = length + 11 + 1;
                int i6 = length + 2 + 5;
                bArr = new byte[i5];
                System.arraycopy(new byte[]{85, -86}, 0, bArr, 0, 2);
                bArr[2] = (byte) ((i6 >> 8) & 255);
                bArr[3] = (byte) (i6 & 255);
                System.arraycopy(new byte[]{1, 1}, 0, bArr, 4, 2);
                System.arraycopy(bArr5, 0, bArr, 6, 3);
                bArr[9] = (byte) ((length >> 8) & 255);
                bArr[10] = (byte) (length & 255);
                System.arraycopy(bytes, 0, bArr, 11, length);
                byte b2 = 0;
                for (int i7 = 2; i7 <= i6 + 4; i7++) {
                    b2 = (byte) (b2 ^ bArr[i7]);
                }
                bArr[i5 - 1] = b2;
            }
            if (C1856n.f10135a) {
                C1856n.m8130a("DPUWiFiManager", "DatagramSocket.send  requestBuffer=" + ByteHexHelper.m8173b(bArr));
            }
            try {
                DatagramSocket datagramSocket = new DatagramSocket(0);
                InetAddress m8118b = NetworkUtil.m8118b(DPUWiFiManager.this.f10193a);
                if (C1856n.f10135a) {
                    C1856n.m8130a("DPUWiFiManager", "broadcast Inet Address :" + m8118b.toString());
                }
                if (m8094e) {
                    inetSocketAddress = new InetSocketAddress(m8118b, 22534);
                } else {
                    inetSocketAddress = new InetSocketAddress(m8118b, 988);
                }
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, inetSocketAddress);
                DatagramPacket datagramPacket2 = new DatagramPacket(bArr4, 1024);
                datagramSocket.setSoTimeout(UIMsg.m_AppUI.MSG_APP_GPS);
                String str = "";
                int i8 = 0;
                int i9 = 5;
                while (true) {
                    if (i8 >= i9) {
                        z = false;
                        break;
                    }
                    try {
                        datagramSocket.send(datagramPacket);
                        i = i8 + 1;
                        try {
                            datagramSocket.receive(datagramPacket2);
                            if (C1856n.f10135a) {
                                try {
                                    C1856n.m8130a("DPUWiFiManager", "DatagramSocket.receive  buffer=" + ByteHexHelper.m8179a(datagramPacket2.getData(), 1024));
                                    C1856n.m8127b("DPUWiFiManager", "dp_receive ip:" + datagramPacket2.getAddress().getHostAddress());
                                    C1856n.m8127b("DPUWiFiManager", "dp_receive port:" + datagramPacket2.getPort());
                                } catch (Exception e) {
                                    e = e;
                                    b = 0;
                                }
                            }
                            if (m8094e) {
                                String serialNo = DPUWiFiManager.this.getSerialNo();
                                byte[] data = datagramPacket2.getData();
                                byte[] bytes2 = serialNo.getBytes(Charset.forName(StringEncodings.US_ASCII));
                                if (data.length <= i2) {
                                    z2 = false;
                                } else {
                                    int i10 = ((data[i3] & 255) * 256) + (data[5] & 255);
                                    if (i10 <= (data.length - i3) - 1) {
                                        int i11 = ((data[9] & 255) * 256) + (data[10] & 255);
                                        if (i11 >= i10) {
                                            z2 = false;
                                        } else {
                                            byte[] bArr6 = new byte[i11];
                                            System.arraycopy(data, 11, bArr6, i4, i11);
                                            if (C1856n.f10135a) {
                                                C1856n.m8130a("Smartbox30DPUWiFiModeSettings", "analysisDPUWiFiDatagramAnswerCommand receiveOrder serino = " + new String(bArr6, Charset.forName(StringEncodings.US_ASCII)));
                                            }
                                            if (bytes2 != null && Arrays.equals(bytes2, bArr6)) {
                                                z2 = true;
                                            }
                                        }
                                    }
                                    z2 = false;
                                }
                            } else {
                                byte[] data2 = datagramPacket2.getData();
                                if (bArr.length >= 4) {
                                    if (((bArr[2] & 255) * 256) + (bArr[3] & 255) == (bArr.length - 4) - 1 && bArr[4] == 1 && bArr[5] == 1 && bArr[6] == 33 && bArr[7] == 25 && bArr[8] == 2) {
                                        int i12 = ((bArr[9] & 255) * 256) + (bArr[10] & 255);
                                        bArr2 = new byte[i12];
                                        System.arraycopy(bArr, 11, bArr2, i4, i12);
                                        if (C1856n.f10135a) {
                                            C1856n.m8130a("StandardDPUWiFiModeSettings", "analysisDPUWiFiDatagramAnswerCommand sendOrder serino = " + new String(bArr2, Charset.forName(StringEncodings.US_ASCII)));
                                        }
                                    } else {
                                        bArr2 = null;
                                    }
                                    if (data2.length >= 4) {
                                        if (((data2[2] & 255) * 256) + (data2[3] & 255) <= (data2.length - 4) - 1) {
                                            if (data2[4] == 1 && data2[5] == 1) {
                                                if (data2[6] == 97 && data2[7] == 25) {
                                                    if (data2[8] == 2) {
                                                        try {
                                                            int i13 = ((data2[9] & 255) * 256) + (data2[10] & 255);
                                                            bArr3 = new byte[i13];
                                                            System.arraycopy(data2, 11, bArr3, 0, i13);
                                                            if (C1856n.f10135a) {
                                                                C1856n.m8130a("StandardDPUWiFiModeSettings", "analysisDPUWiFiDatagramAnswerCommand receiveOrder serino = " + new String(bArr3, Charset.forName(StringEncodings.US_ASCII)));
                                                            }
                                                            if (bArr2 != null && bArr3 != null && Arrays.equals(bArr2, bArr3)) {
                                                                z2 = true;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            b = 0;
                                                            Arrays.fill(bArr4, b);
                                                            datagramPacket2.setData(bArr4);
                                                            i8 = i + 1;
                                                            e.printStackTrace();
                                                            C1856n.m8127b("DPUWiFiManager", "receive broadcast error,exception :" + e.getMessage());
                                                            i2 = 6;
                                                            i3 = 4;
                                                            i9 = 5;
                                                            i4 = 0;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        bArr3 = null;
                                        if (bArr2 != null) {
                                            z2 = true;
                                        }
                                    }
                                }
                                z2 = false;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e5) {
                            e5.printStackTrace();
                        }
                        if (C1856n.f10135a) {
                            C1856n.m8127b("DPUWiFiManager", "send broadcast error,exception :" + e4.getMessage() + " ; " + (5 - i8) + "  more tries...");
                        }
                        i2 = 6;
                        i3 = 4;
                        i9 = 5;
                        i4 = 0;
                    }
                    if (z2) {
                        str = datagramPacket2.getAddress().getHostAddress();
                        datagramPacket2.getPort();
                        z = true;
                        break;
                    }
                    try {
                        i8 = i + 1;
                        Arrays.fill(bArr4, (byte) 0);
                        datagramPacket2.setData(bArr4);
                        i2 = 6;
                        i3 = 4;
                        i9 = 5;
                        i4 = 0;
                    } catch (Exception e6) {
                        e = e6;
                    }
                    e = e6;
                    b = 0;
                    Arrays.fill(bArr4, b);
                    datagramPacket2.setData(bArr4);
                    i8 = i + 1;
                    e.printStackTrace();
                    C1856n.m8127b("DPUWiFiManager", "receive broadcast error,exception :" + e.getMessage());
                    i2 = 6;
                    i3 = 4;
                    i9 = 5;
                    i4 = 0;
                }
                datagramSocket.close();
                if (z) {
                    if (m8094e) {
                        return new InetSocketAddress(str, 22488);
                    }
                    return new InetSocketAddress(str, 8080);
                }
                return null;
            } catch (Exception e7) {
                C1856n.m8127b("DPUWiFiManager", "DatagramSocket initialize error,exception :" + e7.getMessage());
                return null;
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f10201i;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f10202j;
    }

    /* renamed from: a */
    public final void m8051a(String str) {
        this.f10196d = 0;
        Intent intent = new Intent("DPUDeviceConnectFail");
        intent.putExtra("is_connect_fail", true);
        intent.putExtra("isFix", this.f10198f);
        if (str == null) {
            if (Tools.m8113a(this.f10193a)) {
                intent.putExtra(MessageDao.TABLENAME, this.f10193a.getString(C1411a.C1412a.msg_wifi_state_no_active));
            } else if (Tools.m8100b(this.f10193a)) {
                intent.putExtra(MessageDao.TABLENAME, this.f10193a.getString(C1411a.C1412a.msg_wifi_connect_state_fail_for_wifi_priority));
            } else {
                intent.putExtra(MessageDao.TABLENAME, this.f10193a.getString(C1411a.C1412a.msg_wifi_connect_state_fail));
            }
        } else {
            intent.putExtra(MessageDao.TABLENAME, str);
        }
        this.f10193a.sendBroadcast(intent);
    }
}
