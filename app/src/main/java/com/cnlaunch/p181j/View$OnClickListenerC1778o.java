package com.cnlaunch.p181j;

import android.os.Bundle;
import android.view.View;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.o */
/* loaded from: classes.dex */
final class View$OnClickListenerC1778o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1778o(DealDiagMessageHandler.HandlerC1765a handlerC1765a) {
        this.f9456a = handlerC1765a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Bundle bundle;
        GoloLightManager.m8495c();
        bundle = DealDiagMessageHandler.this.f9427c;
        if (bundle != null) {
            DealDiagMessageHandler.this.f9434j.obtainMessage(9).sendToTarget();
        } else {
            DealDiagMessageHandler.this.m8663c();
        }
    }
}
