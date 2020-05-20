package com.mopub.mobileads;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.toolbox.HttpHeaderParser;

/* loaded from: classes.dex */
public class RewardedVideoCompletionRequest extends Request<Integer> {

    /* renamed from: a */
    final RewardedVideoCompletionRequestListener f20396a;

    /* loaded from: classes.dex */
    public interface RewardedVideoCompletionRequestListener extends Response.ErrorListener {
        void onResponse(Integer num);
    }

    @Override // com.mopub.volley.Request
    public /* synthetic */ void deliverResponse(Integer num) {
        this.f20396a.onResponse(num);
    }

    public RewardedVideoCompletionRequest(String str, RetryPolicy retryPolicy, RewardedVideoCompletionRequestListener rewardedVideoCompletionRequestListener) {
        super(0, str, rewardedVideoCompletionRequestListener);
        setShouldCache(false);
        setRetryPolicy(retryPolicy);
        this.f20396a = rewardedVideoCompletionRequestListener;
    }

    @Override // com.mopub.volley.Request
    public final Response<Integer> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(Integer.valueOf(networkResponse.statusCode), HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
