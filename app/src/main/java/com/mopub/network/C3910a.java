package com.mopub.network;

import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;

/* compiled from: MoPubRequestQueue.java */
/* renamed from: com.mopub.network.a */
/* loaded from: classes2.dex */
final class C3910a implements RequestQueue.RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Object f21230a;

    /* renamed from: b */
    final /* synthetic */ MoPubRequestQueue f21231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3910a(MoPubRequestQueue moPubRequestQueue, Object obj) {
        this.f21231b = moPubRequestQueue;
        this.f21230a = obj;
    }

    @Override // com.mopub.volley.RequestQueue.RequestFilter
    public final boolean apply(Request<?> request) {
        return request.getTag() == this.f21230a;
    }
}
