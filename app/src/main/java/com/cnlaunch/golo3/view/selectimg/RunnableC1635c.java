package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.c */
/* loaded from: classes.dex */
final class RunnableC1635c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CountDownLatch f8621a;

    /* renamed from: b */
    final /* synthetic */ RunnableC1634b f8622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1635c(RunnableC1634b runnableC1634b, CountDownLatch countDownLatch) {
        this.f8622b = runnableC1634b;
        this.f8621a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        CropImageView cropImageView;
        Bitmap bitmap2;
        CropImageView cropImageView2;
        CropImageView cropImageView3;
        try {
            CropImage cropImage = this.f8622b.f8620b;
            bitmap = this.f8622b.f8620b.f8563i;
            cropImage.f8563i = CropImage.m9093a(bitmap, this.f8622b.f8619a);
            cropImageView = this.f8622b.f8620b.f8562h;
            bitmap2 = this.f8622b.f8620b.f8563i;
            cropImageView.m9101a(bitmap2);
            cropImageView2 = this.f8622b.f8620b.f8562h;
            if (cropImageView2.f8538a.size() > 0) {
                CropImage cropImage2 = this.f8622b.f8620b;
                cropImageView3 = this.f8622b.f8620b.f8562h;
                cropImage2.f8559e = cropImageView3.f8538a.get(0);
                this.f8622b.f8620b.f8559e.f8698b = true;
            }
        } catch (Exception unused) {
        }
        this.f8621a.countDown();
    }
}
