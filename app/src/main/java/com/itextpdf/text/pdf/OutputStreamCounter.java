package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class OutputStreamCounter extends OutputStream {
    protected long counter = 0;
    protected OutputStream out;

    public OutputStreamCounter(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.counter += bArr.length;
        this.out.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.counter++;
        this.out.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.counter += i2;
        this.out.write(bArr, i, i2);
    }

    public long getCounter() {
        return this.counter;
    }

    public void resetCounter() {
        this.counter = 0L;
    }
}
