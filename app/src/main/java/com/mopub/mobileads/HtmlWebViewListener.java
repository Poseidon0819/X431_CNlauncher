package com.mopub.mobileads;

/* loaded from: classes.dex */
public interface HtmlWebViewListener {
    void onClicked();

    void onCollapsed();

    void onFailed(MoPubErrorCode moPubErrorCode);

    void onLoaded(BaseHtmlWebView baseHtmlWebView);
}
