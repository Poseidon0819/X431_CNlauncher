package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.f */
/* loaded from: classes2.dex */
public final class DialogInterface$OnClickListenerC4139f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f22088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4139f(Context context) {
        this.f22088a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        JSONArray jSONArray;
        Context context = this.f22088a;
        jSONArray = UPPayAssistEx.f22002W;
        UPPayAssistEx.m1683a(context, jSONArray, UPPayAssistEx.m1653r());
        dialogInterface.dismiss();
    }
}
