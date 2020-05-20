package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.views.order.CViewMethods;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.views.order.h */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4410h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f23263a;

    /* renamed from: b */
    final /* synthetic */ CViewMethods f23264b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4410h(CViewMethods cViewMethods, int i) {
        this.f23264b = cViewMethods;
        this.f23263a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CViewMethods.InterfaceC4400a interfaceC4400a;
        CViewMethods.InterfaceC4400a interfaceC4400a2;
        C4390k.m836c("uppay", " touched " + this.f23263a);
        interfaceC4400a = this.f23264b.f23229j;
        if (interfaceC4400a != null) {
            interfaceC4400a2 = this.f23264b.f23229j;
            interfaceC4400a2.mo807c(this.f23263a);
        }
    }
}
