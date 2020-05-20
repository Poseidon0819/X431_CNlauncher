package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.util.EnumSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mobileads.i */
/* loaded from: classes.dex */
public final class HtmlWebViewClient extends WebViewClient {

    /* renamed from: a */
    private final EnumSet<UrlAction> f20595a = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK);

    /* renamed from: b */
    private final Context f20596b;

    /* renamed from: c */
    private final String f20597c;

    /* renamed from: d */
    private HtmlWebViewListener f20598d;

    /* renamed from: e */
    private BaseHtmlWebView f20599e;

    /* renamed from: f */
    private final String f20600f;

    /* renamed from: g */
    private final String f20601g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlWebViewClient(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView baseHtmlWebView, String str, String str2, String str3) {
        this.f20598d = htmlWebViewListener;
        this.f20599e = baseHtmlWebView;
        this.f20600f = str;
        this.f20601g = str2;
        this.f20597c = str3;
        this.f20596b = baseHtmlWebView.getContext();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        new UrlHandler.Builder().withDspCreativeId(this.f20597c).withSupportedUrlActions(this.f20595a).withResultActions(new C3780k(this)).withMoPubSchemeListener(new C3779j(this)).build().handleUrl(this.f20596b, str, this.f20599e.wasClicked());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = this.f20601g;
        if (str2 == null || !str.startsWith(str2)) {
            return;
        }
        webView.stopLoading();
        if (this.f20599e.wasClicked()) {
            try {
                Intents.showMoPubBrowserForUrl(this.f20596b, Uri.parse(str), this.f20597c);
                return;
            } catch (IntentNotResolvableException e) {
                MoPubLog.m2498d(e.getMessage());
                return;
            }
        }
        MoPubLog.m2498d("Attempted to redirect without user interaction");
    }
}
