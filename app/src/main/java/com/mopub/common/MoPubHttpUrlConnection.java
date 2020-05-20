package com.mopub.common;

import com.mopub.common.logging.MoPubLog;
import com.mopub.network.Networking;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public abstract class MoPubHttpUrlConnection extends HttpURLConnection {
    public static HttpURLConnection getHttpUrlConnection(String str) throws IOException {
        Preconditions.checkNotNull(str);
        if (m2557a(str)) {
            throw new IllegalArgumentException("URL is improperly encoded: ".concat(String.valueOf(str)));
        }
        try {
            str = urlEncode(str);
        } catch (Exception unused) {
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Networking.getCachedUserAgent());
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        return httpURLConnection;
    }

    public static String urlEncode(String str) throws Exception {
        URI uri;
        Preconditions.checkNotNull(str);
        if (m2557a(str)) {
            throw new UnsupportedEncodingException("URL is improperly encoded: ".concat(String.valueOf(str)));
        }
        if (m2556b(str)) {
            uri = m2555c(str);
        } else {
            uri = new URI(str);
        }
        return uri.toURL().toString();
    }

    /* renamed from: a */
    private static boolean m2557a(String str) {
        try {
            URLDecoder.decode(str, "UTF-8");
            return false;
        } catch (UnsupportedEncodingException unused) {
            MoPubLog.m2490w("Url is improperly encoded: ".concat(String.valueOf(str)));
            return true;
        }
    }

    /* renamed from: b */
    private static boolean m2556b(String str) {
        try {
            new URI(str);
            return false;
        } catch (URISyntaxException unused) {
            return true;
        }
    }

    /* renamed from: c */
    private static URI m2555c(String str) throws Exception {
        try {
            URL url = new URL(str);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        } catch (Exception e) {
            MoPubLog.m2490w("Failed to encode url: ".concat(String.valueOf(str)));
            throw e;
        }
    }
}
