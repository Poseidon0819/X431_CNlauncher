package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.am */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4204am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4202ak f22548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4204am(C4202ak c4202ak) {
        this.f22548a = c4202ak;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4354a c4354a;
        C4354a c4354a2;
        c4343a = this.f22548a.f22544v;
        c4343a.m1018d();
        ((InputMethodManager) this.f22548a.f22593d.getSystemService("input_method")).hideSoftInputFromWindow(this.f22548a.getWindowToken(), 0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22548a.f22606q);
        sb.append("_open_user_protocol");
        C4202ak c4202ak = this.f22548a;
        c4354a = c4202ak.f22542t;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22548a.f22542t;
        c4202ak.m1420a(m984d, c4354a2.m985c());
    }
}
