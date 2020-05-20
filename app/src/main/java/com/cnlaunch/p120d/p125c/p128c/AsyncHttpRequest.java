package com.cnlaunch.p120d.p125c.p128c;

import android.os.Process;
import android.util.Log;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.cnlaunch.d.c.c.b */
/* loaded from: classes.dex */
class AsyncHttpRequest implements Runnable {

    /* renamed from: a */
    private final String f7097a = AsyncHttpRequest.class.getSimpleName();

    /* renamed from: b */
    private final CloseableHttpClient f7098b;

    /* renamed from: c */
    private final HttpContext f7099c;

    /* renamed from: d */
    private final HttpUriRequest f7100d;

    /* renamed from: e */
    private final ResponseHandlerInterface f7101e;

    /* renamed from: f */
    private LinkedHashMap<String, String> f7102f;

    public AsyncHttpRequest(CloseableHttpClient closeableHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface, LinkedHashMap<String, String> linkedHashMap) {
        this.f7098b = closeableHttpClient;
        this.f7099c = httpContext;
        this.f7100d = httpUriRequest;
        this.f7101e = responseHandlerInterface;
        this.f7102f = linkedHashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Header[] allHeaders;
        Process.setThreadPriority(19);
        ResponseHandlerInterface responseHandlerInterface = this.f7101e;
        if (responseHandlerInterface != null) {
            responseHandlerInterface.mo9494c();
        }
        try {
            if (!Thread.currentThread().isInterrupted()) {
                if (this.f7100d.getURI().getScheme() == null) {
                    throw new MalformedURLException("No valid URI scheme was provided");
                }
                for (String str : this.f7102f.keySet()) {
                    this.f7100d.addHeader(str, this.f7102f.get(str));
                }
                if (this.f7101e instanceof BreakpointHttpResponseHandler) {
                    BreakpointHttpResponseHandler breakpointHttpResponseHandler = (BreakpointHttpResponseHandler) this.f7101e;
                    if (breakpointHttpResponseHandler.f7121l) {
                        if (breakpointHttpResponseHandler.f7121l) {
                            if (breakpointHttpResponseHandler.f7116g.exists()) {
                                breakpointHttpResponseHandler.f7118i = breakpointHttpResponseHandler.f7116g.length();
                            } else {
                                breakpointHttpResponseHandler.f7118i = 0L;
                            }
                        } else {
                            breakpointHttpResponseHandler.f7118i = 0L;
                        }
                        long j = breakpointHttpResponseHandler.f7118i;
                        NLog.m9451c(this.f7097a, "previousFileSized: ".concat(String.valueOf(j)));
                        this.f7100d.setHeader("RANGE", "bytes=" + j + "-");
                    }
                }
                CloseableHttpResponse execute = this.f7098b.execute(this.f7100d, this.f7099c);
                if (NLog.m9458a()) {
                    for (Header header : execute.getAllHeaders()) {
                        Log.d("yhx", header.getName() + "=" + header.getValue());
                    }
                }
                if (!Thread.currentThread().isInterrupted() && this.f7101e != null) {
                    this.f7101e.mo9497a(execute, this.f7100d);
                }
            }
        } catch (IOException e) {
            ResponseHandlerInterface responseHandlerInterface2 = this.f7101e;
            if (responseHandlerInterface2 != null) {
                responseHandlerInterface2.mo9499a(0, null, null, e);
            }
        }
        ResponseHandlerInterface responseHandlerInterface3 = this.f7101e;
        if (responseHandlerInterface3 != null) {
            responseHandlerInterface3.mo9493d();
        }
    }
}
