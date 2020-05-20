package com.cnlaunch.physics.p203i;

import com.cnlaunch.physics.p200f.AbstractPhysicsInputStream;
import java.io.IOException;

/* renamed from: com.cnlaunch.physics.i.c */
/* loaded from: classes.dex */
public final class SimulatorInputStream extends AbstractPhysicsInputStream {

    /* renamed from: a */
    private SimulatorManager f9941a;

    public SimulatorInputStream(SimulatorManager simulatorManager) {
        this.f9941a = simulatorManager;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9941a.f9946d.m8250a();
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
        int m8249b = this.f9941a.f9946d.m8249b(bArr, i, i2);
        if (m8249b >= 0) {
            return m8249b;
        }
        throw new IOException();
    }
}
