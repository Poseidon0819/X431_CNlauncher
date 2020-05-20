package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.i */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4239i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4237g f22653a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4239i(C4237g c4237g) {
        this.f22653a = c4237g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4354a c4354a;
        C4354a c4354a2;
        c4343a = this.f22653a.f22647v;
        c4343a.m1018d();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22653a.f22606q);
        sb.append("_open_user_protocol");
        C4237g c4237g = this.f22653a;
        c4354a = c4237g.f22645t;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22653a.f22645t;
        c4237g.m1420a(m984d, c4354a2.m985c());
    }
}
