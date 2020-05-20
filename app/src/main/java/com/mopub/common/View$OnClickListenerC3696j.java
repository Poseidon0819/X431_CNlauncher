package com.mopub.common;

import android.view.View;
import android.webkit.WebView;

/* compiled from: MoPubBrowser.java */
/* renamed from: com.mopub.common.j */
/* loaded from: classes.dex */
final class View$OnClickListenerC3696j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f20216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3696j(MoPubBrowser moPubBrowser) {
        this.f20216a = moPubBrowser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        webView = this.f20216a.f20082a;
        webView.reload();
    }
}
