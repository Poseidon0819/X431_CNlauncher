package com.unionpay.p371a;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import com.unionpay.utils.C4644b;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.unionpay.a.b */
/* loaded from: classes2.dex */
public final class C4119b implements X509TrustManager {

    /* renamed from: a */
    private X509TrustManager f22038a;

    /* renamed from: b */
    private X509TrustManagerExtensions f22039b;

    /* renamed from: c */
    private Context f22040c;

    public C4119b(Context context) {
        this.f22038a = null;
        this.f22039b = null;
        this.f22040c = context;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 0) {
            throw new NoSuchAlgorithmException("no trust manager found");
        }
        this.f22038a = (X509TrustManager) trustManagers[0];
        if (Build.VERSION.SDK_INT > 23) {
            this.f22039b = new X509TrustManagerExtensions(this.f22038a);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.f22038a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        boolean z;
        X509TrustManagerExtensions x509TrustManagerExtensions;
        if (Build.VERSION.SDK_INT <= 23 || (x509TrustManagerExtensions = this.f22039b) == null) {
            this.f22038a.checkServerTrusted(x509CertificateArr, str);
        } else {
            x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, "");
        }
        boolean z2 = false;
        try {
            X500Principal issuerX500Principal = x509CertificateArr[0].getIssuerX500Principal();
            ArrayList arrayList = new ArrayList(0);
            arrayList.add(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*");
            String m464a = C4644b.m464a(this.f22040c);
            if (!TextUtils.isEmpty(m464a)) {
                arrayList.add(m464a);
            }
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    z = false;
                    break;
                } else if (Pattern.compile((String) arrayList.get(i), 2).matcher(issuerX500Principal.getName()).matches()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                throw new CertificateException();
            }
            X500Principal subjectX500Principal = x509CertificateArr[0].getSubjectX500Principal();
            ArrayList arrayList2 = new ArrayList(0);
            arrayList2.add(".*CN=.*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)");
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList2.size()) {
                    break;
                } else if (Pattern.compile((String) arrayList2.get(i2), 2).matcher(subjectX500Principal.getName()).matches()) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                throw new CertificateException();
            }
        } catch (Exception unused) {
            throw new CertificateException();
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f22038a.getAcceptedIssuers();
    }
}
