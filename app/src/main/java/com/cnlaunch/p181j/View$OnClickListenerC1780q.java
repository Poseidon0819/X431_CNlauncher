package com.cnlaunch.p181j;

import android.view.View;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.q */
/* loaded from: classes.dex */
final class View$OnClickListenerC1780q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9459a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9460b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1780q(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9460b = handlerC1765a;
        this.f9459a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GoloLightManager.m8495c();
        DealDiagMessageHandler.this.m8672a(1, this.f9459a);
    }
}
