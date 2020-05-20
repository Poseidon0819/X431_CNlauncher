package com.cnlaunch.physics.p204j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.j.b */
/* loaded from: classes.dex */
public final class DPUUSBManager implements IPhysics {

    /* renamed from: a */
    DPUUSBDevice f9977a;

    /* renamed from: b */
    String f9978b;

    /* renamed from: c */
    Context f9979c;

    /* renamed from: e */
    boolean f9981e;

    /* renamed from: f */
    DeviceFactoryManager f9982f;

    /* renamed from: g */
    public boolean f9983g;

    /* renamed from: h */
    public boolean f9984h;

    /* renamed from: i */
    private String f9985i;

    /* renamed from: j */
    private USBInputStream f9986j;

    /* renamed from: k */
    private USBOutputStream f9987k;

    /* renamed from: l */
    private String f9988l;

    /* renamed from: m */
    private boolean f9989m;

    /* renamed from: n */
    private boolean f9990n = true;

    /* renamed from: o */
    private BroadcastReceiver f9991o = new C1849c(this);

    /* renamed from: d */
    ReadByteDataStream f9980d = null;

    public DPUUSBManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.f9982f = deviceFactoryManager;
        this.f9979c = context.getApplicationContext();
        this.f9981e = z;
        String str2 = this.f9979c.getPackageName() + ".USB_PERMISSION";
        this.f9978b = str2;
        this.f9977a = new DPUUSBDevice(this.f9979c, str2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction(this.f9978b);
        C1856n.m8130a("DPUUSBManager", "mUeventBroadcastReceiver registerReceiver=." + this.f9991o.toString());
        this.f9979c.registerReceiver(this.f9991o, intentFilter);
        this.f9986j = null;
        this.f9987k = null;
        this.f9988l = str;
        this.f9989m = false;
        this.f9983g = false;
        this.f9984h = false;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("DPUUSBManager", "finalize DPUUSBManager");
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        int m8246a = this.f9977a.m8246a();
        C1856n.m8130a("DPUUSBManager", "UsbDevice State =".concat(String.valueOf(m8246a)));
        if (m8246a != -11) {
            if (m8246a != -9) {
                return m8246a != -7 ? 0 : 3;
            }
            return 2;
        }
        return 3;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        return this.f9985i;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        this.f9985i = str;
        this.f9982f.m8298a(str);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        return this.f9987k;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f9990n;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f9990n = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9979c;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        if (this.f9977a != null) {
            C1856n.m8130a("DPUUSBManager", "mUsbDevice is not null.");
            DPUUSBDevice dPUUSBDevice = this.f9977a;
            if (dPUUSBDevice.f9974a != null) {
                DPUUsbDriver dPUUsbDriver = dPUUSBDevice.f9974a;
                return dPUUsbDriver.f9997e != null ? dPUUsbDriver.f9997e.getDeviceName() : "";
            }
            return "";
        }
        return "";
    }

    /* renamed from: a */
    private String m8239a(int i) {
        if (i != -19) {
            if (i != -17) {
                if (i != 0) {
                    switch (i) {
                        case -14:
                            return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_state_device_not_support);
                        case -13:
                            return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_state_no_device_detected);
                        default:
                            return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_connect_state_fail);
                    }
                }
                return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_connect_state_success);
            }
            return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_state_no_permission);
        }
        return this.f9979c.getResources().getString(C1411a.C1412a.msg_usb_state_no_exclusive_access);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        ReadByteDataStream readByteDataStream = this.f9980d;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            m8237a(this.f9979c, "com.cnlaunch.intent.action.DIAG_UNCONNECTED");
            this.f9980d = null;
        }
        this.f9977a.m8241d();
        C1856n.m8130a("DPUUSBManager", "mUeventBroadcastReceiver=." + this.f9991o.toString());
        BroadcastReceiver broadcastReceiver = this.f9991o;
        if (broadcastReceiver != null) {
            try {
                this.f9979c.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final int m8234a(boolean z) {
        C1856n.m8130a("DPUUSBManager", "open before status=" + this.f9977a.m8246a());
        if (-7 == this.f9977a.m8246a()) {
            return -7;
        }
        int m8242c = this.f9977a.m8242c();
        m8238a(m8242c, z);
        return m8242c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m8238a(int i, boolean z) {
        if (i == -17 || i == -7) {
            return;
        }
        if (i == 0) {
            C1856n.m8130a("DPUUSBManager", "Connect SUCCESS");
            m8240a();
            Intent intent = new Intent("DPUDeviceConnectSuccess");
            intent.putExtra("isFix", this.f9981e);
            intent.putExtra(MessageDao.TABLENAME, m8239a(i));
            this.f9979c.sendBroadcast(intent);
        } else if (z) {
        } else {
            Intent intent2 = new Intent("DPUDeviceConnectFail");
            intent2.putExtra("is_connect_fail", true);
            intent2.putExtra("isFix", this.f9981e);
            intent2.putExtra(MessageDao.TABLENAME, m8239a(i));
            this.f9979c.sendBroadcast(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m8237a(Context context, String str) {
        context.sendBroadcast(new Intent(str));
    }

    /* renamed from: a */
    private void m8240a() {
        this.f9986j = new USBInputStream(this.f9977a);
        this.f9987k = new USBOutputStream(this.f9977a, this.f9982f.f9916p);
        this.f9980d = new ReadByteDataStream(this, this.f9986j, this.f9987k);
        new Thread(this.f9980d).start();
        m8237a(this.f9979c, "com.cnlaunch.intent.action.DIAG_CONNECTED");
    }

    /* renamed from: a */
    public final boolean m8236a(Intent intent) {
        DPUUSBDevice dPUUSBDevice = this.f9977a;
        if (dPUUSBDevice != null) {
            return dPUUSBDevice.m8245a(intent);
        }
        return false;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f9988l;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f9989m = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f9989m;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f9981e = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f9983g;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f9984h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m8235a(DPUUSBManager dPUUSBManager, int i) {
        if (i != -7) {
            if (i == 0) {
                C1856n.m8130a("DPUUSBManager", "Connect With Permisson Request SUCCESS");
                dPUUSBManager.m8240a();
                Intent intent = new Intent("DPUDeviceConnectSuccess");
                intent.putExtra("isFix", dPUUSBManager.f9981e);
                intent.putExtra(MessageDao.TABLENAME, dPUUSBManager.m8239a(i));
                dPUUSBManager.f9979c.sendBroadcast(intent);
                return;
            }
            Intent intent2 = new Intent("DPUDeviceConnectFail");
            intent2.putExtra("is_connect_fail", true);
            intent2.putExtra("isFix", dPUUSBManager.f9981e);
            intent2.putExtra(MessageDao.TABLENAME, dPUUSBManager.m8239a(i));
            dPUUSBManager.f9979c.sendBroadcast(intent2);
        }
    }
}
