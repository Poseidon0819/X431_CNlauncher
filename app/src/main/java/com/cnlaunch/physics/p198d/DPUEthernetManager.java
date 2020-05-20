package com.cnlaunch.physics.p198d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p200f.PhysicsOutputStreamWrapper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: com.cnlaunch.physics.d.a */
/* loaded from: classes.dex */
public final class DPUEthernetManager implements IPhysics {

    /* renamed from: a */
    Context f9873a;

    /* renamed from: f */
    boolean f9878f;

    /* renamed from: g */
    DeviceFactoryManager f9879g;

    /* renamed from: h */
    String f9880h;

    /* renamed from: i */
    public boolean f9881i;

    /* renamed from: j */
    public boolean f9882j;

    /* renamed from: m */
    private String f9885m;

    /* renamed from: o */
    private String f9887o;

    /* renamed from: q */
    private InputStream f9889q;

    /* renamed from: r */
    private OutputStream f9890r;

    /* renamed from: n */
    private boolean f9886n = true;

    /* renamed from: k */
    Handler f9883k = new HandlerC1834b(this, Looper.getMainLooper());

    /* renamed from: l */
    BroadcastReceiver f9884l = new C1835c(this);

    /* renamed from: c */
    public C1833a f9875c = null;

    /* renamed from: b */
    Socket f9874b = null;

    /* renamed from: d */
    public ReadByteDataStream f9876d = null;

    /* renamed from: e */
    public int f9877e = 0;

    /* renamed from: p */
    private boolean f9888p = false;

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        return null;
    }

    public DPUEthernetManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.f9873a = context.getApplicationContext();
        this.f9878f = z;
        this.f9879g = deviceFactoryManager;
        this.f9887o = str;
        String packageName = this.f9873a.getPackageName();
        this.f9880h = packageName + ".USB_PERMISSION";
        this.f9889q = null;
        this.f9890r = null;
        this.f9881i = false;
        this.f9882j = false;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("DPUEthernetManager", "finalize DPUEthernetManager");
            this.f9883k = null;
            this.f9874b = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9873a;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f9886n;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f9886n = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        try {
            this.f9873a.unregisterReceiver(this.f9884l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1856n.m8130a("DPUEthernetManager", "stop ethernet ConnectThread");
        C1833a c1833a = this.f9875c;
        if (c1833a != null) {
            c1833a.m8306a();
            this.f9875c = null;
        }
        ReadByteDataStream readByteDataStream = this.f9876d;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f9873a.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_UNCONNECTED"));
            this.f9876d = null;
        }
        this.f9877e = 0;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        return this.f9877e;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        return this.f9885m;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        this.f9885m = str;
        this.f9879g.m8298a(str);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        try {
            if (this.f9890r == null) {
                this.f9890r = new PhysicsOutputStreamWrapper(this.f9874b.getOutputStream(), this.f9879g.f9916p);
            }
            return this.f9890r;
        } catch (Exception unused) {
            return null;
        }
    }

    /* compiled from: DPUEthernetManager.java */
    /* renamed from: com.cnlaunch.physics.d.a$a */
    /* loaded from: classes.dex */
    public class C1833a extends Thread {

        /* renamed from: b */
        private final Socket f9892b;

        public C1833a() {
            C1856n.m8127b("DPUEthernetManager", "ConnectThread construct");
            this.f9892b = new Socket();
            try {
                this.f9892b.setTcpNoDelay(true);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            InetSocketAddress inetSocketAddress;
            if (!Tools.m8094e(DPUEthernetManager.this.f9873a, DPUEthernetManager.this.getSerialNo())) {
                inetSocketAddress = null;
            } else if (DPUEthernetManager.this.f9879g != null && DPUEthernetManager.this.f9878f && DPUEthernetManager.this.f9879g.f9907g == 5) {
                inetSocketAddress = new InetSocketAddress("192.168.100.1", 22400);
            } else {
                inetSocketAddress = new InetSocketAddress("192.168.100.1", 22488);
            }
            if (inetSocketAddress == null && !interrupted()) {
                DPUEthernetManager dPUEthernetManager = DPUEthernetManager.this;
                dPUEthernetManager.m8307a(dPUEthernetManager.f9873a.getResources().getString(C1411a.C1412a.msg_ethernet_connect_state_fail_with_no_ip));
                return;
            }
            try {
                if (!interrupted()) {
                    this.f9892b.connect(inetSocketAddress, 10000);
                }
            } catch (Exception e) {
                C1856n.m8127b("DPUEthernetManager", "unable to connect() exception : " + e.getMessage());
                try {
                    if (!interrupted()) {
                        this.f9892b.connect(inetSocketAddress, 10000);
                    }
                } catch (Exception unused) {
                    C1856n.m8127b("DPUEthernetManager", "try connect error unable to connect() exception : " + e.getMessage());
                    if (interrupted()) {
                        return;
                    }
                    DPUEthernetManager.this.m8307a(null);
                    return;
                }
            }
            if (interrupted()) {
                return;
            }
            DPUEthernetManager dPUEthernetManager2 = DPUEthernetManager.this;
            Socket socket = this.f9892b;
            C1856n.m8130a("DPUEthernetManager", "connected ");
            dPUEthernetManager2.f9874b = socket;
            try {
                dPUEthernetManager2.f9876d = new ReadByteDataStream(dPUEthernetManager2, socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e2) {
                C1856n.m8127b("DPUEthernetManager", "ethernet Socket sockets not created" + e2.getMessage());
            }
            new Thread(dPUEthernetManager2.f9876d).start();
            dPUEthernetManager2.f9877e = 3;
            dPUEthernetManager2.f9883k.sendEmptyMessage(0);
        }

        /* renamed from: a */
        public final void m8306a() {
            C1856n.m8127b("DPUEthernetManager", "cancel ConnectThread ");
            try {
                interrupt();
                C1856n.m8125d("DPUEthernetManager", "mConnectThread.interrupt() for cancel");
            } catch (Exception unused) {
                C1856n.m8125d("DPUEthernetManager", "mConnectThread.interrupt() Exception for cancel");
            }
            try {
                if (this.f9892b == null || !this.f9892b.isConnected()) {
                    return;
                }
                this.f9892b.close();
            } catch (IOException unused2) {
                C1856n.m8127b("DPUEthernetManager", " close() of Socket connect ");
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f9887o;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f9888p = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f9888p;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f9878f = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f9881i;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f9882j;
    }

    /* renamed from: a */
    final void m8307a(String str) {
        this.f9877e = 0;
        Intent intent = new Intent("DPUDeviceConnectFail");
        intent.putExtra("is_connect_fail", true);
        intent.putExtra("isFix", this.f9878f);
        if (str == null) {
            intent.putExtra(MessageDao.TABLENAME, this.f9873a.getString(C1411a.C1412a.msg_ethernet_connect_state_fail));
        } else {
            intent.putExtra(MessageDao.TABLENAME, str);
        }
        this.f9873a.sendBroadcast(intent);
    }
}
