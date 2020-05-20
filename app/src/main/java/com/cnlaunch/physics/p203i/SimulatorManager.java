package com.cnlaunch.physics.p203i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteBufferStream;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.p207b.ReadByteDataStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.cnlaunch.physics.i.d */
/* loaded from: classes.dex */
public final class SimulatorManager implements IPhysics {

    /* renamed from: j */
    private static String f9942j = "";

    /* renamed from: k */
    private Context f9952k;

    /* renamed from: n */
    private boolean f9955n;

    /* renamed from: o */
    private DeviceFactoryManager f9956o;

    /* renamed from: p */
    private String f9957p;

    /* renamed from: m */
    private boolean f9954m = true;

    /* renamed from: i */
    public Handler f9951i = new HandlerC1848e(this, Looper.getMainLooper());

    /* renamed from: a */
    public ReadByteDataStream f9943a = null;

    /* renamed from: d */
    public C1847a f9946d = null;

    /* renamed from: e */
    public C1847a f9947e = null;

    /* renamed from: f */
    public StreamThread f9948f = null;

    /* renamed from: b */
    public int f9944b = 0;

    /* renamed from: c */
    public InputStream f9945c = null;

    /* renamed from: q */
    private OutputStream f9958q = null;

    /* renamed from: l */
    private boolean f9953l = false;

    /* renamed from: g */
    public boolean f9949g = false;

    /* renamed from: h */
    public boolean f9950h = false;

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getDeviceName() {
        return null;
    }

    public SimulatorManager(DeviceFactoryManager deviceFactoryManager, Context context, boolean z, String str) {
        this.f9952k = context.getApplicationContext();
        this.f9955n = z;
        this.f9956o = deviceFactoryManager;
        this.f9957p = str;
    }

    protected final void finalize() {
        try {
            C1856n.m8127b("SimulatorManager", "finalize SerialPortManager");
            this.f9943a = null;
            this.f9946d = null;
            this.f9947e = null;
            this.f9948f = null;
            this.f9951i = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getCommand() {
        C1856n.m8127b("SimulatorManager", "获取读取到的完整指令" + f9942j);
        return f9942j;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setCommand(String str) {
        f9942j = str;
        this.f9956o.m8298a(str);
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final OutputStream getOutputStream() {
        if (this.f9958q == null) {
            this.f9958q = new SimulatorOutputStream(this, this.f9956o.f9916p);
        }
        return this.f9958q;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final int getState() {
        return this.f9944b;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean getCommand_wait() {
        return this.f9954m;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setCommand_wait(boolean z) {
        this.f9954m = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final Context getContext() {
        return this.f9952k;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void closeDevice() {
        ReadByteDataStream readByteDataStream = this.f9943a;
        if (readByteDataStream != null) {
            readByteDataStream.m8195a();
            this.f9943a = null;
        }
        C1847a c1847a = this.f9946d;
        if (c1847a != null) {
            c1847a.m8250a();
        }
        C1847a c1847a2 = this.f9947e;
        if (c1847a2 != null) {
            c1847a2.m8250a();
        }
        StreamThread streamThread = this.f9948f;
        if (streamThread != null) {
            streamThread.m8248a();
        }
        this.f9944b = 0;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final String getSerialNo() {
        return this.f9957p;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized void setIsTruckReset(boolean z) {
        this.f9953l = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final synchronized boolean isTruckReset() {
        return this.f9953l;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void setIsFix(boolean z) {
        this.f9955n = z;
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final void physicalCloseDevice() {
        closeDevice();
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsRemoteClientDiagnoseMode() {
        return this.f9949g;
    }

    /* compiled from: SimulatorManager.java */
    /* renamed from: com.cnlaunch.physics.i.d$a */
    /* loaded from: classes.dex */
    public static class C1847a extends ByteBufferStream {

        /* renamed from: a */
        private final Lock f9959a = new ReentrantLock();

        /* renamed from: b */
        private final Condition f9960b = this.f9959a.newCondition();

        /* renamed from: a */
        public final void m8250a() {
            this.f9959a.lock();
            try {
                this.f9960b.signal();
            } finally {
                this.f9959a.unlock();
            }
        }

        @Override // com.cnlaunch.physics.p205k.ByteBufferStream
        /* renamed from: a */
        public final void mo8192a(byte[] bArr, int i, int i2) {
            this.f9959a.lock();
            try {
                super.mo8192a(bArr, i, i2);
                this.f9960b.signal();
            } finally {
                this.f9959a.unlock();
            }
        }

        /* renamed from: b */
        public final int m8249b(byte[] bArr, int i, int i2) {
            int i3;
            this.f9959a.lock();
            try {
                if (this.f10094f <= 0) {
                    this.f9960b.await();
                }
                i3 = super.m8188c(bArr, i, i2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                i3 = 0;
            }
            this.f9959a.unlock();
            return i3;
        }
    }

    @Override // com.cnlaunch.physics.p199e.IPhysics
    public final boolean getIsSupportOneRequestMoreAnswerDiagnoseMode() {
        return this.f9950h;
    }
}
