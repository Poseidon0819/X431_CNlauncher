package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

/* compiled from: VastVideoCloseButtonWidget.java */
/* renamed from: com.mopub.mobileads.au */
/* loaded from: classes.dex */
final class C3755au implements ImageLoader.ImageListener {

    /* renamed from: a */
    final /* synthetic */ String f20541a;

    /* renamed from: b */
    final /* synthetic */ VastVideoCloseButtonWidget f20542b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3755au(VastVideoCloseButtonWidget vastVideoCloseButtonWidget, String str) {
        this.f20542b = vastVideoCloseButtonWidget;
        this.f20541a = str;
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
        ImageView imageView;
        Bitmap bitmap = imageContainer.getBitmap();
        if (bitmap == null) {
            MoPubLog.m2498d(String.format("%s returned null bitmap", this.f20541a));
            return;
        }
        imageView = this.f20542b.f20424c;
        imageView.setImageBitmap(bitmap);
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2497d("Failed to load image.", volleyError);
    }
}
