package com.cnlaunch.p181j;

import android.os.Message;
import android.view.View;
import com.cnlaunch.p181j.DealDiagMessageHandler;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.n */
/* loaded from: classes.dex */
final class View$OnClickListenerC1777n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9454a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler.HandlerC1765a f9455b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1777n(DealDiagMessageHandler.HandlerC1765a handlerC1765a, ExplainResult explainResult) {
        this.f9455b = handlerC1765a;
        this.f9454a = explainResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = this.f9454a;
        DealDiagMessageHandler.this.f9434j.sendMessageDelayed(obtain, 120000L);
    }
}
