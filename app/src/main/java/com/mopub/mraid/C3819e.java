package com.mopub.mraid;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.logging.MoPubLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.e */
/* loaded from: classes.dex */
public final class C3819e extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f20714a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3819e(MraidBridge mraidBridge) {
        this.f20714a = mraidBridge;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.m2498d("Error: ".concat(String.valueOf(str)));
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f20714a.m2259b(str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        MraidBridge.m2258c(this.f20714a);
    }
}
