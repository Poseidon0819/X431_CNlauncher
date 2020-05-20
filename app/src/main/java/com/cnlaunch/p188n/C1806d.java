package com.cnlaunch.p188n;

import com.cnlaunch.p188n.p191c.MLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteSocketControler.java */
/* renamed from: com.cnlaunch.n.d */
/* loaded from: classes.dex */
public final class C1806d extends Thread {

    /* renamed from: a */
    final /* synthetic */ RemoteSocketControler f9655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1806d(RemoteSocketControler remoteSocketControler) {
        this.f9655a = remoteSocketControler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        try {
            this.f9655a.m8506a(this.f9655a.f9685u, this.f9655a.f9686v, 22);
        } catch (Exception e) {
            String str = this.f9655a.f9669e;
            MLog.m8521b(str, "connect error:" + e.toString());
            e.printStackTrace();
        }
    }
}
