package com.mopub.common;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.EnumSet;

/* renamed from: com.mopub.common.a */
/* loaded from: classes.dex */
final class BrowserWebViewClient extends WebViewClient {

    /* renamed from: a */
    private static final EnumSet<UrlAction> f20112a = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK);

    /* renamed from: b */
    private MoPubBrowser f20113b;

    public BrowserWebViewClient(MoPubBrowser moPubBrowser) {
        this.f20113b = moPubBrowser;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.m2498d("MoPubBrowser error: ".concat(String.valueOf(str)));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new UrlHandler.Builder().withSupportedUrlActions(f20112a).withoutMoPubBrowser().withResultActions(new C3685b(this)).build().handleResolvedUrl(this.f20113b.getApplicationContext(), str, true, null);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f20113b.getForwardButton().setImageDrawable(Drawables.UNRIGHT_ARROW.createDrawable(this.f20113b));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f20113b.getBackButton().setImageDrawable((webView.canGoBack() ? Drawables.LEFT_ARROW : Drawables.UNLEFT_ARROW).createDrawable(this.f20113b));
        this.f20113b.getForwardButton().setImageDrawable((webView.canGoForward() ? Drawables.RIGHT_ARROW : Drawables.UNRIGHT_ARROW).createDrawable(this.f20113b));
    }
}
