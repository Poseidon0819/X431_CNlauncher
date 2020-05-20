package com.cnlaunch.golo3.view.selectimg;

import com.cnlaunch.golo3.view.selectimg.CropImage;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.h */
/* loaded from: classes.dex */
final class RunnableC1649h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f8686a;

    /* renamed from: b */
    final /* synthetic */ CropImage.RunnableC1624a f8687b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1649h(CropImage.RunnableC1624a runnableC1624a, CountDownLatch countDownLatch) {
        this.f8687b = runnableC1624a;
        this.f8686a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8687b.f8565a.sendMessage(this.f8687b.f8565a.obtainMessage(2000));
        } catch (Exception unused) {
        }
        this.f8686a.countDown();
    }
}
