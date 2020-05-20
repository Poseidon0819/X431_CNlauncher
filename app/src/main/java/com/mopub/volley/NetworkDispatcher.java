package com.mopub.volley;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class NetworkDispatcher extends Thread {

    /* renamed from: a */
    private final BlockingQueue<Request<?>> f21258a;

    /* renamed from: b */
    private final Network f21259b;

    /* renamed from: c */
    private final Cache f21260c;

    /* renamed from: d */
    private final ResponseDelivery f21261d;

    /* renamed from: e */
    private volatile boolean f21262e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.f21258a = blockingQueue;
        this.f21259b = network;
        this.f21260c = cache;
        this.f21261d = responseDelivery;
    }

    public void quit() {
        this.f21262e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                Request<?> take = this.f21258a.take();
                try {
                    take.addMarker("network-queue-take");
                    if (take.isCanceled()) {
                        take.m2017a("network-discard-cancelled");
                    } else {
                        if (Build.VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(take.getTrafficStatsTag());
                        }
                        NetworkResponse performRequest = this.f21259b.performRequest(take);
                        take.addMarker("network-http-complete");
                        if (performRequest.notModified && take.hasHadResponseDelivered()) {
                            take.m2017a("not-modified");
                        } else {
                            Response<?> parseNetworkResponse = take.parseNetworkResponse(performRequest);
                            take.addMarker("network-parse-complete");
                            if (take.shouldCache() && parseNetworkResponse.cacheEntry != null) {
                                this.f21260c.put(take.getCacheKey(), parseNetworkResponse.cacheEntry);
                                take.addMarker("network-cache-written");
                            }
                            take.markDelivered();
                            this.f21261d.postResponse(take, parseNetworkResponse);
                        }
                    }
                } catch (VolleyError e) {
                    e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f21261d.postError(take, Request.m2018a(e));
                } catch (Exception e2) {
                    VolleyLog.m2011e(e2, "Unhandled exception %s", e2.toString());
                    VolleyError volleyError = new VolleyError(e2);
                    volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f21261d.postError(take, volleyError);
                }
            } catch (InterruptedException unused) {
                if (this.f21262e) {
                    return;
                }
            }
        }
    }
}
