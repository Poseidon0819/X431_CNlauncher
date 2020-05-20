package com.cnlaunch.physics.p192a;

import android.os.RemoteException;
import com.cnlaunch.physics.IPhysicsOutputStreamBufferWrapper;
import com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager;
import com.cnlaunch.physics.p200f.AbstractPhysicsOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.a.c */
/* loaded from: classes.dex */
final class BluetoothOutputStreamProxy extends AbstractPhysicsOutputStream {

    /* renamed from: a */
    IRemoteBluetoothManager f9787a;

    /* renamed from: b */
    OutputStream f9788b;

    /* renamed from: c */
    boolean f9789c;

    public BluetoothOutputStreamProxy(IRemoteBluetoothManager iRemoteBluetoothManager, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f9787a = iRemoteBluetoothManager;
        this.f9788b = null;
        this.f9789c = true;
    }

    public BluetoothOutputStreamProxy(OutputStream outputStream, IPhysicsOutputStreamBufferWrapper iPhysicsOutputStreamBufferWrapper) {
        super(iPhysicsOutputStreamBufferWrapper);
        this.f9787a = null;
        this.f9788b = outputStream;
        this.f9789c = false;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            if (this.f9789c) {
                this.f9787a.mo8407n();
            } else {
                this.f9788b.close();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            if (this.f9789c) {
                this.f9787a.mo8406o();
            } else {
                this.f9788b.flush();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            if (this.f9789c) {
                this.f9787a.mo8430a(i);
            } else {
                this.f9788b.write(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("wrapperBuffer is null");
        }
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        try {
            if (this.f9789c) {
                this.f9787a.mo8422b(bArr, i, i2);
            } else {
                this.f9788b.write(bArr, i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
