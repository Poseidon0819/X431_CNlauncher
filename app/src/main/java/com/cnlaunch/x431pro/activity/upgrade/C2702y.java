package com.cnlaunch.x431pro.activity.upgrade;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: UpgradeDetailActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.y */
/* loaded from: classes.dex */
final class C2702y extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ UpgradeDetailActivity f15432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2702y(UpgradeDetailActivity upgradeDetailActivity) {
        this.f15432a = upgradeDetailActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f15432a.f14985I.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
    }
}
