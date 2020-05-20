package com.mopub.volley.toolbox;

import com.mopub.volley.toolbox.ImageLoader;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoader.java */
/* renamed from: com.mopub.volley.toolbox.e */
/* loaded from: classes2.dex */
public final class RunnableC3932e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageLoader f21366a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3932e(ImageLoader imageLoader) {
        this.f21366a = imageLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageLoader.ImageListener imageListener;
        ImageLoader.ImageListener imageListener2;
        ImageLoader.ImageListener imageListener3;
        for (ImageLoader.C3927a c3927a : this.f21366a.f21327e.values()) {
            Iterator<ImageLoader.ImageContainer> it = c3927a.f21336b.iterator();
            while (it.hasNext()) {
                ImageLoader.ImageContainer next = it.next();
                imageListener = next.f21332c;
                if (imageListener != null) {
                    if (c3927a.getError() == null) {
                        next.f21331b = c3927a.f21335a;
                        imageListener2 = next.f21332c;
                        imageListener2.onResponse(next, false);
                    } else {
                        imageListener3 = next.f21332c;
                        imageListener3.onErrorResponse(c3927a.getError());
                    }
                }
            }
        }
        this.f21366a.f21327e.clear();
        ImageLoader.m1983c(this.f21366a);
    }
}
