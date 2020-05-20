package com.mopub.nativeads;

import com.mopub.nativeads.NativeAdSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubStreamAdPlacer.java */
/* renamed from: com.mopub.nativeads.ad */
/* loaded from: classes2.dex */
public final class C3860ad implements NativeAdSource.InterfaceC3862a {

    /* renamed from: a */
    final /* synthetic */ MoPubStreamAdPlacer f21046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3860ad(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        this.f21046a = moPubStreamAdPlacer;
    }

    @Override // com.mopub.nativeads.NativeAdSource.InterfaceC3862a
    public final void onAdsAvailable() {
        MoPubStreamAdPlacer moPubStreamAdPlacer = this.f21046a;
        if (moPubStreamAdPlacer.f20893d) {
            moPubStreamAdPlacer.m2135a();
            return;
        }
        if (moPubStreamAdPlacer.f20890a) {
            moPubStreamAdPlacer.m2130a(moPubStreamAdPlacer.f20891b);
        }
        moPubStreamAdPlacer.f20892c = true;
    }
}
