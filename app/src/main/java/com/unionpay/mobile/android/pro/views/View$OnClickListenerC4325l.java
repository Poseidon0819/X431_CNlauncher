package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.widgets.C4471m;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.l */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4325l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22974a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4325l(C4324k c4324k) {
        this.f22974a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n;
        C4343a c4343a;
        C4354a c4354a;
        C4354a c4354a2;
        C4173b c4173b;
        C4343a c4343a2;
        String str;
        C4471m c4471m;
        C4343a c4343a3;
        HashMap m1107t;
        C4354a c4354a3;
        C4354a c4354a4;
        C4354a c4354a5;
        C4354a c4354a6;
        Context unused;
        n = this.f22974a.m1404n();
        if (n) {
            return;
        }
        c4343a = this.f22974a.f22972y;
        c4343a.m1018d();
        c4354a = this.f22974a.f22949L;
        if (c4354a != null) {
            c4354a5 = this.f22974a.f22949L;
            if (!c4354a5.m983e()) {
                C4324k c4324k = this.f22974a;
                c4354a6 = c4324k.f22949L;
                c4324k.m1422a(c4354a6.m986b());
                return;
            }
        }
        c4354a2 = this.f22974a.f22948K;
        if (c4354a2 != null) {
            c4354a3 = this.f22974a.f22948K;
            if (!c4354a3.m983e()) {
                C4324k c4324k2 = this.f22974a;
                c4354a4 = c4324k2.f22948K;
                c4324k2.m1422a(c4354a4.m986b());
                return;
            }
        }
        c4173b = this.f22974a.f22590a;
        if (c4173b.f22480p != null) {
            c4343a2 = this.f22974a.f22972y;
            C4343a.C4344a m1035a = c4343a2.m1035a();
            if (!m1035a.m1014a()) {
                this.f22974a.m1422a(m1035a.f23028b);
                return;
            }
            unused = this.f22974a.f22593d;
            StringBuilder sb = new StringBuilder();
            str = this.f22974a.f22606q;
            sb.append(str);
            sb.append("_apply");
            c4471m = this.f22974a.f22591b;
            c4471m.m635a(C4171c.f22227bD.f22248U);
            C4324k.m1119i(this.f22974a);
            C4324k c4324k3 = this.f22974a;
            c4343a3 = c4324k3.f22972y;
            String str2 = c4343a3.m1035a().f23028b;
            m1107t = this.f22974a.m1107t();
            c4324k3.m1133b(str2, m1107t);
        }
    }
}
