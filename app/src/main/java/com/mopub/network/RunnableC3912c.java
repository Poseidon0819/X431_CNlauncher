package com.mopub.network;

import com.mopub.network.MoPubRequestQueue;
import com.mopub.volley.Request;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRequestQueue.java */
/* renamed from: com.mopub.network.c */
/* loaded from: classes2.dex */
public final class RunnableC3912c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubRequestQueue f21234a;

    /* renamed from: b */
    final /* synthetic */ Request f21235b;

    /* renamed from: c */
    final /* synthetic */ MoPubRequestQueue.C3909a f21236c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3912c(MoPubRequestQueue.C3909a c3909a, MoPubRequestQueue moPubRequestQueue, Request request) {
        this.f21236c = c3909a;
        this.f21234a = moPubRequestQueue;
        this.f21235b = request;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        map = MoPubRequestQueue.this.f21209a;
        map.remove(this.f21235b);
        MoPubRequestQueue.this.add(this.f21235b);
    }
}
