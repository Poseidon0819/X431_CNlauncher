package com.alipay.sdk.auth;

import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.alipay.sdk.auth.c */
/* loaded from: classes.dex */
public final class RunnableC0740c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3532a;

    /* renamed from: b */
    final /* synthetic */ AuthActivity f3533b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0740c(AuthActivity authActivity, String str) {
        this.f3533b = authActivity;
        this.f3532a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        try {
            webView = this.f3533b.f3521a;
            webView.loadUrl("javascript:" + this.f3532a);
        } catch (Exception unused) {
        }
    }
}
