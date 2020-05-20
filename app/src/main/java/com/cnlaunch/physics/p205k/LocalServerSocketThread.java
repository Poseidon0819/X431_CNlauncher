package com.cnlaunch.physics.p205k;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.cnlaunch.physics.DeviceFactoryManager;
import java.io.IOException;

/* renamed from: com.cnlaunch.physics.k.l */
/* loaded from: classes.dex */
public final class LocalServerSocketThread extends Thread {

    /* renamed from: c */
    private static String f10126c = "LocalServerSocketThread";

    /* renamed from: a */
    public LocalServerSocket f10127a;

    /* renamed from: b */
    public LocalSocketAcceptThread f10128b = null;

    /* renamed from: d */
    private boolean f10129d = false;

    /* renamed from: e */
    private DeviceFactoryManager f10130e;

    public LocalServerSocketThread(DeviceFactoryManager deviceFactoryManager) {
        this.f10130e = deviceFactoryManager;
        try {
            this.f10127a = new LocalServerSocket("com.cnlaunch.diagnose.localsocket");
            C1856n.m8130a(f10126c, "server create success");
        } catch (IOException e) {
            this.f10127a = null;
            e.printStackTrace();
        } catch (Exception e2) {
            this.f10127a = null;
            e2.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!m8135c()) {
            try {
                LocalSocket accept = this.f10127a.accept();
                if (accept == null) {
                    C1856n.m8130a(f10126c, "accept null socket");
                } else {
                    LocalSocketAcceptThread localSocketAcceptThread = this.f10128b;
                    if (localSocketAcceptThread != null) {
                        localSocketAcceptThread.m8134a();
                        this.f10128b = null;
                    }
                    this.f10128b = new LocalSocketAcceptThread(accept, this.f10130e);
                    this.f10128b.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: c */
    private synchronized boolean m8135c() {
        return this.f10129d;
    }

    /* renamed from: a */
    public final synchronized void m8137a() {
        if (this.f10128b != null) {
            C1856n.m8130a(f10126c, "acceptThread is stop");
            this.f10128b.m8134a();
            this.f10128b = null;
        }
    }

    /* renamed from: b */
    public final synchronized void m8136b() {
        try {
            if (this.f10128b != null) {
                C1856n.m8130a(f10126c, "acceptThread is stop");
                this.f10128b.m8134a();
                this.f10128b = null;
            }
            if (this.f10127a != null) {
                C1856n.m8130a(f10126c, "server is close");
                this.f10127a.close();
                this.f10127a = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f10129d = true;
    }
}
