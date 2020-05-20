package com.mopub.network;

import com.mopub.common.VisibleForTesting;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;

/* loaded from: classes2.dex */
public class ScribeBackoffPolicy extends BackoffPolicy {
    public ScribeBackoffPolicy() {
        this((byte) 0);
    }

    @VisibleForTesting
    private ScribeBackoffPolicy(byte b) {
        this.f21203c = 60000;
        this.f21205e = 5;
        this.f21202b = 2;
    }

    @Override // com.mopub.network.BackoffPolicy
    public void backoff(VolleyError volleyError) throws VolleyError {
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
        if (volleyError instanceof NoConnectionError) {
            m2022a();
            return;
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && (networkResponse.statusCode == 503 || networkResponse.statusCode == 504)) {
            m2022a();
            return;
        }
        throw volleyError;
    }

    /* renamed from: a */
    private void m2022a() {
        double pow = Math.pow(this.f21202b, this.f21204d);
        double d = this.f21203c;
        Double.isNaN(d);
        this.f21201a = (int) (d * pow);
        this.f21204d++;
    }
}
