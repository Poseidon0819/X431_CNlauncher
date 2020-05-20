package com.mopub.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a */
    private final ByteArrayPool f21353a;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 256);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f21353a = byteArrayPool;
        this.buf = this.f21353a.getBuf(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21353a.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f21353a.returnBuf(this.buf);
    }

    /* renamed from: a */
    private void m1974a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] buf = this.f21353a.getBuf((this.count + i) * 2);
        System.arraycopy(this.buf, 0, buf, 0, this.count);
        this.f21353a.returnBuf(this.buf);
        this.buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m1974a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        m1974a(1);
        super.write(i);
    }
}
