package com.mopub.nativeads;

/* compiled from: NativeAdSource.java */
/* renamed from: com.mopub.nativeads.ag */
/* loaded from: classes2.dex */
final class RunnableC3863ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NativeAdSource f21061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3863ag(NativeAdSource nativeAdSource) {
        this.f21061a = nativeAdSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativeAdSource nativeAdSource = this.f21061a;
        nativeAdSource.f21051d = false;
        nativeAdSource.m2088c();
    }
}
