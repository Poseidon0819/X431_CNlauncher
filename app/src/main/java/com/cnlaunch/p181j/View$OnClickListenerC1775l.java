package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.p181j.DealDiagMessageHandler;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.l */
/* loaded from: classes.dex */
final class View$OnClickListenerC1775l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9450a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9451b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1775l(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9451b = handlerC1765a;
        this.f9450a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DealDiagMessageHandler.this.f9434j.obtainMessage(14, this.f9450a).sendToTarget();
    }
}
