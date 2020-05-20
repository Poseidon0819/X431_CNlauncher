package com.cnlaunch.x431pro.activity.bluetooth;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.physics.p192a.BluetoothScanManager;
import com.cnlaunch.physics.p201g.OnBluetoothListener;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* compiled from: BluetoothActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.b */
/* loaded from: classes.dex */
final class C1992b implements OnBluetoothListener {

    /* renamed from: a */
    final /* synthetic */ BluetoothActivity f10937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1992b(BluetoothActivity bluetoothActivity) {
        this.f10937a = bluetoothActivity;
    }

    @Override // com.cnlaunch.physics.p201g.OnBluetoothListener
    /* renamed from: a */
    public final void mo7748a(int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (i != 180) {
            handler3 = this.f10937a.f10908v;
            Message obtainMessage = handler3.obtainMessage(110, Integer.valueOf(i));
            handler4 = this.f10937a.f10908v;
            handler4.sendMessage(obtainMessage);
            return;
        }
        handler = this.f10937a.f10908v;
        Message obtainMessage2 = handler.obtainMessage(Opcodes.GETFIELD, Integer.valueOf(i));
        handler2 = this.f10937a.f10908v;
        handler2.sendMessage(obtainMessage2);
    }

    @Override // com.cnlaunch.physics.p201g.OnBluetoothListener
    /* renamed from: a */
    public final void mo7749a() {
        BluetoothScanManager bluetoothScanManager;
        BluetoothScanManager bluetoothScanManager2;
        bluetoothScanManager = this.f10937a.f10897k;
        if (bluetoothScanManager != null) {
            bluetoothScanManager2 = this.f10937a.f10897k;
            bluetoothScanManager2.m8399a();
        }
        this.f10937a.f10905s = false;
        this.f10937a.setResult(-1);
        this.f10937a.finish();
    }

    @Override // com.cnlaunch.physics.p201g.OnBluetoothListener
    /* renamed from: c */
    public final void mo7746c() {
        Handler handler;
        handler = this.f10937a.f10908v;
        handler.sendEmptyMessage(Opcodes.TABLESWITCH);
    }

    @Override // com.cnlaunch.physics.p201g.OnBluetoothListener
    /* renamed from: b */
    public final void mo7747b() {
        Handler handler;
        handler = this.f10937a.f10908v;
        handler.sendEmptyMessage(160);
    }
}
