package com.cnlaunch.physics.p204j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.cnlaunch.physics.p205k.C1856n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DPUUSBManager.java */
/* renamed from: com.cnlaunch.physics.j.c */
/* loaded from: classes.dex */
public final class C1849c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DPUUSBManager f9992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1849c(DPUUSBManager dPUUSBManager) {
        this.f9992a = dPUUSBManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        char c = 0;
        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
            C1856n.m8130a("DPUUSBManager", "ACTION_USB_DEVICE_ATTACHED");
            if ((this.f9992a.f9982f.f9904d || this.f9992a.f9982f.f9902b) && this.f9992a.m8236a(intent)) {
                DPUUSBManager dPUUSBManager = this.f9992a;
                C1856n.m8130a("DPUUSBManager", "connect before status=" + dPUUSBManager.f9977a.m8246a());
                this.f9992a.m8238a(-7 != dPUUSBManager.f9977a.m8246a() ? dPUUSBManager.f9977a.m8243b(intent) : -7, false);
            }
        } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
            C1856n.m8130a("DPUUSBManager", "ACTION_USB_DEVICE_DETACHED");
            if (this.f9992a.m8236a(intent)) {
                C1856n.m8130a("DPUUSBManager", "DEVICE_DETACHED before status=" + this.f9992a.f9977a.m8246a());
                DPUUSBDevice dPUUSBDevice = this.f9992a.f9977a;
                if (dPUUSBDevice.f9974a == null) {
                    c = 65532;
                } else {
                    DPUUsbDriver dPUUsbDriver = dPUUSBDevice.f9974a;
                    if (intent == null) {
                        c = 65520;
                    } else if (-1 == dPUUsbDriver.f10000h || -1 == dPUUsbDriver.f9999g) {
                        c = 65524;
                    } else {
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                        if (usbDevice != null && dPUUsbDriver.f10000h == usbDevice.getVendorId() && dPUUsbDriver.f9999g == usbDevice.getProductId()) {
                            dPUUsbDriver.m8224d();
                            dPUUsbDriver.m8232a(-12);
                            if (dPUUsbDriver.f9994b) {
                                C1856n.m8127b("DPUUSBDriver", "Device [" + String.format("0x%x", Integer.valueOf(usbDevice.getVendorId())) + "," + String.format("0x%x", Integer.valueOf(usbDevice.getProductId())) + "] Detached!");
                            }
                        } else {
                            c = 65522;
                        }
                    }
                }
                DPUUSBManager dPUUSBManager2 = this.f9992a;
                if (c == 0) {
                    if (dPUUSBManager2.f9980d != null) {
                        dPUUSBManager2.f9980d.m8195a();
                        DPUUSBManager.m8237a(dPUUSBManager2.f9979c, "com.cnlaunch.intent.action.DIAG_UNCONNECTED");
                        dPUUSBManager2.f9980d = null;
                    }
                    dPUUSBManager2.f9977a.m8241d();
                    Intent intent2 = new Intent("DPUDeviceConnectDisconnected");
                    intent2.putExtra("isFix", dPUUSBManager2.f9981e);
                    dPUUSBManager2.f9979c.sendBroadcast(intent2);
                }
            }
        } else if (this.f9992a.f9978b.equals(action)) {
            C1856n.m8130a("DPUUSBManager", "Permisson REQUEST");
            if (intent.getBooleanExtra("permission", false)) {
                C1856n.m8130a("DPUUSBManager", "Permisson REQUEST TRUE");
                DPUUSBManager dPUUSBManager3 = this.f9992a;
                C1856n.m8130a("DPUUSBManager", "open Afer Permisson Request before status=" + dPUUSBManager3.f9977a.m8246a());
                DPUUSBManager.m8235a(this.f9992a, -7 != dPUUSBManager3.f9977a.m8246a() ? dPUUSBManager3.f9977a.m8242c() : -7);
                return;
            }
            DPUUSBManager.m8235a(this.f9992a, -17);
        }
    }
}
