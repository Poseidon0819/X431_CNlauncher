package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.auth.AuthActivity;
import com.alipay.sdk.p074d.C0756d;

/* renamed from: com.alipay.sdk.auth.e */
/* loaded from: classes.dex */
final class RunnableC0742e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f3535a;

    /* renamed from: b */
    final /* synthetic */ AuthActivity.C0737b f3536b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0742e(AuthActivity.C0737b c0737b, SslErrorHandler sslErrorHandler) {
        this.f3536b = c0737b;
        this.f3535a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0756d.m12508a(AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface$OnClickListenerC0743f(this), "退出", new DialogInterface$OnClickListenerC0744g(this));
    }
}
