package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* renamed from: com.alipay.sdk.auth.a */
/* loaded from: classes.dex */
final class C0738a implements DownloadListener {

    /* renamed from: a */
    final /* synthetic */ AuthActivity f3530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0738a(AuthActivity authActivity) {
        this.f3530a = authActivity;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.f3530a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
        }
    }
}
