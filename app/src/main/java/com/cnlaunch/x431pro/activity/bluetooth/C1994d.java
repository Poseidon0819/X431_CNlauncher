package com.cnlaunch.x431pro.activity.bluetooth;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p197c.BluetoothListDto;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.d */
/* loaded from: classes.dex */
public final class C1994d extends Thread {

    /* renamed from: a */
    final /* synthetic */ BluetoothListDto f10939a;

    /* renamed from: b */
    final /* synthetic */ int f10940b = 1;

    /* renamed from: c */
    final /* synthetic */ BluetoothActivity f10941c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1994d(BluetoothActivity bluetoothActivity, BluetoothListDto bluetoothListDto) {
        this.f10941c = bluetoothActivity;
        this.f10939a = bluetoothListDto;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothActivity", "device Connected Check");
        }
        if (C2778n.m4914a(DeviceFactoryManager.m8305a().f9901a, this.f10939a.f9849f.getName(), PathUtils.m4858c())) {
            handler3 = this.f10941c.f10908v;
            Message obtainMessage = handler3.obtainMessage(20502, 1, this.f10940b, this.f10939a);
            handler4 = this.f10941c.f10908v;
            handler4.sendMessage(obtainMessage);
            return;
        }
        handler = this.f10941c.f10908v;
        Message obtainMessage2 = handler.obtainMessage(20502, 0, this.f10940b, this.f10939a);
        handler2 = this.f10941c.f10908v;
        handler2.sendMessage(obtainMessage2);
    }
}
