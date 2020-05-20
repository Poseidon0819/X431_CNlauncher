package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public abstract class JsonRequest<T> extends Request<T> {

    /* renamed from: a */
    private static final String f21345a = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: b */
    private final Response.Listener<T> f21346b;

    /* renamed from: c */
    private final String f21347c;

    @Override // com.mopub.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.f21346b = listener;
        this.f21347c = str2;
    }

    @Override // com.mopub.volley.Request
    public void deliverResponse(T t) {
        this.f21346b.onResponse(t);
    }

    @Override // com.mopub.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.mopub.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.mopub.volley.Request
    public String getBodyContentType() {
        return f21345a;
    }

    @Override // com.mopub.volley.Request
    public byte[] getBody() {
        try {
            if (this.f21347c == null) {
                return null;
            }
            return this.f21347c.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.f21347c, "utf-8");
            return null;
        }
    }
}
