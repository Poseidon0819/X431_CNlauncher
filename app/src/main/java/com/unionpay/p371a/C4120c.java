package com.unionpay.p371a;

import android.content.Context;
import com.mopub.common.Constants;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4652j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.unionpay.a.c */
/* loaded from: classes2.dex */
public final class C4120c {

    /* renamed from: a */
    private HttpURLConnection f22041a = null;

    /* renamed from: b */
    private byte[] f22042b = null;

    /* renamed from: c */
    private String f22043c = null;

    /* renamed from: d */
    private InputStream f22044d = null;

    /* renamed from: e */
    private C4121d f22045e;

    /* renamed from: f */
    private Context f22046f;

    public C4120c(C4121d c4121d, Context context) {
        this.f22045e = null;
        this.f22045e = c4121d;
        this.f22046f = context;
    }

    /* renamed from: a */
    public final int m1643a() {
        String str;
        String message2;
        HttpURLConnection httpURLConnection;
        C4652j.m433a("uppay", "HttpConn.connect() +++");
        C4121d c4121d = this.f22045e;
        int i = 1;
        if (c4121d == null) {
            C4652j.m432b("uppay", "params==null!!!");
            return 1;
        }
        try {
            URL m1641a = c4121d.m1641a();
            if (Constants.HTTPS.equals(m1641a.getProtocol().toLowerCase())) {
                httpURLConnection = (HttpsURLConnection) m1641a.openConnection();
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C4118a(this.f22046f).m1645a().getSocketFactory());
            } else {
                httpURLConnection = (HttpURLConnection) m1641a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f22045e.m1639b());
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setUseCaches(false);
            HashMap m1637d = this.f22045e.m1637d();
            if (m1637d != null) {
                for (String str2 : m1637d.keySet()) {
                    httpURLConnection.setRequestProperty(str2, (String) m1637d.get(str2));
                }
            }
            String m1639b = this.f22045e.m1639b();
            char c = 65535;
            int hashCode = m1639b.hashCode();
            if (hashCode != 70454) {
                if (hashCode == 2461856 && m1639b.equals(HttpPostHC4.METHOD_NAME)) {
                    c = 1;
                }
            } else if (m1639b.equals("GET")) {
                c = 0;
            }
            switch (c) {
                case 1:
                    httpURLConnection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    outputStreamWriter.write(this.f22045e.m1638c());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    break;
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                this.f22044d = httpURLConnection.getInputStream();
                if (this.f22044d != null) {
                    this.f22043c = C4644b.m462a(this.f22044d, "UTF-8");
                    i = 0;
                }
            } else if (httpURLConnection.getResponseCode() == 401) {
                i = 8;
            } else {
                C4652j.m432b("uppay", "http status code:" + httpURLConnection.getResponseCode());
            }
        } catch (IllegalStateException e) {
            str = "uppay";
            if ("e2: ".concat(String.valueOf(e)) != null) {
                message2 = e.getMessage();
                C4652j.m432b(str, message2);
            }
            message2 = "e == null";
            C4652j.m432b(str, message2);
        } catch (SSLHandshakeException e2) {
            C4652j.m433a("uppay", "e0:" + e2.getMessage());
            i = 4;
        } catch (IOException e3) {
            str = "uppay";
            if ("e1: ".concat(String.valueOf(e3)) != null) {
                message2 = e3.getMessage();
                C4652j.m432b(str, message2);
            }
            message2 = "e == null";
            C4652j.m432b(str, message2);
        } catch (Exception e4) {
            str = "uppay";
            if ("e3: ".concat(String.valueOf(e4)) != null) {
                message2 = e4.getMessage();
                C4652j.m432b(str, message2);
            }
            message2 = "e == null";
            C4652j.m432b(str, message2);
        }
        C4652j.m433a("uppay", "HttpConn.connect() ---");
        return i;
    }

    /* renamed from: b */
    public final String m1642b() {
        return this.f22043c;
    }
}
