package com.mopub.network;

import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventSerializer;
import com.mopub.network.RequestManager;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class ScribeRequest extends Request<Void> {

    /* renamed from: a */
    private final List<BaseEvent> f21226a;

    /* renamed from: b */
    private final EventSerializer f21227b;

    /* renamed from: c */
    private final Listener f21228c;

    /* loaded from: classes2.dex */
    public interface Listener extends Response.ErrorListener {
        void onResponse();
    }

    /* loaded from: classes2.dex */
    public interface ScribeRequestFactory extends RequestManager.RequestFactory {
        ScribeRequest createRequest(Listener listener);
    }

    public ScribeRequest(String str, List<BaseEvent> list, EventSerializer eventSerializer, Listener listener) {
        super(1, str, listener);
        this.f21226a = list;
        this.f21227b = eventSerializer;
        this.f21228c = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy());
    }

    @Override // com.mopub.volley.Request
    public final Map<String, String> getParams() {
        JSONArray serializeAsJson = this.f21227b.serializeAsJson(this.f21226a);
        HashMap hashMap = new HashMap();
        hashMap.put("log", serializeAsJson.toString());
        return hashMap;
    }

    @Override // com.mopub.volley.Request
    public final Response<Void> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @VisibleForTesting
    @Deprecated
    public List<BaseEvent> getEvents() {
        return this.f21226a;
    }

    @Override // com.mopub.volley.Request
    public /* synthetic */ void deliverResponse(Void r1) {
        this.f21228c.onResponse();
    }
}
