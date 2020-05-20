package com.cnlaunch.p120d.p125c.p128c;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

@TargetApi(17)
/* renamed from: com.cnlaunch.d.c.c.q */
/* loaded from: classes.dex */
public final class TlsSniSocketFactory implements LayeredSocketFactory {

    /* renamed from: a */
    static final HostnameVerifier f7177a = new StrictHostnameVerifier();

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        return null;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final Socket createSocket() throws IOException {
        return null;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(InetAddress.getByName(str), i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (17 <= Build.VERSION.SDK_INT) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        } else {
            try {
                sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
            } catch (Exception unused) {
            }
        }
        if (f7177a.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(str)));
    }
}
