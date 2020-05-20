package com.cnlaunch.p120d.p125c.p128c;

import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.cnlaunch.d.c.c.j */
/* loaded from: classes.dex */
public interface ResponseHandlerInterface {
    /* renamed from: a */
    void mo9499a(int i, Header[] headerArr, byte[] bArr, Throwable th);

    /* renamed from: a */
    void mo9498a(URI uri);

    /* renamed from: a */
    void mo9497a(CloseableHttpResponse closeableHttpResponse, HttpUriRequest httpUriRequest) throws IOException;

    /* renamed from: a */
    void mo9496a(Header[] headerArr);

    /* renamed from: b */
    void mo9495b(int i, int i2);

    /* renamed from: c */
    void mo9494c();

    /* renamed from: d */
    void mo9493d();
}
