package com.cnlaunch.p182k;

import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/* renamed from: com.cnlaunch.k.c */
/* loaded from: classes.dex */
public final class TCPSocketController {

    /* renamed from: e */
    private Thread f9495e = null;

    /* renamed from: a */
    Socket f9491a = null;

    /* renamed from: b */
    TCPHandler f9492b = null;

    /* renamed from: c */
    int f9493c = 0;

    /* renamed from: d */
    int f9494d = 0;

    /* renamed from: a */
    public final byte[] m8639a(int i) {
        if (this.f9491a == null) {
            C1856n.m8127b("XEE", "getReceiveData socket =null");
        }
        long j = i;
        byte[] bArr = new byte[4096];
        Socket socket = this.f9491a;
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f9495e = new Thread(new RunnableC1790d(this, j, bArr));
        this.f9495e.start();
        try {
            this.f9495e.join();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = this.f9493c;
        if (i2 > 0) {
            return Arrays.copyOfRange(bArr, 0, i2);
        }
        return new byte[0];
    }

    /* renamed from: a */
    public final void m8640a() {
        this.f9495e = new Thread(new RunnableC1791e(this));
        this.f9495e.start();
        try {
            this.f9495e.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final boolean m8638a(String str, int i, TCPHandler tCPHandler) {
        this.f9492b = tCPHandler;
        this.f9495e = new Thread(new RunnableC1792f(this, str, i));
        this.f9495e.start();
        try {
            this.f9495e.join();
            if (this.f9491a != null && this.f9491a.isConnected()) {
                if (tCPHandler != null) {
                    tCPHandler.connectSuccess();
                }
                return true;
            } else if (tCPHandler != null) {
                tCPHandler.connectFailed();
                return false;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (tCPHandler != null) {
                tCPHandler.connectFailed();
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public final int m8637a(byte[] bArr) {
        if (this.f9491a == null || bArr == null) {
            return 0;
        }
        this.f9495e = new Thread(new RunnableC1793g(this, bArr, bArr.length));
        this.f9495e.start();
        try {
            this.f9495e.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f9494d;
    }

    /* renamed from: b */
    public final void m8636b() {
        TCPHandler tCPHandler = this.f9492b;
        if (tCPHandler != null) {
            tCPHandler.connectClosed();
        }
        Socket socket = this.f9491a;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.f9491a = null;
            }
        }
    }
}
