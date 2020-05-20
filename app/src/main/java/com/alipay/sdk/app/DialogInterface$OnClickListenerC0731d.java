package com.alipay.sdk.app;

import android.content.DialogInterface;

/* renamed from: com.alipay.sdk.app.d */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC0731d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC0730c f3507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC0731d(RunnableC0730c runnableC0730c) {
        this.f3507a = runnableC0730c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f3507a.f3506b.f3501c = true;
        this.f3507a.f3505a.proceed();
        dialogInterface.dismiss();
    }
}
