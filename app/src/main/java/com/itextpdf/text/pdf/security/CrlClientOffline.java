package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class CrlClientOffline implements CrlClient {
    private ArrayList<byte[]> crls = new ArrayList<>();

    public CrlClientOffline(byte[] bArr) {
        this.crls.add(bArr);
    }

    public CrlClientOffline(CRL crl) {
        try {
            this.crls.add(((X509CRL) crl).getEncoded());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.pdf.security.CrlClient
    public Collection<byte[]> getEncoded(X509Certificate x509Certificate, String str) {
        return this.crls;
    }
}
