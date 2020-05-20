package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.PositioningSource;
import com.mopub.network.Networking;
import com.mopub.volley.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.ax */
/* loaded from: classes2.dex */
public final class ServerPositioningSource implements PositioningSource {

    /* renamed from: b */
    final Context f21095b;

    /* renamed from: e */
    PositioningSource.PositioningListener f21098e;

    /* renamed from: f */
    int f21099f;

    /* renamed from: i */
    private String f21102i;

    /* renamed from: j */
    private PositioningRequest f21103j;

    /* renamed from: a */
    int f21094a = 300000;

    /* renamed from: c */
    final Handler f21096c = new Handler();

    /* renamed from: d */
    final Runnable f21097d = new RunnableC3877ay(this);

    /* renamed from: g */
    private final Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> f21100g = new C3878az(this);

    /* renamed from: h */
    private final Response.ErrorListener f21101h = new C3880ba(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerPositioningSource(Context context) {
        this.f21095b = context.getApplicationContext();
    }

    @Override // com.mopub.nativeads.PositioningSource
    public final void loadPositions(String str, PositioningSource.PositioningListener positioningListener) {
        PositioningRequest positioningRequest = this.f21103j;
        if (positioningRequest != null) {
            positioningRequest.cancel();
            this.f21103j = null;
        }
        if (this.f21099f > 0) {
            this.f21096c.removeCallbacks(this.f21097d);
            this.f21099f = 0;
        }
        this.f21098e = positioningListener;
        this.f21102i = new PositioningUrlGenerator(this.f21095b).withAdUnitId(str).generateUrlString(Constants.HOST);
        m2068a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2068a() {
        MoPubLog.m2498d("Loading positioning from: " + this.f21102i);
        this.f21103j = new PositioningRequest(this.f21102i, this.f21100g, this.f21101h);
        Networking.getRequestQueue(this.f21095b).add(this.f21103j);
    }
}
