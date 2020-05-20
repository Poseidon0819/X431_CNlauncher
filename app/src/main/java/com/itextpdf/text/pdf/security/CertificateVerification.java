package com.itextpdf.text.pdf.security;

import java.security.KeyStore;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.tsp.TimeStampToken;

/* loaded from: classes.dex */
public class CertificateVerification {
    public static String verifyCertificate(X509Certificate x509Certificate, Collection<CRL> collection, Calendar calendar) {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        if (x509Certificate.hasUnsupportedCriticalExtension()) {
            return "Has unsupported critical extension";
        }
        try {
            x509Certificate.checkValidity(calendar.getTime());
            if (collection != null) {
                for (CRL crl : collection) {
                    if (crl.isRevoked(x509Certificate)) {
                        return "Certificate revoked";
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static Object[] verifyCertificates(Certificate[] certificateArr, KeyStore keyStore, Collection<CRL> collection, Calendar calendar) {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        for (int i = 0; i < certificateArr.length; i++) {
            X509Certificate x509Certificate = (X509Certificate) certificateArr[i];
            String verifyCertificate = verifyCertificate(x509Certificate, collection, calendar);
            if (verifyCertificate != null) {
                return new Object[]{x509Certificate, verifyCertificate};
            }
            try {
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    try {
                        String nextElement = aliases.nextElement();
                        if (keyStore.isCertificateEntry(nextElement)) {
                            X509Certificate x509Certificate2 = (X509Certificate) keyStore.getCertificate(nextElement);
                            if (verifyCertificate(x509Certificate2, collection, calendar) == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                                return null;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            int i2 = 0;
            while (i2 < certificateArr.length) {
                if (i2 != i) {
                    try {
                        x509Certificate.verify(((X509Certificate) certificateArr[i2]).getPublicKey());
                        break;
                    } catch (Exception unused3) {
                        continue;
                    }
                }
                i2++;
            }
            if (i2 == certificateArr.length) {
                return new Object[]{x509Certificate, "Cannot be verified against the KeyStore or the certificate chain"};
            }
        }
        return new Object[]{null, "Invalid state. Possible circular certificate chain"};
    }

    public static boolean verifyOcspCertificates(BasicOCSPResp basicOCSPResp, KeyStore keyStore, String str) {
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    String nextElement = aliases.nextElement();
                    if (keyStore.isCertificateEntry(nextElement) && basicOCSPResp.isSignatureValid(new JcaContentVerifierProviderBuilder().setProvider(str).build(((X509Certificate) keyStore.getCertificate(nextElement)).getPublicKey()))) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean verifyTimestampCertificates(TimeStampToken timeStampToken, KeyStore keyStore, String str) {
        String nextElement;
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    nextElement = aliases.nextElement();
                } catch (Exception unused) {
                }
                if (keyStore.isCertificateEntry(nextElement)) {
                    timeStampToken.isSignatureValid(new JcaSimpleSignerInfoVerifierBuilder().setProvider(str).build((X509Certificate) keyStore.getCertificate(nextElement)));
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }
}
