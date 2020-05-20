package com.launch.p353a.p359f;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.launch.p353a.p357d.BitmapCacheUtils;
import com.launch.p353a.p361h.RunnableC3664e;
import com.launch.p353a.p362i.ImageLoaderListener;
import com.launch.p353a.p364k.C3666c;
import com.launch.p353a.p364k.C3669j;
import java.io.File;

/* renamed from: com.launch.a.f.e */
/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: c */
    private static ImageManager f19948c;

    /* renamed from: a */
    public ImageLoaderListener f19949a = null;

    /* renamed from: b */
    private Bitmap f19950b = null;

    /* renamed from: d */
    private Context f19951d;

    public ImageManager(Context context) {
        this.f19951d = null;
        this.f19951d = context;
    }

    /* renamed from: a */
    public final void m2659a(String str, ImageView imageView) {
        Bitmap m2702a = BitmapCacheUtils.m2703a().m2702a(C3669j.m2621a(str));
        if (m2702a != null) {
            ImageLoaderListener imageLoaderListener = this.f19949a;
            if (imageLoaderListener != null) {
                imageLoaderListener.mo2648a(m2702a);
                return;
            }
            return;
        }
        File file = new File(C3666c.m2643a() + "/" + C3669j.m2621a(str));
        if (!file.exists()) {
            m2658a(str, imageView, file);
            return;
        }
        Bitmap m2642a = C3666c.m2642a(file);
        if (m2642a != null) {
            ImageLoaderListener imageLoaderListener2 = this.f19949a;
            if (imageLoaderListener2 != null) {
                imageLoaderListener2.mo2648a(m2642a);
            }
            BitmapCacheUtils.m2703a().m2701a(C3669j.m2621a(str), m2642a);
            return;
        }
        m2658a(str, imageView, file);
    }

    /* renamed from: a */
    private void m2658a(String str, ImageView imageView, File file) {
        RunnableC3664e runnableC3664e = new RunnableC3664e(this.f19951d);
        runnableC3664e.f19880c = str;
        runnableC3664e.f19961f = new C3660f(this, imageView, str, file);
        runnableC3664e.m2654a();
    }
}
