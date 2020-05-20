package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;
import com.unionpay.mobile.android.utils.C4389j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.h */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4238h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4237g f22652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4238h(C4237g c4237g) {
        this.f22652a = c4237g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4343a c4343a2;
        C4354a c4354a;
        boolean z;
        C4354a c4354a2;
        C4354a c4354a3;
        if (this.f22652a.m1404n()) {
            return;
        }
        c4343a = this.f22652a.f22647v;
        c4343a.m1018d();
        c4343a2 = this.f22652a.f22647v;
        C4343a.C4344a m1024b = c4343a2.m1024b();
        if (!m1024b.m1014a()) {
            this.f22652a.m1422a(m1024b.f23028b);
            return;
        }
        c4354a = this.f22652a.f22645t;
        if (c4354a != null) {
            c4354a2 = this.f22652a.f22645t;
            if (!c4354a2.m983e()) {
                C4237g c4237g = this.f22652a;
                c4354a3 = c4237g.f22645t;
                c4237g.m1422a(c4354a3.m986b());
                return;
            }
        }
        this.f22652a.f22591b.m635a(C4171c.f22227bD.f22248U);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22652a.f22606q);
        sb.append("_open_apply");
        z = this.f22652a.f22648w;
        if (z) {
            this.f22652a.m1380s();
            this.f22652a.f22644s = 104;
            return;
        }
        this.f22652a.f22594e.m1506c(C4389j.m846a(this.f22652a.f22590a.f22377C, "action"), m1024b.f23028b);
        this.f22652a.f22644s = 102;
    }
}
