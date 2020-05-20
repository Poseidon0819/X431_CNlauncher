package com.mopub.volley.toolbox;

import com.baidu.mapapi.UIMsg;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes2.dex */
public class HttpClientStack implements HttpStack {

    /* renamed from: a */
    protected final HttpClient f21320a;

    public HttpClientStack(HttpClient httpClient) {
        this.f21320a = httpClient;
    }

    /* renamed from: a */
    private static void m1991a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    /* renamed from: a */
    private static void m1992a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    /* loaded from: classes2.dex */
    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        public final String getMethod() {
            return "PATCH";
        }

        public HttpPatch() {
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }
    }

    @Override // com.mopub.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpPatch httpGet;
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    HttpPatch httpPost = new HttpPost(request.getUrl());
                    httpPost.addHeader(HttpHeaders.CONTENT_TYPE, request.getPostBodyContentType());
                    httpPost.setEntity(new ByteArrayEntity(postBody));
                    httpGet = httpPost;
                    break;
                } else {
                    httpGet = new HttpGet(request.getUrl());
                    break;
                }
            case 0:
                httpGet = new HttpGet(request.getUrl());
                break;
            case 1:
                httpGet = new HttpPost(request.getUrl());
                httpGet.addHeader(HttpHeaders.CONTENT_TYPE, request.getBodyContentType());
                m1992a(httpGet, request);
                break;
            case 2:
                httpGet = new HttpPut(request.getUrl());
                httpGet.addHeader(HttpHeaders.CONTENT_TYPE, request.getBodyContentType());
                m1992a(httpGet, request);
                break;
            case 3:
                httpGet = new HttpDelete(request.getUrl());
                break;
            case 4:
                httpGet = new HttpHead(request.getUrl());
                break;
            case 5:
                httpGet = new HttpOptions(request.getUrl());
                break;
            case 6:
                httpGet = new HttpTrace(request.getUrl());
                break;
            case 7:
                httpGet = new HttpPatch(request.getUrl());
                httpGet.addHeader(HttpHeaders.CONTENT_TYPE, request.getBodyContentType());
                m1992a(httpGet, request);
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        m1991a((HttpUriRequest) httpGet, map);
        m1991a((HttpUriRequest) httpGet, request.getHeaders());
        HttpParams params = httpGet.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, UIMsg.m_AppUI.MSG_APP_GPS);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.f21320a.execute(httpGet);
    }
}
