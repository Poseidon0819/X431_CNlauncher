package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.be */
/* loaded from: classes.dex */
public final class C3768be extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ VastIconConfig f20565a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f20566b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3768be(VastVideoViewController vastVideoViewController, VastIconConfig vastIconConfig) {
        this.f20566b = vastVideoViewController;
        this.f20565a = vastIconConfig;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        VastVideoConfig vastVideoConfig;
        VastIconConfig vastIconConfig = this.f20565a;
        Context context = this.f20566b.mContext;
        vastVideoConfig = this.f20566b.f20466j;
        vastIconConfig.handleClick(context, str, vastVideoConfig.getDspCreativeId());
        return true;
    }
}
