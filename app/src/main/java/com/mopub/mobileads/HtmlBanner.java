package com.mopub.mobileads;

/* loaded from: classes.dex */
public class HtmlBanner extends CustomEventBanner {

    /* renamed from: a */
    private HtmlBannerWebView f20329a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    public final void onInvalidate() {
        HtmlBannerWebView htmlBannerWebView = this.f20329a;
        if (htmlBannerWebView != null) {
            htmlBannerWebView.destroy();
        }
    }
}
