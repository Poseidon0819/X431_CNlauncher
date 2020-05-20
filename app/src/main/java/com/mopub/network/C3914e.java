package com.mopub.network;

import android.graphics.Bitmap;
import android.support.p012v4.p019d.LruCache;
import com.mopub.volley.toolbox.ImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Networking.java */
/* renamed from: com.mopub.network.e */
/* loaded from: classes2.dex */
public final class C3914e implements ImageLoader.ImageCache {

    /* renamed from: a */
    final /* synthetic */ LruCache f21237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3914e(LruCache lruCache) {
        this.f21237a = lruCache;
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageCache
    public final Bitmap getBitmap(String str) {
        return (Bitmap) this.f21237a.get(str);
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageCache
    public final void putBitmap(String str, Bitmap bitmap) {
        this.f21237a.put(str, bitmap);
    }
}
