package com.cnlaunch.p182k;

import android.util.Log;
import com.cnlaunch.physics.p205k.C1856n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.cnlaunch.k.a */
/* loaded from: classes.dex */
public final class RJ45LinkManager {

    /* renamed from: d */
    private static RJ45LinkManager f9486d;

    /* renamed from: a */
    public TCPSocketController f9487a;

    /* renamed from: b */
    public AtomicInteger f9488b = new AtomicInteger(0);

    /* renamed from: c */
    public ConcurrentHashMap<Integer, TCPSocketController> f9489c = new ConcurrentHashMap<>();

    /* renamed from: e */
    private UDPController f9490e;

    /* renamed from: a */
    public static synchronized RJ45LinkManager m8645a() {
        RJ45LinkManager rJ45LinkManager;
        synchronized (RJ45LinkManager.class) {
            if (f9486d == null) {
                f9486d = new RJ45LinkManager();
            }
            rJ45LinkManager = f9486d;
        }
        return rJ45LinkManager;
    }

    private RJ45LinkManager() {
        this.f9487a = null;
        this.f9490e = null;
        this.f9487a = new TCPSocketController();
        this.f9490e = new UDPController();
    }

    /* renamed from: a */
    public final boolean m8644a(int i) {
        TCPSocketController tCPSocketController = this.f9489c.get(Integer.valueOf(i));
        return (tCPSocketController == null || tCPSocketController.f9491a == null || !tCPSocketController.f9491a.isConnected() || tCPSocketController.f9491a.isClosed()) ? false : true;
    }

    /* renamed from: b */
    public final synchronized void m8641b() {
        try {
            if (C1856n.f10135a) {
                C1856n.m8130a("RJ45LinkManager", "RJ45LinkManager dumpAllTcpSocketController start");
                for (Map.Entry<Integer, TCPSocketController> entry : this.f9489c.entrySet()) {
                    C1856n.m8130a("RJ45LinkManager", "RJ45LinkManager dumpAllTcpSocketController  socketIndex = " + entry.getKey() + ", tcpSocketController = " + entry.getValue().toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final byte[] m8642a(int i, int i2, byte[] bArr, String str) {
        try {
            return this.f9490e.m8634a(i, i2, bArr, str);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Sanda", "host is unkonw!");
            return null;
        }
    }

    /* renamed from: a */
    public final byte[] m8643a(int i, int i2) {
        try {
            return this.f9490e.m8635a(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
