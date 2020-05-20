package com.mopub.mobileads;

import com.mopub.common.UrlHandler;

/* compiled from: HtmlWebViewClient.java */
/* renamed from: com.mopub.mobileads.j */
/* loaded from: classes.dex */
final class C3779j implements UrlHandler.MoPubSchemeListener {

    /* renamed from: a */
    final /* synthetic */ HtmlWebViewClient f20602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3779j(HtmlWebViewClient htmlWebViewClient) {
        this.f20602a = htmlWebViewClient;
    }

    @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
    public final void onFinishLoad() {
        HtmlWebViewListener htmlWebViewListener;
        BaseHtmlWebView baseHtmlWebView;
        htmlWebViewListener = this.f20602a.f20598d;
        baseHtmlWebView = this.f20602a.f20599e;
        htmlWebViewListener.onLoaded(baseHtmlWebView);
    }

    @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
    public final void onClose() {
        HtmlWebViewListener htmlWebViewListener;
        htmlWebViewListener = this.f20602a.f20598d;
        htmlWebViewListener.onCollapsed();
    }

    @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
    public final void onFailLoad() {
        HtmlWebViewListener htmlWebViewListener;
        htmlWebViewListener = this.f20602a.f20598d;
        htmlWebViewListener.onFailed(MoPubErrorCode.UNSPECIFIED);
    }
}
