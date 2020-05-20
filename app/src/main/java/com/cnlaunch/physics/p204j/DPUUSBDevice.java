package com.cnlaunch.physics.p204j;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.cnlaunch.physics.p205k.C1856n;

/* renamed from: com.cnlaunch.physics.j.a */
/* loaded from: classes.dex */
public final class DPUUSBDevice {

    /* renamed from: a */
    public DPUUsbDriver f9974a;

    /* renamed from: b */
    private Context f9975b;

    /* renamed from: c */
    private String f9976c;

    public DPUUSBDevice(Context context, String str) {
        this.f9975b = context;
        this.f9976c = str;
        this.f9974a = new DPUUsbDriver(this.f9975b, this.f9976c);
    }

    /* renamed from: a */
    public final int m8246a() {
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return -4;
        }
        return dPUUsbDriver.m8223e();
    }

    /* renamed from: b */
    public final int m8244b() {
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return -4;
        }
        return dPUUsbDriver.m8227b();
    }

    /* renamed from: a */
    public final boolean m8245a(Intent intent) {
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return false;
        }
        return dPUUsbDriver.m8230a(intent);
    }

    /* renamed from: b */
    public final int m8243b(Intent intent) {
        int i;
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return -4;
        }
        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
        if (usbDevice == null) {
            return -2;
        }
        if (dPUUsbDriver.f9995c == null) {
            dPUUsbDriver.m8233a();
            if (dPUUsbDriver.f9995c == null) {
                return -4;
            }
        }
        boolean z = false;
        if (-1 != dPUUsbDriver.f10000h && -1 != dPUUsbDriver.f9999g && (usbDevice.getVendorId() != dPUUsbDriver.f10000h || usbDevice.getProductId() != dPUUsbDriver.f9999g)) {
            C1856n.m8127b("DPUUSBDriver", "Device error VendorId =" + usbDevice.getVendorId() + " ProductId=" + usbDevice.getProductId());
            dPUUsbDriver.m8232a(-7);
            return 0;
        }
        int size = dPUUsbDriver.f9993a.size();
        if (size <= 0) {
            return -23;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -14;
                break;
            } else if (dPUUsbDriver.f9993a.get(i2).f10020a == usbDevice.getVendorId() && dPUUsbDriver.f9993a.get(i2).f10021b == usbDevice.getProductId()) {
                dPUUsbDriver.f10000h = dPUUsbDriver.f9993a.get(i2).f10020a;
                dPUUsbDriver.f9999g = dPUUsbDriver.f9993a.get(i2).f10021b;
                if (dPUUsbDriver.f9994b) {
                    C1856n.m8127b("DPUUSBDriver", "Device [" + String.format("0x%x", Integer.valueOf(dPUUsbDriver.f10000h)) + "," + String.format("0x%x", Integer.valueOf(dPUUsbDriver.f9999g)) + "] Attached!");
                }
                i = dPUUsbDriver.m8225c();
                z = true;
            } else {
                i2++;
            }
        }
        if (z) {
            return i;
        }
        return -14;
    }

    /* renamed from: c */
    public final int m8242c() {
        if (-7 == m8246a()) {
            m8241d();
        }
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return -4;
        }
        return dPUUsbDriver.m8225c();
    }

    /* renamed from: d */
    public final int m8241d() {
        DPUUsbDriver dPUUsbDriver = this.f9974a;
        if (dPUUsbDriver == null) {
            return -4;
        }
        dPUUsbDriver.m8224d();
        return 0;
    }

    protected final void finalize() throws Throwable {
        m8241d();
        this.f9974a = null;
    }
}
