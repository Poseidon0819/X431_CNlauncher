package com.cnlaunch.p120d.p125c.p128c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.ByteArrayBuffer;
import org.xbill.DNS.TTL;

/* renamed from: com.cnlaunch.d.c.c.c */
/* loaded from: classes.dex */
public class AsyncHttpResponseHandler implements ResponseHandlerInterface {

    /* renamed from: a */
    private static final String f7103a = "c";

    /* renamed from: b */
    private Handler f7104b;

    /* renamed from: c */
    HandlerThread f7105c = new HandlerThread("AsyncHttpResponseHandler");

    /* renamed from: d */
    private String f7106d = "UTF-8";

    /* renamed from: e */
    private Boolean f7107e = Boolean.FALSE;

    /* renamed from: f */
    private URI f7108f = null;

    /* renamed from: g */
    private Header[] f7109g = null;

    /* renamed from: a */
    public void mo9530a() {
    }

    /* renamed from: a */
    public void mo9529a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo9528a(int i, int i2, String str, String str2) {
    }

    @Deprecated
    /* renamed from: a */
    public void mo9524a(Throwable th) {
    }

    /* renamed from: b */
    public void mo9522b() {
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: a */
    public final void mo9498a(URI uri) {
        this.f7108f = uri;
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: a */
    public final void mo9496a(Header[] headerArr) {
        this.f7109g = headerArr;
    }

    /* compiled from: AsyncHttpResponseHandler.java */
    /* renamed from: com.cnlaunch.d.c.c.c$a */
    /* loaded from: classes.dex */
    static class HandlerC1423a extends Handler {

        /* renamed from: a */
        private final WeakReference<AsyncHttpResponseHandler> f7110a;

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            AsyncHttpResponseHandler asyncHttpResponseHandler = this.f7110a.get();
            if (asyncHttpResponseHandler != null) {
                asyncHttpResponseHandler.m9525a(message2);
            }
        }

        HandlerC1423a(AsyncHttpResponseHandler asyncHttpResponseHandler) {
            super(asyncHttpResponseHandler.f7105c == null ? null : asyncHttpResponseHandler.f7105c.getLooper());
            this.f7110a = new WeakReference<>(asyncHttpResponseHandler);
        }
    }

    /* renamed from: e */
    private String m9519e() {
        String str = this.f7106d;
        return str == null ? "UTF-8" : str;
    }

    public AsyncHttpResponseHandler() {
        this.f7105c.start();
        if (this.f7105c.getLooper() != null) {
            this.f7104b = new HandlerC1423a(this);
        }
    }

    /* renamed from: a */
    public void mo9516a(Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            try {
                new String(bArr, m9519e());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                mo9524a(e);
            }
        }
    }

    /* renamed from: a */
    public void mo9515a(Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr != null) {
            try {
                new String(bArr, m9519e());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                mo9524a(e);
                return;
            }
        }
        mo9524a(th);
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: b */
    public final void mo9495b(int i, int i2) {
        m9520b(m9527a(4, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* renamed from: a */
    public final void m9526a(int i, Header[] headerArr, byte[] bArr) {
        m9520b(m9527a(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: a */
    public final void mo9499a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        m9520b(m9527a(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: c */
    public final void mo9494c() {
        m9520b(m9527a(2, (Object) null));
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: d */
    public final void mo9493d() {
        m9520b(m9527a(3, (Object) null));
    }

    /* renamed from: b */
    public final void m9521b(int i, int i2, String str, String str2) {
        m9520b(m9527a(6, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}));
    }

    /* renamed from: a */
    protected final void m9525a(Message message2) {
        switch (message2.what) {
            case 0:
                Object[] objArr = (Object[]) message2.obj;
                if (objArr != null && objArr.length >= 3) {
                    ((Integer) objArr[0]).intValue();
                    mo9516a((Header[]) objArr[1], (byte[]) objArr[2]);
                    return;
                }
                NLog.m9456a(f7103a, "SUCCESS_MESSAGE didn't got enough params");
                return;
            case 1:
                Object[] objArr2 = (Object[]) message2.obj;
                if (objArr2 != null && objArr2.length >= 4) {
                    ((Integer) objArr2[0]).intValue();
                    mo9515a((Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                    return;
                }
                NLog.m9456a(f7103a, "FAILURE_MESSAGE didn't got enough params");
                return;
            case 2:
                mo9522b();
                return;
            case 3:
                mo9530a();
                return;
            case 4:
                Object[] objArr3 = (Object[]) message2.obj;
                if (objArr3 != null && objArr3.length >= 2) {
                    try {
                        mo9529a(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
                        return;
                    } catch (Throwable th) {
                        NLog.m9456a(f7103a, "custom onProgress contains an error", th);
                        return;
                    }
                }
                NLog.m9456a(f7103a, "PROGRESS_MESSAGE didn't got enough params");
                return;
            case 5:
                return;
            case 6:
                Object[] objArr4 = (Object[]) message2.obj;
                if (objArr4 != null && objArr4.length >= 4) {
                    try {
                        mo9528a(((Integer) objArr4[0]).intValue(), ((Integer) objArr4[1]).intValue(), (String) objArr4[2], (String) objArr4[3]);
                        return;
                    } catch (Throwable th2) {
                        NLog.m9456a(f7103a, "custom onSaveDownLoadLog contains an error", th2);
                        return;
                    }
                }
                NLog.m9456a(f7103a, "onSaveDownLoadLog didn't got enough params");
                return;
            default:
                NLog.m9456a(f7103a, "handleMessage default");
                return;
        }
    }

    /* renamed from: a */
    private Message m9527a(int i, Object obj) {
        Handler handler = this.f7104b;
        if (handler != null) {
            return handler.obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        if (obtain != null) {
            obtain.what = i;
            obtain.obj = obj;
        }
        return obtain;
    }

    @Override // com.cnlaunch.p120d.p125c.p128c.ResponseHandlerInterface
    /* renamed from: a */
    public void mo9497a(CloseableHttpResponse closeableHttpResponse, HttpUriRequest httpUriRequest) throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = closeableHttpResponse.getStatusLine();
        byte[] m9523a = m9523a(closeableHttpResponse.getEntity());
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (statusLine.getStatusCode() >= 300) {
            mo9499a(statusLine.getStatusCode(), closeableHttpResponse.getAllHeaders(), m9523a, (Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else {
            m9526a(statusLine.getStatusCode(), closeableHttpResponse.getAllHeaders(), m9523a);
        }
    }

    /* renamed from: a */
    private byte[] m9523a(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength > TTL.MAX_VALUE) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (contentLength < 0) {
            contentLength = 4096;
        }
        try {
            int i = (int) contentLength;
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
            byte[] bArr = new byte[4096];
            int i2 = 0;
            while (true) {
                int read = content.read(bArr);
                if (read == -1 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                i2 += read;
                byteArrayBuffer.append(bArr, 0, read);
                mo9495b(i2, i);
            }
            content.close();
            return byteArrayBuffer.toByteArray();
        } catch (OutOfMemoryError unused) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
        }
    }

    /* renamed from: b */
    private void m9520b(Message message2) {
        if (this.f7107e.booleanValue() || this.f7104b == null) {
            m9525a(message2);
        } else if (Thread.currentThread().isInterrupted()) {
        } else {
            this.f7104b.sendMessage(message2);
        }
    }
}
