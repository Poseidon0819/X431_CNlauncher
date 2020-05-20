package com.alipay.sdk.p073c;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* renamed from: com.alipay.sdk.c.c */
/* loaded from: classes.dex */
final class C0750c implements DownloadListener {

    /* renamed from: a */
    final /* synthetic */ Activity f3545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0750c(Activity activity) {
        this.f3545a = activity;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f3545a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
        }
    }
}
