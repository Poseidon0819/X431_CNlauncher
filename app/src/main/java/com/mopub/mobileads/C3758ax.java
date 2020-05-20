package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.ax */
/* loaded from: classes.dex */
public final class C3758ax extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ VastCompanionAdConfig f20548a;

    /* renamed from: b */
    final /* synthetic */ Context f20549b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f20550c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3758ax(VastVideoViewController vastVideoViewController, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f20550c = vastVideoViewController;
        this.f20548a = vastCompanionAdConfig;
        this.f20549b = context;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        VastVideoConfig vastVideoConfig;
        VastCompanionAdConfig vastCompanionAdConfig = this.f20548a;
        Context context = this.f20549b;
        vastVideoConfig = this.f20550c.f20466j;
        vastCompanionAdConfig.handleClick(context, 1, str, vastVideoConfig.getDspCreativeId());
        return true;
    }
}
