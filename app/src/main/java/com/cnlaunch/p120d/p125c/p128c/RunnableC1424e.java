package com.cnlaunch.p120d.p125c.p128c;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: BreakpointHttpResponseHandler.java */
/* renamed from: com.cnlaunch.d.c.c.e */
/* loaded from: classes.dex */
final class RunnableC1424e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InputStream f7130a;

    /* renamed from: b */
    final /* synthetic */ CloseableHttpResponse f7131b;

    /* renamed from: c */
    final /* synthetic */ HttpUriRequest f7132c;

    /* renamed from: d */
    final /* synthetic */ BreakpointHttpResponseHandler f7133d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1424e(BreakpointHttpResponseHandler breakpointHttpResponseHandler, InputStream inputStream, CloseableHttpResponse closeableHttpResponse, HttpUriRequest httpUriRequest) {
        this.f7133d = breakpointHttpResponseHandler;
        this.f7130a = inputStream;
        this.f7131b = closeableHttpResponse;
        this.f7132c = httpUriRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f7130a != null) {
                this.f7131b.close();
                this.f7132c.abort();
                this.f7130a.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
