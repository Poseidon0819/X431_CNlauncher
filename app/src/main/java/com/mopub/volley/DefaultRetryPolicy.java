package com.mopub.volley;

/* loaded from: classes2.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;

    /* renamed from: a */
    private int f21249a;

    /* renamed from: b */
    private int f21250b;

    /* renamed from: c */
    private final int f21251c;

    /* renamed from: d */
    private final float f21252d;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f21249a = i;
        this.f21251c = i2;
        this.f21252d = f;
    }

    @Override // com.mopub.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.f21249a;
    }

    @Override // com.mopub.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.f21250b;
    }

    public float getBackoffMultiplier() {
        return this.f21252d;
    }

    @Override // com.mopub.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        this.f21250b++;
        int i = this.f21249a;
        this.f21249a = (int) (i + (i * this.f21252d));
        if (!(this.f21250b <= this.f21251c)) {
            throw volleyError;
        }
    }
}
