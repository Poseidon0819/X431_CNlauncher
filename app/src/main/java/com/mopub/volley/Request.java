package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.volley.Cache;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* renamed from: a */
    private final VolleyLog.C3919a f21263a;

    /* renamed from: b */
    private final int f21264b;

    /* renamed from: c */
    private final String f21265c;

    /* renamed from: d */
    private final int f21266d;

    /* renamed from: e */
    private final Response.ErrorListener f21267e;

    /* renamed from: f */
    private Integer f21268f;

    /* renamed from: g */
    private RequestQueue f21269g;

    /* renamed from: h */
    private boolean f21270h;

    /* renamed from: i */
    private boolean f21271i;

    /* renamed from: j */
    private boolean f21272j;

    /* renamed from: k */
    private long f21273k;

    /* renamed from: l */
    private RetryPolicy f21274l;

    /* renamed from: m */
    private Cache.Entry f21275m;

    /* renamed from: n */
    private Object f21276n;

    /* loaded from: classes2.dex */
    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    /* loaded from: classes2.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static VolleyError m2018a(VolleyError volleyError) {
        return volleyError;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void deliverResponse(T t);

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    @Deprecated
    public Request(String str, Response.ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    public Request(int i, String str, Response.ErrorListener errorListener) {
        Uri parse;
        String host;
        this.f21263a = VolleyLog.C3919a.ENABLED ? new VolleyLog.C3919a() : null;
        this.f21270h = true;
        int i2 = 0;
        this.f21271i = false;
        this.f21272j = false;
        this.f21273k = 0L;
        this.f21275m = null;
        this.f21264b = i;
        this.f21265c = str;
        this.f21267e = errorListener;
        setRetryPolicy(new DefaultRetryPolicy());
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.f21266d = i2;
    }

    public int getMethod() {
        return this.f21264b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.f21276n = obj;
        return this;
    }

    public Object getTag() {
        return this.f21276n;
    }

    public Response.ErrorListener getErrorListener() {
        return this.f21267e;
    }

    public int getTrafficStatsTag() {
        return this.f21266d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.f21274l = retryPolicy;
        return this;
    }

    public void addMarker(String str) {
        if (VolleyLog.C3919a.ENABLED) {
            this.f21263a.add(str, Thread.currentThread().getId());
        } else if (this.f21273k == 0) {
            this.f21273k = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2017a(String str) {
        RequestQueue requestQueue = this.f21269g;
        if (requestQueue != null) {
            requestQueue.m2015a(this);
        }
        if (VolleyLog.C3919a.ENABLED) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new RunnableC3923c(this, str, id));
                return;
            }
            this.f21263a.add(str, id);
            this.f21263a.finish(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f21273k;
        if (elapsedRealtime >= 3000) {
            VolleyLog.m2013d("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.f21269g = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i) {
        this.f21268f = Integer.valueOf(i);
        return this;
    }

    public final int getSequence() {
        Integer num = this.f21268f;
        if (num == null) {
            throw new IllegalStateException("getSequence called before setSequence");
        }
        return num.intValue();
    }

    public String getUrl() {
        return this.f21265c;
    }

    public String getCacheKey() {
        return getUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(Cache.Entry entry) {
        this.f21275m = entry;
        return this;
    }

    public Cache.Entry getCacheEntry() {
        return this.f21275m;
    }

    public void cancel() {
        this.f21271i = true;
    }

    public boolean isCanceled() {
        return this.f21271i;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return m2016a(params, "UTF-8");
    }

    /* renamed from: a */
    private static byte[] m2016a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: ".concat(String.valueOf(str)), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.f21270h = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.f21270h;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final int getTimeoutMs() {
        return this.f21274l.getCurrentTimeout();
    }

    public RetryPolicy getRetryPolicy() {
        return this.f21274l;
    }

    public void markDelivered() {
        this.f21272j = true;
    }

    public boolean hasHadResponseDelivered() {
        return this.f21272j;
    }

    public void deliverError(VolleyError volleyError) {
        Response.ErrorListener errorListener = this.f21267e;
        if (errorListener != null) {
            errorListener.onErrorResponse(volleyError);
        }
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        return priority == priority2 ? this.f21268f.intValue() - request.f21268f.intValue() : priority2.ordinal() - priority.ordinal();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21271i ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(getPriority());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.f21268f);
        return sb.toString();
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return m2016a(params, "UTF-8");
    }
}
