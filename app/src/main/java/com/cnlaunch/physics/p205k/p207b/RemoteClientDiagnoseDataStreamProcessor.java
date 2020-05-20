package com.cnlaunch.physics.p205k.p207b;

import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.p206a.MessageStream;
import com.cnlaunch.physics.p205k.p206a.RemoteMessage;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cnlaunch.physics.k.b.d */
/* loaded from: classes.dex */
public class RemoteClientDiagnoseDataStreamProcessor {

    /* renamed from: a */
    private static final String f10086a = "d";

    /* renamed from: b */
    private IPhysics f10087b;

    /* renamed from: c */
    private InputStream f10088c;

    /* renamed from: d */
    private OutputStream f10089d;

    /* renamed from: e */
    private MessageStream f10090e = null;

    /* renamed from: f */
    private ReadByteDataStream f10091f;

    public RemoteClientDiagnoseDataStreamProcessor(ReadByteDataStream readByteDataStream, IPhysics iPhysics, InputStream inputStream, OutputStream outputStream) {
        this.f10088c = inputStream;
        this.f10089d = outputStream;
        this.f10087b = iPhysics;
        this.f10091f = readByteDataStream;
    }

    /* renamed from: a */
    public final void m8194a() {
        if (C1856n.f10135a) {
            C1856n.m8130a(f10086a, "RemoteClientDiagnoseDataStreamProcessor  dataItemProcess() ");
        }
        if (this.f10090e == null) {
            this.f10090e = new MessageStream();
        }
        this.f10090e.mo8192a(this.f10091f.f10077c, 0, this.f10091f.f10075a);
        while (true) {
            RemoteMessage m8210a = this.f10090e.m8210a();
            if (m8210a == null) {
                return;
            }
            String m8173b = ByteHexHelper.m8173b(m8210a.m8205b());
            if (C1856n.f10135a) {
                C1856n.m8130a(f10086a, "remoteClientDiagnoseModeProcess  result = ".concat(String.valueOf(m8173b)));
            }
            this.f10087b.setCommand(m8173b);
        }
    }
}
