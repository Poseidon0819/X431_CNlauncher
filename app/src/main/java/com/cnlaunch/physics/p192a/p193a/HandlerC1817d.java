package com.cnlaunch.physics.p192a.p193a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.p205k.C1856n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothBLEManager.java */
/* renamed from: com.cnlaunch.physics.a.a.d */
/* loaded from: classes.dex */
public final class HandlerC1817d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BluetoothBLEManager f9739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1817d(BluetoothBLEManager bluetoothBLEManager, Looper looper) {
        super(looper);
        this.f9739a = bluetoothBLEManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z;
        BluetoothDevice bluetoothDevice;
        String str;
        BluetoothDevice bluetoothDevice2;
        BluetoothDevice bluetoothDevice3;
        boolean z2;
        BluetoothDevice bluetoothDevice4;
        String str2;
        BluetoothDevice bluetoothDevice5;
        if (message2.what == 0) {
            BluetoothBLEManager bluetoothBLEManager = this.f9739a;
            Context context = bluetoothBLEManager.f9717m;
            String string = this.f9739a.f9717m.getString(C1411a.C1412a.bluetooth_connected);
            bluetoothDevice3 = this.f9739a.f9711f;
            bluetoothBLEManager.m8489a(context, "action.bt.device.con.success", 130, string, bluetoothDevice3, 0);
            Intent intent = new Intent("DPUDeviceConnectSuccess");
            z2 = this.f9739a.f9721q;
            intent.putExtra("isFix", z2);
            bluetoothDevice4 = this.f9739a.f9711f;
            if (bluetoothDevice4 != null) {
                bluetoothDevice5 = this.f9739a.f9711f;
                str2 = bluetoothDevice5.getName();
            } else {
                str2 = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            intent.putExtra("deviceName", str2);
            intent.putExtra(MessageDao.TABLENAME, this.f9739a.f9717m.getString(C1411a.C1412a.msg_serialport_connect_state_success));
            this.f9739a.f9717m.sendBroadcast(intent);
            C1856n.m8127b("BluetoothBLEManager", "ble connected success,starting transfer data ");
            this.f9739a.f9717m.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
        } else if (message2.what == 1) {
            Intent intent2 = new Intent("DPUDeviceConnectDisconnected");
            z = this.f9739a.f9721q;
            intent2.putExtra("isFix", z);
            bluetoothDevice = this.f9739a.f9711f;
            if (bluetoothDevice != null) {
                bluetoothDevice2 = this.f9739a.f9711f;
                str = bluetoothDevice2.getName();
            } else {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            intent2.putExtra("deviceName", str);
            this.f9739a.f9717m.sendBroadcast(intent2);
        } else if (message2.what == 2) {
            BluetoothBLEManager.m8474d(this.f9739a);
        }
    }
}
