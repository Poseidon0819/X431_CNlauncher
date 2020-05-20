package com.cnlaunch.p188n;

/* compiled from: SocketControler.java */
/* renamed from: com.cnlaunch.n.l */
/* loaded from: classes.dex */
final class RunnableC1812l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SocketControler f9689a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1812l(SocketControler socketControler) {
        this.f9689a = socketControler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(10000L);
            if (this.f9689a.f9687w) {
                return;
            }
            this.f9689a.f9676l++;
            this.f9689a.mo8509a(4355);
            this.f9689a.mo8502f();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
