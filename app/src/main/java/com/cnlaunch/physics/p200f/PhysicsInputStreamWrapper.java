package com.cnlaunch.physics.p200f;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cnlaunch.physics.f.c */
/* loaded from: classes.dex */
public final class PhysicsInputStreamWrapper extends AbstractPhysicsInputStream {

    /* renamed from: a */
    private InputStream f9929a;

    public PhysicsInputStreamWrapper(InputStream inputStream) {
        this.f9929a = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f9929a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9929a.close();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.f9929a.read(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f9929a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f9929a.read();
    }
}
