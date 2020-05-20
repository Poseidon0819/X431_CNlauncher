package com.mopub.nativeads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubStreamAdPlacer.java */
/* renamed from: com.mopub.nativeads.ab */
/* loaded from: classes2.dex */
public final class RunnableC3858ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubStreamAdPlacer f21044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3858ab(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        this.f21044a = moPubStreamAdPlacer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.f21044a.f20907s;
        if (z) {
            this.f21044a.m2129b();
            MoPubStreamAdPlacer.m2127c(this.f21044a);
        }
    }
}
