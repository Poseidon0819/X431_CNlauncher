package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: CropImage.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.g */
/* loaded from: classes.dex */
final class RunnableC1648g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RunnableC1647f f8685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1648g(RunnableC1647f runnableC1647f) {
        this.f8685a = runnableC1647f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CropImageView cropImageView;
        Bitmap bitmap;
        Bitmap bitmap2;
        CropImageView cropImageView2;
        CropImageView cropImageView3;
        CropImageView cropImageView4;
        CropImageView cropImageView5;
        this.f8685a.f8684e.f8557c = this.f8685a.f8683d > 1;
        RunnableC1647f runnableC1647f = this.f8685a;
        cropImageView = runnableC1647f.f8684e.f8562h;
        HighlightView highlightView = new HighlightView(cropImageView);
        bitmap = runnableC1647f.f8684e.f8563i;
        int width = bitmap.getWidth();
        bitmap2 = runnableC1647f.f8684e.f8563i;
        int height = bitmap2.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int min = (Math.min(width, height) * 4) / 5;
        int i = (width - min) / 2;
        int i2 = (height - min) / 2;
        highlightView.m9026a(runnableC1647f.f8681b, rect, new RectF(i, i2, i + min, i2 + min));
        cropImageView2 = runnableC1647f.f8684e.f8562h;
        cropImageView2.m9099a(highlightView);
        cropImageView3 = this.f8685a.f8684e.f8562h;
        cropImageView3.invalidate();
        cropImageView4 = this.f8685a.f8684e.f8562h;
        if (cropImageView4.f8538a.size() > 0) {
            CropImage cropImage = this.f8685a.f8684e;
            cropImageView5 = this.f8685a.f8684e.f8562h;
            cropImage.f8559e = cropImageView5.f8538a.get(0);
            this.f8685a.f8684e.f8559e.f8698b = true;
        }
    }
}
