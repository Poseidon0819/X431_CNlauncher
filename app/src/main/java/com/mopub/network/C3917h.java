package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TrackingRequest.java */
/* renamed from: com.mopub.network.h */
/* loaded from: classes2.dex */
public final class C3917h implements TrackingRequest.Listener {

    /* renamed from: a */
    final /* synthetic */ TrackingRequest.Listener f21241a;

    /* renamed from: b */
    final /* synthetic */ String f21242b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3917h(TrackingRequest.Listener listener, String str) {
        this.f21241a = listener;
        this.f21242b = str;
    }

    @Override // com.mopub.network.TrackingRequest.Listener
    public final void onResponse(String str) {
        MoPubLog.m2498d("Successfully hit tracking endpoint: ".concat(String.valueOf(str)));
        TrackingRequest.Listener listener = this.f21241a;
        if (listener != null) {
            listener.onResponse(str);
        }
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        MoPubLog.m2498d("Failed to hit tracking endpoint: " + this.f21242b);
        TrackingRequest.Listener listener = this.f21241a;
        if (listener != null) {
            listener.onErrorResponse(volleyError);
        }
    }
}
