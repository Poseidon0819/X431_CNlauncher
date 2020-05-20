package com.cnlaunch.physics.p205k.p207b;

import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.k.b.c */
/* loaded from: classes.dex */
public class ReadByteDataStream implements Runnable {

    /* renamed from: h */
    private static final String f10074h = "c";

    /* renamed from: a */
    protected int f10075a;

    /* renamed from: f */
    public CommonDiagnoseDataStreamProcessor f10080f;

    /* renamed from: g */
    public OBDCheckDiagnoseDataStreamProcessor f10081g;

    /* renamed from: i */
    private IPhysics f10082i;

    /* renamed from: j */
    private InputStream f10083j;

    /* renamed from: k */
    private OutputStream f10084k;

    /* renamed from: l */
    private RemoteClientDiagnoseDataStreamProcessor f10085l;

    /* renamed from: b */
    protected final int f10076b = 5120;

    /* renamed from: c */
    protected byte[] f10077c = new byte[5120];

    /* renamed from: e */
    protected int f10079e = 10240;

    /* renamed from: d */
    protected byte[] f10078d = new byte[this.f10079e];

    public ReadByteDataStream(IPhysics iPhysics, InputStream inputStream, OutputStream outputStream) {
        this.f10083j = inputStream;
        this.f10084k = outputStream;
        this.f10082i = iPhysics;
        this.f10085l = new RemoteClientDiagnoseDataStreamProcessor(this, this.f10082i, this.f10083j, this.f10084k);
        this.f10080f = new CommonDiagnoseDataStreamProcessor(this, this.f10082i, this.f10083j, this.f10084k);
        this.f10081g = new OBDCheckDiagnoseDataStreamProcessor(this, this.f10082i, this.f10083j, this.f10084k);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10082i == null) {
            return;
        }
        this.f10075a = 0;
        while (true) {
            try {
                this.f10075a = this.f10083j.read(this.f10077c);
                if (C1856n.f10135a) {
                    String str = f10074h;
                    C1856n.m8130a(str, "ReadByteDataStream.run(). buffer=" + ByteHexHelper.m8179a(this.f10077c, this.f10075a));
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (C1856n.f10135a) {
                    String str2 = f10074h;
                    C1856n.m8130a(str2, "read data error" + e.getMessage());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f10075a > 0) {
                if (this.f10082i.getIsRemoteClientDiagnoseMode()) {
                    this.f10085l.m8194a();
                } else if (this.f10082i.getIsSupportOneRequestMoreAnswerDiagnoseMode()) {
                    this.f10081g.m8199b();
                } else {
                    this.f10080f.m8199b();
                }
            } else {
                if (this.f10075a == 0) {
                }
                try {
                    this.f10082i.setCommand_wait(false);
                    this.f10082i.setCommand("");
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m8195a() {
        try {
            if (C1856n.f10135a) {
                C1856n.m8130a(f10074h, "cancel()");
            }
            this.f10083j.close();
            this.f10084k.close();
            if (this.f10080f != null) {
                this.f10080f.m8198d();
            }
            if (this.f10081g != null) {
                this.f10081g.m8198d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
