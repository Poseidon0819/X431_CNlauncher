package com.unionpay;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unionpay.utils.C4652j;

/* renamed from: com.unionpay.ab */
/* loaded from: classes2.dex */
final class C4123ab extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ WebViewJavascriptBridge f22053a;

    private C4123ab(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.f22053a = webViewJavascriptBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C4123ab(WebViewJavascriptBridge webViewJavascriptBridge, byte b) {
        this(webViewJavascriptBridge);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        C4652j.m433a("test", "onPageFinished");
    }
}
