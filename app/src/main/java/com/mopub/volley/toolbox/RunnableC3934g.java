package com.mopub.volley.toolbox;

import com.mopub.volley.toolbox.ImageLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkImageView.java */
/* renamed from: com.mopub.volley.toolbox.g */
/* loaded from: classes2.dex */
public final class RunnableC3934g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageLoader.ImageContainer f21369a;

    /* renamed from: b */
    final /* synthetic */ C3933f f21370b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3934g(C3933f c3933f, ImageLoader.ImageContainer imageContainer) {
        this.f21370b = c3933f;
        this.f21369a = imageContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21370b.onResponse(this.f21369a, false);
    }
}
