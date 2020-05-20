package com.mopub.mobileads;

import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

/* compiled from: HtmlWebViewClient.java */
/* renamed from: com.mopub.mobileads.k */
/* loaded from: classes.dex */
final class C3780k implements UrlHandler.ResultActions {

    /* renamed from: a */
    final /* synthetic */ HtmlWebViewClient f20603a;

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingFailed(String str, UrlAction urlAction) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3780k(HtmlWebViewClient htmlWebViewClient) {
        this.f20603a = htmlWebViewClient;
    }

    @Override // com.mopub.common.UrlHandler.ResultActions
    public final void urlHandlingSucceeded(String str, UrlAction urlAction) {
        BaseHtmlWebView baseHtmlWebView;
        HtmlWebViewListener htmlWebViewListener;
        BaseHtmlWebView baseHtmlWebView2;
        baseHtmlWebView = this.f20603a.f20599e;
        if (baseHtmlWebView.wasClicked()) {
            htmlWebViewListener = this.f20603a.f20598d;
            htmlWebViewListener.onClicked();
            baseHtmlWebView2 = this.f20603a.f20599e;
            baseHtmlWebView2.onResetUserClick();
        }
    }
}
