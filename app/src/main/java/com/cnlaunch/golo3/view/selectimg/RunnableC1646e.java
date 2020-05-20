package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.e */
/* loaded from: classes.dex */
final class RunnableC1646e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f8677a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f8678b;

    /* renamed from: c */
    final /* synthetic */ RunnableC1645d f8679c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1646e(RunnableC1645d runnableC1645d, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f8679c = runnableC1645d;
        this.f8677a = bitmap;
        this.f8678b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        CropImageView cropImageView;
        CropImageView cropImageView2;
        CropImageView cropImageView3;
        Bitmap bitmap2;
        Bitmap bitmap3 = this.f8677a;
        bitmap = this.f8679c.f8676a.f8563i;
        if (bitmap3 != bitmap && this.f8677a != null) {
            cropImageView3 = this.f8679c.f8676a.f8562h;
            cropImageView3.setImageBitmapResetBase$1fdc9e65(this.f8677a);
            bitmap2 = this.f8679c.f8676a.f8563i;
            bitmap2.recycle();
            this.f8679c.f8676a.f8563i = this.f8677a;
        }
        cropImageView = this.f8679c.f8676a.f8562h;
        if (cropImageView.getScale() == 1.0f) {
            cropImageView2 = this.f8679c.f8676a.f8562h;
            cropImageView2.m9023a();
        }
        this.f8678b.countDown();
    }
}
