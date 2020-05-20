package com.mopub.volley;

import com.mopub.volley.RequestQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestQueue.java */
/* renamed from: com.mopub.volley.d */
/* loaded from: classes2.dex */
public final class C3924d implements RequestQueue.RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Object f21297a;

    /* renamed from: b */
    final /* synthetic */ RequestQueue f21298b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3924d(RequestQueue requestQueue, Object obj) {
        this.f21298b = requestQueue;
        this.f21297a = obj;
    }

    @Override // com.mopub.volley.RequestQueue.RequestFilter
    public final boolean apply(Request<?> request) {
        return request.getTag() == this.f21297a;
    }
}
