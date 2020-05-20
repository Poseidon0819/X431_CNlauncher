package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.au */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4213au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4212at f22584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4213au(C4212at c4212at) {
        this.f22584a = c4212at;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4343a c4343a2;
        C4343a c4343a3;
        C4354a c4354a;
        C4354a c4354a2;
        boolean z;
        C4354a c4354a3;
        C4354a c4354a4;
        C4354a c4354a5;
        C4354a c4354a6;
        C4343a c4343a4;
        C4343a c4343a5;
        if (this.f22584a.m1404n()) {
            return;
        }
        String str = "";
        c4343a = this.f22584a.f22565A;
        if (c4343a != null) {
            c4343a4 = this.f22584a.f22565A;
            c4343a4.m1018d();
            c4343a5 = this.f22584a.f22565A;
            C4343a.C4344a m1024b = c4343a5.m1024b();
            if (!m1024b.m1014a()) {
                this.f22584a.m1422a(m1024b.f23028b);
                return;
            }
            str = m1024b.f23028b;
        }
        c4343a2 = this.f22584a.f22566B;
        c4343a2.m1018d();
        c4343a3 = this.f22584a.f22566B;
        C4343a.C4344a m1024b2 = c4343a3.m1024b();
        if (!m1024b2.m1014a()) {
            this.f22584a.m1422a(m1024b2.f23028b);
            return;
        }
        c4354a = this.f22584a.f22582y;
        if (c4354a != null) {
            c4354a5 = this.f22584a.f22582y;
            if (!c4354a5.m983e()) {
                C4212at c4212at = this.f22584a;
                c4354a6 = c4212at.f22582y;
                c4212at.m1422a(c4354a6.m986b());
                return;
            }
        }
        c4354a2 = this.f22584a.f22581x;
        if (c4354a2 != null) {
            c4354a3 = this.f22584a.f22581x;
            if (!c4354a3.m983e()) {
                C4212at c4212at2 = this.f22584a;
                c4354a4 = c4212at2.f22581x;
                c4212at2.m1422a(c4354a4.m986b());
                return;
            }
        }
        String str2 = m1024b2.f23028b;
        if (C4212at.m1416b(str)) {
            str2 = str2 + "," + str;
        }
        this.f22584a.f22591b.m635a(C4171c.f22227bD.f22248U);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22584a.f22606q);
        sb.append("_apply");
        if (this.f22584a.f22590a.f22379E == null || this.f22584a.f22590a.f22379E.length() <= 0) {
            this.f22584a.m1436e(str2);
            return;
        }
        C4212at c4212at3 = this.f22584a;
        z = c4212at3.f22567C;
        C4212at.m1446a(c4212at3, z, str2);
    }
}
