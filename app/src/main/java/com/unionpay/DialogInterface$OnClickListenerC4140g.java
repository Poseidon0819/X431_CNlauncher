package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.g */
/* loaded from: classes2.dex */
public final class DialogInterface$OnClickListenerC4140g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f22089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4140g(Context context) {
        this.f22089a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        UPPayAssistEx.m1676b(this.f22089a);
    }
}
