package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;

/* loaded from: classes2.dex */
public class ClearCacheRequest extends Request<Object> {

    /* renamed from: a */
    private final Cache f21313a;

    /* renamed from: b */
    private final Runnable f21314b;

    @Override // com.mopub.volley.Request
    public void deliverResponse(Object obj) {
    }

    @Override // com.mopub.volley.Request
    public final Response<Object> parseNetworkResponse(NetworkResponse networkResponse) {
        return null;
    }

    public ClearCacheRequest(Cache cache, Runnable runnable) {
        super(0, null, null);
        this.f21313a = cache;
        this.f21314b = runnable;
    }

    @Override // com.mopub.volley.Request
    public boolean isCanceled() {
        this.f21313a.clear();
        if (this.f21314b != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f21314b);
            return true;
        }
        return true;
    }

    @Override // com.mopub.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }
}
