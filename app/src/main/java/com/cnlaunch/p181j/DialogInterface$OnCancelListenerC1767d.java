package com.cnlaunch.p181j;

import android.content.DialogInterface;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.d */
/* loaded from: classes.dex */
public final class DialogInterface$OnCancelListenerC1767d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ String f9437a;

    /* renamed from: b */
    final /* synthetic */ ExplainResult f9438b;

    /* renamed from: c */
    final /* synthetic */ DealDiagMessageHandler f9439c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC1767d(DealDiagMessageHandler dealDiagMessageHandler, String str, ExplainResult explainResult) {
        this.f9439c = dealDiagMessageHandler;
        this.f9437a = str;
        this.f9438b = explainResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f9439c.f9434j.removeMessages(11);
        this.f9439c.m8669a(this.f9437a, R.string.canlce_remotediag, this.f9438b.toJsonString(ExplainResult.STOP));
        this.f9439c.f9430f.m8681c();
    }
}
