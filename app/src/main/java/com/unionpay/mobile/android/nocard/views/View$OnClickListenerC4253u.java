package com.unionpay.mobile.android.nocard.views;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.u */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4253u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o f22715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4253u(C4245o c4245o) {
        this.f22715a = c4245o;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f22715a.f22684F = str;
        C4245o.m1364a(this.f22715a);
        this.f22715a.m1354d(str, "");
    }
}
