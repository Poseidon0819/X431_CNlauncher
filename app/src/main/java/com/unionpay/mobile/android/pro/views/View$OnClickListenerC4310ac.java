package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.nocard.utils.C4187c;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.ac */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4310ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4338y f22918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4310ac(C4338y c4338y) {
        this.f22918a = c4338y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        C4173b c4173b;
        C4173b c4173b2;
        C4173b c4173b3;
        C4173b c4173b4;
        context = this.f22918a.f22593d;
        c4173b = this.f22918a.f22590a;
        if (C4187c.m1481a(context, c4173b) == InterfaceC4414l.f23275c.intValue()) {
            this.f22918a.m1405m();
            this.f22918a.m1405m();
            return;
        }
        this.f22918a.m1405m();
        c4173b2 = this.f22918a.f22590a;
        if (c4173b2.f22384J) {
            this.f22918a.m1405m();
            c4173b4 = this.f22918a.f22590a;
            c4173b4.f22384J = false;
        }
        c4173b3 = this.f22918a.f22590a;
        c4173b3.f22415aP = InterfaceC4414l.f23275c.intValue();
        this.f22918a.m1411d(2);
    }
}
