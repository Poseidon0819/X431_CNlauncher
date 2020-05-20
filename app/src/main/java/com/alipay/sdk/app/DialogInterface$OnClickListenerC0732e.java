package com.alipay.sdk.app;

import android.app.Activity;
import android.content.DialogInterface;

/* renamed from: com.alipay.sdk.app.e */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC0732e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RunnableC0730c f3508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC0732e(RunnableC0730c runnableC0730c) {
        this.f3508a = runnableC0730c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Activity activity;
        this.f3508a.f3505a.cancel();
        this.f3508a.f3506b.f3501c = false;
        C0734g.f3510a = C0734g.m12549a();
        activity = this.f3508a.f3506b.f3500b;
        activity.finish();
    }
}
