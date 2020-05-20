package com.mopub.common;

import android.view.View;
import android.webkit.WebView;

/* compiled from: MoPubBrowser.java */
/* renamed from: com.mopub.common.i */
/* loaded from: classes.dex */
final class View$OnClickListenerC3695i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f20215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3695i(MoPubBrowser moPubBrowser) {
        this.f20215a = moPubBrowser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.f20215a.f20082a;
        if (webView.canGoForward()) {
            webView2 = this.f20215a.f20082a;
            webView2.goForward();
        }
    }
}
