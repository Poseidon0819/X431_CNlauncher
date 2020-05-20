package com.cnlaunch.p182k;

import android.util.Log;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TCPSocketController.java */
/* renamed from: com.cnlaunch.k.d */
/* loaded from: classes.dex */
public final class RunnableC1790d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f9496a;

    /* renamed from: b */
    final /* synthetic */ byte[] f9497b;

    /* renamed from: c */
    final /* synthetic */ TCPSocketController f9498c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1790d(TCPSocketController tCPSocketController, long j, byte[] bArr) {
        this.f9498c = tCPSocketController;
        this.f9496a = j;
        this.f9497b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TCPHandler tCPHandler;
        Date date = new Date(System.currentTimeMillis());
        long j = 0;
        try {
            try {
                InputStream inputStream = this.f9498c.f9491a.getInputStream();
                this.f9498c.f9493c = 0;
                j = new Date(System.currentTimeMillis()).getTime() - date.getTime();
                while (j < this.f9496a) {
                    TCPSocketController tCPSocketController = this.f9498c;
                    int read = inputStream.read(this.f9497b);
                    tCPSocketController.f9493c = read;
                    if (read != -1) {
                        break;
                    }
                    if (this.f9498c.f9491a.isConnected() && !this.f9498c.f9491a.isClosed()) {
                        j = new Date(System.currentTimeMillis()).getTime() - date.getTime();
                        if (C1856n.f10135a) {
                            C1856n.m8127b("XEE", "ReceiveData count=" + this.f9498c.f9493c + " diff：" + j + " < ? " + this.f9496a);
                        }
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (this.f9498c.f9492b != null) {
                        this.f9498c.f9492b.socketTimeOut();
                    }
                }
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                if (j <= this.f9496a || this.f9498c.f9492b == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder("超时 maxWaitTime=diff=");
                sb.append(j);
                sb.append(" tcpHandler=null?");
                sb.append(this.f9498c.f9492b != null ? Boolean.FALSE : null);
                Log.e("XEE", sb.toString());
                if (this.f9498c.f9492b == null) {
                    return;
                }
                tCPHandler = this.f9498c.f9492b;
            } catch (IOException e3) {
                e3.printStackTrace();
                if (j <= this.f9496a || this.f9498c.f9492b == null) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder("超时 maxWaitTime=diff=");
                sb2.append(j);
                sb2.append(" tcpHandler=null?");
                sb2.append(this.f9498c.f9492b != null ? Boolean.FALSE : null);
                Log.e("XEE", sb2.toString());
                if (this.f9498c.f9492b == null) {
                    return;
                }
                tCPHandler = this.f9498c.f9492b;
            }
            if (j <= this.f9496a || this.f9498c.f9492b == null) {
                return;
            }
            StringBuilder sb3 = new StringBuilder("超时 maxWaitTime=diff=");
            sb3.append(j);
            sb3.append(" tcpHandler=null?");
            sb3.append(this.f9498c.f9492b != null ? Boolean.FALSE : null);
            Log.e("XEE", sb3.toString());
            if (this.f9498c.f9492b != null) {
                tCPHandler = this.f9498c.f9492b;
                tCPHandler.socketTimeOut();
            }
        } catch (Throwable th) {
            if (j > this.f9496a && this.f9498c.f9492b != null) {
                StringBuilder sb4 = new StringBuilder("超时 maxWaitTime=diff=");
                sb4.append(j);
                sb4.append(" tcpHandler=null?");
                sb4.append(this.f9498c.f9492b != null ? Boolean.FALSE : null);
                Log.e("XEE", sb4.toString());
                if (this.f9498c.f9492b != null) {
                    this.f9498c.f9492b.socketTimeOut();
                }
            }
            throw th;
        }
    }
}
