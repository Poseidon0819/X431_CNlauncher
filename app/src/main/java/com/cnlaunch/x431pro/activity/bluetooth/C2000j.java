package com.cnlaunch.x431pro.activity.bluetooth;

/* compiled from: DownloadBinActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.j */
/* loaded from: classes.dex */
final class C2000j extends Thread {

    /* renamed from: a */
    final /* synthetic */ HandlerC1999i f10956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2000j(HandlerC1999i handlerC1999i) {
        this.f10956a = handlerC1999i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f10956a.f10955a.m7772e();
    }
}
