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

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.af */
/* loaded from: classes.dex */
final class RunnableC2307af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HandlerC2306ae f13414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2307af(HandlerC2306ae handlerC2306ae) {
        this.f13414a = handlerC2306ae;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        String str2;
        Handler handler;
        try {
            try {
                str = this.f13414a.f13413a.f13195bm;
                this.f13414a.f13413a.f13190bh = Drawable.createFromStream(new URL(str).openStream(), null);
                drawable = this.f13414a.f13413a.f13190bh;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                drawable2 = this.f13414a.f13413a.f13190bh;
                int intrinsicHeight = drawable2.getIntrinsicHeight();
                drawable3 = this.f13414a.f13413a.f13190bh;
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable3.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                drawable4 = this.f13414a.f13413a.f13190bh;
                drawable4.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable5 = this.f13414a.f13413a.f13190bh;
                drawable5.draw(canvas);
                StringBuilder sb = new StringBuilder();
                sb.append(PathUtils.m4846j());
                str2 = this.f13414a.f13413a.f13196bn;
                sb.append(str2);
                FileUtils.m5023a(createBitmap, sb.toString());
                handler = this.f13414a.f13413a.f13208bz;
                handler.sendEmptyMessage(3);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
