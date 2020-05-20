package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import android.os.Handler;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.d */
/* loaded from: classes.dex */
final class RunnableC1645d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f8676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1645d(CropImage cropImage) {
        this.f8676a = cropImage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        Handler handler;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        bitmap = this.f8676a.f8563i;
        handler = this.f8676a.f8561g;
        handler.post(new RunnableC1646e(this, bitmap, countDownLatch));
        try {
            countDownLatch.await();
            this.f8676a.f8564j.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
