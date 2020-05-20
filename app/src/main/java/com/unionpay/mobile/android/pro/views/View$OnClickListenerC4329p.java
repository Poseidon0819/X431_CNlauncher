package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.nocard.utils.C4187c;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.p */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4329p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4329p(C4324k c4324k) {
        this.f22979a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        C4173b c4173b;
        C4173b c4173b2;
        C4173b c4173b3;
        C4173b c4173b4;
        context = this.f22979a.f22593d;
        c4173b = this.f22979a.f22590a;
        if (C4187c.m1481a(context, c4173b) == InterfaceC4414l.f23275c.intValue()) {
            this.f22979a.m1405m();
            this.f22979a.m1405m();
            return;
        }
        this.f22979a.m1405m();
        c4173b2 = this.f22979a.f22590a;
        if (c4173b2.f22384J) {
            this.f22979a.m1405m();
            c4173b4 = this.f22979a.f22590a;
            c4173b4.f22384J = false;
        }
        c4173b3 = this.f22979a.f22590a;
        c4173b3.f22415aP = InterfaceC4414l.f23275c.intValue();
        this.f22979a.m1411d(2);
    }
}
