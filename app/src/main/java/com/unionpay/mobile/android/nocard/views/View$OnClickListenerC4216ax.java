package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.nocard.utils.C4187c;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* renamed from: com.unionpay.mobile.android.nocard.views.ax */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4216ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4212at f22587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4216ax(C4212at c4212at) {
        this.f22587a = c4212at;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C4187c.m1481a(this.f22587a.f22593d, this.f22587a.f22590a) == InterfaceC4414l.f23275c.intValue()) {
            this.f22587a.m1405m();
            this.f22587a.m1405m();
            return;
        }
        this.f22587a.m1405m();
        if (this.f22587a.f22590a.f22384J) {
            this.f22587a.m1405m();
            this.f22587a.f22590a.f22384J = false;
        }
        this.f22587a.f22590a.f22415aP = InterfaceC4414l.f23275c.intValue();
        this.f22587a.m1411d(2);
    }
}
