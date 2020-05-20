package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.v */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4254v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o f22716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4254v(C4245o c4245o) {
        this.f22716a = c4245o;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4343a c4343a2;
        C4354a c4354a;
        C4343a c4343a3;
        C4343a c4343a4;
        C4354a c4354a2;
        C4354a c4354a3;
        if (this.f22716a.m1404n()) {
            return;
        }
        c4343a = this.f22716a.f22690t;
        c4343a.m1018d();
        c4343a2 = this.f22716a.f22690t;
        C4343a.C4344a m1024b = c4343a2.m1024b();
        if (!m1024b.m1014a()) {
            this.f22716a.m1422a(m1024b.f23028b);
            return;
        }
        c4354a = this.f22716a.f22681C;
        if (c4354a != null) {
            c4354a2 = this.f22716a.f22681C;
            if (!c4354a2.m983e()) {
                C4245o c4245o = this.f22716a;
                c4354a3 = c4245o.f22681C;
                c4245o.m1422a(c4354a3.m986b());
                return;
            }
        }
        String str = "";
        c4343a3 = this.f22716a.f22682D;
        if (c4343a3 != null) {
            c4343a4 = this.f22716a.f22682D;
            C4343a.C4344a m1024b2 = c4343a4.m1024b();
            if (!m1024b2.m1014a()) {
                this.f22716a.m1422a(m1024b2.f23028b);
                return;
            }
            str = m1024b2.f23028b;
        }
        String str2 = m1024b.f23028b;
        if (C4245o.m1416b(str)) {
            str2 = str2 + "," + str;
        }
        this.f22716a.f22591b.m635a(C4171c.f22227bD.f22248U);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22716a.f22606q);
        sb.append("_apply");
        C4245o.m1359b(this.f22716a, str2);
    }
}
