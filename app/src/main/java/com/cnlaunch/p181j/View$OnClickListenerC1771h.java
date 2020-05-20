package com.cnlaunch.p181j;

import android.view.View;

/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.h */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1771h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9444a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler f9445b;

    public View$OnClickListenerC1771h(DealDiagMessageHandler dealDiagMessageHandler, String str) {
        this.f9445b = dealDiagMessageHandler;
        this.f9444a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        DealDiagMessageHandler dealDiagMessageHandler = this.f9445b;
        str = dealDiagMessageHandler.f9432h;
        dealDiagMessageHandler.m8668a(str, this.f9444a);
        this.f9445b.f9431g.dismiss();
    }
}
