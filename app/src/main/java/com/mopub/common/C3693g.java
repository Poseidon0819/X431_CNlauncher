package com.mopub.common;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: MoPubBrowser.java */
/* renamed from: com.mopub.common.g */
/* loaded from: classes.dex */
final class C3693g extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f20213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3693g(MoPubBrowser moPubBrowser) {
        this.f20213a = moPubBrowser;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        this.f20213a.setTitle("Loading...");
        this.f20213a.setProgress(i * 100);
        if (i == 100) {
            this.f20213a.setTitle(webView.getUrl());
        }
    }
}
