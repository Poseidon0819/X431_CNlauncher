package com.unionpay.mobile.android.net;

import android.content.Context;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/* renamed from: com.unionpay.mobile.android.net.a */
/* loaded from: classes2.dex */
public class C4178a {

    /* renamed from: a */
    private SSLContext f22492a = null;

    /* renamed from: b */
    private Context f22493b;

    public C4178a(Context context) {
        this.f22493b = context;
    }

    /* renamed from: a */
    private static SSLContext m1530a(Context context) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            sSLContext.init(null, new TrustManager[]{new C4179b(context)}, null);
            return sSLContext;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    public final SSLContext m1531a() throws IOException {
        if (this.f22492a == null) {
            this.f22492a = m1530a(this.f22493b);
        }
        return this.f22492a;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(C4178a.class);
    }

    public int hashCode() {
        return C4178a.class.hashCode();
    }
}
