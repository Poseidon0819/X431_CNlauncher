package com.mopub.volley.toolbox;

import com.mopub.common.Constants;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.HttpDeleteHC4;
import org.apache.http.client.methods.HttpHeadHC4;
import org.apache.http.client.methods.HttpOptionsHC4;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.client.methods.HttpTraceHC4;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* loaded from: classes2.dex */
public class HurlStack implements HttpStack {

    /* renamed from: a */
    private final UrlRewriter f21321a;

    /* renamed from: b */
    private final SSLSocketFactory f21322b;

    /* loaded from: classes2.dex */
    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.f21321a = urlRewriter;
        this.f21322b = sSLSocketFactory;
    }

    @Override // com.mopub.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String str;
        SSLSocketFactory sSLSocketFactory;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        UrlRewriter urlRewriter = this.f21321a;
        if (urlRewriter != null) {
            str = urlRewriter.rewriteUrl(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: ".concat(String.valueOf(url)));
            }
        } else {
            str = url;
        }
        URL url2 = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
        int timeoutMs = request.getTimeoutMs();
        httpURLConnection.setConnectTimeout(timeoutMs);
        httpURLConnection.setReadTimeout(timeoutMs);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (Constants.HTTPS.equals(url2.getProtocol()) && (sSLSocketFactory = this.f21322b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        for (String str2 : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
                    httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, request.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    break;
                }
                break;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                break;
            case 1:
                httpURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
                m1989a(httpURLConnection, request);
                break;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m1989a(httpURLConnection, request);
                break;
            case 3:
                httpURLConnection.setRequestMethod(HttpDeleteHC4.METHOD_NAME);
                break;
            case 4:
                httpURLConnection.setRequestMethod(HttpHeadHC4.METHOD_NAME);
                break;
            case 5:
                httpURLConnection.setRequestMethod(HttpOptionsHC4.METHOD_NAME);
                break;
            case 6:
                httpURLConnection.setRequestMethod(HttpTraceHC4.METHOD_NAME);
                break;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m1989a(httpURLConnection, request);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnection.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage()));
        basicHttpResponse.setEntity(m1990a(httpURLConnection));
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    /* renamed from: a */
    private static HttpEntity m1990a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* renamed from: a */
    private static void m1989a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, request.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }
}
