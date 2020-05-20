package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial;

/* compiled from: MraidActivity.java */
/* renamed from: com.mopub.mobileads.ad */
/* loaded from: classes.dex */
final class C3744ad extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ CustomEventInterstitial.CustomEventInterstitialListener f20506a;

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3744ad(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        this.f20506a = customEventInterstitialListener;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.f20506a.onInterstitialLoaded();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f20506a.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }
}
