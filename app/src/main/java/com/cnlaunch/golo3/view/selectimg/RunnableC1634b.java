package com.cnlaunch.golo3.view.selectimg;

import android.os.Handler;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.b */
/* loaded from: classes.dex */
public final class RunnableC1634b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f8619a;

    /* renamed from: b */
    final /* synthetic */ CropImage f8620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1634b(CropImage cropImage, float f) {
        this.f8620b = cropImage;
        this.f8619a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        handler = this.f8620b.f8561g;
        handler.post(new RunnableC1635c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
