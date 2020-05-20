package com.cnlaunch.physics.p192a.p193a;

import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import com.cnlaunch.physics.p200f.AbstractPhysicsOutputStream;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;

/* renamed from: com.cnlaunch.physics.a.a.f */
/* loaded from: classes.dex */
final class BluetoothBLEOutputStream extends AbstractPhysicsOutputStream {

    /* renamed from: a */
    private BluetoothBLEManager f9741a;

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothBLEOutputStream(BluetoothBLEManager bluetoothBLEManager, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f9741a = bluetoothBLEManager;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9741a.f9707b.m8459a();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("wrapperBuffer is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "BluetoothBLEManager.write start");
        }
        this.f9741a.f9708c.mo8192a(bArr, i, i2);
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothBLEManager", "BluetoothBLEManager.write end");
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
