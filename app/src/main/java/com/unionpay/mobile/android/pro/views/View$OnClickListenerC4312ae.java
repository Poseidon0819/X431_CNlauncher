package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.ae */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4312ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4338y f22924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4312ae(C4338y c4338y) {
        this.f22924a = c4338y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        Context context;
        String str;
        C4354a c4354a;
        C4354a c4354a2;
        c4343a = this.f22924a.f22988A;
        c4343a.m1018d();
        context = this.f22924a.f22593d;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.f22924a.getWindowToken(), 0);
        StringBuilder sb = new StringBuilder();
        str = this.f22924a.f22606q;
        sb.append(str);
        sb.append("_open_user_protocol");
        C4338y c4338y = this.f22924a;
        c4354a = c4338y.f23003x;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22924a.f23003x;
        c4338y.m1420a(m984d, c4354a2.m985c());
    }
}
