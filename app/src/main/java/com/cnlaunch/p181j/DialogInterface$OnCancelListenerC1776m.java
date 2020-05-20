package com.cnlaunch.p181j;

import android.content.DialogInterface;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.m */
/* loaded from: classes.dex */
final class DialogInterface$OnCancelListenerC1776m implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9452a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC1776m(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9453b = handlerC1765a;
        this.f9452a = explainResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        DealDiagMessageHandler.this.f9434j.removeMessages(13);
        DealDiagMessageHandler.this.m8669a(this.f9452a.f9478id, R.string.canlce_remotediag, this.f9452a.toJsonString(ExplainResult.STOP));
        DealDiagMessageHandler.this.f9430f.m8681c();
    }
}
