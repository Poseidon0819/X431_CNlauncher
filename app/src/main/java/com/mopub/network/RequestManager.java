package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.RequestManager.RequestFactory;
import com.mopub.volley.Request;

/* loaded from: classes2.dex */
public abstract class RequestManager<T extends RequestFactory> {

    /* renamed from: a */
    protected Request<?> f21221a;

    /* renamed from: b */
    protected T f21222b;

    /* renamed from: c */
    protected BackoffPolicy f21223c;

    /* renamed from: d */
    protected Handler f21224d;

    /* loaded from: classes2.dex */
    public interface RequestFactory {
    }

    /* renamed from: a */
    abstract Request<?> mo2021a();

    public RequestManager(Looper looper) {
        this.f21224d = new Handler(looper);
    }

    public boolean isAtCapacity() {
        return this.f21221a != null;
    }

    public void makeRequest(T t, BackoffPolicy backoffPolicy) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(backoffPolicy);
        cancelRequest();
        this.f21222b = t;
        this.f21223c = backoffPolicy;
        m2024b();
    }

    public void cancelRequest() {
        Request<?> request;
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue != null && (request = this.f21221a) != null) {
            requestQueue.cancel(request);
        }
        m2023c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final void m2024b() {
        this.f21221a = mo2021a();
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue == null) {
            MoPubLog.m2498d("MoPubRequest queue is null. Clearing request.");
            m2023c();
        } else if (this.f21223c.getRetryCount() == 0) {
            requestQueue.add(this.f21221a);
        } else {
            requestQueue.addDelayedRequest(this.f21221a, this.f21223c.getBackoffMs());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public final void m2023c() {
        this.f21221a = null;
        this.f21222b = null;
        this.f21223c = null;
    }
}
