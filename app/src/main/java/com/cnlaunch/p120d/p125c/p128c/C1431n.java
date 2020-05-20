package com.cnlaunch.p120d.p125c.p128c;

import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncHttpClient.java */
/* renamed from: com.cnlaunch.d.c.c.n */
/* loaded from: classes.dex */
public final class C1431n implements HttpRequestInterceptor {

    /* renamed from: a */
    final /* synthetic */ SyncHttpClient f7174a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1431n(SyncHttpClient syncHttpClient) {
        this.f7174a = syncHttpClient;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        Map map;
        Map map2;
        if (!httpRequest.containsHeader(HttpHeaders.ACCEPT_ENCODING)) {
            httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        map = this.f7174a.f7172g;
        for (String str : map.keySet()) {
            map2 = this.f7174a.f7172g;
            httpRequest.addHeader(str, (String) map2.get(str));
        }
    }
}
