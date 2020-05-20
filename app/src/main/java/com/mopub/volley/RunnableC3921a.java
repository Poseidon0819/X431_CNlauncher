package com.mopub.volley;

import java.util.concurrent.BlockingQueue;

/* compiled from: CacheDispatcher.java */
/* renamed from: com.mopub.volley.a */
/* loaded from: classes2.dex */
final class RunnableC3921a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Request f21290a;

    /* renamed from: b */
    final /* synthetic */ CacheDispatcher f21291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3921a(CacheDispatcher cacheDispatcher, Request request) {
        this.f21291b = cacheDispatcher;
        this.f21290a = request;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f21291b.f21245c;
            blockingQueue.put(this.f21290a);
        } catch (InterruptedException unused) {
        }
    }
}
