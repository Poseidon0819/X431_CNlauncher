package com.cnlaunch.physics.p192a.p193a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteBufferStream;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.physics.a.a.c */
/* loaded from: classes.dex */
public final class BluetoothBLEManager implements IPhysics {

    /* renamed from: a */
    public static BluetoothGatt f9700a = null;

    /* renamed from: l */
    private static String f9701l = "";

    /* renamed from: w */
    private static String f9702w = "00002902-0000-1000-8000-00805f9b34fb";

    /* renamed from: B */
    private boolean f9704B;

    /* renamed from: b */
    C1813a f9707b;

    /* renamed from: c */
    C1814b f9708c;

    /* renamed from: d */
    BluetoothBLEInputStream f9709d;

    /* renamed from: e */
    public boolean f9710e;

    /* renamed from: f */
    public BluetoothDevice f9711f;

    /* renamed from: g */
    public boolean f9712g;

    /* renamed from: i */
    public BluetoothLeScannerManager f9714i;

    /* renamed from: j */
    public int f9715j;

    /* renamed from: k */
    public boolean f9716k;

    /* renamed from: m */
    private Context f9717m;

    /* renamed from: o */
    private int f9719o;

    /* renamed from: q */
    private boolean f9721q;

    /* renamed from: r */
    private DeviceFactoryManager f9722r;

    /* renamed from: s */
    private String f9723s;

    /* renamed from: t */
    private boolean f9724t;

    /* renamed from: u */
    private BluetoothGattCharacteristic f9725u;

    /* renamed from: v */
    private String f9726v;

    /* renamed from: x */
    private int f9727x;

    /* renamed from: y */
    private C1816d f9728y;

    /* renamed from: z */
    private BluetoothBLEOutputStream f9729z;

    /* renamed from: p */
    private boolean f9720p = true;

    /* renamed from: A */
    private boolean f9703A = true;

    /* renamed from: C */
    private Handler f9705C = new HandlerC1817d(this, Looper.getMainLooper());

    /* renamed from: D */
    private final BluetoothGattCallback f9706D = new C1818e(this);

    /* renamed from: n */
    private ReadByteDataStream f9718n = null;

    /* renamed from: h */
    public BluetoothAdapter f9713h = BluetoothAdapter.getDefaultAdapter();

    public BluetoothBLEManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.f9726v = "0000fff0-0000-1000-8000-00805f9b34fb";
        this.f9717m = context.getApplicationContext();
        this.f9721q = z;
        this.f9722r = deviceFactoryManager;
        if (!this.f9713h.isEnabled()) {
            this.f9713h.enable();
        }
        this.f9719o = 0;
        this.f9723s = str;
        this.f9724t = false;
        f9700a = null;
        if (!TextUtils.isEmpty(deviceFactoryManager.f9913m)) {
            this.f9726v = deviceFactoryManager.f9913m;
        }
        this.f9727x = 20;
        this.f9707b = new C1813a();
        this.f9708c = new C1814b();
        this.f9728y = null;
        this.f9709d = new BluetoothBLEInputStream(this);
        this.f9729z = new BluetoothBLEOutputStream(this, deviceFactoryManager.f9916p);
        this.f9712g = false;
        this.f9715j = 3;
        this.f9714i = null;
        this.f9710e = false;
        this.f9716k = false;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("BluetoothBLEManager", "finalize BluetoothBLEManager");
            this.f9705C = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        return f9701l;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        f9701l = str;
        if (this.f9703A) {
            this.f9722r.m8298a(str);
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        return this.f9729z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        return this.f9719o;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f9720p;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f9720p = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9717m;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        if (this.f9711f != null) {
            C1856n.m8130a("BluetoothBLEManager", "ble remoteDevice is not null.");
            String name = this.f9711f.getName();
            return name == null ? "" : name;
        }
        return "";
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        ReadByteDataStream readByteDataStream = this.f9718n;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f9717m.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_UNCONNECTED"));
            this.f9718n = null;
        }
        C1816d c1816d = this.f9728y;
        if (c1816d != null) {
            c1816d.m8455a();
            this.f9728y = null;
        }
        this.f9707b.m8459a();
        this.f9708c.m8457a();
        BluetoothGatt bluetoothGatt = f9700a;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
        m8473e();
        this.f9719o = 0;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f9723s;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f9724t = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f9724t;
    }

    /* renamed from: a */
    public final void m8494a() {
        Handler handler = this.f9705C;
        if (handler != null) {
            this.f9705C.sendMessage(handler.obtainMessage(0, 0, 0));
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f9721q = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f9710e;
    }

    /* compiled from: BluetoothBLEManager.java */
    /* renamed from: com.cnlaunch.physics.a.a.c$c */
    /* loaded from: classes.dex */
    public class C1815c implements BluetoothLeScannerManager.InterfaceC1819a {

        /* renamed from: b */
        private String f9737b;

        public C1815c(String str) {
            this.f9737b = str;
        }

        @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
        /* renamed from: a */
        public final void mo8391a() {
            C1856n.m8125d("BluetoothBLEManager", "BLE_SCAN_STARTED");
        }

        @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
        /* renamed from: b */
        public final void mo8388b() {
            C1856n.m8125d("BluetoothBLEManager", "BLE_SCAN_FINISHED");
        }

        @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
        /* renamed from: a */
        public final void mo8389a(BluetoothDevice bluetoothDevice) {
            C1856n.m8130a("BluetoothBLEManager", "onScanResult =bluetoothDevice " + bluetoothDevice.getName());
            if (bluetoothDevice == null || !BluetoothBLEManager.m8493a(bluetoothDevice, this.f9737b)) {
                return;
            }
            C1856n.m8125d("BluetoothBLEManager", "match Devices name=" + bluetoothDevice.getName() + " address=" + bluetoothDevice.getAddress());
            PreferencesManager.m9595a(BluetoothBLEManager.this.f9717m).m9588a("bluetooth_name", bluetoothDevice.getName());
            PreferencesManager.m9595a(BluetoothBLEManager.this.f9717m).m9588a("bluetooth_address", bluetoothDevice.getAddress());
            if (BluetoothBLEManager.this.f9714i != null) {
                BluetoothBLEManager.this.f9714i.m8453b();
            }
            BluetoothBLEManager.this.f9711f = bluetoothDevice;
            BluetoothBLEManager.this.m8480b();
        }

        @Override // com.cnlaunch.physics.p192a.p193a.BluetoothLeScannerManager.InterfaceC1819a
        /* renamed from: a */
        public final void mo8390a(int i) {
            C1856n.m8130a("BluetoothBLEManager", "BLE_SCAN_FINISHED WITH ERROR=".concat(String.valueOf(i)));
            BluetoothBLEManager.this.m8481a(false);
        }
    }

    /* renamed from: b */
    public final void m8480b() {
        ReadByteDataStream readByteDataStream = this.f9718n;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f9718n = null;
        }
        C1816d c1816d = this.f9728y;
        if (c1816d != null) {
            c1816d.m8455a();
            this.f9728y = null;
        }
        this.f9707b.m8459a();
        this.f9708c.m8457a();
        Context context = this.f9717m;
        m8489a(context, "action.bt.device.con.coning", Opcodes.ISHL, context.getString(C1411a.C1412a.bluetooth_connecting), this.f9711f, this.f9715j);
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "start create a new connection.  ");
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f9700a = this.f9711f.connectGatt(this.f9717m, false, this.f9706D, 2);
        } else {
            m8471f();
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "Trying to create a new connection. Gatt: " + f9700a);
        }
        if (f9700a == null) {
            m8475d();
        } else {
            this.f9719o = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8475d() {
        Context context = this.f9717m;
        m8489a(context, "action.bt.device.con.fail", 140, context.getString(C1411a.C1412a.bluetooth_connect_fail), this.f9711f, this.f9715j);
        if (this.f9715j != 1) {
            this.f9705C.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        m8481a(true);
        this.f9719o = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m8473e() {
        BluetoothGatt bluetoothGatt = f9700a;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            f9700a = null;
        }
    }

    /* renamed from: a */
    public final void m8492a(BluetoothGatt bluetoothGatt) {
        if (!this.f9726v.toUpperCase(Locale.ENGLISH).equals(BLEDeviceConfig.f9696a)) {
            m8490a(bluetoothGatt, this.f9726v, "", "");
        } else {
            m8490a(bluetoothGatt, BLEDeviceConfig.f9696a, BLEDeviceConfig.f9697b, BLEDeviceConfig.f9698c);
        }
    }

    /* renamed from: a */
    private void m8490a(BluetoothGatt bluetoothGatt, String str, String str2, String str3) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
        if (service == null) {
            C1856n.m8130a("BluetoothBLEManager", "service not found");
            return;
        }
        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
        C1856n.m8130a("BluetoothBLEManager", "gattCharacteristics size=" + characteristics.size());
        for (int i = 0; i < characteristics.size(); i++) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristics.get(i);
            C1856n.m8130a("BluetoothBLEManager", "char Uuid is " + bluetoothGattCharacteristic.getUuid().toString() + "chara.getProperties() = " + bluetoothGattCharacteristic.getProperties());
            if (((bluetoothGattCharacteristic.getProperties() & 8) == 8 || (bluetoothGattCharacteristic.getProperties() & 4) == 4) && (TextUtils.isEmpty(str3) || bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(str3)))) {
                C1856n.m8130a("BluetoothBLEManager", "Wr char is " + bluetoothGattCharacteristic.getUuid().toString());
                this.f9725u = bluetoothGattCharacteristic;
                if (BLEDeviceConfig.f9696a.equals(this.f9726v)) {
                    this.f9725u.setWriteType(2);
                } else {
                    this.f9725u.setWriteType(1);
                }
            }
            if ((bluetoothGattCharacteristic.getProperties() & 16) == 16 && (TextUtils.isEmpty(str2) || bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(str2)))) {
                C1856n.m8130a("BluetoothBLEManager", "NotiChar UUID is : " + bluetoothGattCharacteristic.getUuid().toString());
                m8491a(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }
    }

    /* renamed from: a */
    private static boolean m8491a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt == null) {
            C1856n.m8130a("BluetoothBLEManager", "BluetoothAdapter not initialized");
            return false;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        try {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(f9702w));
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                return bluetoothGatt.writeDescriptor(descriptor);
            }
            C1856n.m8130a("BluetoothBLEManager", "descriptor is null");
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8489a(Context context, String str, int i, String str2, BluetoothDevice bluetoothDevice, int i2) {
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, i);
        bundle.putString("status", str2);
        bundle.putInt("pair", 12);
        if (str.equalsIgnoreCase("action.bt.device.con.coning")) {
            bundle.putInt("auto_reconnect_count", (3 - i2) + 1);
        }
        bundle.putParcelable("bluetoothDevice", bluetoothDevice);
        intent.putExtra("customBluetoothBroadcastIntentExtraBundle", bundle);
        intent.putExtra("isFix", this.f9721q);
        context.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BluetoothBLEManager.java */
    /* renamed from: com.cnlaunch.physics.a.a.c$a */
    /* loaded from: classes.dex */
    public class C1813a extends ByteBufferStream {

        /* renamed from: b */
        private final Lock f9731b = new ReentrantLock();

        /* renamed from: c */
        private final Condition f9732c = this.f9731b.newCondition();

        public C1813a() {
        }

        /* renamed from: a */
        public final void m8459a() {
            this.f9731b.lock();
            try {
                this.f9732c.signal();
            } finally {
                this.f9731b.unlock();
            }
        }

        @Override // com.cnlaunch.physics.p205k.ByteBufferStream
        /* renamed from: a */
        public final void mo8192a(byte[] bArr, int i, int i2) {
            this.f9731b.lock();
            try {
                super.mo8192a(bArr, i, i2);
                this.f9732c.signal();
            } finally {
                this.f9731b.unlock();
            }
        }

        /* renamed from: b */
        public final int m8458b(byte[] bArr, int i, int i2) {
            int i3;
            this.f9731b.lock();
            try {
                if (this.f10094f <= 0) {
                    this.f9732c.await();
                }
                i3 = super.m8188c(bArr, i, i2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                i3 = 0;
            }
            this.f9731b.unlock();
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BluetoothBLEManager.java */
    /* renamed from: com.cnlaunch.physics.a.a.c$b */
    /* loaded from: classes.dex */
    public class C1814b extends ByteBufferStream {

        /* renamed from: a */
        final Lock f9733a = new ReentrantLock();

        /* renamed from: b */
        final Condition f9734b = this.f9733a.newCondition();

        public C1814b() {
        }

        /* renamed from: a */
        public final void m8457a() {
            this.f9733a.lock();
            try {
                this.f9734b.signal();
            } finally {
                this.f9733a.unlock();
            }
        }

        @Override // com.cnlaunch.physics.p205k.ByteBufferStream
        /* renamed from: a */
        public final void mo8192a(byte[] bArr, int i, int i2) {
            synchronized (this) {
                super.mo8192a(bArr, i, i2);
            }
        }

        /* renamed from: a */
        public final int m8456a(byte[] bArr) {
            int m8189b;
            boolean writeCharacteristic;
            boolean writeCharacteristic2;
            this.f9733a.lock();
            int i = 0;
            try {
                synchronized (this) {
                    m8189b = super.m8189b(bArr);
                }
                if (m8189b > 0) {
                    if (m8189b == bArr.length) {
                        do {
                            BluetoothBLEManager.this.f9725u.setValue(bArr);
                            writeCharacteristic2 = (BluetoothBLEManager.this.f9704B || BluetoothBLEManager.f9700a == null) ? true : BluetoothBLEManager.f9700a.writeCharacteristic(BluetoothBLEManager.this.f9725u);
                            if (C1856n.f10135a && !writeCharacteristic2) {
                                C1856n.m8130a("BleSendDataByteBufferStream", "写数据失败 ");
                                continue;
                            }
                        } while (!writeCharacteristic2);
                    } else {
                        byte[] bArr2 = new byte[m8189b];
                        System.arraycopy(bArr, 0, bArr2, 0, m8189b);
                        do {
                            BluetoothBLEManager.this.f9725u.setValue(bArr2);
                            writeCharacteristic = (BluetoothBLEManager.this.f9704B || BluetoothBLEManager.f9700a == null) ? true : BluetoothBLEManager.f9700a.writeCharacteristic(BluetoothBLEManager.this.f9725u);
                            if (C1856n.f10135a && !writeCharacteristic) {
                                C1856n.m8130a("BleSendDataByteBufferStream", "写数据失败 in flush");
                                continue;
                            }
                        } while (!writeCharacteristic);
                    }
                    this.f9734b.await();
                    if (C1856n.f10135a) {
                        C1856n.m8130a("BleSendDataByteBufferStream", "mSendDataCondition.await signal");
                    }
                }
                i = m8189b;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f9733a.unlock();
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BluetoothBLEManager.java */
    /* renamed from: com.cnlaunch.physics.a.a.c$d */
    /* loaded from: classes.dex */
    public class C1816d extends Thread {
        public C1816d() {
            BluetoothBLEManager.this.f9704B = false;
        }

        /* renamed from: a */
        public final void m8455a() {
            BluetoothBLEManager.this.f9704B = true;
            BluetoothBLEManager.this.f9708c.m8457a();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr = new byte[BluetoothBLEManager.this.f9727x];
            while (!BluetoothBLEManager.this.f9704B) {
                if (BluetoothBLEManager.this.f9708c.m8456a(bArr) == 0) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f9716k;
    }

    /* renamed from: f */
    private void m8471f() {
        try {
            try {
                f9700a = (BluetoothGatt) this.f9711f.getClass().getDeclaredMethod("connectGatt", Context.class, Boolean.TYPE, BluetoothGattCallback.class, Integer.TYPE).invoke(this.f9711f, this.f9717m, Boolean.FALSE, this.f9706D, 2);
                if (f9700a != null) {
                    return;
                }
            } catch (Exception e) {
                C1856n.m8127b("BluetoothBLEManager", e.toString());
                if (f9700a != null) {
                    return;
                }
            }
            f9700a = this.f9711f.connectGatt(this.f9717m, false, this.f9706D);
        } catch (Throwable th) {
            if (f9700a == null) {
                f9700a = this.f9711f.connectGatt(this.f9717m, false, this.f9706D);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final void m8481a(boolean z) {
        this.f9719o = 0;
        Context context = this.f9717m;
        m8489a(context, "action.bt.device.con.fail", 140, context.getString(C1411a.C1412a.bluetooth_connect_fail), this.f9711f, this.f9715j);
        Intent intent = new Intent("DPUDeviceConnectFail");
        intent.putExtra("is_connect_fail", z);
        intent.putExtra("isFix", this.f9721q);
        intent.putExtra(MessageDao.TABLENAME, this.f9717m.getString(C1411a.C1412a.bluetooth_connect_fail));
        BluetoothDevice bluetoothDevice = this.f9711f;
        if (bluetoothDevice != null) {
            intent.putExtra("deviceName", bluetoothDevice.getName());
        }
        this.f9717m.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m8474d(BluetoothBLEManager bluetoothBLEManager) {
        C1856n.m8127b("BluetoothBLEManager", "开始重新连接 剩余次数: " + (bluetoothBLEManager.f9715j - 1));
        if (bluetoothBLEManager.f9711f == null || bluetoothBLEManager.f9715j <= 1) {
            return;
        }
        C1856n.m8127b("BluetoothBLEManager", "ReConnect TimerTask Start");
        bluetoothBLEManager.f9715j--;
        bluetoothBLEManager.m8480b();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m8493a(BluetoothDevice bluetoothDevice, String str) {
        String name = bluetoothDevice.getName();
        return name != null && name.equalsIgnoreCase(str);
    }
}
