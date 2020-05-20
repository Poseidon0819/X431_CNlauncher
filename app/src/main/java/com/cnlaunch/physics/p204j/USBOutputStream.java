package com.cnlaunch.physics.p204j;

import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import com.cnlaunch.physics.p200f.AbstractPhysicsOutputStream;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;

/* renamed from: com.cnlaunch.physics.j.f */
/* loaded from: classes.dex */
final class USBOutputStream extends AbstractPhysicsOutputStream {

    /* renamed from: a */
    private DPUUSBDevice f10024a;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
    }

    public USBOutputStream(DPUUSBDevice dPUUSBDevice, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f10024a = dPUUSBDevice;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("buffer is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        if (i != 0) {
            throw new IllegalArgumentException("offset 必须为0");
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("USBOutputStream", "usbDevice.write start");
        }
        DPUUSBDevice dPUUSBDevice = this.f10024a;
        if ((dPUUSBDevice.f9974a == null ? -4 : dPUUSBDevice.f9974a.m8226b(bArr, i2)) <= 0) {
            throw new IOException();
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("USBOutputStream", "usbDevice.write end");
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
