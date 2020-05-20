package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.k */
/* loaded from: classes.dex */
final class View$OnClickListenerC1774k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9448a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9449b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1774k(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9449b = handlerC1765a;
        this.f9448a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DealDiagMessageHandler.this.m8669a(this.f9448a.f9478id, R.string.canlce_remotediag, this.f9448a.toJsonString(ExplainResult.STOP));
        RemoteDiagObserve.m7939a(4);
        LoadDialog.m4681b(DealDiagMessageHandler.this.f9429e);
        DealDiagMessageHandler.this.f9430f.m8681c();
    }
}
