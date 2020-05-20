package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.upwidget.C4354a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.r */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4331r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4331r(C4324k c4324k) {
        this.f22981a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4343a c4343a;
        Context context;
        String str;
        C4354a c4354a;
        C4354a c4354a2;
        Context unused;
        c4343a = this.f22981a.f22972y;
        c4343a.m1018d();
        context = this.f22981a.f22593d;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.f22981a.getWindowToken(), 0);
        unused = this.f22981a.f22593d;
        StringBuilder sb = new StringBuilder();
        str = this.f22981a.f22606q;
        sb.append(str);
        sb.append("_open_user_protocol");
        C4324k c4324k = this.f22981a;
        c4354a = c4324k.f22949L;
        String m984d = c4354a.m984d();
        c4354a2 = this.f22981a.f22949L;
        c4324k.m1420a(m984d, c4354a2.m985c());
    }
}
