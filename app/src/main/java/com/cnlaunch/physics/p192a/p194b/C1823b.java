package com.cnlaunch.physics.p192a.p194b;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: BluetoothManagerImpl.java */
/* renamed from: com.cnlaunch.physics.a.b.b */
/* loaded from: classes.dex */
final class C1823b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ BluetoothManagerImpl f9783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1823b(BluetoothManagerImpl bluetoothManagerImpl) {
        this.f9783a = bluetoothManagerImpl;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C1856n.m8130a("BluetoothManagerImpl", "BluetoothManager  Receiver action".concat(String.valueOf(action)));
        if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action) || "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action) || "DPUDeviceConnectSuccess".equals(action) || "DPUDeviceConnectFail".equals(action) || !action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        String address = this.f9783a.f9759f != null ? this.f9783a.f9759f.getAddress() : "";
        int i = Build.VERSION.SDK_INT;
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothConnectReceive", "Build.VERSION.SDK_INT = ".concat(String.valueOf(i)));
        }
        if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(address)) {
            if (C1856n.f10135a) {
                C1856n.m8130a("BluetoothConnectReceive", "not pair cnlaunch device " + bluetoothDevice.getAddress() + "  " + address);
            }
        } else if (i < 23) {
            if (Build.VERSION.SDK_INT <= 15) {
                try {
                    PairUtils.m8400a(bluetoothDevice.getClass(), bluetoothDevice, "0000");
                    PairUtils.m8401a(bluetoothDevice.getClass(), bluetoothDevice);
                    ((Boolean) BluetoothDevice.class.getMethod("cancelPairingUserInput", new Class[0]).invoke(BluetoothDevice.class.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                PairUtils.m8400a(bluetoothDevice.getClass(), bluetoothDevice, "0000");
                C1856n.m8130a("PairUtils", "Success to add the PIN.");
                try {
                    bluetoothDevice.getClass().getMethod("setPairingConfirmation", Boolean.TYPE).invoke(bluetoothDevice, Boolean.TRUE);
                    C1856n.m8130a("PairUtils", "Success to setPairingConfirmation.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
