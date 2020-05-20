package com.mopub.mobileads.util;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;

/* compiled from: WebViews.java */
/* renamed from: com.mopub.mobileads.util.a */
/* loaded from: classes.dex */
final class C3795a extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2498d(str2);
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2498d(str2);
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        MoPubLog.m2498d(str2);
        jsPromptResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2498d(str2);
        jsResult.confirm();
        return true;
    }
}
