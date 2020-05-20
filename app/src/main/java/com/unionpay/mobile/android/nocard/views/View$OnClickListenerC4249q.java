package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.upwidget.C4354a;

/* renamed from: com.unionpay.mobile.android.nocard.views.q */
/* loaded from: classes2.dex */
final class View$OnClickListenerC4249q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o f22710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4249q(C4245o c4245o) {
        this.f22710a = c4245o;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4354a c4354a;
        C4354a c4354a2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22710a.f22606q);
        sb.append("_open_user_protocol");
        C4245o c4245o = this.f22710a;
        c4354a = c4245o.f22681C;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22710a.f22681C;
        c4245o.m1420a(m984d, c4354a2.m985c());
    }
}
