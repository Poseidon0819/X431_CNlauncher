package com.unionpay;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* renamed from: com.unionpay.p */
/* loaded from: classes2.dex */
final class DialogInterface$OnClickListenerC4489p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC4487n f23516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4489p(View$OnClickListenerC4487n view$OnClickListenerC4487n) {
        this.f23516a = view$OnClickListenerC4487n;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.f23516a.f23514a.f22035d;
        alertDialog.dismiss();
    }
}
