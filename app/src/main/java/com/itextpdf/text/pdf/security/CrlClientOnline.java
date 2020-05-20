package com.itextpdf.text.pdf.security;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class CrlClientOnline implements CrlClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrlClientOnline.class);
    protected List<URL> urls = new ArrayList();

    public CrlClientOnline() {
    }

    public CrlClientOnline(String... strArr) {
        for (String str : strArr) {
            try {
                this.urls.add(new URL(str));
                LOGGER.info("Added CRL url: ".concat(String.valueOf(str)));
            } catch (MalformedURLException unused) {
                LOGGER.info("Skipped CRL url: ".concat(String.valueOf(str)));
            }
        }
    }

    public CrlClientOnline(URL... urlArr) {
        for (URL url : this.urls) {
            this.urls.add(url);
            LOGGER.info("Added CRL url: ".concat(String.valueOf(url)));
        }
    }

    public CrlClientOnline(Certificate[] certificateArr) {
        for (Certificate certificate : certificateArr) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            String str = null;
            try {
                LOGGER.info("Checking certificate: " + x509Certificate.getSubjectDN());
                str = CertificateUtil.getCRLURL(x509Certificate);
                if (str != null) {
                    this.urls.add(new URL(str));
                    LOGGER.info("Added CRL url: ".concat(String.valueOf(str)));
                }
            } catch (Exception unused) {
                LOGGER.info("Skipped CRL url: ".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.itextpdf.text.pdf.security.CrlClient
    public Collection<byte[]> getEncoded(X509Certificate x509Certificate, String str) {
        HttpURLConnection httpURLConnection;
        if (x509Certificate == null) {
            return null;
        }
        if (this.urls.size() == 0) {
            Logger logger = LOGGER;
            logger.info("Looking for CRL for certificate " + x509Certificate.getSubjectDN());
            if (str == null) {
                try {
                    str = CertificateUtil.getCRLURL(x509Certificate);
                } catch (Exception e) {
                    Logger logger2 = LOGGER;
                    logger2.info("Skipped CRL url: " + e.getMessage());
                }
            }
            if (str == null) {
                throw new NullPointerException();
            }
            this.urls.add(new URL(str));
            LOGGER.info("Found CRL url: ".concat(String.valueOf(str)));
        }
        ArrayList arrayList = new ArrayList();
        for (URL url : this.urls) {
            try {
                LOGGER.info("Checking CRL: ".concat(String.valueOf(url)));
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (Exception e2) {
                Logger logger3 = LOGGER;
                logger3.info("Skipped CRL: " + e2.getMessage() + " for " + url);
            }
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                throw new IOException(MessageLocalization.getComposedMessage("invalid.http.response.1", httpURLConnection.getResponseCode()));
                break;
            }
            InputStream inputStream = (InputStream) httpURLConnection.getContent();
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            arrayList.add(byteArrayOutputStream.toByteArray());
            LOGGER.info("Added CRL found at: ".concat(String.valueOf(url)));
        }
        return arrayList;
    }
}
