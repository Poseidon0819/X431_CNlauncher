package com.cnlaunch.p188n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteSocketControler.java */
/* renamed from: com.cnlaunch.n.e */
/* loaded from: classes.dex */
public final class C1807e extends Thread {

    /* renamed from: a */
    final /* synthetic */ boolean f9656a;

    /* renamed from: b */
    final /* synthetic */ boolean f9657b;

    /* renamed from: c */
    final /* synthetic */ int f9658c;

    /* renamed from: d */
    final /* synthetic */ RemoteSocketControler f9659d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1807e(RemoteSocketControler remoteSocketControler, boolean z, boolean z2, int i) {
        this.f9659d = remoteSocketControler;
        this.f9656a = z;
        this.f9657b = z2;
        this.f9658c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            super.run()
            com.cnlaunch.n.b r0 = r7.f9659d
            java.util.concurrent.locks.Lock r0 = r0.f9674j
            r0.lock()
            com.cnlaunch.n.b r0 = r7.f9659d
            com.cnlaunch.n.c.d r0 = r0.f9678n
            if (r0 == 0) goto L1c
            com.cnlaunch.n.b r0 = r7.f9659d     // Catch: java.lang.Exception -> L18
            com.cnlaunch.n.c.d r0 = r0.f9678n     // Catch: java.lang.Exception -> L18
            r0.m8523b()     // Catch: java.lang.Exception -> L18
            goto L1c
        L18:
            r0 = move-exception
            r0.printStackTrace()
        L1c:
            com.cnlaunch.n.b r0 = r7.f9659d
            r1 = 0
            r0.f9675k = r1
            boolean r0 = r7.f9656a
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L94
            int r0 = com.cnlaunch.p188n.p191c.RemoteConstants.f9649a
            if (r0 == r3) goto L37
            com.cnlaunch.n.b r0 = r7.f9659d
            java.lang.String r0 = com.cnlaunch.p188n.RemoteSocketControler.m8603a(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6e
        L37:
            boolean r0 = r7.f9657b
            if (r0 == 0) goto L58
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.core.session.IoSession r0 = r0.f9671g
            com.cnlaunch.n.b.i r4 = new com.cnlaunch.n.b.i
            r4.<init>()
            com.cnlaunch.n.b.g r4 = r4.m8567i()
            byte[] r4 = r4.getData()
            org.apache.mina.core.buffer.IoBuffer r4 = org.apache.mina.core.buffer.IoBuffer.wrap(r4)
            org.apache.mina.core.future.WriteFuture r0 = r0.write(r4)
            r0.awaitUninterruptibly()
            goto L6a
        L58:
            com.cnlaunch.n.b r0 = r7.f9659d
            com.cnlaunch.n.b.i r4 = new com.cnlaunch.n.b.i
            r4.<init>()
            r5 = 133(0x85, float:1.86E-43)
            int r6 = r7.f9658c
            com.cnlaunch.n.b.g r4 = r4.m8573a(r5, r6)
            r0.m8507a(r4, r1)
        L6a:
            com.cnlaunch.p188n.p191c.RemoteConstants.f9649a = r1
            com.cnlaunch.p188n.p191c.RemoteConstants.f9650b = r3
        L6e:
            com.cnlaunch.n.b r0 = r7.f9659d
            com.cnlaunch.n.b.o r0 = r0.f9672h
            if (r0 == 0) goto L90
            com.cnlaunch.n.b r0 = r7.f9659d
            com.cnlaunch.n.b.o r0 = r0.f9672h
            boolean r0 = r0.f9616c
            if (r0 == 0) goto L90
            com.cnlaunch.n.b r0 = r7.f9659d
            java.lang.String r0 = r0.f9669e
            java.lang.String r1 = "------> mSendChecker.destory"
            com.cnlaunch.p188n.p191c.MLog.m8520c(r0, r1)
            com.cnlaunch.n.b r0 = r7.f9659d
            com.cnlaunch.n.b.o r0 = r0.f9672h
            r0.mo8536b()
            com.cnlaunch.n.b r0 = r7.f9659d
            r0.f9672h = r2
        L90:
            com.cnlaunch.n.b r0 = r7.f9659d
            r0.f9687w = r3
        L94:
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.core.session.IoSession r0 = r0.f9671g
            if (r0 == 0) goto Lba
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.core.session.IoSession r0 = r0.f9671g
            r0.close(r3)
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.core.session.IoSession r0 = r0.f9671g
            org.apache.mina.core.service.IoService r0 = r0.getService()
            if (r0 == 0) goto Lb6
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.core.session.IoSession r0 = r0.f9671g
            org.apache.mina.core.service.IoService r0 = r0.getService()
            r0.dispose()
        Lb6:
            com.cnlaunch.n.b r0 = r7.f9659d
            r0.f9671g = r2
        Lba:
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.transport.socket.nio.NioSocketConnector r0 = r0.f9673i
            if (r0 == 0) goto Lcb
            com.cnlaunch.n.b r0 = r7.f9659d
            org.apache.mina.transport.socket.nio.NioSocketConnector r0 = r0.f9673i
            r0.dispose()
            com.cnlaunch.n.b r0 = r7.f9659d
            r0.f9673i = r2
        Lcb:
            com.cnlaunch.n.b r0 = r7.f9659d
            java.lang.String r0 = r0.f9669e
            java.lang.String r1 = "------> end<------"
            com.cnlaunch.p188n.p191c.MLog.m8520c(r0, r1)
            com.cnlaunch.n.b r0 = r7.f9659d
            java.util.concurrent.locks.Lock r0 = r0.f9674j
            r0.unlock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p188n.C1807e.run():void");
    }
}
