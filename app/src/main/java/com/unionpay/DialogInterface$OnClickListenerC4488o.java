package com.unionpay;

import android.content.DialogInterface;

/* renamed from: com.unionpay.o */
/* loaded from: classes2.dex */
final class DialogInterface$OnClickListenerC4488o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC4487n f23515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4488o(View$OnClickListenerC4487n view$OnClickListenerC4487n) {
        this.f23515a = view$OnClickListenerC4487n;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        UPPayWapActivity.m1649a(this.f23515a.f23514a, "cancel", (String) null);
    }
}
