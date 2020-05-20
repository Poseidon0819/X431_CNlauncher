package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

/* compiled from: NativeImageHelper.java */
/* renamed from: com.mopub.nativeads.am */
/* loaded from: classes2.dex */
final class C3869am implements ImageLoader.ImageListener {

    /* renamed from: a */
    final /* synthetic */ ImageView f21074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3869am(ImageView imageView) {
        this.f21074a = imageView;
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
        if (!z) {
            MoPubLog.m2498d("Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
        }
        this.f21074a.setImageBitmap(imageContainer.getBitmap());
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2497d("Failed to load image.", volleyError);
        this.f21074a.setImageDrawable(null);
    }
}
