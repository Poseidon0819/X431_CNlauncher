package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.NativeImageHelper;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NativeImageHelper.java */
/* renamed from: com.mopub.nativeads.al */
/* loaded from: classes2.dex */
final class C3868al implements ImageLoader.ImageListener {

    /* renamed from: a */
    final /* synthetic */ AtomicInteger f21071a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f21072b;

    /* renamed from: c */
    final /* synthetic */ NativeImageHelper.ImageListener f21073c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3868al(AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, NativeImageHelper.ImageListener imageListener) {
        this.f21071a = atomicInteger;
        this.f21072b = atomicBoolean;
        this.f21073c = imageListener;
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
        if (imageContainer.getBitmap() == null || this.f21071a.decrementAndGet() != 0 || this.f21072b.get()) {
            return;
        }
        this.f21073c.onImagesCached();
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2497d("Failed to download a native ads image:", volleyError);
        boolean andSet = this.f21072b.getAndSet(true);
        this.f21071a.decrementAndGet();
        if (andSet) {
            return;
        }
        this.f21073c.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
    }
}
