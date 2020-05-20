package com.cnlaunch.physics.p205k;

import android.net.LocalSocket;
import com.cnlaunch.physics.DeviceFactoryManager;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cnlaunch.physics.k.m */
/* loaded from: classes.dex */
public final class LocalSocketAcceptThread extends Thread {

    /* renamed from: a */
    public static String f10131a = "LocalSocketAcceptThread";

    /* renamed from: b */
    public LocalSocket f10132b;

    /* renamed from: c */
    private DeviceFactoryManager f10133c;

    /* renamed from: d */
    private boolean f10134d = false;

    public LocalSocketAcceptThread(LocalSocket localSocket, DeviceFactoryManager deviceFactoryManager) {
        this.f10132b = localSocket;
        this.f10133c = deviceFactoryManager;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            InputStream inputStream = this.f10132b.getInputStream();
            byte[] bArr = new byte[5370];
            while (!m8132b()) {
                try {
                    int read = inputStream.read(bArr);
                    while (read == 5370 && inputStream.available() > 0) {
                        m8133a(bArr, 5370);
                        if (C1856n.f10135a) {
                            String str = f10131a;
                            C1856n.m8130a(str, "get sucess command buffer=" + ByteHexHelper.m8179a(bArr, read));
                        }
                        read = inputStream.read(bArr);
                    }
                    if (read > 0) {
                        m8133a(bArr, read);
                        if (C1856n.f10135a) {
                            String str2 = f10131a;
                            C1856n.m8130a(str2, "get sucess command buffer=" + ByteHexHelper.m8179a(bArr, read));
                        }
                    } else if (this.f10132b != null && !this.f10132b.isConnected()) {
                        return;
                    } else {
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    C1856n.m8130a(f10131a, "get command IOException");
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    private synchronized boolean m8132b() {
        return this.f10134d;
    }

    /* renamed from: a */
    public final synchronized void m8134a() {
        try {
            C1856n.m8130a(f10131a, "connect is close");
            if (this.f10132b != null && this.f10132b.isConnected()) {
                this.f10132b.getInputStream().close();
                this.f10132b.getOutputStream().close();
                this.f10132b.close();
            }
            this.f10132b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f10134d = true;
    }

    /* renamed from: a */
    private void m8133a(byte[] bArr, int i) {
        DeviceFactoryManager deviceFactoryManager = this.f10133c;
        if (deviceFactoryManager != null) {
            deviceFactoryManager.m8294a(bArr, i);
        }
    }
}
