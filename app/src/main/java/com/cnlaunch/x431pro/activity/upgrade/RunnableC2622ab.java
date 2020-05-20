package com.cnlaunch.x431pro.activity.upgrade;

import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradeDetailActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ab */
/* loaded from: classes.dex */
public final class RunnableC2622ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f15065a;

    /* renamed from: b */
    final /* synthetic */ UpgradeDetailActivity f15066b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2622ab(UpgradeDetailActivity upgradeDetailActivity, String str) {
        this.f15066b = upgradeDetailActivity;
        this.f15065a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        webView = this.f15066b.f14979C;
        webView.loadUrl(this.f15065a);
    }
}
