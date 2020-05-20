package com.mopub.common;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.common.e */
/* loaded from: classes.dex */
public final class DiskLruCacheStrictLineReader implements Closeable {

    /* renamed from: a */
    final Charset f20116a;

    /* renamed from: b */
    private final InputStream f20117b;

    /* renamed from: c */
    private byte[] f20118c;

    /* renamed from: d */
    private int f20119d;

    /* renamed from: e */
    private int f20120e;

    public DiskLruCacheStrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public DiskLruCacheStrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(DiskLruCacheUtil.f20059a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f20117b = inputStream;
        this.f20116a = charset;
        this.f20118c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f20117b) {
            if (this.f20118c != null) {
                this.f20118c = null;
                this.f20117b.close();
            }
        }
    }

    public final String readLine() throws IOException {
        int i;
        int i2;
        synchronized (this.f20117b) {
            if (this.f20118c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f20119d >= this.f20120e) {
                m2536a();
            }
            for (int i3 = this.f20119d; i3 != this.f20120e; i3++) {
                if (this.f20118c[i3] == 10) {
                    if (i3 != this.f20119d) {
                        i2 = i3 - 1;
                        if (this.f20118c[i2] == 13) {
                            String str = new String(this.f20118c, this.f20119d, i2 - this.f20119d, this.f20116a.name());
                            this.f20119d = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.f20118c, this.f20119d, i2 - this.f20119d, this.f20116a.name());
                    this.f20119d = i3 + 1;
                    return str2;
                }
            }
            C3692f c3692f = new C3692f(this, (this.f20120e - this.f20119d) + 80);
            loop1: while (true) {
                c3692f.write(this.f20118c, this.f20119d, this.f20120e - this.f20119d);
                this.f20120e = -1;
                m2536a();
                i = this.f20119d;
                while (i != this.f20120e) {
                    if (this.f20118c[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f20119d) {
                c3692f.write(this.f20118c, this.f20119d, i - this.f20119d);
            }
            this.f20119d = i + 1;
            return c3692f.toString();
        }
    }

    /* renamed from: a */
    private void m2536a() throws IOException {
        InputStream inputStream = this.f20117b;
        byte[] bArr = this.f20118c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f20119d = 0;
        this.f20120e = read;
    }
}
