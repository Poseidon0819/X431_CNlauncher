package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class RequestQueue {

    /* renamed from: a */
    private AtomicInteger f21278a;

    /* renamed from: b */
    private final Map<String, Queue<Request<?>>> f21279b;

    /* renamed from: c */
    private final Set<Request<?>> f21280c;

    /* renamed from: d */
    private final PriorityBlockingQueue<Request<?>> f21281d;

    /* renamed from: e */
    private final PriorityBlockingQueue<Request<?>> f21282e;

    /* renamed from: f */
    private final Cache f21283f;

    /* renamed from: g */
    private final Network f21284g;

    /* renamed from: h */
    private final ResponseDelivery f21285h;

    /* renamed from: i */
    private NetworkDispatcher[] f21286i;

    /* renamed from: j */
    private CacheDispatcher f21287j;

    /* loaded from: classes2.dex */
    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    public RequestQueue(Cache cache, Network network, int i, ResponseDelivery responseDelivery) {
        this.f21278a = new AtomicInteger();
        this.f21279b = new HashMap();
        this.f21280c = new HashSet();
        this.f21281d = new PriorityBlockingQueue<>();
        this.f21282e = new PriorityBlockingQueue<>();
        this.f21283f = cache;
        this.f21284g = network;
        this.f21286i = new NetworkDispatcher[i];
        this.f21285h = responseDelivery;
    }

    public RequestQueue(Cache cache, Network network, int i) {
        this(cache, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public void start() {
        stop();
        this.f21287j = new CacheDispatcher(this.f21281d, this.f21282e, this.f21283f, this.f21285h);
        this.f21287j.start();
        for (int i = 0; i < this.f21286i.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f21282e, this.f21284g, this.f21283f, this.f21285h);
            this.f21286i[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        CacheDispatcher cacheDispatcher = this.f21287j;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        int i = 0;
        while (true) {
            NetworkDispatcher[] networkDispatcherArr = this.f21286i;
            if (i >= networkDispatcherArr.length) {
                return;
            }
            if (networkDispatcherArr[i] != null) {
                networkDispatcherArr[i].quit();
            }
            i++;
        }
    }

    public int getSequenceNumber() {
        return this.f21278a.incrementAndGet();
    }

    public Cache getCache() {
        return this.f21283f;
    }

    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.f21280c) {
            for (Request<?> request : this.f21280c) {
                if (requestFilter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll((RequestFilter) new C3924d(this, obj));
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f21280c) {
            this.f21280c.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.f21282e.add(request);
            return request;
        }
        synchronized (this.f21279b) {
            String cacheKey = request.getCacheKey();
            if (this.f21279b.containsKey(cacheKey)) {
                Queue<Request<?>> queue = this.f21279b.get(cacheKey);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(request);
                this.f21279b.put(cacheKey, queue);
                if (VolleyLog.DEBUG) {
                    VolleyLog.m2010v("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
            } else {
                this.f21279b.put(cacheKey, null);
                this.f21281d.add(request);
            }
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2015a(Request<?> request) {
        synchronized (this.f21280c) {
            this.f21280c.remove(request);
        }
        if (request.shouldCache()) {
            synchronized (this.f21279b) {
                String cacheKey = request.getCacheKey();
                Queue<Request<?>> remove = this.f21279b.remove(cacheKey);
                if (remove != null) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.m2010v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    this.f21281d.addAll(remove);
                }
            }
        }
    }
}
