package com.cnlaunch.physics.p192a.p194b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.RomoteLocalSwitch;
import com.cnlaunch.physics.p192a.BluetoothsNeedDirectLinkManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.ConnectWaitTimer;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.physics.a.b.a */
/* loaded from: classes.dex */
public final class BluetoothManagerImpl implements IPhysics {

    /* renamed from: c */
    public boolean f9756c;

    /* renamed from: f */
    public BluetoothDevice f9759f;

    /* renamed from: g */
    Context f9760g;

    /* renamed from: m */
    boolean f9766m;

    /* renamed from: n */
    String f9767n;

    /* renamed from: o */
    public boolean f9768o;

    /* renamed from: p */
    public boolean f9769p;

    /* renamed from: r */
    private int f9771r;

    /* renamed from: s */
    private String f9772s;

    /* renamed from: t */
    private boolean f9773t;

    /* renamed from: a */
    final UUID f9754a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: b */
    final UUID f9755b = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: k */
    public boolean f9764k = false;

    /* renamed from: u */
    private boolean f9774u = true;

    /* renamed from: v */
    private boolean f9775v = true;

    /* renamed from: w */
    private BroadcastReceiver f9776w = new C1823b(this);

    /* renamed from: q */
    Handler f9770q = new HandlerC1825d(this, Looper.getMainLooper());

    /* renamed from: e */
    BluetoothSocket f9758e = null;

    /* renamed from: i */
    C1821a f9762i = null;

    /* renamed from: j */
    ReadByteDataStream f9763j = null;

    /* renamed from: d */
    public int f9757d = 4;

    /* renamed from: l */
    ConnectWaitTimer f9765l = new ConnectWaitTimer();

    /* renamed from: h */
    BluetoothAdapter f9761h = BluetoothAdapter.getDefaultAdapter();

    public BluetoothManagerImpl(Context context, boolean z, String str) {
        this.f9756c = true;
        this.f9760g = context.getApplicationContext();
        this.f9766m = z;
        this.f9756c = true;
        if (!this.f9761h.isEnabled()) {
            this.f9761h.enable();
        }
        this.f9771r = 0;
        C1856n.m8125d("BluetoothManagerImpl", "BluetoothManager register Receiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        this.f9760g.registerReceiver(this.f9776w, intentFilter);
        this.f9767n = str;
        this.f9773t = false;
        this.f9768o = false;
        this.f9769p = false;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("BluetoothManagerImpl", "finalize BluetoothManager");
            this.f9770q = null;
            ConnectWaitTimer connectWaitTimer = this.f9765l;
            connectWaitTimer.m8164a();
            connectWaitTimer.f10098a.shutdown();
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m8438a(String str, String str2) {
        C1856n.m8127b("BluetoothManagerImpl", "auto Bluetooth Connect serialNo=" + str + "deviceAddress=" + str2);
        boolean z = true;
        this.f9764k = true;
        this.f9756c = true;
        this.f9757d = 4;
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                m8439a(str2);
                return;
            } else if (TextUtils.isEmpty(str)) {
                return;
            } else {
                Iterator<BluetoothDevice> it = this.f9761h.getBondedDevices().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    BluetoothDevice next = it.next();
                    if (next.getName() != null && next.getName().equals(str)) {
                        m8439a(next.getAddress());
                        break;
                    }
                }
                if (z) {
                    return;
                }
                m8437a(false, -1);
                return;
            }
        }
        m8437a(false, 0);
    }

    /* renamed from: a */
    public final void m8445a() {
        if (m8436b() != null) {
            m8444a(2);
            C1821a c1821a = this.f9762i;
            if (c1821a != null) {
                c1821a.m8434a();
                this.f9762i = null;
            }
            C1856n.m8127b("BluetoothManagerImpl", "mReadByteDataStreamThread cancel ");
            ReadByteDataStream readByteDataStream = this.f9763j;
            if (readByteDataStream != null) {
                readByteDataStream.m8195a();
                this.f9763j = null;
            }
            Context context = this.f9760g;
            m8441a(context, "action.bt.device.con.coning", Opcodes.ISHL, context.getString(C1411a.C1412a.bluetooth_connecting), this.f9759f, this.f9757d);
            this.f9762i = new C1821a(this.f9759f);
            this.f9762i.start();
            return;
        }
        m8437a(true, 0);
    }

    /* renamed from: a */
    private void m8439a(String str) {
        this.f9759f = this.f9761h.getRemoteDevice(str);
        m8445a();
    }

    /* renamed from: a */
    final synchronized void m8444a(int i) {
        this.f9771r = i;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized int getState() {
        return this.f9771r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BluetoothManagerImpl.java */
    /* renamed from: com.cnlaunch.physics.a.b.a$a */
    /* loaded from: classes.dex */
    public class C1821a extends Thread {

        /* renamed from: b */
        private final BluetoothSocket f9778b;

        /* renamed from: c */
        private final BluetoothDevice f9779c;

        /* renamed from: d */
        private String f9780d = "Insecure";

        /* renamed from: e */
        private String f9781e;

        public C1821a(BluetoothDevice bluetoothDevice) {
            this.f9781e = "";
            C1856n.m8127b("BluetoothManagerImpl", "ConnectThread construct");
            this.f9779c = bluetoothDevice;
            if (Build.MODEL != null) {
                this.f9781e = Build.MODEL;
            }
            BluetoothSocket bluetoothSocket = null;
            if (this.f9781e.equals("") || !this.f9781e.equalsIgnoreCase("MediaPad 10 LINK")) {
                boolean m8386a = BluetoothsNeedDirectLinkManager.m8387a().m8386a(BluetoothManagerImpl.this.f9767n);
                if ((BluetoothManagerImpl.this.f9757d % 2 == 0 && !m8386a) || Build.VERSION.SDK_INT >= 21) {
                    C1856n.m8127b("BluetoothManagerImpl", "connect with public method");
                    try {
                        BluetoothsNeedDirectLinkManager.m8387a().m8385a(BluetoothManagerImpl.this.f9767n, true);
                        if (Build.VERSION.SDK_INT >= 10) {
                            if (BluetoothManagerImpl.this.f9768o) {
                                bluetoothSocket = this.f9779c.createInsecureRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9755b);
                            } else {
                                bluetoothSocket = this.f9779c.createInsecureRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9754a);
                            }
                        } else if (BluetoothManagerImpl.this.f9768o) {
                            bluetoothSocket = this.f9779c.createRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9755b);
                        } else {
                            bluetoothSocket = this.f9779c.createRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9754a);
                        }
                    } catch (IOException e) {
                        C1856n.m8127b("BluetoothManagerImpl", "Socket Type: " + this.f9780d + " create() failed " + e.getMessage());
                    }
                } else {
                    C1856n.m8127b("BluetoothManagerImpl", "connect with private method");
                    BluetoothsNeedDirectLinkManager.m8387a().m8385a(BluetoothManagerImpl.this.f9767n, false);
                    bluetoothSocket = m8433a(this.f9779c);
                }
            } else if (BluetoothManagerImpl.this.f9757d > 2) {
                bluetoothSocket = m8433a(this.f9779c);
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 10) {
                        if (BluetoothManagerImpl.this.f9768o) {
                            bluetoothSocket = this.f9779c.createInsecureRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9755b);
                        } else {
                            bluetoothSocket = this.f9779c.createInsecureRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9754a);
                        }
                    } else if (BluetoothManagerImpl.this.f9768o) {
                        bluetoothSocket = this.f9779c.createRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9755b);
                    } else {
                        bluetoothSocket = this.f9779c.createRfcommSocketToServiceRecord(BluetoothManagerImpl.this.f9754a);
                    }
                } catch (IOException e2) {
                    C1856n.m8127b("BluetoothManagerImpl", "Socket Type: " + this.f9780d + " create() failed " + e2.getMessage());
                }
            }
            this.f9778b = bluetoothSocket;
        }

        /* renamed from: a */
        private static BluetoothSocket m8433a(BluetoothDevice bluetoothDevice) {
            try {
                return (BluetoothSocket) bluetoothDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(bluetoothDevice, 1);
            } catch (Exception e) {
                Log.e("BluetoothChatService", "Could not create Insecure RFComm Connection", e);
                return null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            C1856n.m8125d("BluetoothManagerImpl", "BEGIN mConnectThread SocketType:" + this.f9780d);
            setName("ConnectThread" + this.f9780d);
            if (this.f9778b == null) {
                BluetoothManagerImpl.m8440a(BluetoothManagerImpl.this);
                return;
            }
            BluetoothManagerImpl.this.f9761h.cancelDiscovery();
            try {
                ConnectWaitTimer connectWaitTimer = BluetoothManagerImpl.this.f9765l;
                RunnableC1822b runnableC1822b = new RunnableC1822b();
                connectWaitTimer.m8164a();
                connectWaitTimer.f10099b = connectWaitTimer.f10098a.schedule(runnableC1822b, 45L, TimeUnit.SECONDS);
                this.f9778b.connect();
                BluetoothManagerImpl.this.f9765l.m8164a();
                if (!interrupted()) {
                    BluetoothManagerImpl bluetoothManagerImpl = BluetoothManagerImpl.this;
                    BluetoothSocket bluetoothSocket = this.f9778b;
                    BluetoothDevice bluetoothDevice = this.f9779c;
                    C1856n.m8130a("BluetoothManagerImpl", "connected ");
                    bluetoothManagerImpl.f9757d = -1;
                    bluetoothManagerImpl.m8444a(3);
                    BluetoothsNeedDirectLinkManager.m8387a().m8385a(bluetoothManagerImpl.f9767n, false);
                    bluetoothManagerImpl.f9758e = bluetoothSocket;
                    bluetoothManagerImpl.m8443a(bluetoothDevice);
                    try {
                        bluetoothManagerImpl.f9763j = new ReadByteDataStream(bluetoothManagerImpl, bluetoothSocket.getInputStream(), bluetoothSocket.getOutputStream());
                    } catch (IOException e) {
                        C1856n.m8127b("BluetoothManagerImpl", "remoteSocket sockets not created" + e.getMessage());
                    }
                    new Thread(bluetoothManagerImpl.f9763j).start();
                    bluetoothManagerImpl.f9770q.sendMessage(bluetoothManagerImpl.f9770q.obtainMessage(0, 0, 0));
                    return;
                }
                m8434a();
            } catch (IOException e2) {
                BluetoothManagerImpl.this.f9765l.m8164a();
                try {
                    this.f9778b.close();
                } catch (IOException e3) {
                    C1856n.m8127b("BluetoothManagerImpl", "unable to close() " + this.f9780d + " socket during connection failure" + e3.getMessage());
                }
                C1856n.m8127b("BluetoothManagerImpl", "unable to connect() " + e2.getMessage() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e2.getClass().getSimpleName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e2.toString());
                if (!interrupted()) {
                    BluetoothManagerImpl.m8440a(BluetoothManagerImpl.this);
                } else {
                    C1856n.m8127b("BluetoothManagerImpl", "connection thread has interrupted ");
                }
            }
        }

        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public final void m8434a() {
            C1856n.m8127b("BluetoothManagerImpl", "cancel ConnectThread ");
            try {
                interrupt();
                C1856n.m8125d("BluetoothManagerImpl", "mConnectThread.interrupt() for cancel");
            } catch (Exception unused) {
                C1856n.m8125d("BluetoothManagerImpl", "mConnectThread.interrupt() Exception for cancel");
            }
            try {
                if (this.f9778b == null || !this.f9778b.isConnected()) {
                    return;
                }
                C1856n.m8130a("BluetoothManagerImpl", "socket close for cancel");
                this.f9778b.close();
            } catch (IOException e) {
                C1856n.m8127b("BluetoothManagerImpl", "close() of connect " + this.f9780d + " socket failed" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m8442a(Context context, String str) {
        context.sendBroadcast(new Intent(str));
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        return this.f9772s;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        this.f9772s = str;
        if (this.f9774u) {
            RomoteLocalSwitch m8086a = RomoteLocalSwitch.m8086a();
            String str2 = this.f9767n;
            if (!m8086a.f10149a) {
                DeviceFactoryManager.m8305a().m8298a(str);
                return;
            }
            try {
                RomoteLocalSwitch.C1859a c1859a = m8086a.f10150b.get(str2);
                IRemoteDeviceFactoryManagerCallBack iRemoteDeviceFactoryManagerCallBack = c1859a == null ? null : c1859a.f10151a;
                if (iRemoteDeviceFactoryManagerCallBack != null) {
                    iRemoteDeviceFactoryManagerCallBack.mo8264a(str);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        try {
            if (this.f9758e != null) {
                return this.f9758e.getOutputStream();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f9775v;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f9775v = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9760g;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        C1856n.m8130a("BluetoothManagerImpl", "stop bluetooth ConnectThread");
        m8443a((BluetoothDevice) null);
        BroadcastReceiver broadcastReceiver = this.f9776w;
        if (broadcastReceiver != null) {
            try {
                this.f9760g.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f9765l.m8164a();
        C1821a c1821a = this.f9762i;
        if (c1821a != null) {
            c1821a.m8434a();
            this.f9762i = null;
        }
        ReadByteDataStream readByteDataStream = this.f9763j;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            m8442a(this.f9760g, "com.cnlaunch.intent.action.DIAG_UNCONNECTED");
            this.f9763j = null;
        }
        m8444a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m8441a(Context context, String str, int i, String str2, BluetoothDevice bluetoothDevice, int i2) {
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, i);
        bundle.putString("status", str2);
        bundle.putInt("pair", 12);
        if (str.equalsIgnoreCase("action.bt.device.con.coning")) {
            bundle.putInt("auto_reconnect_count", 4 - (i2 - 1));
        }
        bundle.putParcelable("bluetoothDevice", bluetoothDevice);
        intent.putExtra("customBluetoothBroadcastIntentExtraBundle", bundle);
        intent.putExtra("isFix", this.f9766m);
        context.sendBroadcast(intent);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        if (this.f9759f != null) {
            C1856n.m8130a("BluetoothManagerImpl", "remoteDevice is not null.");
            String name = this.f9759f.getName();
            return name == null ? "" : name;
        }
        return "";
    }

    /* renamed from: a */
    final void m8437a(boolean z, int i) {
        this.f9757d = -1;
        Intent intent = new Intent("DPUDeviceConnectFail");
        intent.putExtra("isFix", this.f9766m);
        intent.putExtra("is_connect_fail", z);
        intent.putExtra("connect_fail_reason", i);
        intent.putExtra(MessageDao.TABLENAME, this.f9760g.getString(C1411a.C1412a.bluetooth_connect_fail));
        BluetoothDevice bluetoothDevice = this.f9759f;
        if (bluetoothDevice != null) {
            String name = bluetoothDevice.getName();
            if (name == null) {
                name = "";
            }
            intent.putExtra("deviceName", name);
        }
        this.f9760g.sendBroadcast(intent);
    }

    /* compiled from: BluetoothManagerImpl.java */
    /* renamed from: com.cnlaunch.physics.a.b.a$b */
    /* loaded from: classes.dex */
    class RunnableC1822b implements Runnable {
        public RunnableC1822b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BluetoothManagerImpl bluetoothManagerImpl = BluetoothManagerImpl.this;
            if (bluetoothManagerImpl.f9762i != null) {
                try {
                    bluetoothManagerImpl.f9762i.interrupt();
                    C1856n.m8125d("BluetoothManagerImpl", "mConnectThread.interrupt() for connection Failed With Long Times trigger");
                } catch (Exception e) {
                    C1856n.m8125d("BluetoothManagerImpl", "mConnectThread.interrupt() Exception for connection Failed With Long Times trigger");
                    e.printStackTrace();
                }
                bluetoothManagerImpl.f9762i = null;
            }
            C1856n.m8125d("BluetoothManagerImpl", "connection Failed With Long Times trigger");
            if (BluetoothsNeedDirectLinkManager.m8387a().m8386a(bluetoothManagerImpl.f9767n) && bluetoothManagerImpl.f9757d == 4) {
                C1856n.m8125d("BluetoothManagerImpl", "connection Failed With Long Times trigger and do connectionFailed after 15 second");
                new Timer().schedule(new C1824c(bluetoothManagerImpl), 5000L);
                return;
            }
            bluetoothManagerImpl.m8444a(0);
            bluetoothManagerImpl.m8441a(bluetoothManagerImpl.f9760g, "action.bt.device.con.fail", 140, bluetoothManagerImpl.f9760g.getString(C1411a.C1412a.bluetooth_connect_fail), bluetoothManagerImpl.f9759f, bluetoothManagerImpl.f9757d);
            bluetoothManagerImpl.m8437a(true, 0);
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f9767n;
    }

    /* renamed from: b */
    public final synchronized BluetoothDevice m8436b() {
        return this.f9759f;
    }

    /* renamed from: a */
    final synchronized void m8443a(BluetoothDevice bluetoothDevice) {
        this.f9759f = bluetoothDevice;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f9773t = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f9773t;
    }

    /* renamed from: c */
    public final void m8435c() {
        Handler handler = this.f9770q;
        if (handler != null) {
            this.f9770q.sendMessage(handler.obtainMessage(0, 0, 0));
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f9766m = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f9768o;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f9769p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8440a(BluetoothManagerImpl bluetoothManagerImpl) {
        Context context = bluetoothManagerImpl.f9760g;
        bluetoothManagerImpl.m8441a(context, "action.bt.device.con.fail", 140, context.getString(C1411a.C1412a.bluetooth_connect_fail), bluetoothManagerImpl.f9759f, bluetoothManagerImpl.f9757d);
        if ((bluetoothManagerImpl.f9756c && bluetoothManagerImpl.f9757d - 1 == 0) || !bluetoothManagerImpl.f9756c) {
            bluetoothManagerImpl.m8437a(true, 0);
            bluetoothManagerImpl.m8444a(0);
            return;
        }
        bluetoothManagerImpl.f9770q.sendEmptyMessageDelayed(2, 1000L);
    }
}
