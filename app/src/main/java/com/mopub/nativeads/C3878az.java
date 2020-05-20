package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.volley.Response;

/* compiled from: ServerPositioningSource.java */
/* renamed from: com.mopub.nativeads.az */
/* loaded from: classes2.dex */
final class C3878az implements Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> {

    /* renamed from: a */
    final /* synthetic */ ServerPositioningSource f21105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3878az(ServerPositioningSource serverPositioningSource) {
        this.f21105a = serverPositioningSource;
    }

    @Override // com.mopub.volley.Response.Listener
    public final void onResponse(MoPubNativeAdPositioning.MoPubClientPositioning moPubClientPositioning) {
        ServerPositioningSource serverPositioningSource = this.f21105a;
        if (serverPositioningSource.f21098e != null) {
            serverPositioningSource.f21098e.onLoad(moPubClientPositioning);
        }
        serverPositioningSource.f21098e = null;
        serverPositioningSource.f21099f = 0;
    }
}
