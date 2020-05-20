package com.cnlaunch.x431pro.p210a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: CertificadoAceptar.java */
/* renamed from: com.cnlaunch.x431pro.a.c */
/* loaded from: classes.dex */
final class C1944c implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return str.contains("x431") || str.contains("dbscar") || str.contains("cnlaunch") || str.contains("google");
    }
}
