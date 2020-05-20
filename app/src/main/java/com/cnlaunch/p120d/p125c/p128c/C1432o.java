package com.cnlaunch.p120d.p125c.p128c;

import com.cnlaunch.p120d.p125c.p128c.SyncHttpClient;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* compiled from: SyncHttpClient.java */
/* renamed from: com.cnlaunch.d.c.c.o */
/* loaded from: classes.dex */
final class C1432o implements HttpResponseInterceptor {

    /* renamed from: a */
    final /* synthetic */ SyncHttpClient f7175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1432o(SyncHttpClient syncHttpClient) {
        this.f7175a = syncHttpClient;
    }

    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        for (HeaderElement headerElement : contentEncoding.getElements()) {
            if (headerElement.getName().equalsIgnoreCase("gzip")) {
                httpResponse.setEntity(new SyncHttpClient.C1430a(entity));
                return;
            }
        }
    }
}
