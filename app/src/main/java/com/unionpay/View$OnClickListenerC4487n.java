package com.unionpay;

import android.app.AlertDialog;
import android.view.View;
import com.unionpay.utils.C4653k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.n */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4487n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UPPayWapActivity f23514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4487n(UPPayWapActivity uPPayWapActivity) {
        this.f23514a = uPPayWapActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f23514a);
        this.f23514a.f22035d = builder.create();
        builder.setMessage(C4653k.m431a().f23762a);
        builder.setTitle(C4653k.m431a().f23765d);
        builder.setPositiveButton(C4653k.m431a().f23763b, new DialogInterface$OnClickListenerC4488o(this));
        builder.setNegativeButton(C4653k.m431a().f23764c, new DialogInterface$OnClickListenerC4489p(this));
        builder.create().show();
    }
}
