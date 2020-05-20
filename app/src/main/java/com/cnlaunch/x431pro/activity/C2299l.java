package com.cnlaunch.x431pro.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseWebFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.l */
/* loaded from: classes.dex */
public final class C2299l extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ BaseWebFragment f12975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2299l(BaseWebFragment baseWebFragment) {
        this.f12975a = baseWebFragment;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f12975a.f12970b.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
    }
}
