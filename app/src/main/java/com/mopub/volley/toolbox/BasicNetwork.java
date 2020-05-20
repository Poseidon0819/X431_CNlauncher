package com.mopub.volley.toolbox;

import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.ServerError;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* loaded from: classes2.dex */
public class BasicNetwork implements Network {

    /* renamed from: a */
    protected static final boolean f21303a = VolleyLog.DEBUG;

    /* renamed from: d */
    private static int f21304d = SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY;

    /* renamed from: e */
    private static int f21305e = 4096;

    /* renamed from: b */
    protected final HttpStack f21306b;

    /* renamed from: c */
    protected final ByteArrayPool f21307c;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(f21305e));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.f21306b = httpStack;
        this.f21307c = byteArrayPool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
        if (r13 > com.mopub.volley.toolbox.BasicNetwork.f21304d) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    @Override // com.mopub.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.mopub.volley.NetworkResponse performRequest(com.mopub.volley.Request<?> r21) throws com.mopub.volley.VolleyError {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.BasicNetwork.performRequest(com.mopub.volley.Request):com.mopub.volley.NetworkResponse");
    }

    /* renamed from: a */
    private static void m2009a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    /* renamed from: a */
    private byte[] m2008a(HttpEntity httpEntity) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.f21307c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new ServerError();
            }
            byte[] buf = this.f21307c.getBuf(1024);
            while (true) {
                int read = content.read(buf);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, read);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                VolleyLog.m2010v("Error occured when calling consumingContent", new Object[0]);
            }
            this.f21307c.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                VolleyLog.m2010v("Error occured when calling consumingContent", new Object[0]);
            }
            this.f21307c.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static Map<String, String> m2007a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
