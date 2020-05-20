package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.event.BaseEvent;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastMacroHelper;
import com.mopub.mobileads.VastTracker;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class TrackingRequest extends Request<Void> {

    /* renamed from: a */
    private final Listener f21229a;

    /* loaded from: classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onResponse(String str);
    }

    private TrackingRequest(String str, Listener listener) {
        super(0, str, listener);
        this.f21229a = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1.0f));
    }

    @Override // com.mopub.volley.Request
    public final Response<Void> parseNetworkResponse(NetworkResponse networkResponse) {
        if (networkResponse.statusCode != 200) {
            return Response.error(new MoPubNetworkError("Failed to log tracking request. Response code: " + networkResponse.statusCode + " for url: " + getUrl(), MoPubNetworkError.Reason.TRACKING_FAILURE));
        }
        return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @Override // com.mopub.volley.Request
    public void deliverResponse(Void r2) {
        Listener listener = this.f21229a;
        if (listener != null) {
            listener.onResponse(getUrl());
        }
    }

    public static void makeVastTrackingHttpRequest(List<VastTracker> list, VastErrorCode vastErrorCode, Integer num, String str, Context context) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (VastTracker vastTracker : list) {
            if (vastTracker != null && (!vastTracker.isTracked() || vastTracker.isRepeatable())) {
                arrayList.add(vastTracker.getTrackingUrl());
                vastTracker.setTracked();
            }
        }
        makeTrackingHttpRequest(new VastMacroHelper(arrayList).withErrorCode(vastErrorCode).withContentPlayHead(num).withAssetUri(str).getUris(), context);
    }

    public static void makeTrackingHttpRequest(Iterable<String> iterable, Context context, Listener listener, BaseEvent.Name name) {
        if (iterable == null || context == null) {
            return;
        }
        MoPubRequestQueue requestQueue = Networking.getRequestQueue(context);
        for (String str : iterable) {
            if (!TextUtils.isEmpty(str)) {
                requestQueue.add(new TrackingRequest(str, new C3917h(listener, str)));
            }
        }
    }

    public static void makeTrackingHttpRequest(String str, Context context) {
        makeTrackingHttpRequest(str, context, (Listener) null, (BaseEvent.Name) null);
    }

    public static void makeTrackingHttpRequest(String str, Context context, Listener listener) {
        makeTrackingHttpRequest(str, context, listener, (BaseEvent.Name) null);
    }

    public static void makeTrackingHttpRequest(String str, Context context, BaseEvent.Name name) {
        makeTrackingHttpRequest(str, context, (Listener) null, name);
    }

    public static void makeTrackingHttpRequest(String str, Context context, Listener listener, BaseEvent.Name name) {
        if (str != null) {
            makeTrackingHttpRequest(Arrays.asList(str), context, listener, name);
        }
    }

    public static void makeTrackingHttpRequest(Iterable<String> iterable, Context context) {
        makeTrackingHttpRequest(iterable, context, (Listener) null, (BaseEvent.Name) null);
    }

    public static void makeTrackingHttpRequest(Iterable<String> iterable, Context context, BaseEvent.Name name) {
        makeTrackingHttpRequest(iterable, context, (Listener) null, name);
    }
}
