package com.mopub.network;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class MoPubRequestQueue extends RequestQueue {

    /* renamed from: a */
    private final Map<Request<?>, C3909a> f21209a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoPubRequestQueue(Cache cache, Network network) {
        super(cache, network);
        this.f21209a = new HashMap(10);
    }

    public void addDelayedRequest(Request<?> request, int i) {
        Preconditions.checkNotNull(request);
        C3909a c3909a = new C3909a(this, request, i);
        Preconditions.checkNotNull(c3909a);
        if (this.f21209a.containsKey(request)) {
            cancel(request);
        }
        c3909a.f21211b.postDelayed(c3909a.f21212c, c3909a.f21210a);
        this.f21209a.put(request, c3909a);
    }

    @Override // com.mopub.volley.RequestQueue
    public void cancelAll(RequestQueue.RequestFilter requestFilter) {
        Preconditions.checkNotNull(requestFilter);
        super.cancelAll(requestFilter);
        Iterator<Map.Entry<Request<?>, C3909a>> it = this.f21209a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Request<?>, C3909a> next = it.next();
            if (requestFilter.apply(next.getKey())) {
                next.getKey().cancel();
                C3909a value = next.getValue();
                value.f21211b.removeCallbacks(value.f21212c);
                it.remove();
            }
        }
    }

    @Override // com.mopub.volley.RequestQueue
    public void cancelAll(Object obj) {
        Preconditions.checkNotNull(obj);
        super.cancelAll(obj);
        cancelAll((RequestQueue.RequestFilter) new C3910a(this, obj));
    }

    public void cancel(Request<?> request) {
        Preconditions.checkNotNull(request);
        cancelAll((RequestQueue.RequestFilter) new C3911b(this, request));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.network.MoPubRequestQueue$a */
    /* loaded from: classes2.dex */
    public class C3909a {

        /* renamed from: a */
        final int f21210a;

        /* renamed from: b */
        final Handler f21211b;

        /* renamed from: c */
        final Runnable f21212c;

        C3909a(MoPubRequestQueue moPubRequestQueue, Request<?> request, int i) {
            this(request, i, new Handler());
        }

        @VisibleForTesting
        private C3909a(Request<?> request, int i, Handler handler) {
            this.f21210a = i;
            this.f21211b = handler;
            this.f21212c = new RunnableC3912c(this, MoPubRequestQueue.this, request);
        }
    }
}
