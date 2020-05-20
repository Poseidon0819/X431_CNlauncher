package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.widgets.C4471m;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.z */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4339z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4338y f23006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4339z(C4338y c4338y) {
        this.f23006a = c4338y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n;
        C4343a c4343a;
        C4343a c4343a2;
        C4354a c4354a;
        C4354a c4354a2;
        C4471m c4471m;
        String str;
        C4173b c4173b;
        C4173b c4173b2;
        C4173b c4173b3;
        C4343a c4343a3;
        C4173b c4173b4;
        C4343a c4343a4;
        C4354a c4354a3;
        C4354a c4354a4;
        C4354a c4354a5;
        C4354a c4354a6;
        n = this.f23006a.m1404n();
        if (n) {
            return;
        }
        c4343a = this.f23006a.f22988A;
        c4343a.m1018d();
        c4343a2 = this.f23006a.f22988A;
        C4343a.C4344a m1035a = c4343a2.m1035a();
        if (!m1035a.m1014a()) {
            this.f23006a.m1422a(m1035a.f23028b);
            return;
        }
        c4354a = this.f23006a.f23003x;
        if (c4354a != null) {
            c4354a5 = this.f23006a.f23003x;
            if (!c4354a5.m983e()) {
                C4338y c4338y = this.f23006a;
                c4354a6 = c4338y.f23003x;
                c4338y.m1422a(c4354a6.m986b());
                return;
            }
        }
        c4354a2 = this.f23006a.f23002w;
        if (c4354a2 != null) {
            c4354a3 = this.f23006a.f23002w;
            if (!c4354a3.m983e()) {
                C4338y c4338y2 = this.f23006a;
                c4354a4 = c4338y2.f23002w;
                c4338y2.m1422a(c4354a4.m986b());
                return;
            }
        }
        c4471m = this.f23006a.f22591b;
        c4471m.m635a(C4171c.f22227bD.f22248U);
        StringBuilder sb = new StringBuilder();
        str = this.f23006a.f22606q;
        sb.append(str);
        sb.append("_apply");
        c4173b = this.f23006a.f22590a;
        if (c4173b.f22464br) {
            C4338y c4338y3 = this.f23006a;
            c4173b4 = c4338y3.f22590a;
            InterfaceC4174c interfaceC4174c = c4173b4.f22465bs;
            c4343a4 = this.f23006a.f22988A;
            C4338y.m1081a(c4338y3, interfaceC4174c, c4343a4.m1035a().f23028b, C4338y.m1058i(this.f23006a));
            return;
        }
        C4338y c4338y4 = this.f23006a;
        c4173b2 = c4338y4.f22590a;
        List<InterfaceC4174c> list = c4173b2.f22481q;
        c4173b3 = this.f23006a.f22590a;
        c4343a3 = this.f23006a.f22988A;
        C4338y.m1081a(c4338y4, list.get(c4173b3.f22388N), c4343a3.m1035a().f23028b, C4338y.m1058i(this.f23006a));
    }
}
