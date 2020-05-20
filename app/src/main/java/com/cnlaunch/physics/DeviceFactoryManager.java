package com.cnlaunch.physics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.LinkParameters;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p199e.IAssitsPhysics;
import com.cnlaunch.physics.p199e.IAssitsPhysicsMatcher;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;
import com.cnlaunch.physics.p203i.ISimulatorDataProcessor;
import com.cnlaunch.physics.p204j.DPUUSBDevice;
import com.cnlaunch.physics.p204j.DPUUSBManager;
import com.cnlaunch.physics.p204j.DPUUsbDriver;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.LocalServerSocketThread;
import com.cnlaunch.physics.p205k.LocalSocketAcceptThread;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.physics.serialport.SerialPortManager;
import com.cnlaunch.physics.wifi.IDPUWiFiModeSettings;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.cnlaunch.physics.e */
/* loaded from: classes.dex */
public final class DeviceFactoryManager {

    /* renamed from: q */
    private static DeviceFactoryManager f9895q;

    /* renamed from: A */
    private boolean f9896A;

    /* renamed from: B */
    private LinkParameters.C1852a f9897B;

    /* renamed from: E */
    private InterfaceC1837b f9900E;

    /* renamed from: h */
    public IDPUWiFiModeSettings f9908h;

    /* renamed from: i */
    public ISimulatorDataProcessor f9909i;

    /* renamed from: j */
    public boolean f9910j;

    /* renamed from: k */
    public boolean f9911k;

    /* renamed from: l */
    public boolean f9912l;

    /* renamed from: m */
    public String f9913m;

    /* renamed from: v */
    private InterfaceC1838c f9921v;

    /* renamed from: w */
    private boolean f9922w;

    /* renamed from: x */
    private boolean f9923x;

    /* renamed from: z */
    private List<IAssitsPhysics> f9925z;

    /* renamed from: f */
    public boolean f9906f = false;

    /* renamed from: n */
    public IRemoteDeviceFactoryManager f9914n = null;

    /* renamed from: C */
    private ServiceConnection f9898C = new ServiceConnectionC1839f(this);

    /* renamed from: o */
    public IRemoteDeviceFactoryManagerCallBack.AbstractBinderC1844a f9915o = new BinderC1840g(this);

    /* renamed from: D */
    private Handler f9899D = new HandlerC1841h(this, Looper.getMainLooper());

    /* renamed from: p */
    public IPhysicsOutputStreamBufferWrapper f9916p = new C1846i(this);

    /* renamed from: y */
    private PAD3DHCPForDoIP f9924y = null;

    /* renamed from: u */
    private Context f9920u = null;

    /* renamed from: g */
    public int f9907g = 0;

    /* renamed from: a */
    public IPhysics f9901a = null;

    /* renamed from: b */
    public boolean f9902b = false;

    /* renamed from: d */
    public boolean f9904d = false;

    /* renamed from: s */
    private boolean f9918s = false;

    /* renamed from: e */
    public Dialog f9905e = null;

    /* renamed from: c */
    public int f9903c = -1;

    /* renamed from: t */
    private boolean f9919t = false;

    /* renamed from: r */
    private LocalServerSocketThread f9917r = new LocalServerSocketThread(this);

    /* compiled from: DeviceFactoryManager.java */
    /* renamed from: com.cnlaunch.physics.e$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1837b {
    }

    /* compiled from: DeviceFactoryManager.java */
    /* renamed from: com.cnlaunch.physics.e$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1838c {
    }

    /* renamed from: a */
    public static DeviceFactoryManager m8305a() {
        if (f9895q == null) {
            f9895q = new DeviceFactoryManager();
        }
        return f9895q;
    }

    private DeviceFactoryManager() {
        this.f9917r.start();
        this.f9908h = null;
        this.f9909i = null;
        this.f9921v = null;
        this.f9911k = false;
        this.f9922w = false;
        this.f9912l = false;
        this.f9913m = "";
        this.f9923x = false;
        this.f9925z = Collections.synchronizedList(new LinkedList());
        this.f9896A = false;
        this.f9897B = null;
        this.f9910j = false;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("DeviceFactoryManager", "finalize DeviceFactoryManager");
            if (this.f9917r != null) {
                this.f9917r.m8136b();
                this.f9917r = null;
            }
            PAD3DHCPForDoIP pAD3DHCPForDoIP = this.f9924y;
            if (pAD3DHCPForDoIP.f10143c) {
                if (C1856n.f10135a) {
                    C1856n.m8130a(PAD3DHCPForDoIP.f10141a, "ro.support_lan_dhcp is true");
                    String str = PAD3DHCPForDoIP.f10141a;
                    C1856n.m8130a(str, "pad3DHCPBroadcastReceiver  unregisterBoardcasetReciver" + pAD3DHCPForDoIP.f10144d.toString());
                }
                try {
                    if (pAD3DHCPForDoIP.f10142b != null) {
                        pAD3DHCPForDoIP.f10142b.unregisterReceiver(pAD3DHCPForDoIP.f10144d);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m8293b() {
        if (C1856n.f10135a) {
            C1856n.m8130a("DeviceFactoryManager", "init stop ConnectThread ,link mode =" + this.f9903c);
        }
        LocalServerSocketThread localServerSocketThread = this.f9917r;
        if (localServerSocketThread != null) {
            localServerSocketThread.m8137a();
        }
        int i = this.f9903c;
        if ((i != 0 && i != 1 && i != 2) || ((Tools.m8114a() && !Tools.m8101b()) || this.f9912l)) {
            m8288c();
        }
        m8271i();
        this.f9896A = false;
    }

    /* renamed from: h */
    private void m8273h() {
        this.f9902b = false;
        this.f9904d = false;
        this.f9905e = null;
        this.f9903c = -1;
        this.f9907g = 0;
        this.f9923x = false;
        this.f9897B = null;
    }

    /* renamed from: c */
    public final void m8288c() {
        IPhysics iPhysics = this.f9901a;
        if (iPhysics != null) {
            iPhysics.closeDevice();
            this.f9901a = null;
        }
        m8273h();
    }

    /* renamed from: d */
    public final void m8284d() {
        IPhysics iPhysics = this.f9901a;
        if (iPhysics != null) {
            iPhysics.physicalCloseDevice();
            this.f9901a = null;
        }
        m8273h();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.cnlaunch.physics.p199e.IPhysics m8301a(android.content.Context r10, boolean r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.physics.DeviceFactoryManager.m8301a(android.content.Context, boolean, java.lang.String):com.cnlaunch.physics.e.c");
    }

    /* renamed from: b */
    private int m8291b(Context context, boolean z, String str) {
        boolean z2 = DPULinkSettingsInformation.m8314a().m8310b(str) || PreferencesManager.m9595a(context).m9583b("link_mode_wifi_switch_for_simulate", false);
        C1856n.m8130a("DeviceFactoryManager", "wifiSwitch = " + z2 + " isFix =" + z + " getFirmwareFixSubMode()=" + this.f9907g);
        if (!z2 || (z && this.f9907g == 2)) {
            return PreferencesManager.m9595a(context).m9583b("link_mode_serialport_switch", false) ? 2 : 0;
        }
        return 1;
    }

    /* renamed from: c */
    private BluetoothManager m8286c(Context context, boolean z, String str) {
        if (m8277f()) {
            RomoteLocalSwitch.m8086a().m8085a(true);
        } else {
            RomoteLocalSwitch.m8086a().m8085a(false);
        }
        BluetoothManager bluetoothManager = new BluetoothManager(context, z, str, this.f9912l);
        bluetoothManager.m8449a(this.f9911k);
        bluetoothManager.m8447b(this.f9922w);
        return bluetoothManager;
    }

    /* renamed from: d */
    private DPUUSBManager m8282d(Context context, boolean z, String str) {
        RomoteLocalSwitch.m8086a().m8085a(false);
        DPUUSBManager dPUUSBManager = new DPUUSBManager(this, context, z, str);
        dPUUSBManager.f9983g = this.f9911k;
        dPUUSBManager.f9984h = this.f9922w;
        return dPUUSBManager;
    }

    /* renamed from: e */
    private SerialPortManager m8278e(Context context, boolean z, String str) {
        RomoteLocalSwitch.m8086a().m8085a(false);
        SerialPortManager serialPortManager = new SerialPortManager(this, context, z, str);
        if (this.f9897B != null) {
            LinkParameters linkParameters = new LinkParameters();
            linkParameters.f10025a = this.f9897B;
            serialPortManager.setLinkParameters(linkParameters);
        }
        serialPortManager.setIsRemoteClientDiagnoseMode(this.f9911k);
        serialPortManager.setIsSupportOneRequestMoreAnswerDiagnoseMode(this.f9922w);
        return serialPortManager;
    }

    /* renamed from: e */
    public final String m8280e() {
        IPhysics iPhysics = this.f9901a;
        if (iPhysics != null) {
            String deviceName = iPhysics.getDeviceName();
            if (TextUtils.isEmpty(deviceName)) {
                Context context = this.f9901a.getContext();
                if (context != null) {
                    return PreferencesManager.m9595a(context).m9584b("serialNo", "");
                }
                return null;
            }
            return deviceName;
        }
        return null;
    }

    /* renamed from: a */
    public final void m8295a(byte[] bArr) {
        m8294a(bArr, bArr.length);
    }

    /* renamed from: a */
    public final void m8294a(byte[] bArr, int i) {
        OutputStream outputStream;
        OutputStream outputStream2;
        try {
            if (this.f9925z.size() > 0) {
                boolean z = true;
                if (C1856n.f10135a) {
                    C1856n.m8130a("DeviceFactoryManager", String.format("mAssitsPhysicsList.size()>0 offset=%d count=%d", 0, Integer.valueOf(i)));
                    C1856n.m8130a("DeviceFactoryManager", "write mCurrentDevice= " + this.f9901a);
                }
                Iterator<IAssitsPhysics> it = this.f9925z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    IAssitsPhysics next = it.next();
                    IAssitsPhysicsMatcher assitsPhysicsMatcher = next.getAssitsPhysicsMatcher();
                    if (assitsPhysicsMatcher != null && assitsPhysicsMatcher.m8270a()) {
                        if (C1856n.f10135a) {
                            C1856n.m8130a("DeviceFactoryManager", "assitsPhysicsMatcher isMatched ");
                        }
                        OutputStream outputStream3 = next.getPhysics().getOutputStream();
                        if (outputStream3 != null) {
                            outputStream3.write(bArr, 0, i);
                            outputStream3.flush();
                        }
                    }
                }
                if (z || this.f9901a == null || (outputStream2 = this.f9901a.getOutputStream()) == null) {
                    return;
                }
                outputStream2.write(bArr, 0, i);
                outputStream2.flush();
            } else if (this.f9901a == null || (outputStream = this.f9901a.getOutputStream()) == null) {
            } else {
                outputStream.write(bArr, 0, i);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m8298a(String str) {
        if (this.f9900E != null || this.f9911k) {
            return;
        }
        LocalServerSocketThread localServerSocketThread = this.f9917r;
        if (localServerSocketThread.f10128b != null) {
            LocalSocketAcceptThread localSocketAcceptThread = localServerSocketThread.f10128b;
            if (localSocketAcceptThread.f10132b != null) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(localSocketAcceptThread.f10132b.getOutputStream()));
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    C1856n.m8130a(LocalSocketAcceptThread.f10131a, "send fail command=".concat(String.valueOf(str)));
                }
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public final void m8297a(boolean z) {
        if (this.f9904d != z) {
            this.f9904d = z;
            if (this.f9904d) {
                if (this.f9903c == 0) {
                    this.f9903c = 3;
                } else {
                    this.f9903c = 0;
                }
            }
        }
    }

    /* renamed from: g */
    private static boolean m8274g(Context context) {
        String packageName = context.getPackageName();
        DPUUSBDevice dPUUSBDevice = new DPUUSBDevice(context, packageName + ".USB_PERMISSION");
        int m8244b = dPUUSBDevice.m8244b();
        C1856n.m8130a("DeviceFactoryManager", "queryUsbDeviceExist STATE = ".concat(String.valueOf(m8244b)));
        boolean z = m8244b == 0;
        dPUUSBDevice.m8241d();
        return z;
    }

    /* renamed from: a */
    public static boolean m8303a(Context context, Intent intent) {
        String packageName = context.getPackageName();
        DPUUSBDevice dPUUSBDevice = new DPUUSBDevice(context, packageName + ".USB_PERMISSION");
        boolean m8245a = dPUUSBDevice.m8245a(intent);
        dPUUSBDevice.m8241d();
        return m8245a;
    }

    /* compiled from: DeviceFactoryManager.java */
    /* renamed from: com.cnlaunch.physics.e$a */
    /* loaded from: classes.dex */
    public final class DialogInterface$OnCancelListenerC1836a implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
        public DialogInterface$OnCancelListenerC1836a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Process.killProcess(Process.myPid());
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            Process.killProcess(Process.myPid());
        }
    }

    /* renamed from: b */
    public final void m8292b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.cnlaunch.dpulinkmanager", "com.cnlaunch.dpulinkmanager.DPULinkManagerService"));
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
            m8289b(false);
        }
    }

    /* renamed from: c */
    public final void m8287c(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.cnlaunch.dpulinkmanager", "com.cnlaunch.dpulinkmanager.DPULinkManagerService"));
            context.startService(intent);
            context.getApplicationContext().bindService(intent, this.f9898C, 1);
            this.f9920u = context;
            this.f9924y = new PAD3DHCPForDoIP(this.f9920u);
            PAD3DHCPForDoIP pAD3DHCPForDoIP = this.f9924y;
            if (pAD3DHCPForDoIP.f10143c) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.bsk.broadcast.eth.start.service.status");
                intentFilter.addAction("com.bsk.broadcast.eth.stop.service.status");
                intentFilter.addAction("com.bsk.broadcast.eth.cable.status");
                intentFilter.addAction("com.bsk.broadcast.eth.service.ip");
                if (C1856n.f10135a) {
                    C1856n.m8130a(PAD3DHCPForDoIP.f10141a, "ro.support_lan_dhcp is true");
                    String str = PAD3DHCPForDoIP.f10141a;
                    C1856n.m8130a(str, "pad3DHCPBroadcastReceiver registerReceiver=." + pAD3DHCPForDoIP.f10144d.toString());
                }
                if (pAD3DHCPForDoIP.f10142b != null) {
                    pAD3DHCPForDoIP.f10142b.registerReceiver(pAD3DHCPForDoIP.f10144d, intentFilter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            m8289b(false);
        }
        PreferencesManager.m9595a(context).m9584b("serialNo", "");
    }

    /* renamed from: h */
    private static String m8272h(Context context) {
        return context != null ? PreferencesManager.m9595a(context).m9584b("serialNo", "") : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m8289b(boolean z) {
        this.f9919t = z;
    }

    /* renamed from: f */
    public final synchronized boolean m8277f() {
        return this.f9919t;
    }

    /* renamed from: d */
    public final void m8283d(Context context) {
        m8305a().m8288c();
        if (context != null) {
            if (!RomoteLocalSwitch.m8086a().f10149a) {
                context.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_UNCONNECTED"));
            }
            try {
                if (m8277f()) {
                    context.getApplicationContext().unbindService(this.f9898C);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public static void m8279e(Context context) {
        if (context != null) {
            context.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
        }
    }

    /* renamed from: a */
    public static String m8302a(Context context, String str) {
        return BluetoothManager.m8451a(context, str);
    }

    /* renamed from: i */
    private void m8271i() {
        if (this.f9925z.size() > 0) {
            for (IAssitsPhysics iAssitsPhysics : this.f9925z) {
                iAssitsPhysics.getPhysics().closeDevice();
            }
            this.f9925z.clear();
        }
    }

    /* renamed from: g */
    public final boolean m8275g() {
        return this.f9909i != null;
    }

    /* renamed from: a */
    public final int m8296a(boolean z, Context context, String str) {
        if (z && this.f9907g == 4) {
            return 0;
        }
        if (this.f9909i != null) {
            return 6;
        }
        if (m8274g(context)) {
            return 3;
        }
        if (PreferencesManager.m9595a(context).m9583b("link_mode_serialport_switch", false)) {
            return 2;
        }
        if (str == null) {
            str = m8272h(context);
        }
        return (!(DPULinkSettingsInformation.m8314a().m8310b(str) || PreferencesManager.m9595a(context).m9583b("link_mode_wifi_switch_for_simulate", false)) || (z && this.f9907g == 2)) ? 0 : 1;
    }

    /* renamed from: a */
    public static boolean m8304a(Context context) {
        String packageName = context.getPackageName();
        DPUUSBDevice dPUUSBDevice = new DPUUSBDevice(context, packageName + ".USB_PERMISSION");
        boolean z = false;
        if (dPUUSBDevice.f9974a != null) {
            DPUUsbDriver dPUUsbDriver = dPUUSBDevice.f9974a;
            if (dPUUsbDriver.m8227b() == 0 && dPUUsbDriver.m8222f()) {
                z = true;
            }
        }
        dPUUSBDevice.m8241d();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m8276f(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(17039380);
        builder.setMessage(context.getString(C1411a.C1412a.msg_system_dpulms_error_tips));
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.setOnCancelListener(null);
        builder.show();
    }
}
