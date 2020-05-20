package com.cnlaunch.physics.p192a.p194b;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: BluetoothManagerImpl.java */
/* renamed from: com.cnlaunch.physics.a.b.d */
/* loaded from: classes.dex */
final class HandlerC1825d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BluetoothManagerImpl f9785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1825d(BluetoothManagerImpl bluetoothManagerImpl, Looper looper) {
        super(looper);
        this.f9785a = bluetoothManagerImpl;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z = false;
        if (message2.what != 0) {
            if (message2.what == 2) {
                BluetoothManagerImpl bluetoothManagerImpl = this.f9785a;
                C1856n.m8127b("BluetoothManagerImpl", "开始重新连接 剩余次数: " + (bluetoothManagerImpl.f9757d - 1));
                if (bluetoothManagerImpl.m8436b() != null) {
                    if (bluetoothManagerImpl.f9756c && bluetoothManagerImpl.f9757d - 1 > 0) {
                        z = true;
                    }
                    if (z) {
                        C1856n.m8127b("BluetoothManagerImpl", "ReConnect TimerTask Start");
                        bluetoothManagerImpl.f9757d--;
                        bluetoothManagerImpl.m8445a();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int i = message2.arg1;
        String name = this.f9785a.f9759f != null ? this.f9785a.f9759f.getName() : "";
        if (name == null) {
            name = "";
        }
        if (i == 0) {
            BluetoothManagerImpl bluetoothManagerImpl2 = this.f9785a;
            bluetoothManagerImpl2.m8441a(bluetoothManagerImpl2.f9760g, "action.bt.device.con.success", 130, this.f9785a.f9760g.getString(C1411a.C1412a.bluetooth_connected), this.f9785a.f9759f, this.f9785a.f9757d);
            Intent intent = new Intent("DPUDeviceConnectSuccess");
            intent.putExtra("deviceName", name);
            intent.putExtra("isFix", this.f9785a.f9766m);
            intent.putExtra(MessageDao.TABLENAME, this.f9785a.f9760g.getString(C1411a.C1412a.bluetooth_connect_success));
            this.f9785a.f9760g.sendBroadcast(intent);
        } else {
            Intent intent2 = new Intent("DPUDeviceConnectSuccessBackground");
            intent2.putExtra("deviceName", name);
            intent2.putExtra("isFix", this.f9785a.f9766m);
            intent2.putExtra(MessageDao.TABLENAME, this.f9785a.f9760g.getString(C1411a.C1412a.bluetooth_connect_success));
            this.f9785a.f9760g.sendBroadcast(intent2);
        }
        C1856n.m8127b("BluetoothManagerImpl", "Bluetooth connected success,starting transfer data ");
        Toast.makeText(this.f9785a.f9760g, this.f9785a.f9760g.getString(C1411a.C1412a.bluetooth_connect_success) + ":" + name, 0).show();
        C1856n.m8125d("BluetoothManagerImpl", "BluetoothManager  Receiver 蓝牙连接成功");
        BluetoothManagerImpl.m8442a(this.f9785a.f9760g, "com.cnlaunch.intent.action.DIAG_CONNECTED");
    }
}
