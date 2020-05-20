package com.cnlaunch.physics.p198d;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: DPUEthernetManager.java */
/* renamed from: com.cnlaunch.physics.d.b */
/* loaded from: classes.dex */
final class HandlerC1834b extends Handler {

    /* renamed from: a */
    final /* synthetic */ DPUEthernetManager f9893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1834b(DPUEthernetManager dPUEthernetManager, Looper looper) {
        super(looper);
        this.f9893a = dPUEthernetManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Intent intent = new Intent("DPUDeviceConnectSuccess");
        intent.putExtra("isFix", this.f9893a.f9878f);
        intent.putExtra(MessageDao.TABLENAME, this.f9893a.f9873a.getString(C1411a.C1412a.msg_ethernet_connect_state_success));
        this.f9893a.f9873a.sendBroadcast(intent);
        DPUEthernetManager dPUEthernetManager = this.f9893a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction(dPUEthernetManager.f9880h);
        dPUEthernetManager.f9873a.registerReceiver(dPUEthernetManager.f9884l, intentFilter);
        C1856n.m8127b("DPUEthernetManager", "ethernet connected success,starting transfer data ");
        this.f9893a.f9873a.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
    }
}
