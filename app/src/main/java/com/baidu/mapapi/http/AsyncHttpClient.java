package com.baidu.mapapi.http;

import android.os.Build;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AsyncHttpClient {

    /* renamed from: a */
    private int f4891a = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: b */
    private int f4892b = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: c */
    private ExecutorService f4893c = Executors.newCachedThreadPool();

    /* renamed from: com.baidu.mapapi.http.AsyncHttpClient$a */
    /* loaded from: classes.dex */
    static abstract class AbstractRunnableC1061a implements Runnable {
        private AbstractRunnableC1061a() {
        }

        /* renamed from: a */
        public abstract void mo11264a();

        @Override // java.lang.Runnable
        public void run() {
            mo11264a();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", PdfBoolean.FALSE);
        }
    }

    public void get(final String str, final HttpClient.ProtoResultCallback protoResultCallback) {
        if (str == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }
        this.f4893c.submit(new AbstractRunnableC1061a() { // from class: com.baidu.mapapi.http.AsyncHttpClient.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.mapapi.http.AsyncHttpClient.AbstractRunnableC1061a
            /* renamed from: a */
            public void mo11264a() {
                HttpClient httpClient = new HttpClient("GET", protoResultCallback);
                httpClient.setMaxTimeOut(AsyncHttpClient.this.f4891a);
                httpClient.setReadTimeOut(AsyncHttpClient.this.f4892b);
                httpClient.request(str);
            }
        });
    }

    protected boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        return permissionCheck == 0 || permissionCheck == 602 || permissionCheck == 601;
    }
}
