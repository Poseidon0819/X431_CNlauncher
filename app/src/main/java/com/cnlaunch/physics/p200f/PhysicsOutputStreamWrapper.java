package com.cnlaunch.physics.p200f;

import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.f.d */
/* loaded from: classes.dex */
public final class PhysicsOutputStreamWrapper extends AbstractPhysicsOutputStream {

    /* renamed from: a */
    private OutputStream f9930a;

    public PhysicsOutputStreamWrapper(OutputStream outputStream, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f9930a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9930a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f9930a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f9930a.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("wrapperBuffer is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        this.f9930a.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f9930a.write(i);
    }
}
