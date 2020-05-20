package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubNative;
import com.mopub.network.AdResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubNative.java */
/* renamed from: com.mopub.nativeads.w */
/* loaded from: classes2.dex */
public final class C3904w implements CustomEventNative.CustomEventNativeListener {

    /* renamed from: a */
    final /* synthetic */ AdResponse f21169a;

    /* renamed from: b */
    final /* synthetic */ MoPubNative f21170b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3904w(MoPubNative moPubNative, AdResponse adResponse) {
        this.f21170b = moPubNative;
        this.f21169a = adResponse;
    }

    @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
    public final void onNativeAdLoaded(BaseNativeAd baseNativeAd) {
        MoPubNative.MoPubNativeNetworkListener moPubNativeNetworkListener;
        String str;
        Context m2148a = this.f21170b.m2148a();
        if (m2148a == null) {
            return;
        }
        MoPubAdRenderer rendererForAd = this.f21170b.f20870d.getRendererForAd(baseNativeAd);
        if (rendererForAd != null) {
            moPubNativeNetworkListener = this.f21170b.f20869c;
            String impressionTrackingUrl = this.f21169a.getImpressionTrackingUrl();
            String clickTrackingUrl = this.f21169a.getClickTrackingUrl();
            str = this.f21170b.f20871e;
            moPubNativeNetworkListener.onNativeLoad(new NativeAd(m2148a, impressionTrackingUrl, clickTrackingUrl, str, baseNativeAd, rendererForAd));
            return;
        }
        onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
    }

    @Override // com.mopub.nativeads.CustomEventNative.CustomEventNativeListener
    public final void onNativeAdFailed(NativeErrorCode nativeErrorCode) {
        MoPubLog.m2492v(String.format("Native Ad failed to load with error: %s.", nativeErrorCode));
        this.f21170b.m2145a(this.f21169a.getFailoverUrl());
    }
}
