package com.mopub.volley;

/* loaded from: classes2.dex */
public class NetworkError extends VolleyError {
    public NetworkError() {
    }

    public NetworkError(Throwable th) {
        super(th);
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}
