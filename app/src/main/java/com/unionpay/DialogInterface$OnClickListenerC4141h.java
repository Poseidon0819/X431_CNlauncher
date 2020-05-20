package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.h */
/* loaded from: classes2.dex */
public final class DialogInterface$OnClickListenerC4141h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f22090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4141h(Context context) {
        this.f22090a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        JSONArray jSONArray;
        Context context = this.f22090a;
        jSONArray = UPPayAssistEx.f22002W;
        UPPayAssistEx.m1683a(context, jSONArray, UPPayAssistEx.m1653r());
        dialogInterface.dismiss();
    }
}
