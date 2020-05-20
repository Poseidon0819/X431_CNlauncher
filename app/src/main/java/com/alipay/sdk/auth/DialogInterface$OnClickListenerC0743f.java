package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* renamed from: com.alipay.sdk.auth.f */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC0743f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC0742e f3537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC0743f(RunnableC0742e runnableC0742e) {
        this.f3537a = runnableC0742e;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AuthActivity.this.f3525e = true;
        this.f3537a.f3535a.proceed();
        dialogInterface.dismiss();
    }
}
