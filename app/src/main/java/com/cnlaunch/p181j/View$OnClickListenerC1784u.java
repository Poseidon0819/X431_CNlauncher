package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.u */
/* loaded from: classes.dex */
final class View$OnClickListenerC1784u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9465a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9466b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1784u(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9466b = handlerC1765a;
        this.f9465a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DealDiagMessageHandler.this.f9434j.removeMessages(13);
        DealDiagMessageHandler.this.m8669a(this.f9465a.f9478id, R.string.canlce_remotediag, this.f9465a.toJsonString(ExplainResult.STOP));
        RemoteDiagObserve.m7939a(4);
        DealDiagMessageHandler.this.f9430f.m8681c();
    }
}
