package com.cnlaunch.physics.p192a.p193a;

import com.cnlaunch.physics.p200f.AbstractPhysicsInputStream;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;

/* renamed from: com.cnlaunch.physics.a.a.b */
/* loaded from: classes.dex */
final class BluetoothBLEInputStream extends AbstractPhysicsInputStream {

    /* renamed from: a */
    private BluetoothBLEManager f9699a;

    public BluetoothBLEInputStream(BluetoothBLEManager bluetoothBLEManager) {
        this.f9699a = bluetoothBLEManager;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9699a.f9708c.m8457a();
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
        if (bArr == null) {
            throw new NullPointerException("byte array is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException("invalid offset or length");
        }
        C1856n.m8130a("BluetoothBLEInputStream", "BluetoothBLEInputStream.read start");
        int m8458b = this.f9699a.f9707b.m8458b(bArr, i, i2);
        C1856n.m8130a("BluetoothBLEInputStream", "BluetoothBLEInputStream.read end");
        if (m8458b >= 0) {
            return m8458b;
        }
        throw new IOException();
    }
}
