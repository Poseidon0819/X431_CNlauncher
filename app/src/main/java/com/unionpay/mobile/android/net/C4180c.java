package com.unionpay.mobile.android.net;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.unionpay.mobile.android.utils.C4390k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.unionpay.mobile.android.net.c */
/* loaded from: classes2.dex */
public final class C4180c {

    /* renamed from: a */
    private HttpURLConnection f22497a = null;

    /* renamed from: b */
    private byte[] f22498b = null;

    /* renamed from: c */
    private String f22499c = null;

    /* renamed from: d */
    private InputStream f22500d = null;

    /* renamed from: e */
    private C4181d f22501e;

    /* renamed from: f */
    private Context f22502f;

    public C4180c(C4181d c4181d, Context context) {
        this.f22501e = null;
        this.f22501e = c4181d;
        this.f22502f = context;
    }

    /* renamed from: a */
    public final int m1529a() {
        String str;
        String message2;
        HttpURLConnection httpURLConnection;
        C4390k.m838a("uppay", "HttpConn.connect() +++");
        C4181d c4181d = this.f22501e;
        int i = 1;
        if (c4181d == null) {
            C4390k.m836c("uppay", "params==null!!!");
            return 1;
        }
        try {
            URL m1526a = c4181d.m1526a();
            if (Constants.HTTPS.equals(m1526a.getProtocol().toLowerCase())) {
                httpURLConnection = (HttpsURLConnection) m1526a.openConnection();
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C4178a(this.f22502f).m1531a().getSocketFactory());
            } else {
                httpURLConnection = (HttpURLConnection) m1526a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f22501e.m1522b());
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setUseCaches(false);
            HashMap<String, String> m1520d = this.f22501e.m1520d();
            if (m1520d != null) {
                for (String str2 : m1520d.keySet()) {
                    httpURLConnection.setRequestProperty(str2, m1520d.get(str2));
                }
            }
            String m1522b = this.f22501e.m1522b();
            char c = 65535;
            int hashCode = m1522b.hashCode();
            if (hashCode != 70454) {
                if (hashCode == 2461856 && m1522b.equals(HttpPostHC4.METHOD_NAME)) {
                    c = 1;
                }
            } else if (m1522b.equals("GET")) {
                c = 0;
            }
            switch (c) {
                case 1:
                    httpURLConnection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    outputStreamWriter.write(this.f22501e.m1521c());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    break;
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                this.f22500d = httpURLConnection.getInputStream();
                if (this.f22500d != null) {
                    this.f22499c = C4182e.m1519a(this.f22500d, "UTF-8");
                    i = 0;
                }
            } else if (httpURLConnection.getResponseCode() == 401) {
                i = 8;
            } else {
                C4390k.m836c("uppay", "http status code:" + httpURLConnection.getResponseCode());
            }
        } catch (IllegalStateException e) {
            str = "uppay";
            if ("e2: ".concat(String.valueOf(e)) != null) {
                message2 = e.getMessage();
                C4390k.m836c(str, message2);
            }
            message2 = "e == null";
            C4390k.m836c(str, message2);
        } catch (SSLHandshakeException e2) {
            C4390k.m838a("uppay", "e0:" + e2.getMessage());
            i = 4;
        } catch (IOException e3) {
            str = "uppay";
            if ("e1: ".concat(String.valueOf(e3)) != null) {
                message2 = e3.getMessage();
                C4390k.m836c(str, message2);
            }
            message2 = "e == null";
            C4390k.m836c(str, message2);
        } catch (Exception e4) {
            str = "uppay";
            if ("e3: ".concat(String.valueOf(e4)) != null) {
                message2 = e4.getMessage();
                C4390k.m836c(str, message2);
            }
            message2 = "e == null";
            C4390k.m836c(str, message2);
        }
        C4390k.m838a("uppay", "HttpConn.connect() ---");
        return i;
    }

    /* renamed from: b */
    public final byte[] m1528b() {
        if (TextUtils.isEmpty(this.f22499c)) {
            return null;
        }
        return this.f22499c.getBytes();
    }

    /* renamed from: c */
    public final String m1527c() {
        return this.f22499c;
    }
}
