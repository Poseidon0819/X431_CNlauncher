package com.launch.p353a.p361h;

import android.content.Context;
import com.launch.p353a.p354a.ADSLibAplication;
import com.launch.p353a.p364k.C3666c;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.cert.CertificateException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/* renamed from: com.launch.a.h.a */
/* loaded from: classes.dex */
public final class ADSSSLSocketFactory {

    /* renamed from: a */
    public static final HostnameVerifier f19958a = new C3662c();

    /* renamed from: a */
    public static SSLSocketFactory m2656a(Context context) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException, java.security.cert.CertificateException {
        InputStream openRawResource;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        int m2704b = ADSLibAplication.m2704b();
        if (m2704b == 0) {
            openRawResource = ADSLibAplication.m2706a();
            if (openRawResource == null) {
                openRawResource = C3666c.m2641b();
            }
        } else {
            openRawResource = context.getResources().openRawResource(m2704b);
        }
        Certificate generateCertificate = certificateFactory.generateCertificate(openRawResource);
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", generateCertificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext.getSocketFactory();
    }

    /* renamed from: a */
    public static void m2657a() {
        TrustManager[] trustManagerArr = {new C3661b()};
        try {
            SSLContext sSLContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
