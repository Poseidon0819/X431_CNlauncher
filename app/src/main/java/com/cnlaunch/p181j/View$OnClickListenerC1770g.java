package com.cnlaunch.p181j;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.golo.others.OrderDialog;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.g */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1770g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DealDiagMessageHandler f9443a;

    public View$OnClickListenerC1770g(DealDiagMessageHandler dealDiagMessageHandler) {
        this.f9443a = dealDiagMessageHandler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Context context = this.f9443a.f9429e;
        str = this.f9443a.f9432h;
        new OrderDialog(context, str).show();
        this.f9443a.f9431g.dismiss();
    }
}
