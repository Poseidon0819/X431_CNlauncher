package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.r */
/* loaded from: classes.dex */
final class View$OnClickListenerC1781r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9461a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9462b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1781r(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9462b = handlerC1765a;
        this.f9461a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoloLightManager.m8495c();
        DealDiagMessageHandler.this.m8669a(this.f9461a.f9478id, R.string.tip_other_deny_your_request, this.f9461a.toJsonString(ExplainResult.REFUSE));
        DealDiagMessageHandler.this.f9430f.m8681c();
    }
}
