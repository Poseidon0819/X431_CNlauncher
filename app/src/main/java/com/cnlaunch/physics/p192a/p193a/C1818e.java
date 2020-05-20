package com.cnlaunch.physics.p192a.p193a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.cnlaunch.physics.p192a.p193a.BluetoothBLEManager;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothBLEManager.java */
/* renamed from: com.cnlaunch.physics.a.a.e */
/* loaded from: classes.dex */
public final class C1818e extends BluetoothGattCallback {

    /* renamed from: a */
    final /* synthetic */ BluetoothBLEManager f9740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1818e(BluetoothBLEManager bluetoothBLEManager) {
        this.f9740a = bluetoothBLEManager;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onConnectionStateChange : " + i + "  newState : " + i2);
        }
        if (i2 == 2) {
            bluetoothGatt.requestMtu(512);
        } else if (i2 == 0 && this.f9740a.getState() == 2) {
            BluetoothBLEManager.m8473e();
            this.f9740a.m8475d();
            this.f9740a.f9719o = 0;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onMtuChanged MTU: " + i + "status: " + i2);
        }
        if (i2 == 0) {
            this.f9740a.f9727x = i - 3;
        } else {
            this.f9740a.f9727x = 20;
        }
        BluetoothBLEManager.f9700a.discoverServices();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        ReadByteDataStream readByteDataStream;
        BluetoothBLEManager.C1816d c1816d;
        Handler handler;
        for (BluetoothGattService bluetoothGattService : BluetoothBLEManager.f9700a.getServices()) {
            if (C1856n.f10135a) {
                C1856n.m8130a("BluetoothBLEManager", "BluetoothGattService Uuid=" + bluetoothGattService.getUuid().toString());
            }
        }
        this.f9740a.m8492a(bluetoothGatt);
        if (C1856n.f10135a) {
            C1856n.m8125d("BluetoothBLEManager", "ble连接成功开启读取数据的线程 ");
        }
        BluetoothBLEManager bluetoothBLEManager = this.f9740a;
        bluetoothBLEManager.f9718n = new ReadByteDataStream(bluetoothBLEManager, bluetoothBLEManager.f9709d, this.f9740a.getOutputStream());
        readByteDataStream = this.f9740a.f9718n;
        new Thread(readByteDataStream).start();
        BluetoothBLEManager bluetoothBLEManager2 = this.f9740a;
        bluetoothBLEManager2.f9728y = new BluetoothBLEManager.C1816d();
        c1816d = this.f9740a.f9728y;
        c1816d.start();
        this.f9740a.f9719o = 3;
        handler = this.f9740a.f9705C;
        handler.sendEmptyMessageDelayed(0, 1000L);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothBLEManager.C1813a c1813a;
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onCharacteristicChanged uuid=" + bluetoothGattCharacteristic.getUuid().toString());
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value != null) {
            if (C1856n.f10135a) {
                C1856n.m8130a("BluetoothBLEManager", "onCharacteristicChanged characteristicData=" + ByteHexHelper.m8173b(value));
            }
            c1813a = this.f9740a.f9707b;
            c1813a.mo8192a(value, 0, value.length);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onCharacteristicRead status=".concat(String.valueOf(i)));
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onDescriptorWrite");
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onCharacteristicWrite status =".concat(String.valueOf(i)));
        }
        if (i != 0 && C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "onCharacteristicWrite Send failed!");
        }
        BluetoothBLEManager.C1814b c1814b = this.f9740a.f9708c;
        c1814b.f9733a.lock();
        try {
            c1814b.f9734b.signal();
        } finally {
            c1814b.f9733a.unlock();
        }
    }
}
