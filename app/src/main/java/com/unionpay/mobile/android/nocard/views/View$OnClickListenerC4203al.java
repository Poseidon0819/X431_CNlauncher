package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.al */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4203al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4202ak f22547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4203al(C4202ak c4202ak) {
        this.f22547a = c4202ak;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4343a c4343a2;
        C4354a c4354a;
        C4354a c4354a2;
        C4354a c4354a3;
        if (this.f22547a.m1404n()) {
            return;
        }
        c4343a = this.f22547a.f22544v;
        c4343a.m1018d();
        c4343a2 = this.f22547a.f22544v;
        C4343a.C4344a m1024b = c4343a2.m1024b();
        if (!m1024b.m1014a()) {
            this.f22547a.m1422a(m1024b.f23028b);
            return;
        }
        c4354a = this.f22547a.f22542t;
        if (c4354a != null) {
            c4354a2 = this.f22547a.f22542t;
            if (!c4354a2.m983e()) {
                C4202ak c4202ak = this.f22547a;
                c4354a3 = c4202ak.f22542t;
                c4202ak.m1422a(c4354a3.m986b());
                return;
            }
        }
        String str = m1024b.f23028b;
        this.f22547a.f22591b.m635a(C4171c.f22227bD.f22248U);
        this.f22547a.f22594e.m1492k(str);
        C4202ak.m1468c(this.f22547a);
    }
}
