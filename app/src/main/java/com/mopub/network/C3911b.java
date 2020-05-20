package com.mopub.network;

import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRequestQueue.java */
/* renamed from: com.mopub.network.b */
/* loaded from: classes2.dex */
public final class C3911b implements RequestQueue.RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Request f21232a;

    /* renamed from: b */
    final /* synthetic */ MoPubRequestQueue f21233b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3911b(MoPubRequestQueue moPubRequestQueue, Request request) {
        this.f21233b = moPubRequestQueue;
        this.f21232a = request;
    }

    @Override // com.mopub.volley.RequestQueue.RequestFilter
    public final boolean apply(Request<?> request) {
        return this.f21232a == request;
    }
}
