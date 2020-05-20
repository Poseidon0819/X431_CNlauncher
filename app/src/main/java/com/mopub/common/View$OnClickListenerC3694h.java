package com.mopub.common;

import android.view.View;
import android.webkit.WebView;

/* compiled from: MoPubBrowser.java */
/* renamed from: com.mopub.common.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC3694h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f20214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3694h(MoPubBrowser moPubBrowser) {
        this.f20214a = moPubBrowser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f20214a.f20082a;
        if (webView.canGoBack()) {
            webView2 = this.f20214a.f20082a;
            webView2.goBack();
        }
    }
}
