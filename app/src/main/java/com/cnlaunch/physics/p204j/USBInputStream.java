package com.cnlaunch.physics.p204j;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import com.cnlaunch.physics.p200f.AbstractPhysicsInputStream;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.cnlaunch.physics.j.e */
/* loaded from: classes.dex */
final class USBInputStream extends AbstractPhysicsInputStream {

    /* renamed from: a */
    private DPUUSBDevice f10023a;

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public USBInputStream(DPUUSBDevice dPUUSBDevice) {
        this.f10023a = dPUUSBDevice;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int read = read(new byte[1], 0, 1);
        if (read >= 0) {
            return read;
        }
        throw new IOException();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        UsbRequest usbRequest;
        UsbRequest requestWait;
        if (bArr == null) {
            throw new NullPointerException("byte array is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException("invalid offset or length");
        }
        if (i != 0) {
            throw new IllegalArgumentException("offset 必须为0");
        }
        C1856n.m8130a("USBInputStream", "usbDevice.read start");
        int i3 = 0;
        if (Build.VERSION.SDK_INT <= 25) {
            DPUUSBDevice dPUUSBDevice = this.f10023a;
            i3 = dPUUSBDevice.f9974a == null ? -4 : dPUUSBDevice.f9974a.m8228a(bArr, i2);
        } else {
            DPUUSBDevice dPUUSBDevice2 = this.f10023a;
            UsbDeviceConnection usbDeviceConnection = null;
            if (dPUUSBDevice2.f9974a == null) {
                usbRequest = null;
            } else {
                DPUUsbDriver dPUUsbDriver = dPUUSBDevice2.f9974a;
                int m8223e = dPUUsbDriver.m8223e();
                if (-7 != m8223e) {
                    C1856n.m8127b("DPUUSBDriver", "read() --> device status error! error: ".concat(String.valueOf(m8223e)));
                    usbRequest = null;
                } else if (dPUUsbDriver.f9995c == null || dPUUsbDriver.f9996d == null || dPUUsbDriver.f9998f.f10017a == null || dPUUsbDriver.f10001i == null) {
                    C1856n.m8127b("DPUUSBDriver", "read() -> No USBDriver object's instance!");
                    usbRequest = null;
                } else {
                    usbRequest = dPUUsbDriver.f10001i;
                }
            }
            if (usbRequest != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, i2);
                if (usbRequest.queue(wrap, i2)) {
                    DPUUSBDevice dPUUSBDevice3 = this.f10023a;
                    if (dPUUSBDevice3.f9974a != null) {
                        DPUUsbDriver dPUUsbDriver2 = dPUUSBDevice3.f9974a;
                        int m8223e2 = dPUUsbDriver2.m8223e();
                        if (-7 != m8223e2) {
                            C1856n.m8127b("DPUUSBDriver", "read() --> device status error! error: ".concat(String.valueOf(m8223e2)));
                        } else if (dPUUsbDriver2.f9995c == null || dPUUsbDriver2.f9996d == null || dPUUsbDriver2.f9998f.f10017a == null) {
                            C1856n.m8127b("DPUUSBDriver", "read() -> No USBDriver object's instance!");
                        } else {
                            usbDeviceConnection = dPUUsbDriver2.f9996d;
                        }
                    }
                    if (usbDeviceConnection != null && (requestWait = usbDeviceConnection.requestWait()) != null) {
                        if (requestWait.equals(usbRequest)) {
                            byte[] array = wrap.array();
                            int position = wrap.position();
                            System.arraycopy(array, 0, bArr, i, position);
                            i3 = position;
                        }
                    }
                }
            }
            i3 = -1;
        }
        C1856n.m8130a("USBInputStream", "usbDevice.read end");
        if (i3 >= 0) {
            return i3;
        }
        throw new IOException();
    }
}
