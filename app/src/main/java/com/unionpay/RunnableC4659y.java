package com.unionpay;

/* renamed from: com.unionpay.y */
/* loaded from: classes2.dex */
final class RunnableC4659y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f23774a;

    /* renamed from: b */
    final /* synthetic */ WebViewJavascriptBridge f23775b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4659y(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.f23775b = webViewJavascriptBridge;
        this.f23774a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23775b.mWebView.loadUrl(this.f23774a);
    }
}
