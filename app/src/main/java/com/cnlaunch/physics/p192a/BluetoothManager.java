package com.cnlaunch.physics.p192a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.RomoteLocalSwitch;
import com.cnlaunch.physics.p192a.p193a.BluetoothBLEManager;
import com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager;
import com.cnlaunch.physics.p192a.p194b.BluetoothManagerImpl;
import com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager;
import com.cnlaunch.physics.p199e.IAssitsPhysics;
import com.cnlaunch.physics.p199e.IAssitsPhysicsMatcher;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManager;
import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.a.b */
/* loaded from: classes.dex */
public final class BluetoothManager implements IAssitsPhysics, IPhysics {

    /* renamed from: a */
    public IRemoteBluetoothManager f9746a;

    /* renamed from: b */
    public BluetoothManagerImpl f9747b;

    /* renamed from: c */
    public BluetoothBLEManager f9748c;

    /* renamed from: d */
    InputStream f9749d;

    /* renamed from: e */
    OutputStream f9750e;

    /* renamed from: f */
    public boolean f9751f;

    /* renamed from: g */
    private Context f9752g;

    /* renamed from: h */
    private IAssitsPhysicsMatcher f9753h;

    @Override // com.cnlaunch.physics.p199e.IAssitsPhysics
    public final IPhysics getPhysics() {
        return this;
    }

    public BluetoothManager(Context context, boolean z, String str, boolean z2) {
        this.f9752g = context.getApplicationContext();
        this.f9751f = z2;
        if (this.f9751f) {
            this.f9746a = null;
            this.f9747b = null;
            this.f9749d = null;
            this.f9750e = null;
            this.f9748c = new BluetoothBLEManager(DeviceFactoryManager.m8305a(), context, z, str);
        } else if (!RomoteLocalSwitch.m8086a().f10149a) {
            this.f9746a = null;
            this.f9748c = null;
            this.f9749d = null;
            this.f9750e = null;
            this.f9747b = new BluetoothManagerImpl(context, z, str);
        } else {
            IRemoteDeviceFactoryManagerCallBack.AbstractBinderC1844a abstractBinderC1844a = DeviceFactoryManager.m8305a().f9915o;
            IRemoteDeviceFactoryManager iRemoteDeviceFactoryManager = DeviceFactoryManager.m8305a().f9914n;
            try {
                this.f9746a = iRemoteDeviceFactoryManager.mo8267a(str, z, abstractBinderC1844a);
                iRemoteDeviceFactoryManager.mo8266a(str, Tools.m8112a(this.f9752g, str), Tools.m8099b(this.f9752g, str));
                this.f9749d = new BluetoothInputStreamProxy(this.f9746a);
                this.f9750e = new BluetoothOutputStreamProxy(this.f9746a, DeviceFactoryManager.m8305a().f9916p);
                this.f9747b = null;
                this.f9748c = null;
            } catch (Exception e) {
                e.printStackTrace();
                RomoteLocalSwitch.m8086a().m8085a(false);
                this.f9746a = null;
                this.f9748c = null;
                this.f9749d = null;
                this.f9750e = null;
                this.f9747b = new BluetoothManagerImpl(context, z, str);
            }
        }
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("BluetoothManagerProxy", "finalize BluetoothManagerProxy");
            this.f9747b = null;
            this.f9748c = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m8450a(String str, String str2) {
        C1856n.m8127b("BluetoothManagerProxy", "auto Bluetooth Connect serialNo=" + str + "deviceAddress=" + str2);
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                if (bluetoothBLEManager.getState() == 3) {
                    this.f9748c.m8494a();
                    return;
                }
                BluetoothBLEManager bluetoothBLEManager2 = this.f9748c;
                C1856n.m8127b("BluetoothBLEManager", "auto Bluetooth Connect serialNo=" + str + "deviceAddress=" + str2);
                bluetoothBLEManager2.f9712g = true;
                bluetoothBLEManager2.f9715j = 3;
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        BluetoothDevice remoteDevice = bluetoothBLEManager2.f9713h.getRemoteDevice(str2);
                        if (remoteDevice != null) {
                            bluetoothBLEManager2.f9711f = remoteDevice;
                            bluetoothBLEManager2.m8480b();
                            return;
                        }
                        bluetoothBLEManager2.m8481a(false);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        return;
                    } else {
                        if (bluetoothBLEManager2.f9714i == null) {
                            bluetoothBLEManager2.f9714i = new BluetoothLeScannerManager(bluetoothBLEManager2.f9713h, new BluetoothBLEManager.C1815c(str));
                        }
                        bluetoothBLEManager2.f9714i.m8454a();
                        return;
                    }
                }
                bluetoothBLEManager2.m8481a(false);
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                if (this.f9746a.mo8431a() == 3) {
                    this.f9746a.mo8411j();
                } else {
                    this.f9746a.mo8428a(str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                if (bluetoothManagerImpl.getState() == 3) {
                    this.f9747b.m8435c();
                } else {
                    this.f9747b.m8438a(str, str2);
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m8452a() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.f9712g;
            }
            return false;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8414g();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return false;
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.f9764k;
            }
            return false;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.getState();
            }
            return 0;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                int mo8431a = this.f9746a.mo8431a();
                C1856n.m8127b("BluetoothManagerProxy", "current state is ".concat(String.valueOf(mo8431a)));
                return mo8431a;
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return 0;
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.getState();
            }
            return 0;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            return bluetoothBLEManager != null ? bluetoothBLEManager.getCommand() : "";
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8425b();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return "";
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            return bluetoothManagerImpl != null ? bluetoothManagerImpl.getCommand() : "";
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                if (this.f9750e == null) {
                    this.f9750e = bluetoothBLEManager.getOutputStream();
                }
                return this.f9750e;
            }
            return null;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            return this.f9750e;
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                if (this.f9750e == null) {
                    this.f9750e = new BluetoothOutputStreamProxy(bluetoothManagerImpl.getOutputStream(), DeviceFactoryManager.m8305a().f9916p);
                }
                return this.f9750e;
            }
            return null;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getCommand_wait() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.getCommand_wait();
            }
            return false;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8421c();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return false;
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.getCommand_wait();
            }
            return false;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand_wait(boolean z) {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.setCommand_wait(z);
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                this.f9746a.mo8427a(z);
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.setCommand_wait(z);
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9752g;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        C1856n.m8130a("BluetoothManagerProxy", "stop bluetooth ConnectThread");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.closeDevice();
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                this.f9746a.mo8417e();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.closeDevice();
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            return bluetoothBLEManager != null ? bluetoothBLEManager.getDeviceName() : "";
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8419d();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return "";
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            return bluetoothManagerImpl != null ? bluetoothManagerImpl.getDeviceName() : "";
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    @Deprecated
    public final void setCommand(String str) {
        BluetoothManagerImpl bluetoothManagerImpl;
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.setCommand(str);
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a || (bluetoothManagerImpl = this.f9747b) == null) {
        } else {
            bluetoothManagerImpl.setCommand(str);
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.getSerialNo();
            }
            return null;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8413h();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return null;
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.getSerialNo();
            }
            return null;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsTruckReset(boolean z) {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.setIsTruckReset(z);
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                this.f9746a.mo8423b(z);
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.setIsTruckReset(z);
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean isTruckReset() {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.isTruckReset();
            }
            return false;
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                return this.f9746a.mo8412i();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
                return false;
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.isTruckReset();
            }
            return false;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.setIsFix(z);
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                this.f9746a.mo8420c(z);
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.setIsFix(z);
            }
        }
    }

    /* renamed from: b */
    public final void m8448b() {
        RomoteLocalSwitch.m8086a().m8085a(false);
        Intent intent = new Intent("DPUDeviceConnectDisconnected");
        intent.putExtra("isFix", false);
        this.f9752g.sendBroadcast(intent);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        C1856n.m8130a("BluetoothManagerProxy", "physical close Device");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.physicalCloseDevice();
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                this.f9746a.mo8405p();
            } catch (Exception e) {
                e.printStackTrace();
                m8448b();
            }
        } else {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.physicalCloseDevice();
            }
        }
    }

    /* renamed from: c */
    private String m8446c() {
        BluetoothDevice bluetoothDevice;
        BluetoothManagerImpl bluetoothManagerImpl;
        BluetoothDevice m8436b;
        C1856n.m8130a("BluetoothManagerProxy", "get no remote mode Bluetooth Device address");
        if (!this.f9751f) {
            if (DeviceFactoryManager.m8305a().m8277f() || (bluetoothManagerImpl = this.f9747b) == null || (m8436b = bluetoothManagerImpl.m8436b()) == null) {
                return null;
            }
            return m8436b.getAddress();
        }
        BluetoothBLEManager bluetoothBLEManager = this.f9748c;
        if (bluetoothBLEManager == null || (bluetoothDevice = bluetoothBLEManager.f9711f) == null) {
            return null;
        }
        return bluetoothDevice.getAddress();
    }

    /* renamed from: a */
    public static String m8451a(Context context, String str) {
        C1856n.m8130a("BluetoothManagerProxy", "get Bluetooth Device address");
        if (!DeviceFactoryManager.m8305a().f9912l) {
            if (DeviceFactoryManager.m8305a().m8277f()) {
                IRemoteDeviceFactoryManagerCallBack.AbstractBinderC1844a abstractBinderC1844a = DeviceFactoryManager.m8305a().f9915o;
                IRemoteDeviceFactoryManager iRemoteDeviceFactoryManager = DeviceFactoryManager.m8305a().f9914n;
                try {
                    IRemoteBluetoothManager mo8267a = iRemoteDeviceFactoryManager.mo8267a(str, false, (IRemoteDeviceFactoryManagerCallBack) abstractBinderC1844a);
                    iRemoteDeviceFactoryManager.mo8266a(str, Tools.m8112a(context, str), Tools.m8099b(context, str));
                    return mo8267a.mo8404q();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            try {
                IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                BluetoothManager bluetoothManager = iPhysics instanceof BluetoothManager ? (BluetoothManager) iPhysics : null;
                if (bluetoothManager == null || !bluetoothManager.getSerialNo().equals(str)) {
                    return null;
                }
                return bluetoothManager.m8446c();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        try {
            IPhysics iPhysics2 = DeviceFactoryManager.m8305a().f9901a;
            BluetoothManager bluetoothManager2 = iPhysics2 instanceof BluetoothManager ? (BluetoothManager) iPhysics2 : null;
            if (bluetoothManager2 == null || !bluetoothManager2.getSerialNo().equals(str)) {
                return null;
            }
            return bluetoothManager2.m8446c();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final void m8449a(boolean z) {
        C1856n.m8130a("BluetoothManagerProxy", "setIsRemoteClientDiagnoseMode call");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.f9710e = z;
            }
        } else if (!RomoteLocalSwitch.m8086a().f10149a) {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.f9768o = z;
            }
        } else {
            try {
                this.f9746a.mo8418d(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        C1856n.m8130a("BluetoothManagerProxy", "getIsRemoteClientDiagnoseMode call");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.getIsRemoteClientDiagnoseMode();
            }
            return false;
        } else if (!RomoteLocalSwitch.m8086a().f10149a) {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.getIsRemoteClientDiagnoseMode();
            }
            return false;
        } else {
            try {
                return this.f9746a.mo8403r();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m8447b(boolean z) {
        C1856n.m8130a("BluetoothManagerProxy", "setIsSupportOneRequestMoreAnswerDiagnoseMode");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                bluetoothBLEManager.f9716k = z;
            }
        } else if (!RomoteLocalSwitch.m8086a().f10149a) {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                bluetoothManagerImpl.f9769p = z;
            }
        } else {
            try {
                this.f9746a.mo8416e(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        C1856n.m8130a("BluetoothManagerProxy", "getIsSupportOneRequestMoreAnswerDiagnoseMode call");
        if (this.f9751f) {
            BluetoothBLEManager bluetoothBLEManager = this.f9748c;
            if (bluetoothBLEManager != null) {
                return bluetoothBLEManager.getIsSupportOneRequestMoreAnswerDiagnoseMode();
            }
            return false;
        } else if (!RomoteLocalSwitch.m8086a().f10149a) {
            BluetoothManagerImpl bluetoothManagerImpl = this.f9747b;
            if (bluetoothManagerImpl != null) {
                return bluetoothManagerImpl.getIsSupportOneRequestMoreAnswerDiagnoseMode();
            }
            return false;
        } else {
            try {
                return this.f9746a.mo8402s();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IAssitsPhysics
    public final IAssitsPhysicsMatcher getAssitsPhysicsMatcher() {
        return this.f9753h;
    }
}
