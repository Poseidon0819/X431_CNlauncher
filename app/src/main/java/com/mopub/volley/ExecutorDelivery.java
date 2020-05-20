package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: a */
    private final Executor f21253a;

    public ExecutorDelivery(Handler handler) {
        this.f21253a = new ExecutorC3922b(this, handler);
    }

    public ExecutorDelivery(Executor executor) {
        this.f21253a = executor;
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f21253a.execute(new RunnableC3918a(request, response, runnable));
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f21253a.execute(new RunnableC3918a(request, Response.error(volleyError), null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.ExecutorDelivery$a */
    /* loaded from: classes2.dex */
    public class RunnableC3918a implements Runnable {

        /* renamed from: b */
        private final Request f21255b;

        /* renamed from: c */
        private final Response f21256c;

        /* renamed from: d */
        private final Runnable f21257d;

        public RunnableC3918a(Request request, Response response, Runnable runnable) {
            this.f21255b = request;
            this.f21256c = response;
            this.f21257d = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f21255b.isCanceled()) {
                this.f21255b.m2017a("canceled-at-delivery");
                return;
            }
            if (this.f21256c.isSuccess()) {
                this.f21255b.deliverResponse(this.f21256c.result);
            } else {
                this.f21255b.deliverError(this.f21256c.error);
            }
            if (this.f21256c.intermediate) {
                this.f21255b.addMarker("intermediate-response");
            } else {
                this.f21255b.m2017a("done");
            }
            Runnable runnable = this.f21257d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
