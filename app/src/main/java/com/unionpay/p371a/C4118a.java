package com.unionpay.p371a;

import android.content.Context;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/* renamed from: com.unionpay.a.a */
/* loaded from: classes2.dex */
public class C4118a {

    /* renamed from: a */
    private SSLContext f22036a = null;

    /* renamed from: b */
    private Context f22037b;

    public C4118a(Context context) {
        this.f22037b = context;
    }

    /* renamed from: a */
    private static SSLContext m1644a(Context context) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            sSLContext.init(null, new TrustManager[]{new C4119b(context)}, null);
            return sSLContext;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    public final SSLContext m1645a() {
        if (this.f22036a == null) {
            this.f22036a = m1644a(this.f22037b);
        }
        return this.f22036a;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(C4118a.class);
    }

    public int hashCode() {
        return C4118a.class.hashCode();
    }
}
