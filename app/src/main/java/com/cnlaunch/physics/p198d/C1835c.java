package com.cnlaunch.physics.p198d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: DPUEthernetManager.java */
/* renamed from: com.cnlaunch.physics.d.c */
/* loaded from: classes.dex */
final class C1835c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DPUEthernetManager f9894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1835c(DPUEthernetManager dPUEthernetManager) {
        this.f9894a = dPUEthernetManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
            C1856n.m8130a("DPUEthernetManager", "ACTION_USB_DEVICE_ATTACHED");
        } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
            C1856n.m8130a("DPUEthernetManager", "ACTION_USB_DEVICE_DETACHED");
            if (DeviceFactoryManager.m8303a(this.f9894a.f9873a, intent)) {
                this.f9894a.f9873a.sendBroadcast(new Intent("DPUDeviceConnectDisconnected"));
            }
        } else if (this.f9894a.f9880h.equals(action)) {
            C1856n.m8130a("DPUEthernetManager", "Permisson REQUEST");
        }
    }
}
