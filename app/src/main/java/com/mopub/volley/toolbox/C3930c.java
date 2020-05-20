package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.ImageLoader;

/* compiled from: ImageLoader.java */
/* renamed from: com.mopub.volley.toolbox.c */
/* loaded from: classes2.dex */
final class C3930c implements Response.Listener<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ String f21362a;

    /* renamed from: b */
    final /* synthetic */ ImageLoader f21363b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3930c(ImageLoader imageLoader, String str) {
        this.f21363b = imageLoader;
        this.f21362a = str;
    }

    @Override // com.mopub.volley.Response.Listener
    public final void onResponse(Bitmap bitmap) {
        ImageLoader imageLoader = this.f21363b;
        String str = this.f21362a;
        imageLoader.f21323a.putBitmap(str, bitmap);
        ImageLoader.C3927a remove = imageLoader.f21324b.remove(str);
        if (remove != null) {
            remove.f21335a = bitmap;
            imageLoader.m1985a(str, remove);
        }
    }
}
