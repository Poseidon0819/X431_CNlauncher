package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNative;

/* compiled from: MoPubNative.java */
/* renamed from: com.mopub.nativeads.u */
/* loaded from: classes2.dex */
final class C3902u implements MoPubNative.MoPubNativeNetworkListener {
    @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
    public final void onNativeFail(NativeErrorCode nativeErrorCode) {
    }

    @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
    public final void onNativeLoad(NativeAd nativeAd) {
        nativeAd.destroy();
    }
}
