package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;
import com.alipay.sdk.p074d.C0756d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.alipay.sdk.app.c */
/* loaded from: classes.dex */
public final class RunnableC0730c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f3505a;

    /* renamed from: b */
    final /* synthetic */ C0729b f3506b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0730c(C0729b c0729b, SslErrorHandler sslErrorHandler) {
        this.f3506b = c0729b;
        this.f3505a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.f3506b.f3500b;
        C0756d.m12508a(activity, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface$OnClickListenerC0731d(this), "退出", new DialogInterface$OnClickListenerC0732e(this));
    }
}
