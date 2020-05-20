package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.FaceDetector;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.f */
/* loaded from: classes.dex */
public final class RunnableC1647f implements Runnable {

    /* renamed from: b */
    Matrix f8681b;

    /* renamed from: d */
    int f8683d;

    /* renamed from: e */
    final /* synthetic */ CropImage f8684e;

    /* renamed from: a */
    float f8680a = 1.0f;

    /* renamed from: c */
    FaceDetector.Face[] f8682c = new FaceDetector.Face[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1647f(CropImage cropImage) {
        this.f8684e = cropImage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CropImageView cropImageView;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap createBitmap;
        Bitmap bitmap6;
        Handler handler;
        Bitmap bitmap7;
        cropImageView = this.f8684e.f8562h;
        this.f8681b = cropImageView.getImageMatrix();
        bitmap = this.f8684e.f8563i;
        if (bitmap == null) {
            createBitmap = null;
        } else {
            bitmap2 = this.f8684e.f8563i;
            if (bitmap2.getWidth() > 256) {
                bitmap6 = this.f8684e.f8563i;
                this.f8680a = 256.0f / bitmap6.getWidth();
            }
            Matrix matrix = new Matrix();
            float f = this.f8680a;
            matrix.setScale(f, f);
            bitmap3 = this.f8684e.f8563i;
            bitmap4 = this.f8684e.f8563i;
            int width = bitmap4.getWidth();
            bitmap5 = this.f8684e.f8563i;
            createBitmap = Bitmap.createBitmap(bitmap3, 0, 0, width, bitmap5.getHeight(), matrix, true);
        }
        this.f8680a = 1.0f / this.f8680a;
        if (createBitmap != null) {
            this.f8683d = new FaceDetector(createBitmap.getWidth(), createBitmap.getHeight(), this.f8682c.length).findFaces(createBitmap, this.f8682c);
        }
        if (createBitmap != null) {
            bitmap7 = this.f8684e.f8563i;
            if (createBitmap != bitmap7) {
                createBitmap.recycle();
            }
        }
        handler = this.f8684e.f8561g;
        handler.post(new RunnableC1648g(this));
    }
}
