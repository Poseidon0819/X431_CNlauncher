package com.mopub.nativeads;

import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import com.mopub.nativeads.NativeImageHelper;

/* compiled from: MoPubCustomEventNative.java */
/* renamed from: com.mopub.nativeads.m */
/* loaded from: classes2.dex */
final class C3894m implements NativeImageHelper.ImageListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventNative.C3841a f21160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3894m(MoPubCustomEventNative.C3841a c3841a) {
        this.f21160a = c3841a;
    }

    @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
    public final void onImagesCached() {
        CustomEventNative.CustomEventNativeListener customEventNativeListener;
        customEventNativeListener = this.f21160a.f20826e;
        customEventNativeListener.onNativeAdLoaded(this.f21160a);
    }

    @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
    public final void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
        CustomEventNative.CustomEventNativeListener customEventNativeListener;
        customEventNativeListener = this.f21160a.f20826e;
        customEventNativeListener.onNativeAdFailed(nativeErrorCode);
    }
}
