package com.mopub.network;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeRequest;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;

/* loaded from: classes2.dex */
public class ScribeRequestManager extends RequestManager<ScribeRequest.ScribeRequestFactory> implements ScribeRequest.Listener {
    public ScribeRequestManager(Looper looper) {
        super(looper);
    }

    @Override // com.mopub.network.RequestManager
    /* renamed from: a */
    final Request<?> mo2021a() {
        return ((ScribeRequest.ScribeRequestFactory) this.f21222b).createRequest(this);
    }

    @Override // com.mopub.network.ScribeRequest.Listener
    public void onResponse() {
        MoPubLog.m2498d("Successfully scribed events");
        this.f21224d.post(new RunnableC3915f(this));
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        this.f21224d.post(new RunnableC3916g(this, volleyError));
    }
}
