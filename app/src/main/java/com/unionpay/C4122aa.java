package com.unionpay;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/* renamed from: com.unionpay.aa */
/* loaded from: classes2.dex */
final class C4122aa extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ WebViewJavascriptBridge f22052a;

    private C4122aa(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.f22052a = webViewJavascriptBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C4122aa(WebViewJavascriptBridge webViewJavascriptBridge, byte b) {
        this(webViewJavascriptBridge);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.cancel();
        Toast.makeText(this.f22052a.mContext, str2, 0).show();
        return true;
    }
}
