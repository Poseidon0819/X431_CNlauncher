package com.mopub.nativeads;

import android.os.Handler;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;

/* renamed from: com.mopub.nativeads.a */
/* loaded from: classes2.dex */
final class ClientPositioningSource implements PositioningSource {

    /* renamed from: a */
    final MoPubNativeAdPositioning.MoPubClientPositioning f21042a;

    /* renamed from: b */
    private final Handler f21043b = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientPositioningSource(MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        this.f21042a = MoPubNativeAdPositioning.m2143a(moPubClientPositioning);
    }

    @Override // com.mopub.nativeads.PositioningSource
    public final void loadPositions(String str, PositioningSource.PositioningListener positioningListener) {
        this.f21043b.post(new RunnableC3879b(this, positioningListener));
    }
}
