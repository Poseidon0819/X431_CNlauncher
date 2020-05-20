package com.cnlaunch.physics.p192a;

import android.os.RemoteException;
import com.cnlaunch.physics.p192a.p194b.IRemoteBluetoothManager;
import com.cnlaunch.physics.p200f.AbstractPhysicsInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cnlaunch.physics.a.a */
/* loaded from: classes.dex */
final class BluetoothInputStreamProxy extends AbstractPhysicsInputStream {

    /* renamed from: a */
    IRemoteBluetoothManager f9693a;

    /* renamed from: b */
    InputStream f9694b = null;

    /* renamed from: c */
    boolean f9695c = true;

    public BluetoothInputStreamProxy(IRemoteBluetoothManager iRemoteBluetoothManager) {
        this.f9693a = iRemoteBluetoothManager;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            if (this.f9695c) {
                return this.f9693a.mo8409l();
            }
            return this.f9694b.available();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            if (this.f9695c) {
                this.f9693a.mo8408m();
            } else {
                this.f9694b.close();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            if (this.f9695c) {
                return this.f9693a.mo8410k();
            }
            return this.f9694b.read();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            if (this.f9695c) {
                return this.f9693a.mo8426a(bArr, i, i2);
            }
            return this.f9694b.read(bArr, i, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
