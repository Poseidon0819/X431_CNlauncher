package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial;

/* compiled from: MoPubActivity.java */
/* renamed from: com.mopub.mobileads.l */
/* loaded from: classes.dex */
final class C3781l extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ CustomEventInterstitial.CustomEventInterstitialListener f20604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3781l(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        this.f20604a = customEventInterstitialListener;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ("mopub://finishLoad".equals(str)) {
            this.f20604a.onInterstitialLoaded();
            return true;
        } else if ("mopub://failLoad".equals(str)) {
            this.f20604a.onInterstitialFailed(null);
            return true;
        } else {
            return true;
        }
    }
}
