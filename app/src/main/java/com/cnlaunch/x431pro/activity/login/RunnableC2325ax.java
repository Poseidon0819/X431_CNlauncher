package com.cnlaunch.x431pro.activity.login;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ax */
/* loaded from: classes.dex */
final class RunnableC2325ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HandlerC2324aw f13432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2325ax(HandlerC2324aw handlerC2324aw) {
        this.f13432a = handlerC2324aw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Handler handler;
        try {
            try {
                try {
                    this.f13432a.f13431a.f13245aL = Drawable.createFromStream(new URL(this.f13432a.f13431a.f13210C).openStream(), null);
                    drawable = this.f13432a.f13431a.f13245aL;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    drawable2 = this.f13432a.f13431a.f13245aL;
                    int intrinsicHeight = drawable2.getIntrinsicHeight();
                    drawable3 = this.f13432a.f13431a.f13245aL;
                    Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable3.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    drawable4 = this.f13432a.f13431a.f13245aL;
                    drawable4.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable5 = this.f13432a.f13431a.f13245aL;
                    drawable5.draw(canvas);
                    FileUtils.m5023a(createBitmap, PathUtils.m4846j() + this.f13432a.f13431a.f13211D);
                    handler = this.f13432a.f13431a.f13249aP;
                    handler.sendEmptyMessage(3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
