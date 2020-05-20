package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class RequestFuture<T> implements Response.ErrorListener, Response.Listener<T>, Future<T> {

    /* renamed from: a */
    private Request<?> f21354a;

    /* renamed from: b */
    private boolean f21355b = false;

    /* renamed from: c */
    private T f21356c;

    /* renamed from: d */
    private VolleyError f21357d;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public void setRequest(Request<?> request) {
        this.f21354a = request;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f21354a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f21354a.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return m1973a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m1973a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    /* renamed from: a */
    private synchronized T m1973a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f21357d != null) {
            throw new ExecutionException(this.f21357d);
        }
        if (this.f21355b) {
            return this.f21356c;
        }
        if (l == null) {
            wait(0L);
        } else if (l.longValue() > 0) {
            wait(l.longValue());
        }
        if (this.f21357d != null) {
            throw new ExecutionException(this.f21357d);
        }
        if (!this.f21355b) {
            throw new TimeoutException();
        }
        return this.f21356c;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.f21354a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f21355b && this.f21357d == null) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.mopub.volley.Response.Listener
    public synchronized void onResponse(T t) {
        this.f21355b = true;
        this.f21356c = t;
        notifyAll();
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.f21357d = volleyError;
        notifyAll();
    }
}
