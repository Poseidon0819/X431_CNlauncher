package com.mopub.network;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class CustomSSLSocketFactory extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f21206a;

    private CustomSSLSocketFactory() {
    }

    public static CustomSSLSocketFactory getDefault(int i) {
        CustomSSLSocketFactory customSSLSocketFactory = new CustomSSLSocketFactory();
        customSSLSocketFactory.f21206a = SSLCertificateSocketFactory.getDefault(i, null);
        return customSSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket createSocket = sSLSocketFactory.createSocket();
        m2028a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i);
        m2028a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket createSocket = sSLSocketFactory.createSocket(str, i, inetAddress, i2);
        m2028a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i);
        m2028a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket createSocket = sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        m2028a(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            return new String[0];
        }
        return sSLSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            return new String[0];
        }
        return sSLSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.f21206a == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        if (z && socket != null) {
            socket.close();
        }
        Socket createSocket = this.f21206a.createSocket(InetAddressUtils.getInetAddressByName(str), i);
        m2028a(createSocket);
        Preconditions.checkNotNull(createSocket);
        SSLSocketFactory sSLSocketFactory = this.f21206a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        if (createSocket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) sSLSocketFactory;
            Preconditions.checkNotNull(sSLCertificateSocketFactory);
            Preconditions.checkNotNull(sSLSocket);
            if (Build.VERSION.SDK_INT >= 17) {
                sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            } else {
                try {
                    new Reflection.MethodBuilder(sSLSocket, "setHostname").addParam(String.class, str).execute();
                } catch (Exception unused) {
                    MoPubLog.m2498d("Unable to call setHostname() on the socket");
                }
            }
            Preconditions.checkNotNull(sSLSocket);
            sSLSocket.startHandshake();
            if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSocket.getSession())) {
                throw new SSLHandshakeException("Server Name Identification failed.");
            }
        }
        return createSocket;
    }

    /* renamed from: a */
    private static void m2028a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
    }
}
