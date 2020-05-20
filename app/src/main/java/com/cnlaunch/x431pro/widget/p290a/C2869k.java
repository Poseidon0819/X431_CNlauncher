package com.cnlaunch.x431pro.widget.p290a;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.k */
/* loaded from: classes.dex */
final class C2869k extends Thread {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2868j f16455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2869k(View$OnClickListenerC2868j view$OnClickListenerC2868j) {
        this.f16455a = view$OnClickListenerC2868j;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            threadPoolExecutor = this.f16455a.f16454a.f16413C;
            threadPoolExecutor.awaitTermination(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoadDialog.m4681b(this.f16455a.f16454a.f16441t);
        this.f16455a.f16454a.f16419I.sendMessage(this.f16455a.f16454a.f16419I.obtainMessage(10, 1, 0));
    }
}
