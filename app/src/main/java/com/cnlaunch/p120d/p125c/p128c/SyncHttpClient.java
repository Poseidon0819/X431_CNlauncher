package com.cnlaunch.p120d.p125c.p128c;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.CacheManager;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.d.c.c.m */
/* loaded from: classes.dex */
public class SyncHttpClient {

    /* renamed from: i */
    private static PersistentCookieStore f7164i;

    /* renamed from: j */
    private static volatile SyncHttpClient f7165j;

    /* renamed from: a */
    private final String f7166a;

    /* renamed from: b */
    private int f7167b;

    /* renamed from: c */
    private int f7168c;

    /* renamed from: d */
    private final DefaultHttpClient f7169d;

    /* renamed from: e */
    private final HttpContext f7170e;

    /* renamed from: f */
    private final Map<Context, List<WeakReference<Future<?>>>> f7171f;

    /* renamed from: g */
    private final Map<String, String> f7172g;

    /* renamed from: h */
    private boolean f7173h;

    /* renamed from: a */
    public static SyncHttpClient m9481a(Context context) {
        if (f7165j == null) {
            synchronized (SyncHttpClient.class) {
                if (f7165j == null) {
                    f7165j = new SyncHttpClient();
                }
            }
        }
        f7164i = new PersistentCookieStore(context);
        SyncHttpClient syncHttpClient = f7165j;
        syncHttpClient.f7170e.setAttribute(HttpClientContext.COOKIE_STORE, f7164i);
        return f7165j;
    }

    public SyncHttpClient() {
        this((byte) 0);
    }

    private SyncHttpClient(SchemeRegistry schemeRegistry) {
        this.f7166a = SyncHttpClient.class.getSimpleName();
        this.f7167b = 10;
        this.f7168c = 60000;
        this.f7173h = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.f7168c);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f7167b));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f7168c);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f7168c);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s", "1.4.4"));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f7171f = new WeakHashMap();
        this.f7172g = new HashMap();
        this.f7170e = new SyncBasicHttpContext(new BasicHttpContext());
        this.f7169d = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f7169d.addRequestInterceptor(new C1431n(this));
        this.f7169d.addResponseInterceptor(new C1432o(this));
    }

    /* renamed from: a */
    public final String m9477a(String str, C1426i c1426i) throws C1425f {
        DefaultHttpClient defaultHttpClient = this.f7169d;
        HttpContext httpContext = this.f7170e;
        if (this.f7173h) {
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
        return m9476a(defaultHttpClient, httpContext, new HttpGet(str));
    }

    /* renamed from: a */
    private String m9476a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest) throws C1425f {
        String str = "";
        defaultHttpClient.getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.TRUE);
        List<Cookie> cookies = f7164i.getCookies();
        if (cookies != null && cookies.size() > 0) {
            for (Cookie cookie : cookies) {
                httpUriRequest.setHeader("Cookie", cookie.getValue());
            }
        }
        try {
            URI uri = httpUriRequest.getURI();
            String str2 = this.f7166a;
            NLog.m9451c(str2, "url : " + uri.toString());
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme) && "assets".equals(scheme)) {
                Context context = null;
                String m9478a = m9478a(context.getAssets().open(uri.getAuthority()));
                NLog.m9451c(this.f7166a, "responseBody : ".concat(String.valueOf(m9478a)));
                return m9478a;
            }
            HttpResponse execute = defaultHttpClient.execute(httpUriRequest, httpContext);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                str = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
                if (NLog.m9458a()) {
                    CacheManager.m9603a(str, httpUriRequest.getURI().toString().replace("/", "").replaceAll("[?.=&:]", "_"));
                }
                NLog.m9451c(this.f7166a, "responseBody : ".concat(String.valueOf(str)));
            }
            Header[] headers = execute.getHeaders("Set-Cookie");
            if (headers != null && headers.length > 0) {
                for (int i = 0; i < headers.length; i++) {
                    f7164i.addCookie(new BasicClientCookie("cookie".concat(String.valueOf(i)), headers[i].getValue()));
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1425f(e);
        }
    }

    /* renamed from: a */
    private HttpEntity m9480a(C1426i c1426i) {
        if (c1426i != null) {
            try {
                String str = this.f7166a;
                NLog.m9451c(str, "params : " + c1426i.toString());
                return c1426i.m9511a();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* compiled from: SyncHttpClient.java */
    /* renamed from: com.cnlaunch.d.c.c.m$a */
    /* loaded from: classes.dex */
    static class C1430a extends HttpEntityWrapper {
        public final long getContentLength() {
            return -1L;
        }

        public C1430a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public final InputStream getContent() throws IOException {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }
    }

    /* renamed from: a */
    private static String m9478a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private SyncHttpClient(byte r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p120d.p125c.p128c.SyncHttpClient.<init>(byte):void");
    }

    /* renamed from: b */
    public final String m9475b(String str, C1426i c1426i) throws C1425f {
        HttpEntity m9480a = m9480a(c1426i);
        DefaultHttpClient defaultHttpClient = this.f7169d;
        HttpContext httpContext = this.f7170e;
        HttpPost httpPost = new HttpPost(str);
        if (m9480a != null) {
            httpPost.setEntity(m9480a);
        }
        return m9476a(defaultHttpClient, httpContext, httpPost);
    }
}
