package com.cnlaunch.x431pro.activity.upgrade;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.h */
/* loaded from: classes.dex */
final class C2686h extends Thread {

    /* renamed from: a */
    final /* synthetic */ C2685g f15413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2686h(C2685g c2685g) {
        this.f15413a = c2685g;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            threadPoolExecutor = this.f15413a.f15412a.f15362N;
            threadPoolExecutor.awaitTermination(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f15413a.f15412a.f15403x.sendMessage(this.f15413a.f15412a.f15403x.obtainMessage(13, 0, 0));
    }
}
