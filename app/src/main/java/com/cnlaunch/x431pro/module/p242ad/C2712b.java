package com.cnlaunch.x431pro.module.p242ad;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: ADShowActivity.java */
/* renamed from: com.cnlaunch.x431pro.module.ad.b */
/* loaded from: classes.dex */
final class C2712b extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ ADShowActivity f15473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2712b(ADShowActivity aDShowActivity) {
        this.f15473a = aDShowActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f15473a.f15465c.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
    }
}
