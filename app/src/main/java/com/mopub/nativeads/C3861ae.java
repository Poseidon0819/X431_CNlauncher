package com.mopub.nativeads;

import com.mopub.nativeads.BaseNativeAd;
import com.mopub.network.TrackingRequest;

/* compiled from: NativeAd.java */
/* renamed from: com.mopub.nativeads.ae */
/* loaded from: classes2.dex */
final class C3861ae implements BaseNativeAd.NativeEventListener {

    /* renamed from: a */
    final /* synthetic */ NativeAd f21047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3861ae(NativeAd nativeAd) {
        this.f21047a = nativeAd;
    }

    @Override // com.mopub.nativeads.BaseNativeAd.NativeEventListener
    public final void onAdImpressed() {
        NativeAd nativeAd = this.f21047a;
        if (nativeAd.f20914e || nativeAd.f20916g) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(nativeAd.f20911b, nativeAd.f20910a);
        if (nativeAd.f20913d != null) {
            nativeAd.f20913d.onImpression(null);
        }
        nativeAd.f20914e = true;
    }

    @Override // com.mopub.nativeads.BaseNativeAd.NativeEventListener
    public final void onAdClicked() {
        NativeAd nativeAd = this.f21047a;
        if (nativeAd.f20915f || nativeAd.f20916g) {
            return;
        }
        TrackingRequest.makeTrackingHttpRequest(nativeAd.f20912c, nativeAd.f20910a);
        if (nativeAd.f20913d != null) {
            nativeAd.f20913d.onClick(null);
        }
        nativeAd.f20915f = true;
    }
}
