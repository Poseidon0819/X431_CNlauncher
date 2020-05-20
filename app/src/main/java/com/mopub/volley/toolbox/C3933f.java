package com.mopub.volley.toolbox;

import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkImageView.java */
/* renamed from: com.mopub.volley.toolbox.f */
/* loaded from: classes2.dex */
public final class C3933f implements ImageLoader.ImageListener {

    /* renamed from: a */
    final /* synthetic */ boolean f21367a;

    /* renamed from: b */
    final /* synthetic */ NetworkImageView f21368b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3933f(NetworkImageView networkImageView, boolean z) {
        this.f21368b = networkImageView;
        this.f21367a = z;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        int i;
        int i2;
        i = this.f21368b.f21350c;
        if (i != 0) {
            NetworkImageView networkImageView = this.f21368b;
            i2 = networkImageView.f21350c;
            networkImageView.setImageResource(i2);
        }
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
        int i;
        int i2;
        if (z && this.f21367a) {
            this.f21368b.post(new RunnableC3934g(this, imageContainer));
        } else if (imageContainer.getBitmap() == null) {
            i = this.f21368b.f21349b;
            if (i != 0) {
                NetworkImageView networkImageView = this.f21368b;
                i2 = networkImageView.f21349b;
                networkImageView.setImageResource(i2);
            }
        } else {
            this.f21368b.setImageBitmap(imageContainer.getBitmap());
        }
    }
}
