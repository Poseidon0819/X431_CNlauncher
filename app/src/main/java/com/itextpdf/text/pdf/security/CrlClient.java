package com.itextpdf.text.pdf.security;

import java.security.cert.X509Certificate;
import java.util.Collection;

/* loaded from: classes.dex */
public interface CrlClient {
    Collection<byte[]> getEncoded(X509Certificate x509Certificate, String str);
}
