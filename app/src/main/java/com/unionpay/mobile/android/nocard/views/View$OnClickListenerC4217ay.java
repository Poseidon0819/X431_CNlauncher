package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.ay */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4217ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4212at f22588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4217ay(C4212at c4212at) {
        this.f22588a = c4212at;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        C4354a c4354a;
        C4354a c4354a2;
        c4343a = this.f22588a.f22566B;
        c4343a.m1018d();
        ((InputMethodManager) this.f22588a.f22593d.getSystemService("input_method")).hideSoftInputFromWindow(this.f22588a.getWindowToken(), 0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22588a.f22606q);
        sb.append("_open_user_protocol");
        C4212at c4212at = this.f22588a;
        c4354a = c4212at.f22582y;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22588a.f22582y;
        c4212at.m1420a(m984d, c4354a2.m985c());
    }
}
