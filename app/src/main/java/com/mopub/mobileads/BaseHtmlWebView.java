package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.network.Networking;

/* loaded from: classes.dex */
public class BaseHtmlWebView extends BaseWebView implements ViewGestureDetector.UserClickListener {

    /* renamed from: b */
    private final ViewGestureDetector f20303b;

    /* renamed from: c */
    private boolean f20304c;

    public BaseHtmlWebView(Context context, AdReport adReport) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        getSettings().setJavaScriptEnabled(true);
        this.f20303b = new ViewGestureDetector(context, this, adReport);
        this.f20303b.setUserClickListener(this);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            m2448a(true);
        }
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (str == null) {
            return;
        }
        MoPubLog.m2498d("Loading url: ".concat(String.valueOf(str)));
        if (str.startsWith("javascript:")) {
            super.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2452a(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://ads.mopub.com/", str, "text/html", "utf-8", null);
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public void onUserClick() {
        this.f20304c = true;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public void onResetUserClick() {
        this.f20304c = false;
    }

    @Override // com.mopub.mobileads.ViewGestureDetector.UserClickListener
    public boolean wasClicked() {
        return this.f20304c;
    }

    public void init(boolean z) {
        setOnTouchListener(new View$OnTouchListenerC3773d(this, z));
    }
}
