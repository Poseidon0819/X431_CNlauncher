package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.ifoer.expedition.pro.R;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.p */
/* loaded from: classes.dex */
final class View$OnClickListenerC1779p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9457a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9458b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1779p(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9458b = handlerC1765a;
        this.f9457a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoloLightManager.m8495c();
        DealDiagMessageHandler.this.m8669a(this.f9457a.f9478id, R.string.tip_other_deny_your_request, this.f9457a.toJsonString(ExplainResult.REFUSE));
        DealDiagMessageHandler.this.f9430f.m8681c();
    }
}
