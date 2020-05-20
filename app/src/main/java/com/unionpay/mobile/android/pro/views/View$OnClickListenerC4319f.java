package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.widgets.C4471m;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.f */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4319f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4307a f22931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4319f(C4307a c4307a) {
        this.f22931a = c4307a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n;
        C4343a c4343a;
        boolean z;
        C4173b c4173b;
        C4343a c4343a2;
        String str;
        C4471m c4471m;
        C4173b c4173b2;
        Context unused;
        n = this.f22931a.m1404n();
        if (n) {
            return;
        }
        c4343a = this.f22931a.f22913x;
        c4343a.m1018d();
        z = this.f22931a.f22899F;
        if (z) {
            C4307a.m1170p(this.f22931a);
            return;
        }
        c4173b = this.f22931a.f22590a;
        if (c4173b.f22480p != null) {
            c4343a2 = this.f22931a.f22913x;
            C4343a.C4344a m1035a = c4343a2.m1035a();
            if (!m1035a.m1014a()) {
                this.f22931a.m1422a(m1035a.f23028b);
                return;
            }
            unused = this.f22931a.f22593d;
            StringBuilder sb = new StringBuilder();
            str = this.f22931a.f22606q;
            sb.append(str);
            sb.append("_apply");
            c4471m = this.f22931a.f22591b;
            c4471m.m635a(C4171c.f22227bD.f22248U);
            C4307a.m1163u(this.f22931a);
            C4307a c4307a = this.f22931a;
            c4173b2 = c4307a.f22590a;
            c4307a.m1197a(c4173b2.f22480p);
        }
    }
}
