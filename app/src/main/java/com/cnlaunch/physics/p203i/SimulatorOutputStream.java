package com.cnlaunch.physics.p203i;

import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import com.cnlaunch.physics.p200f.AbstractPhysicsOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.cnlaunch.physics.i.f */
/* loaded from: classes.dex */
public final class SimulatorOutputStream extends AbstractPhysicsOutputStream {

    /* renamed from: a */
    private SimulatorManager f9962a;

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimulatorOutputStream(SimulatorManager simulatorManager, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f9962a = simulatorManager;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9962a.f9947e.m8250a();
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
        this.f9962a.f9947e.mo8192a(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
