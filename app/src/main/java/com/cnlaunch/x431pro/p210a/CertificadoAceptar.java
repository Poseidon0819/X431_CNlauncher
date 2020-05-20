package com.cnlaunch.x431pro.p210a;

import android.util.Log;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/* renamed from: com.cnlaunch.x431pro.a.b */
/* loaded from: classes.dex */
public final class CertificadoAceptar {

    /* renamed from: a */
    private static TrustManager[] f10542a;

    /* compiled from: CertificadoAceptar.java */
    /* renamed from: com.cnlaunch.x431pro.a.b$a */
    /* loaded from: classes.dex */
    public static class C1943a implements X509TrustManager {

        /* renamed from: a */
        private static final X509Certificate[] f10543a = new X509Certificate[0];

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return f10543a;
        }
    }

    /* renamed from: a */
    public static void m7971a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        HttpsURLConnection.setDefaultHostnameVerifier(new C1944c());
        if (f10542a == null) {
            f10542a = new TrustManager[]{new C1943a()};
        }
        try {
            sSLContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            try {
                sSLContext.init(null, f10542a, new SecureRandom());
            } catch (KeyManagementException e3) {
                e2 = e3;
                Log.e("sarah", e2.toString());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                Log.e("sarah", e.toString());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            }
        } catch (KeyManagementException e5) {
            sSLContext = null;
            e2 = e5;
        } catch (NoSuchAlgorithmException e6) {
            sSLContext = null;
            e = e6;
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }
}
