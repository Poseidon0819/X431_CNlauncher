package com.cnlaunch.golo3.view.selectimg.clip;

/* compiled from: ClipImageActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.a */
/* loaded from: classes.dex */
final class RunnableC1638a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ClipImageActivity f8670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1638a(ClipImageActivity clipImageActivity) {
        this.f8670a = clipImageActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r11 = this;
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageView r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9053b(r0)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r1 = r11.f8670a
            int r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9057a(r1)
            r0.setMaxOutputWidth(r1)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            java.lang.String r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9050c(r0)
            int r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9055a(r1)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9056a(r0, r1)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            int r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9048d(r0)
            r1 = 0
            r2 = 1
            r3 = 90
            if (r0 == r3) goto L35
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            int r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9048d(r0)
            r3 = 270(0x10e, float:3.78E-43)
            if (r0 != r3) goto L33
            goto L35
        L33:
            r0 = 0
            goto L36
        L35:
            r0 = 1
        L36:
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options
            r3.<init>()
            r3.inJustDecodeBounds = r2
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r2 = r11.f8670a
            java.lang.String r2 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9050c(r2)
            android.graphics.BitmapFactory.decodeFile(r2, r3)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r2 = r11.f8670a
            int r4 = r3.outWidth
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9052b(r2, r4)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r2 = r11.f8670a
            int r4 = r3.outHeight
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9049c(r2, r4)
            if (r0 == 0) goto L59
            int r0 = r3.outHeight
            goto L5b
        L59:
            int r0 = r3.outWidth
        L5b:
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r2 = r11.f8670a
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageView r4 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9053b(r2)
            android.graphics.Rect r4 = r4.getClipBorder()
            int r4 = r4.width()
            int r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9058a(r0, r4)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9047d(r2, r0)
            r3.inJustDecodeBounds = r1
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            int r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9046e(r0)
            r3.inSampleSize = r0
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.RGB_565
            r3.inPreferredConfig = r0
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r0 = r11.f8670a
            java.lang.String r0 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9050c(r0)
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r3)
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r1 = r11.f8670a
            int r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9048d(r1)
            if (r1 != 0) goto L91
            goto Lbc
        L91:
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r1 = r11.f8670a
            int r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9048d(r1)
            float r1 = (float) r1
            r9.postRotate(r1)
            r5 = 0
            r6 = 0
            int r7 = r0.getWidth()
            int r8 = r0.getHeight()
            r10 = 0
            r4 = r0
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            if (r1 == r0) goto Lbb
            boolean r2 = r0.isRecycled()
            if (r2 != 0) goto Lbb
            r0.recycle()
        Lbb:
            r0 = r1
        Lbc:
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity r1 = r11.f8670a
            com.cnlaunch.golo3.view.selectimg.clip.ClipImageView r1 = com.cnlaunch.golo3.view.selectimg.clip.ClipImageActivity.m9053b(r1)
            r1.setImageBitmap(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.view.selectimg.clip.RunnableC1638a.run():void");
    }
}
