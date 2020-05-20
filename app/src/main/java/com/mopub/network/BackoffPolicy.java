package com.mopub.network;

import com.mopub.volley.VolleyError;

/* loaded from: classes2.dex */
public abstract class BackoffPolicy {

    /* renamed from: a */
    protected int f21201a;

    /* renamed from: b */
    protected int f21202b;

    /* renamed from: c */
    protected int f21203c;

    /* renamed from: d */
    protected int f21204d;

    /* renamed from: e */
    protected int f21205e;

    public abstract void backoff(VolleyError volleyError) throws VolleyError;

    public int getBackoffMs() {
        return this.f21201a;
    }

    public int getRetryCount() {
        return this.f21204d;
    }

    public boolean hasAttemptRemaining() {
        return this.f21204d < this.f21205e;
    }
}
