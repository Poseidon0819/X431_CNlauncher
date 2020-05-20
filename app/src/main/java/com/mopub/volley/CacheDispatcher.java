package com.mopub.volley;

import android.os.Process;
import com.mopub.volley.Cache;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class CacheDispatcher extends Thread {

    /* renamed from: a */
    private static final boolean f21243a = VolleyLog.DEBUG;

    /* renamed from: b */
    private final BlockingQueue<Request<?>> f21244b;

    /* renamed from: c */
    private final BlockingQueue<Request<?>> f21245c;

    /* renamed from: d */
    private final Cache f21246d;

    /* renamed from: e */
    private final ResponseDelivery f21247e;

    /* renamed from: f */
    private volatile boolean f21248f = false;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f21244b = blockingQueue;
        this.f21245c = blockingQueue2;
        this.f21246d = cache;
        this.f21247e = responseDelivery;
    }

    public void quit() {
        this.f21248f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f21243a) {
            VolleyLog.m2010v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f21246d.initialize();
        while (true) {
            try {
                Request<?> take = this.f21244b.take();
                take.addMarker("cache-queue-take");
                if (take.isCanceled()) {
                    take.m2017a("cache-discard-canceled");
                } else {
                    Cache.Entry entry = this.f21246d.get(take.getCacheKey());
                    if (entry == null) {
                        take.addMarker("cache-miss");
                        this.f21245c.put(take);
                    } else if (entry.isExpired()) {
                        take.addMarker("cache-hit-expired");
                        take.setCacheEntry(entry);
                        this.f21245c.put(take);
                    } else {
                        take.addMarker("cache-hit");
                        Response<?> parseNetworkResponse = take.parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                        take.addMarker("cache-hit-parsed");
                        if (!entry.refreshNeeded()) {
                            this.f21247e.postResponse(take, parseNetworkResponse);
                        } else {
                            take.addMarker("cache-hit-refresh-needed");
                            take.setCacheEntry(entry);
                            parseNetworkResponse.intermediate = true;
                            this.f21247e.postResponse(take, parseNetworkResponse, new RunnableC3921a(this, take));
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.f21248f) {
                    return;
                }
            }
        }
    }
}
