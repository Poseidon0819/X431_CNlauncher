package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.p071a.C0727a;
import com.alipay.sdk.p073c.C0748b;
import com.alipay.sdk.p074d.C0752a;

/* renamed from: com.alipay.sdk.app.b */
/* loaded from: classes.dex */
public final class C0729b extends WebViewClient {

    /* renamed from: a */
    boolean f3499a;

    /* renamed from: b */
    private Activity f3500b;

    /* renamed from: c */
    private boolean f3501c;

    /* renamed from: d */
    private Handler f3502d;

    /* renamed from: e */
    private C0752a f3503e;

    /* renamed from: f */
    private Runnable f3504f = new RunnableC0733f(this);

    public C0729b(Activity activity) {
        this.f3500b = activity;
        this.f3502d = new Handler(this.f3500b.getMainLooper());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f3499a = true;
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C0727a.m12556a("net", "SSLError", "证书错误");
        if (this.f3501c) {
            sslErrorHandler.proceed();
            this.f3501c = false;
            return;
        }
        this.f3500b.runOnUiThread(new RunnableC0730c(this, sslErrorHandler));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return C0748b.m12523a(webView, str, this.f3500b);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f3503e == null) {
            this.f3503e = new C0752a(this.f3500b, "正在加载");
        }
        this.f3503e.m12516a();
        this.f3502d.postDelayed(this.f3504f, 30000L);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        m12553a();
        this.f3502d.removeCallbacks(this.f3504f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12553a() {
        C0752a c0752a = this.f3503e;
        if (c0752a != null) {
            c0752a.m12513b();
        }
        this.f3503e = null;
    }
}
