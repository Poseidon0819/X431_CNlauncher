package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* renamed from: com.alipay.sdk.auth.g */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC0744g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC0742e f3538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC0744g(RunnableC0742e runnableC0742e) {
        this.f3538a = runnableC0742e;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String str;
        this.f3538a.f3535a.cancel();
        AuthActivity.this.f3525e = false;
        StringBuilder sb = new StringBuilder();
        str = AuthActivity.this.f3522b;
        sb.append(str);
        sb.append("?resultCode=150");
        C0745h.m12531a(AuthActivity.this, sb.toString());
        AuthActivity.this.finish();
    }
}
