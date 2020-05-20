package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/* loaded from: classes.dex */
public class DownloadResponse {

    /* renamed from: a */
    private byte[] f20066a;

    /* renamed from: b */
    private final int f20067b;

    /* renamed from: c */
    private final long f20068c;

    /* renamed from: d */
    private final Header[] f20069d;

    public DownloadResponse(HttpResponse httpResponse) throws Exception {
        this.f20066a = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = null;
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(entity.getContent());
                try {
                    Streams.copyContent(bufferedInputStream2, byteArrayOutputStream);
                    this.f20066a = byteArrayOutputStream.toByteArray();
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    Streams.closeStream(bufferedInputStream);
                    Streams.closeStream(byteArrayOutputStream);
                    throw th;
                }
            }
            Streams.closeStream(bufferedInputStream);
            Streams.closeStream(byteArrayOutputStream);
            this.f20067b = httpResponse.getStatusLine().getStatusCode();
            this.f20068c = this.f20066a.length;
            this.f20069d = httpResponse.getAllHeaders();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public byte[] getByteArray() {
        return this.f20066a;
    }

    public int getStatusCode() {
        return this.f20067b;
    }

    public long getContentLength() {
        return this.f20068c;
    }

    public String getFirstHeader(ResponseHeader responseHeader) {
        Header[] headerArr;
        for (Header header : this.f20069d) {
            if (header.getName().equalsIgnoreCase(responseHeader.getKey())) {
                return header.getValue();
            }
        }
        return null;
    }
}
