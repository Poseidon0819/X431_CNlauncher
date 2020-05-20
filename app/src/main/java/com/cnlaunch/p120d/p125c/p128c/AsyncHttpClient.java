package com.cnlaunch.p120d.p125c.p128c;

import android.content.Context;
import com.cnlaunch.p120d.p130d.NLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.d.c.c.a */
/* loaded from: classes.dex */
public final class AsyncHttpClient {

    /* renamed from: a */
    private int f7089a;

    /* renamed from: b */
    private int f7090b;

    /* renamed from: c */
    private final CloseableHttpClient f7091c;

    /* renamed from: d */
    private final HttpContext f7092d;

    /* renamed from: e */
    private volatile ThreadPoolExecutor f7093e;

    /* renamed from: f */
    private final Map<Context, List<WeakReference<Future<?>>>> f7094f;

    /* renamed from: g */
    private final LinkedHashMap<String, String> f7095g;

    /* renamed from: h */
    private boolean f7096h;

    public AsyncHttpClient() {
        this((byte) 0);
    }

    private AsyncHttpClient(SchemeRegistry schemeRegistry) {
        this.f7089a = 5;
        this.f7090b = 60000;
        this.f7096h = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.f7090b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f7089a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 5);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f7090b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f7090b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", "1.4.4"));
        new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f7093e = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        this.f7094f = new WeakHashMap();
        this.f7095g = new LinkedHashMap<>();
        this.f7092d = new SyncBasicHttpContext(new BasicHttpContext());
        this.f7091c = HttpClients.createDefault();
    }

    /* renamed from: a */
    public final synchronized void m9533a(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (this) {
            this.f7093e = threadPoolExecutor;
        }
    }

    /* renamed from: a */
    public final void m9534a(String str, String str2) {
        this.f7095g.put(str, str2);
    }

    /* renamed from: a */
    public final RequestHandle m9535a(Context context, String str, ResponseHandlerInterface responseHandlerInterface) {
        return m9536a(context, str, null, responseHandlerInterface);
    }

    /* renamed from: a */
    public final RequestHandle m9536a(Context context, String str, C1426i c1426i, ResponseHandlerInterface responseHandlerInterface) {
        return m9532a(this.f7091c, this.f7092d, new HttpGet(m9531a(this.f7096h, str, c1426i)), responseHandlerInterface, context);
    }

    /* renamed from: a */
    private RequestHandle m9532a(CloseableHttpClient closeableHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface, Context context) {
        responseHandlerInterface.mo9496a(httpUriRequest.getAllHeaders());
        responseHandlerInterface.mo9498a(httpUriRequest.getURI());
        try {
            Future<?> submit = this.f7093e.submit(new AsyncHttpRequest(closeableHttpClient, httpContext, httpUriRequest, responseHandlerInterface, this.f7095g));
            if (context != null) {
                List<WeakReference<Future<?>>> list = this.f7094f.get(context);
                if (list == null) {
                    list = new LinkedList<>();
                    this.f7094f.put(context, list);
                }
                list.add(new WeakReference<>(submit));
            }
            return new RequestHandle(submit);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m9531a(boolean z, String str, C1426i c1426i) {
        if (z) {
            str = str.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "%20");
        }
        if (c1426i != null) {
            String m9505b = c1426i.m9505b();
            if (!str.contains("?")) {
                str = str + "?" + m9505b;
            } else {
                str = str + "&" + m9505b;
            }
        }
        NLog.m9456a("AsyncHttpClient", "url: ".concat(String.valueOf(str)));
        return str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private AsyncHttpClient(byte r5) {
        /*
            r4 = this;
            org.apache.http.conn.scheme.SchemeRegistry r5 = new org.apache.http.conn.scheme.SchemeRegistry
            r5.<init>()
            org.apache.http.conn.scheme.Scheme r0 = new org.apache.http.conn.scheme.Scheme
            java.lang.String r1 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r2 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()
            r3 = 80
            r0.<init>(r1, r2, r3)
            r5.register(r0)
            org.apache.http.conn.scheme.Scheme r0 = new org.apache.http.conn.scheme.Scheme
            java.lang.String r1 = "https"
            com.cnlaunch.d.c.c.q r2 = new com.cnlaunch.d.c.c.q
            r2.<init>()
            r3 = 443(0x1bb, float:6.21E-43)
            r0.<init>(r1, r2, r3)
            r5.register(r0)
            r4.<init>(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p120d.p125c.p128c.AsyncHttpClient.<init>(byte):void");
    }
}
