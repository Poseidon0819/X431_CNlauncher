package com.cnlaunch.physics.p203i;

import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.i.g */
/* loaded from: classes.dex */
public final class StreamThread extends Thread {

    /* renamed from: b */
    private static String f9963b = "StreamThread";

    /* renamed from: i */
    private SimulatorManager f9971i;

    /* renamed from: j */
    private byte f9972j;

    /* renamed from: k */
    private byte[] f9973k;

    /* renamed from: f */
    private final int f9968f = 5120;

    /* renamed from: c */
    private boolean f9965c = false;

    /* renamed from: a */
    ArrayList<SimulatorDPUCommand> f9964a = new ArrayList<>();

    /* renamed from: g */
    private byte[] f9969g = new byte[5120];

    /* renamed from: d */
    private int f9966d = 10240;

    /* renamed from: h */
    private byte[] f9970h = new byte[this.f9966d];

    /* renamed from: e */
    private int f9967e = 0;

    public StreamThread(SimulatorManager simulatorManager) {
        SimulatorDPUCommand.m8260a(this.f9964a);
        this.f9971i = simulatorManager;
        this.f9964a.add(SimulatorDPUCommand.m8261a(this.f9971i.getSerialNo()));
        this.f9964a.add(SimulatorDPUCommand.m8256b(this.f9971i.getSerialNo()));
        this.f9964a.add(SimulatorDPUCommand.m8262a());
        this.f9964a.add(SimulatorDPUCommand.m8257b());
        this.f9964a.add(SimulatorDPUCommand.m8254c());
        this.f9973k = new byte[]{-1, 2};
    }

    /* renamed from: b */
    private synchronized boolean m8247b() {
        return this.f9965c;
    }

    /* renamed from: a */
    public final synchronized void m8248a() {
        if (C1856n.f10135a) {
            C1856n.m8130a(f9963b, "connect is close");
        }
        this.f9965c = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        boolean z;
        ISimulatorDataProcessor iSimulatorDataProcessor;
        while (!m8247b()) {
            try {
                int m8249b = this.f9971i.f9947e.m8249b(this.f9969g, 0, 5120);
                if (C1856n.f10135a) {
                    C1856n.m8130a(f9963b, "Diagnose Request Data  buffer count = ".concat(String.valueOf(m8249b)));
                }
                if (m8249b > 0) {
                    if (this.f9967e + m8249b <= this.f9966d) {
                        System.arraycopy(this.f9969g, 0, this.f9970h, this.f9967e, m8249b);
                    } else {
                        this.f9967e = 0;
                        System.arraycopy(this.f9969g, 0, this.f9970h, this.f9967e, m8249b);
                    }
                    this.f9967e += m8249b;
                    int m8177a = ByteHexHelper.m8177a(this.f9970h, SimulatorDPUCommand.f9936a, 0, this.f9967e);
                    if (m8177a >= 0) {
                        if (m8177a > 0) {
                            int i2 = this.f9967e - m8177a;
                            byte[] bArr = this.f9970h;
                            System.arraycopy(bArr, m8177a, bArr, 0, i2);
                            this.f9967e = i2;
                        }
                        if (this.f9967e >= 6 && this.f9967e >= (i = ((this.f9970h[4] & 255) * 256) + (this.f9970h[5] & 255) + 7) && this.f9972j != this.f9970h[6]) {
                            byte[] bArr2 = this.f9970h;
                            this.f9972j = bArr2[6];
                            int i3 = 0;
                            while (true) {
                                if (i3 >= this.f9964a.size()) {
                                    z = false;
                                    break;
                                }
                                SimulatorDPUCommand simulatorDPUCommand = this.f9964a.get(i3);
                                if (ByteHexHelper.m8177a(bArr2, simulatorDPUCommand.f9939d, 7, i - 7) == 7) {
                                    byte[] m8255b = SimulatorDPUCommand.m8255b(simulatorDPUCommand.f9940e, simulatorDPUCommand.f9940e.length, this.f9972j);
                                    this.f9971i.f9946d.mo8192a(m8255b, 0, m8255b.length);
                                    z = true;
                                    break;
                                }
                                i3++;
                            }
                            if (!z && (iSimulatorDataProcessor = DeviceFactoryManager.m8305a().f9909i) != null) {
                                byte[] m8263a = iSimulatorDataProcessor.m8263a();
                                if (m8263a != null && m8263a.length > 0) {
                                    byte[] m8259a = SimulatorDPUCommand.m8259a(m8263a, m8263a.length, this.f9972j);
                                    this.f9971i.f9946d.mo8192a(m8259a, 0, m8259a.length);
                                } else {
                                    byte[] m8259a2 = SimulatorDPUCommand.m8259a(this.f9973k, this.f9973k.length, this.f9972j);
                                    this.f9971i.f9946d.mo8192a(m8259a2, 0, m8259a2.length);
                                }
                            }
                            this.f9967e -= i;
                            if (this.f9967e > 0) {
                                byte[] bArr3 = this.f9970h;
                                System.arraycopy(bArr3, i, bArr3, 0, this.f9967e);
                            }
                        }
                    }
                } else if (m8249b != 0) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
