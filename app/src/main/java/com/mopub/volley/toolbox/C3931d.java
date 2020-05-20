package com.mopub.volley.toolbox;

import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

/* compiled from: ImageLoader.java */
/* renamed from: com.mopub.volley.toolbox.d */
/* loaded from: classes2.dex */
final class C3931d implements Response.ErrorListener {

    /* renamed from: a */
    final /* synthetic */ String f21364a;

    /* renamed from: b */
    final /* synthetic */ ImageLoader f21365b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3931d(ImageLoader imageLoader, String str) {
        this.f21365b = imageLoader;
        this.f21364a = str;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        ImageLoader imageLoader = this.f21365b;
        String str = this.f21364a;
        ImageLoader.C3927a remove = imageLoader.f21324b.remove(str);
        if (remove != null) {
            remove.setError(volleyError);
            imageLoader.m1985a(str, remove);
        }
    }
}
