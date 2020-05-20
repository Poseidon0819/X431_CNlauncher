package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.nocard.utils.C4187c;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.e */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4318e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4307a f22930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4318e(C4307a c4307a) {
        this.f22930a = c4307a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        C4173b c4173b;
        C4173b c4173b2;
        context = this.f22930a.f22593d;
        c4173b = this.f22930a.f22590a;
        int m1481a = C4187c.m1481a(context, c4173b);
        this.f22930a.m1405m();
        this.f22930a.m1405m();
        if (m1481a != InterfaceC4414l.f23275c.intValue()) {
            c4173b2 = this.f22930a.f22590a;
            c4173b2.f22415aP = InterfaceC4414l.f23275c.intValue();
            this.f22930a.m1411d(2);
        }
    }
}
