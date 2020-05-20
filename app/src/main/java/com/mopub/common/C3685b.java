package com.mopub.common;

import com.mopub.common.UrlHandler;

/* compiled from: BrowserWebViewClient.java */
/* renamed from: com.mopub.common.b */
/* loaded from: classes.dex */
final class C3685b implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ BrowserWebViewClient f20114a;

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3685b(BrowserWebViewClient browserWebViewClient) {
        this.f20114a = browserWebViewClient;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        MoPubBrowser moPubBrowser;
        MoPubBrowser moPubBrowser2;
        if (urlAction.equals(UrlAction.OPEN_IN_APP_BROWSER)) {
            moPubBrowser2 = this.f20114a.f20113b;
            moPubBrowser2.getWebView().loadUrl(str);
            return;
        }
        moPubBrowser = this.f20114a.f20113b;
        moPubBrowser.finish();
    }
}
